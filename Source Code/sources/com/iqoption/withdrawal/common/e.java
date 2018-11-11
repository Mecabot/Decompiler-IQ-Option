package com.iqoption.withdrawal.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.fragment.h;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.d.amt;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001d"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "binding", "Lcom/iqoption/databinding/WithdrawLimitReasonDialogBinding;", "listener", "Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$OnCloseListener;", "getListener", "()Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$OnCloseListener;", "setListener", "(Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$OnCloseListener;)V", "close", "", "getAnimationDuration", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "Companion", "OnCloseListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawLimitReasonDialog.kt */
public final class e extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.withdrawal.common.e";
    public static final a dPW = new a();
    private h aFD;
    private HashMap atz;
    private amt dPU;
    private b dPV;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0002J*\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$Companion;", "", "()V", "ARG_MESSAGE", "", "ARG_TITLE", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog;", "title", "", "message", "show", "fm", "Landroid/support/v4/app/FragmentManager;", "container", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawLimitReasonDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }

        public final e a(FragmentManager fragmentManager, int i, CharSequence charSequence, CharSequence charSequence2) {
            kotlin.jvm.internal.h.e(fragmentManager, "fm");
            kotlin.jvm.internal.h.e(charSequence2, "message");
            e a = a(charSequence, charSequence2);
            fragmentManager.beginTransaction().add(i, a, e.dPW.Ll()).addToBackStack(e.dPW.Ll()).commit();
            return a;
        }

        private final e a(CharSequence charSequence, CharSequence charSequence2) {
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("ARG_TITLE", charSequence);
            bundle.putCharSequence("ARG_MESSAGE", charSequence2);
            eVar.setArguments(bundle);
            return eVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawLimitReasonDialog$OnCloseListener;", "", "onDialogClose", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawLimitReasonDialog.kt */
    public interface b {
        void ahp();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/withdrawal/common/WithdrawLimitReasonDialog$onCreateView$1$1"})
    /* compiled from: WithdrawLimitReasonDialog.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ CharSequence cpb;
        final /* synthetic */ CharSequence cpc;
        final /* synthetic */ e dPX;

        c(e eVar, CharSequence charSequence, CharSequence charSequence2) {
            this.dPX = eVar;
            this.cpb = charSequence;
            this.cpc = charSequence2;
        }

        public final void onClick(View view) {
            this.dPX.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/withdrawal/common/WithdrawLimitReasonDialog$onCreateView$1$2"})
    /* compiled from: WithdrawLimitReasonDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ CharSequence cpb;
        final /* synthetic */ CharSequence cpc;
        final /* synthetic */ e dPX;

        d(e eVar, CharSequence charSequence, CharSequence charSequence2) {
            this.dPX = eVar;
            this.cpb = charSequence;
            this.cpc = charSequence2;
        }

        public final void onClick(View view) {
            this.dPX.close();
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 250;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    static {
        if (e.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public final void a(b bVar) {
        this.dPV = bVar;
    }

    public void ND() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        amt amt = this.dPU;
        if (amt == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[0] = ObjectAnimator.ofFloat(amt.getRoot(), View.ALPHA, new float[]{0.0f, 1.0f});
        amt = this.dPU;
        if (amt == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[1] = ObjectAnimator.ofFloat(amt.bmb, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp24), 0.0f});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    public void NE() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        amt amt = this.dPU;
        if (amt == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[0] = ObjectAnimator.ofFloat(amt.getRoot(), View.ALPHA, new float[]{1.0f, 0.0f});
        amt = this.dPU;
        if (amt == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[1] = ObjectAnimator.ofFloat(amt.bmb, View.TRANSLATION_Y, new float[]{0.0f, eN(R.dimen.dp24)});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        bundle = getArguments();
        CharSequence charSequence = null;
        CharSequence charSequence2 = bundle != null ? bundle.getCharSequence("ARG_TITLE") : null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            charSequence = arguments.getCharSequence("ARG_MESSAGE");
        }
        amt aD = amt.aD(layoutInflater, viewGroup, false);
        kotlin.jvm.internal.h.d(aD, "this");
        this.dPU = aD;
        com.iqoption.fragment.base.b bVar = this;
        View root = aD.getRoot();
        kotlin.jvm.internal.h.d(root, "root");
        MaxSizeCardViewLayout maxSizeCardViewLayout = aD.bmb;
        kotlin.jvm.internal.h.d(maxSizeCardViewLayout, "frame");
        this.aFD = new h(bVar, root, maxSizeCardViewLayout);
        aD.awS.setOnClickListener(new c(this, charSequence2, charSequence));
        if (charSequence2 != null) {
            textView = aD.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setVisibility(0);
            textView = aD.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setText(charSequence2);
        } else {
            textView = aD.agA;
            kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setVisibility(8);
        }
        textView = aD.aip;
        kotlin.jvm.internal.h.d(textView, "text");
        textView.setText(charSequence);
        aD.bma.setOnClickListener(new d(this, charSequence2, charSequence));
        aD = this.dPU;
        if (aD == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return aD.getRoot();
    }

    public final void close() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        b bVar = this.dPV;
        if (bVar != null) {
            bVar.ahp();
        }
    }
}
