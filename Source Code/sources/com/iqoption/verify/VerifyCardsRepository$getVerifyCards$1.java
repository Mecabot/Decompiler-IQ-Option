package com.iqoption.verify;

import android.arch.lifecycle.MutableLiveData;
import com.iqoption.mobbtech.connect.response.q;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "result", "", "Lcom/iqoption/mobbtech/connect/response/VerifyCard;", "invoke"})
/* compiled from: VerifyCardsRepository.kt */
final class VerifyCardsRepository$getVerifyCards$1 extends Lambda implements b<List<? extends q>, l> {
    final /* synthetic */ MutableLiveData $liveData;

    VerifyCardsRepository$getVerifyCards$1(MutableLiveData mutableLiveData) {
        this.$liveData = mutableLiveData;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        P((List) obj);
        return l.etX;
    }

    public final void P(List<q> list) {
        this.$liveData.postValue(list);
    }
}
