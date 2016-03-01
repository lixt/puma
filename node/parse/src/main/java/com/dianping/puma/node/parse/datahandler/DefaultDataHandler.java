/**
 * Project: ${puma-datahandler.aid}
 * <p/>
 * File Created at 2012-6-25
 * $Id$
 * <p/>
 * Copyright 2010 dianping.com.
 * All rights reserved.
 * <p/>
 * This software is the confidential and proprietary information of
 * Dianping Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with dianping.com.
 */
package com.dianping.puma.node.parse.datahandler;

import com.dianping.cat.Cat;
import com.dianping.puma.common.mysql.BinlogConstants;
import com.dianping.puma.common.mysql.column.Column;
import com.dianping.puma.common.mysql.event.*;
import com.dianping.puma.core.event.ChangedEvent;
import com.dianping.puma.core.event.RowChangedEvent;
import com.dianping.puma.core.event.RowChangedEvent.ColumnInfo;
import com.dianping.puma.core.util.sql.DMLType;
import com.dianping.puma.node.parse.meta.Meta;
import com.google.common.collect.MapMaker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leo Liang
 */
public class DefaultDataHandler extends AbstractDataHandler {
    private Logger log = Logger.getLogger(DefaultDataHandler.class);

    private Map<Long, Meta> tableIdMetaMap;

    private int rowPos = 0;

    @Override
    protected void doProcess(DataHandlerResult result, BinlogEvent binlogEvent, byte eventType) {
        if (log.isDebugEnabled()) {
            log.debug("event:" + eventType);
        }
        switch (eventType) {
            case BinlogConstants.TABLE_MAP_EVENT:
                TableMapEvent tableMapEvent = (TableMapEvent) binlogEvent;

                if (tableIdMetaMap == null) {
                    tableIdMetaMap = new MapMaker().makeMap();
                }

                Meta meta = getMetaFetcher().getMeta(tableMapEvent.getDatabaseName(), tableMapEvent.getTableName());

                if (meta != null) {
                    tableIdMetaMap.put(tableMapEvent.getTableId(), meta);
                } else {
                    skipEvent(result);
                    return;
                }

                fillRawTypeCodes(tableMapEvent, meta);
                fillRawNullAbilities(tableMapEvent, meta);
                rowPos = 0;
                result.setEmpty(true);
                result.setFinished(true);
                break;
            case BinlogConstants.WRITE_ROWS_EVENT_V1:
            case BinlogConstants.WRITE_ROWS_EVENT:
                if (tableIdMetaMap == null || tableIdMetaMap.isEmpty()) {
                    skipEvent(result);
                    return;
                }

                processWriteRowEvent(result, binlogEvent);
                break;
            case BinlogConstants.UPDATE_ROWS_EVENT_V1:
            case BinlogConstants.UPDATE_ROWS_EVENT:
                if (tableIdMetaMap == null || tableIdMetaMap.isEmpty()) {
                    skipEvent(result);
                    return;
                }
                processUpdateRowEvent(result, binlogEvent);
                break;
            case BinlogConstants.DELETE_ROWS_EVENT_V1:
            case BinlogConstants.DELETE_ROWS_EVENT:
                if (tableIdMetaMap == null || tableIdMetaMap.isEmpty()) {
                    skipEvent(result);
                    return;
                }
                processDeleteRowEvent(result, binlogEvent);
                break;
            case BinlogConstants.XID_EVENT:
                if (tableIdMetaMap == null || tableIdMetaMap.isEmpty()) {
                    skipEvent(result);
                    return;
                }
                processTransactionCommitEvent(binlogEvent, result);
                break;
            default:
                result.setEmpty(true);
                result.setFinished(true);
                break;
        }

    }

    protected void processTransactionCommitEvent(BinlogEvent binlogEvent, DataHandlerResult result) {
        // commit事件，发送一个commit transaction的事件
        ChangedEvent dataChangedEvent = new RowChangedEvent();
        ((RowChangedEvent) dataChangedEvent).setTransactionCommit(true);
        dataChangedEvent.setExecuteTime(binlogEvent.getHeader().getTimestamp());
        dataChangedEvent.setDatabase(tableIdMetaMap.values().iterator().next().getDatabase());

        result.setData(dataChangedEvent);
        result.setEmpty(false);
        result.setFinished(true);
        tableIdMetaMap.clear();
        tableIdMetaMap = null;
    }

    /**
     * @param result
     * @param binlogEvent
     */
    protected void processDeleteRowEvent(DataHandlerResult result, BinlogEvent binlogEvent) {
        DeleteRowsEvent deleteRowsEvent = (DeleteRowsEvent) binlogEvent;

        if (rowPos >= deleteRowsEvent.getRows().size()) {
            rowPos = 0;
            result.setEmpty(true);
            result.setFinished(true);
        } else {
            Meta meta = tableIdMetaMap.get(deleteRowsEvent.getTableId());

            if (meta == null) {
                skipEvent(result);
                return;
            }

            RowChangedEvent rowChangedEvent = new RowChangedEvent();
            Map<String, ColumnInfo> columns = initColumns(deleteRowsEvent, rowChangedEvent, DMLType.DELETE,
                    meta);

            for (int columnPos = 0, columnIndex = 0; columnPos < deleteRowsEvent.getColumnCount().intValue(); columnPos++) {
                if (deleteRowsEvent.getUsedColumns().get(columnPos)) {
                    Column binlogColumn = deleteRowsEvent.getRows().get(rowPos).getColumns().get(columnIndex);
                    String columnName = meta.getFieldMap().get(columnPos + 1);
                    if (!checkUnknownColumnName(result, columnName, columnPos + 1)) {
                        return;
                    }
                    ColumnInfo columnInfo = new ColumnInfo(meta.getKeyMap().get(columnPos + 1),
                            convertUnsignedValueIfNeeded(columnPos + 1, binlogColumn.getValue(), meta), null);
                    columns.put(columnName, columnInfo);
                    columnIndex++;
                }
            }

            rowPos++;
            result.setData(rowChangedEvent);
            result.setEmpty(false);
            result.setFinished(false);
        }
    }

    /**
     * @param result
     * @param binlogEvent
     */
    protected void processUpdateRowEvent(DataHandlerResult result, BinlogEvent binlogEvent) {
        UpdateRowsEvent updateRowsEvent = (UpdateRowsEvent) binlogEvent;

        if (rowPos >= updateRowsEvent.getRows().size()) {
            rowPos = 0;
            result.setEmpty(true);
            result.setFinished(true);
        } else {
            Meta meta = tableIdMetaMap.get(updateRowsEvent.getTableId());

            if (meta == null) {
                skipEvent(result);
                return;
            }

            RowChangedEvent rowChangedEvent = new RowChangedEvent();
            Map<String, ColumnInfo> columns = initColumns(updateRowsEvent, rowChangedEvent, DMLType.UPDATE, meta);

            for (int columnPos = 0, columnAfterIndex = 0, columnBeforeIndex = 0; columnPos < updateRowsEvent
                    .getColumnCount().intValue(); columnPos++) {
                String columnName = meta.getFieldMap().get(columnPos + 1);
                if (!checkUnknownColumnName(result, columnName, columnPos + 1)) {
                    return;
                }
                Column afterColumn = null;
                Column beforeColumn = null;
                if (updateRowsEvent.getUsedColumnsAfter().get(columnPos)) {
                    afterColumn = updateRowsEvent.getRows().get(rowPos).getAfter().getColumns().get(columnAfterIndex);
                    columnAfterIndex++;
                }
                if (updateRowsEvent.getUsedColumnsBefore().get(columnPos)) {
                    beforeColumn = updateRowsEvent.getRows().get(rowPos).getBefore().getColumns().get(columnBeforeIndex);
                    columnBeforeIndex++;
                }
                ColumnInfo columnInfo = new ColumnInfo(meta.getKeyMap().get(columnPos + 1),
                        beforeColumn == null ? null : convertUnsignedValueIfNeeded(columnPos + 1, beforeColumn.getValue(),
                                meta), afterColumn == null ? null : convertUnsignedValueIfNeeded(columnPos + 1,
                        afterColumn.getValue(), meta));
                columns.put(columnName, columnInfo);
            }

            rowPos++;
            result.setData(rowChangedEvent);
            result.setEmpty(false);
            result.setFinished(false);
        }
    }

    /**
     * @param result
     * @param binlogEvent
     */
    protected void processWriteRowEvent(DataHandlerResult result, BinlogEvent binlogEvent) {
        WriteRowsEvent writeRowsEvent = (WriteRowsEvent) binlogEvent;

        if (rowPos >= writeRowsEvent.getRows().size()) {
            rowPos = 0;
            result.setEmpty(true);
            result.setFinished(true);
        } else {
            Meta meta = tableIdMetaMap.get(writeRowsEvent.getTableId());

            if (meta == null) {
                skipEvent(result);
                return;
            }

            RowChangedEvent rowChangedEvent = new RowChangedEvent();
            Map<String, ColumnInfo> columns = initColumns(writeRowsEvent, rowChangedEvent, DMLType.INSERT, meta);

            for (int columnPos = 0, columnIndex = 0; columnPos < writeRowsEvent.getColumnCount().intValue(); columnPos++) {
                if (writeRowsEvent.getUsedColumns().get(columnPos)) {
                    Column binlogColumn = writeRowsEvent.getRows().get(rowPos).getColumns().get(columnIndex);
                    String columnName = meta.getFieldMap().get(columnPos + 1);
                    if (!checkUnknownColumnName(result, columnName, columnPos + 1)) {
                        return;
                    }
                    ColumnInfo columnInfo = new ColumnInfo(meta.getKeyMap().get(columnPos + 1), null,
                            convertUnsignedValueIfNeeded(columnPos + 1, binlogColumn.getValue(), meta));
                    columns.put(columnName, columnInfo);
                    columnIndex++;
                }
            }

            rowPos++;
            result.setData(rowChangedEvent);
            result.setEmpty(false);
            result.setFinished(false);
        }
    }

    protected boolean checkUnknownColumnName(DataHandlerResult result, String columnName, int pos) {
        if (columnName == null) {
            StringBuilder msg = new StringBuilder();
            msg.append("Unknown column for Binlog:  ");
            msg.append(" columnPos: ").append(pos);
            log.error(msg.toString());
            Cat.logError(msg.toString(), new IllegalArgumentException(msg.toString()));
            skipEvent(result);

            return false;
        }

        return true;
    }

    protected void skipEvent(DataHandlerResult result) {
        rowPos = 0;
        result.setEmpty(true);
        result.setFinished(true);
    }

    private void fillRawNullAbilities(TableMapEvent tableMapEvent, Meta meta) {
        if (meta.getRawNullAbilities() == null && tableMapEvent.getColumnNullabilities() != null) {
            List<Integer> rawNullAbilities = new ArrayList<Integer>();
            for (int i = 0; i < tableMapEvent.getColumnNullabilities().size()
                    && i < tableMapEvent.getColumnCount().intValue(); i++) {
                if (tableMapEvent.getColumnNullabilities().get(i)) {
                    rawNullAbilities.add(i + 1);
                }
            }

            meta.setRawNullAbilities(rawNullAbilities);
        }
    }

    private void fillRawTypeCodes(TableMapEvent tableMapEvent, Meta meta) {
        if (meta.getRawTypeCodes() == null && tableMapEvent.getColumnTypes() != null) {
            Map<Integer, Byte> rawTypes = new HashMap<Integer, Byte>();
            for (int i = 0; i < tableMapEvent.getColumnTypes().length; i++) {
                rawTypes.put(i + 1, tableMapEvent.getColumnTypes()[i]);
            }

            meta.setRawTypeCodes(rawTypes);
        }
    }

    private Map<String, ColumnInfo> initColumns(AbstractRowsEvent rowsEvent, RowChangedEvent rowChangedData,
                                                DMLType dmlType, Meta meta) {
        Map<String, ColumnInfo> columns = new HashMap<String, ColumnInfo>();
        rowChangedData.setDmlType(dmlType);
        rowChangedData.setExecuteTime(rowsEvent.getHeader().getTimestamp());
        rowChangedData.setColumns(columns);
        rowChangedData.setDatabase(meta.getDatabase());
        rowChangedData.setTable(meta.getTable());
        return columns;
    }
}
