package com.iqoption.withdrawal.common.fields;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.microservice.withdraw.response.n;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/microservice/withdraw/response/WithdrawResponse;", "invoke"})
/* compiled from: WithdrawFieldsViewModel.kt */
final class WithdrawFieldsViewModel$withdrawal$1 extends Lambda implements b<n, l> {
    final /* synthetic */ MutableLiveData $liveData;

    WithdrawFieldsViewModel$withdrawal$1(MutableLiveData mutableLiveData) {
        this.$liveData = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((n) obj);
        return l.etX;
    }

    public final void b(n nVar) {
        this.$liveData.setValue(nVar);
    }
}
