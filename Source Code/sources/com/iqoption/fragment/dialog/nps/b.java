package com.iqoption.fragment.dialog.nps;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.abq;
import com.iqoption.dto.ToastEntity;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.fragment.leftpanel.BackListenerObserver;
import com.iqoption.util.am;
import com.iqoption.util.g;
import com.iqoption.view.e;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fH\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\fH\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u001a\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010$\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006-"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsFeedbackFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/NpsFeedbackFragmentBinding;", "isCloseAnimation", "", "popupObj", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "popupViewModel", "Lcom/iqoption/fragment/dialog/popup/PopupViewModel;", "score", "", "Ljava/lang/Integer;", "onClose", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "enter", "nextAnim", "onCreateAnimator", "Landroid/animation/Animator;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "send", "showCompletedFragment", "fm", "Landroid/support/v4/app/FragmentManager;", "skip", "submitNps", "feedback", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NpsFeedbackFragment.kt */
public final class b extends f {
    private static final String TAG = "b";
    public static final a cBd = new a();
    private PopupViewModel aep;
    private HashMap atz;
    private com.iqoption.core.microservices.popupserver.response.a cAZ;
    private Integer cBa;
    private abq cBb;
    private boolean cBc = true;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsFeedbackFragment$Companion;", "", "()V", "ARG_DIALOG_TYPE", "", "ARG_SCORE", "MAX_FEEDBACK_LENGTH", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/fragment/dialog/nps/NpsFeedbackFragment;", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "score", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsFeedbackFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return b.TAG;
        }

        public final b a(com.iqoption.core.microservices.popupserver.response.a aVar, int i) {
            h.e(aVar, "popup");
            b bVar = new b();
            bVar.setArguments(new g().O("ARG_SCORE", i).b("ARG_DIALOG_TYPE", (Parcelable) aVar).toBundle());
            return bVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    /* compiled from: NpsFeedbackFragment.kt */
    static final class d implements OnTouchListener {
        final /* synthetic */ b this$0;

        d(b bVar) {
            this.this$0 = bVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            com.iqoption.activity.b ajV = this.this$0.ajV();
            if (ajV != null && ajV.zN()) {
                am.a(this.this$0.zzakw(), view);
            }
            return true;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsFeedbackFragment$onCreateView$1", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsFeedbackFragment.kt */
    public static final class b extends com.iqoption.view.d.b {
        final /* synthetic */ b this$0;

        b(b bVar) {
            this.this$0 = bVar;
        }

        public void q(View view) {
            this.this$0.all();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsFeedbackFragment$onCreateView$2", "Lcom/iqoption/view/viewinterface/OnClickDelayView;", "onDelayClick", "", "view", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsFeedbackFragment.kt */
    public static final class c extends com.iqoption.view.d.b {
        final /* synthetic */ b this$0;

        c(b bVar) {
            this.this$0 = bVar;
        }

        public void q(View view) {
            this.this$0.send();
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.iqoption.fragment.dialog.popup.PopupViewModel.a aVar = PopupViewModel.cBp;
        FragmentActivity requireActivity = requireActivity();
        h.d(requireActivity, "requireActivity()");
        this.aep = aVar.j(requireActivity);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        bundle = getArguments();
        if (bundle != null) {
            this.cBa = Integer.valueOf(bundle.getInt("ARG_SCORE"));
            this.cAZ = (com.iqoption.core.microservices.popupserver.response.a) bundle.getParcelable("ARG_DIALOG_TYPE");
        }
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.nps_feedback_fragment, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…agment, container, false)");
        this.cBb = (abq) inflate;
        abq abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        abq.a(this);
        abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        abq.bBH.setOnClickListener(new b(this));
        abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        abq.bMx.setOnClickListener(new c(this));
        abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        abq.bMw.setOnTouchListener(new d(this));
        abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        return abq.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity activity = zzakw();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.view.BackController");
        }
        lifecycle.a(new BackListenerObserver((e) activity, new NpsFeedbackFragment$onViewCreated$1(this)));
    }

    public boolean onClose() {
        hN("");
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
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TJ());
        animatorSet.setDuration(300);
        abq abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(abq.bxT, View.TRANSLATION_Y, new float[]{eN(R.dimen._dp35), 0.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(abq.bMv, View.TRANSLATION_Y, new float[]{eN(R.dimen._dp35), 0.0f});
        animatorSet.playTogether(animatorArr);
        return animatorSet;
    }

    private final Animator alj() {
        if (this.cBc) {
            abq abq = this.cBb;
            if (abq == null) {
                h.lS("binding");
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(abq.getRoot(), View.ALPHA, new float[]{0.0f});
            h.d(ofFloat, "anim");
            ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
            ofFloat.setDuration(300);
            return ofFloat;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
        animatorSet.setDuration(300);
        abq abq2 = this.cBb;
        if (abq2 == null) {
            h.lS("binding");
        }
        Animator[] animatorArr = new Animator[6];
        animatorArr[0] = ObjectAnimator.ofFloat(abq2.brn, View.TRANSLATION_Y, new float[]{eN(R.dimen._dp30)});
        animatorArr[1] = ObjectAnimator.ofFloat(abq2.bxT, View.TRANSLATION_Y, new float[]{eN(R.dimen._dp30)});
        animatorArr[2] = ObjectAnimator.ofFloat(abq2.bMv, View.TRANSLATION_Y, new float[]{eN(R.dimen._dp30)});
        animatorArr[3] = ObjectAnimator.ofFloat(abq2.bBH, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp30)});
        animatorArr[4] = ObjectAnimator.ofFloat(abq2.bMx, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp30)});
        animatorArr[5] = ObjectAnimator.ofFloat(abq2.axL, View.ALPHA, new float[]{1.0f, 0.0f});
        animatorSet.playTogether(animatorArr);
        return animatorSet;
    }

    private final void all() {
        this.cBc = false;
        hN("");
        FragmentManager supportFragmentManager = com.iqoption.core.ext.a.n(this).getSupportFragmentManager();
        h.d(supportFragmentManager, "act.supportFragmentManager");
        n(supportFragmentManager);
    }

    private final void send() {
        this.cBc = false;
        abq abq = this.cBb;
        if (abq == null) {
            h.lS("binding");
        }
        EditText editText = abq.bMv;
        h.d(editText, "binding.feedback");
        String obj = editText.getText().toString();
        if (obj.length() > ToastEntity.ALERT_TOAST_DURATION) {
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            obj = obj.substring(ToastEntity.ALERT_TOAST_DURATION);
            h.d(obj, "(this as java.lang.String).substring(startIndex)");
        }
        hN(obj);
        FragmentManager supportFragmentManager = com.iqoption.core.ext.a.n(this).getSupportFragmentManager();
        h.d(supportFragmentManager, "act.supportFragmentManager");
        n(supportFragmentManager);
    }

    private final void hN(String str) {
        com.iqoption.core.microservices.popupserver.response.a aVar = this.cAZ;
        if (aVar != null) {
            PopupViewModel popupViewModel = this.aep;
            if (popupViewModel != null) {
                Integer num = this.cBa;
                popupViewModel.a(aVar, num != null ? num.intValue() : 0, str);
            }
            PopupViewModel popupViewModel2 = this.aep;
            if (popupViewModel2 != null) {
                PopupViewModel.a(popupViewModel2, aVar, null, 2, null);
            }
        }
    }

    private final void n(FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().remove(this).add(R.id.fragment, a.cAX.alk(), a.cAX.Ll()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitAllowingStateLoss();
    }

    static {
        h.d(b.class.getSimpleName(), "NpsFeedbackFragment::class.java.simpleName");
    }
}
