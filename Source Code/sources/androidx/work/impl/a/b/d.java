package androidx.work.impl.a.b;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import androidx.work.e;
import androidx.work.impl.a.a;
import java.util.LinkedHashSet;
import java.util.Set;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: ConstraintTracker */
public abstract class d<T> {
    private final Set<a<T>> fR = new LinkedHashSet();
    private T fS;
    protected final Context mAppContext;

    public abstract T ci();

    public abstract void cj();

    public abstract void startTracking();

    d(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public void a(a<T> aVar) {
        if (this.fR.add(aVar)) {
            if (this.fR.size() == 1) {
                this.fS = ci();
                e.b("ConstraintTracker", String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.fS}), new Throwable[0]);
                startTracking();
            }
            aVar.h(this.fS);
        }
    }

    public void b(a<T> aVar) {
        if (this.fR.remove(aVar) && this.fR.isEmpty()) {
            cj();
        }
    }

    public void setState(T t) {
        if (this.fS != t && (this.fS == null || !this.fS.equals(t))) {
            this.fS = t;
            for (a h : this.fR) {
                h.h(this.fS);
            }
        }
    }
}
