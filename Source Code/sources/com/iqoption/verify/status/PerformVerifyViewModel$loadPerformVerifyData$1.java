package com.iqoption.verify.status;

import com.iqoption.dto.entity.iqbus.Country;
import com.iqoption.dto.entity.iqbus.VerifyInitResult;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "values", "", "", "invoke"})
/* compiled from: PerformVerifyViewModel.kt */
final class PerformVerifyViewModel$loadPerformVerifyData$1 extends Lambda implements b<List<Object>, l> {
    final /* synthetic */ PerformVerifyViewModel this$0;

    PerformVerifyViewModel$loadPerformVerifyData$1(PerformVerifyViewModel performVerifyViewModel) {
        this.this$0 = performVerifyViewModel;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        P((List) obj);
        return l.etX;
    }

    public final void P(List<Object> list) {
        if (list != null) {
            Object obj = list.get(0);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.dto.entity.iqbus.VerifyInitResult");
            }
            VerifyInitResult verifyInitResult = (VerifyInitResult) obj;
            Object obj2 = list.get(1);
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.iqoption.dto.entity.iqbus.Country");
            }
            this.this$0.dyo.postValue(new f(verifyInitResult, (Country) obj2));
        }
    }
}
