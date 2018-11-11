package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DevicePowerStateListener */
class w {
    private static final IntentFilter vj = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter vk = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter vl = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context context;
    private final AtomicBoolean vm = new AtomicBoolean(false);
    private final BroadcastReceiver vo = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            w.this.vq = false;
        }
    };
    private final BroadcastReceiver vp = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            w.this.vq = true;
        }
    };
    private boolean vq;

    public w(Context context) {
        this.context = context;
    }

    public void initialize() {
        boolean z = true;
        if (!this.vm.getAndSet(true)) {
            Intent registerReceiver = this.context.registerReceiver(null, vj);
            int i = -1;
            if (registerReceiver != null) {
                i = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            }
            if (!(i == 2 || i == 5)) {
                z = false;
            }
            this.vq = z;
            this.context.registerReceiver(this.vp, vk);
            this.context.registerReceiver(this.vo, vl);
        }
    }

    public boolean hK() {
        return this.vq;
    }

    public void dispose() {
        if (this.vm.getAndSet(false)) {
            this.context.unregisterReceiver(this.vp);
            this.context.unregisterReceiver(this.vo);
        }
    }
}
