package com.iqoption.withdrawal.common;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.google.common.base.d;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.iqoption.microservice.withdraw.response.j;
import com.iqoption.microservice.withdraw.response.l;
import com.iqoption.util.af;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tR\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, aXE = {"Lcom/iqoption/withdrawal/common/WithdrawRepository;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getCardsAndPayoutMethods", "Landroid/arch/lifecycle/LiveData;", "Lcom/iqoption/microservice/withdraw/response/CardsAndWithdrawMethods;", "withdrawHistory", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawRepository.kt */
public final class f {
    private static final String TAG = "com.iqoption.withdrawal.common.f";
    public static final f dPY = new f();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a4\u00120\u0012.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u0005 \u0006*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\t"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlin/Pair;", "", "Lcom/iqoption/microservice/withdraw/response/Card;", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodsResponse;", "kotlin.jvm.PlatformType", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: WithdrawRepository.kt */
    static final class a<I, O> implements g<com.iqoption.core.microservices.billing.response.b.a, Pair<? extends List<? extends com.iqoption.microservice.withdraw.response.b>, ? extends j>> {
        public static final a dPZ = new a();

        a() {
        }

        /* renamed from: d */
        public final s<Pair<List<com.iqoption.microservice.withdraw.response.b>, j>> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
            s[] sVarArr = new s[2];
            com.iqoption.microservice.withdraw.a aVar2 = com.iqoption.microservice.withdraw.a.cTo;
            if (aVar == null) {
                h.aXZ();
            }
            sVarArr[0] = aVar2.ao(aVar.getHost(), aVar.Uy());
            sVarArr[1] = com.iqoption.microservice.withdraw.a.cTo.ap(aVar.getHost(), aVar.Uy());
            s a = o.a(sVarArr);
            h.d(a, "allAsList(\n             …on)\n                    )");
            return af.a(a, (d) AnonymousClass1.dQa, null, 2, null);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "Lcom/google/common/util/concurrent/ListenableFuture;", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "it", "Lcom/iqoption/core/microservices/billing/response/CreateSessionResult$CreateSession;", "apply"})
    /* compiled from: WithdrawRepository.kt */
    static final class b<I, O> implements g<com.iqoption.core.microservices.billing.response.b.a, List<? extends l>> {
        public static final b dQb = new b();

        b() {
        }

        /* renamed from: d */
        public final s<List<l>> aP(com.iqoption.core.microservices.billing.response.b.a aVar) {
            com.iqoption.microservice.withdraw.a aVar2 = com.iqoption.microservice.withdraw.a.cTo;
            if (aVar == null) {
                h.aXZ();
            }
            return aVar2.aq(aVar.getHost(), aVar.Uy());
        }
    }

    private f() {
    }

    public final String Ll() {
        return TAG;
    }

    public final LiveData<com.iqoption.microservice.withdraw.response.d> aMU() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        com.iqoption.mobbtech.connect.response.a.a.ava().restart();
        s b = o.b(com.iqoption.mobbtech.connect.response.a.a.ava().iM(TAG), (g) a.dPZ, MoreExecutors.vV());
        h.d(b, "cardsAndPayoutMethods");
        af.a(b, new WithdrawRepository$getCardsAndPayoutMethods$1(mutableLiveData), new WithdrawRepository$getCardsAndPayoutMethods$2(mutableLiveData), null, 4, null);
        return mutableLiveData;
    }

    public final LiveData<List<l>> aMV() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        com.iqoption.mobbtech.connect.response.a.a.ava().restart();
        s b = o.b(com.iqoption.mobbtech.connect.response.a.a.ava().iM(TAG), (g) b.dQb, MoreExecutors.vV());
        h.d(b, "cardsAndPayoutMethods");
        af.a(b, new WithdrawRepository$withdrawHistory$1(mutableLiveData), new WithdrawRepository$withdrawHistory$2(mutableLiveData), null, 4, null);
        return mutableLiveData;
    }
}
