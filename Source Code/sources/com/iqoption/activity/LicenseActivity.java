package com.iqoption.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.x.R;

public class LicenseActivity extends AppCompatActivity {
    public static Intent aI(Context context) {
        return new Intent(context, LicenseActivity.class);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.license_activity);
        ((WebView) findViewById(R.id.content)).loadUrl("file:///android_asset/licenses.html");
    }

    protected void onPause() {
        super.onPause();
        PasscodeFragment.bn(this);
    }
}
