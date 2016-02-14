package com.dianping.puma.manage.registry.exception;

import com.dianping.puma.common.exception.PumaException;

/**
 * Created by xiaotian.li on 16/2/5.
 * Email: lixiaotian07@gmail.com
 */
public class PumaInstanceRegistryException extends PumaException {

    public PumaInstanceRegistryException() {
    }

    public PumaInstanceRegistryException(String message) {
        super(message);
    }

    public PumaInstanceRegistryException(String message, Throwable cause) {
        super(message, cause);
    }

    public PumaInstanceRegistryException(Throwable cause) {
        super(cause);
    }

    public PumaInstanceRegistryException(String format, Object... arguments) {
        super(format, arguments);
    }
}
