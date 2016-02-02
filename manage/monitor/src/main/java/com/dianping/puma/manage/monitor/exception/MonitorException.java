package com.dianping.puma.manage.monitor.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/2.
 * Email: lixiaotian07@gmail.com
 */
public class MonitorException extends PumaException {

    public MonitorException() {
    }

    public MonitorException(String message) {
        super(message);
    }

    public MonitorException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonitorException(Throwable cause) {
        super(cause);
    }

    public MonitorException(String format, Object... arguments) {
        super(format, arguments);
    }
}
