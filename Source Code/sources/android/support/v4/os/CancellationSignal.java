package android.support.v4.os;

import android.os.Build.VERSION;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0012, code:
            if (r0 == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:11:?, code:
            r0.onCancel();
     */
    /* JADX WARNING: Missing block: B:13:0x001a, code:
            if (r1 == null) goto L_0x0033;
     */
    /* JADX WARNING: Missing block: B:15:0x0020, code:
            if (android.os.Build.VERSION.SDK_INT < 16) goto L_0x0033;
     */
    /* JADX WARNING: Missing block: B:16:0x0022, code:
            ((android.os.CancellationSignal) r1).cancel();
     */
    /* JADX WARNING: Missing block: B:17:0x0028, code:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:19:?, code:
            r4.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:26:0x0033, code:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:28:?, code:
            r4.mCancelInProgress = false;
            notifyAll();
     */
    /* JADX WARNING: Missing block: B:29:0x0039, code:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:30:0x003a, code:
            return;
     */
    public void cancel() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mIsCanceled;	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        return;
    L_0x0007:
        r0 = 1;
        r4.mIsCanceled = r0;	 Catch:{ all -> 0x003e }
        r4.mCancelInProgress = r0;	 Catch:{ all -> 0x003e }
        r0 = r4.mOnCancelListener;	 Catch:{ all -> 0x003e }
        r1 = r4.mCancellationSignalObj;	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r2 = 0;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0.onCancel();	 Catch:{ all -> 0x0018 }
        goto L_0x001a;
    L_0x0018:
        r0 = move-exception;
        goto L_0x0028;
    L_0x001a:
        if (r1 == 0) goto L_0x0033;
    L_0x001c:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0018 }
        r3 = 16;
        if (r0 < r3) goto L_0x0033;
    L_0x0022:
        r1 = (android.os.CancellationSignal) r1;	 Catch:{ all -> 0x0018 }
        r1.cancel();	 Catch:{ all -> 0x0018 }
        goto L_0x0033;
    L_0x0028:
        monitor-enter(r4);
        r4.mCancelInProgress = r2;	 Catch:{ all -> 0x0030 }
        r4.notifyAll();	 Catch:{ all -> 0x0030 }
        monitor-exit(r4);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0030 }
        throw r0;
    L_0x0033:
        monitor-enter(r4);
        r4.mCancelInProgress = r2;	 Catch:{ all -> 0x003b }
        r4.notifyAll();	 Catch:{ all -> 0x003b }
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
        return;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003b }
        throw r0;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.cancel():void");
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (!this.mIsCanceled || onCancelListener == null) {
                return;
            }
            onCancelListener.onCancel();
        }
    }

    public Object getCancellationSignalObject() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                this.mCancellationSignalObj = new android.os.CancellationSignal();
                if (this.mIsCanceled) {
                    ((android.os.CancellationSignal) this.mCancellationSignalObj).cancel();
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A:{LOOP_START, LOOP:0: B:0:0x0000->B:6:0x0000, Splitter: B:2:0x0004, ExcHandler: java.lang.InterruptedException (unused java.lang.InterruptedException)} */
    /* JADX WARNING: Can't wrap try/catch for R(5:2|3|4|9|0) */
    private void waitForCancelFinishedLocked() {
        /*
        r1 = this;
    L_0x0000:
        r0 = r1.mCancelInProgress;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r1.wait();	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0000;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.CancellationSignal.waitForCancelFinishedLocked():void");
    }
}
