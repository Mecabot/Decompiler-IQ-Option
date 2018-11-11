package android.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({Scope.LIBRARY_GROUP})
public class DefaultTaskExecutor extends TaskExecutor {
    private ExecutorService aj = Executors.newFixedThreadPool(2);
    @Nullable
    private volatile Handler ak;
    private final Object mLock = new Object();

    public void a(Runnable runnable) {
        this.aj.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.ak == null) {
            synchronized (this.mLock) {
                if (this.ak == null) {
                    this.ak = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.ak.post(runnable);
    }

    public boolean C() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
