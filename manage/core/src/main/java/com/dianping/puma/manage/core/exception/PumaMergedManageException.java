package com.dianping.puma.manage.core.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/4.
 * Email: lixiaotian07@gmail.com
 */
public class PumaMergedManageException extends PumaException {

    public PumaMergedManageException() {
    }

    public PumaMergedManageException(String message) {
        super(message);
    }

    public PumaMergedManageException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaMergedManageException(Throwable cause) {
        super(cause);
    }

    public PumaMergedManageException(String format, Object... arguments) {
        super(format, arguments);
    }
}
