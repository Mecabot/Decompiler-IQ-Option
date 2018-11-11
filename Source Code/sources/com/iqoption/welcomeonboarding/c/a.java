package com.iqoption.welcomeonboarding.c;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.iqoption.app.IQApp;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature;
import com.iqoption.d.ue;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.entity.result.OnlineCountResult;
import com.iqoption.mobbtech.connect.RequestManager;
import com.iqoption.mobbtech.connect.request.a.a.h;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.util.bg;
import com.iqoption.x.R;

/* compiled from: OnboardingFragment */
public class a extends Fragment implements d {
    private static final String TAG = "com.iqoption.welcomeonboarding.c.a";
    private int aVD = 0;
    private final int bcT = 5000;
    private boolean dLG;
    private ue dLZ;
    @Nullable
    private a dMa;
    private Handler dMb = new Handler();
    private Runnable dMc = new Runnable() {
        public void run() {
            a.this.aKX();
        }
    };
    private com.iqoption.mobbtech.connect.a.b<OnlineCountResult> dMd = new com.iqoption.mobbtech.connect.a.b<OnlineCountResult>() {
        public void a(g gVar) {
        }

        /* renamed from: a */
        public void onSuccess(OnlineCountResult onlineCountResult) {
            if (a.this.isAdded() && onlineCountResult != null && onlineCountResult.result != null && onlineCountResult.result.online != null) {
                a.this.aVD = onlineCountResult.result.online.intValue();
                if (a.this.aVD > 5000) {
                    a.this.dLZ.bGw.s(a.this.aVD, 1, ChartTimeInterval.CANDLE_15m);
                    a.this.ht(500);
                } else {
                    a.this.dLZ.bGx.animate().alpha(0.0f).setListener(new com.iqoption.view.a.a.c(a.this.dLZ.bGx)).start();
                }
                a.this.dMb.postDelayed(a.this.dMc, 3000);
            }
        }
    };

    /* compiled from: OnboardingFragment */
    /* renamed from: com.iqoption.welcomeonboarding.c.a$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] dMg = new int[WelcomeScreenFeature.values().length];

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:5:0x001f, code:
            return;
     */
        static {
            /*
            r0 = com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature.values();
            r0 = r0.length;
            r0 = new int[r0];
            dMg = r0;
            r0 = dMg;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature.welcome1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = dMg;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.iqoption.core.ui.viewmodel.welcome.WelcomeScreenFeature.welcome2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.welcomeonboarding.c.a.4.<clinit>():void");
        }
    }

    /* compiled from: OnboardingFragment */
    public interface a {
        void aKE();

        void aKF();
    }

    /* compiled from: OnboardingFragment */
    static abstract class c implements OnPageChangeListener {
        private float dMj = 0.0f;
        private int scrollDirection = 0;

        abstract void a(int i, float f, int i2);

        c() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            float f2 = ((float) i) + f;
            if (f2 > this.dMj) {
                this.scrollDirection = 0;
            } else if (f2 < this.dMj) {
                this.scrollDirection = 1;
            }
            this.dMj = f2;
            a(i, f, i2);
        }

        int aLa() {
            return this.scrollDirection;
        }
    }

    /* compiled from: OnboardingFragment */
    private static class b extends FragmentPagerAdapter {
        private Fragment[] dMh;
        private com.iqoption.welcomeonboarding.c.a.b[] dMi;

        b(FragmentManager fragmentManager, com.iqoption.welcomeonboarding.c.a.b[] bVarArr) {
            super(fragmentManager);
            this.dMh = new Fragment[bVarArr.length];
            this.dMi = bVarArr;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Object instantiateItem = super.instantiateItem(viewGroup, i);
            this.dMh[i] = (Fragment) instantiateItem;
            return instantiateItem;
        }

        public Fragment getItem(int i) {
            if (this.dMh[i] == null) {
                this.dMh[i] = com.iqoption.welcomeonboarding.c.a.a.a(this.dMi[i], i);
            }
            return this.dMh[i];
        }

        public int getCount() {
            return this.dMi.length;
        }
    }

    /* compiled from: OnboardingFragment */
    private class d extends c {
        private final String TAG;
        private int dMk;

        public void onPageScrollStateChanged(int i) {
        }

        private d() {
            this.TAG = d.class.getName();
            this.dMk = -1;
        }

        /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a(int i, float f, int i2) {
            b(i, f, aLa());
        }

        public void onPageSelected(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("position: ");
            stringBuilder.append(i);
            i.d("hell_selected", stringBuilder.toString());
            b bVar = (b) a.this.dLZ.bGy.getAdapter();
            ((e) bVar.getItem(i)).aLb();
            if (!(this.dMk == -1 || this.dMk == i)) {
                ((e) bVar.getItem(this.dMk)).aLc();
            }
            this.dMk = i;
            a.this.dLZ.bGv.getChildAt(i).setAlpha(1.0f);
        }

        private void b(int i, float f, int i2) {
            b bVar = (b) a.this.dLZ.bGy.getAdapter();
            if (i != bVar.getCount() - 1) {
                switch (i2) {
                    case 0:
                        i2 = i + 1;
                        break;
                    case 1:
                        f = 1.0f - f;
                        i2 = i;
                        i++;
                        break;
                    default:
                        String str = this.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown scroll direction: ");
                        stringBuilder.append(i2);
                        i.e(str, stringBuilder.toString());
                        return;
                }
                Fragment item = bVar.getItem(i);
                Fragment item2 = bVar.getItem(i2);
                if (item instanceof e) {
                    ((e) item).c(f, 1);
                }
                if (item2 instanceof e) {
                    ((e) item2).c(f, 0);
                }
                View childAt = a.this.dLZ.bGv.getChildAt(i);
                View childAt2 = a.this.dLZ.bGv.getChildAt(i2);
                double d = ((double) f) * 0.8d;
                childAt.setAlpha((float) (1.0d - d));
                childAt2.setAlpha((float) (d + 0.2d));
            }
        }
    }

    public static a kk(String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create welcome fragment, feature=");
        stringBuilder.append(str);
        i.d(str2, stringBuilder.toString());
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_FEATURE_NAME", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.dMa = (a) context;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.dLZ = (ue) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_welcome_onboarding, viewGroup, false);
        this.dLZ.a(this);
        return this.dLZ.getRoot();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        WelcomeScreenFeature welcomeScreenFeature;
        if (getArguments() == null) {
            welcomeScreenFeature = WelcomeScreenFeature.welcome2;
        } else {
            welcomeScreenFeature = WelcomeScreenFeature.valueOf(getArguments().getString("ARG_FEATURE_NAME", WelcomeScreenFeature.welcome2.name()));
        }
        a(welcomeScreenFeature);
        this.dMb.post(this.dMc);
        if (bundle == null && !this.dLG) {
            bg.a(this.dLZ.getRoot(), new b(this));
        }
    }

    final /* synthetic */ void aKY() {
        this.dLG = true;
        this.dLZ.bGv.setTranslationY(700.0f);
        this.dLZ.bGt.setTranslationY(700.0f);
        this.dLZ.bGs.setTranslationY(700.0f);
        new Handler().postDelayed(new c(this), 1100);
    }

    final /* synthetic */ void aKZ() {
        TimeInterpolator decelerateInterpolator = new DecelerateInterpolator(1.5f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dLZ.bGv, "translationY", new float[]{700.0f, 0.0f}).setDuration(200);
        duration.setInterpolator(decelerateInterpolator);
        duration.start();
        duration = ObjectAnimator.ofFloat(this.dLZ.bGt, "translationY", new float[]{700.0f, 0.0f}).setDuration(200);
        duration.setInterpolator(decelerateInterpolator);
        duration.start();
        duration = ObjectAnimator.ofFloat(this.dLZ.bGs, "translationY", new float[]{700.0f, 0.0f}).setDuration(200);
        duration.setInterpolator(decelerateInterpolator);
        duration.start();
    }

    public void onDestroyView() {
        this.dMb.removeCallbacksAndMessages(this.dMc);
        this.dLZ.unbind();
        super.onDestroyView();
    }

    public void ct(View view) {
        if (this.dMa != null) {
            this.dMa.aKE();
        }
    }

    public void cu(View view) {
        if (this.dMa != null) {
            this.dMa.aKF();
        }
    }

    public com.iqoption.welcomeonboarding.c.a.a aKV() {
        return (this.dLZ == null || this.dLZ.bGy.getAdapter() == null) ? null : (com.iqoption.welcomeonboarding.c.a.a) ((b) this.dLZ.bGy.getAdapter()).getItem(this.dLZ.bGy.getCurrentItem());
    }

    private void a(WelcomeScreenFeature welcomeScreenFeature) {
        if (this.dLZ != null) {
            if (this.dLZ.bGy.getAdapter() == null) {
                com.iqoption.welcomeonboarding.c.a.b[] b = b(welcomeScreenFeature);
                if (b.length != 0) {
                    hu(b.length);
                    this.dLZ.bGy.setAdapter(new b(getChildFragmentManager(), b));
                    this.dLZ.bGy.addOnPageChangeListener(new d(this, null));
                } else {
                    return;
                }
            }
            if (com.iqoption.fragment.a.a.isAvailable()) {
                aKW();
            }
        }
    }

    private void aKW() {
        this.dLZ.bGu.setVisibility(0);
        this.dLZ.bGu.setOnTouchListener(new com.iqoption.view.d.d());
        this.dLZ.bGu.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.zzakw().getSupportFragmentManager().beginTransaction().add(R.id.content, com.iqoption.fragment.a.b.akV(), "DebugMenuFragment").addToBackStack("DebugMenuFragment").commit();
            }
        });
    }

    private void ht(int i) {
        if (this.aVD > 5000 && this.dLZ.bGx.getVisibility() == 8) {
            this.dLZ.bGx.setAlpha(0.0f);
            this.dLZ.bGx.setVisibility(0);
            this.dLZ.bGx.animate().setDuration((long) i).alpha(1.0f).setListener(null).start();
        }
    }

    private void aKX() {
        String in = IQApp.Dl().in("api/users-stat");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(in);
        stringBuilder.append("api/users-stat");
        new h(OnlineCountResult.class, RequestManager.a(stringBuilder.toString(), null, zzakw()), this.dMd, "api/users-stat").auF();
    }

    private void hu(int i) {
        this.dLZ.bGv.removeAllViews();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp6);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dp6);
        for (int i2 = 0; i2 < i; i2++) {
            View view = new View(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            if (i2 != 0) {
                layoutParams.setMargins(dimensionPixelSize2, 0, 0, 0);
            }
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.drawable.onboarding_screen_dot_bg);
            view.setAlpha(0.2f);
            this.dLZ.bGv.addView(view);
        }
    }

    private com.iqoption.welcomeonboarding.c.a.b[] b(WelcomeScreenFeature welcomeScreenFeature) {
        if (AnonymousClass4.dMg[welcomeScreenFeature.ordinal()] != 1) {
            return new com.iqoption.welcomeonboarding.c.a.b[]{new com.iqoption.welcomeonboarding.c.a.b("logo_showing.json", getString(R.string.welcome_to_iq_option), getString(R.string.swipe_to_learn_more)), new com.iqoption.welcomeonboarding.c.a.b("forex.json", getString(R.string.forex), getString(R.string.multiplier_up_to)), new com.iqoption.welcomeonboarding.c.a.b("crypto.json", getString(R.string.cryptocurrency), getString(R.string.invest_in_top_crypto)), new com.iqoption.welcomeonboarding.c.a.b("cfd.json", getString(R.string.cfd), getString(R.string.trade_stocks_of_industry)), new com.iqoption.welcomeonboarding.c.a.b("trading.json", getString(R.string.option_trading), getString(R.string.turbo_trading))};
        }
        boolean Dh = af.DX().Dh();
        com.iqoption.welcomeonboarding.c.a.b[] bVarArr = new com.iqoption.welcomeonboarding.c.a.b[5];
        bVarArr[0] = new com.iqoption.welcomeonboarding.c.a.b("logo_showing.json", getString(R.string.welcome_to_iq_option), getString(R.string.swipe_to_learn_more));
        bVarArr[1] = new com.iqoption.welcomeonboarding.c.a.b("market.json", getString(R.string.master_the_markets), getString(R.string.trade_forex));
        bVarArr[2] = new com.iqoption.welcomeonboarding.c.a.b("security.json", getString(R.string.account_security), getString(Dh ? R.string.funds_are_covered : R.string.__2_step_authentication));
        bVarArr[3] = new com.iqoption.welcomeonboarding.c.a.b("support.json", getString(R.string.__24_7_support), getString(R.string.trained_support_team));
        bVarArr[4] = new com.iqoption.welcomeonboarding.c.a.b("solutions.json", getString(R.string.cutting_edge_solutions), getString(R.string.smooth_charts));
        return bVarArr;
    }
}
