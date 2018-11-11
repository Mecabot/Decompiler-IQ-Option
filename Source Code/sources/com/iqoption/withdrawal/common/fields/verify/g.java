package com.iqoption.withdrawal.common.fields.verify;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.us;
import com.iqoption.fragment.base.f;
import com.iqoption.kyc.fragment.jumio.e;
import com.iqoption.mobbtech.connect.response.q;
import com.iqoption.util.ar;
import com.iqoption.verify.VerifyCardsActivity;
import com.iqoption.view.drumview.recyclerviewpager.RecyclerViewPager;
import com.iqoption.x.R;
import com.rd.PageIndicatorView;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010&\u001a\u00020\u0010H\u0002J\u0016\u0010'\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006+"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "Lcom/iqoption/withdrawal/common/fields/verify/WarningListener;", "()V", "adapter", "Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyWarningAdapter;", "allWarnings", "", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "binding", "Lcom/iqoption/databinding/FragmentWithdrawVerifyBinding;", "shouldShowWarnings", "", "viewModel", "Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyViewModel;", "hideContent", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDocWarningClick", "onMultipleCardsWarningClick", "onSingleCardWarningClick", "card", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "onViewCreated", "view", "showContent", "showWarnings", "warnings", "updateShouldShowWarnings", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawVerifyFragment.kt */
public final class g extends f implements f {
    private static final String TAG = "com.iqoption.withdrawal.common.fields.verify.g";
    public static final a dQH = new a();
    private HashMap atz;
    private WithdrawVerifyViewModel dQC;
    private us dQD;
    private h dQE;
    private boolean dQF;
    private List<? extends d> dQG;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyFragment$Companion;", "", "()V", "REQUEST_CODE_CARDS", "", "REQUEST_CODE_KYC", "TAG", "", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/iqoption/withdrawal/common/fields/verify/WithdrawVerifyFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawVerifyFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return g.TAG;
        }

        public final g aNv() {
            return new g();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$doOnLayout$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d implements OnGlobalLayoutListener {
        final /* synthetic */ View aGz;
        final /* synthetic */ g dQJ;
        final /* synthetic */ LinearLayout dQK;
        final /* synthetic */ List dQL;
        final /* synthetic */ LinearLayout dQM;
        final /* synthetic */ PageIndicatorView dQN;

        public d(View view, LinearLayout linearLayout, g gVar, List list, LinearLayout linearLayout2, PageIndicatorView pageIndicatorView) {
            this.aGz = view;
            this.dQK = linearLayout;
            this.dQJ = gVar;
            this.dQL = list;
            this.dQM = linearLayout2;
            this.dQN = pageIndicatorView;
        }

        public void onGlobalLayout() {
            if (ViewCompat.isLaidOut(this.dQK)) {
                this.aGz.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                h a = g.a(this.dQJ);
                List list = this.dQL;
                LinearLayout linearLayout = this.dQM;
                h.d(linearLayout, "container");
                a.c(list, linearLayout.getMeasuredWidth());
                PageIndicatorView pageIndicatorView = this.dQN;
                h.d(pageIndicatorView, "indicator");
                RecyclerViewPager recyclerViewPager = g.b(this.dQJ).bHr;
                h.d(recyclerViewPager, "binding.withdrawVerifyPager");
                pageIndicatorView.setSelection(recyclerViewPager.getCurrentPosition());
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "", "newPosition", "OnPageChanged"})
    /* compiled from: WithdrawVerifyFragment.kt */
    static final class b implements com.iqoption.view.drumview.recyclerviewpager.RecyclerViewPager.a {
        final /* synthetic */ PageIndicatorView dQI;

        b(PageIndicatorView pageIndicatorView) {
            this.dQI = pageIndicatorView;
        }

        public final void an(int i, int i2) {
            PageIndicatorView pageIndicatorView = this.dQI;
            h.d(pageIndicatorView, "indicator");
            pageIndicatorView.setSelection(i2);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "warnings", "", "Lcom/iqoption/withdrawal/common/fields/verify/VerificationWarning;", "onChanged"})
    /* compiled from: WithdrawVerifyFragment.kt */
    static final class c<T> implements Observer<List<? extends d>> {
        final /* synthetic */ g dQJ;

        c(g gVar) {
            this.dQJ = gVar;
        }

        /* renamed from: L */
        public final void onChanged(List<? extends d> list) {
            if (list != null) {
                this.dQJ.dQG = list;
                this.dQJ.bB(list);
            }
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

    public static final /* synthetic */ h a(g gVar) {
        h hVar = gVar.dQE;
        if (hVar == null) {
            h.lS("adapter");
        }
        return hVar;
    }

    public static final /* synthetic */ us b(g gVar) {
        us usVar = gVar.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        return usVar;
    }

    static {
        if (g.class.getName() == null) {
            h.aXZ();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        this.dQD = (us) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.fragment_withdraw_verify, viewGroup, false, 4, null);
        us usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        return usVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.dQC = WithdrawVerifyViewModel.dQT.M(com.iqoption.core.ext.a.n(this));
        aNu();
        us usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        RecyclerViewPager recyclerViewPager = usVar.bHr;
        h.d(recyclerViewPager, "pager");
        recyclerViewPager.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this), 0, false));
        this.dQE = new h(com.iqoption.core.ext.a.m(this), this);
        h hVar = this.dQE;
        if (hVar == null) {
            h.lS("adapter");
        }
        recyclerViewPager.setAdapter(hVar);
        us usVar2 = this.dQD;
        if (usVar2 == null) {
            h.lS("binding");
        }
        recyclerViewPager.a(new b(usVar2.bHq));
        WithdrawVerifyViewModel withdrawVerifyViewModel = this.dQC;
        if (withdrawVerifyViewModel == null) {
            h.lS("viewModel");
        }
        ar.a(withdrawVerifyViewModel.aNw(), (Fragment) this, (Observer) new c(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        WithdrawVerifyViewModel withdrawVerifyViewModel;
        if (i == 100) {
            withdrawVerifyViewModel = this.dQC;
            if (withdrawVerifyViewModel == null) {
                h.lS("viewModel");
            }
            withdrawVerifyViewModel.aNz();
        } else if (i == 200) {
            withdrawVerifyViewModel = this.dQC;
            if (withdrawVerifyViewModel == null) {
                h.lS("viewModel");
            }
            withdrawVerifyViewModel.aNB();
        }
    }

    private final void bB(List<? extends d> list) {
        us usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        View root = usVar.getRoot();
        if (root == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        TransitionManager.beginDelayedTransition((ViewGroup) root);
        if (list.isEmpty() || !this.dQF) {
            aNu();
            return;
        }
        aGU();
        usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        PageIndicatorView pageIndicatorView = usVar.bHq;
        if (list.size() > 1) {
            h.d(pageIndicatorView, "indicator");
            pageIndicatorView.setCount(list.size());
            com.iqoption.core.ext.a.L(pageIndicatorView);
        } else {
            h.d(pageIndicatorView, "indicator");
            com.iqoption.core.ext.a.M(pageIndicatorView);
        }
        usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = usVar.bHp;
        h.d(linearLayout, "container");
        View view = linearLayout;
        if (ViewCompat.isLaidOut(view)) {
            a(this).c(list, linearLayout.getMeasuredWidth());
            RecyclerViewPager recyclerViewPager = b(this).bHr;
            h.d(recyclerViewPager, "binding.withdrawVerifyPager");
            pageIndicatorView.setSelection(recyclerViewPager.getCurrentPosition());
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new d(view, linearLayout, this, list, linearLayout, pageIndicatorView));
        }
    }

    public void aNs() {
        new com.iqoption.kyc.activity.KycActivity.a(com.iqoption.core.ext.a.n(this)).ic(e.TAG).dR(false).f(this, 100);
    }

    public void m(q qVar) {
        h.e(qVar, "card");
        VerifyCardsActivity.dxn.a((Fragment) this, 200, qVar);
    }

    public void aNt() {
        com.iqoption.verify.VerifyCardsActivity.a.a(VerifyCardsActivity.dxn, (Fragment) this, 200, null, 4, null);
    }

    public final void fA(boolean z) {
        this.dQF = z;
        List list = this.dQG;
        if (list != null) {
            bB(list);
        }
    }

    private final void aGU() {
        us usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = usVar.bHp;
        h.d(linearLayout, "binding.withdrawVerifyContainer");
        com.iqoption.core.ext.a.L(linearLayout);
    }

    private final void aNu() {
        us usVar = this.dQD;
        if (usVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = usVar.bHp;
        h.d(linearLayout, "binding.withdrawVerifyContainer");
        com.iqoption.core.ext.a.M(linearLayout);
    }
}
