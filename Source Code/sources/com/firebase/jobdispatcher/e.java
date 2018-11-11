package com.firebase.jobdispatcher;

import android.support.annotation.NonNull;
import com.firebase.jobdispatcher.n.a;

/* compiled from: FirebaseJobDispatcher */
public final class e {
    private final c JL;
    private final ValidationEnforcer JN;
    private final a JQ;

    public int a(@NonNull n nVar) {
        if (this.JL.isAvailable()) {
            return this.JL.a(nVar);
        }
        return 2;
    }

    public int cr(@NonNull String str) {
        if (this.JL.isAvailable()) {
            return this.JL.cr(str);
        }
        return 2;
    }

    @NonNull
    public a oA() {
        return new a(this.JN);
    }

    public x e(int i, int i2, int i3) {
        return this.JQ.f(i, i2, i3);
    }
}
