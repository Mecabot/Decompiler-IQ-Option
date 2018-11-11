package com.iqoption.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.iqoption.analytics.EventManager;
import com.iqoption.core.i;
import com.iqoption.dto.Event;
import com.iqoption.dto.Event.Builder;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment.b;
import com.iqoption.fragment.account.security.touchId.a.a;
import com.iqoption.x.R;

public class SetPasscodeActivity extends AppCompatActivity implements b, a {
    private static final String TAG = "com.iqoption.activity.SetPasscodeActivity";
    public static final String adN;
    private static final String adO;
    private static final String adP;
    private static final String adQ;
    private PasscodeScreen adR;
    private long adS;
    private Builder adT;

    public void zt() {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".RESULT_PASSCODE");
        adN = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".ARG_PASSCODE_SCREEN");
        adO = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".KEY_LAST_PASSCODE_SCREEN");
        adP = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TAG);
        stringBuilder.append(".KEY_PASSCODE");
        adQ = stringBuilder.toString();
    }

    public static Intent a(Context context, PasscodeScreen passcodeScreen) {
        Intent intent = new Intent(context, SetPasscodeActivity.class);
        intent.putExtra(adO, passcodeScreen.name());
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        i.d(TAG, "onCreate()");
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_passcode);
        PasscodeScreen passcodeScreen = PasscodeScreen.newPasscode;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(adO)) {
            passcodeScreen = PasscodeScreen.valueOf(intent.getStringExtra(adO));
        }
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(16908290, PasscodeFragment.a(passcodeScreen), PasscodeFragment.TAG).commit();
        } else {
            if (bundle.getString(adO) != null) {
                this.adR = PasscodeScreen.valueOf(bundle.getString(adP));
            }
            this.adS = bundle.getLong(adQ);
        }
        this.adT = Event.Builder(Event.CATEGORY_POPUP_SERVED, "security-touch-id_set-passcode");
    }

    protected void onNewIntent(Intent intent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onNewIntent() ");
        stringBuilder.append(intent);
        i.d(str, stringBuilder.toString());
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            if (intent.hasExtra(adO)) {
                PasscodeScreen valueOf = PasscodeScreen.valueOf(intent.getStringExtra(adO));
                PasscodeFragment passcodeFragment = (PasscodeFragment) getSupportFragmentManager().findFragmentByTag(PasscodeFragment.TAG);
                if (passcodeFragment != null) {
                    passcodeFragment.b((Context) this, valueOf);
                    this.adR = valueOf;
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        i.d("onSaveInstanceState()");
        bundle.putLong(adQ, this.adS);
        bundle.putString(adP, this.adR.name());
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public void co(@StringRes int i) {
        i.d("showPasscodeErrorFragment()");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fast_fade_in, R.anim.fast_fade_out).replace(16908290, com.iqoption.fragment.account.security.touchId.a.hH(getString(i)), com.iqoption.fragment.account.security.touchId.a.TAG).commitNow();
    }

    /* JADX WARNING: Missing block: B:17:0x0086, code:
            r4 = 1;
     */
    /* JADX WARNING: Missing block: B:19:0x008f, code:
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:21:0x0091, code:
            return r4 ^ true;
     */
    public boolean a(com.iqoption.fragment.account.security.touchId.PasscodeFragment r4, com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen r5, long r6) {
        /*
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "onPasscodeEntered() passcodeScreen:";
        r0.append(r1);
        r0.append(r5);
        r1 = ", passcode:";
        r0.append(r1);
        r0.append(r6);
        r0 = r0.toString();
        com.iqoption.core.i.d(r0);
        r3.adR = r5;
        r0 = com.iqoption.activity.SetPasscodeActivity.AnonymousClass2.adW;
        r5 = r5.ordinal();
        r5 = r0[r5];
        r0 = 2131821318; // 0x7f110306 float:1.9275376E38 double:1.0532596763E-314;
        r1 = 1;
        switch(r5) {
            case 1: goto L_0x0088;
            case 2: goto L_0x006e;
            case 3: goto L_0x0066;
            case 4: goto L_0x004d;
            case 5: goto L_0x0041;
            case 6: goto L_0x002e;
            default: goto L_0x002d;
        };
    L_0x002d:
        goto L_0x008f;
    L_0x002e:
        r4 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.b(r3, r6);
        if (r4 == 0) goto L_0x0086;
    L_0x0034:
        r4 = com.iqoption.app.af.aR(r3);
        r5 = -1;
        r4.ae(r5);
        r3.O(r5);
        goto L_0x008f;
    L_0x0041:
        r5 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.b(r3, r6);
        if (r5 == 0) goto L_0x0086;
    L_0x0047:
        r5 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen.newPasscode;
        r4.b(r3, r5);
        goto L_0x008f;
    L_0x004d:
        r4 = r3.adS;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x005e;
    L_0x0053:
        r4 = com.iqoption.app.af.aR(r3);
        r4.ae(r6);
        r3.O(r6);
        goto L_0x008f;
    L_0x005e:
        r3.co(r0);
        r4 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen.newPasscode;
        r3.adR = r4;
        goto L_0x0086;
    L_0x0066:
        r3.adS = r6;
        r5 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen.repeatNewPasscode;
        r4.b(r3, r5);
        goto L_0x008f;
    L_0x006e:
        r4 = r3.adS;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 != 0) goto L_0x007f;
    L_0x0074:
        r4 = com.iqoption.app.af.aR(r3);
        r4.ae(r6);
        r3.O(r6);
        goto L_0x008f;
    L_0x007f:
        r3.co(r0);
        r4 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen.passcode;
        r3.adR = r4;
    L_0x0086:
        r4 = 1;
        goto L_0x0090;
    L_0x0088:
        r3.adS = r6;
        r5 = com.iqoption.fragment.account.security.touchId.PasscodeFragment.PasscodeScreen.repeatPasscode;
        r4.b(r3, r5);
    L_0x008f:
        r4 = 0;
    L_0x0090:
        r4 = r4 ^ r1;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.activity.SetPasscodeActivity.a(com.iqoption.fragment.account.security.touchId.PasscodeFragment, com.iqoption.fragment.account.security.touchId.PasscodeFragment$PasscodeScreen, long):boolean");
    }

    public void zu() {
        i.d("onExitPasscodeFragment()");
        zP();
    }

    public void onBackPressed() {
        i.d("onBackPressed()");
        zP();
    }

    public void zO() {
        i.d("onExitPasscodeErrorFragment()");
        zP();
    }

    public void zP() {
        i.d("exitCanceled()");
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().setValue(Double.valueOf(0.0d)).build());
        }
        setResult(0);
        finish();
    }

    public void O(final long j) {
        i.d("exitOk()");
        com.iqoption.core.d.a.aSe.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putLong(SetPasscodeActivity.adN, j);
                intent.putExtras(bundle);
                SetPasscodeActivity.this.setResult(-1, intent);
                SetPasscodeActivity.this.finish();
            }
        }, (long) PasscodeFragment.cvm);
        if (this.adT != null) {
            EventManager.Bm().a(this.adT.calcDuration().setValue(Double.valueOf(1.0d)).build());
        }
    }

    public void zQ() {
        i.d("onTryAgainPasscode()");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(17432576, 17432577).replace(16908290, PasscodeFragment.a(this.adR), PasscodeFragment.TAG).commitNow();
    }
}
