package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.b;
import org.slf4j.c;

abstract class NamedLoggerBase implements Serializable, b {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    NamedLoggerBase() {
    }

    public String getName() {
        return this.name;
    }

    protected Object readResolve() {
        return c.nJ(getName());
    }
}
