package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
public abstract class c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements a<i>, f, i {
    private final g enQ = new g();

    /* compiled from: PriorityAsyncTask */
    private static class a<Result> implements Executor {
        private final c enR;
        private final Executor executor;

        public a(Executor executor, c cVar) {
            this.executor = executor;
            this.enR = cVar;
        }

        public void execute(Runnable runnable) {
            this.executor.execute(new e<Result>(runnable, null) {
                public <T extends a<i> & f & i> T aVb() {
                    return a.this.enR;
                }
            });
        }
    }

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    /* renamed from: a */
    public void bS(i iVar) {
        if (aUU() != Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((a) ((f) aVb())).bS(iVar);
    }

    public Collection<i> aUq() {
        return ((a) ((f) aVb())).aUq();
    }

    public boolean aUW() {
        return ((a) ((f) aVb())).aUW();
    }

    public Priority hA() {
        return ((f) aVb()).hA();
    }

    public void gr(boolean z) {
        ((i) ((f) aVb())).gr(z);
    }

    public boolean isFinished() {
        return ((i) ((f) aVb())).isFinished();
    }

    public void P(Throwable th) {
        ((i) ((f) aVb())).P(th);
    }

    public <T extends a<i> & f & i> T aVb() {
        return this.enQ;
    }
}
