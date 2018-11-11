package com.iqoption.deposit.dark.constructor.selector.integer;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.constructor.selector.integer.SelectorIntegerMenuViewModel;
import com.iqoption.deposit.constructor.selector.integer.b;
import com.iqoption.deposit.r;
import com.iqoption.dialogs.a.g;
import com.iqoption.dto.ChartTimeInterval;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/deposit/dark/constructor/selector/integer/SelectorIntegerMenuDarkFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/dialogs/databinding/FragmentMenuListBinding;", "Lcom/iqoption/deposit/constructor/selector/integer/OnIntegerItemSelectListener;", "()V", "navigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "params", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "getParams", "()Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "params$delegate", "viewModel", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuViewModel;", "onBottomSheetClosed", "", "onIntegerItemSelected", "item", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "deposit_release"})
/* compiled from: SelectorIntegerMenuDarkFragment.kt */
public final class c extends com.iqoption.bottomsheet.a<g> implements com.iqoption.deposit.constructor.selector.integer.a {
    private static final String TAG = "com.iqoption.deposit.dark.constructor.selector.integer.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "navigator", "getNavigator()Lcom/iqoption/core/ui/navigation/StackNavigator;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "params", "getParams()Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;"))};
    public static final a bYa = new a();
    private HashMap atz;
    private final d bWq = g.f(new SelectorIntegerMenuDarkFragment$navigator$2(this));
    private final d bXY = g.f(new SelectorIntegerMenuDarkFragment$params$2(this));
    private SelectorIntegerMenuViewModel bXZ;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/deposit/dark/constructor/selector/integer/SelectorIntegerMenuDarkFragment$Companion;", "", "()V", "ARG_PARAMS", "", "TAG", "getTAG", "()Ljava/lang/String;", "getNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuParams;", "deposit_release"})
    /* compiled from: SelectorIntegerMenuDarkFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return c.TAG;
        }

        public final h b(com.iqoption.deposit.constructor.selector.integer.c cVar) {
            kotlin.jvm.internal.h.e(cVar, "params");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAMS", cVar);
            return new h(Ll(), c.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    private final com.iqoption.core.ui.navigation.j YT() {
        d dVar = this.bWq;
        j jVar = apP[0];
        return (com.iqoption.core.ui.navigation.j) dVar.getValue();
    }

    private final com.iqoption.deposit.constructor.selector.integer.c acR() {
        d dVar = this.bXY;
        j jVar = apP[1];
        return (com.iqoption.deposit.constructor.selector.integer.c) dVar.getValue();
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

    /* renamed from: i */
    public g e(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return (g) com.iqoption.core.ext.a.a(viewGroup, r.g.fragment_menu_list, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.bXZ = SelectorIntegerMenuViewModel.bXh.z(this);
        RecyclerView recyclerView = ((g) getBinding()).ckU;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        a aVar = new a(this);
        recyclerView.setAdapter(aVar);
        Iterable<Number> acd = acR().acd();
        Collection arrayList = new ArrayList(n.e(acd, 10));
        for (Number intValue : acd) {
            int intValue2 = intValue.intValue();
            String fieldName = acR().getFieldName();
            Integer ace = acR().ace();
            boolean z = ace != null && intValue2 == ace.intValue();
            arrayList.add(new b(fieldName, intValue2, z));
        }
        aVar.ap((List) arrayList);
    }

    public void JP() {
        YT().pop();
    }

    public void c(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "item");
        JK();
        SelectorIntegerMenuViewModel selectorIntegerMenuViewModel = this.bXZ;
        if (selectorIntegerMenuViewModel == null) {
            kotlin.jvm.internal.h.lS("viewModel");
        }
        selectorIntegerMenuViewModel.a(bVar);
    }
}
