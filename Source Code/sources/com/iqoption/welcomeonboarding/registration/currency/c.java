package com.iqoption.welcomeonboarding.registration.currency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.dialogs.a.g;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.dto.Currencies.Currency;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/dialogs/databinding/FragmentMenuListBinding;", "Lcom/iqoption/welcomeonboarding/registration/currency/OnCurrencyClickListener;", "()V", "params", "Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "getParams", "()Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "params$delegate", "Lkotlin/Lazy;", "onBottomSheetClosed", "", "onCurrencyClicked", "currency", "Lcom/iqoption/dto/Currencies$Currency;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CurrencyMenuFragment.kt */
public final class c extends com.iqoption.bottomsheet.a<g> implements f {
    private static final String TAG = "com.iqoption.welcomeonboarding.registration.currency.c";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(c.class), "params", "getParams()Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;"))};
    public static final a dNu = new a();
    private HashMap atz;
    private final d bXY = g.f(new CurrencyMenuFragment$params$2(this));

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, aXE = {"Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuFragment$Companion;", "", "()V", "ARG_PARAMS", "", "TAG", "getTAG", "()Ljava/lang/String;", "getNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "params", "Lcom/iqoption/welcomeonboarding/registration/currency/CurrencyMenuParams;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: CurrencyMenuFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return c.TAG;
        }

        public final h a(d dVar) {
            kotlin.jvm.internal.h.e(dVar, "params");
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARG_PARAMS", dVar);
            return new h(Ll(), c.class, bundle, 0, 0, 0, 0, ChartTimeInterval.CANDLE_2m, null);
        }
    }

    private final d aMz() {
        d dVar = this.bXY;
        j jVar = apP[0];
        return (d) dVar.getValue();
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
        return (g) com.iqoption.core.ext.a.a(viewGroup, (int) R.layout.fragment_menu_list, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = ((g) getBinding()).ckU;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        a aVar = new a(this);
        recyclerView.setAdapter(aVar);
        Iterable<Currency> VF = aMz().VF();
        Collection arrayList = new ArrayList(n.e(VF, 10));
        for (Currency currency : VF) {
            arrayList.add(new b(currency, kotlin.jvm.internal.h.E(currency.id, aMz().ace())));
        }
        aVar.ap((List) arrayList);
    }

    public void JP() {
        if (!isStateSaved()) {
            com.iqoption.core.ext.a.p(this).popBackStack();
        }
    }

    public void b(Currency currency) {
        kotlin.jvm.internal.h.e(currency, b.CURRENCY);
        JK();
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof f)) {
            parentFragment = null;
        }
        f fVar = (f) parentFragment;
        if (fVar != null) {
            fVar.b(currency);
        }
    }
}
