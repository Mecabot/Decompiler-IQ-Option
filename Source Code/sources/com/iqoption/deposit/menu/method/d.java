package com.iqoption.deposit.menu.method;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.f;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.e;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.c.c;
import com.iqoption.deposit.r;
import com.iqoption.dialogs.a.g;
import com.iqoption.dto.ChartTimeInterval;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodMenuFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/dialogs/databinding/FragmentMenuListBinding;", "Lcom/iqoption/deposit/menu/method/OnMethodClickListener;", "()V", "navigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "params", "Lcom/iqoption/deposit/menu/method/MethodMenuParams;", "getParams", "()Lcom/iqoption/deposit/menu/method/MethodMenuParams;", "params$delegate", "viewModel", "Lcom/iqoption/deposit/menu/method/MethodMenuViewModel;", "onBottomSheetClosed", "", "onMethodClicked", "payMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "deposit_release"})
/* compiled from: MethodMenuFragment.kt */
public final class d extends com.iqoption.bottomsheet.a<g> implements i {
    private static final String TAG = "com.iqoption.deposit.menu.method.d";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "navigator", "getNavigator()Lcom/iqoption/core/ui/navigation/StackNavigator;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "params", "getParams()Lcom/iqoption/deposit/menu/method/MethodMenuParams;"))};
    public static final a cbx = new a();
    private HashMap atz;
    private final kotlin.d bWq = g.f(new MethodMenuFragment$navigator$2(this));
    private final kotlin.d bXY = g.f(new MethodMenuFragment$params$2(this));
    private MethodMenuViewModel cbw;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/menu/method/MethodMenuFragment$Companion;", "", "()V", "ARG_PARAMS", "", "TAG", "getTAG", "()Ljava/lang/String;", "getNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/deposit/menu/method/MethodMenuParams;", "deposit_release"})
    /* compiled from: MethodMenuFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        public final h a(e eVar) {
            kotlin.jvm.internal.h.e(eVar, "params");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAMS", eVar);
            return new h(Ll(), d.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    /* compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return b.c(Boolean.valueOf(e.a(((b) t2).aaT())), Boolean.valueOf(e.a(((b) t).aaT())));
        }
    }

    private final com.iqoption.core.ui.navigation.j YT() {
        kotlin.d dVar = this.bWq;
        j jVar = apP[0];
        return (com.iqoption.core.ui.navigation.j) dVar.getValue();
    }

    private final e adG() {
        kotlin.d dVar = this.bXY;
        j jVar = apP[1];
        return (e) dVar.getValue();
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

    static {
        if (d.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    /* renamed from: i */
    public g e(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return (g) com.iqoption.core.ext.a.a(viewGroup, r.g.fragment_menu_list, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.cbw = MethodMenuViewModel.cbA.F(this);
        RecyclerView recyclerView = ((g) getBinding()).ckU;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        g gVar = new g(this);
        recyclerView.setAdapter(gVar);
        String adK = adG().adK();
        List adI = adG().adI();
        if (adI == null) {
            adI = m.emptyList();
        }
        Iterable<PayMethod> b = u.b((Collection) adI, (Iterable) adG().adJ());
        Collection arrayList = new ArrayList(n.e(b, 10));
        for (PayMethod payMethod : b) {
            arrayList.add(new b(payMethod, adG().abQ(), kotlin.jvm.internal.h.E(adK, e.e(payMethod)), null, 8, null));
        }
        gVar.ap(u.a((Iterable) (List) arrayList, (Comparator) new b()));
    }

    public void JP() {
        YT().pop();
    }

    public void j(PayMethod payMethod) {
        kotlin.jvm.internal.h.e(payMethod, "payMethod");
        JK();
        MethodMenuViewModel methodMenuViewModel = this.cbw;
        if (methodMenuViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        methodMenuViewModel.f(payMethod);
        if (e.a(payMethod)) {
            f.RQ().Ds().a("deposit-page_new-card", c.ceC.aeh());
        } else if (payMethod instanceof com.iqoption.core.microservices.billing.response.deposit.g) {
            f.RQ().Ds().a("deposit-page_choose-method", (double) ((com.iqoption.core.microservices.billing.response.deposit.g) payMethod).getId(), c.ceC.aeh());
        }
    }
}
