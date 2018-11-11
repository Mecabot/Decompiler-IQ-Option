package com.iqoption.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.util.concurrent.s;
import com.iqoption.system.c.b;
import com.iqoption.util.Network;
import com.iqoption.util.ag;
import com.iqoption.x.R;

public class OfflineActivity extends d {
    private static final String TAG = "com.iqoption.activity.OfflineActivity";
    @Nullable
    private s<Boolean> adM;

    private static class a extends b<OfflineActivity, Boolean> {
        public a(OfflineActivity offlineActivity) {
            super((Object) offlineActivity);
        }

        /* renamed from: a */
        public void z(@NonNull OfflineActivity offlineActivity, @NonNull Boolean bool) {
            super.z(offlineActivity, bool);
            com.iqoption.util.a.a(offlineActivity, null);
        }
    }

    public static void l(Activity activity) {
        activity.startActivity(new Intent(activity, OfflineActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_offline);
    }

    public void onResume() {
        super.onResume();
        if (Network.dwp.aGr()) {
            com.iqoption.util.a.t(this);
            return;
        }
        this.adM = Network.dwp.aGq();
        ag.b(this.adM, new a(this));
    }

    public void onPause() {
        super.onPause();
        if (ag.j(this.adM)) {
            this.adM.cancel(true);
            this.adM = null;
        }
    }

    public void onBackPressed() {
        finishAffinity();
    }
}
