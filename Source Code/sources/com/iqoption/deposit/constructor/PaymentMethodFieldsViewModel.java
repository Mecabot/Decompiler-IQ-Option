package com.iqoption.deposit.constructor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.data.b.b;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.constructor.selector.string.c;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/deposit/constructor/PaymentMethodFieldsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "observeSelectedInteger", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "observeSelectedStringItem", "Lcom/iqoption/deposit/constructor/selector/string/SelectorStringItem;", "selectedMethod", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "Companion", "deposit_release"})
/* compiled from: PaymentMethodFieldsViewModel.kt */
public final class PaymentMethodFieldsViewModel extends ViewModel {
    public static final a bXf = new a();
    private DepositSelectionViewModel bWd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/constructor/PaymentMethodFieldsViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/constructor/PaymentMethodFieldsViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: PaymentMethodFieldsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final PaymentMethodFieldsViewModel y(Fragment fragment) {
            h.e(fragment, "fragment");
            PaymentMethodFieldsViewModel paymentMethodFieldsViewModel = (PaymentMethodFieldsViewModel) ViewModelProviders.d(fragment).h(PaymentMethodFieldsViewModel.class);
            paymentMethodFieldsViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(paymentMethodFieldsViewModel, "viewModel");
            return paymentMethodFieldsViewModel;
        }
    }

    public final LiveData<PayMethod> acb() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaJ();
    }

    public final b<com.iqoption.deposit.constructor.selector.integer.b> acc() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaP();
    }

    public final b<c> aaQ() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaQ();
    }
}
