package com.iqoption.system;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: CountTimer */
public abstract class b {
    private final long drM;
    private boolean mCancelled = false;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            synchronized (b.this) {
                if (b.this.mCancelled) {
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b.this.axw();
                long b = (elapsedRealtime + b.this.drM) - SystemClock.elapsedRealtime();
                while (b < 0) {
                    b += b.this.drM;
                }
                sendMessageDelayed(obtainMessage(1), b);
            }
        }
    };

    public abstract void axw();

    public b(long j) {
        this.drM = j;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
    }

    public final synchronized b aEn() {
        this.mCancelled = false;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        return this;
    }
}
