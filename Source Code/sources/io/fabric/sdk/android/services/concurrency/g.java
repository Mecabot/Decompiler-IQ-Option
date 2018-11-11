package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
public class g implements a<i>, f, i {
    private final List<i> enT = new ArrayList();
    private final AtomicBoolean enU = new AtomicBoolean(false);
    private final AtomicReference<Throwable> enV = new AtomicReference(null);

    public synchronized Collection<i> aUq() {
        return Collections.unmodifiableCollection(this.enT);
    }

    /* renamed from: a */
    public synchronized void bS(i iVar) {
        this.enT.add(iVar);
    }

    public boolean aUW() {
        for (i isFinished : aUq()) {
            if (!isFinished.isFinished()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void gr(boolean z) {
        this.enU.set(z);
    }

    public boolean isFinished() {
        return this.enU.get();
    }

    public Priority hA() {
        return Priority.NORMAL;
    }

    public void P(Throwable th) {
        this.enV.set(th);
    }

    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    public static boolean bU(Object obj) {
        boolean z = false;
        try {
            a aVar = (a) obj;
            i iVar = (i) obj;
            f fVar = (f) obj;
            if (!(aVar == null || iVar == null || fVar == null)) {
                z = true;
            }
            return z;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
