package com.iqoption.protrader.active;

import com.iqoption.core.data.model.ActiveType;
import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/data/model/ActiveType;", "invoke"})
/* compiled from: ProTraderActiveFragment.kt */
final class ProTraderActiveFragment$activeType$2 extends Lambda implements a<ActiveType> {
    final /* synthetic */ a this$0;

    ProTraderActiveFragment$activeType$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: ayB */
    public final ActiveType invoke() {
        Serializable serializable = com.iqoption.core.ext.a.o(this.this$0).getSerializable("ARG_ACTIVE_TYPE");
        if (serializable != null) {
            return (ActiveType) serializable;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iqoption.core.data.model.ActiveType");
    }
}
