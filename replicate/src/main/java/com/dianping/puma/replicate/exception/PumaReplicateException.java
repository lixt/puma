package com.dianping.puma.replicate.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/16.
 * Email: lixiaotian07@gmail.com
 */
public class PumaReplicateException extends PumaException {

    public PumaReplicateException() {
    }

    public PumaReplicateException(String message) {
        super(message);
    }

    public PumaReplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaReplicateException(Throwable cause) {
        super(cause);
    }

    public PumaReplicateException(String format, Object... arguments) {
        super(format, arguments);
    }
}
