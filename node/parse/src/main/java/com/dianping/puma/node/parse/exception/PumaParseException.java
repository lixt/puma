package com.dianping.puma.node.parse.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/25.
 * Email: lixiaotian07@gmail.com
 */
public class PumaParseException extends PumaException {

    public PumaParseException() {
    }

    public PumaParseException(String message) {
        super(message);
    }

    public PumaParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaParseException(Throwable cause) {
        super(cause);
    }

    public PumaParseException(String format, Object... arguments) {
        super(format, arguments);
    }
}
