package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogAuthException extends PumaException {

    public BinlogAuthException() {
    }

    public BinlogAuthException(String message) {
        super(message);
    }

    public BinlogAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinlogAuthException(Throwable cause) {
        super(cause);
    }

    public BinlogAuthException(String format, Object... arguments) {
        super(format, arguments);
    }
}
