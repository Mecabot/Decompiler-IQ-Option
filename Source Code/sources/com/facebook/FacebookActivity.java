package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.facebook.common.a.d;
import com.facebook.common.a.e;
import com.facebook.internal.g;
import com.facebook.internal.s;
import com.facebook.internal.w;
import com.facebook.login.h;
import com.facebook.share.internal.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;

public class FacebookActivity extends FragmentActivity {
    private static final String TAG = "com.facebook.FacebookActivity";
    public static String xc = "PassThrough";
    private static String xd = "SingleFragment";
    private Fragment xe;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!h.isInitialized()) {
            w.E(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            h.Q(getApplicationContext());
        }
        setContentView(e.com_facebook_activity_layout);
        if (xc.equals(intent.getAction())) {
            iO();
        } else {
            this.xe = getFragment();
        }
    }

    protected Fragment getFragment() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(xd);
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        if ("FacebookDialogFragment".equals(intent.getAction())) {
            findFragmentByTag = new g();
            findFragmentByTag.setRetainInstance(true);
            findFragmentByTag.show(supportFragmentManager, xd);
            return findFragmentByTag;
        } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
            findFragmentByTag = new a();
            findFragmentByTag.setRetainInstance(true);
            findFragmentByTag.a((com.facebook.share.a.a) intent.getParcelableExtra(b.CONTENT));
            findFragmentByTag.show(supportFragmentManager, xd);
            return findFragmentByTag;
        } else {
            findFragmentByTag = new h();
            findFragmentByTag.setRetainInstance(true);
            supportFragmentManager.beginTransaction().add(d.com_facebook_fragment_container, findFragmentByTag, xd).commit();
            return findFragmentByTag;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.xe != null) {
            this.xe.onConfigurationChanged(configuration);
        }
    }

    public Fragment iN() {
        return this.xe;
    }

    private void iO() {
        setResult(0, s.a(getIntent(), null, s.i(s.g(getIntent()))));
        finish();
    }
}
