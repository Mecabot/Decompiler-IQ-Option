package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = (enx + 1);
    private static final int MAXIMUM_POOL_SIZE = ((enx * 2) + 1);
    public static final Executor SERIAL_EXECUTOR = new c();
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, enz, eny);
    private static final b enA = new b();
    private static volatile Executor enB = SERIAL_EXECUTOR;
    private static final int enx = Runtime.getRuntime().availableProcessors();
    private static final ThreadFactory eny = new ThreadFactory() {
        private final AtomicInteger count = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AsyncTask #");
            stringBuilder.append(this.count.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    };
    private static final BlockingQueue<Runnable> enz = new LinkedBlockingQueue(128);
    private final d<Params, Result> enC = new d<Params, Result>() {
        public Result call() {
            AsyncTask.this.enG.set(true);
            Process.setThreadPriority(10);
            return AsyncTask.this.postResult(AsyncTask.this.doInBackground(this.enP));
        }
    };
    private final FutureTask<Result> enD = new FutureTask<Result>(this.enC) {
        protected void done() {
            try {
                AsyncTask.this.postResultIfNotInvoked(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                AsyncTask.this.postResultIfNotInvoked(null);
            }
        }
    };
    private volatile Status enE = Status.PENDING;
    private final AtomicBoolean enF = new AtomicBoolean();
    private final AtomicBoolean enG = new AtomicBoolean();

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static class a<Data> {
        final AsyncTask enJ;
        final Data[] enK;

        a(AsyncTask asyncTask, Data... dataArr) {
            this.enJ = asyncTask;
            this.enK = dataArr;
        }
    }

    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.enJ.finish(aVar.enK[0]);
                    return;
                case 2:
                    aVar.enJ.onProgressUpdate(aVar.enK);
                    return;
                default:
                    return;
            }
        }
    }

    private static class c implements Executor {
        final LinkedList<Runnable> enL;
        Runnable enM;

        private c() {
            this.enL = new LinkedList();
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void execute(final Runnable runnable) {
            this.enL.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.aUV();
                    }
                }
            });
            if (this.enM == null) {
                aUV();
            }
        }

        protected synchronized void aUV() {
            Runnable runnable = (Runnable) this.enL.poll();
            this.enM = runnable;
            if (runnable != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.enM);
            }
        }
    }

    private static abstract class d<Params, Result> implements Callable<Result> {
        Params[] enP;

        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    protected abstract Result doInBackground(Params... paramsArr);

    protected void onCancelled() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    private void postResultIfNotInvoked(Result result) {
        if (!this.enG.get()) {
            postResult(result);
        }
    }

    private Result postResult(Result result) {
        enA.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    public final Status aUU() {
        return this.enE;
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    public final boolean isCancelled() {
        return this.enF.get();
    }

    public final boolean cancel(boolean z) {
        this.enF.set(true);
        return this.enD.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.enE != Status.PENDING) {
            switch (this.enE) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.enE = Status.RUNNING;
        onPreExecute();
        this.enC.enP = paramsArr;
        executor.execute(this.enD);
        return this;
    }

    private void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.enE = Status.FINISHED;
    }
}
