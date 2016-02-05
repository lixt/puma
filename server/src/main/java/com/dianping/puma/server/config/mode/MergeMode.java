package com.dianping.puma.server.config.mode;

/**
 * Created by xiaotian.li on 16/2/5.
 * Email: lixiaotian07@gmail.com
 */
public enum MergeMode {

    /** loose. */
    LOOSE,

    /** standard. */
    STANDARD,

    /** strict. */
    STRICT;

    public boolean isLoose() {
        return this.equals(LOOSE);
    }

    public boolean isStandard() {
        return this.equals(STANDARD);
    }

    public boolean isStrict() {
        return this.equals(STRICT);
    }
}
