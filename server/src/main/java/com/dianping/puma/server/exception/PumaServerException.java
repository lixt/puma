package com.dianping.puma.server.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class PumaServerException extends PumaException {

    public PumaServerException() {
    }

    public PumaServerException(String message) {
        super(message);
    }

    public PumaServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaServerException(Throwable cause) {
        super(cause);
    }

    public PumaServerException(String format, Object... arguments) {
        super(format, arguments);
    }
}
