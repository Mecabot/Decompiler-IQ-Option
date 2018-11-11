package com.iqoption.withdrawal.crypto.barcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.vision.barcode.Barcode;
import com.iqoption.dto.ToastEntity;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.withdrawal.crypto.barcode.a.a;
import com.iqoption.x.R;

public class BarcodeActivity extends AppCompatActivity implements a {
    private static final String TAG = "com.iqoption.withdrawal.crypto.barcode.BarcodeActivity";

    @NonNull
    public static Intent aI(Context context) {
        return new Intent(context, BarcodeActivity.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_barcode);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add((int) R.id.barcodeFrame, a.l(true, false)).commit();
        }
    }

    protected void onStart() {
        super.onStart();
        WebSocketHandler.aDm().bE(TAG);
    }

    protected void onStop() {
        super.onStop();
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        PasscodeFragment.bn(this);
    }

    public void a(Barcode barcode) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_BARCODE", barcode);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
