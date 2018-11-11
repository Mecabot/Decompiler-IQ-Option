package com.iqoption.portfolio;

import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.a;
import com.google.common.collect.i;
import com.iqoption.core.data.model.ActiveType;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.core.ext.c;
import com.iqoption.mobbtech.connect.response.options.e;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: Portfolio */
public final class f {
    public static final long cYm = TimeUnit.MINUTES.toMillis(30);
    private final j<d> cYn = new j<d>() {
        /* renamed from: a */
        public boolean apply(d dVar) {
            boolean z = false;
            switch (f.this.filter) {
                case 1:
                    return dVar.avQ();
                case 2:
                    return dVar.avQ() ^ true;
                case 3:
                    return c.b(dVar.getInstrumentType(), InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT);
                case 4:
                    if (dVar.getInstrumentType() == InstrumentType.CFD_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 5:
                    if (dVar.getInstrumentType() == InstrumentType.FOREX_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 6:
                    if (dVar.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 7:
                    if (dVar.getInstrumentType() == InstrumentType.DIGITAL_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 8:
                    if (dVar.getInstrumentType() == InstrumentType.FX_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                default:
                    return true;
            }
        }
    };
    private final j<b> cYo = new j<b>() {
        /* renamed from: b */
        public boolean apply(b bVar) {
            boolean z = false;
            switch (f.this.filter) {
                case 1:
                    return bVar.avQ();
                case 2:
                    return bVar.avQ() ^ true;
                case 3:
                    return c.b(bVar.getInstrumentType(), InstrumentType.BINARY_INSTRUMENT, InstrumentType.TURBO_INSTRUMENT);
                case 4:
                    if (bVar.getInstrumentType() == InstrumentType.CFD_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 5:
                    if (bVar.getInstrumentType() == InstrumentType.FOREX_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 6:
                    if (bVar.getInstrumentType() == InstrumentType.CRYPTO_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 7:
                    if (bVar.getInstrumentType() == InstrumentType.DIGITAL_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                case 8:
                    if (bVar.getInstrumentType() == InstrumentType.FOREX_INSTRUMENT) {
                        z = true;
                    }
                    return z;
                default:
                    return true;
            }
        }
    };
    private final j<e> cYp = new j<e>() {
        /* renamed from: a */
        public boolean apply(e eVar) {
            int a = f.this.filter;
            boolean z = false;
            if (a != 1) {
                switch (a) {
                    case 3:
                    case 7:
                    case 8:
                        break;
                    case 4:
                        if (eVar.getActiveType().toInstrumentType() == InstrumentType.CFD_INSTRUMENT) {
                            z = true;
                        }
                        return z;
                    case 5:
                        if (eVar.getActiveType() == ActiveType.FOREX_ACTIVE) {
                            z = true;
                        }
                        return z;
                    case 6:
                        if (eVar.getActiveType() == ActiveType.CRYPTO_ACTIVE) {
                            z = true;
                        }
                        return z;
                    default:
                        return true;
                }
            }
            return false;
        }
    };
    private ImmutableList<d> cYq = ImmutableList.sL();
    private ImmutableList<d> cYr;
    private ImmutableMap<Integer, a> cYs = new a().r(Integer.valueOf(0), new a()).r(Integer.valueOf(1), new a()).r(Integer.valueOf(3), new a()).r(Integer.valueOf(7), new a()).r(Integer.valueOf(8), new a()).r(Integer.valueOf(2), new a()).r(Integer.valueOf(4), new a()).r(Integer.valueOf(6), new a()).r(Integer.valueOf(5), new a()).tc();
    private ImmutableList<b> cYt = ImmutableList.sL();
    private ImmutableList<b> cYu;
    private ImmutableList<e> cYv = ImmutableList.sL();
    private ImmutableList<e> cYw;
    private volatile int cYx;
    private int filter = 0;

    public f(int i) {
        fD(i);
    }

    void fD(int i) {
        Object obj;
        if (this.filter != i) {
            this.filter = i;
            obj = 1;
        } else {
            obj = null;
        }
        if (this.cYr == null || obj != null) {
            this.cYr = i.c(this.cYq).c(this.cYn).sA();
        }
        if (this.cYu == null || obj != null) {
            this.cYu = i.c(this.cYt).c(this.cYo).sA();
        }
        if (this.cYw == null || obj != null) {
            this.cYw = i.c(this.cYv).c(this.cYp).sA();
        }
    }

    public int avX() {
        return this.filter;
    }

    public ImmutableList<d> avY() {
        return fE(this.filter);
    }

    public ImmutableList<d> fE(int i) {
        fD(i);
        return this.cYr;
    }

    void t(ImmutableList<d> immutableList) {
        this.cYq = immutableList;
        this.cYr = null;
        fD(this.filter);
    }

    public ImmutableList<b> avZ() {
        return fF(this.filter);
    }

    public ImmutableList<b> fF(int i) {
        fD(i);
        return this.cYu;
    }

    public ImmutableList<e> awa() {
        return fG(this.filter);
    }

    public ImmutableList<e> fG(int i) {
        fD(i);
        return this.cYw;
    }

    void u(ImmutableList<b> immutableList) {
        this.cYt = immutableList;
        this.cYu = null;
        fD(this.filter);
    }

    void v(ImmutableList<e> immutableList) {
        this.cYv = immutableList;
        this.cYw = null;
        fD(this.filter);
    }

    void awb() {
        Iterator sI = this.cYs.values().iterator();
        while (sI.hasNext()) {
            ((a) sI.next()).reset();
        }
        if (this.cYq != null) {
            sI = this.cYq.iterator();
            while (sI.hasNext()) {
                d dVar = (d) sI.next();
                a avW = dVar.avW();
                ((a) this.cYs.get(Integer.valueOf(0))).a(avW);
                if (dVar.avQ()) {
                    ((a) this.cYs.get(Integer.valueOf(1))).a(avW);
                } else {
                    ((a) this.cYs.get(Integer.valueOf(2))).a(avW);
                }
                switch (dVar.getInstrumentType()) {
                    case TURBO_INSTRUMENT:
                    case BINARY_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(3))).a(avW);
                        break;
                    case DIGITAL_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(7))).a(avW);
                        break;
                    case FX_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(8))).a(avW);
                        break;
                    case CFD_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(4))).a(avW);
                        break;
                    case FOREX_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(5))).a(avW);
                        break;
                    case CRYPTO_INSTRUMENT:
                        ((a) this.cYs.get(Integer.valueOf(6))).a(avW);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public a awc() {
        return fH(this.filter);
    }

    public a fH(int i) {
        return (a) this.cYs.get(Integer.valueOf(i));
    }

    public int getDataState() {
        com.iqoption.core.i.d("portfolio:ds-get", String.valueOf(this.cYx));
        return this.cYx;
    }

    void fI(int i) {
        com.iqoption.core.i.d("portfolio:ds-set", String.valueOf(i));
        this.cYx = i;
    }

    public e s(long j, long j2) {
        Iterator sI = this.cYq.iterator();
        while (sI.hasNext()) {
            d dVar = (d) sI.next();
            if (dVar.getId() == j2) {
                Iterator sI2 = dVar.avS().iterator();
                while (sI2.hasNext()) {
                    e eVar = (e) sI2.next();
                    if (eVar.getId().longValue() == j) {
                        return eVar;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
