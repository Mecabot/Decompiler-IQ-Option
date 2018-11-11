package com.iqoption.charttools.tools;

import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.tools.data.m;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/charttools/tools/data/TitleIndicatorItem;", "it", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "invoke"})
/* compiled from: ToolsViewModel.kt */
final class ToolsViewModel$Companion$mapToSortedList$1 extends Lambda implements b<x, m> {
    final /* synthetic */ List $active;
    final /* synthetic */ e $expanded;
    final /* synthetic */ List $favorites;

    ToolsViewModel$Companion$mapToSortedList$1(e eVar, List list, List list2) {
        this.$expanded = eVar;
        this.$favorites = list;
        this.$active = list2;
        super(1);
    }

    /* renamed from: e */
    public final m invoke(x xVar) {
        h.e(xVar, "it");
        return ToolsViewModel.aBn.a(xVar, this.$expanded, this.$favorites, this.$active);
    }
}
