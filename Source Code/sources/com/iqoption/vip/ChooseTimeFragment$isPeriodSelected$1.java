package com.iqoption.vip;

import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "date", "", "period", "Lcom/iqoption/vip/WorkingPeriod;", "invoke"})
/* compiled from: ChooseTimeFragment.kt */
final class ChooseTimeFragment$isPeriodSelected$1 extends Lambda implements m<Long, j, Boolean> {
    final /* synthetic */ c this$0;

    ChooseTimeFragment$isPeriodSelected$1(c cVar) {
        this.this$0 = cVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Boolean.valueOf(c(((Number) obj).longValue(), (j) obj2));
    }

    public final boolean c(long j, j jVar) {
        h.e(jVar, "period");
        return j == this.this$0.dKV && h.E(jVar, this.this$0.dKU);
    }
}
