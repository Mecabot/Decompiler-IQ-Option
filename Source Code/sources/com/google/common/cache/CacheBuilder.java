package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.e;
import com.google.common.base.i;
import com.google.common.base.n;
import com.google.common.base.p;
import com.google.common.cache.a.a;
import com.google.common.cache.a.b;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder<K, V> {
    static final n<? extends b> NN = Suppliers.H(new b() {
        public void ay(int i) {
        }

        public void az(int i) {
        }

        public void qf() {
        }

        public void y(long j) {
        }

        public void z(long j) {
        }
    });
    static final c NQ = new c(0, 0, 0, 0, 0, 0);
    static final n<b> NS = new n<b>() {
        /* renamed from: qz */
        public b get() {
            return new a();
        }
    };
    static final p NT = new p() {
        public long qd() {
            return 0;
        }
    };
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    boolean NV = true;
    int NW = -1;
    long NX = -1;
    long NY = -1;
    long Oa = -1;
    n<? extends b> Ob = NN;
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    Equivalence<Object> keyEquivalence;
    Strength keyStrength;
    g<? super K, ? super V> removalListener;
    p ticker;
    Equivalence<Object> valueEquivalence;
    Strength valueStrength;
    h<? super K, ? super V> weigher;

    enum NullListener implements g<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    enum OneWeigher implements h<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> qh() {
        return new CacheBuilder();
    }

    CacheBuilder<K, V> a(Equivalence<Object> equivalence) {
        i.b(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) i.checkNotNull(equivalence);
        return this;
    }

    Equivalence<Object> qi() {
        return (Equivalence) e.h(this.keyEquivalence, qp().defaultEquivalence());
    }

    CacheBuilder<K, V> b(Equivalence<Object> equivalence) {
        i.b(this.valueEquivalence == null, "value equivalence was already set to %s", this.valueEquivalence);
        this.valueEquivalence = (Equivalence) i.checkNotNull(equivalence);
        return this;
    }

    Equivalence<Object> qj() {
        return (Equivalence) e.h(this.valueEquivalence, qq().defaultEquivalence());
    }

    int qk() {
        return this.NW == -1 ? 16 : this.NW;
    }

    public CacheBuilder<K, V> aA(int i) {
        boolean z = false;
        i.b(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        if (i > 0) {
            z = true;
        }
        i.checkArgument(z);
        this.concurrencyLevel = i;
        return this;
    }

    int ql() {
        return this.concurrencyLevel == -1 ? 4 : this.concurrencyLevel;
    }

    public CacheBuilder<K, V> A(long j) {
        boolean z = false;
        i.b(this.NX == -1, "maximum size was already set to %s", this.NX);
        i.b(this.NY == -1, "maximum weight was already set to %s", this.NY);
        i.a(this.weigher == null, "maximum size can not be combined with weigher");
        if (j >= 0) {
            z = true;
        }
        i.checkArgument(z, "maximum size must not be negative");
        this.NX = j;
        return this;
    }

    public CacheBuilder<K, V> B(long j) {
        boolean z = false;
        i.b(this.NY == -1, "maximum weight was already set to %s", this.NY);
        i.b(this.NX == -1, "maximum size was already set to %s", this.NX);
        this.NY = j;
        if (j >= 0) {
            z = true;
        }
        i.checkArgument(z, "maximum weight must not be negative");
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(h<? super K1, ? super V1> hVar) {
        boolean z = false;
        i.checkState(this.weigher == null);
        if (this.NV) {
            if (this.NX == -1) {
                z = true;
            }
            i.b(z, "weigher can not be combined with maximum size", this.NX);
        }
        this.weigher = (h) i.checkNotNull(hVar);
        return this;
    }

    long qm() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        return this.weigher == null ? this.NX : this.NY;
    }

    <K1 extends K, V1 extends V> h<K1, V1> qn() {
        return (h) e.h(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> qo() {
        return a(Strength.WEAK);
    }

    CacheBuilder<K, V> a(Strength strength) {
        i.b(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (Strength) i.checkNotNull(strength);
        return this;
    }

    Strength qp() {
        return (Strength) e.h(this.keyStrength, Strength.STRONG);
    }

    CacheBuilder<K, V> b(Strength strength) {
        i.b(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (Strength) i.checkNotNull(strength);
        return this;
    }

    Strength qq() {
        return (Strength) e.h(this.valueStrength, Strength.STRONG);
    }

    public CacheBuilder<K, V> a(long j, TimeUnit timeUnit) {
        boolean z = false;
        i.b(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        if (j >= 0) {
            z = true;
        }
        i.a(z, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    long qr() {
        return this.expireAfterWriteNanos == -1 ? 0 : this.expireAfterWriteNanos;
    }

    public CacheBuilder<K, V> b(long j, TimeUnit timeUnit) {
        boolean z = false;
        i.b(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        if (j >= 0) {
            z = true;
        }
        i.a(z, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    long qs() {
        return this.expireAfterAccessNanos == -1 ? 0 : this.expireAfterAccessNanos;
    }

    long qt() {
        return this.Oa == -1 ? 0 : this.Oa;
    }

    public CacheBuilder<K, V> a(p pVar) {
        i.checkState(this.ticker == null);
        this.ticker = (p) i.checkNotNull(pVar);
        return this;
    }

    p ab(boolean z) {
        if (this.ticker != null) {
            return this.ticker;
        }
        return z ? p.qe() : NT;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(g<? super K1, ? super V1> gVar) {
        i.checkState(this.removalListener == null);
        this.removalListener = (g) i.checkNotNull(gVar);
        return this;
    }

    <K1 extends K, V1 extends V> g<K1, V1> qu() {
        return (g) e.h(this.removalListener, NullListener.INSTANCE);
    }

    n<? extends b> qv() {
        return this.Ob;
    }

    public <K1 extends K, V1 extends V> e<K1, V1> a(CacheLoader<? super K1, V1> cacheLoader) {
        qy();
        return new LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> b<K1, V1> qw() {
        qy();
        qx();
        return new LocalManualCache(this);
    }

    private void qx() {
        i.a(this.Oa == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void qy() {
        boolean z = false;
        if (this.weigher == null) {
            if (this.NY == -1) {
                z = true;
            }
            i.a(z, "maximumWeight requires weigher");
        } else if (this.NV) {
            if (this.NY != -1) {
                z = true;
            }
            i.a(z, "weigher requires maximumWeight");
        } else if (this.NY == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public String toString() {
        StringBuilder stringBuilder;
        e.a B = e.B(this);
        if (this.NW != -1) {
            B.n("initialCapacity", this.NW);
        }
        if (this.concurrencyLevel != -1) {
            B.n("concurrencyLevel", this.concurrencyLevel);
        }
        if (this.NX != -1) {
            B.e("maximumSize", this.NX);
        }
        if (this.NY != -1) {
            B.e("maximumWeight", this.NY);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.expireAfterWriteNanos);
            stringBuilder.append("ns");
            B.d("expireAfterWrite", stringBuilder.toString());
        }
        if (this.expireAfterAccessNanos != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.expireAfterAccessNanos);
            stringBuilder.append("ns");
            B.d("expireAfterAccess", stringBuilder.toString());
        }
        if (this.keyStrength != null) {
            B.d("keyStrength", com.google.common.base.a.toLowerCase(this.keyStrength.toString()));
        }
        if (this.valueStrength != null) {
            B.d("valueStrength", com.google.common.base.a.toLowerCase(this.valueStrength.toString()));
        }
        if (this.keyEquivalence != null) {
            B.C("keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            B.C("valueEquivalence");
        }
        if (this.removalListener != null) {
            B.C("removalListener");
        }
        return B.toString();
    }
}
