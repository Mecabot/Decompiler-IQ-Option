package com.iqoption.launcher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.activity.OfflineActivity;
import com.iqoption.activity.TradeRoomActivity;
import com.iqoption.activity.d;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature;
import com.iqoption.dto.ToastEntity;
import com.iqoption.microservice.authorization.AuthException;
import com.iqoption.microservice.configuration.g;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.quiz.m;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.service.e.h;
import com.iqoption.system.a.e;
import com.iqoption.util.MusicUtil;
import com.iqoption.util.Network;
import com.iqoption.util.ag;
import com.iqoption.verify.VerifyCardsActivity;
import com.iqoption.view.SplashView;
import com.iqoption.welcomeonboarding.WelcomeOnboardingActivity;
import com.iqoption.widget.helper.SplashLogHelper;
import com.iqoption.x.R;

public class LauncherActivity extends d {
    private static final String TAG = "com.iqoption.launcher.LauncherActivity";
    private SplashView aei;
    private final a cNF = new a(this);
    private final c cNG = new c(this);
    private LauncherViewModel cNH;

    public static class a extends e<LauncherActivity> {
        public a(LauncherActivity launcherActivity) {
            super(launcherActivity);
        }

        @com.google.common.b.e
        public void onApiConfigErrorEvent(g gVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    LauncherActivity launcherActivity = (LauncherActivity) a.this.drU.get();
                    if (launcherActivity != null) {
                        i.w(LauncherActivity.TAG, "relogin on ApiConfigErrorEvent");
                        launcherActivity.clear("api-config-error");
                    }
                }
            });
        }
    }

    private static class b extends com.iqoption.system.c.b<LauncherActivity, com.iqoption.b.b.a> {
        public b(LauncherActivity launcherActivity) {
            super(launcherActivity, com.iqoption.b.b.a.class);
        }

        /* renamed from: a */
        public void z(@NonNull LauncherActivity launcherActivity, com.iqoption.b.b.a aVar) {
            super.z(launcherActivity, aVar);
            launcherActivity.aqA();
        }

        /* renamed from: a */
        public void c(@NonNull LauncherActivity launcherActivity, Throwable th) {
            super.c(launcherActivity, th);
            launcherActivity.aqA();
        }
    }

    private static class c extends com.iqoption.system.a.i<LauncherActivity> {
        public c(LauncherActivity launcherActivity) {
            super(launcherActivity);
        }

        @com.google.common.b.e
        public void onShowRelogin(final h hVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    LauncherActivity launcherActivity = (LauncherActivity) c.this.drU.get();
                    if (launcherActivity != null && !launcherActivity.isDestroyed()) {
                        launcherActivity.clear(hVar.reason);
                        launcherActivity.aqB();
                    }
                }
            });
        }
    }

    protected void b(@NonNull com.iqoption.core.microservices.busapi.response.a aVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.v(TAG, "onCreate");
        this.cNH = LauncherViewModel.q(this);
        if (!Network.dwp.aGr()) {
            OfflineActivity.l(this);
            finish();
        } else if (v(getIntent())) {
            finish();
        } else {
            setContentView((int) R.layout.activity_launcher);
            this.aei = (SplashView) findViewById(R.id.splashView);
            SplashLogHelper.cg(this);
            MusicUtil.v(this);
            this.cNF.register();
            this.cNG.register();
            ag.b(((com.iqoption.b.a) IQApp.Dk().akP.get()).Jc(), new b(this));
        }
    }

    private boolean v(Intent intent) {
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return false;
        }
        CharSequence string = extras.getString(Param.TYPE);
        if (TextUtils.isEmpty(string) || !"39".equals(string)) {
            return false;
        }
        Object string2 = extras.getString("link");
        if (!TextUtils.isEmpty(string2)) {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string2)));
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
    }

    private void aqx() {
        Uri data = getIntent().getData();
        if (data != null && "https".equals(data.getScheme())) {
            String path = data.getPath();
            Object obj = -1;
            int hashCode = path.hashCode();
            if (hashCode != -2044725737) {
                if (hashCode == 1905526730 && path.equals("/verification")) {
                    obj = null;
                }
            } else if (path.equals("/verify-bank-cards")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    aqy();
                    break;
                case 1:
                    if (com.iqoption.app.managers.feature.a.HR()) {
                        VerifyCardsActivity.start(this);
                        break;
                    }
                    break;
            }
        }
    }

    private void aqy() {
        this.cNH.aqD().observe(this, new a(this));
    }

    final /* synthetic */ void p(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            new com.iqoption.kyc.activity.KycActivity.a(this).ic(com.iqoption.kyc.fragment.jumio.e.TAG).start();
        }
    }

    private void aqz() {
        Uri k = com.iqoption.b.a.k(this, getIntent());
        if (k != null && "iqoption".equals(k.getScheme())) {
            String uri = k.toString();
            if (uri.contains("quiz/")) {
                Object queryParameter = k.getQueryParameter("code");
                com.iqoption.quiz.a.a.did.jf(queryParameter);
                if (!TextUtils.isEmpty(queryParameter)) {
                    m.ayY().azk().edit().putString("QUIZ_REFCODE_WHEN_INSTALL", queryParameter).apply();
                }
            } else if (uri.contains("openquiz")) {
                com.iqoption.quiz.a.a.did.azX();
                m.ayY().azk().edit().putBoolean("QUIZ_OPEN_FROM_LANDING", true).apply();
            }
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        i.v(TAG, "onNewIntent");
    }

    protected void onStart() {
        super.onStart();
        i.v(TAG, "onStart");
    }

    protected void onStop() {
        super.onStop();
        i.v(TAG, "onStop");
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
    }

    protected void onDestroy() {
        this.cNF.unregister();
        this.cNG.unregister();
        super.onDestroy();
    }

    private void aqA() {
        com.appsflyer.h.fA().e((Activity) this);
        aqz();
        if (com.iqoption.c.g.JD()) {
            o.a(bx(this), new com.iqoption.system.c.b<LauncherActivity, Void>(this, Void.class) {
                /* renamed from: a */
                public void z(@NonNull LauncherActivity launcherActivity, @NonNull Void voidR) {
                    super.z(launcherActivity, voidR);
                    i.v(LauncherActivity.TAG, "tokenLoginRequest onSuccess");
                    launcherActivity.aqC();
                    launcherActivity.aqx();
                }

                /* renamed from: a */
                public void c(@NonNull LauncherActivity launcherActivity, Throwable th) {
                    StringBuilder stringBuilder;
                    super.c(launcherActivity, th);
                    i.v(LauncherActivity.TAG, "tokenLoginRequest onFailure");
                    if (th instanceof AuthException) {
                        AuthException authException = (AuthException) th;
                        if (authException.status == 100 || authException.status == 101) {
                            String access$000 = LauncherActivity.TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("two step auth is required, phone mask=");
                            stringBuilder.append(authException.phoneMask);
                            i.i(access$000, stringBuilder.toString());
                            LauncherActivity.this.clear("two-step-auth");
                            launcherActivity.aqB();
                            return;
                        }
                    }
                    LauncherActivity launcherActivity2 = LauncherActivity.this;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("platform-initialize-error ");
                    stringBuilder.append(th.getMessage());
                    launcherActivity2.clear(stringBuilder.toString());
                    launcherActivity.aqB();
                }
            }, com.iqoption.core.d.a.aSe);
        } else {
            o.a(bw((Context) this), new com.iqoption.system.c.b<LauncherActivity, Boolean>(this, Boolean.class) {
                /* renamed from: a */
                public void z(@NonNull LauncherActivity launcherActivity, @NonNull Boolean bool) {
                    super.z(launcherActivity, bool);
                    i.v(LauncherActivity.TAG, "regulationRequest onSuccess");
                    launcherActivity.aqB();
                }

                /* renamed from: a */
                public void c(@NonNull LauncherActivity launcherActivity, Throwable th) {
                    super.c(launcherActivity, th);
                    i.v(LauncherActivity.TAG, "regulationRequest onFailure");
                    launcherActivity.aqB();
                }
            }, com.iqoption.core.d.a.aSe);
        }
    }

    @NonNull
    private static s<Boolean> bw(Context context) {
        i.v(TAG, "initUnAuthorized");
        return ag.a(ag.a(IQApp.Dl().bz(context), b.ari), c.ari);
    }

    @NonNull
    public static s<Void> bx(Context context) {
        i.v(TAG, "initAuthorized");
        s a = ag.a(IQApp.Dl().bz(context), d.ari);
        boolean ff = com.iqoption.app.managers.feature.b.HT().ff("force-use-autologin-token");
        if (!RequestManager.atO().atT() || (ff && com.iqoption.app.a.Cw().getUserId() != -1)) {
            i.v(TAG, "token");
            a = ag.a(ag.a(a, f.ari), Functions.y(Boolean.valueOf(true)));
        } else {
            i.v(TAG, "valid");
            a = ag.a(a, e.$instance);
        }
        return ag.a(o.a(ag.a(a, g.ari), h.ari), i.ari);
    }

    private void aqB() {
        i.v(TAG, "openWelcomeScreen");
        WelcomeScreenFeature HC = com.iqoption.app.managers.feature.a.HC();
        setRequestedOrientation(4);
        Intent a = WelcomeOnboardingActivity.a((Context) this, new com.iqoption.core.ui.viewmodel.welcome.b(HC));
        af.DX().eL(HC.name());
        a.addFlags(67174400);
        a.putExtra("com.iqoption.view.SplashView.extra.sharedState", this.aei.getSharedState());
        w(a);
        startActivity(a);
        com.iqoption.util.a.s(this);
        overridePendingTransition(0, 0);
    }

    public void onResume() {
        i.v(TAG, "onResume");
        super.onResume();
        this.aei.show();
        com.iqoption.app.managers.feature.b.HT().HU();
    }

    public void onPause() {
        i.v(TAG, "onPause");
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1001) {
            ((com.iqoption.b.a) IQApp.Dk().akP.get()).d(getApplication());
            if (iArr.length <= 0 || iArr[0] != 0) {
                i.w(TAG, "PHONE_STATE permission denied");
                IQApp.a("IMEI permission denied", null);
            } else {
                i.i(TAG, "PHONE_STATE permission granted");
                IQApp.a("IMEI permission granted", null);
            }
            ag.b(((com.iqoption.b.a) IQApp.Dk().akP.get()).Jc(), new b(this));
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void w(Intent intent) {
        Intent intent2 = getIntent();
        if (intent2 != null) {
            if (intent2.getExtras() != null) {
                intent.putExtras(intent2.getExtras());
            }
            if (intent2.getData() != null) {
                intent.setData(intent2.getData());
            }
        }
    }

    private void aqC() {
        i.v(TAG, "openTradeRoom");
        af.setLong("a63e971afa3e", System.currentTimeMillis());
        Intent intent = new Intent(this, TradeRoomActivity.class);
        intent.addFlags(65536);
        intent.putExtra("com.iqoption.view.SplashView.extra.sharedState", this.aei.getSharedState());
        w(intent);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tradeRoomIntent=");
        stringBuilder.append(intent);
        i.v(str, stringBuilder.toString());
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    private void clear(String str) {
        com.iqoption.core.d.a.Uf();
        com.iqoption.gl.b.aow().glchTabRemoveAllSmallDeals();
        com.iqoption.app.a.aL((Context) this).aM(this);
        RequestManager.atO().atW();
        RequestManager.atO().atV();
        com.iqoption.mobbtech.connect.response.a.a.ava().onStop();
        IQApp.Dl().bA(this);
        com.iqoption.fragment.b.b.aoi().onStop();
        af.aR((Context) this).et(str);
        m.ayY().azk().edit().putBoolean("PREF_REFCODE_WAS_USED", false).putString("QUIZ_REFCODE_WHEN_INSTALL", "").putBoolean("PREF_QUIZ_DISABLE_PROMO_CODE", false).apply();
    }
}
