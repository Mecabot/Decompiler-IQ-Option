package pl.droidsonroids.gif;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: SafeRunnable */
abstract class k implements Runnable {
    final b fkX;

    abstract void doWork();

    k(b bVar) {
        this.fkX = bVar;
    }

    public final void run() {
        try {
            if (!this.fkX.isRecycled()) {
                doWork();
            }
        } catch (Throwable th) {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
