package com.iqoption.withdrawal.common.fields;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.microservice.withdraw.response.n;
import com.iqoption.util.af;
import com.iqoption.withdrawal.common.f;
import java.util.Map;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "selectedMethod", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsData;", "getSelectedMethod", "Landroid/arch/lifecycle/LiveData;", "selectMethod", "", "data", "withdrawal", "Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "method", "Lcom/iqoption/microservice/withdraw/response/BaseWithdrawMethod;", "params", "", "", "", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsViewModel.kt */
public final class WithdrawFieldsViewModel extends ViewModel {
    public static final a dQx = new a();
    private final MutableLiveData<c> dQw = new MutableLiveData();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsViewModel$Companion;", "", "()V", "create", "Lcom/iqoption/withdrawal/common/fields/WithdrawFieldsViewModel;", "activity", "Landroid/support/v4/app/FragmentActivity;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawFieldsViewModel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final WithdrawFieldsViewModel L(FragmentActivity fragmentActivity) {
            h.e(fragmentActivity, "activity");
            return (WithdrawFieldsViewModel) ViewModelProviders.b(fragmentActivity).h(WithdrawFieldsViewModel.class);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: WithdrawFieldsViewModel.kt */
    static final class b<I, O> implements g<com.iqoption.core.microservices.billing.response.b.a, n> {
        final /* synthetic */ com.iqoption.microservice.withdraw.response.a dQy;
        final /* synthetic */ Map dQz;

        b(com.iqoption.microservice.withdraw.response.a aVar, Map map) {
            this.dQy = aVar;
            this.dQz = map;
        }

        /* renamed from: d */
        public final s<n> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
            com.iqoption.microservice.withdraw.a aVar2 = com.iqoption.microservice.withdraw.a.cTo;
            if (aVar == null) {
                h.aXZ();
            }
            return aVar2.a(aVar.getHost(), aVar.Uy(), this.dQy, this.dQz);
        }
    }

    public final void d(c cVar) {
        h.e(cVar, "data");
        this.dQw.setValue(cVar);
    }

    public final LiveData<c> akH() {
        return this.dQw;
    }

    public final LiveData<n> a(com.iqoption.microservice.withdraw.response.a aVar, Map<String, ? extends Object> map) {
        h.e(aVar, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
        h.e(map, "params");
        MutableLiveData mutableLiveData = new MutableLiveData();
        s b = o.b(com.iqoption.mobbtech.connect.response.a.a.ava().iM(f.dPY.Ll()), (g) new b(aVar, map), MoreExecutors.vV());
        h.d(b, Position.CLOSE_REASON_WITHDRAW);
        af.a(b, new WithdrawFieldsViewModel$withdrawal$1(mutableLiveData), new WithdrawFieldsViewModel$withdrawal$2(mutableLiveData), null, 4, null);
        return mutableLiveData;
    }
}
