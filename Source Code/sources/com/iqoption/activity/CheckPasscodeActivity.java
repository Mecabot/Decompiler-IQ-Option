package com.iqoption.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.iqoption.core.d.a;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment.b;
import com.iqoption.x.R;

public class CheckPasscodeActivity extends AppCompatActivity implements b {
    private static final String TAG = "com.iqoption.activity.CheckPasscodeActivity";

    public void zu() {
    }

    public static void aG(Context context) {
        context.startActivity(new Intent(context, CheckPasscodeActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_passcode);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(16908290, PasscodeFragment.a(PasscodeScreen.passcodeVerificationOnLogin)).commit();
        }
    }

    public boolean a(PasscodeFragment passcodeFragment, PasscodeScreen passcodeScreen, long j) {
        if (!PasscodeFragment.b((Context) this, j)) {
            return false;
        }
        a.aSe.postDelayed(new Runnable() {
            public void run() {
                CheckPasscodeActivity.this.zv();
            }
        }, (long) PasscodeFragment.cvm);
        return true;
    }

    public void zt() {
        zv();
    }

    private void zv() {
        PasscodeFragment.bn(this);
        finish();
        zw();
    }

    private void zw() {
        startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }

    public void onBackPressed() {
        finish();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onStart() {
        super.onStart();
    }
}
