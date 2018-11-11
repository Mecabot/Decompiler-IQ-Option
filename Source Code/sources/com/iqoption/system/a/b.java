package com.iqoption.system.a;

import com.google.common.base.n;
import com.iqoption.app.IQApp;
import com.iqoption.core.i;
import com.iqoption.util.aw;

/* compiled from: EventBusValue */
public class b<T> {
    private final n<c<T>> cKx;
    private T defaultValue;
    private T value;

    public b(n<c<T>> nVar, T t) {
        this.cKx = nVar;
        this.defaultValue = t;
    }

    public boolean bG(T t) {
        if (aw.equals(this.value, t)) {
            return false;
        }
        String name = getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Change value. old=");
        stringBuilder.append(this.value);
        stringBuilder.append(", new=");
        stringBuilder.append(t);
        i.d(name, stringBuilder.toString());
        this.value = t;
        c cVar = (c) this.cKx.get();
        cVar.setValue(t);
        if (IQApp.Dk() != null) {
            IQApp.Dn().aE(cVar);
        }
        return true;
    }

    public void bH(T t) {
        this.value = t;
    }

    public void aEs() {
        this.value = this.defaultValue;
    }

    public T getValue() {
        return this.value == null ? this.defaultValue : this.value;
    }
}
