package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.h;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, aXE = {"Lcom/iqoption/charttools/ActiveIndicatorEvent;", "", "key", "", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "(Ljava/lang/String;Ljava/util/List;)V", "getIndicators", "()Ljava/util/List;", "getKey", "()Ljava/lang/String;", "Lcom/iqoption/charttools/ActiveIndicatorAdded;", "Lcom/iqoption/charttools/ActiveIndicatorUpdated;", "Lcom/iqoption/charttools/ActiveIndicatorRemoved;", "Lcom/iqoption/charttools/ActiveIndicatorReplace;", "techtools_release"})
/* compiled from: ActiveIndicatorsManager.kt */
public abstract class b {
    private final List<h> arF;
    private final String key;

    private b(String str, List<h> list) {
        this.key = str;
        this.arF = list;
    }

    public /* synthetic */ b(String str, List list, f fVar) {
        this(str, list);
    }

    public final List<h> JT() {
        return this.arF;
    }

    public final String getKey() {
        return this.key;
    }
}
