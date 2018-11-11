package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.appevents.AppEventsLogger;

/* compiled from: BoltsMeasurementEventListener */
public class c extends BroadcastReceiver {
    private static c Ce;
    private Context xK;

    private c(Context context) {
        this.xK = context.getApplicationContext();
    }

    private void open() {
        LocalBroadcastManager.getInstance(this.xK).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void close() {
        LocalBroadcastManager.getInstance(this.xK).unregisterReceiver(this);
    }

    public static c aa(Context context) {
        if (Ce != null) {
            return Ce;
        }
        Ce = new c(context);
        Ce.open();
        return Ce;
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppEventsLogger T = AppEventsLogger.T(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bf_");
        stringBuilder.append(intent.getStringExtra("event_name"));
        String stringBuilder2 = stringBuilder.toString();
        Bundle bundleExtra = intent.getBundleExtra("event_args");
        Bundle bundle = new Bundle();
        for (String str : bundleExtra.keySet()) {
            bundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str));
        }
        T.logEvent(stringBuilder2, bundle);
    }
}
