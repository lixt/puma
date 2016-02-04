package com.dianping.puma.server.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaUnsupportedModeException extends PumaException {

    public PumaUnsupportedModeException() {
    }

    public PumaUnsupportedModeException(String message) {
        super(message);
    }

    public PumaUnsupportedModeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaUnsupportedModeException(Throwable cause) {
        super(cause);
    }

    public PumaUnsupportedModeException(String format, Object... arguments) {
        super(format, arguments);
    }
}
