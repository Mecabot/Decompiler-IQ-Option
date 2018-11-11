package com.pro100svitlo.creditCardNfcReader.model;

import java.io.Serializable;
import org.apache.commons.lang3.builder.b;

public abstract class AbstractData implements Serializable {
    private static final long serialVersionUID = -456811026151402726L;

    public String toString() {
        return b.dq(this);
    }
}
