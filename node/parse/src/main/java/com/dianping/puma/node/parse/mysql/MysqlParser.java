package com.dianping.puma.node.parse.mysql;

import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.node.parse.AbstractPumaParser;
import com.dianping.puma.node.parse.exception.PumaParseException;

import java.nio.ByteBuffer;

/**
 * Created by xiaotian.li on 16/2/25.
 * Email: lixiaotian07@gmail.com
 */
public class MysqlParser extends AbstractPumaParser {

    @Override
    public BinlogEvent parse(ByteBuffer byteBuffer) throws PumaParseException {
        return null;
    }
}
