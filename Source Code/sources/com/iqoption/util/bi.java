package com.iqoption.util;

import com.google.common.util.concurrent.v;
import com.google.common.util.concurrent.x;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00018\u00008\b@\bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/util/WorkLimiter;", "T", "", "callback", "Lkotlin/Function1;", "", "rateLimiter", "Lcom/google/common/util/concurrent/RateLimiter;", "scheduler", "Ljava/util/concurrent/Executor;", "(Lkotlin/jvm/functions/Function1;Lcom/google/common/util/concurrent/RateLimiter;Ljava/util/concurrent/Executor;)V", "lastArg", "Ljava/lang/Object;", "doWork", "arg", "(Ljava/lang/Object;)V", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WorkLimiter.kt */
public final class bi<T> {
    private volatile T dwN;
    private final b<T, l> dwO;
    private final x dwP;
    private final Executor dwQ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "T", "run"})
    /* compiled from: WorkLimiter.kt */
    static final class a implements Runnable {
        final /* synthetic */ bi dwR;

        a(bi biVar) {
            this.dwR = biVar;
        }

        public final void run() {
            this.dwR.dwP.vY();
            Object b = this.dwR.dwN;
            if (b != null) {
                this.dwR.dwO.invoke(b);
            }
            this.dwR.dwN = null;
        }
    }

    public bi(b<? super T, l> bVar, x xVar, Executor executor) {
        h.e(bVar, "callback");
        h.e(xVar, "rateLimiter");
        h.e(executor, "scheduler");
        this.dwO = bVar;
        this.dwP = xVar;
        this.dwQ = executor;
    }

    public /* synthetic */ bi(b bVar, x xVar, Executor executor, int i, f fVar) {
        if ((i & 2) != 0) {
            xVar = x.a(1.0d, 1, TimeUnit.SECONDS);
            h.d(xVar, "RateLimiter.create(1.0, 1, TimeUnit.SECONDS)");
        }
        if ((i & 4) != 0) {
            v vVar = com.iqoption.core.d.a.aSc;
            h.d(vVar, "Schedulers.io");
            executor = vVar;
        }
        this(bVar, xVar, executor);
    }

    public final void bN(T t) {
        if (this.dwP.tryAcquire()) {
            this.dwO.invoke(t);
            return;
        }
        Object obj = this.dwN == null ? 1 : null;
        this.dwN = t;
        if (obj == null) {
            this.dwQ.execute(new a(this));
        }
    }
}
