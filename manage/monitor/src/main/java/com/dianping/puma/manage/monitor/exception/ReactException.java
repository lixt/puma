package com.dianping.puma.manage.monitor.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class ReactException extends PumaException {

    public ReactException() {
    }

    public ReactException(String message) {
        super(message);
    }

    public ReactException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReactException(Throwable cause) {
        super(cause);
    }

    public ReactException(String format, Object... arguments) {
        super(format, arguments);
    }
}
