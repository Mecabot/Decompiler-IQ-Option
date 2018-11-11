package androidx.work;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;

/* compiled from: OneTimeWorkRequest */
public final class f extends k {

    /* compiled from: OneTimeWorkRequest */
    public static final class a extends androidx.work.k.a<a, f> {
        @NonNull
        /* renamed from: aT */
        a aU() {
            return this;
        }

        public a(@NonNull Class<? extends Worker> cls) {
            super(cls);
        }

        @NonNull
        /* renamed from: aS */
        f aV() {
            if (!this.dY || VERSION.SDK_INT < 23 || !this.dW.gv.aJ()) {
                return new f(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
    }

    f(a aVar) {
        super(aVar.dV, aVar.dW, aVar.dX);
    }
}
