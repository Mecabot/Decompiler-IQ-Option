package com.iqoption.activity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.arch.lifecycle.LifecycleOwner;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Functions;
import com.google.common.base.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.analytics.EventManager;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.ui.navigation.g;
import com.iqoption.core.ui.viewmodel.welcome.FacebookAuthViewModel;
import com.iqoption.dialog.q;
import com.iqoption.dto.Event;
import com.iqoption.dto.ToastEntity;
import com.iqoption.dto.entity.BackCall;
import com.iqoption.dto.entity.Version;
import com.iqoption.dto.entity.Version.Android;
import com.iqoption.dto.entity.result.KycState;
import com.iqoption.fragment.MenuFragment;
import com.iqoption.fragment.MenuFragment.MenuItem;
import com.iqoption.fragment.account.security.AccountSecurityFragment;
import com.iqoption.fragment.account.security.touchId.PasscodeFragment;
import com.iqoption.fragment.ay;
import com.iqoption.fragment.cr;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.leftmenu.LeftMenuFragment;
import com.iqoption.fragment.leftmenu.LeftMenuViewModel;
import com.iqoption.fragment.leftpanel.LeftPanelViewModel;
import com.iqoption.gl.NativeHandler.p;
import com.iqoption.kyc.activity.KycBlockActivity;
import com.iqoption.kyc.activity.KycReportableErrorActivity;
import com.iqoption.kyc.h;
import com.iqoption.microservice.regulators.response.StatusType;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.protrader.web.ProTraderWebActivity;
import com.iqoption.protrader.web.ProTraderWebType;
import com.iqoption.service.WebSocketHandler;
import com.iqoption.system.IQFirebaseInstanceIDService;
import com.iqoption.tutorial.StepDoneType;
import com.iqoption.tutorial.TutorialViewModel;
import com.iqoption.tutorial.dictionary.TutorialAction;
import com.iqoption.util.Network;
import com.iqoption.util.ac;
import com.iqoption.util.ag;
import com.iqoption.util.ar;
import com.iqoption.util.be;
import com.iqoption.util.k;
import com.iqoption.util.v;
import com.iqoption.view.SplashView;
import com.iqoption.view.f;
import com.iqoption.vip.j;
import com.iqoption.withdrawal.common.WithdrawActivity;
import com.iqoption.x.R;
import io.card.payment.BuildConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TradeRoomActivity extends d implements com.iqoption.core.ui.navigation.a, com.iqoption.fragment.leftmenu.LeftMenuFragment.b, com.iqoption.system.a, com.iqoption.view.e, com.iqoption.vip.c.b {
    private static final String TAG = "com.iqoption.activity.TradeRoomActivity";
    public static final String adX;
    public static final String adY;
    public static final String adZ;
    public static final String aea;
    private final BroadcastReceiver aeA = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            TradeRoomActivity.this.zI();
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            Query query = new Query();
            query.setFilterById(new long[]{intent.getExtras().getLong("extra_download_id")});
            Cursor query2 = downloadManager.query(query);
            if (query2.moveToFirst() && query2.getInt(query2.getColumnIndex(NotificationCompat.CATEGORY_STATUS)) == 8) {
                try {
                    intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(FileProvider.getUriForFile(context, "com.iqoption.x.provider", new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "update.apk")), "application/vnd.android.package-archive");
                    intent.addFlags(1);
                    context.startActivity(intent);
                } catch (Throwable e) {
                    i.d(e.getMessage());
                    k.c(e);
                }
            }
        }
    };
    private cr aeb;
    private boolean aec;
    private boolean aed;
    private boolean aee;
    private boolean aef;
    private boolean aeg;
    public LeftMenuFragment aeh;
    private SplashView aei;
    private ViewGroup aej;
    private ViewGroup aek;
    private View ael;
    private View aem;
    private final f aen = new f();
    private boolean aeo;
    private PopupViewModel aep;
    @Nullable
    private TutorialViewModel aeq;
    @Nullable
    private com.iqoption.tutorial.e aer;
    private boolean aes = true;
    @NonNull
    private final a aet = new a(this);
    private io.reactivex.disposables.b aeu;
    @NonNull
    private Runnable aev = new e(this);
    private g aew = new g();
    private boolean aex = false;
    private LeftMenuViewModel aey;
    private q aez;
    @NonNull
    private Handler handler = new Handler();

    private static class b extends AnimatorListenerAdapter {
        private static final Property<b, Float> aeI = new Property<b, Float>(Float.class, NotificationCompat.CATEGORY_PROGRESS) {
            /* renamed from: a */
            public void set(b bVar, Float f) {
                bVar.jg = f.floatValue();
            }

            /* renamed from: c */
            public Float get(b bVar) {
                return Float.valueOf(bVar.jg);
            }
        };
        @NonNull
        private final View aeJ;
        @NonNull
        private final n<Animator> aeK;
        @NonNull
        private final n<Animator> aeL;
        @NonNull
        private final AnimatorListener aeM = new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                b.this.aeJ.setVisibility(0);
            }

            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                b.this.aeO = null;
            }
        };
        @NonNull
        private final AnimatorListener aeN = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                b.this.aeJ.setVisibility(8);
                b.this.aeO = null;
            }
        };
        @Nullable
        private Animator aeO;
        private boolean aeP;
        private float jg;

        b(@NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull LeftMenuFragment leftMenuFragment) {
            this.aeJ = view3;
            this.aeK = new v(this, view, view2, leftMenuFragment);
            this.aeL = new w(this, view, view2, leftMenuFragment);
        }

        final /* synthetic */ Animator b(@NonNull View view, @NonNull View view2, @NonNull LeftMenuFragment leftMenuFragment) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, aeI, new float[]{1.0f});
            Animator a = com.iqoption.activity.a.a.a(view, view2);
            Animator a2 = com.iqoption.fragment.leftmenu.d.a(leftMenuFragment, view.getHeight());
            Animator animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, a, a2});
            animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            return animatorSet;
        }

        final /* synthetic */ Animator a(@NonNull View view, @NonNull View view2, @NonNull LeftMenuFragment leftMenuFragment) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, aeI, new float[]{0.0f});
            Animator b = com.iqoption.activity.a.a.b(view, view2);
            Animator b2 = com.iqoption.fragment.leftmenu.d.b(leftMenuFragment, view.getHeight());
            Animator animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, b, b2});
            animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TI());
            return animatorSet;
        }

        private long AD() {
            return (long) Math.round((1.0f - this.jg) * 700.0f);
        }

        private long AE() {
            return (long) Math.round(this.jg * 500.0f);
        }

        void ar(boolean z) {
            if (this.aeP != z) {
                Animator animator;
                if (this.aeO != null) {
                    this.aeO.cancel();
                }
                this.aeP = z;
                if (z) {
                    animator = (Animator) this.aeK.get();
                    animator.cancel();
                    animator.setDuration(AD());
                    animator.addListener(this.aeM);
                } else {
                    animator = (Animator) this.aeL.get();
                    animator.cancel();
                    animator.setDuration(AE());
                    animator.addListener(this.aeN);
                }
                animator.start();
            }
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeAllListeners();
            this.aeO = null;
        }
    }

    private static class a extends com.iqoption.system.a.e<FragmentActivity> {
        public a(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @com.google.common.b.e
        public void onTapTimeScaleBar(p pVar) {
            com.iqoption.core.d.a.aSe.execute(new u(this));
        }

        final /* synthetic */ void AC() {
            FragmentActivity fragmentActivity = (FragmentActivity) this.drU.get();
            if (fragmentActivity != null && !fragmentActivity.isDestroyed()) {
                TutorialViewModel.D(fragmentActivity).a(TutorialAction.TIME_SCALE, StepDoneType.TAP_ON_TARGET);
            }
        }
    }

    private static class c extends com.iqoption.system.c.b<TradeRoomActivity, com.iqoption.core.microservices.billing.response.b.a> {
        public c(TradeRoomActivity tradeRoomActivity) {
            super((Object) tradeRoomActivity);
        }

        /* renamed from: b */
        public void z(@NonNull TradeRoomActivity tradeRoomActivity, @NonNull com.iqoption.core.microservices.billing.response.b.a aVar) {
            super.z(tradeRoomActivity, aVar);
            tradeRoomActivity.aei.hide();
            tradeRoomActivity.a(aVar);
        }

        /* renamed from: a */
        public void c(@NonNull TradeRoomActivity tradeRoomActivity, Throwable th) {
            super.c(tradeRoomActivity, th);
            tradeRoomActivity.aei.hide();
        }
    }

    private class d extends com.iqoption.system.c.b<TradeRoomActivity, Version> {
        private final boolean aeU;

        public d(TradeRoomActivity tradeRoomActivity, boolean z) {
            super(tradeRoomActivity, Version.class);
            this.aeU = z;
        }

        /* renamed from: a */
        public void z(@NonNull TradeRoomActivity tradeRoomActivity, @NonNull Version version) {
            super.z(tradeRoomActivity, version);
            Android android = version.getAndroid();
            if (android != null) {
                try {
                    boolean z = false;
                    int i = tradeRoomActivity.getPackageManager().getPackageInfo(tradeRoomActivity.getPackageName(), 0).versionCode;
                    if (i < android.getMin().intValue()) {
                        z = true;
                    }
                    if (i < android.getCurrent().intValue()) {
                        v.a(tradeRoomActivity, z, android.getPath());
                    } else if (this.aeU) {
                        v.c(tradeRoomActivity, android.getPath());
                    }
                } catch (Throwable e) {
                    i.d(TradeRoomActivity.TAG, e);
                }
            }
        }
    }

    private static class e extends com.iqoption.system.c.b<TradeRoomActivity, Void> {
        public e(TradeRoomActivity tradeRoomActivity) {
            super(tradeRoomActivity, Void.class);
        }

        /* renamed from: a */
        public void z(@NonNull TradeRoomActivity tradeRoomActivity, @NonNull Void voidR) {
            com.iqoption.app.a aL = com.iqoption.app.a.aL((Context) tradeRoomActivity);
            if (aL.Da()) {
                i.i(TradeRoomActivity.TAG, "Logout demo user. Demo flag is not supported anymore. See 47164 story for details");
                aL.aO(tradeRoomActivity);
                tradeRoomActivity.zZ();
                return;
            }
            tradeRoomActivity.Ae();
            com.iqoption.feed.a.cle.afH();
        }

        /* renamed from: a */
        public void c(TradeRoomActivity tradeRoomActivity, Throwable th) {
            com.iqoption.util.a.t(tradeRoomActivity);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TradeRoomActivity.class.getName());
        stringBuilder.append(".show_kyc_page");
        adX = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TradeRoomActivity.class.getName());
        stringBuilder.append(".SKIP_KYC");
        adY = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TradeRoomActivity.class.getName());
        stringBuilder.append(".SHOW_DEPOSIT_PAGE");
        adZ = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(TradeRoomActivity.class.getName());
        stringBuilder.append(".START_FROM_ACTIVITY");
        aea = stringBuilder.toString();
    }

    final /* synthetic */ void Aw() {
        this.aes = true;
        this.aeq.aFy();
    }

    private static Bundle T(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        return bundle;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(T(bundle));
        i.d("TradeRoomActivity onCreate");
        if (!Ac()) {
            setContentView((int) R.layout.main);
            FragmentManager.enableDebugLogging(false);
            if (bundle != null) {
                this.aeb = null;
            }
            zW();
            zU();
            zV();
            Ap();
            zY();
            ap(false);
            this.aep = PopupViewModel.j((FragmentActivity) this);
            this.aeq = TutorialViewModel.D(this);
            this.aer = new com.iqoption.tutorial.e(getSupportFragmentManager(), f.aeC, new m(this), new n(this), new o(this));
        }
    }

    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        this.aes = false;
        this.handler.removeCallbacks(this.aev);
        this.handler.postDelayed(this.aev, 3000);
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean zR() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        return supportFragmentManager != null && supportFragmentManager.findFragmentById(R.id.other_fragment) == null && zS() && !this.aep.isShowing() && this.aes;
    }

    private void a(@NonNull com.iqoption.tutorial.dictionary.b bVar) {
        com.iqoption.tutorial.c.a(getSupportFragmentManager(), (int) R.id.other_fragment, bVar);
    }

    private void a(@NonNull ToastEntity toastEntity) {
        cr zT = zT();
        if (zT != null) {
            zT.crz.f(toastEntity).aIn();
        }
    }

    @Nullable
    public cr getTradeFragment() {
        if (this.aeb == null) {
            cr crVar = (cr) getSupportFragmentManager().findFragmentByTag(cr.TAG);
            if (crVar != null) {
                this.aeb = crVar;
            }
        }
        return this.aeb;
    }

    private boolean zS() {
        cr zT = zT();
        return zT != null && zT.isResumed();
    }

    @Nullable
    private cr zT() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        return findFragmentById instanceof cr ? (cr) findFragmentById : null;
    }

    private void zU() {
        this.aei = (SplashView) findViewById(R.id.splashView);
        this.aei.setSharedState(getIntent().getParcelableExtra("com.iqoption.view.SplashView.extra.sharedState"));
        this.aei.show();
        this.aei.jX("-=Traderoom=-");
    }

    private void ap(boolean z) {
        if (!zJ()) {
            af aR = af.aR((Context) this);
            Object version = aR.getVersion();
            if (TextUtils.isEmpty(version)) {
                EventManager.Bm().b(new Event(Event.CATEGORY_SYSTEM, "M_First_open"));
                aR.ba(true);
            } else {
                aR.ba(false);
                if (version.equals(BuildConfig.PRODUCT_VERSION)) {
                    aR.aZ(false);
                } else {
                    aR.aZ(true);
                }
            }
            aR.setVersion(BuildConfig.PRODUCT_VERSION);
            String in = IQApp.Dl().in("api/getversion");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(in);
            stringBuilder.append("api/getversion");
            ag.b(new com.iqoption.mobbtech.connect.request.a.a.b(Version.class, RequestManager.a(stringBuilder.toString(), null, (Context) this), "api/getversion").auF(), new d(this, z));
        }
    }

    private void zV() {
        this.aej = (ViewGroup) findViewById(R.id.leftMenuFrame);
        this.aeh = (LeftMenuFragment) getSupportFragmentManager().findFragmentById(R.id.leftSlide);
        b bVar = new b(this.aek, this.ael, this.aej, this.aeh);
        this.aey = LeftMenuViewModel.k(this);
        ar.a(this.aey.alN(), (LifecycleOwner) this, new p(bVar));
    }

    private void zW() {
        this.aek = (ViewGroup) findViewById(R.id.fragmentRootFrame);
        this.ael = this.aek.findViewById(R.id.tradeRoomVeil);
        this.ael.setOnClickListener(new com.iqoption.view.d.b() {
            public void q(View view) {
                TradeRoomActivity.this.aey.close();
            }
        });
        this.aem = this.aek.findViewById(R.id.other_fragment);
    }

    private void zX() {
        com.iqoption.g.a aDm = WebSocketHandler.aDm();
        if (!aDm.isAuthorized()) {
            this.aei.show();
        }
        o.a(aDm.bE(TAG), new e(this), com.iqoption.core.d.a.aSe);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    private void zY() {
        /*
        r9 = this;
        r0 = r9.getIntent();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = "type";
        r0 = r0.getStringExtra(r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 1;
        r1 = r1 ^ r2;
        r9.aeg = r1;
        r1 = r9.aeg;
        if (r1 == 0) goto L_0x0041;
    L_0x001a:
        r1 = new com.google.gson.JsonObject;
        r1.<init>();
        r3 = "push_type";
        r4 = new com.google.gson.JsonPrimitive;
        r4.<init>(r0);
        r1.add(r3, r4);
        r0 = com.iqoption.analytics.EventManager.Bm();
        r3 = "system";
        r4 = "app-opened-by-push";
        r3 = com.iqoption.dto.Event.Builder(r3, r4);
        r1 = r3.setParameters(r1);
        r1 = r1.build();
        r0.a(r1);
    L_0x0041:
        r0 = r9.getIntent();
        r1 = adX;
        r3 = 0;
        r0 = r0.getBooleanExtra(r1, r3);
        r9.aec = r0;
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "isShowKycPage=";
        r1.append(r4);
        r4 = r9.aec;
        r1.append(r4);
        r1 = r1.toString();
        com.iqoption.core.i.d(r0, r1);
        r0 = r9.getIntent();
        r1 = adZ;
        r0 = r0.getBooleanExtra(r1, r3);
        r9.aee = r0;
        r0 = TAG;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "isShowDepositPage=";
        r1.append(r4);
        r4 = r9.aee;
        r1.append(r4);
        r1 = r1.toString();
        com.iqoption.core.i.d(r0, r1);
        r0 = r9.getIntent();
        r1 = adY;
        r0 = r0.getBooleanExtra(r1, r3);
        r9.aed = r0;
        r0 = r9.getIntent();
        r1 = aea;
        r0 = r0.getBooleanExtra(r1, r3);
        r9.aef = r0;
        r0 = r9.getIntent();
        r0 = com.iqoption.b.a.k(r9, r0);
        if (r0 == 0) goto L_0x01f8;
    L_0x00ac:
        r1 = com.iqoption.app.af.aR(r9);
        r4 = "retrack";
        r4 = r0.getQueryParameter(r4);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x00c6;
    L_0x00bc:
        r1.ez(r4);
        r4 = java.lang.System.currentTimeMillis();
        r1.ab(r4);
    L_0x00c6:
        r4 = r0.getHost();
        if (r4 == 0) goto L_0x01f8;
    L_0x00cc:
        r4 = r0.getHost();
        r5 = -1;
        r6 = r4.hashCode();
        r7 = -1194687765; // 0xffffffffb8ca82eb float:-9.656496E-5 double:NaN;
        r8 = 2;
        if (r6 == r7) goto L_0x0133;
    L_0x00db:
        r7 = -290756696; // 0xffffffffeeab67a8 float:-2.6523625E28 double:NaN;
        if (r6 == r7) goto L_0x0129;
    L_0x00e0:
        if (r6 == 0) goto L_0x011f;
    L_0x00e2:
        r7 = 101142; // 0x18b16 float:1.4173E-40 double:4.9971E-319;
        if (r6 == r7) goto L_0x0115;
    L_0x00e7:
        r7 = 1395379953; // 0x532bcef1 float:7.3791131E11 double:6.894092977E-315;
        if (r6 == r7) goto L_0x010b;
    L_0x00ec:
        r7 = 1548165862; // 0x5c4722e6 float:2.24207566E17 double:7.648955665E-315;
        if (r6 == r7) goto L_0x0101;
    L_0x00f1:
        r7 = 2020250018; // 0x786a91a2 float:1.9030488E34 double:9.9813613E-315;
        if (r6 == r7) goto L_0x00f7;
    L_0x00f6:
        goto L_0x013d;
    L_0x00f7:
        r6 = "fbretargeting";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x00ff:
        r4 = 0;
        goto L_0x013e;
    L_0x0101:
        r6 = "openasset";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x0109:
        r4 = 5;
        goto L_0x013e;
    L_0x010b:
        r6 = "newsfeed";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x0113:
        r4 = 4;
        goto L_0x013e;
    L_0x0115:
        r6 = "faq";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x011d:
        r4 = 3;
        goto L_0x013e;
    L_0x011f:
        r6 = "";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x0127:
        r4 = 6;
        goto L_0x013e;
    L_0x0129:
        r6 = "education";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x0131:
        r4 = 1;
        goto L_0x013e;
    L_0x0133:
        r6 = "aboutus";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x013d;
    L_0x013b:
        r4 = 2;
        goto L_0x013e;
    L_0x013d:
        r4 = -1;
    L_0x013e:
        switch(r4) {
            case 0: goto L_0x019b;
            case 1: goto L_0x0195;
            case 2: goto L_0x018a;
            case 3: goto L_0x017f;
            case 4: goto L_0x0173;
            case 5: goto L_0x0149;
            case 6: goto L_0x0145;
            default: goto L_0x0141;
        };
    L_0x0141:
        r0 = "other";
        goto L_0x01bd;
    L_0x0145:
        r0 = "empty";
        goto L_0x01bd;
    L_0x0149:
        r4 = "openasset";
        r5 = "asset";
        r5 = r0.getQueryParameter(r5);
        r6 = "type";
        r0 = r0.getQueryParameter(r6);
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 == 0) goto L_0x0164;
    L_0x015e:
        r6 = android.text.TextUtils.isEmpty(r0);
        if (r6 != 0) goto L_0x01bc;
    L_0x0164:
        r0 = com.iqoption.core.data.model.InstrumentType.fromServerValue(r0);
        r1.b(r0);
        r0 = java.lang.Integer.parseInt(r5);	 Catch:{ NumberFormatException -> 0x01bc }
        r1.cK(r0);	 Catch:{ NumberFormatException -> 0x01bc }
        goto L_0x01bc;
    L_0x0173:
        r0 = "newsfeed";
        r1 = com.iqoption.fragment.leftpanel.LeftPanelViewModel.l(r9);
        r4 = com.iqoption.fragment.leftpanel.b.f.cDS;
        r1.e(r4);
        goto L_0x01bd;
    L_0x017f:
        r0 = "faq";
        r1 = new com.iqoption.dialog.z;
        r1.<init>(r9);
        r1.show();
        goto L_0x01bd;
    L_0x018a:
        r0 = "aboutus";
        r1 = new com.iqoption.dialog.a;
        r1.<init>(r9);
        r1.show();
        goto L_0x01bd;
    L_0x0195:
        r0 = "education";
        r9.An();
        goto L_0x01bd;
    L_0x019b:
        r4 = "fbretargeting";
        r5 = "text";
        r5 = r0.getQueryParameter(r5);
        r6 = "promocode";
        r0 = r0.getQueryParameter(r6);
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 == 0) goto L_0x01b6;
    L_0x01b0:
        r6 = android.text.TextUtils.isEmpty(r0);
        if (r6 != 0) goto L_0x01bc;
    L_0x01b6:
        r1.eu(r0);
        r1.ev(r5);
    L_0x01bc:
        r0 = r4;
    L_0x01bd:
        r1 = com.iqoption.app.IQApp.aP(r9);
        r4 = new com.google.android.gms.analytics.HitBuilders$EventBuilder;
        r4.<init>();
        r5 = com.iqoption.app.a.aL(r9);
        r5 = r5.getUserId();
        r5 = (float) r5;
        r2 = r4.setCustomMetric(r2, r5);
        r2 = (com.google.android.gms.analytics.HitBuilders.EventBuilder) r2;
        r4 = "Android";
        r2 = r2.setCategory(r4);
        r4 = "AppLinks";
        r2 = r2.setAction(r4);
        r0 = r2.setLabel(r0);
        r2 = "&cid";
        r2 = r1.get(r2);
        r0 = r0.setCustomDimension(r8, r2);
        r0 = (com.google.android.gms.analytics.HitBuilders.EventBuilder) r0;
        r0 = r0.build();
        r1.send(r0);
    L_0x01f8:
        r0 = r9.getIntent();
        r1 = "wasLaunchedAfterCrash";
        r0 = r0.getBooleanExtra(r1, r3);
        r9.aex = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.activity.TradeRoomActivity.zY():void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (i != 82) {
            return onKeyDown;
        }
        if (!this.aep.isShowing()) {
            this.aey.toggle();
        }
        return true;
    }

    public void zZ() {
        i.d(TAG, "relogin");
        logout();
    }

    private void logout() {
        IQFirebaseInstanceIDService.bM(this);
        if (com.iqoption.app.a.aL((Context) this).CJ() == 4) {
            FacebookAuthViewModel.Zc();
        }
        WeakReference weakReference = new WeakReference(this);
        ag.a(ag.a(o.a(com.iqoption.microservice.authorization.a.aX(this), Aa()), Functions.y(null)), new q(weakReference), new r(weakReference));
    }

    private s<?> Aa() {
        return com.iqoption.core.d.a.aSc.i(new s(this));
    }

    static final /* synthetic */ void aJ(Context context) {
        com.iqoption.gl.b.aow().glchTabClearBets();
        com.iqoption.gl.b.aow().glchClearPositions();
        com.iqoption.gl.b.aow().glchClearOrders();
        com.iqoption.gl.b.aow().glchClearVisibleUnits();
        com.iqoption.app.a.aL(context).aM(context);
        af.aR(context).et("user");
        RequestManager.atO().atW();
        RequestManager.atO().atV();
        WebSocketHandler.aDm().aiM();
        com.iqoption.core.d.a.Uf();
        com.iqoption.mobbtech.connect.response.a.a.ava().onStop();
        com.iqoption.app.managers.a.Gf().clear();
        com.iqoption.app.managers.c.Gn().clear();
        com.iqoption.core.f.a.clear();
    }

    private void Ab() {
        ac.u(getSupportFragmentManager());
        startActivity(Intent.makeRestartActivityTask(getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent()));
        be.aGB();
    }

    public void onStart() {
        super.onStart();
        i.d(TAG, "onStart");
        registerReceiver(this.aeA, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        if (!Ac()) {
            zX();
            this.aet.register();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.aeu != null) {
            this.aeu.dispose();
            this.aeu = null;
        }
        WebSocketHandler.aDm().m(TAG, ToastEntity.ACTION_TOAST_DURATION);
        unregisterReceiver(this.aeA);
        this.aet.unregister();
        com.iqoption.feed.a.cle.afI();
    }

    public boolean Ac() {
        if (Network.dwp.aGr()) {
            return false;
        }
        OfflineActivity.l(this);
        finish();
        return true;
    }

    public void onPause() {
        super.onPause();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPause, isFinishing=");
        stringBuilder.append(isFinishing());
        stringBuilder.append(", isCheckPasscodeActivityStart=");
        stringBuilder.append(this.aeo);
        i.d(str, stringBuilder.toString());
        if (Aj() && !this.aeo) {
            PasscodeFragment.bn(this);
        }
        af.aR((Context) this).ai(System.currentTimeMillis());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        zY();
        if (this.aeb != null) {
            this.aeb.onNewIntent(intent);
        }
        if (this.aef || this.aeg) {
            this.aef = false;
            this.aeg = false;
            Ae();
        }
    }

    public void onResume() {
        super.onResume();
        i.d(TAG, "onResume");
        long Fj = af.aR((Context) this).Fj();
        if (Fj > 0) {
            af.aR((Context) this).aj(System.currentTimeMillis() - Fj);
        }
        if (!(Ac() || !Aj() || Ak())) {
            Ah();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResult requestCode:");
        stringBuilder.append(i);
        i.d(str, stringBuilder.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 101) {
            Bundle bundle;
            if (intent == null) {
                bundle = null;
            } else {
                bundle = intent.getExtras();
            }
            if (bundle != null && bundle.getString("RETURN_PARAM") != null && Objects.equals(bundle.getString("RETURN_PARAM"), "WHATS_NEW_DIALOG_TYPE_QUIZ")) {
                LeftPanelViewModel.l(this).e(com.iqoption.fragment.leftpanel.b.d.cDQ);
            }
        }
    }

    public void onDestroy() {
        i.d(TAG, "onDestroy, isRestart=");
        com.iqoption.core.d.a.aSe.removeCallbacksAndMessages(null);
        IQApp.Dl().bA(this);
        if (this.aei != null) {
            this.aei.hide();
        }
        this.handler.removeCallbacks(this.aev);
        if (!(this.aeq == null || this.aer == null)) {
            this.aeq.b(this.aer);
        }
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onConfigurationChanged ");
        stringBuilder.append(configuration);
        i.d(str, stringBuilder.toString());
        super.onConfigurationChanged(configuration);
        if (this.aeu != null) {
            this.aeu.dispose();
            this.aeu = null;
        }
        if (configuration.orientation == 1) {
            this.aeu = com.iqoption.core.h.i.Yo().c(new t(this), 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private boolean Ad() {
        if (!zK()) {
            return false;
        }
        i.d(TAG, "set SCREEN_ORIENTATION_SENSOR_LANDSCAPE");
        com.iqoption.core.h.i.Yp().q(new g(this));
        return true;
    }

    final /* synthetic */ void Au() {
        setRequestedOrientation(6);
    }

    public void Ae() {
        if (this.aee) {
            this.aee = false;
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                getIntent().getExtras().putBoolean(adZ, false);
            }
            Aq();
        } else if (KycState.isBlocked() && !this.aec && !com.iqoption.app.managers.feature.a.eW("kyc-block-real-trading-only")) {
            i.d(TAG, "open KYC");
            KycBlockActivity.aG(this);
        } else if (com.iqoption.kyc.c.bu(this) && !this.aec) {
            i.d(TAG, "open KYC US reportable error");
            Ai();
        }
        if (Aj() && !Ak()) {
            Ah();
        } else if (!h.bv(this) || this.aed) {
            i.d(TAG, "open trade room");
            Ag();
        } else {
            new com.iqoption.kyc.activity.KycActivity.a(this).start();
        }
        Af();
    }

    private void Af() {
        cr zT = zT();
        if (zT != null) {
            ag.b(zT.crH, new com.google.common.util.concurrent.n<Boolean>() {
                public void l(@NonNull Throwable th) {
                }

                /* renamed from: f */
                public void onSuccess(@Nullable Boolean bool) {
                    TradeRoomActivity.this.aeq.a(TradeRoomActivity.this.aer);
                }
            });
        } else {
            ac.a(getSupportFragmentManager(), new h(this), new i(this));
        }
    }

    public void Ag() {
        if (Aj() && !Ak()) {
            Ah();
        } else if (this.aeb == null || !this.aeb.isAdded()) {
            this.aei.show();
            this.aeb = cr.ahX();
            try {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, this.aeb, cr.TAG).commitNowAllowingStateLoss();
            } catch (Exception unused) {
            }
        } else {
            if (this.aeb.aim() || !this.aeb.ail()) {
                this.aei.hide();
            } else {
                com.iqoption.core.d.a.aSe.postDelayed(new j(this), 1000);
            }
            this.aeb.aif();
        }
    }

    final /* synthetic */ void At() {
        this.aei.hide();
    }

    private void Ah() {
        this.aeo = true;
        CheckPasscodeActivity.aG(this);
        finish();
    }

    public void Ai() {
        KycReportableErrorActivity.aG(this);
        finish();
    }

    private boolean Aj() {
        return af.aR(getApplicationContext()).EP() >= 0;
    }

    private boolean Ak() {
        af aR = af.aR(getApplicationContext());
        boolean z = false;
        if (aR.EP() < 0) {
            return false;
        }
        long EQ = aR.EQ() - System.currentTimeMillis();
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("left: ");
        stringBuilder.append(EQ);
        i.d(str, stringBuilder.toString());
        if (EQ > 0 && EQ <= ((long) PasscodeFragment.cvl)) {
            z = true;
        }
        return z;
    }

    public void Al() {
        AccountSecurityFragment.i(getSupportFragmentManager());
        this.aey.close();
    }

    public void a(@NonNull StatusType statusType) {
        if (statusType == StatusType.DECLINED) {
            ProTraderWebActivity.a(this, ProTraderWebType.APPLY);
        } else {
            com.iqoption.protrader.dialog.a.u(this);
        }
    }

    public void Am() {
        this.aei.show();
        com.iqoption.mobbtech.connect.response.a.a.ava().onStart();
        ag.b(com.iqoption.mobbtech.connect.response.a.a.ava().iM("openWithdrawal"), new c(this));
    }

    private void a(com.iqoption.core.microservices.billing.response.b.a aVar) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("openSessionIdWithdrawal ");
        stringBuilder.append(aVar);
        i.v(str, stringBuilder.toString());
        WithdrawActivity.start(this);
    }

    public void An() {
        ay.a(this, getSupportFragmentManager(), R.id.other_fragment);
    }

    public void a(MenuItem menuItem) {
        a(menuItem, new HashMap());
    }

    public void a(MenuItem menuItem, HashMap<String, Object> hashMap) {
        MenuFragment menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentByTag(MenuFragment.TAG);
        if (menuFragment == null) {
            Fragment menuFragment2 = new MenuFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", menuItem);
            bundle.putSerializable("params", hashMap);
            menuFragment2.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.other_fragment, menuFragment2).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(MenuFragment.TAG).commit();
            getSupportFragmentManager().executePendingTransactions();
        } else {
            menuFragment.b(menuItem);
        }
        this.aey.close();
    }

    public void onBackPressed() {
        if (!this.aew.onBackPressed()) {
            if (Boolean.TRUE.equals(this.aey.alN().getValue())) {
                this.aey.close();
            } else if (!this.aen.onBackPressed()) {
                if (this.aeb == null || !this.aeb.onBackPressed()) {
                    super.onBackPressed();
                }
            }
        }
    }

    public void Ao() {
        if (com.iqoption.app.a.aL(IQApp.Dk()).isAuthorized()) {
            if (this.aez == null) {
                this.aez = new q(this);
            }
            this.aez.show();
            return;
        }
        i.w(TAG, "relogin dialog is not shown, user is not authorized");
    }

    public void b(long j, int i) {
        MenuFragment menuFragment = (MenuFragment) getSupportFragmentManager().findFragmentByTag(MenuFragment.TAG);
        if (menuFragment != null) {
            menuFragment.b(j, i);
        }
    }

    private void Ap() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.mainParent);
        View findViewById = findViewById(R.id.fragment);
        if (viewGroup != null && findViewById != null) {
            viewGroup.requestTransparentRegion(findViewById);
        }
    }

    public void dP(String str) {
        cr tradeFragment = getTradeFragment();
        if (tradeFragment == null || !tradeFragment.cV(false)) {
            com.iqoption.deposit.i.c(this, str);
        } else {
            tradeFragment.cW(false);
        }
    }

    public void Aq() {
        b(null, null);
    }

    public void b(String str, Long l) {
        cr tradeFragment = getTradeFragment();
        if (tradeFragment == null || !tradeFragment.cV(false)) {
            com.iqoption.deposit.i.a(this, str, false, false, l);
        } else {
            tradeFragment.cW(false);
        }
    }

    public void a(com.iqoption.fragment.leftmenu.content.a aVar) {
        com.iqoption.fragment.leftmenu.a.a(aVar, this);
    }

    @Nullable
    public BackCall Ar() {
        return com.iqoption.app.managers.a.Gf().Gg();
    }

    public void zC() {
        if (this.aei != null) {
            this.aei.show();
        }
    }

    public void zB() {
        if (this.aei != null) {
            this.aei.hide();
        }
    }

    public void dQ(String str) {
        if (this.aei != null) {
            this.aei.log(str);
        }
    }

    public void a(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.a(aVar);
    }

    public void b(@NonNull com.iqoption.view.e.a aVar) {
        this.aen.b(aVar);
    }

    public void b(boolean z, int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        com.iqoption.feed.b bVar = (com.iqoption.feed.b) supportFragmentManager.findFragmentByTag(com.iqoption.feed.b.TAG);
        if (bVar != null) {
            bVar.onBackPressed();
        }
        this.aeq.b(this.aer);
        com.iqoption.fragment.a.a(supportFragmentManager, R.id.fragment, z, i);
        ac.a(getSupportFragmentManager(), new k(this), new l(this));
    }

    final /* synthetic */ void As() {
        this.aeq.a(this.aer);
    }

    public void a(long j, j jVar) {
        for (com.iqoption.vip.c.b a : ac.a(getSupportFragmentManager(), com.iqoption.vip.c.b.class)) {
            a.a(j, jVar);
        }
    }

    public void aq(boolean z) {
        ap(z);
    }

    protected void b(@NonNull com.iqoption.core.microservices.busapi.response.a aVar) {
        com.iqoption.gdpr.removal.a.b(this, aVar);
    }

    public void a(@NonNull com.iqoption.core.ui.navigation.b bVar) {
        this.aew.a(bVar);
    }

    public void b(@NonNull com.iqoption.core.ui.navigation.b bVar) {
        this.aew.b(bVar);
    }
}
