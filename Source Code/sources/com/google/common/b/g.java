package com.google.common.b;

import com.google.common.base.i;
import java.lang.reflect.Method;

/* compiled from: SubscriberExceptionContext */
public class g {
    private final Object TA;
    private final d Ud;
    private final Object Ue;
    private final Method Uf;

    g(d dVar, Object obj, Object obj2, Method method) {
        this.Ud = (d) i.checkNotNull(dVar);
        this.TA = i.checkNotNull(obj);
        this.Ue = i.checkNotNull(obj2);
        this.Uf = (Method) i.checkNotNull(method);
    }

    public d va() {
        return this.Ud;
    }

    public Object uV() {
        return this.TA;
    }

    public Object vb() {
        return this.Ue;
    }

    public Method vc() {
        return this.Uf;
    }
}
