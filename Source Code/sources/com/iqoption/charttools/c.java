package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.h;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorRemoved;", "Lcom/iqoption/charttools/ActiveIndicatorEvent;", "key", "", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "removed", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getRemoved", "()I", "techtools_release"})
/* compiled from: ActiveIndicatorsManager.kt */
public final class c extends b {
    private final int arG;

    public final int JU() {
        return this.arG;
    }

    public c(String str, List<h> list, int i) {
        kotlin.jvm.internal.h.e(str, "key");
        kotlin.jvm.internal.h.e(list, "indicators");
        super(str, list, null);
        this.arG = i;
    }
}
