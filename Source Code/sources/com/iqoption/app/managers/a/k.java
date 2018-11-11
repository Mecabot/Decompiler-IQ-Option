package com.iqoption.app.managers.a;

import com.google.common.base.Suppliers;
import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.s;
import com.iqoption.app.IQApp;
import com.iqoption.core.data.model.InstrumentType;
import com.iqoption.dto.entity.expiration.Expiration;
import com.iqoption.dto.entity.strike.Strike;
import com.iqoption.mobbtech.connect.response.options.i;
import com.iqoption.util.bf;
import com.iqoption.util.m;
import com.iqoption.x.R;
import java.util.Objects;

/* compiled from: ExpirationHelper */
public class k implements s {
    public static final Ordering<Expiration> ORDERING = new Ordering<Expiration>() {
        public int compare(Expiration expiration, Expiration expiration2) {
            return expiration.expValue.compareTo(expiration2.expValue);
        }
    };
    private static volatile transient k aoj;
    private final n<e> aok = Suppliers.a(l.ajD);
    private final n<a> aol = Suppliers.a(m.ajD);
    private final n<r> aom = Suppliers.a(n.ajD);
    private final n<b> aon = Suppliers.a(o.ajD);
    private final n<j> aoo = Suppliers.a(p.ajD);

    /* compiled from: ExpirationHelper */
    public static class a {
        public final Expiration aop;
        public final int aoq;
        public final boolean aor;
        public final i optionKey;

        public a(i iVar, Expiration expiration, int i, boolean z) {
            this.optionKey = iVar;
            this.aop = expiration;
            this.aoq = i;
            this.aor = z;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!(this.aoq == aVar.aoq && this.aor == aVar.aor && Objects.equals(this.optionKey, aVar.optionKey) && Objects.equals(this.aop, aVar.aop))) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.optionKey, this.aop, Integer.valueOf(this.aoq), Boolean.valueOf(this.aor)});
        }
    }

    /* compiled from: ExpirationHelper */
    public static class d {
        public boolean aos;

        public d(boolean z) {
            this.aos = z;
        }
    }

    /* compiled from: ExpirationHelper */
    public static class e {
    }

    /* compiled from: ExpirationHelper */
    public static class f {
    }

    /* compiled from: ExpirationHelper */
    public static class c implements j<Expiration> {
        private final Integer activeId;
        private long anQ;
        private final InstrumentType type;

        public c(Integer num, InstrumentType instrumentType, long j) {
            this.activeId = num;
            this.type = instrumentType;
            this.anQ = j;
        }

        public void au(long j) {
            this.anQ = j;
        }

        /* renamed from: c */
        public boolean apply(Expiration expiration) {
            i iVar = new i(Long.valueOf(expiration.expValue.longValue() / 1000), this.activeId, this.type);
            boolean z = true;
            if (this.anQ > expiration.expValue.longValue() - expiration.deadTime.longValue() && !com.iqoption.app.managers.c.Gn().b(iVar)) {
                return true;
            }
            if (this.anQ >= expiration.expValue.longValue() - expiration.deadTime.longValue()) {
                z = false;
            }
            return z;
        }
    }

    /* compiled from: ExpirationHelper */
    public static class b extends com.iqoption.system.a.c<Strike> {
        public int aoq;

        public b(int i) {
            this.aoq = i;
        }
    }

    public static long a(long j, long j2, long j3, long j4) {
        while (j2 - j4 < j) {
            j2 += j3;
        }
        return j2;
    }

    public static synchronized k HB() {
        k kVar;
        synchronized (k.class) {
            if (aoj == null) {
                synchronized (k.class) {
                    if (aoj == null) {
                        aoj = new k();
                    }
                }
            }
            kVar = aoj;
        }
        return kVar;
    }

    private s m(InstrumentType instrumentType) {
        switch (instrumentType) {
            case TURBO_INSTRUMENT:
                return (s) this.aom.get();
            case BINARY_INSTRUMENT:
                return (s) this.aol.get();
            case DIGITAL_INSTRUMENT:
                return (s) this.aok.get();
            case FX_INSTRUMENT:
                return (s) this.aoo.get();
            default:
                return (s) this.aon.get();
        }
    }

    public e n(InstrumentType instrumentType) {
        switch (instrumentType) {
            case DIGITAL_INSTRUMENT:
                return (e) this.aok.get();
            case FX_INSTRUMENT:
                return (e) this.aoo.get();
            default:
                return null;
        }
    }

    public void clear() {
        ((e) this.aok.get()).clear();
    }

    public static long a(int i, InstrumentType instrumentType, long j, long j2, long j3, long j4) {
        while (j2 - j4 < j) {
            if (!com.iqoption.app.managers.c.Gn().b(new i(Long.valueOf(j2 / 1000), Integer.valueOf(i), instrumentType)) && j2 > j) {
                break;
            }
            j2 += j3;
        }
        return j2;
    }

    public static String av(long j) {
        if (j == 0) {
            return IQApp.Dk().getString(R.string.n_a);
        }
        return bf.dwF.format(Long.valueOf(j));
    }

    public static String aw(long j) {
        if (j == 0) {
            return IQApp.Dk().getString(R.string.n_a);
        }
        if (m.aQ(j)) {
            return bf.cgr.format(Long.valueOf(j));
        }
        return bf.dwF.format(Long.valueOf(j));
    }

    public s<ImmutableList<Expiration>> h(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return m(aVar.getInstrumentType()).h(aVar);
    }

    public s<Expiration> k(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return m(aVar.getInstrumentType()).k(aVar);
    }

    public Expiration a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        return m(aVar.getInstrumentType()).a(aVar, expiration);
    }

    public boolean b(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        return m(aVar.getInstrumentType()).b(aVar, expiration);
    }

    public String a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, long j) {
        return m(aVar.getInstrumentType()).a(aVar, j);
    }

    public void l(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        m(aVar.getInstrumentType()).l(aVar);
    }

    public long c(com.iqoption.core.microservices.tradingengine.response.active.a aVar, Expiration expiration) {
        return m(aVar.getInstrumentType()).c(aVar, expiration);
    }

    public long i(com.iqoption.core.microservices.tradingengine.response.active.a aVar) {
        return m(aVar.getInstrumentType()).i(aVar);
    }
}
