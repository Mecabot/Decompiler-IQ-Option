package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: IntTree */
final class c<V> {
    static final c<Object> eXZ = new c();
    private final long eYa;
    private final c<V> eYb;
    private final c<V> eYc;
    private final int size;
    private final V value;

    private c() {
        this.size = 0;
        this.eYa = 0;
        this.value = null;
        this.eYb = null;
        this.eYc = null;
    }

    private c(long j, V v, c<V> cVar, c<V> cVar2) {
        this.eYa = j;
        this.value = v;
        this.eYb = cVar;
        this.eYc = cVar2;
        this.size = (cVar.size + 1) + cVar2.size;
    }

    private c<V> dk(long j) {
        if (this.size == 0 || j == this.eYa) {
            return this;
        }
        return new c(j, this.value, this.eYb, this.eYc);
    }

    V get(long j) {
        if (this.size == 0) {
            return null;
        }
        if (j < this.eYa) {
            return this.eYb.get(j - this.eYa);
        }
        if (j > this.eYa) {
            return this.eYc.get(j - this.eYa);
        }
        return this.value;
    }

    c<V> a(long j, V v) {
        if (this.size == 0) {
            return new c(j, v, this, this);
        }
        if (j < this.eYa) {
            return a(this.eYb.a(j - this.eYa, (Object) v), this.eYc);
        }
        if (j > this.eYa) {
            return a(this.eYb, this.eYc.a(j - this.eYa, (Object) v));
        }
        if (v == this.value) {
            return this;
        }
        return new c(j, v, this.eYb, this.eYc);
    }

    private c<V> a(c<V> cVar, c<V> cVar2) {
        if (cVar == this.eYb && cVar2 == this.eYc) {
            return this;
        }
        return a(this.eYa, this.value, cVar, cVar2);
    }

    private static <V> c<V> a(long j, V v, c<V> cVar, c<V> cVar2) {
        c<V> cVar3 = cVar;
        c<V> cVar4 = cVar2;
        if (cVar3.size + cVar4.size > 1) {
            c cVar5;
            if (cVar3.size >= cVar4.size * 5) {
                c cVar6 = cVar3.eYb;
                cVar5 = cVar3.eYc;
                if (cVar5.size < cVar6.size * 2) {
                    return new c(cVar3.eYa + j, cVar3.value, cVar6, new c(-cVar3.eYa, v, cVar5.dk(cVar5.eYa + cVar3.eYa), cVar4));
                }
                c cVar7 = cVar5.eYb;
                c cVar8 = cVar5.eYc;
                long j2 = (cVar5.eYa + cVar3.eYa) + j;
                return new c(j2, cVar5.value, new c(-cVar5.eYa, cVar3.value, cVar6, cVar7.dk(cVar7.eYa + cVar5.eYa)), new c((-cVar3.eYa) - cVar5.eYa, v, cVar8.dk((cVar8.eYa + cVar5.eYa) + cVar3.eYa), cVar4));
            } else if (cVar4.size >= cVar3.size * 5) {
                c cVar9 = cVar4.eYb;
                c cVar10 = cVar4.eYc;
                if (cVar9.size < cVar10.size * 2) {
                    long j3 = cVar4.eYa + j;
                    return new c(j3, cVar4.value, new c(-cVar4.eYa, v, cVar3, cVar9.dk(cVar9.eYa + cVar4.eYa)), cVar10);
                }
                cVar5 = cVar9.eYb;
                c cVar11 = cVar9.eYc;
                long j4 = (cVar9.eYa + cVar4.eYa) + j;
                return new c(j4, cVar9.value, new c((-cVar4.eYa) - cVar9.eYa, v, cVar3, cVar5.dk((cVar5.eYa + cVar9.eYa) + cVar4.eYa)), new c(-cVar9.eYa, cVar4.value, cVar11.dk(cVar11.eYa + cVar9.eYa), cVar10));
            }
        }
        return new c(j, v, cVar3, cVar4);
    }
}
