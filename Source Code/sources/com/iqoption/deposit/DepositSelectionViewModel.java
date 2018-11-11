package com.iqoption.deposit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.b;
import com.iqoption.core.microservices.billing.response.deposit.c;
import com.iqoption.core.microservices.billing.response.deposit.d;
import com.iqoption.deposit.card.ScanViewModel.ScanItem;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0018J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0018J\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0018J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0018J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u0012J\u000e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0016J\u000e\u0010.\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010\bJ\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, aXE = {"Lcom/iqoption/deposit/DepositSelectionViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "amountLiveData", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "Ljava/math/BigDecimal;", "cashboxLiveData", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "currencyLiveData", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "depositLiveData", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "fieldSelectIntegerLiveData", "Lcom/iqoption/deposit/constructor/selector/integer/SelectorIntegerAdapterItem;", "fieldSelectStringLiveData", "Lcom/iqoption/deposit/constructor/selector/string/SelectorStringItem;", "methodLiveData", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "nfcCardLiveData", "Lcom/iqoption/deposit/card/NfcCardScanner$NfcCard;", "scanCardLiveData", "Lcom/iqoption/deposit/card/ScanViewModel$ScanItem;", "currentAmount", "Landroid/arch/lifecycle/LiveData;", "currentCurrency", "currentDeposit", "currentMethod", "currentScanItem", "loadedCashbox", "observeSelectedIntegerItem", "observeSelectedStringItem", "observerNfcCard", "selectAmount", "", "amount", "selectCurrency", "currencyWithPresets", "selectDeposit", "deposit", "selectIntegerItem", "item", "selectMethod", "payMethod", "selectScanItem", "scanItem", "selectStringItem", "setLoadedCashbox", "counting", "setNfcCard", "nfcCard", "Companion", "deposit_release"})
/* compiled from: DepositSelectionViewModel.kt */
public final class DepositSelectionViewModel extends ViewModel {
    public static final a bVO = new a();
    private final MutableLiveData<b> bVF = new MutableLiveData();
    private final MutableLiveData<PayMethod> bVG = new MutableLiveData();
    private final MutableLiveData<c> bVH = new MutableLiveData();
    private final com.iqoption.core.data.b.b<d> bVI = new com.iqoption.core.data.b.b();
    private final com.iqoption.core.data.b.b<BigDecimal> bVJ = new com.iqoption.core.data.b.b();
    private final com.iqoption.core.data.b.b<ScanItem> bVK = new com.iqoption.core.data.b.b();
    private final com.iqoption.core.data.b.b<com.iqoption.deposit.constructor.selector.integer.b> bVL = new com.iqoption.core.data.b.b();
    private final com.iqoption.core.data.b.b<com.iqoption.deposit.constructor.selector.string.c> bVM = new com.iqoption.core.data.b.b();
    private final com.iqoption.core.data.b.b<com.iqoption.deposit.card.d.a> bVN = new com.iqoption.core.data.b.b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/DepositSelectionViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "child", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: DepositSelectionViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final DepositSelectionViewModel u(Fragment fragment) {
            h.e(fragment, "child");
            com.iqoption.deposit.navigator.b bVar = (com.iqoption.deposit.navigator.b) (!(fragment instanceof com.iqoption.deposit.navigator.b) ? null : fragment);
            if (bVar == null) {
                bVar = (com.iqoption.deposit.navigator.b) com.iqoption.core.ext.a.a(fragment, com.iqoption.deposit.navigator.b.class);
            }
            ViewModel h = ViewModelProviders.d((Fragment) bVar).h(DepositSelectionViewModel.class);
            h.d(h, "ViewModelProviders.of(fr…ionViewModel::class.java]");
            return (DepositSelectionViewModel) h;
        }
    }

    public final void a(b bVar) {
        this.bVF.postValue(bVar);
    }

    public final LiveData<b> aaI() {
        return this.bVF;
    }

    public final void f(PayMethod payMethod) {
        this.bVG.postValue(payMethod);
    }

    public final LiveData<PayMethod> aaJ() {
        return this.bVG;
    }

    public final void a(c cVar) {
        h.e(cVar, "currencyWithPresets");
        this.bVH.postValue(cVar);
    }

    public final LiveData<c> aaK() {
        return this.bVH;
    }

    public final void b(d dVar) {
        h.e(dVar, "deposit");
        this.bVI.postValue(dVar);
    }

    public final LiveData<d> aaL() {
        return this.bVI;
    }

    public final void a(BigDecimal bigDecimal) {
        this.bVJ.postValue(bigDecimal);
    }

    public final LiveData<BigDecimal> aaM() {
        return this.bVJ;
    }

    public final void a(ScanItem scanItem) {
        h.e(scanItem, "scanItem");
        this.bVK.postValue(scanItem);
    }

    public final LiveData<ScanItem> aaN() {
        return this.bVK;
    }

    public final void a(com.iqoption.deposit.card.d.a aVar) {
        h.e(aVar, "nfcCard");
        this.bVN.postValue(aVar);
    }

    public final LiveData<com.iqoption.deposit.card.d.a> aaO() {
        return this.bVN;
    }

    public final void a(com.iqoption.deposit.constructor.selector.integer.b bVar) {
        h.e(bVar, "item");
        this.bVL.postValue(bVar);
    }

    public final com.iqoption.core.data.b.b<com.iqoption.deposit.constructor.selector.integer.b> aaP() {
        return this.bVL;
    }

    public final void a(com.iqoption.deposit.constructor.selector.string.c cVar) {
        h.e(cVar, "item");
        this.bVM.postValue(cVar);
    }

    public final com.iqoption.core.data.b.b<com.iqoption.deposit.constructor.selector.string.c> aaQ() {
        return this.bVM;
    }
}
