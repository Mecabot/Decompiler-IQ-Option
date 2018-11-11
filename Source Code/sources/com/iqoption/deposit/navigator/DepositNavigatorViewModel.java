package com.iqoption.deposit.navigator;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import com.iqoption.core.connect.bus.IQBusState;
import com.iqoption.core.microservices.billing.response.deposit.PayMethod;
import com.iqoption.deposit.DepositSelectionViewModel;
import com.iqoption.deposit.p;
import io.reactivex.c.f;
import io.reactivex.e;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nJ\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, aXE = {"Lcom/iqoption/deposit/navigator/DepositNavigatorViewModel;", "Landroid/arch/lifecycle/ViewModel;", "Lcom/iqoption/deposit/web/BaseRedirectWebPaymentFragment$OnFragmentInteractionListener;", "()V", "depositSelectionViewModel", "Lcom/iqoption/deposit/DepositSelectionViewModel;", "webPaymentResultEvent", "Lcom/iqoption/core/data/livedata/IQLiveEvent;", "Lcom/iqoption/deposit/navigator/WebPaymentResult;", "currentMethod", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/core/microservices/billing/response/deposit/PayMethod;", "getCounting", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "withKycLimit", "", "getCountingFlowable", "Lio/reactivex/Flowable;", "isMethodSelected", "onDepositPageWebPaymentResult", "", "isSuccess", "depositParams", "Lcom/iqoption/deposit/DepositParams;", "onDepositPageWebPaymentStartAgain", "selectMethod", "payMethod", "setLoadedCashbox", "counting", "webPaymentResultEvents", "Companion", "deposit_release"})
/* compiled from: DepositNavigatorViewModel.kt */
public final class DepositNavigatorViewModel extends ViewModel implements com.iqoption.deposit.web.a.b {
    public static final a cbJ = new a();
    private DepositSelectionViewModel bWd;
    private final com.iqoption.core.data.b.b<d> cbI = new com.iqoption.core.data.b.b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/navigator/DepositNavigatorViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/deposit/navigator/DepositNavigatorViewModel;", "fragment", "Landroid/support/v4/app/Fragment;", "deposit_release"})
    /* compiled from: DepositNavigatorViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final DepositNavigatorViewModel O(Fragment fragment) {
            h.e(fragment, "fragment");
            DepositNavigatorViewModel depositNavigatorViewModel = (DepositNavigatorViewModel) ViewModelProviders.d(fragment).h(DepositNavigatorViewModel.class);
            depositNavigatorViewModel.bWd = DepositSelectionViewModel.bVO.u(fragment);
            h.d(depositNavigatorViewModel, "viewModel");
            return depositNavigatorViewModel;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "it", "apply"})
    /* compiled from: DepositNavigatorViewModel.kt */
    static final class b<T, R> implements f<T, R> {
        public static final b cbK = new b();

        b() {
        }

        /* renamed from: f */
        public final com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b> apply(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
            h.e(bVar, "it");
            return com.iqoption.core.ui.c.baY.bm(bVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "kotlin.jvm.PlatformType", "error", "", "apply"})
    /* compiled from: DepositNavigatorViewModel.kt */
    static final class c<T, R> implements f<Throwable, org.a.b<? extends com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>>> {
        final /* synthetic */ boolean ark;
        final /* synthetic */ DepositNavigatorViewModel cbL;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lio/reactivex/Flowable;", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "it", "Lcom/iqoption/core/connect/bus/IQBusState;", "apply"})
        /* compiled from: DepositNavigatorViewModel.kt */
        /* renamed from: com.iqoption.deposit.navigator.DepositNavigatorViewModel$c$2 */
        static final class AnonymousClass2<T, R> implements f<T, org.a.b<? extends R>> {
            final /* synthetic */ c cbO;

            AnonymousClass2(c cVar) {
                this.cbO = cVar;
            }

            /* renamed from: c */
            public final e<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> apply(IQBusState iQBusState) {
                h.e(iQBusState, "it");
                return this.cbO.cbL.cy(this.cbO.ark);
            }
        }

        c(DepositNavigatorViewModel depositNavigatorViewModel, boolean z) {
            this.cbL = depositNavigatorViewModel;
            this.ark = z;
        }

        /* renamed from: s */
        public final e<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> apply(Throwable th) {
            h.e(th, "error");
            return e.bW(com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, th, null, null, 6, null)).b((f) AnonymousClass1.cbM).a((f) new AnonymousClass2(this));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/iqoption/core/ui/Resource;", "Lcom/iqoption/core/microservices/billing/response/deposit/CashboxCounting;", "it", "", "apply"})
    /* compiled from: DepositNavigatorViewModel.kt */
    static final class d<T, R> implements f<Throwable, com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> {
        public static final d cbP = new d();

        d() {
        }

        /* renamed from: t */
        public final com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b> apply(Throwable th) {
            h.e(th, "it");
            return com.iqoption.core.ui.c.a.a(com.iqoption.core.ui.c.baY, th, null, null, 6, null);
        }
    }

    public final LiveData<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> cx(boolean z) {
        LiveData<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> a = LiveDataReactiveStreams.a(cy(z));
        h.d(a, "LiveDataReactiveStreams.…ngFlowable(withKycLimit))");
        return a;
    }

    private final e<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> cy(boolean z) {
        e<com.iqoption.core.ui.c<com.iqoption.core.microservices.billing.response.deposit.b>> c = com.iqoption.billing.repository.a.arj.bE(z).d((f) b.cbK).e((f) new c(this, z)).f(d.cbP).d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yp());
        h.d(c, "CashBoxMediator.getCount…           .observeOn(ui)");
        return c;
    }

    public final void a(com.iqoption.core.microservices.billing.response.deposit.b bVar) {
        DepositSelectionViewModel depositSelectionViewModel = this.bWd;
        if (depositSelectionViewModel == null) {
            h.lS("depositSelectionViewModel");
        }
        depositSelectionViewModel.a(bVar);
    }

    public final void f(PayMethod payMethod) {
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

    public final boolean adR() {
        return aaJ().getValue() != null;
    }

    public final LiveData<d> adS() {
        return this.cbI;
    }

    public void a(boolean z, p pVar) {
        h.e(pVar, "depositParams");
        com.iqoption.billing.repository.e.ary.JI();
        com.iqoption.core.ext.a.a((MutableLiveData) this.cbI, new a(z, pVar));
    }

    public void adN() {
        com.iqoption.billing.repository.e.ary.JI();
        com.iqoption.core.ext.a.a((MutableLiveData) this.cbI, c.cbQ);
    }
}
