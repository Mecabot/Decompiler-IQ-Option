package com.google.common.collect;

import com.google.common.base.f;
import com.google.common.base.i;
import com.iqoption.dto.event.OtnEmissionExecuted;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ObjectCountHashMap */
class y<K> extends e<K> {
    private transient int[] Sx;
    transient long[] Sy;
    private transient float Sz;
    private transient int threshold;

    /* compiled from: ObjectCountHashMap */
    class a extends a {
        a() {
            super();
        }

        public Iterator<com.google.common.collect.w.a<K>> iterator() {
            return new b<com.google.common.collect.w.a<K>>() {
                {
                    e eVar = y.this;
                }

                /* renamed from: bt */
                com.google.common.collect.w.a<K> aJ(int i) {
                    return new d(i);
                }
            };
        }
    }

    private static int G(long j) {
        return (int) (j >>> 32);
    }

    private static int H(long j) {
        return (int) j;
    }

    private static long a(long j, int i) {
        return (j & -4294967296L) | (((long) i) & 4294967295L);
    }

    public static <K> y<K> uE() {
        return new y();
    }

    public static <K> y<K> bm(int i) {
        return new y(i);
    }

    y() {
        c(3, 1.0f);
    }

    y(e<K> eVar) {
        c(eVar.size(), 1.0f);
        int sg = eVar.sg();
        while (sg != -1) {
            g(eVar.getKey(sg), eVar.getValue(sg));
            sg = eVar.aI(sg);
        }
    }

    y(int i) {
        this(i, 1.0f);
    }

    y(int i, float f) {
        c(i, f);
    }

    void c(int i, float f) {
        boolean z = false;
        i.checkArgument(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        i.checkArgument(z, "Illegal load factor");
        int a = r.a(i, (double) f);
        this.Sx = bn(a);
        this.Sz = f;
        this.keys = new Object[i];
        this.values = new int[i];
        this.Sy = bo(i);
        this.threshold = Math.max(1, (int) (((float) a) * f));
    }

    private static int[] bn(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static long[] bo(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    private int uF() {
        return this.Sx.length - 1;
    }

    public int g(K k, int i) {
        g.c(i, OtnEmissionExecuted.COUNT);
        long[] jArr = this.Sy;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int ac = r.ac(k);
        int uF = uF() & ac;
        int i2 = this.size;
        int i3 = this.Sx[uF];
        if (i3 == -1) {
            this.Sx[uF] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (G(j) == ac && f.equal(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                uF = H(j);
                if (uF == -1) {
                    jArr[i3] = a(j, i2);
                    break;
                }
                i3 = uF;
            }
        }
        if (i2 == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i5 = i2 + 1;
        bp(i5);
        a(i2, k, i, ac);
        this.size = i5;
        if (i2 >= this.threshold) {
            br(this.Sx.length * 2);
        }
        this.modCount++;
        return 0;
    }

    void a(int i, K k, int i2, int i3) {
        this.Sy[i] = (((long) i3) << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = i2;
    }

    private void bp(int i) {
        int length = this.Sy.length;
        if (i > length) {
            i = Math.max(1, length >>> 1) + length;
            if (i < 0) {
                i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (i != length) {
                bq(i);
            }
        }
    }

    void bq(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.Sy;
        int length = jArr.length;
        jArr = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArr, length, i, -1);
        }
        this.Sy = jArr;
    }

    private void br(int i) {
        if (this.Sx.length >= 1073741824) {
            this.threshold = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            return;
        }
        int i2 = ((int) (((float) i) * this.Sz)) + 1;
        int[] bn = bn(i);
        long[] jArr = this.Sy;
        int length = bn.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int G = G(jArr[i3]);
            int i4 = G & length;
            int i5 = bn[i4];
            bn[i4] = i3;
            jArr[i3] = (((long) G) << 32) | (((long) i5) & 4294967295L);
        }
        this.threshold = i2;
        this.Sx = bn;
    }

    int indexOf(Object obj) {
        int ac = r.ac(obj);
        int i = this.Sx[uF() & ac];
        while (i != -1) {
            long j = this.Sy[i];
            if (G(j) == ac && f.equal(obj, this.keys[i])) {
                return i;
            }
            i = H(j);
        }
        return -1;
    }

    public int get(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.values[indexOf];
    }

    public int W(Object obj) {
        return e(obj, r.ac(obj));
    }

    int aG(int i) {
        return e(this.keys[i], G(this.Sy[i]));
    }

    private int e(Object obj, int i) {
        int uF = uF() & i;
        int i2 = this.Sx[uF];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (G(this.Sy[i2]) == i && f.equal(obj, this.keys[i2])) {
                int i4 = this.values[i2];
                if (i3 == -1) {
                    this.Sx[uF] = H(this.Sy[i2]);
                } else {
                    this.Sy[i3] = a(this.Sy[i3], H(this.Sy[i2]));
                }
                bs(i2);
                this.size--;
                this.modCount++;
                return i4;
            }
            i3 = H(this.Sy[i2]);
            if (i3 == -1) {
                return 0;
            }
            int i5 = i3;
            i3 = i2;
            i2 = i5;
        }
    }

    void bs(int i) {
        int size = size() - 1;
        if (i < size) {
            this.keys[i] = this.keys[size];
            this.values[i] = this.values[size];
            this.keys[size] = null;
            this.values[size] = 0;
            long j = this.Sy[size];
            this.Sy[i] = j;
            this.Sy[size] = -1;
            int G = G(j) & uF();
            int i2 = this.Sx[G];
            if (i2 == size) {
                this.Sx[G] = i;
                return;
            }
            while (true) {
                long j2 = this.Sy[i2];
                G = H(j2);
                if (G == size) {
                    this.Sy[i2] = a(j2, i);
                    return;
                }
                i2 = G;
            }
        } else {
            this.keys[i] = null;
            this.values[i] = 0;
            this.Sy[i] = -1;
        }
    }

    Set<com.google.common.collect.w.a<K>> rF() {
        return new a();
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.Sx, -1);
        Arrays.fill(this.Sy, -1);
        this.size = 0;
    }
}
