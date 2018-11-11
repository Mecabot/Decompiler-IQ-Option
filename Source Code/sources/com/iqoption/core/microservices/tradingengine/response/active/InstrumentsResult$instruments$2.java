package com.iqoption.core.microservices.tradingengine.response.active;

import com.google.common.collect.Maps;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004 \u0003* \u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "invoke"})
/* compiled from: InstrumentsResult.kt */
final class InstrumentsResult$instruments$2 extends Lambda implements a<HashMap<Integer, a>> {
    final /* synthetic */ j this$0;

    InstrumentsResult$instruments$2(j jVar) {
        this.this$0 = jVar;
        super(0);
    }

    /* renamed from: Xx */
    public final HashMap<Integer, a> invoke() {
        HashMap<Integer, a> bf = Maps.bf(c.D(this.this$0.Xw()));
        for (h hVar : this.this$0.aYO) {
            h.d(bf, "activeHashMap");
            bf.put(Integer.valueOf(hVar.getActiveId()), this.this$0.a(hVar, this.this$0.Xw()));
        }
        return bf;
    }
}
