package com.iqoption.charttools;

import com.iqoption.charttools.model.indicator.x;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, aXE = {"Lcom/iqoption/charttools/LocalLibrary;", "", "figures", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "indicators", "(Ljava/util/List;Ljava/util/List;)V", "getFigures", "()Ljava/util/List;", "getIndicators", "techtools_release"})
/* compiled from: IndicatorsLibraryManager.kt */
final class m {
    private final List<x> arF;
    private final List<x> asP;

    public m(List<? extends x> list, List<? extends x> list2) {
        h.e(list, "figures");
        h.e(list2, "indicators");
        this.asP = list;
        this.arF = list2;
    }

    public final List<x> JT() {
        return this.arF;
    }

    public final List<x> Kr() {
        return this.asP;
    }
}
