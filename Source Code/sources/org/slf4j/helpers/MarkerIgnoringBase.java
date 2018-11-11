package org.slf4j.helpers;

import org.slf4j.b;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements b {
    private static final long serialVersionUID = 9044267456635152283L;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append("(");
        stringBuilder.append(getName());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
