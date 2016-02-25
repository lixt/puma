package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/19.
 * Email: lixiaotian07@gmail.com
 */
public class IllegalBinlogImageException extends PumaException {

    public IllegalBinlogImageException() {
    }

    public IllegalBinlogImageException(String message) {
        super(message);
    }

    public IllegalBinlogImageException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalBinlogImageException(Throwable cause) {
        super(cause);
    }

    public IllegalBinlogImageException(String format, Object... arguments) {
        super(format, arguments);
    }
}
