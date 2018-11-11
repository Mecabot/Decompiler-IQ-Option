package com.iqoption.charttools.tools;

import com.iqoption.charttools.model.indicator.ae;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.tools.data.d;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "invoke"})
/* compiled from: ToolsViewModel.kt */
final class ToolsViewModel$createIndicatorsStream$7$1 extends Lambda implements b<x, Boolean> {
    final /* synthetic */ n this$0;

    ToolsViewModel$createIndicatorsStream$7$1(n nVar) {
        this.this$0 = nVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(f((x) obj));
    }

    public final boolean f(x xVar) {
        h.e(xVar, "it");
        if (xVar instanceof ae) {
            Set categories = ((ae) xVar).getCategories();
            if (categories != null && categories.contains(((d) this.this$0.aBB).Oe())) {
                return true;
            }
        }
        return false;
    }
}
