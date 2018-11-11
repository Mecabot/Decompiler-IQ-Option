package io.reactivex.a.b;

import android.os.Handler;
import android.os.Message;
import io.reactivex.n;
import io.reactivex.n.c;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler */
final class b extends n {
    private final Handler handler;

    /* compiled from: HandlerScheduler */
    private static final class b implements io.reactivex.disposables.b, Runnable {
        private final Runnable WZ;
        private volatile boolean disposed;
        private final Handler handler;

        b(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.WZ = runnable;
        }

        public void run() {
            try {
                this.WZ.run();
            } catch (Throwable th) {
                io.reactivex.d.a.onError(th);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacks(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* compiled from: HandlerScheduler */
    private static final class a extends c {
        private volatile boolean disposed;
        private final Handler handler;

        a(Handler handler) {
            this.handler = handler;
        }

        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.disposed) {
                return io.reactivex.disposables.c.aWp();
            } else {
                Object bVar = new b(this.handler, io.reactivex.d.a.u(runnable));
                Message obtain = Message.obtain(this.handler, bVar);
                obtain.obj = this;
                this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.disposed) {
                    return bVar;
                }
                this.handler.removeCallbacks(bVar);
                return io.reactivex.disposables.c.aWp();
            }
        }

        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    b(Handler handler) {
        this.handler = handler;
    }

    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            Object bVar = new b(this.handler, io.reactivex.d.a.u(runnable));
            this.handler.postDelayed(bVar, timeUnit.toMillis(j));
            return bVar;
        }
    }

    public c aWg() {
        return new a(this.handler);
    }
}
