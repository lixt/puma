package com.dianping.puma.manage.record.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class PumaRecordException extends PumaException {

    public PumaRecordException() {
    }

    public PumaRecordException(String message) {
        super(message);
    }

    public PumaRecordException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaRecordException(Throwable cause) {
        super(cause);
    }

    public PumaRecordException(String format, Object... arguments) {
        super(format, arguments);
    }
}
