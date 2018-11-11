package androidx.work;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* compiled from: PeriodicWorkRequest */
public final class g extends k {

    /* compiled from: PeriodicWorkRequest */
    public static final class a extends androidx.work.k.a<a, g> {
        @NonNull
        /* renamed from: aX */
        a aU() {
            return this;
        }

        public a(@NonNull Class<? extends Worker> cls, long j, @NonNull TimeUnit timeUnit) {
            super(cls);
            this.dW.d(timeUnit.toMillis(j));
        }

        @NonNull
        /* renamed from: aW */
        g aV() {
            if (!this.dY || VERSION.SDK_INT < 23 || !this.dW.gv.aJ()) {
                return new g(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
    }

    g(a aVar) {
        super(aVar.dV, aVar.dW, aVar.dX);
    }
}
