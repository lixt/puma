package com.dianping.puma.server.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaUnimplementedModeException extends PumaException {

    public PumaUnimplementedModeException() {
    }

    public PumaUnimplementedModeException(String message) {
        super(message);
    }

    public PumaUnimplementedModeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaUnimplementedModeException(Throwable cause) {
        super(cause);
    }

    public PumaUnimplementedModeException(String format, Object... arguments) {
        super(format, arguments);
    }
}
