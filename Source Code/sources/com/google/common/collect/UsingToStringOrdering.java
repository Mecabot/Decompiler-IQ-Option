package com.google.common.collect;

import java.io.Serializable;

final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
    static final UsingToStringOrdering Tw = new UsingToStringOrdering();
    private static final long serialVersionUID = 0;

    public String toString() {
        return "Ordering.usingToString()";
    }

    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    private Object readResolve() {
        return Tw;
    }

    private UsingToStringOrdering() {
    }
}
