package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogDumpException extends PumaException {

    public BinlogDumpException() {
    }

    public BinlogDumpException(String message) {
        super(message);
    }

    public BinlogDumpException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinlogDumpException(Throwable cause) {
        super(cause);
    }

    public BinlogDumpException(String format, Object... arguments) {
        super(format, arguments);
    }
}
