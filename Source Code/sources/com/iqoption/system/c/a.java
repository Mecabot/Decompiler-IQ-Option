package com.iqoption.system.c;

import android.support.annotation.NonNull;
import com.google.common.util.concurrent.n;

/* compiled from: CheckFutureCallback */
public abstract class a<V> implements n<V> {
    public void N(Throwable th) {
    }

    public void bF(@NonNull V v) {
    }

    public void onSuccess(V v) {
        if (v == null) {
            try {
                N(new NullPointerException("not parse"));
                return;
            } catch (Throwable th) {
                N(th);
                return;
            }
        }
        bF(v);
    }

    public void l(Throwable th) {
        N(th);
    }
}
