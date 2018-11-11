package com.iqoption.portfolio;

import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.collect.i;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.mobbtech.connect.response.options.a;
import com.iqoption.mobbtech.connect.response.options.e;
import java.util.Comparator;

/* compiled from: ClosedPositionGroup */
public final class b {
    private static final d<a, b> cYb = new d<a, b>() {
        /* renamed from: f */
        public b apply(a aVar) {
            return new b(aVar);
        }
    };
    private final int activeId;
    private final long cYc;
    private final boolean cYd = avP();
    private final ImmutableList<Long> cYe;
    private a cYf;
    private final ImmutableList<? extends e> cgy;
    private final long id;
    private final InstrumentType instrumentType;

    public static ImmutableList<b> a(Iterable<a> iterable, Ordering<b> ordering) {
        return i.c((Iterable) iterable).b(cYb).a((Comparator) ordering);
    }

    public b(a aVar) {
        this.activeId = aVar.getActiveId().intValue();
        this.instrumentType = aVar.getInstrumentType();
        this.cYc = aVar.getExpired().longValue() * 1000;
        this.cYe = aVar.avf();
        this.cgy = aVar.avh();
        this.id = (long) e(aVar);
        this.cYf = new a();
        this.cYf.a(aVar.getAmount().doubleValue(), aVar.getWinAmount().doubleValue() - aVar.getAmount().doubleValue(), this.cYd ? aVar.getWinAmount().doubleValue() : 0.0d, 0);
    }

    private int e(a aVar) {
        if (this.cYd) {
            return f.hashCode(aVar.getActiveId(), aVar.getActiveType(), aVar.getExpired());
        }
        return f.hashCode(aVar.getActiveId(), aVar.getActiveType(), aVar.getCreated());
    }

    private boolean avP() {
        InstrumentType instrumentType = getInstrumentType();
        if (instrumentType == null) {
            return false;
        }
        switch (instrumentType) {
            case TURBO_INSTRUMENT:
            case BINARY_INSTRUMENT:
            case DIGITAL_INSTRUMENT:
                return true;
            default:
                return false;
        }
    }

    public long getId() {
        return this.id;
    }

    public boolean avQ() {
        return this.cYd;
    }

    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    public com.iqoption.core.microservices.tradingengine.response.active.a Jg() {
        return com.iqoption.app.helpers.a.FI().a(Integer.valueOf(this.activeId), getInstrumentType());
    }

    public long getCloseTime() {
        return this.cYc;
    }

    public ImmutableList<Long> avR() {
        return this.cYe;
    }

    public ImmutableList<? extends e> avS() {
        return this.cgy;
    }

    public int avT() {
        return this.cYe.size();
    }

    public a avU() {
        return this.cYf;
    }
}
