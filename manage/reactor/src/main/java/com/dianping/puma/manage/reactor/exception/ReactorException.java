package com.dianping.puma.manage.reactor.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class ReactorException extends PumaException {

    public ReactorException() {
    }

    public ReactorException(String message) {
        super(message);
    }

    public ReactorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReactorException(Throwable cause) {
        super(cause);
    }

    public ReactorException(String format, Object... arguments) {
        super(format, arguments);
    }
}
