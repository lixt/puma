package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class IllegalBinlogFormatException extends PumaException {

    public IllegalBinlogFormatException() {
    }

    public IllegalBinlogFormatException(String message) {
        super(message);
    }

    public IllegalBinlogFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalBinlogFormatException(Throwable cause) {
        super(cause);
    }

    public IllegalBinlogFormatException(String format, Object... arguments) {
        super(format, arguments);
    }
}
