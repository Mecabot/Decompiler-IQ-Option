package android.arch.core.executor;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.concurrent.Executor;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ArchTaskExecutor extends TaskExecutor {
    private static volatile ArchTaskExecutor af;
    @NonNull
    private static final Executor ai = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.A().a(runnable);
        }
    };
    @NonNull
    private static final Executor sMainThreadExecutor = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.A().b(runnable);
        }
    };
    @NonNull
    private TaskExecutor ag = this.ah;
    @NonNull
    private TaskExecutor ah = new DefaultTaskExecutor();

    private ArchTaskExecutor() {
    }

    @NonNull
    public static ArchTaskExecutor A() {
        if (af != null) {
            return af;
        }
        synchronized (ArchTaskExecutor.class) {
            if (af == null) {
                af = new ArchTaskExecutor();
            }
        }
        return af;
    }

    public void a(Runnable runnable) {
        this.ag.a(runnable);
    }

    public void b(Runnable runnable) {
        this.ag.b(runnable);
    }

    @NonNull
    public static Executor B() {
        return ai;
    }

    public boolean C() {
        return this.ag.C();
    }
}
