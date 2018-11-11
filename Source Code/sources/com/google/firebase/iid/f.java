package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Hide
public abstract class f extends Service {
    private Binder Yd;
    private int Ye;
    private int Yf = 0;
    private final Object mLock = new Object();
    @VisibleForTesting
    final ExecutorService zzimc = Executors.newSingleThreadExecutor();

    private final void o(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.mLock) {
            this.Yf--;
            if (this.Yf == 0) {
                stopSelfResult(this.Ye);
            }
        }
    }

    @Hide
    protected Intent m(Intent intent) {
        return intent;
    }

    @Hide
    public abstract void n(Intent intent);

    @Hide
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.Yd == null) {
            this.Yd = new j(this);
        }
        return this.Yd;
    }

    @Hide
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.mLock) {
            this.Ye = i2;
            this.Yf++;
        }
        Intent m = m(intent);
        if (m == null) {
            o(intent);
            return 2;
        } else if (p(m)) {
            o(intent);
            return 2;
        } else {
            this.zzimc.execute(new g(this, m, intent));
            return 3;
        }
    }

    @Hide
    public boolean p(Intent intent) {
        return false;
    }
}
