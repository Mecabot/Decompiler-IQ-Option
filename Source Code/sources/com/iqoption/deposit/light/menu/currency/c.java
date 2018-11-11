package com.iqoption.deposit.light.menu.currency;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.f;
import com.iqoption.deposit.menu.currency.CurrencyMenuViewModel;
import com.iqoption.deposit.menu.currency.b;
import com.iqoption.deposit.menu.method.h;
import com.iqoption.deposit.r.g;
import com.iqoption.dto.ChartTimeInterval;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/deposit/light/menu/currency/CurrencyMenuLightFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/dialogs/databinding/FragmentMenuListLightBinding;", "Lcom/iqoption/deposit/menu/method/OnCurrencyClickListener;", "()V", "navigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "params", "Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "getParams", "()Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "params$delegate", "viewModel", "Lcom/iqoption/deposit/menu/currency/CurrencyMenuViewModel;", "onBottomSheetClosed", "", "onCurrencyClicked", "currencyBilling", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "deposit_release"})
/* compiled from: CurrencyMenuLightFragment.kt */
public final class c extends com.iqoption.bottomsheet.a<com.iqoption.dialogs.a.i> implements h {
    private static final String TAG = "com.iqoption.deposit.light.menu.currency.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "navigator", "getNavigator()Lcom/iqoption/core/ui/navigation/StackNavigator;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "params", "getParams()Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;"))};
    public static final a caP = new a();
    private HashMap atz;
    private final d bWq = g.f(new CurrencyMenuLightFragment$navigator$2(this));
    private final d bXY = g.f(new CurrencyMenuLightFragment$params$2(this));
    private CurrencyMenuViewModel bYj;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/light/menu/currency/CurrencyMenuLightFragment$Companion;", "", "()V", "ARG_PARAMS", "", "TAG", "getTAG", "()Ljava/lang/String;", "getNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/deposit/menu/currency/CurrencyMenuParams;", "deposit_release"})
    /* compiled from: CurrencyMenuLightFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return c.TAG;
        }

        public final com.iqoption.core.ui.navigation.h a(b bVar) {
            kotlin.jvm.internal.h.e(bVar, "params");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAMS", bVar);
            return new com.iqoption.core.ui.navigation.h(Ll(), c.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    private final com.iqoption.core.ui.navigation.j YT() {
        d dVar = this.bWq;
        j jVar = apP[0];
        return (com.iqoption.core.ui.navigation.j) dVar.getValue();
    }

    private final b acX() {
        d dVar = this.bXY;
        j jVar = apP[1];
        return (b) dVar.getValue();
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
        if (c.class.getName() == null) {
            kotlin.jvm.internal.h.aXZ();
        }
    }

    /* renamed from: j */
    public com.iqoption.dialogs.a.i e(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return (com.iqoption.dialogs.a.i) com.iqoption.core.ext.a.a(viewGroup, g.fragment_menu_list_light, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.bYj = CurrencyMenuViewModel.cbr.E(this);
        RecyclerView recyclerView = ((com.iqoption.dialogs.a.i) getBinding()).ckU;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        a aVar = new a(this);
        recyclerView.setAdapter(aVar);
        Iterable<com.iqoption.core.microservices.billing.response.deposit.c> VF = acX().VF();
        Collection arrayList = new ArrayList(n.e(VF, 10));
        for (com.iqoption.core.microservices.billing.response.deposit.c cVar : VF) {
            long id = cVar.getId();
            Long adE = acX().adE();
            boolean z = adE != null && id == adE.longValue();
            arrayList.add(new com.iqoption.deposit.menu.currency.a(cVar, z));
        }
        aVar.ap((List) arrayList);
    }

    public void JP() {
        YT().pop();
    }

    public void d(com.iqoption.core.microservices.billing.response.deposit.c cVar) {
        kotlin.jvm.internal.h.e(cVar, "currencyBilling");
        JK();
        CurrencyMenuViewModel currencyMenuViewModel = this.bYj;
        if (currencyMenuViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        currencyMenuViewModel.a(cVar);
        f.RQ().Ds().a("deposit-page_choose-currency", (double) cVar.getId(), com.iqoption.deposit.c.c.ceC.aeh());
    }
}
