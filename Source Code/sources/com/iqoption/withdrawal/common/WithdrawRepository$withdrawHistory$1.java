package com.iqoption.withdrawal.common;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.microservice.withdraw.response.l;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "", "Lcom/iqoption/microservice/withdraw/response/WithdrawPayout;", "invoke"})
/* compiled from: WithdrawRepository.kt */
final class WithdrawRepository$withdrawHistory$1 extends Lambda implements b<List<? extends l>, kotlin.l> {
    final /* synthetic */ MutableLiveData $liveData;

    WithdrawRepository$withdrawHistory$1(MutableLiveData mutableLiveData) {
        this.$liveData = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        P((List) obj);
        return kotlin.l.etX;
    }

    public final void P(List<l> list) {
        this.$liveData.setValue(list);
    }
}
