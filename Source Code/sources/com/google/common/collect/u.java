package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.e;
import com.google.common.base.e.a;
import com.google.common.base.i;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapMaker */
public final class u {
    int NW = -1;
    boolean RM;
    int concurrencyLevel = -1;
    Equivalence<Object> keyEquivalence;
    Strength keyStrength;
    Strength valueStrength;

    u c(Equivalence<Object> equivalence) {
        i.b(this.keyEquivalence == null, "key equivalence was already set to %s", this.keyEquivalence);
        this.keyEquivalence = (Equivalence) i.checkNotNull(equivalence);
        this.RM = true;
        return this;
    }

    Equivalence<Object> qi() {
        return (Equivalence) e.h(this.keyEquivalence, tP().defaultEquivalence());
    }

    public u ba(int i) {
        boolean z = false;
        i.b(this.NW == -1, "initial capacity was already set to %s", this.NW);
        if (i >= 0) {
            z = true;
        }
        i.checkArgument(z);
        this.NW = i;
        return this;
    }

    int qk() {
        return this.NW == -1 ? 16 : this.NW;
    }

    public u bb(int i) {
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

    public u tO() {
        return a(Strength.WEAK);
    }

    u a(Strength strength) {
        i.b(this.keyStrength == null, "Key strength was already set to %s", this.keyStrength);
        this.keyStrength = (Strength) i.checkNotNull(strength);
        if (strength != Strength.STRONG) {
            this.RM = true;
        }
        return this;
    }

    Strength tP() {
        return (Strength) e.h(this.keyStrength, Strength.STRONG);
    }

    u b(Strength strength) {
        i.b(this.valueStrength == null, "Value strength was already set to %s", this.valueStrength);
        this.valueStrength = (Strength) i.checkNotNull(strength);
        if (strength != Strength.STRONG) {
            this.RM = true;
        }
        return this;
    }

    Strength tQ() {
        return (Strength) e.h(this.valueStrength, Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> tR() {
        if (this.RM) {
            return MapMakerInternalMap.a(this);
        }
        return new ConcurrentHashMap(qk(), 0.75f, ql());
    }

    public String toString() {
        a B = e.B(this);
        if (this.NW != -1) {
            B.n("initialCapacity", this.NW);
        }
        if (this.concurrencyLevel != -1) {
            B.n("concurrencyLevel", this.concurrencyLevel);
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
        return B.toString();
    }
}
