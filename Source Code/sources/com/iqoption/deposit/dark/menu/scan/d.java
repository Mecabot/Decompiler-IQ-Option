package com.iqoption.deposit.dark.menu.scan;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.iqoption.core.f;
import com.iqoption.core.ui.navigation.h;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.c.c;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import com.iqoption.deposit.r;
import com.iqoption.dialogs.a.g;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, aXE = {"Lcom/iqoption/deposit/dark/menu/scan/ScanCardMenuDarkFragment;", "Lcom/iqoption/bottomsheet/BindingBottomSheetFragment;", "Lcom/iqoption/dialogs/databinding/FragmentMenuListBinding;", "Lcom/iqoption/deposit/menu/scan/ScanCardClickListener;", "()V", "navigator", "Lcom/iqoption/core/ui/navigation/StackNavigator;", "getNavigator", "()Lcom/iqoption/core/ui/navigation/StackNavigator;", "navigator$delegate", "Lkotlin/Lazy;", "scanItemToSendOnCollapse", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "viewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "onBottomSheetClosed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onScanCardClick", "scanItem", "onViewCreated", "view", "Landroid/view/View;", "provideViewBinding", "container", "Landroid/view/ViewGroup;", "Companion", "deposit_release"})
/* compiled from: ScanCardMenuDarkFragment.kt */
public final class d extends com.iqoption.bottomsheet.a<g> implements com.iqoption.deposit.menu.a.a {
    private static final String TAG = "com.iqoption.deposit.dark.menu.scan.d";
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "navigator", "getNavigator()Lcom/iqoption/core/ui/navigation/StackNavigator;"))};
    public static final a bYr = new a();
    private HashMap atz;
    private final kotlin.d bWq = g.f(new ScanCardMenuDarkFragment$navigator$2(this));
    private DepositSelectionViewModel bYp;
    private ScanItem bYq;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, aXE = {"Lcom/iqoption/deposit/dark/menu/scan/ScanCardMenuDarkFragment$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getNavigatorEntry", "Lcom/iqoption/core/ui/navigation/NavigatorEntry;", "deposit_release"})
    /* compiled from: ScanCardMenuDarkFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return d.TAG;
        }

        public final h ada() {
            return new h(Ll(), d.class, null, 0, 0, 0, 0, 124, null);
        }
    }

    private final com.iqoption.core.ui.navigation.j YT() {
        kotlin.d dVar = this.bWq;
        j jVar = apP[0];
        return (com.iqoption.core.ui.navigation.j) dVar.getValue();
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bYp = DepositSelectionViewModel.bVO.u(this);
    }

    /* renamed from: i */
    public g e(ViewGroup viewGroup) {
        kotlin.jvm.internal.h.e(viewGroup, "container");
        return (g) com.iqoption.core.ext.a.a(viewGroup, r.g.fragment_menu_list, null, false, 6, null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = ((g) getBinding()).ckU;
        kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(com.iqoption.core.ext.a.m(this)));
        recyclerView.setAdapter(new a(this));
    }

    public void JP() {
        YT().pop();
        ScanItem scanItem = this.bYq;
        if (scanItem != null) {
            DepositSelectionViewModel depositSelectionViewModel = this.bYp;
            if (depositSelectionViewModel == null) {
                kotlin.jvm.internal.h.lS("viewModel");
            }
            depositSelectionViewModel.a(scanItem);
            this.bYq = (ScanItem) null;
        }
    }

    public void d(ScanItem scanItem) {
        String str;
        kotlin.jvm.internal.h.e(scanItem, "scanItem");
        JK();
        this.bYq = scanItem;
        switch (scanItem) {
            case CAMERA:
                str = "deposit-page_scan-card-number-camera";
                break;
            case NFC:
                str = "deposit-page_scan-card-number-nfc";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        f.RQ().Ds().a(str, 0.0d, c.ceC.aeh());
    }
}
