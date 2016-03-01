package com.dianping.puma.node.parse.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/26.
 * Email: lixiaotian07@gmail.com
 */
public class PumaMetaException extends PumaException {

    public PumaMetaException() {
    }

    public PumaMetaException(String message) {
        super(message);
    }

    public PumaMetaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaMetaException(Throwable cause) {
        super(cause);
    }

    public PumaMetaException(String format, Object... arguments) {
        super(format, arguments);
    }
}
