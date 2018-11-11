package androidx.work.impl.utils.a;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkManagerTaskExecutor */
public class c implements b {
    private static c hf;
    private b eE = this.hg;
    private final b hg = new a();

    public static synchronized c cG() {
        c cVar;
        synchronized (c.class) {
            if (hf == null) {
                hf = new c();
            }
            cVar = hf;
        }
        return cVar;
    }

    private c() {
    }

    public void b(Runnable runnable) {
        this.eE.b(runnable);
    }

    public void e(Runnable runnable) {
        this.eE.e(runnable);
    }
}
