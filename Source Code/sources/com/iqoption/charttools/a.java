package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.h;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorAdded;", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "key", "", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "indicator", "(Ljava/lang/String;Ljava/util/List;Lcom/iqoption/charttools/model/indicator/ChartIndicator;)V", "getIndicator", "()Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "techtools_release"})
/* compiled from: ActiveIndicatorsManager.kt */
public final class a extends b {
    private final h arE;

    public final h JS() {
        return this.arE;
    }

    public a(String str, List<h> list, h hVar) {
        kotlin.jvm.internal.h.e(str, "key");
        kotlin.jvm.internal.h.e(list, "indicators");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        super(str, list, null);
        this.arE = hVar;
    }
}
