package com.iqoption.asset.mediators;

import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001B]\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0002\u0010\u0010B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011Bi\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\u0002\u0010\u0015R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, aXE = {"Lcom/iqoption/asset/mediators/AssetStreamParams;", "", "instrumentType", "Lcom/iqoption/core/data/model/InstrumentType;", "activeType", "Lcom/iqoption/core/data/model/ActiveType;", "defaultComparator", "Ljava/util/Comparator;", "Lcom/iqoption/asset/mediators/AssetDisplayData;", "Lkotlin/Comparator;", "limit", "", "filter", "Lkotlin/Function1;", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "", "(Lcom/iqoption/core/data/model/InstrumentType;Lcom/iqoption/core/data/model/ActiveType;Ljava/util/Comparator;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "(Lcom/iqoption/core/data/model/InstrumentType;Lcom/iqoption/core/data/model/ActiveType;)V", "instrumentTypes", "", "activeTypes", "(Ljava/util/List;Ljava/util/List;Ljava/util/Comparator;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getActiveTypes", "()Ljava/util/List;", "getDefaultComparator", "()Ljava/util/Comparator;", "getFilter", "()Lkotlin/jvm/functions/Function1;", "getInstrumentTypes", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "asset_release"})
/* compiled from: AssetStreamParams.kt */
public final class d {
    private final List<InstrumentType> aqi;
    private final List<ActiveType> aqj;
    private final Comparator<a> aqk;
    private final Integer aql;
    private final b<a, Boolean> aqm;

    public d() {
        this(null, null, null, null, null, 31, null);
    }

    public d(List<? extends InstrumentType> list, List<? extends ActiveType> list2, Comparator<a> comparator, Integer num, b<? super a, Boolean> bVar) {
        h.e(list, "instrumentTypes");
        this.aqi = list;
        this.aqj = list2;
        this.aqk = comparator;
        this.aql = num;
        this.aqm = bVar;
    }

    public /* synthetic */ d(List list, List list2, Comparator comparator, Integer num, b bVar, int i, f fVar) {
        if ((i & 1) != 0) {
            list = InstrumentType.Companion.getKnownValues();
        }
        if ((i & 2) != 0) {
            list2 = (List) null;
        }
        List list3 = list2;
        if ((i & 4) != 0) {
            comparator = (Comparator) null;
        }
        Comparator comparator2 = comparator;
        if ((i & 8) != 0) {
            num = (Integer) null;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            bVar = (b) null;
        }
        this(list, list3, comparator2, num2, bVar);
    }

    public final List<InstrumentType> Jk() {
        return this.aqi;
    }

    public final List<ActiveType> Jl() {
        return this.aqj;
    }

    public final Comparator<a> Jm() {
        return this.aqk;
    }

    public final Integer Jn() {
        return this.aql;
    }

    public final b<a, Boolean> Jo() {
        return this.aqm;
    }
}
