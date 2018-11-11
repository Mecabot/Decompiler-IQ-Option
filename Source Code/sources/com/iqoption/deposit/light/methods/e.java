package com.iqoption.deposit.light.methods;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ext.g;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod.PayMethodType;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.a.o;
import com.iqoption.deposit.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020(H\u0016J\u001a\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020#H\u0002R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006:"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodsLightFragment;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "Lcom/iqoption/deposit/light/methods/OnMethodCallbackLight;", "()V", "<set-?>", "Lcom/iqoption/deposit/light/methods/MethodsLightAdapter;", "adapter", "getAdapter", "()Lcom/iqoption/deposit/light/methods/MethodsLightAdapter;", "setAdapter", "(Lcom/iqoption/deposit/light/methods/MethodsLightAdapter;)V", "adapter$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/iqoption/deposit/databinding/FragmentDepositMethodsLightBinding;", "binding", "getBinding", "()Lcom/iqoption/deposit/databinding/FragmentDepositMethodsLightBinding;", "setBinding", "(Lcom/iqoption/deposit/databinding/FragmentDepositMethodsLightBinding;)V", "binding$delegate", "methods", "", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "selectedItemId", "", "viewModel", "Lcom/iqoption/deposit/light/methods/MethodsLightViewModel;", "findViewHolder", "Lcom/iqoption/deposit/light/methods/MethodLightViewHolder;", "uniqueId", "isKycLimitEnabled", "", "isSelected", "payMethod", "onCashboxLoaded", "", "cashbox", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onMethodClicked", "onSaveInstanceState", "outState", "onViewCreated", "view", "setUIStateContent", "setUIStateLoading", "setUIStateNoMethods", "shouldSelectFirstMethod", "updateItems", "Companion", "deposit_release"})
/* compiled from: MethodsLightFragment.kt */
public final class e extends com.iqoption.core.ui.fragment.b implements g {
    private static final String TAG = "com.iqoption.deposit.light.methods.e";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "binding", "getBinding()Lcom/iqoption/deposit/databinding/FragmentDepositMethodsLightBinding;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "adapter", "getAdapter()Lcom/iqoption/deposit/light/methods/MethodsLightAdapter;"))};
    public static final Comparator<com.iqoption.deposit.menu.method.b> caY = new b(new a());
    public static final c caZ = new c();
    private HashMap atz;
    private final kotlin.e.d bXo = kotlin.e.a.euA.aYg();
    private final kotlin.e.d caV = kotlin.e.a.euA.aYg();
    private MethodsLightViewModel caW;
    private String caX;
    private List<? extends PayMethod> methods;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            boolean z = false;
            Comparable valueOf = Boolean.valueOf(((com.iqoption.deposit.menu.method.b) t2).aaT().UT() == PayMethodType.UserCard);
            if (((com.iqoption.deposit.menu.method.b) t).aaT().UT() == PayMethodType.UserCard) {
                z = true;
            }
            return b.c(valueOf, Boolean.valueOf(z));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        final /* synthetic */ Comparator cba;

        public b(Comparator comparator) {
            this.cba = comparator;
        }

        public final int compare(T t, T t2) {
            int compare = this.cba.compare(t, t2);
            return compare != 0 ? compare : b.c(Boolean.valueOf(com.iqoption.core.microservices.billing.response.deposit.e.a(((com.iqoption.deposit.menu.method.b) t2).aaT())), Boolean.valueOf(com.iqoption.core.microservices.billing.response.deposit.e.a(((com.iqoption.deposit.menu.method.b) t).aaT())));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, aXE = {"Lcom/iqoption/deposit/light/methods/MethodsLightFragment$Companion;", "", "()V", "METHOD_ITEMS_COMPARATOR", "Ljava/util/Comparator;", "Lcom/iqoption/deposit/menu/method/MethodAdapterItem;", "Lkotlin/Comparator;", "STATE_SELECTED_METHOD_ID", "", "TAG", "getTAG", "()Ljava/lang/String;", "createNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: MethodsLightFragment.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }

        public final String Ll() {
            return e.TAG;
        }

        public final h abt() {
            return new h(Ll(), e.class, null, 0, 0, 0, 0, 124, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d extends g {
        final /* synthetic */ e this$0;

        public d(e eVar) {
            this.this$0 = eVar;
            super(0, 1, null);
        }

        public void q(View view) {
            kotlin.jvm.internal.h.e(view, "v");
            com.iqoption.deposit.navigator.b.cbG.a(this.this$0, false);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "cashbox", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "onChanged"})
    /* compiled from: MethodsLightFragment.kt */
    static final class e<T> implements Observer<com.iqoption.core.microservices.billing.response.deposit.b> {
        final /* synthetic */ e this$0;

        e(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: e */
        public final void onChanged(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            if (bVar != null) {
                this.this$0.ads();
                this.this$0.d(bVar);
                return;
            }
            this.this$0.adr();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onChanged"})
    /* compiled from: MethodsLightFragment.kt */
    static final class f<T> implements Observer<PayMethod> {
        final /* synthetic */ e this$0;

        f(e eVar) {
            this.this$0 = eVar;
        }

        /* renamed from: h */
        public final void onChanged(PayMethod payMethod) {
            this.this$0.caX = payMethod != null ? com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod) : null;
            this.this$0.ado();
            if (payMethod != null && com.iqoption.core.microservices.billing.response.deposit.e.a(payMethod)) {
                com.iqoption.core.f.RQ().Ds().a("deposit-page_new-card", com.iqoption.deposit.c.c.ceC.aeh());
            } else if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) {
                com.iqoption.core.f.RQ().Ds().a("deposit-page_choose-method", (double) ((com.iqoption.core.microservices.billing.response.deposit.g) payMethod).getId(), com.iqoption.deposit.c.c.ceC.aeh());
            }
        }
    }

    private final void a(o oVar) {
        this.bXo.a(this, apP[0], oVar);
    }

    private final void a(d dVar) {
        this.caV.a(this, apP[1], dVar);
    }

    private final o adm() {
        return (o) this.bXo.b(this, apP[0]);
    }

    private final d adn() {
        return (d) this.caV.b(this, apP[1]);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
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

    public static final /* synthetic */ MethodsLightViewModel e(e eVar) {
        MethodsLightViewModel methodsLightViewModel = eVar.caW;
        if (methodsLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        return methodsLightViewModel;
    }

    static {
        if (e.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.caX = bundle != null ? bundle.getString("STATE_SELECTED_METHOD_ID") : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.e(layoutInflater, "inflater");
        a((o) com.iqoption.core.ext.a.a((Fragment) this, r.g.fragment_deposit_methods_light, viewGroup, false, 4, null));
        return adm().getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        ImageView imageView = adm().bYV;
        kotlin.jvm.internal.h.d(imageView, "binding.toolbarClose");
        imageView.setOnClickListener(new d(this));
        this.caW = MethodsLightViewModel.cbc.C(this);
        RecyclerView recyclerView = adm().bxp;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        com.iqoption.core.ui.a.a(recyclerView, getResources().getDimension(com.iqoption.deposit.r.d.dp1), false);
        a(new d(this));
        recyclerView.setAdapter(adn());
        adq();
        MethodsLightViewModel methodsLightViewModel = this.caW;
        if (methodsLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        methodsLightViewModel.aaI().observe(lifecycleOwner, new e(this));
        methodsLightViewModel = this.caW;
        if (methodsLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        methodsLightViewModel.aaJ().observe(lifecycleOwner, new f(this));
    }

    private final void d(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
        int i = 0;
        Object obj = this.methods == null ? 1 : null;
        ArrayList UG = bVar.UG();
        this.methods = u.b((Collection) UG != null ? UG : m.emptyList(), (Iterable) bVar.UH());
        PayMethod payMethod = (PayMethod) null;
        if (this.caX != null) {
            for (Object next : bVar.UH()) {
                if (kotlin.jvm.internal.h.E(com.iqoption.core.microservices.billing.response.deposit.e.e((com.iqoption.core.microservices.billing.response.deposit.g) next), this.caX)) {
                    break;
                }
            }
            Object next2 = null;
            payMethod = (PayMethod) next2;
        }
        Long M = com.iqoption.deposit.navigator.b.cbG.M(this);
        if (payMethod == null && M != null) {
            for (Object next3 : bVar.UH()) {
                Object obj2;
                long id = ((com.iqoption.core.microservices.billing.response.deposit.g) next3).getId();
                if (M != null && id == M.longValue()) {
                    obj2 = 1;
                    continue;
                } else {
                    obj2 = null;
                    continue;
                }
                if (obj2 != null) {
                    break;
                }
            }
            Object next32 = null;
            payMethod = (PayMethod) next32;
        }
        if (adp()) {
            if (payMethod == null) {
                ArrayList UG2 = bVar.UG();
                payMethod = UG2 != null ? (com.iqoption.core.microservices.billing.response.deposit.h) u.bV(UG2) : null;
            }
            if (payMethod == null) {
                for (Object next4 : bVar.UH()) {
                    if (com.iqoption.core.microservices.billing.response.deposit.e.a((com.iqoption.core.microservices.billing.response.deposit.g) next4)) {
                        break;
                    }
                }
                Object next42 = null;
                payMethod = (PayMethod) next42;
            }
        }
        if (payMethod != null) {
            MethodsLightViewModel methodsLightViewModel = this.caW;
            if (methodsLightViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            methodsLightViewModel.f(payMethod);
            this.caX = com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod);
        }
        ado();
        if (M != null && obj != null) {
            for (com.iqoption.deposit.menu.method.a Jf : adn().getItems()) {
                if (kotlin.jvm.internal.h.E((String) Jf.Jf(), this.caX)) {
                    break;
                }
                i++;
            }
            i = -1;
            adm().bxp.b(i);
        }
    }

    private final void ado() {
        List list = this.methods;
        if (list != null) {
            list = m.f(m.a(m.f(u.ac(list), new MethodsLightFragment$updateItems$$inlined$let$lambda$1(abQ(), this)), caY));
            String string = getString(r.h.available);
            kotlin.jvm.internal.h.d(string, "getString(R.string.available)");
            adn().ap(u.b((Collection) l.cr(new b(string)), (Iterable) list));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.h.e(bundle, "outState");
        String str = this.caX;
        if (str != null) {
            bundle.putString("STATE_SELECTED_METHOD_ID", str);
        }
        super.onSaveInstanceState(bundle);
    }

    public void j(PayMethod payMethod) {
        kotlin.jvm.internal.h.e(payMethod, "payMethod");
        String str = this.caX;
        if (str != null) {
            a hj = hj(str);
            if (hj != null) {
                hj.cv(false);
            }
        }
        str = com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod);
        a hj2 = hj(str);
        if (hj2 != null) {
            hj2.cv(true);
        }
        this.caX = str;
        com.iqoption.core.util.j.n(zzakw());
        MethodsLightViewModel methodsLightViewModel = this.caW;
        if (methodsLightViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        methodsLightViewModel.f(payMethod);
        if (com.iqoption.core.microservices.billing.response.deposit.e.a(payMethod)) {
            com.iqoption.core.f.RQ().Ds().a("deposit-page_new-card", com.iqoption.deposit.c.c.ceC.aeh());
        } else if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) {
            com.iqoption.core.f.RQ().Ds().a("deposit-page_choose-method", (double) ((com.iqoption.core.microservices.billing.response.deposit.g) payMethod).getId(), com.iqoption.deposit.c.c.ceC.aeh());
        }
    }

    private final a hj(String str) {
        int i = 0;
        for (com.iqoption.deposit.menu.method.a aVar : adn().getItems()) {
            Object obj = ((aVar instanceof com.iqoption.deposit.menu.method.b) && kotlin.jvm.internal.h.E(com.iqoption.core.microservices.billing.response.deposit.e.e(((com.iqoption.deposit.menu.method.b) aVar).aaT()), str)) ? 1 : null;
            if (obj != null) {
                break;
            }
            i++;
        }
        i = -1;
        ViewHolder findViewHolderForLayoutPosition = adm().bxp.findViewHolderForLayoutPosition(i);
        if (!(findViewHolderForLayoutPosition instanceof a)) {
            findViewHolderForLayoutPosition = null;
        }
        return (a) findViewHolderForLayoutPosition;
    }

    public boolean k(PayMethod payMethod) {
        kotlin.jvm.internal.h.e(payMethod, "payMethod");
        return kotlin.jvm.internal.h.E(this.caX, com.iqoption.core.microservices.billing.response.deposit.e.e(payMethod));
    }

    private final boolean abQ() {
        return com.iqoption.deposit.navigator.b.cbG.J(this);
    }

    private final boolean adp() {
        return com.iqoption.deposit.navigator.b.cbG.K(this);
    }

    private final void adq() {
        FrameLayout frameLayout = adm().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        frameLayout.setVisibility(0);
        TextView textView = adm().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.M(textView);
        RecyclerView recyclerView = adm().bxp;
        kotlin.jvm.internal.h.d(recyclerView, "binding.depositMethodsList");
        com.iqoption.core.ext.a.M(recyclerView);
    }

    private final void adr() {
        FrameLayout frameLayout = adm().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        frameLayout.setVisibility(8);
        TextView textView = adm().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.L(textView);
        RecyclerView recyclerView = adm().bxp;
        kotlin.jvm.internal.h.d(recyclerView, "binding.depositMethodsList");
        com.iqoption.core.ext.a.M(recyclerView);
    }

    private final void ads() {
        FrameLayout frameLayout = adm().bYR;
        kotlin.jvm.internal.h.d(frameLayout, "binding.depositProgress");
        frameLayout.setVisibility(8);
        TextView textView = adm().bYQ;
        kotlin.jvm.internal.h.d(textView, "binding.depositError");
        com.iqoption.core.ext.a.M(textView);
        RecyclerView recyclerView = adm().bxp;
        kotlin.jvm.internal.h.d(recyclerView, "binding.depositMethodsList");
        com.iqoption.core.ext.a.L(recyclerView);
    }
}
