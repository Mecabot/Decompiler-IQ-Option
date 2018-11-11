package com.iqoption.vip;

import android.support.v7.widget.RecyclerView;
import com.iqoption.analytics.r;
import com.iqoption.d.tv;
import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "date", "", "period", "Lcom/iqoption/vip/WorkingPeriod;", "invoke"})
/* compiled from: ChooseTimeFragment.kt */
final class ChooseTimeFragment$periodSelected$1 extends Lambda implements m<Long, j, l> {
    final /* synthetic */ c this$0;

    ChooseTimeFragment$periodSelected$1(c cVar) {
        this.this$0 = cVar;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        d(((Number) obj).longValue(), (j) obj2);
        return l.etX;
    }

    public final void d(long j, j jVar) {
        r.ajo.BY();
        if (j == this.this$0.dKV && h.E(jVar, this.this$0.dKU)) {
            this.this$0.dKV = 0;
            this.this$0.dKU = (j) null;
        } else {
            this.this$0.dKV = j;
            this.this$0.dKU = jVar;
        }
        tv c = c.c(this.this$0);
        RecyclerView recyclerView = c.bFY;
        h.d(recyclerView, "todayPeriods");
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView = c.bFU;
        h.d(recyclerView, "nextDayPeriods");
        recyclerView.getAdapter().notifyDataSetChanged();
        RecyclerView recyclerView2 = c.bFW;
        h.d(recyclerView2, "nextNextDayPeriods");
        recyclerView2.getAdapter().notifyDataSetChanged();
    }
}
