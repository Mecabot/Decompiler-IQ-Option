package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class ComputableLiveData<T> {
    private final LiveData<T> aE;
    private AtomicBoolean aF;
    private AtomicBoolean aG;
    @VisibleForTesting
    final Runnable aH;
    @VisibleForTesting
    final Runnable aI;
    private final Executor mExecutor;

    @WorkerThread
    protected abstract T compute();

    public ComputableLiveData() {
        this(ArchTaskExecutor.B());
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.aF = new AtomicBoolean(true);
        this.aG = new AtomicBoolean(false);
        this.aH = new Runnable() {
            @WorkerThread
            public void run() {
                do {
                    Object obj;
                    if (ComputableLiveData.this.aG.compareAndSet(false, true)) {
                        Object obj2 = null;
                        obj = null;
                        while (ComputableLiveData.this.aF.compareAndSet(true, false)) {
                            try {
                                obj2 = ComputableLiveData.this.compute();
                                obj = 1;
                            } catch (Throwable th) {
                                ComputableLiveData.this.aG.set(false);
                            }
                        }
                        if (obj != null) {
                            ComputableLiveData.this.aE.postValue(obj2);
                        }
                        ComputableLiveData.this.aG.set(false);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        return;
                    }
                } while (ComputableLiveData.this.aF.get());
            }
        };
        this.aI = new Runnable() {
            @MainThread
            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.aE.hasActiveObservers();
                if (ComputableLiveData.this.aF.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.aH);
                }
            }
        };
        this.mExecutor = executor;
        this.aE = new LiveData<T>() {
            protected void onActive() {
                ComputableLiveData.this.mExecutor.execute(ComputableLiveData.this.aH);
            }
        };
    }

    @NonNull
    public LiveData<T> H() {
        return this.aE;
    }

    public void invalidate() {
        ArchTaskExecutor.A().c(this.aI);
    }
}
