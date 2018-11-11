package android.arch.core.executor;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class TaskExecutor {
    public abstract boolean C();

    public abstract void a(@NonNull Runnable runnable);

    public abstract void b(@NonNull Runnable runnable);

    public void c(@NonNull Runnable runnable) {
        if (C()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
