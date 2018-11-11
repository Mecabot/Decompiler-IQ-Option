package com.google.common.b;

import com.google.common.base.e;
import com.google.common.base.i;

/* compiled from: DeadEvent */
public class b {
    private final Object TA;
    private final Object source;

    public b(Object obj, Object obj2) {
        this.source = i.checkNotNull(obj);
        this.TA = i.checkNotNull(obj2);
    }

    public Object uV() {
        return this.TA;
    }

    public String toString() {
        return e.B(this).d(com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE, this.source).d("event", this.TA).toString();
    }
}
