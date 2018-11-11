package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class CustomTabActivity extends Activity {
    public static final String wR;
    public static final String wS;
    private BroadcastReceiver wT;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_customTabRedirect");
        wR = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_destroy");
        wS = stringBuilder.toString();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(wR);
        intent.putExtra(CustomTabMainActivity.wX, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(wR);
            intent2.putExtra(CustomTabMainActivity.wX, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            this.wT = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    CustomTabActivity.this.finish();
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.wT, new IntentFilter(wS));
        }
    }

    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.wT);
        super.onDestroy();
    }
}
