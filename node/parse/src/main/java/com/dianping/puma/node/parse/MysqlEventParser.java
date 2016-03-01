package com.dianping.puma.node.parse;

import com.dianping.puma.common.model.PumaEvent;
import com.dianping.puma.common.model.SQLServer;
import com.dianping.puma.common.mysql.BinlogConstants;
import com.dianping.puma.common.mysql.event.*;
import com.dianping.puma.common.mysql.packet.PumaContext;
import com.dianping.puma.core.event.ChangedEvent;
import com.dianping.puma.node.parse.AbstractPumaParser;
import com.dianping.puma.node.parse.datahandler.DataHandler;
import com.dianping.puma.node.parse.datahandler.DataHandlerResult;
import com.dianping.puma.node.parse.datahandler.DefaultDataHandler;
import com.dianping.puma.node.parse.exception.PumaParseException;
import com.dianping.puma.node.parse.meta.MetaFetcher;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xiaotian.li on 16/2/25.
 * Email: lixiaotian07@gmail.com
 */
public class MysqlEventParser extends AbstractPumaParser {

    private DefaultDataHandler dataHandler = new DefaultDataHandler();

    private static Map<Byte, Class<? extends BinlogEvent>> eventMaps
            = new ConcurrentHashMap<Byte, Class<? extends BinlogEvent>>();

    private MetaFetcher metaFetcher;

    @Override
    public void start() {
        eventMaps.put(BinlogConstants.UNKNOWN_EVENT, UnknownEvent.class);
        eventMaps.put(BinlogConstants.QUERY_EVENT, QueryEvent.class);
        eventMaps.put(BinlogConstants.STOP_EVENT, StopEvent.class);
        eventMaps.put(BinlogConstants.ROTATE_EVENT, RotateEvent.class);
        eventMaps.put(BinlogConstants.INTVAR_EVENT, IntVarEvent.class);
        eventMaps.put(BinlogConstants.RAND_EVENT, RandEvent.class);
        eventMaps.put(BinlogConstants.USER_VAR_EVENT, UserVarEvent.class);
        eventMaps.put(BinlogConstants.FORMAT_DESCRIPTION_EVENT, FormatDescriptionEvent.class);
        eventMaps.put(BinlogConstants.XID_EVENT, XIDEvent.class);
        eventMaps.put(BinlogConstants.TABLE_MAP_EVENT, TableMapEvent.class);
        eventMaps.put(BinlogConstants.WRITE_ROWS_EVENT_V1, WriteRowsEvent.class);
        eventMaps.put(BinlogConstants.UPDATE_ROWS_EVENT_V1, UpdateRowsEvent.class);
        eventMaps.put(BinlogConstants.DELETE_ROWS_EVENT_V1, DeleteRowsEvent.class);
        eventMaps.put(BinlogConstants.INCIDENT_EVENT, IncidentEvent.class);
        //mysql --5.6
        eventMaps.put(BinlogConstants.WRITE_ROWS_EVENT, WriteRowsEvent.class);
        eventMaps.put(BinlogConstants.UPDATE_ROWS_EVENT, UpdateRowsEvent.class);
        eventMaps.put(BinlogConstants.DELETE_ROWS_EVENT, DeleteRowsEvent.class);
        eventMaps.put(BinlogConstants.HEARTBEAT_LOG_EVENT, HeartbeatEvent.class);
        eventMaps.put(BinlogConstants.IGNORABLE_LOG_EVENT, IgnorableEvent.class);
        eventMaps.put(BinlogConstants.ROWS_QUERY_LOG_EVENT, RowsQueryEvent.class);
        eventMaps.put(BinlogConstants.GTID_LOG_EVENT, GtidEvent.class);
        eventMaps.put(BinlogConstants.ANONYMOUS_GTID_LOG_EVENT, AnonymousGtidEvent.class);
        eventMaps.put(BinlogConstants.PREVIOUS_GTIDS_LOG_EVENT, PreviousGtidsEvent.class);

        metaFetcher.start();
        dataHandler.setMetaFetcher(metaFetcher);
    }

    @Override
    public PumaEvent parse(ByteBuffer byteBuffer) throws PumaParseException {

        BinlogHeader header = new BinlogHeader();
        header.parse(byteBuffer);

        BinlogEvent event = null;
        Class<? extends BinlogEvent> eventClass = eventMaps.get(header.getEventType());
        if (eventClass != null) {
            try {
                event = eventClass.newInstance();
            } catch (Exception e) {
                event = null;
            }
        }

        if (event == null) {
            event = new PumaIgnoreEvent();
        }

        try {
            event.parse(byteBuffer, new PumaContext(), header);
        } catch (IOException e) {
            throw new PumaParseException("Parse error.", e);
        }

        DataHandlerResult result = dataHandler.process(event);

        ChangedEvent changedEvent = result.getData();
        if (changedEvent == null) {
            return null;
        } else {
            PumaEvent pumaEvent = new PumaEvent();
            pumaEvent.setDatabase(changedEvent.getDatabase());
            pumaEvent.setTable(changedEvent.getTable());
            return pumaEvent;
        }
    }

    public void setMetaFetcher(MetaFetcher metaFetcher) {
        this.metaFetcher = metaFetcher;
    }
}
