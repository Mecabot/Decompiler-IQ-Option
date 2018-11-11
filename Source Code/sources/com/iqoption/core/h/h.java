package com.iqoption.core.h;

import com.iqoption.core.connect.http.HttpException;
import com.iqoption.core.connect.ws.SocketException;
import io.reactivex.c.e;
import io.reactivex.exceptions.UndeliverableException;
import java.io.IOException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/rx/RxJavaErrorHandlers;", "", "()V", "rxJavaErrorHandler", "Lio/reactivex/functions/Consumer;", "", "core_release"})
/* compiled from: RxJavaErrorHandlers.kt */
public final class h {
    public static final e<Throwable> baE = a.baG;
    public static final h baF = new h();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "error", "", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: RxJavaErrorHandlers.kt */
    static final class a<T> implements e<Throwable> {
        public static final a baG = new a();

        a() {
        }

        /* renamed from: o */
        public final void accept(Throwable th) {
            if (th instanceof UndeliverableException) {
                th = th.getCause();
            }
            Thread currentThread;
            if ((th instanceof IOException) || (th instanceof SocketException) || (th instanceof HttpException)) {
                com.iqoption.core.i.w("Unhandled exception occurred", th);
            } else if (th instanceof InterruptedException) {
                com.iqoption.core.i.w("Unhandled exception occurred", th);
            } else if ((th instanceof NullPointerException) || (th instanceof IllegalArgumentException)) {
                currentThread = Thread.currentThread();
                kotlin.jvm.internal.h.d(currentThread, "Thread.currentThread()");
                currentThread.getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            } else if (th instanceof IllegalStateException) {
                currentThread = Thread.currentThread();
                kotlin.jvm.internal.h.d(currentThread, "Thread.currentThread()");
                currentThread.getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            } else {
                com.crashlytics.android.a.c(th);
                com.iqoption.core.i.w("Undeliverable exception received, not sure what to do", th);
            }
        }
    }

    private h() {
    }
}
