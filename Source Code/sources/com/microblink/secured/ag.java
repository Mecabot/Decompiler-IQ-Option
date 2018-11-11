package com.microblink.secured;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: line */
public final class ag extends Thread implements ak {
    private Looper dYo;
    private AtomicBoolean dYp = new AtomicBoolean(false);
    private AtomicBoolean dYq = new AtomicBoolean(false);
    private CountDownLatch dYr;
    private CountDownLatch dYs;
    private Handler mHandler;
    private String mName = "";

    /* compiled from: line */
    static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable th) {
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) message.obj;
                StackTraceElement[] stackTrace = th2.getStackTrace();
                ArrayList arrayList = new ArrayList(stackTrace.length + stackTraceElementArr.length);
                for (Object add : stackTrace) {
                    arrayList.add(add);
                }
                arrayList.add(new StackTraceElement("********************* Posted to handler", "at: ", null, -2));
                for (int i = 5; i < stackTraceElementArr.length; i++) {
                    arrayList.add(stackTraceElementArr[i]);
                }
                stackTraceElementArr = new StackTraceElement[arrayList.size()];
                arrayList.toArray(stackTraceElementArr);
                th2.setStackTrace(stackTraceElementArr);
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            message.obj = Thread.currentThread().getStackTrace();
            return super.sendMessageAtTime(message, j);
        }
    }

    public ag(String str) {
        this.mName = str;
        this.dYr = new CountDownLatch(1);
        this.dYs = new CountDownLatch(1);
        setName(this.mName);
    }

    public final void run() {
        try {
            Looper.prepare();
            Log.e(this, "Booting processing queue {}", this.mName);
            this.dYo = Looper.myLooper();
            this.mHandler = new a(this.dYo);
            this.dYr.countDown();
            Looper.loop();
            this.dYp.set(true);
            this.dYs.countDown();
            Log.a(this, "Processing queue {} terminated gracefully", this.mName);
        } catch (final Throwable th) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    StringBuilder stringBuilder = new StringBuilder("Processing queue ");
                    stringBuilder.append(ag.this.mName);
                    stringBuilder.append(" halted due to an error.");
                    throw new RuntimeException(stringBuilder.toString(), th);
                }
            });
        }
    }

    private void aPW() {
        try {
            this.dYr.await();
        } catch (Throwable e) {
            Log.a(this, e, "Interrupted while waiting for processing queue {} to start", this.mName);
        }
    }

    public final void o(Runnable runnable) {
        aPW();
        if (this.dYq.get()) {
            Log.c(this, "Processing queue {} is exiting, unable to post job to it", this.mName);
            return;
        }
        this.mHandler.post(runnable);
    }

    public final Handler getHandler() {
        aPW();
        return this.mHandler;
    }
}
