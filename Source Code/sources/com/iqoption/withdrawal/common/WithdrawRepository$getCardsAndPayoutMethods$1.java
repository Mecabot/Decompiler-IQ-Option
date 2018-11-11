package com.iqoption.withdrawal.common;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.microservice.withdraw.response.d;
import com.iqoption.microservice.withdraw.response.j;
import java.util.List;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "result", "Lkotlin/Pair;", "", "Lcom/iqoption/microservice/withdraw/response/Card;", "Lcom/iqoption/microservice/withdraw/response/WithdrawMethodsResponse;", "invoke"})
/* compiled from: WithdrawRepository.kt */
final class WithdrawRepository$getCardsAndPayoutMethods$1 extends Lambda implements b<Pair<? extends List<? extends com.iqoption.microservice.withdraw.response.b>, ? extends j>, l> {
    final /* synthetic */ MutableLiveData $liveData;

    WithdrawRepository$getCardsAndPayoutMethods$1(MutableLiveData mutableLiveData) {
        this.$liveData = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        g((Pair) obj);
        return l.etX;
    }

    public final void g(Pair<? extends List<com.iqoption.microservice.withdraw.response.b>, j> pair) {
        this.$liveData.setValue(pair != null ? new d((List) pair.getFirst(), ((j) pair.aXF()).atJ().atC()) : null);
    }
}
