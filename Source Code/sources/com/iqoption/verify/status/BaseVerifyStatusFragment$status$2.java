package com.iqoption.verify.status;

import com.iqoption.mobbtech.connect.response.CardStatus;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/mobbtech/connect/response/CardStatus;", "invoke"})
/* compiled from: BaseVerifyStatusFragment.kt */
final class BaseVerifyStatusFragment$status$2 extends Lambda implements a<CardStatus> {
    final /* synthetic */ a this$0;

    BaseVerifyStatusFragment$status$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aHf */
    public final CardStatus invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_STATUS");
        if (serializable != null) {
            return (CardStatus) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.mobbtech.connect.response.CardStatus");
    }
}
