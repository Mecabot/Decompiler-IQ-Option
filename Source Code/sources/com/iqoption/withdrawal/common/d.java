package com.iqoption.withdrawal.common;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.uk;
import com.iqoption.x.R;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u001a\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001c"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawCompleteFragment;", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentWithdrawCompleteBinding;", "success", "", "getSuccess", "()Z", "success$delegate", "Lkotlin/Lazy;", "close", "", "initToolbar", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawCompleteFragment.kt */
public final class d extends com.iqoption.fragment.base.b {
    private static final String TAG = "com.iqoption.withdrawal.common.d";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), com.google.firebase.analytics.FirebaseAnalytics.b.SUCCESS, "getSuccess()Z"))};
    public static final a dPT = new a();
    private HashMap atz;
    private uk dPR;
    private final kotlin.d dPS = g.f(new WithdrawCompleteFragment$success$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawCompleteFragment$Companion;", "", "()V", "ARG_SUCCESS", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/withdrawal/common/WithdrawCompleteFragment;", "success", "", "show", "", "fm", "Landroid/support/v4/app/FragmentManager;", "containerViewId", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawCompleteFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        public final void a(FragmentManager fragmentManager, @IdRes int i, boolean z) {
            h.e(fragmentManager, "fm");
            fragmentManager.beginTransaction().add(i, fx(z), d.dPT.Ll()).commit();
        }

        private final d fx(boolean z) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_SUCCESS", z);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawCompleteFragment.kt */
    static final class b implements OnClickListener {
        final /* synthetic */ d this$0;

        b(d dVar) {
            this.this$0 = dVar;
        }

        public final void onClick(View view) {
            this.this$0.close();
        }
    }

    private final boolean Pg() {
        kotlin.d dVar = this.dPS;
        j jVar = apP[0];
        return ((Boolean) dVar.getValue()).booleanValue();
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

    static {
        if (d.class.getName() == null) {
            h.aXZ();
        }
    }

    public void ND() {
        uk ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        View root = ukVar.getRoot();
        h.d(root, "binding.root");
        root.setAlpha(0.0f);
        ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        root = ukVar.getRoot();
        h.d(root, "binding.root");
        root.setTranslationX(eN(R.dimen.dp64));
        ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        ukVar.getRoot().animate().translationX(0.0f).alpha(1.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    public void NE() {
        uk ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        ukVar.getRoot().animate().translationX(eN(R.dimen.dp64)).alpha(0.0f).setInterpolator(com.iqoption.view.a.a.d.dEM).setDuration(getAnimationDuration()).start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        uk F = uk.F(layoutInflater, viewGroup, false);
        h.d(F, "this");
        this.dPR = F;
        h.d(F, "FragmentWithdrawComplete….apply { binding = this }");
        return F.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        int i2;
        int i3;
        int i4;
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        apX();
        if (Pg()) {
            i = R.drawable.ic_withdraw_success;
            i2 = R.string.requested;
            i3 = R.color.withdraw_green;
            i4 = R.string.withdrawal_request_success;
        } else {
            i = R.drawable.ic_withdraw_error;
            i2 = R.string.failed;
            i3 = R.color.red;
            i4 = R.string.the_withdraw_was_unsuccessful;
        }
        uk ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        ukVar.bGY.setImageDrawable(com.iqoption.core.ext.a.e((ViewDataBinding) ukVar, i));
        ukVar.bGZ.setText(i2);
        ukVar.bGZ.setTextColor(getColor(i3));
        ukVar.bGX.setText(i4);
    }

    private final void apX() {
        uk ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        View root = ukVar.getRoot();
        h.d(root, "binding.root");
        ((ImageView) root.findViewById(com.iqoption.b.a.toolbarBack)).setOnClickListener(new b(this));
        ukVar = this.dPR;
        if (ukVar == null) {
            h.lS("binding");
        }
        root = ukVar.getRoot();
        h.d(root, "binding.root");
        TextView textView = (TextView) root.findViewById(com.iqoption.b.a.toolbarTitle);
        h.d(textView, "binding.root.toolbarTitle");
        textView.setText(getString(R.string.withdrawal));
    }

    public boolean onBackPressed() {
        close();
        return true;
    }

    private final void close() {
        com.iqoption.core.ext.a.n(this).finish();
    }
}
