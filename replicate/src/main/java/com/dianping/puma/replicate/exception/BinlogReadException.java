package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogReadException extends PumaException {

    public BinlogReadException() {
    }

    public BinlogReadException(String message) {
        super(message);
    }

    public BinlogReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinlogReadException(Throwable cause) {
        super(cause);
    }

    public BinlogReadException(String format, Object... arguments) {
        super(format, arguments);
    }
}
