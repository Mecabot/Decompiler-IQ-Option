package com.iqoption.deposit.constructor.selector.integer;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.deposit.DepositSelectionViewModel;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "selectIntegerItem", "", "item", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "Companion", "deposit_release"})
/* compiled from: SelectorIntegerMenuViewModel.kt */
public final class SelectorIntegerMenuViewModel extends ViewModel {
    public static final a bXh = new a();
    private DepositSelectionViewModel bWd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerMenuViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: SelectorIntegerMenuViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final SelectorIntegerMenuViewModel z(Fragment fragment) {
            h.e(fragment, "fragment");
            SelectorIntegerMenuViewModel selectorIntegerMenuViewModel = (SelectorIntegerMenuViewModel) ViewModelProviders.d(fragment).h(SelectorIntegerMenuViewModel.class);
            selectorIntegerMenuViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(selectorIntegerMenuViewModel, "viewModel");
            return selectorIntegerMenuViewModel;
        }
    }

    public final void a(b bVar) {
        h.e(bVar, "item");
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.a(bVar);
    }
}
