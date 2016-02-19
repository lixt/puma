package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class BinlogSetupException extends PumaException {

    public BinlogSetupException() {
    }

    public BinlogSetupException(String message) {
        super(message);
    }

    public BinlogSetupException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinlogSetupException(Throwable cause) {
        super(cause);
    }

    public BinlogSetupException(String format, Object... arguments) {
        super(format, arguments);
    }
}
