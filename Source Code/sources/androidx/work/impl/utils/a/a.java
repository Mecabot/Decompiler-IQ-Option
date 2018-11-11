package androidx.work.impl.utils.a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: DefaultTaskExecutor */
public class a implements b {
    private final ExecutorService he = Executors.newSingleThreadExecutor();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());

    public void b(Runnable runnable) {
        this.mMainThreadHandler.post(runnable);
    }

    public void e(Runnable runnable) {
        this.he.execute(runnable);
    }
}
