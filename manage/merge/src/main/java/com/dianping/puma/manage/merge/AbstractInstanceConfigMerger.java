package com.dianping.puma.manage.merge;

import com.dianping.puma.common.AbstractPumaLifeCycle;
import com.dianping.puma.common.model.BinlogIndex;
import com.dianping.puma.common.model.BinlogServer;
import com.dianping.puma.common.model.InstanceConfig;
import com.dianping.puma.common.model.MergedInstanceConfig;
import com.dianping.puma.manage.merge.exception.PumaMergeException;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public abstract class AbstractInstanceConfigMerger extends AbstractPumaLifeCycle implements InstanceConfigMerger {

    private long minBinlogIntervalInSecond;

    @Override
    public MergedInstanceConfig merge(InstanceConfig instanceConfig) throws PumaMergeException {
        MergedInstanceConfig mergedInstanceConfig = new MergedInstanceConfig();

        String database = instanceConfig.getDatabase();
        Set<String> mergedDatabases = Sets.newHashSet(database);
        mergedInstanceConfig.setDatabases(mergedDatabases);

        BinlogIndex binlogCursor = instanceConfig.getBinlogCursor();
        mergedInstanceConfig.setBinlogCursor(binlogCursor);

        Set<BinlogServer> binlogServers = instanceConfig.getBinlogServers();
        mergedInstanceConfig.setBinlogServers(binlogServers);

        return mergedInstanceConfig;
    }

    @Override
    public MergedInstanceConfig merge(MergedInstanceConfig mergedInstanceConfig,
                                      InstanceConfig instanceConfig) throws PumaMergeException {

        Set<String> mergedDatabases = mergedInstanceConfig.getDatabases();
        String database = instanceConfig.getDatabase();
        mergedDatabases = mergeDatabase(mergedDatabases, database);
        mergedInstanceConfig.setDatabases(mergedDatabases);

        BinlogIndex mergedBinlogCursor = mergedInstanceConfig.getBinlogCursor();
        BinlogIndex binlogCursor = instanceConfig.getBinlogCursor();
        mergedBinlogCursor = mergeBinlogCursor(mergedBinlogCursor, binlogCursor);
        mergedInstanceConfig.setBinlogCursor(mergedBinlogCursor);

        Set<BinlogServer> mergedBinlogServers = mergedInstanceConfig.getBinlogServers();
        Set<BinlogServer> binlogServers = instanceConfig.getBinlogServers();
        mergedBinlogServers = mergeBinlogServers(mergedBinlogServers, binlogServers);
        mergedInstanceConfig.setBinlogServers(mergedBinlogServers);

        return mergedInstanceConfig;
    }

    protected Set<String> mergeDatabase(Set<String> mergedDatabases, String database) throws PumaMergeException {
        if (mergedDatabases.contains(database)) {
            throw new PumaMergeException("Duplicated database[%s].", database);
        } else {
            mergedDatabases.add(database);
            return mergedDatabases;
        }
    }

    protected BinlogIndex mergeBinlogCursor(BinlogIndex mergedBinlogCursor, BinlogIndex binlogCursor) {
        if (mergedBinlogCursor == null) {
            return binlogCursor;
        } else {
            Long mergedBinlogTimestamp = mergedBinlogCursor.getBinlogTimestamp();
            Long binlogTimestamp = binlogCursor.getBinlogTimestamp();
            if (mergedBinlogTimestamp == null || binlogTimestamp == null) {
                throw new PumaMergeException("All binlog cursor must contain timestamp.");
            } else {
                if (Math.abs(mergedBinlogTimestamp - binlogTimestamp) > minBinlogIntervalInSecond) {
                    throw new PumaMergeException("Binlog timestamps interval is too large.");
                } else {
                    return mergedBinlogTimestamp > binlogTimestamp ? binlogCursor : mergedBinlogCursor;
                }
            }
        }
    }

    @Override
    public MergedInstanceConfig unmerge(MergedInstanceConfig mergedInstanceConfig,
                                        InstanceConfig instanceConfig) throws PumaMergeException {
        return null;
    }

    protected abstract Set<BinlogServer> mergeBinlogServers(
            Set<BinlogServer> mergedBinlogServers, Set<BinlogServer> binlogServers);

    public void setMinBinlogIntervalInSecond(long minBinlogIntervalInSecond) {
        this.minBinlogIntervalInSecond = minBinlogIntervalInSecond;
    }
}
