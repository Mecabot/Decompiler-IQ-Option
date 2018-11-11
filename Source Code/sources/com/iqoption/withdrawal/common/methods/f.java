package com.iqoption.withdrawal.common.methods;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v7.widget.CardView2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.d.amv;
import com.iqoption.d.uq;
import com.iqoption.mobbtech.connect.response.g;
import com.iqoption.withdrawal.common.e;
import com.iqoption.x.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001fH\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0016\u0010*\u001a\u00020\u001c2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006."}, aXE = {"Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsFragment;", "Lcom/iqoption/fragment/base/IQFragment;", "()V", "binding", "Lcom/iqoption/databinding/FragmentWithdrawMethodsBinding;", "callbacks", "Lcom/iqoption/withdrawal/common/MethodsCallback;", "getCallbacks", "()Lcom/iqoption/withdrawal/common/MethodsCallback;", "setCallbacks", "(Lcom/iqoption/withdrawal/common/MethodsCallback;)V", "data", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsData;", "restoredSelectedMethod", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "selectedMethod", "viewModel", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsViewModel;", "createMethodView", "Landroid/view/View;", "layoutInflater", "Landroid/view/LayoutInflater;", "enabledContainer", "Landroid/widget/LinearLayout;", "method", "mask", "", "highlightSelectedMethod", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "container", "Landroid/view/ViewGroup;", "onDataLoaded", "onSaveInstanceState", "outState", "onViewCreated", "view", "performMethodSelection", "showMethods", "methods", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawMethodsFragment.kt */
public final class f extends com.iqoption.fragment.base.f {
    public static final String TAG = "com.iqoption.withdrawal.common.methods.f";
    public static final a dRH = new a();
    private HashMap atz;
    private com.iqoption.microservice.withdraw.response.a dQA;
    private uq dRC;
    private WithdrawMethodsViewModel dRD;
    private e dRE;
    private com.iqoption.microservice.withdraw.response.a dRF;
    private com.iqoption.withdrawal.common.c dRG;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, aXE = {"Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsFragment$Companion;", "", "()V", "STATE_SELECTED_METHOD", "", "TAG", "newInstance", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsFragment;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawMethodsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final f aNT() {
            return new f();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawMethodsFragment.kt */
    static final class c implements OnClickListener {
        final /* synthetic */ com.iqoption.microservice.withdraw.response.a dQy;
        final /* synthetic */ f dRI;

        c(f fVar, com.iqoption.microservice.withdraw.response.a aVar) {
            this.dRI = fVar;
            this.dQy = aVar;
        }

        public final void onClick(View view) {
            this.dRI.f(this.dQy);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* compiled from: WithdrawMethodsFragment.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ f dRI;
        final /* synthetic */ String dRJ;

        d(f fVar, String str) {
            this.dRI = fVar;
            this.dRJ = str;
        }

        public final void onClick(View view) {
            e.dPW.a(com.iqoption.core.ext.a.p(this.dRI), R.id.withdrawOtherContainer, null, this.dRJ);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "value", "Lcom/iqoption/withdrawal/common/methods/WithdrawMethodsData;", "onChanged"})
    /* compiled from: WithdrawMethodsFragment.kt */
    static final class b<T> implements Observer<e> {
        final /* synthetic */ f dRI;

        b(f fVar) {
            this.dRI = fVar;
        }

        /* renamed from: b */
        public final void onChanged(e eVar) {
            if (eVar != null) {
                boolean isEmpty = eVar.atC().isEmpty() ^ 1;
                com.iqoption.withdrawal.common.c aNS = this.dRI.aNS();
                if (aNS == null) {
                    h.aXZ();
                }
                aNS.fw(isEmpty);
                if (isEmpty) {
                    this.dRI.a(eVar);
                    return;
                }
                return;
            }
            com.iqoption.withdrawal.common.c aNS2 = this.dRI.aNS();
            if (aNS2 == null) {
                h.aXZ();
            }
            aNS2.b(new g());
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

    static {
        if (f.class.getName() == null) {
            h.aXZ();
        }
    }

    public final void a(com.iqoption.withdrawal.common.c cVar) {
        this.dRG = cVar;
    }

    public final com.iqoption.withdrawal.common.c aNS() {
        return this.dRG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dRF = bundle != null ? (com.iqoption.microservice.withdraw.response.a) bundle.getParcelable("STATE_SELECTED_METHOD") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        uq I = uq.I(layoutInflater, viewGroup, false);
        h.d(I, "this");
        this.dRC = I;
        h.d(I, "FragmentWithdrawMethodsB….apply { binding = this }");
        return I.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.dRD = WithdrawMethodsViewModel.dRN.O(com.iqoption.core.ext.a.n(this));
        WithdrawMethodsViewModel withdrawMethodsViewModel = this.dRD;
        if (withdrawMethodsViewModel == null) {
            h.lS("viewModel");
        }
        withdrawMethodsViewModel.k(true, true).observe(this, new b(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.e(bundle, "outState");
        com.iqoption.microservice.withdraw.response.a aVar = this.dQA;
        if (aVar != null) {
            bundle.putParcelable("STATE_SELECTED_METHOD", aVar);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARNING: Missing block: B:11:0x0030, code:
            if (r4 != null) goto L_0x0052;
     */
    private final void a(com.iqoption.withdrawal.common.methods.e r7) {
        /*
        r6 = this;
        r6.dRE = r7;
        r0 = r7.atC();
        r7 = r7.aNR();
        r1 = r6.dQA;
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0011;
    L_0x000f:
        r1 = r6.dRF;
    L_0x0011:
        r2 = 0;
        if (r1 == 0) goto L_0x0033;
    L_0x0014:
        r3 = r0;
        r3 = (java.lang.Iterable) r3;
        r3 = r3.iterator();
    L_0x001b:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x002f;
    L_0x0021:
        r4 = r3.next();
        r5 = r4;
        r5 = (com.iqoption.microservice.withdraw.response.a) r5;
        r5 = com.iqoption.microservice.withdraw.response.i.a(r5, r1);
        if (r5 == 0) goto L_0x001b;
    L_0x002e:
        goto L_0x0030;
    L_0x002f:
        r4 = r2;
    L_0x0030:
        if (r4 == 0) goto L_0x0033;
    L_0x0032:
        goto L_0x0052;
    L_0x0033:
        r1 = r0;
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
    L_0x003a:
        r3 = r1.hasNext();
        if (r3 == 0) goto L_0x0069;
    L_0x0040:
        r3 = r1.next();
        r3 = (com.iqoption.microservice.withdraw.response.a) r3;
        r4 = r7.get(r3);
        if (r4 != 0) goto L_0x004e;
    L_0x004c:
        r4 = 1;
        goto L_0x004f;
    L_0x004e:
        r4 = 0;
    L_0x004f:
        if (r4 == 0) goto L_0x003a;
    L_0x0051:
        r1 = r3;
    L_0x0052:
        r6.bG(r0);
        r7 = r6.dQA;
        r7 = com.iqoption.microservice.withdraw.response.i.a(r1, r7);
        if (r7 != 0) goto L_0x0061;
    L_0x005d:
        r6.f(r1);
        goto L_0x0064;
    L_0x0061:
        r6.g(r1);
    L_0x0064:
        r2 = (com.iqoption.microservice.withdraw.response.a) r2;
        r6.dRF = r2;
        return;
    L_0x0069:
        r7 = new java.util.NoSuchElementException;
        r0 = "Collection contains no element matching the predicate.";
        r7.<init>(r0);
        r7 = (java.lang.Throwable) r7;
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.withdrawal.common.methods.f.a(com.iqoption.withdrawal.common.methods.e):void");
    }

    private final void bG(List<? extends com.iqoption.microservice.withdraw.response.a> list) {
        LayoutInflater from = LayoutInflater.from(getContext());
        uq uqVar = this.dRC;
        if (uqVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = uqVar.bHn;
        uq uqVar2 = this.dRC;
        if (uqVar2 == null) {
            h.lS("binding");
        }
        View root = uqVar2.getRoot();
        h.d(root, "binding.root");
        LinearLayout linearLayout2 = (LinearLayout) root.findViewById(com.iqoption.b.a.withdrawDisabledMethodsContainer);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        e eVar = this.dRE;
        if (eVar == null) {
            h.aXZ();
        }
        Map aNR = eVar.aNR();
        for (com.iqoption.microservice.withdraw.response.a aVar : list) {
            String str = (String) aNR.get(aVar);
            h.d(from, "layoutInflater");
            h.d(linearLayout, "enabledContainer");
            String str2 = eVar.aNe().mask;
            h.d(str2, "dataLocal.conversion.mask");
            View a = a(from, linearLayout, aVar, str2);
            if (str == null) {
                ((CardView2) a.findViewById(com.iqoption.b.a.withdrawMethodContainer)).setOnClickListener(new c(this, aVar));
                linearLayout.addView(a);
            } else {
                ((CardView2) a.findViewById(com.iqoption.b.a.withdrawMethodContainer)).setOnClickListener(new d(this, str));
                linearLayout2.addView(a);
            }
        }
        uq uqVar3 = this.dRC;
        if (uqVar3 == null) {
            h.lS("binding");
        }
        View root2 = uqVar3.getRoot();
        h.d(root2, "binding.root");
        LinearLayout linearLayout3 = (LinearLayout) root2.findViewById(com.iqoption.b.a.withdrawDisabledLayout);
        h.d(linearLayout3, "binding.root.withdrawDisabledLayout");
        h.d(linearLayout2, "disabledContainer");
        linearLayout3.setVisibility(linearLayout2.getChildCount() > 0 ? 0 : 8);
    }

    private final View a(LayoutInflater layoutInflater, LinearLayout linearLayout, com.iqoption.microservice.withdraw.response.a aVar, String str) {
        amv aE = amv.aE(layoutInflater, linearLayout, false);
        h.d(aE, "binding");
        View root = aE.getRoot();
        h.d(root, Promotion.ACTION_VIEW);
        root.setTag(new b(aE, aVar, str));
        return root;
    }

    private final void f(com.iqoption.microservice.withdraw.response.a aVar) {
        this.dQA = aVar;
        g(aVar);
        uq uqVar = this.dRC;
        if (uqVar == null) {
            h.lS("binding");
        }
        uqVar.bHn.requestFocus();
        WithdrawMethodsViewModel withdrawMethodsViewModel = this.dRD;
        if (withdrawMethodsViewModel == null) {
            h.lS("viewModel");
        }
        e eVar = this.dRE;
        if (eVar == null) {
            h.aXZ();
        }
        withdrawMethodsViewModel.a(eVar, aVar);
    }

    private final void g(com.iqoption.microservice.withdraw.response.a aVar) {
        uq uqVar = this.dRC;
        if (uqVar == null) {
            h.lS("binding");
        }
        LinearLayout linearLayout = uqVar.bHn;
        h.d(linearLayout, "enabledMethodsContainer");
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            h.d(childAt, Promotion.ACTION_VIEW);
            Object tag = childAt.getTag();
            if (tag == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.withdrawal.common.methods.MethodHolder");
            }
            b bVar = (b) tag;
            boolean a = com.iqoption.microservice.withdraw.response.i.a(bVar.aNc(), aVar);
            childAt = bVar.aNQ().getRoot();
            h.d(childAt, "holder.binding.root");
            CardView2 cardView2 = (CardView2) childAt.findViewById(com.iqoption.b.a.withdrawMethodContainer);
            h.d(cardView2, "cardView");
            cardView2.setCardElevation(a ? 0.0f : eN(R.dimen.withdraw_method_elevation));
            cardView2.setForeground(getDrawable(a ? R.drawable.withdraw_method_selected : R.drawable.withdraw_method_normal));
        }
    }
}
