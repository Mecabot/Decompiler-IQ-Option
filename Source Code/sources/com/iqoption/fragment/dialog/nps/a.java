package com.iqoption.fragment.dialog.nps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.abo;
import com.iqoption.fragment.base.f;
import com.iqoption.fragment.leftpanel.BackListenerObserver;
import com.iqoption.view.e;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsCompletedFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/NpsCompletedFragmentBinding;", "onClose", "", "onCreateAnimator", "Landroid/animation/Animator;", "transit", "", "enter", "nextAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "onViewCreated", "", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NpsCompletedFragment.kt */
public final class a extends f {
    private static final String TAG = "a";
    public static final a cAX = new a();
    private HashMap atz;
    private abo cAW;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/fragment/dialog/nps/NpsCompletedFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/fragment/dialog/nps/NpsCompletedFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsCompletedFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return a.TAG;
        }

        public final a alk() {
            return new a();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/fragment/dialog/nps/NpsCompletedFragment$onShowAnimation$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: NpsCompletedFragment.kt */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ abo cAY;

        b(abo abo) {
            this.cAY = abo;
        }

        public void onAnimationEnd(Animator animator) {
            FrameLayout frameLayout = this.cAY.bMr;
            h.d(frameLayout, "closeFrame");
            frameLayout.setAlpha(1.0f);
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, R.layout.nps_completed_fragment, viewGroup, false);
        h.d(inflate, "DataBindingUtil.inflate(…agment, container, false)");
        this.cAW = (abo) inflate;
        abo abo = this.cAW;
        if (abo == null) {
            h.lS("binding");
        }
        abo.a(this);
        abo = this.cAW;
        if (abo == null) {
            h.lS("binding");
        }
        FrameLayout frameLayout = abo.bMr;
        h.d(frameLayout, "binding.closeFrame");
        frameLayout.setAlpha(0.0f);
        abo = this.cAW;
        if (abo == null) {
            h.lS("binding");
        }
        return abo.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        Lifecycle lifecycle = getLifecycle();
        FragmentActivity activity = zzakw();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.view.BackController");
        }
        lifecycle.a(new BackListenerObserver((e) activity, new NpsCompletedFragment$onViewCreated$1(this)));
    }

    public boolean onClose() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().remove(this).setTransition(8194).commitAllowingStateLoss();
        }
        return true;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return z ? ali() : alj();
    }

    public final Animator ali() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(com.iqoption.core.graphics.animation.i.TJ());
        animatorSet.setDuration(300);
        abo abo = this.cAW;
        if (abo == null) {
            h.lS("binding");
        }
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(abo.bmu, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp35), 0.0f});
        animatorArr[1] = ObjectAnimator.ofFloat(abo.aip, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp35), 0.0f});
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new b(abo));
        return animatorSet;
    }

    public final Animator alj() {
        abo abo = this.cAW;
        if (abo == null) {
            h.lS("binding");
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(abo.getRoot(), View.ALPHA, new float[]{0.0f});
        h.d(ofFloat, "anim");
        ofFloat.setInterpolator(com.iqoption.core.graphics.animation.i.TK());
        ofFloat.setDuration(300);
        return ofFloat;
    }

    static {
        h.d(a.class.getSimpleName(), "NpsCompletedFragment::class.java.simpleName");
    }
}
