package com.iqoption.core.connect.bus;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, aXE = {"Lcom/iqoption/core/connect/bus/OtherError;", "Lcom/iqoption/core/connect/bus/IQBusError;", "()V", "toString", "", "core_release"})
/* compiled from: IQBusError.kt */
public final class c extends a {
    public static final c aNg = new c();

    private c() {
        super();
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        h.d(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
