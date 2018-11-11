package com.iqoption.kyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.google.common.util.concurrent.s;
import com.iqoption.core.i;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.fragment.MenuFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.kyc.f;
import com.iqoption.mobbtech.connect.response.MobbErrorException;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.system.c.b;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.x.R;

public class KycBlockActivity extends AppCompatActivity implements com.iqoption.kyc.fragment.a.a {
    private static final String TAG = "com.iqoption.kyc.activity.KycBlockActivity";
    private boolean cKq;
    private boolean cKr;

    private static class a extends b<KycBlockActivity, KycState> {
        public a(KycBlockActivity kycBlockActivity) {
            super((Object) kycBlockActivity);
        }

        /* renamed from: a */
        public void z(KycBlockActivity kycBlockActivity, KycState kycState) {
            super.z(kycBlockActivity, kycState);
            if (kycState != null) {
                new com.iqoption.kyc.activity.KycActivity.a(kycBlockActivity).d(kycState).start();
                kycBlockActivity.cKr = true;
                kycBlockActivity.finish();
            }
        }

        /* renamed from: a */
        public void c(KycBlockActivity kycBlockActivity, Throwable th) {
            super.c(kycBlockActivity, th);
            MobbErrorException.D(th);
        }
    }

    public static void aG(Context context) {
        context.startActivity(new Intent(context, KycBlockActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_kyc);
        if (bundle == null) {
            this.cKq = com.iqoption.app.managers.feature.b.HT().ff("kyc-back-on-block");
            getSupportFragmentManager().beginTransaction().add((int) R.id.kycFrame, com.iqoption.kyc.fragment.a.dT(this.cKq)).commit();
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

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        am.n(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack();
        } else if (this.cKq) {
            super.onBackPressed();
        } else {
            i.d(TAG, "ignore back");
        }
    }

    private void b(Fragment fragment, String str) {
        am.n(this);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_right, 17432579).add(R.id.kycFrame, fragment, str).addToBackStack(str).commitAllowingStateLoss();
    }

    public void apN() {
        i.v(TAG, "onBlockContactSupport");
        b(MenuFragment.ahz(), MenuFragment.TAG);
    }

    public s<?> apO() {
        s<?> aoR = new f(this).aoR();
        ag.b(aoR, new a(this));
        return aoR;
    }
}
