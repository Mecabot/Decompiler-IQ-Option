package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.e;

public class CustomTabMainActivity extends Activity {
    public static final String wV;
    public static final String wW;
    public static final String wX;
    public static final String wY;
    private boolean wZ = true;
    private BroadcastReceiver xa;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_params");
        wV = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_chromePackage");
        wW = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_url");
        wX = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".action_refresh");
        wY = stringBuilder.toString();
    }

    public static final String iM() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(h.it());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.wR.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            bundle = getIntent().getBundleExtra(wV);
            new e("oauth", bundle).b(this, getIntent().getStringExtra(wW));
            this.wZ = false;
            this.xa = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.wY);
                    intent2.putExtra(CustomTabMainActivity.wX, intent.getStringExtra(CustomTabMainActivity.wX));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.xa, new IntentFilter(CustomTabActivity.wR));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (wY.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.wS));
            a(-1, intent);
        } else if (CustomTabActivity.wR.equals(intent.getAction())) {
            a(-1, intent);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.wZ) {
            a(0, null);
        }
        this.wZ = true;
    }

    private void a(int i, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.xa);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }
}
