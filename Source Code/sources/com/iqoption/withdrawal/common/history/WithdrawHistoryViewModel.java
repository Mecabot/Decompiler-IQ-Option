package com.iqoption.withdrawal.common.history;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.microservice.withdraw.response.l;
import com.iqoption.util.af;
import com.iqoption.withdrawal.common.f;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bJ\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, aXE = {"Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "historyLiveData", "Landroid/arch/lifecycle/MediatorLiveData;", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "cancel", "Landroid/arch/lifecycle/LiveData;", "Ljava/lang/Void;", "payout", "getWithdrawHistory", "refreshHistory", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawHistoryViewModel.kt */
public final class WithdrawHistoryViewModel extends ViewModel {
    public static final a dRx = new a();
    private MediatorLiveData<List<l>> dRw = new MediatorLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/withdrawal/common/history/WithdrawHistoryViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawHistoryViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WithdrawHistoryViewModel N(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (WithdrawHistoryViewModel) ViewModelProviders.b(fragmentActivity).h(WithdrawHistoryViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Void;", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: WithdrawHistoryViewModel.kt */
    static final class b<I, O> implements g<com.iqoption.core.microservices.billing.response.b.a, Void> {
        final /* synthetic */ l dRj;

        b(l lVar) {
            this.dRj = lVar;
        }

        /* renamed from: d */
        public final s<Void> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
            com.iqoption.microservice.withdraw.a aVar2 = com.iqoption.microservice.withdraw.a.cTo;
            if (aVar == null) {
                h.aXZ();
            }
            return aVar2.b(aVar.getHost(), aVar.Uy(), this.dRj.getId());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "result", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "onChanged"})
    /* compiled from: WithdrawHistoryViewModel.kt */
    static final class c<T> implements Observer<S> {
        final /* synthetic */ MediatorLiveData receiver$0;

        c(MediatorLiveData mediatorLiveData) {
            this.receiver$0 = mediatorLiveData;
        }

        /* renamed from: L */
        public final void onChanged(List<l> list) {
            if (list != null || this.receiver$0.getValue() == null) {
                this.receiver$0.postValue(list);
            }
        }
    }

    public final LiveData<List<l>> aNN() {
        aNO();
        return this.dRw;
    }

    public final void aNO() {
        MediatorLiveData mediatorLiveData = this.dRw;
        mediatorLiveData.a(f.dPY.aMV(), new c(mediatorLiveData));
    }

    public final LiveData<Void> e(l lVar) {
        h.e(lVar, "payout");
        MutableLiveData mutableLiveData = new MutableLiveData();
        s b = o.b(com.iqoption.mobbtech.connect.response.a.a.ava().iM(f.dPY.Ll()), (g) new b(lVar), MoreExecutors.vV());
        h.d(b, Position.CLOSE_REASON_WITHDRAW);
        af.a(b, new WithdrawHistoryViewModel$cancel$1(mutableLiveData), new WithdrawHistoryViewModel$cancel$2(mutableLiveData), null, 4, null);
        return mutableLiveData;
    }
}
