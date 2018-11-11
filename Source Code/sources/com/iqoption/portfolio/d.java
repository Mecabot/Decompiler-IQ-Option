package com.iqoption.portfolio;

import android.support.v4.util.ArrayMap;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.i;
import com.google.common.primitives.Longs;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.mobbtech.connect.response.options.b;
import com.iqoption.mobbtech.connect.response.options.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: OpenPositionGroup */
public class d {
    private static final Ordering<e> ORDERING = cYg.compound(cYh);
    private static final Ordering<e> cYg = new Ordering<e>() {
        /* renamed from: c */
        public int compare(e eVar, e eVar2) {
            return Longs.compare(eVar2.getExpired().longValue(), eVar.getExpired().longValue());
        }
    };
    private static final Ordering<e> cYh = new Ordering<e>() {
        /* renamed from: c */
        public int compare(e eVar, e eVar2) {
            return Longs.compare(eVar2.getCreated().longValue(), eVar.getCreated().longValue());
        }
    };
    private final int activeId;
    private a aiJ;
    private final boolean cYd;
    private a cYf;
    private long cYi;
    private ImmutableList<e> cYj;
    private boolean cYk;
    private final List<e> cht = new ArrayList();
    private final long id;
    private final InstrumentType instrumentType;

    public d(e eVar) {
        this.id = (long) f.hashCode(Integer.valueOf(eVar.getActiveId()), eVar.getInstrumentType());
        this.instrumentType = r0;
        this.activeId = eVar.getActiveId();
        this.cYd = avP();
        u(eVar);
    }

    private boolean avP() {
        switch (this.instrumentType) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
            case DIGITAL_INSTRUMENT:
            case FX_INSTRUMENT:
                return true;
            default:
                return false;
        }
    }

    void u(e eVar) {
        this.cht.add(eVar);
        long createTime = eVar.getCreateTime();
        if (this.cYi < createTime) {
            this.cYi = createTime;
        }
        this.cYk = true;
    }

    public long getId() {
        return this.id;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public boolean avQ() {
        return this.cYd;
    }

    public long avV() {
        return this.cYi;
    }

    public a avW() {
        if (this.cYf == null) {
            this.cYf = new a();
        } else {
            this.cYf.reset();
        }
        for (e eVar : this.cht) {
            this.cYf.e(eVar.getInvestSum().doubleValue(), eVar.getSellPnl(), eVar.getExpPnl());
        }
        return this.cYf;
    }

    public a avU() {
        if (this.cYf == null) {
            return avW();
        }
        return this.cYf;
    }

    public a Jg() {
        if (this.aiJ == null) {
            this.aiJ = com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.activeId), this.instrumentType);
        }
        return this.aiJ;
    }

    public int size() {
        return this.cht.size();
    }

    public ImmutableList<e> avS() {
        if (this.cYj == null || this.cYk) {
            Collections.sort(this.cht, ORDERING);
            this.cYj = ImmutableList.m(this.cht);
            this.cYk = false;
        }
        return this.cYj;
    }

    public static ImmutableList<d> a(Iterable<b> iterable, Ordering<d> ordering) {
        List<e> arrayList = new ArrayList();
        for (b avh : iterable) {
            arrayList.addAll(avh.avh());
        }
        Map arrayMap = new ArrayMap();
        for (e eVar : arrayList) {
            Object activeType = eVar.getActiveType();
            Object instrumentType = eVar.getInstrumentType();
            if (activeType == ActiveType.TURBO_ACTIVE) {
                activeType = ActiveType.BINARY_ACTIVE;
            }
            if (instrumentType == InstrumentType.TURBO_INSTRUMENT) {
                instrumentType = InstrumentType.BINARY_INSTRUMENT;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(eVar.getActiveId());
            stringBuilder.append("_");
            stringBuilder.append(activeType);
            stringBuilder.append("_");
            stringBuilder.append(instrumentType);
            String stringBuilder2 = stringBuilder.toString();
            d dVar = (d) arrayMap.get(stringBuilder2);
            if (dVar != null) {
                dVar.u(eVar);
            } else {
                arrayMap.put(stringBuilder2, new d(eVar));
            }
        }
        return i.c(arrayMap.values()).a((Comparator) ordering);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OpenPositionGroup{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", instrumentType='");
        stringBuilder.append(this.instrumentType);
        stringBuilder.append('\'');
        stringBuilder.append(", expirable=");
        stringBuilder.append(this.cYd);
        stringBuilder.append(", active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", lastCreateTime=");
        stringBuilder.append(this.cYi);
        stringBuilder.append(", snapshotDirty=");
        stringBuilder.append(this.cYk);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
