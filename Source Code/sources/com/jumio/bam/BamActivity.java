package com.jumio.bam;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import com.jumio.MobileActivity;
import com.jumio.commons.log.Log;
import com.jumio.commons.view.CompatibilityLayer;
import com.jumio.core.data.Strings;
import com.jumio.sdk.models.CredentialsModel;
import java.util.ArrayList;
import jumio.bam.a;
import jumio.bam.af;
import jumio.bam.ag;
import jumio.bam.ah;
import jumio.bam.h;

public class BamActivity extends MobileActivity implements ah {
    private final Object a;
    private ArrayList<Fragment> b;
    private ag c;
    private BroadcastReceiver d;

    public void setUiAutomationString(String str) {
    }

    public BamActivity() {
        this.a = new Object();
        this.b = null;
        this.c = null;
        this.d = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.jumio.bam.CLOSE_SDK")) {
                    intent.setAction("");
                    int intExtra = intent.getIntExtra("com.jumio.bam.RESULT", 0);
                    intent.removeExtra("com.jumio.bam.RESULT");
                    BamActivity.this.setResult(intExtra, intent);
                    BamActivity.this.finish();
                }
            }
        };
        this.b = new ArrayList();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFinishOnTouchOutside(false);
        getWindow().addFlags(8192);
        setContentView(R.layout.activity_bam);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.d, a.a());
        if (bundle == null) {
            getIntent();
            Strings.setFactory(new h.a());
            startFragment(new af(), false, 0, 0);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeActionContentDescription(getString(R.string.jumio_accessibility_quit_scan));
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);
            Drawable drawable = CompatibilityLayer.getDrawable(getResources(), R.drawable.jumio_ic_clear);
            drawable.setColorFilter(typedValue.data, Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(drawable);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.a();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onBackPressed() {
        if (!(this.c != null ? this.c.onBackButtonPressed() : false)) {
            Object obj = 1;
            if (this.b.size() <= 1) {
                obj = null;
            }
            if (obj != null) {
                closeFragment(0, 0);
            } else {
                super.onBackPressed();
            }
        }
    }

    public void registerActivityCallback(ag agVar) {
        this.c = agVar;
    }

    public CredentialsModel getCredentials() {
        return super.getCredentialsModel();
    }

    public void startFragment(Fragment fragment, boolean z, int i, int i2) {
        synchronized (this.a) {
            if (isFinishing()) {
                return;
            }
            this.c = null;
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(i, i2);
            if (this.b.size() > 0) {
                Fragment fragment2 = (Fragment) this.b.get(this.b.size() - 1);
                if (z) {
                    this.b.remove(fragment2);
                }
                beginTransaction.detach(fragment2);
            }
            if (fragment != null) {
                beginTransaction.add(R.id.fragment_container, fragment);
                this.b.add(fragment);
            }
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }
    }

    public void closeFragment(int i, int i2) {
        synchronized (this.a) {
            if (isFinishing()) {
                return;
            } else if (this.b.size() == 0) {
                return;
            } else {
                Fragment fragment = (Fragment) this.b.get(this.b.size() - 1);
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.setCustomAnimations(i, i2);
                beginTransaction.remove(fragment);
                this.b.remove(fragment);
                if (this.b.size() > 0) {
                    beginTransaction.attach((Fragment) this.b.get(this.b.size() - 1));
                }
                try {
                    beginTransaction.commitAllowingStateLoss();
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                }
            }
        }
    }

    public void setUiAutomationId(int i) {
        findViewById(R.id.fragment_container).setContentDescription(getResources().getString(i));
    }
}
