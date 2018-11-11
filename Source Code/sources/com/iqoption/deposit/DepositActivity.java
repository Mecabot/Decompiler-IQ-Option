package com.iqoption.deposit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.google.common.util.concurrent.s;
import com.iqoption.activity.d;
import com.iqoption.app.IQApp;
import com.iqoption.chat.ChatActivity;
import com.iqoption.core.i;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.dto.ToastEntity;
import com.iqoption.fragment.cashbox.deppage.e;
import com.iqoption.fragment.cashbox.j.f;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.util.ag;
import com.iqoption.view.SplashView;
import com.iqoption.x.R;
import java.util.ArrayList;

public class DepositActivity extends d implements com.iqoption.fragment.cashbox.a.a.a, com.iqoption.fragment.cashbox.deppage.d.a.a, e, com.iqoption.fragment.cashbox.i.a, f, com.iqoption.fragment.cashbox.k.a, com.iqoption.fragment.cashbox.l.a, com.iqoption.view.e {
    private static final String TAG = "com.iqoption.deposit.DepositActivity";
    private SplashView aei;
    private final com.iqoption.view.f aen = new com.iqoption.view.f();
    private final a bVj = new a(this);
    private final l bVk = new l(this);
    private boolean bVl;
    private boolean bVm;
    @Nullable
    private Long bVn;
    private final Runnable bVo = new f(this);

    public static class a extends com.iqoption.system.a.e<DepositActivity> {
        public a(DepositActivity depositActivity) {
            super(depositActivity);
        }
    }

    private static class b extends com.iqoption.system.c.b<DepositActivity, Void> {
        public b(DepositActivity depositActivity) {
            super(depositActivity, Void.class);
        }

        /* renamed from: a */
        public void z(@NonNull DepositActivity depositActivity, Void voidR) {
            super.z(depositActivity, voidR);
            com.iqoption.core.d.a.aSe.removeCallbacks(depositActivity.bVo);
            depositActivity.zB();
        }

        /* renamed from: a */
        public void c(@NonNull DepositActivity depositActivity, Throwable th) {
            super.c(depositActivity, th);
            com.iqoption.core.d.a.aSe.removeCallbacks(depositActivity.bVo);
            depositActivity.zB();
        }
    }

    public static void a(Activity activity, @Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, String str, boolean z, boolean z2, @Nullable Long l) {
        activity.startActivity(a(activity, arrayList, str, z, false, false, z2, l));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void a(Activity activity, @Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, @Nullable Long l) {
        activity.startActivity(a(activity, arrayList, null, true, true, false, false, l));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void a(Activity activity, String str, @Nullable Long l) {
        activity.startActivity(a(activity, null, str, true, false, true, false, l));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @NonNull
    private static Intent a(Activity activity, @Nullable ArrayList<com.iqoption.core.c.c.a> arrayList, String str, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Long l) {
        Intent intent = new Intent(activity, DepositActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ARG_DEFAULT_PRESET", arrayList);
        bundle.putString("ARG_CURRENCY", str);
        bundle.putBoolean("ARG_IS_RETURN_TO_PARENT", z);
        bundle.putBoolean("ARG_IS_3DS_DEPOSIT", z2);
        bundle.putBoolean("ARG_IS_CRYPTO_DEPOSIT", z3);
        bundle.putBoolean("ARG_IS_NEW_USER", z4);
        if (l != null) {
            bundle.putLong("ARG_PAYMENT_METHOD_ID", l.longValue());
        }
        intent.putExtras(bundle);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.v(TAG, "onCreate");
        setContentView((int) R.layout.activity_deposit);
        this.aei = (SplashView) findViewById(R.id.splashView);
        this.aei.setVisibility(8);
        this.bVj.register();
        com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
        Bundle extras = getIntent().getExtras();
        if (extras != null && bundle == null) {
            ArrayList parcelableArrayList = extras.getParcelableArrayList("ARG_DEFAULT_PRESET");
            String string = extras.getString("ARG_CURRENCY", "");
            this.bVl = extras.getBoolean("ARG_IS_RETURN_TO_PARENT");
            boolean z = extras.getBoolean("ARG_IS_3DS_DEPOSIT");
            boolean z2 = extras.getBoolean("ARG_IS_CRYPTO_DEPOSIT");
            this.bVm = extras.getBoolean("ARG_IS_NEW_USER");
            if (extras.containsKey("ARG_PAYMENT_METHOD_ID")) {
                this.bVn = Long.valueOf(extras.getLong("ARG_PAYMENT_METHOD_ID"));
            }
            this.bVk.a(parcelableArrayList, string, z, z2);
        }
        if (bundle == null) {
            IQApp.a("deposit_try", null);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        i.v(TAG, "onNewIntent");
    }

    protected void onStart() {
        super.onStart();
        i.v(TAG, "onStart");
        s bE = WebSocketHandler.aDm().bE(TAG);
        com.iqoption.core.d.a.aSe.postDelayed(this.bVo, 1000);
        ag.b(bE, new b(this));
    }

    protected void onStop() {
        com.iqoption.core.d.a.aSe.removeCallbacks(this.bVo);
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        super.onStop();
    }

    protected void onDestroy() {
        this.bVj.unregister();
        super.onDestroy();
    }

    public void Ag() {
        aar();
    }

    private void aar() {
        if (this.bVl) {
            com.iqoption.util.a.a(this, null);
            return;
        }
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.fade_out_short);
    }

    public boolean aas() {
        com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) this);
        return (aL.akz && !aL.akD) || !(!aL.akB || aL.akI || aL.akF);
    }

    public void zC() {
        this.aei.show();
    }

    public void zB() {
        this.aei.hide();
    }

    public void aat() {
        ChatActivity.a(this, null, ChatRoomType.SUPPORT);
    }

    public void onBackPressed() {
        if (this.aen.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                aar();
                overridePendingTransition(R.anim.slide_in_right, R.anim.fade_out_short);
            }
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName());
            if (!(findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.fragment.base.f) && ((com.iqoption.fragment.base.f) findFragmentByTag).aN())) {
                aar();
                overridePendingTransition(R.anim.slide_in_right, R.anim.fade_out_short);
            }
        }
    }

    public s<Boolean> a(PayMethod payMethod, c cVar, Double d, boolean z) {
        return this.bVk.a(payMethod, cVar, d, null, null, z);
    }

    public void e(boolean z, String str) {
        this.bVk.e(z, str);
    }

    public void aau() {
        this.bVk.aau();
    }

    public void aav() {
        this.bVk.aav();
    }

    public void cq(boolean z) {
        this.bVk.cq(z);
    }

    public void aaw() {
        this.bVk.aaw();
    }

    public void aax() {
        this.bVk.aax();
    }

    public void a(com.iqoption.mobbtech.connect.response.i iVar) {
        this.bVk.a(iVar);
    }

    public void aay() {
        this.bVk.aay();
    }

    public void b(com.iqoption.mobbtech.connect.response.i iVar) {
        this.bVk.b(iVar);
    }

    public void aaz() {
        this.bVk.aaz();
    }

    public boolean aaA() {
        return this.bVm;
    }

    @Nullable
    public Long aaB() {
        return this.bVn;
    }

    public void a(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.a(aVar);
    }

    public void b(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.b(aVar);
    }
}
