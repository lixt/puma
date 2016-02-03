package com.dianping.puma.manage.record.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/3.
 * Email: lixiaotian07@gmail.com
 */
public class RecordException extends PumaException {

    public RecordException() {
    }

    public RecordException(String message) {
        super(message);
    }

    public RecordException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordException(Throwable cause) {
        super(cause);
    }

    public RecordException(String format, Object... arguments) {
        super(format, arguments);
    }
}
