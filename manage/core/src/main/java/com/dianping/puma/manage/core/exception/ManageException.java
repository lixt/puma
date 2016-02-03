package com.dianping.puma.manage.core.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class ManageException extends PumaException {

    public ManageException() {
    }

    public ManageException(String message) {
        super(message);
    }

    public ManageException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManageException(Throwable cause) {
        super(cause);
    }

    public ManageException(String format, Object... arguments) {
        super(format, arguments);
    }
}
