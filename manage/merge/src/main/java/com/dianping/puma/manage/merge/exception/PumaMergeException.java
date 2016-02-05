package com.dianping.puma.manage.merge.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaMergeException extends PumaException {

    public PumaMergeException() {
    }

    public PumaMergeException(String message) {
        super(message);
    }

    public PumaMergeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaMergeException(Throwable cause) {
        super(cause);
    }

    public PumaMergeException(String format, Object... arguments) {
        super(format, arguments);
    }
}
