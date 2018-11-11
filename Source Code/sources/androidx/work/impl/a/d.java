package androidx.work.impl.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import androidx.work.impl.a.a.b;
import androidx.work.impl.a.a.c;
import androidx.work.impl.a.a.c.a;
import androidx.work.impl.a.a.e;
import androidx.work.impl.a.a.f;
import androidx.work.impl.a.a.g;
import androidx.work.impl.a.a.h;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkConstraintsTracker */
public class d implements a {
    @Nullable
    private final c fJ;
    private final c[] fK;
    private final Object mLock = new Object();

    public d(Context context, @Nullable c cVar) {
        context = context.getApplicationContext();
        this.fJ = cVar;
        this.fK = new c[]{new androidx.work.impl.a.a.a(context), new b(context), new h(context), new androidx.work.impl.a.a.d(context), new g(context), new f(context), new e(context)};
    }

    public void j(@NonNull List<j> list) {
        synchronized (this.mLock) {
            for (c a : this.fK) {
                a.a(null);
            }
            for (c a2 : this.fK) {
                a2.j((List) list);
            }
            for (c a3 : this.fK) {
                a3.a(this);
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            for (c reset : this.fK) {
                reset.reset();
            }
        }
    }

    public boolean F(@NonNull String str) {
        synchronized (this.mLock) {
            for (c G : this.fK) {
                if (G.G(str)) {
                    androidx.work.e.b("WorkConstraintsTracker", String.format("Work %s constrained by %s", new Object[]{str, r1[r4].getClass().getSimpleName()}), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void k(@NonNull List<String> list) {
        synchronized (this.mLock) {
            List arrayList = new ArrayList();
            for (String str : list) {
                if (F(str)) {
                    androidx.work.e.b("WorkConstraintsTracker", String.format("Constraints met for %s", new Object[]{str}), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            if (this.fJ != null) {
                this.fJ.h(arrayList);
            }
        }
    }

    public void l(@NonNull List<String> list) {
        synchronized (this.mLock) {
            if (this.fJ != null) {
                this.fJ.i(list);
            }
        }
    }
}
