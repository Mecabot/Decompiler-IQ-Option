package com.iqoption.protrader;

import com.iqoption.microservice.regulators.response.StatusType;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/microservice/regulators/response/StatusType;", "invoke"})
/* compiled from: ProTraderApplicationStatusDialog.kt */
final class ProTraderApplicationStatusDialog$statusType$2 extends Lambda implements a<StatusType> {
    final /* synthetic */ c this$0;

    ProTraderApplicationStatusDialog$statusType$2(c cVar) {
        this.this$0 = cVar;
        super(0);
    }

    /* renamed from: ayv */
    public final StatusType invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_STATUS_TYPE");
        if (serializable != null) {
            return (StatusType) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.microservice.regulators.response.StatusType");
    }
}
