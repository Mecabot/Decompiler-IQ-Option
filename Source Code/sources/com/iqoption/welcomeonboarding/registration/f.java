package com.iqoption.welcomeonboarding.registration;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.app.IQApp;
import com.iqoption.d.tb;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.dto.Event;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020$H\u0014J\b\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001cH\u0014J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020 H\u0014J\b\u0010,\u001a\u00020-H\u0014J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0014H\u0014J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020-H\u0016J\b\u0010;\u001a\u00020-H\u0016J\b\u0010<\u001a\u00020-H\u0016J\u0012\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010B\u001a\u00020 H\u0014J\b\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020*H\u0014J\b\u0010F\u001a\u00020*H\u0014J\b\u0010G\u001a\u00020/H\u0014J\b\u0010H\u001a\u00020'H\u0014J\b\u0010I\u001a\u00020/H\u0014J\b\u0010J\u001a\u00020*H\u0014R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/TrialRegistrationDialog;", "Lcom/iqoption/welcomeonboarding/registration/BaseRegistrationFragment;", "Lcom/iqoption/welcomeonboarding/registration/currency/window/CurrencySelectionAdapter$ItemClickListener;", "()V", "<set-?>", "Lcom/iqoption/databinding/FragmentTrialRegistrationBinding;", "binding", "getBinding", "()Lcom/iqoption/databinding/FragmentTrialRegistrationBinding;", "setBinding", "(Lcom/iqoption/databinding/FragmentTrialRegistrationBinding;)V", "binding$delegate", "Lkotlin/properties/ReadWriteProperty;", "enterAnimationDuration", "", "getEnterAnimationDuration", "()J", "exitAnimationDuration", "getExitAnimationDuration", "isCustomAnimationsEnabled", "", "()Z", "selectCurrencyWindow", "Lcom/iqoption/welcomeonboarding/registration/currency/window/SelectCurrencyWindow;", "acceptTermsCheck", "Landroid/widget/CheckBox;", "ageCheckBox", "ageLayout", "Landroid/widget/LinearLayout;", "countryContainer", "Landroid/widget/FrameLayout;", "countryEdit", "Landroid/support/design/widget/TextInputEditText;", "countryInput", "Landroid/support/design/widget/TextInputLayout;", "countryLocationButton", "Landroid/widget/ImageView;", "countryLocationError", "countryProgress", "Landroid/support/v4/widget/ContentLoadingProgressBar;", "currencyContainer", "currencySpinnerTitle", "Landroid/widget/TextView;", "emailEdit", "forceClose", "", "getCurrentCurrencyPosition", "", "getPopUpWindow", "isTrialUser", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCurrencyContainerClick", "onEnterAnimation", "onExitAnimation", "onItemClick", "currency", "Lcom/iqoption/dto/Currencies$Currency;", "onViewCreated", "view", "passwordEdit", "passwordToggle", "Landroid/widget/ToggleButton;", "policyTextView", "registerButton", "registerButtonText", "registerProgress", "searchCountriesContainerId", "titleView", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TrialRegistrationDialog.kt */
public final class f extends b implements com.iqoption.welcomeonboarding.registration.currency.a.a.a {
    private static final String TAG = "com.iqoption.welcomeonboarding.registration.f";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(f.class), "binding", "getBinding()Lcom/iqoption/databinding/FragmentTrialRegistrationBinding;"))};
    public static final a dNb = new a();
    private HashMap atz;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final boolean bbw = true;
    private final long bbx = 350;
    private final long bby = 350;
    private com.iqoption.welcomeonboarding.registration.currency.a.c dNa;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/TrialRegistrationDialog$Companion;", "", "()V", "TAG", "", "show", "", "activity", "Landroid/support/v4/app/FragmentActivity;", "fm", "Landroid/support/v4/app/FragmentManager;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TrialRegistrationDialog.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: TrialRegistrationDialog.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;

            a(FragmentManager fragmentManager) {
                this.cBh = fragmentManager;
            }

            public final void run() {
                f.dNb.e(this.cBh);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager) {
            h.e(fragmentActivity, "activity");
            h.e(fragmentManager, "fm");
            PopupViewModel.cBp.j(fragmentActivity).a((Runnable) new a(fragmentManager), f.TAG);
        }

        private final void e(FragmentManager fragmentManager) {
            if (fragmentManager.findFragmentByTag(f.TAG) == null) {
                fragmentManager.beginTransaction().add(R.id.other_fragment, new f(), f.TAG).addToBackStack(f.TAG).commit();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "onDismiss"})
    /* compiled from: TrialRegistrationDialog.kt */
    static final class b implements OnDismissListener {
        final /* synthetic */ f dNc;

        b(f fVar) {
            this.dNc = fVar;
        }

        public final void onDismiss() {
            this.dNc.aMm().bEF.animate().alpha(1.0f).setDuration(150).start();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: TrialRegistrationDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ f dNc;

        c(f fVar) {
            this.dNc = fVar;
        }

        public final void onClick(View view) {
            this.dNc.aiM();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: TrialRegistrationDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ f dNc;
        final /* synthetic */ int dNd;

        d(f fVar, int i) {
            this.dNc = fVar;
            this.dNd = i;
        }

        public final void onClick(View view) {
            if (!this.dNc.aLx()) {
                com.iqoption.util.b.o(this.dNc.aMm().bES, this.dNd);
            }
        }
    }

    public static final void a(FragmentActivity fragmentActivity, FragmentManager fragmentManager) {
        dNb.a(fragmentActivity, fragmentManager);
    }

    private final void a(tb tbVar) {
        this.bXo.a(this, apP[0], tbVar);
    }

    private final tb aMm() {
        return (tb) this.bXo.b(this, apP[0]);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    protected int aLS() {
        return R.string.next;
    }

    protected boolean aLy() {
        return true;
    }

    protected int aLz() {
        return R.id.registerOther;
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
        if (f.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        a((tb) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_trial_registration, viewGroup, false));
        return aMm().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        aMm().bEV.setOnClickListener(new c(this));
        aMm().bjF.setOnClickListener(new d(this, com.iqoption.util.b.bQ(getContext())));
        j(Event.Builder(Event.CATEGORY_POPUP_SERVED, "registration_popup"));
        Tracker aP = IQApp.aP(getContext());
        aP.setScreenName("Open real account");
        aP.send(((ScreenViewBuilder) new ScreenViewBuilder().setCustomDimension(2, aP.get("&cid"))).build());
    }

    private final com.iqoption.welcomeonboarding.registration.currency.a.c aMn() {
        Context m = com.iqoption.core.ext.a.m(this);
        com.iqoption.welcomeonboarding.registration.currency.a.a.a aVar = this;
        List VF = VF();
        LinearLayout linearLayout = aMm().bEF;
        h.d(linearLayout, "binding.accountCurrencySelector");
        return new com.iqoption.welcomeonboarding.registration.currency.a.c(m, aVar, VF, linearLayout.getWidth());
    }

    public void c(Currency currency) {
        a(currency);
        com.iqoption.welcomeonboarding.registration.currency.a.c cVar = this.dNa;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void aLn() {
        am.n(zzakw());
        com.iqoption.welcomeonboarding.registration.currency.a.c cVar = this.dNa;
        if (cVar == null) {
            cVar = aMn();
        }
        this.dNa = cVar;
        cVar.cD(aMo());
        LinearLayout linearLayout = aMm().bEF;
        View view = linearLayout;
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        if (linearLayout == null) {
            h.aXZ();
        }
        h.d(linearLayout, "selectorView!!");
        cVar.showAsDropDown(view, xOffset, yOffset - linearLayout.getHeight());
        cVar.setOnDismissListener(new b(this));
        aMm().bEF.animate().alpha(0.0f).setDuration(150).start();
    }

    private final int aMo() {
        int i = 0;
        for (Currency currency : VF()) {
            Integer num = currency.id;
            Currency aLi = aLi();
            if (aLi == null) {
                h.aXZ();
            }
            if (h.E(num, aLi.id)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public boolean KE() {
        return this.bbw;
    }

    public long Yw() {
        return this.bbx;
    }

    public long Yx() {
        return this.bby;
    }

    public void KF() {
        Animator c = com.iqoption.view.a.a.a.c(aMm().bjF, com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), R.color.transparent), com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), R.color.black_66));
        h.d(c, "background");
        c.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(aMm().bES, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f, 1.0f})});
        h.d(ofPropertyValuesHolder, "popup");
        ofPropertyValuesHolder.setInterpolator(com.iqoption.view.a.a.d.dEM);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aMm().bES, View.ALPHA, new float[]{0.0f, 1.0f});
        h.d(ofFloat, "alphaPopup");
        ofFloat.setInterpolator(com.iqoption.view.a.a.d.dEM);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, Yw());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder, ofFloat});
        animatorSet.start();
    }

    public void KG() {
        Animator c = com.iqoption.view.a.a.a.c(aMm().bjF, com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), R.color.black_66), com.iqoption.core.ext.a.i(com.iqoption.core.ext.a.m(this), R.color.transparent));
        FrameLayout frameLayout = aMm().bES;
        r2 = new PropertyValuesHolder[3];
        r2[0] = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.4f});
        r2[1] = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.4f});
        r2[2] = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(frameLayout, r2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.util.b.a(animatorSet, Yx());
        animatorSet.playTogether(new Animator[]{c, ofPropertyValuesHolder});
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    protected void aiM() {
        super.aiM();
        PopupViewModel.cBp.j(com.iqoption.core.ext.a.n(this)).hO(TAG);
    }

    /* renamed from: aMa */
    protected TextView aLA() {
        return aMm().agA;
    }

    /* renamed from: aMb */
    protected TextInputEditText aLB() {
        return aMm().bxq;
    }

    /* renamed from: aMc */
    protected TextInputEditText aLC() {
        return aMm().bEP;
    }

    protected ToggleButton aLD() {
        return aMm().bER;
    }

    /* renamed from: aMd */
    protected FrameLayout aLE() {
        return aMm().bEK;
    }

    protected TextInputLayout aLF() {
        return aMm().bBW;
    }

    /* renamed from: aMe */
    protected TextInputEditText aLG() {
        return aMm().bBV;
    }

    /* renamed from: aMf */
    protected ContentLoadingProgressBar aLH() {
        return aMm().bEM;
    }

    /* renamed from: aMg */
    protected ImageView aLI() {
        return aMm().bEL;
    }

    /* renamed from: aMh */
    protected ImageView aLJ() {
        return aMm().bBY;
    }

    /* renamed from: aMi */
    protected LinearLayout aLK() {
        return aMm().bEF;
    }

    protected TextView aLL() {
        return aMm().bEN;
    }

    /* renamed from: aMj */
    protected LinearLayout aLM() {
        return aMm().bEI;
    }

    protected CheckBox aLN() {
        return aMm().bEJ;
    }

    protected TextView aLO() {
        return aMm().bEX;
    }

    protected CheckBox aLP() {
        return aMm().bEW;
    }

    protected TextView aLQ() {
        return aMm().bnd;
    }

    /* renamed from: aMk */
    protected ContentLoadingProgressBar aLR() {
        return aMm().bnn;
    }
}
