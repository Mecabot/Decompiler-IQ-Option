package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class e extends BroadcastReceiver {
    private d Yc;

    public e(d dVar) {
        this.Yc = dVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.Yc != null && this.Yc.wB()) {
            if (FirebaseInstanceId.wp()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.Yc, 0);
            this.Yc.getContext().unregisterReceiver(this);
            this.Yc = null;
        }
    }

    public final void wC() {
        if (FirebaseInstanceId.wp()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.Yc.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
