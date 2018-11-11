package com.iqoption.charttools;

import com.iqoption.charttools.model.a;
import com.iqoption.charttools.model.indicator.ae;
import com.iqoption.charttools.model.indicator.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, aXE = {"Lcom/iqoption/charttools/MergedLibrary;", "Lcom/iqoption/charttools/IndicatorsLibrary;", "remote", "Lcom/iqoption/charttools/RemoteLibrary;", "local", "Lcom/iqoption/charttools/LocalLibrary;", "(Lcom/iqoption/charttools/RemoteLibrary;Lcom/iqoption/charttools/LocalLibrary;)V", "all", "", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getAll", "()Ljava/util/List;", "categories", "Lcom/iqoption/charttools/model/IndicatorCategory;", "getCategories", "figures", "getFigures", "indicators", "getIndicators", "localIndicators", "getLocalIndicators", "techtools_release"})
/* compiled from: IndicatorsLibraryManager.kt */
final class n implements k {
    private final List<x> arF;
    private final List<x> asP;
    private final List<a> asQ;
    private final List<x> asR;
    private final List<x> asS;

    public n(p pVar, m mVar) {
        h.e(pVar, "remote");
        h.e(mVar, "local");
        this.asQ = pVar.Kj();
        List JT = pVar.JT();
        Iterable<ae> iterable = JT;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (ae Mo : iterable) {
            arrayList.add(Mo.Mo());
        }
        List list = (List) arrayList;
        Collection collection = JT;
        Collection arrayList2 = new ArrayList();
        for (Object next : mVar.JT()) {
            if ((list.contains(((x) next).getType()) ^ 1) != 0) {
                arrayList2.add(next);
            }
        }
        this.arF = u.b(collection, (Iterable) (List) arrayList2);
        this.asR = mVar.JT();
        this.asP = mVar.Kr();
        this.asS = u.b((Collection) u.b((Collection) pVar.JT(), (Iterable) mVar.JT()), (Iterable) mVar.Kr());
    }

    public List<a> Kj() {
        return this.asQ;
    }

    public List<x> JT() {
        return this.arF;
    }

    public List<x> Kk() {
        return this.asR;
    }

    public List<x> getAll() {
        return this.asS;
    }
}
