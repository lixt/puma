package com.dianping.puma.node.parse;

import com.dianping.puma.common.PumaLifeCycle;
import com.dianping.puma.common.model.BinlogEvent;
import com.dianping.puma.node.parse.exception.PumaParseException;

import java.nio.ByteBuffer;

/**
 * Created by xiaotian.li on 16/2/25.
 * Email: lixiaotian07@gmail.com
 */
public interface PumaParser extends PumaLifeCycle {

    BinlogEvent parse(ByteBuffer byteBuffer) throws PumaParseException;
}
