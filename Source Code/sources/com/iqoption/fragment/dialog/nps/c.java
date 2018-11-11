package com.iqoption.fragment.dialog.nps;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.transition.Fade;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.widget.nps.NpsRatingBar;
import com.iqoption.d.abs;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.leftpanel.BackListenerObserver;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010%\u001a\u00020\u000eJ \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsScoreFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/NpsScoreFragmentBinding;", "errorAnimator", "Landroid/animation/ObjectAnimator;", "isCloseAnimation", "", "popupObj", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "popupViewModel", "Lcom/iqoption/fragment/dialog/popup/PopupViewModel;", "hideError", "", "onClose", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateAnimator", "Landroid/animation/Animator;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "showError", "showFeedbackFragment", "fm", "Landroid/support/v4/app/FragmentManager;", "popup", "score", "submit", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NpsScoreFragment.kt */
public final class c extends com.iqoption.fragment.base.f {
    private static final String TAG = "c";
    public static final a cBg = new a();
    private PopupViewModel aep;
    private HashMap atz;
    private com.iqoption.core.microservices.popupserver.response.a cAZ;
    private boolean cBc = true;
    private abs cBe;
    private ObjectAnimator cBf;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsScoreFragment$Companion;", "", "()V", "ARG_DIALOG_TYPE", "", "BLINKING_DURATION", "", "BLINKING_DURATION_ERROR", "EXIT_ENTER_DURATION", "HIDE_ERROR_DURATION", "SHOW_ERROR_DURATION", "TAG", "kotlin.jvm.PlatformType", "newInstance", "Lcom/iqoption/fragment/dialog/nps/NpsScoreFragment;", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "tryShow", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsScoreFragment.kt */
    public static final class a {

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
        /* compiled from: NpsScoreFragment.kt */
        static final class a implements Runnable {
            final /* synthetic */ FragmentManager cBh;
            final /* synthetic */ com.iqoption.core.microservices.popupserver.response.a cBi;

            a(FragmentManager fragmentManager, com.iqoption.core.microservices.popupserver.response.a aVar) {
                this.cBh = fragmentManager;
                this.cBi = aVar;
            }

            public final void run() {
                a aVar = c.cBg;
                FragmentManager fragmentManager = this.cBh;
                h.d(fragmentManager, "fm");
                aVar.a(fragmentManager, this.cBi);
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity, com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(fragmentActivity, "activity");
            h.e(aVar, "popup");
            PopupViewModel.cBp.j(fragmentActivity).a((Runnable) new a(fragmentActivity.getSupportFragmentManager(), aVar), aVar);
        }

        private final void a(FragmentManager fragmentManager, com.iqoption.core.microservices.popupserver.response.a aVar) {
            c h = h(aVar);
            h.setEnterTransition(new Fade());
            fragmentManager.beginTransaction().add(R.id.fragment, h, c.TAG).commitAllowingStateLoss();
        }

        private final c h(com.iqoption.core.microservices.popupserver.response.a aVar) {
            c cVar = new c();
            cVar.setArguments(new com.iqoption.util.g().b("ARG_DIALOG_TYPE", (Parcelable) aVar).toBundle());
            return cVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/iqoption/fragment/dialog/nps/NpsScoreFragment$showError$1$1"})
    /* compiled from: NpsScoreFragment.kt */
    static final class g implements AnimatorUpdateListener {
        final /* synthetic */ BooleanRef cBj;
        final /* synthetic */ c this$0;

        g(BooleanRef booleanRef, c cVar) {
            this.cBj = booleanRef;
            this.this$0 = cVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.cBj.element) {
                h.d(valueAnimator, "it");
                if (valueAnimator.getAnimatedFraction() >= 0.2f) {
                    this.cBj.element = true;
                    c.c(this.this$0).bMF.bf(2000);
                }
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsScoreFragment$onCreateView$1", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsScoreFragment.kt */
    public static final class b extends com.iqoption.view.d.b {
        final /* synthetic */ c this$0;

        b(c cVar) {
            this.this$0 = cVar;
        }

        public void q(View view) {
            this.this$0.alm();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "view", "Lcom/iqoption/core/ui/widget/nps/NpsRatingBar;", "rating", "", "onRatingChanged"})
    /* compiled from: NpsScoreFragment.kt */
    static final class c implements com.iqoption.core.ui.widget.nps.NpsRatingBar.a {
        final /* synthetic */ c this$0;

        c(c cVar) {
            this.this$0 = cVar;
        }

        public final void a(NpsRatingBar npsRatingBar, int i) {
            h.e(npsRatingBar, Promotion.ACTION_VIEW);
            this.this$0.alm();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsScoreFragment$onCreateView$3", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsScoreFragment.kt */
    public static final class d extends com.iqoption.view.d.b {
        final /* synthetic */ c this$0;

        d(c cVar) {
            this.this$0 = cVar;
        }

        public void q(View view) {
            this.this$0.submit();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsScoreFragment$onCreateView$4", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsScoreFragment.kt */
    public static final class e extends com.iqoption.view.d.b {
        final /* synthetic */ c this$0;

        e(c cVar) {
            this.this$0 = cVar;
        }

        public void q(View view) {
            NpsRatingBar npsRatingBar = c.c(this.this$0).bMF;
            NpsRatingBar npsRatingBar2 = c.c(this.this$0).bMF;
            h.d(npsRatingBar2, "binding.ratingBar");
            npsRatingBar.dT(npsRatingBar2.getRatingMax() / 3);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsScoreFragment$onCreateView$5", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsScoreFragment.kt */
    public static final class f extends com.iqoption.view.d.b {
        final /* synthetic */ c this$0;

        f(c cVar) {
            this.this$0 = cVar;
        }

        public void q(View view) {
            NpsRatingBar npsRatingBar = c.c(this.this$0).bMF;
            NpsRatingBar npsRatingBar2 = c.c(this.this$0).bMF;
            h.d(npsRatingBar2, "binding.ratingBar");
            npsRatingBar.dT(npsRatingBar2.getRatingMax());
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public static final /* synthetic */ abs c(c cVar) {
        abs abs = cVar.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        return abs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.iqoption.fragment.dialog.popup.PopupViewModel.a aVar = PopupViewModel.cBp;
        FragmentActivity requireActivity = requireActivity();
        h.d(requireActivity, "requireActivity()");
        this.aep = aVar.j(requireActivity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        bundle = getArguments();
        if (bundle != null) {
            this.cAZ = (com.iqoption.core.microservices.popupserver.response.a) bundle.getParcelable("ARG_DIALOG_TYPE");
        }
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.nps_score_fragment, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…agment, container, false)");
        this.cBe = (abs) inflate;
        abs abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.a(this);
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = abs.bMC;
        h.d(frameLayout, "binding.error");
        frameLayout.setAlpha(0.0f);
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        frameLayout = abs.bMC;
        h.d(frameLayout, "binding.error");
        com.iqoption.core.ext.a.L(frameLayout);
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bMC.setOnClickListener(new b(this));
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bMF.setOnRatingChangeListener(new c(this));
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bMI.setOnClickListener(new d(this));
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bME.setOnClickListener(new e(this));
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bMJ.setOnClickListener(new f(this));
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        return abs.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity activity = zzakw();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.view.BackController");
        }
        lifecycle.a(new BackListenerObserver((com.iqoption.view.e) activity, new NpsScoreFragment$onViewCreated$1(this)));
        abs abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        abs.bMF.bf(800);
    }

    public boolean onClose() {
        com.iqoption.core.microservices.popupserver.response.a aVar = this.cAZ;
        if (aVar != null) {
            PopupViewModel popupViewModel = this.aep;
            if (popupViewModel != null) {
                PopupViewModel.a(popupViewModel, aVar, null, 2, null);
            }
        }
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
        }
        return true;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return z ? ali() : alj();
    }

    private final Animator ali() {
        abs abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        View root = abs.getRoot();
        h.d(root, "binding.root");
        root.setAlpha(0.0f);
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(abs.getRoot(), View.ALPHA, new float[]{1.0f});
        h.d(ofFloat, "anim");
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
        ofFloat.setDuration(300);
        return ofFloat;
    }

    private final Animator alj() {
        abs abs;
        ObjectAnimator ofFloat;
        if (this.cBc) {
            abs = this.cBe;
            if (abs == null) {
                h.lS("binding");
            }
            ofFloat = ObjectAnimator.ofFloat(abs.getRoot(), View.ALPHA, new float[]{0.0f});
            h.d(ofFloat, "anim");
            ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
            ofFloat.setDuration(300);
            return ofFloat;
        }
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        ofFloat = ObjectAnimator.ofFloat(abs.axL, View.ALPHA, new float[]{0.0f});
        h.d(ofFloat, "anim");
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
        ofFloat.setDuration(300);
        return ofFloat;
    }

    private final void submit() {
        abs abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        NpsRatingBar npsRatingBar = abs.bMF;
        h.d(npsRatingBar, "binding.ratingBar");
        if (npsRatingBar.getRating() == 0) {
            zy();
            return;
        }
        com.iqoption.core.microservices.popupserver.response.a aVar = this.cAZ;
        if (aVar != null) {
            this.cBc = false;
            FragmentManager supportFragmentManager = com.iqoption.core.ext.a.n(this).getSupportFragmentManager();
            h.d(supportFragmentManager, "act.supportFragmentManager");
            abs abs2 = this.cBe;
            if (abs2 == null) {
                h.lS("binding");
            }
            NpsRatingBar npsRatingBar2 = abs2.bMF;
            h.d(npsRatingBar2, "binding.ratingBar");
            a(supportFragmentManager, aVar, npsRatingBar2.getRating());
        }
    }

    private final void a(FragmentManager fragmentManager, com.iqoption.core.microservices.popupserver.response.a aVar, int i) {
        fragmentManager.beginTransaction().remove(this).add(R.id.fragment, b.cBd.a(aVar, i), b.cBd.Ll()).commitAllowingStateLoss();
    }

    public final void zy() {
        ObjectAnimator objectAnimator = this.cBf;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        abs abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = abs.bMC;
        h.d(frameLayout, "binding.error");
        frameLayout.setAlpha(0.0f);
        abs = this.cBe;
        if (abs == null) {
            h.lS("binding");
        }
        frameLayout = abs.bMC;
        h.d(frameLayout, "binding.error");
        com.iqoption.core.ext.a.L(frameLayout);
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.2f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.9f, 1.0f);
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 0.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.0f, eN(R.dimen.dp40));
        Keyframe ofFloat6 = Keyframe.ofFloat(0.2f, eN(R.dimen.dp10));
        Keyframe ofFloat7 = Keyframe.ofFloat(1.0f, eN(R.dimen.dp10));
        abs abs2 = this.cBe;
        if (abs2 == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout2 = abs2.bMC;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[]{ofFloat5, ofFloat6, ofFloat7});
        this.cBf = ObjectAnimator.ofPropertyValuesHolder(frameLayout2, propertyValuesHolderArr);
        objectAnimator = this.cBf;
        if (objectAnimator != null) {
            objectAnimator.setDuration(2400);
            objectAnimator.setInterpolator(com.iqoption.core.graphics.animation.i.TJ());
            BooleanRef booleanRef = new BooleanRef();
            booleanRef.element = false;
            objectAnimator.addUpdateListener(new g(booleanRef, this));
            objectAnimator.start();
        }
    }

    public final void alm() {
        if (this.cBf != null) {
            abs abs = this.cBe;
            if (abs == null) {
                h.lS("binding");
            }
            FrameLayout frameLayout = abs.bMC;
            h.d(frameLayout, "binding.error");
            if (frameLayout.getAlpha() != 0.0f) {
                ObjectAnimator objectAnimator = this.cBf;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                abs = this.cBe;
                if (abs == null) {
                    h.lS("binding");
                }
                this.cBf = ObjectAnimator.ofFloat(abs.bMC, View.ALPHA, new float[]{0.0f});
                objectAnimator = this.cBf;
                if (objectAnimator == null) {
                    h.aXZ();
                }
                objectAnimator.setDuration(300);
                objectAnimator = this.cBf;
                if (objectAnimator == null) {
                    h.aXZ();
                }
                objectAnimator.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
                objectAnimator = this.cBf;
                if (objectAnimator == null) {
                    h.aXZ();
                }
                objectAnimator.start();
            }
        }
    }
}
