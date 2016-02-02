package com.dianping.puma.manage.monitor.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class PumaMonitorException extends PumaException {

    public PumaMonitorException() {
    }

    public PumaMonitorException(String message) {
        super(message);
    }

    public PumaMonitorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaMonitorException(Throwable cause) {
        super(cause);
    }

    public PumaMonitorException(String format, Object... arguments) {
        super(format, arguments);
    }
}
