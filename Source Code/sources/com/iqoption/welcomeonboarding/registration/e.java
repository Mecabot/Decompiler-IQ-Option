package com.iqoption.welcomeonboarding.registration;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.d.ug;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.util.ag;
import com.iqoption.util.am;
import com.iqoption.welcomeonboarding.registration.country.g;
import com.iqoption.x.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\u0019H\u0014J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001dH\u0014J\b\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020+H\u0016J \u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020+2\u0006\u00104\u001a\u000202H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020-H\u0016J\b\u0010A\u001a\u00020-H\u0002J\b\u0010B\u001a\u00020-H\u0002J\b\u0010C\u001a\u00020-H\u0002J\u001a\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u0002062\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010F\u001a\u00020\u001dH\u0014J\b\u0010G\u001a\u00020HH\u0014J\b\u0010I\u001a\u00020'H\u0014J\b\u0010J\u001a\u00020'H\u0014J\b\u0010K\u001a\u000202H\u0014J\b\u0010L\u001a\u00020$H\u0014J\b\u0010M\u001a\u000202H\u0014J\b\u0010N\u001a\u00020'H\u0014R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068B@BX\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006P"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/RegistrationFragment;", "Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;", "Lcom/iqoption/welcomeonboarding/registration/currency/OnCurrencyClickListener;", "Lcom/iqoption/welcomeonboarding/registration/country/PreviewButtonProvider;", "()V", "<set-?>", "Lcom/iqoption/welcomeonboarding/registration/AnimatorFactory;", "animatorFactory", "getAnimatorFactory", "()Lcom/iqoption/welcomeonboarding/registration/AnimatorFactory;", "setAnimatorFactory", "(Lcom/iqoption/welcomeonboarding/registration/AnimatorFactory;)V", "animatorFactory$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/databinding/FragmentWelcomeRegistrationBinding;", "binding", "getBinding", "()Lcom/iqoption/databinding/FragmentWelcomeRegistrationBinding;", "setBinding", "(Lcom/iqoption/databinding/FragmentWelcomeRegistrationBinding;)V", "binding$delegate", "acceptTermsCheck", "Landroid/widget/CheckBox;", "ageCheckBox", "ageLayout", "Landroid/widget/LinearLayout;", "countryContainer", "Landroid/widget/FrameLayout;", "countryEdit", "Landroid/support/design/widget/TextInputEditText;", "countryInput", "Landroid/support/design/widget/TextInputLayout;", "countryLocationButton", "Landroid/widget/ImageView;", "countryLocationError", "countryProgress", "Landroid/support/v4/widget/ContentLoadingProgressBar;", "currencyContainer", "currencySpinnerTitle", "Landroid/widget/TextView;", "emailEdit", "getPreviewButton", "isTrialUser", "", "onBackButtonClick", "", "onBackPressed", "onCreateAnimator", "Landroid/animation/Animator;", "transit", "", "enter", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCurrencyClicked", "currency", "Lcom/iqoption/dto/Currencies$Currency;", "onCurrencyContainerClick", "onFacebookButtonClick", "onGoogleButtonClick", "onPreviewAppClick", "onViewCreated", "view", "passwordEdit", "passwordToggle", "Landroid/widget/ToggleButton;", "policyTextView", "registerButton", "registerButtonText", "registerProgress", "searchCountriesContainerId", "titleView", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RegistrationFragment.kt */
public final class e extends b implements g, com.iqoption.welcomeonboarding.registration.currency.f {
    public static final String TAG = "com.iqoption.welcomeonboarding.registration.e";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "binding", "getBinding()Lcom/iqoption/databinding/FragmentWelcomeRegistrationBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "animatorFactory", "getAnimatorFactory()Lcom/iqoption/welcomeonboarding/registration/AnimatorFactory;"))};
    public static final a dMU = new a();
    private HashMap atz;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.e.d dMT = kotlin.e.a.euA.aYg();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/RegistrationFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/iqoption/welcomeonboarding/registration/RegistrationFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RegistrationFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final e aMl() {
            return new e();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RegistrationFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ e dMX;

        e(e eVar) {
            this.dMX = eVar;
        }

        public final void onClick(View view) {
            this.dMX.aLX();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: RegistrationFragment.kt */
    static final class f implements OnClickListener {
        final /* synthetic */ e dMX;

        f(e eVar) {
            this.dMX = eVar;
        }

        public final void onClick(View view) {
            this.dMX.aLW();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "", "call"})
    /* compiled from: RegistrationFragment.kt */
    static final class b<T> implements com.iqoption.util.ag.e<V> {
        final /* synthetic */ WeakReference dMF;

        b(WeakReference weakReference) {
            this.dMF = weakReference;
        }

        public /* synthetic */ void aU(Object obj) {
            cc(((Boolean) obj).booleanValue());
        }

        public final void cc(boolean z) {
            e eVar = (e) this.dMF.get();
            if (eVar != null && eVar.isAdded() && eVar.aLj() != null) {
                com.iqoption.welcomeonboarding.a aLj = eVar.aLj();
                if (aLj == null) {
                    h.aXZ();
                }
                aLj.aKA();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "throwable", "", "call"})
    /* compiled from: RegistrationFragment.kt */
    static final class c implements com.iqoption.util.ag.a {
        public static final c dMV = new c();

        c() {
        }

        public final void n(Throwable th) {
            h.e(th, "throwable");
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/appsflayer/AppsFlyerListener$AppsflyerInstallResult;", "apply"})
    /* compiled from: RegistrationFragment.kt */
    static final class d<I, O> implements com.google.common.util.concurrent.g<I, O> {
        public static final d dMW = new d();

        d() {
        }

        /* renamed from: b */
        public final s<Boolean> aP(com.iqoption.b.b.a aVar) {
            return com.iqoption.c.a.Jw().JA();
        }
    }

    private final void a(ug ugVar) {
        this.bXo.a(this, apP[0], ugVar);
    }

    private final void a(a aVar) {
        this.dMT.a(this, apP[1], aVar);
    }

    private final ug aLU() {
        return (ug) this.bXo.b(this, apP[0]);
    }

    private final a aLV() {
        return (a) this.dMT.b(this, apP[1]);
    }

    public static final e aMl() {
        return dMU.aMl();
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected int aLS() {
        return R.string.open_account;
    }

    protected boolean aLy() {
        return false;
    }

    protected int aLz() {
        return R.id.registerContentContainer;
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (e.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a dVar;
        h.e(layoutInflater, "inflater");
        a((ug) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_welcome_registration, viewGroup, false));
        Resources resources = getResources();
        h.d(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            dVar = new d(aLU());
        } else {
            dVar = new c(aLU());
        }
        a(dVar);
        return aLU().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        aLU().aOU.setOnClickListener(new e(this));
        aLU().bGD.setOnClickListener(new f(this));
        TextView textView = (TextView) view.findViewById(R.id.socialTitle);
        view = view.findViewById(R.id.social_container);
        h.d(view, "view.findViewById<View>(R.id.social_container)");
        view.setVisibility(8);
        h.d(textView, "socialTitle");
        textView.setVisibility(8);
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        Animator aKI;
        if (z) {
            aKI = aLV().aKI();
            h.d(aKI, "animatorFactory.createEnterAnimator()");
            return aKI;
        }
        aKI = aLV().aKJ();
        h.d(aKI, "animatorFactory.createExitAnimator()");
        return aKI;
    }

    private final void aLW() {
        ag.a(ag.a(((com.iqoption.b.a) IQApp.Dk().akP.get()).Jc(), (com.google.common.util.concurrent.g) d.dMW), (com.iqoption.util.ag.e) new b(new WeakReference(this)), (com.iqoption.util.ag.a) c.dMV);
        IQApp.a("Demka", null);
    }

    public void b(Currency currency) {
        h.e(currency, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        a(currency);
    }

    public void aLn() {
        Integer num;
        am.n(zzakw());
        if (aLi() != null) {
            Currency aLi = aLi();
            if (aLi == null) {
                h.aXZ();
            }
            num = aLi.id;
        } else {
            num = null;
        }
        com.iqoption.core.ui.navigation.h a = com.iqoption.welcomeonboarding.registration.currency.c.dNu.a(new com.iqoption.welcomeonboarding.registration.currency.d(VF(), num));
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Context context = getContext();
        if (context == null) {
            h.aXZ();
        }
        h.d(context, "context!!");
        beginTransaction.add(R.id.registerContainer, a.bf(context), a.getName()).addToBackStack(a.getName()).commitAllowingStateLoss();
    }

    private final void aLX() {
        if (aLj() != null) {
            com.iqoption.welcomeonboarding.a aLj = aLj();
            if (aLj == null) {
                h.aXZ();
            }
            aLj.aKD();
        }
        am.n(zzakw());
    }

    public boolean onBackPressed() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        h.d(childFragmentManager, "fm");
        boolean z = false;
        if (childFragmentManager.getBackStackEntryCount() <= 0) {
            return false;
        }
        BackStackEntry backStackEntryAt = childFragmentManager.getBackStackEntryAt(childFragmentManager.getBackStackEntryCount() - 1);
        h.d(backStackEntryAt, "fm.getBackStackEntryAt(fm.backStackEntryCount - 1)");
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag(backStackEntryAt.getName());
        if (findFragmentByTag != null && (findFragmentByTag instanceof com.iqoption.view.e.a) && ((com.iqoption.view.e.a) findFragmentByTag).onBackPressed()) {
            z = true;
        }
        return z;
    }

    /* renamed from: aLY */
    public TextView aLZ() {
        return aLU().bGD;
    }

    /* renamed from: aMa */
    protected TextView aLA() {
        return aLU().agA;
    }

    /* renamed from: aMb */
    protected TextInputEditText aLB() {
        return aLU().bxq;
    }

    /* renamed from: aMc */
    protected TextInputEditText aLC() {
        return aLU().bEP;
    }

    protected ToggleButton aLD() {
        return aLU().bER;
    }

    /* renamed from: aMd */
    protected FrameLayout aLE() {
        return aLU().bEK;
    }

    protected TextInputLayout aLF() {
        return aLU().bBW;
    }

    /* renamed from: aMe */
    protected TextInputEditText aLG() {
        return aLU().bBV;
    }

    /* renamed from: aMf */
    protected ContentLoadingProgressBar aLH() {
        return aLU().bEM;
    }

    /* renamed from: aMg */
    protected ImageView aLI() {
        return aLU().bEL;
    }

    /* renamed from: aMh */
    protected ImageView aLJ() {
        return aLU().bBY;
    }

    /* renamed from: aMi */
    protected LinearLayout aLK() {
        return aLU().bEF;
    }

    protected TextView aLL() {
        return aLU().bEN;
    }

    /* renamed from: aMj */
    protected LinearLayout aLM() {
        return aLU().bEI;
    }

    protected CheckBox aLN() {
        return aLU().bEJ;
    }

    protected TextView aLO() {
        TextView textView = aLU().bGE.bEX;
        if (textView == null) {
            h.aXZ();
        }
        return textView;
    }

    protected CheckBox aLP() {
        CheckBox checkBox = aLU().bGE.bEW;
        if (checkBox == null) {
            h.aXZ();
        }
        return checkBox;
    }

    protected TextView aLQ() {
        return aLU().bnd;
    }

    /* renamed from: aMk */
    protected ContentLoadingProgressBar aLR() {
        return aLU().bnn;
    }
}
