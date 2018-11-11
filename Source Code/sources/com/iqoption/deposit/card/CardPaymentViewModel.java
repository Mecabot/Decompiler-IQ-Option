package com.iqoption.deposit.card;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/deposit/card/CardPaymentViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "currentMethod", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "currentScanItem", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "observerNfcCard", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "Companion", "deposit_release"})
/* compiled from: CardPaymentViewModel.kt */
public final class CardPaymentViewModel extends ViewModel {
    public static final a bWe = new a();
    private DepositSelectionViewModel bWd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/card/CardPaymentViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/card/CardPaymentViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: CardPaymentViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final CardPaymentViewModel v(Fragment fragment) {
            h.e(fragment, "fragment");
            CardPaymentViewModel cardPaymentViewModel = (CardPaymentViewModel) ViewModelProviders.d(fragment).h(CardPaymentViewModel.class);
            cardPaymentViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(cardPaymentViewModel, "viewModel");
            return cardPaymentViewModel;
        }
    }

    public final LiveData<PayMethod> aaJ() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaJ();
    }

    public final LiveData<ScanItem> aaN() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaN();
    }

    public final LiveData<com.iqoption.deposit.card.d.a> aaO() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaO();
    }
}
