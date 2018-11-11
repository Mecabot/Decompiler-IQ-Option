package com.iqoption.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.fragment.h;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.d.lo;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, aXE = {"Lcom/iqoption/fragment/DarkDialogFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "binding", "Lcom/iqoption/databinding/FragmentDarkDialogBinding;", "close", "", "getAnimationDuration", "", "getListener", "Lcom/iqoption/fragment/DarkDialogFragment$OnDialogListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "setTextOrGone", "textView", "Landroid/widget/TextView;", "text", "", "Companion", "OnDialogListener", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DarkDialogFragment.kt */
public final class as extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.fragment.as";
    public static final a coZ = new a();
    private h aFD;
    private HashMap atz;
    private lo coY;

    @i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002JB\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, aXE = {"Lcom/iqoption/fragment/DarkDialogFragment$Companion;", "", "()V", "ARG_CANCEL", "", "ARG_CONFIRM", "ARG_MESSAGE", "ARG_TITLE", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/fragment/DarkDialogFragment;", "title", "", "message", "cancel", "confirm", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "container", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DarkDialogFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return as.TAG;
        }

        public final void a(FragmentManager fragmentManager, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            kotlin.jvm.internal.h.e(fragmentManager, "fm");
            kotlin.jvm.internal.h.e(charSequence2, "message");
            fragmentManager.beginTransaction().add(i, as.coZ.a(charSequence, charSequence2, charSequence3, charSequence4), as.coZ.Ll()).addToBackStack(as.coZ.Ll()).commit();
        }

        private final as a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            as asVar = new as();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("ARG_TITLE", charSequence);
            bundle.putCharSequence("ARG_MESSAGE", charSequence2);
            bundle.putCharSequence("ARG_CANCEL", charSequence3);
            bundle.putCharSequence("ARG_CONFIRM", charSequence4);
            asVar.setArguments(bundle);
            return asVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, aXE = {"Lcom/iqoption/fragment/DarkDialogFragment$OnDialogListener;", "", "onConfirm", "", "onDialogClose", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DarkDialogFragment.kt */
    public interface b {
        void ahp();

        void ahq();
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/DarkDialogFragment$onCreateView$1$1"})
    /* compiled from: DarkDialogFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ as cpa;
        final /* synthetic */ CharSequence cpb;
        final /* synthetic */ CharSequence cpc;

        c(as asVar, CharSequence charSequence, CharSequence charSequence2) {
            this.cpa = asVar;
            this.cpb = charSequence;
            this.cpc = charSequence2;
        }

        public final void onClick(View view) {
            b a = this.cpa.aho();
            if (a != null) {
                a.ahp();
            }
            this.cpa.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/DarkDialogFragment$onCreateView$1$2"})
    /* compiled from: DarkDialogFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ as cpa;
        final /* synthetic */ CharSequence cpb;
        final /* synthetic */ CharSequence cpc;

        d(as asVar, CharSequence charSequence, CharSequence charSequence2) {
            this.cpa = asVar;
            this.cpb = charSequence;
            this.cpc = charSequence2;
        }

        public final void onClick(View view) {
            b a = this.cpa.aho();
            if (a != null) {
                a.ahp();
            }
            this.cpa.close();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/fragment/DarkDialogFragment$onCreateView$1$3"})
    /* compiled from: DarkDialogFragment.kt */
    static final class e implements OnClickListener {
        final /* synthetic */ as cpa;
        final /* synthetic */ CharSequence cpb;
        final /* synthetic */ CharSequence cpc;

        e(as asVar, CharSequence charSequence, CharSequence charSequence2) {
            this.cpa = asVar;
            this.cpb = charSequence;
            this.cpc = charSequence2;
        }

        public final void onClick(View view) {
            b a = this.cpa.aho();
            if (a != null) {
                a.ahq();
            }
            this.cpa.close();
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
        if (as.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void ND() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        lo loVar = this.coY;
        if (loVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[0] = ObjectAnimator.ofFloat(loVar.getRoot(), View.ALPHA, new float[]{0.0f, 1.0f});
        loVar = this.coY;
        if (loVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[1] = ObjectAnimator.ofFloat(loVar.bmb, View.TRANSLATION_Y, new float[]{eN(R.dimen.dp24), 0.0f});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    public void NE() {
        AnimatorSet animatorSet = new AnimatorSet();
        com.iqoption.core.ext.a.a((Animator) animatorSet, getAnimationDuration());
        Animator[] animatorArr = new Animator[2];
        lo loVar = this.coY;
        if (loVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[0] = ObjectAnimator.ofFloat(loVar.getRoot(), View.ALPHA, new float[]{1.0f, 0.0f});
        loVar = this.coY;
        if (loVar == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        animatorArr[1] = ObjectAnimator.ofFloat(loVar.bmb, View.TRANSLATION_Y, new float[]{0.0f, eN(R.dimen.dp24)});
        animatorSet.playTogether(animatorArr);
        animatorSet.setInterpolator(com.iqoption.view.a.a.d.dEM);
        animatorSet.start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        bundle = getArguments();
        CharSequence charSequence = null;
        CharSequence charSequence2 = bundle != null ? bundle.getCharSequence("ARG_TITLE") : null;
        Bundle arguments = getArguments();
        CharSequence charSequence3 = arguments != null ? arguments.getCharSequence("ARG_MESSAGE") : null;
        lo A = lo.A(layoutInflater, viewGroup, false);
        kotlin.jvm.internal.h.d(A, "this");
        this.coY = A;
        com.iqoption.fragment.base.b bVar = this;
        View root = A.getRoot();
        kotlin.jvm.internal.h.d(root, "root");
        MaxSizeCardViewLayout maxSizeCardViewLayout = A.bmb;
        kotlin.jvm.internal.h.d(maxSizeCardViewLayout, "frame");
        this.aFD = new h(bVar, root, maxSizeCardViewLayout);
        A.awS.setOnClickListener(new c(this, charSequence2, charSequence3));
        TextView textView = A.agA;
        kotlin.jvm.internal.h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        a(textView, charSequence2);
        textView = A.aip;
        kotlin.jvm.internal.h.d(textView, "text");
        textView.setText(charSequence3);
        textView = A.bxm;
        kotlin.jvm.internal.h.d(textView, "buttonCancel");
        Bundle arguments2 = getArguments();
        a(textView, arguments2 != null ? arguments2.getCharSequence("ARG_CANCEL") : null);
        A.bxm.setOnClickListener(new d(this, charSequence2, charSequence3));
        textView = A.bxn;
        kotlin.jvm.internal.h.d(textView, "buttonConfirm");
        arguments2 = getArguments();
        if (arguments2 != null) {
            charSequence = arguments2.getCharSequence("ARG_CONFIRM");
        }
        a(textView, charSequence);
        A.bxn.setOnClickListener(new e(this, charSequence2, charSequence3));
        A = this.coY;
        if (A == null) {
            kotlin.jvm.internal.h.lS("binding");
        }
        return A.getRoot();
    }

    private final void a(TextView textView, CharSequence charSequence) {
        if (charSequence != null) {
            com.iqoption.core.ext.a.L(textView);
            textView.setText(charSequence);
            return;
        }
        com.iqoption.core.ext.a.M(textView);
    }

    private final void close() {
        com.iqoption.core.ext.a.p(this).popBackStack();
    }

    private final b aho() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof b)) {
            parentFragment = null;
        }
        b bVar = (b) parentFragment;
        if (bVar != null) {
            return bVar;
        }
        FragmentActivity activity = zzakw();
        if (!(activity instanceof b)) {
            activity = null;
        }
        return (b) activity;
    }
}
