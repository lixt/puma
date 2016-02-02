package com.dianping.puma.manage.core.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class PumaManageException extends PumaException {

    public PumaManageException() {
    }

    public PumaManageException(String message) {
        super(message);
    }

    public PumaManageException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaManageException(Throwable cause) {
        super(cause);
    }

    public PumaManageException(String format, Object... arguments) {
        super(format, arguments);
    }
}
