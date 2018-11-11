package com.iqoption.deposit.dark;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.microservices.billing.response.c;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.core.microservices.billing.response.deposit.d;
import com.iqoption.deposit.DepositSelectionViewModel;
import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.o;
import io.reactivex.s;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006J\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J8\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006&"}, aXE = {"Lcom/iqoption/deposit/dark/DepositViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "currentAmount", "Landroid/arch/lifecycle/LiveData;", "Ljava/math/BigDecimal;", "currentCurrency", "Lcom/iqoption/core/microservices/billing/response/deposit/CurrencyBilling;", "currentDeposit", "Lcom/iqoption/core/microservices/billing/response/deposit/Deposit;", "currentMethod", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getCounting", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "withKycLimit", "", "pay", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "paymentMethodId", "", "currency", "", "amount", "extraParams", "", "", "selectAmount", "", "selectCurrency", "selectDeposit", "deposit", "selectMethod", "payMethod", "Companion", "deposit_release"})
/* compiled from: DepositViewModel.kt */
public final class DepositViewModel extends ViewModel {
    public static final a bXI = new a();
    private DepositSelectionViewModel bWd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/dark/DepositViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/dark/DepositViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: DepositViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final DepositViewModel B(Fragment fragment) {
            h.e(fragment, "fragment");
            DepositViewModel depositViewModel = (DepositViewModel) ViewModelProviders.d(fragment).h(DepositViewModel.class);
            depositViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(depositViewModel, "viewModel");
            return depositViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/iqoption/core/microservices/billing/response/PayResponse;", "session", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: DepositViewModel.kt */
    static final class b<T, R> implements f<T, s<? extends R>> {
        final /* synthetic */ long bXJ;
        final /* synthetic */ String bXK;
        final /* synthetic */ BigDecimal bXL;
        final /* synthetic */ Map bXM;

        b(long j, String str, BigDecimal bigDecimal, Map map) {
            this.bXJ = j;
            this.bXK = str;
            this.bXL = bigDecimal;
            this.bXM = map;
        }

        /* renamed from: c */
        public final o<c> apply(com.iqoption.core.microservices.billing.response.b.a aVar) {
            h.e(aVar, "session");
            return com.iqoption.core.microservices.billing.a.aSZ.a(aVar.getHost(), aVar.Uy(), this.bXJ, this.bXK, this.bXL, null, this.bXM);
        }
    }

    public final e<com.iqoption.core.microservices.billing.response.deposit.b> bE(boolean z) {
        return com.iqoption.billing.repository.a.arj.bE(z);
    }

    public final void f(PayMethod payMethod) {
        h.e(payMethod, "payMethod");
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.f(payMethod);
    }

    public final LiveData<PayMethod> aaJ() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaJ();
    }

    public final void a(com.iqoption.core.microservices.billing.response.deposit.c cVar) {
        h.e(cVar, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.a(cVar);
    }

    public final LiveData<com.iqoption.core.microservices.billing.response.deposit.c> aaK() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaK();
    }

    public final void b(d dVar) {
        h.e(dVar, "deposit");
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.b(dVar);
    }

    public final LiveData<d> aaL() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaL();
    }

    public final void a(BigDecimal bigDecimal) {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.a(bigDecimal);
    }

    public final LiveData<BigDecimal> aaM() {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        return depositSelectionViewModel.aaM();
    }

    public final o<c> a(long j, String str, BigDecimal bigDecimal, Map<String, ? extends Object> map) {
        h.e(str, com.google.firebase.analytics.FirebaseAnalytics.b.CURRENCY);
        h.e(bigDecimal, "amount");
        h.e(map, "extraParams");
        o<c> k = com.iqoption.billing.repository.a.arj.JF().aVY().k(new b(j, str, bigDecimal, map));
        h.d(k, "CashBoxMediator.getSessi…l, extraParams)\n        }");
        return k;
    }
}
