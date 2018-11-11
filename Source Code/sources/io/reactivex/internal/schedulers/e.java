package io.reactivex.internal.schedulers;

import io.reactivex.n;
import io.reactivex.n.c;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler */
public final class e extends n {
    private static final RxThreadFactory erU = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory eny;

    public e() {
        this(erU);
    }

    public e(ThreadFactory threadFactory) {
        this.eny = threadFactory;
    }

    public c aWg() {
        return new f(this.eny);
    }
}
