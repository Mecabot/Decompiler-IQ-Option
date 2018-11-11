package com.iqoption.core.h;

import com.iqoption.core.f;
import com.iqoption.core.util.b.a;
import io.reactivex.n;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f¨\u0006\u0010"}, aXE = {"bg", "Lio/reactivex/Scheduler;", "getBg", "()Lio/reactivex/Scheduler;", "comp", "getComp", "ui", "getUi", "worker", "getWorker", "workerHandler", "Lcom/iqoption/core/util/thread/ExecutorHandlerThread;", "getWorkerHandler", "()Lcom/iqoption/core/util/thread/ExecutorHandlerThread;", "GuavaSchedulers", "Lcom/iqoption/core/guava/Schedulers;", "core_release"})
/* compiled from: Schedulers.kt */
public final class i {
    private static final a baH;
    private static final n baI = (f.Dp().DQ() ? io.reactivex.e.a.aXu() : io.reactivex.e.a.a(com.iqoption.core.d.a.aSc));
    private static final n baJ = (f.Dp().DQ() ? io.reactivex.e.a.aXu() : io.reactivex.e.a.a(com.iqoption.core.d.a.aSe));
    private static final n baK = (f.Dp().DQ() ? io.reactivex.e.a.aXu() : io.reactivex.e.a.aXs());
    private static final n baL = (f.Dp().DQ() ? io.reactivex.e.a.aXu() : io.reactivex.e.a.a(baH));

    static {
        a aVar = new a("WorkerHandlerThread");
        aVar.start();
        baH = aVar;
    }

    public static final a Yn() {
        return baH;
    }

    public static final n Yo() {
        return baI;
    }

    public static final n Yp() {
        return baJ;
    }

    public static final n Yq() {
        return baK;
    }

    public static final n Yr() {
        return baL;
    }
}
