package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.w;
import com.facebook.internal.x;

/* compiled from: AccessTokenTracker */
public abstract class d {
    private static final String TAG = "d";
    private final BroadcastReceiver receiver;
    private final LocalBroadcastManager wO;
    private boolean wP = false;

    /* compiled from: AccessTokenTracker */
    private class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
                w.E(d.TAG, "AccessTokenChanged");
                d.this.b((a) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (a) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
            }
        }
    }

    protected abstract void b(a aVar, a aVar2);

    public d() {
        x.mC();
        this.receiver = new a();
        this.wO = LocalBroadcastManager.getInstance(h.getApplicationContext());
        startTracking();
    }

    public void startTracking() {
        if (!this.wP) {
            iJ();
            this.wP = true;
        }
    }

    private void iJ() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.wO.registerReceiver(this.receiver, intentFilter);
    }
}
