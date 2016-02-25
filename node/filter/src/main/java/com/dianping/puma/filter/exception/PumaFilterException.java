package com.dianping.puma.filter.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/15.
 * Email: lixiaotian07@gmail.com
 */
public class PumaFilterException extends PumaException {

    public PumaFilterException() {
    }

    public PumaFilterException(String message) {
        super(message);
    }

    public PumaFilterException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaFilterException(Throwable cause) {
        super(cause);
    }

    public PumaFilterException(String format, Object... arguments) {
        super(format, arguments);
    }
}
