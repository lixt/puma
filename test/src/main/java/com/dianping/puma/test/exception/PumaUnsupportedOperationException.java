package com.dianping.puma.test.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaUnsupportedOperationException extends PumaException {

    public PumaUnsupportedOperationException() {
    }

    public PumaUnsupportedOperationException(String message) {
        super(message);
    }

    public PumaUnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaUnsupportedOperationException(Throwable cause) {
        super(cause);
    }

    public PumaUnsupportedOperationException(String format, Object... arguments) {
        super(format, arguments);
    }
}
