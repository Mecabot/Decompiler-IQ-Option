package com.google.common.collect;

import com.google.common.base.i;
import com.google.common.c.b;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: TopKSelector */
final class ag<T> {
    private final T[] Tt;
    private T Tu;
    private int bufferSize;
    private final Comparator<? super T> comparator;
    private final int k;

    public static <T> ag<T> a(int i, Comparator<? super T> comparator) {
        return new ag(comparator, i);
    }

    private ag(Comparator<? super T> comparator, int i) {
        this.comparator = (Comparator) i.checkNotNull(comparator, "comparator");
        this.k = i;
        i.a(i >= 0, "k must be nonnegative, was %s", i);
        this.Tt = new Object[(i * 2)];
        this.bufferSize = 0;
        this.Tu = null;
    }

    public void aB(T t) {
        if (this.k != 0) {
            Object[] objArr;
            int i;
            if (this.bufferSize == 0) {
                this.Tt[0] = t;
                this.Tu = t;
                this.bufferSize = 1;
            } else if (this.bufferSize < this.k) {
                objArr = this.Tt;
                i = this.bufferSize;
                this.bufferSize = i + 1;
                objArr[i] = t;
                if (this.comparator.compare(t, this.Tu) > 0) {
                    this.Tu = t;
                }
            } else if (this.comparator.compare(t, this.Tu) < 0) {
                objArr = this.Tt;
                i = this.bufferSize;
                this.bufferSize = i + 1;
                objArr[i] = t;
                if (this.bufferSize == this.k * 2) {
                    trim();
                }
            }
        }
    }

    private void trim() {
        int i = (this.k * 2) - 1;
        int a = b.a(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = i(i2, i, ((i2 + i) + 1) >>> 1);
            if (i5 <= this.k) {
                if (i5 >= this.k) {
                    break;
                }
                i2 = Math.max(i5, i2 + 1);
                i4 = i5;
            } else {
                i = i5 - 1;
            }
            i3++;
            if (i3 >= a) {
                Arrays.sort(this.Tt, i2, i, this.comparator);
                break;
            }
        }
        this.bufferSize = this.k;
        this.Tu = this.Tt[i4];
        while (true) {
            i4++;
            if (i4 >= this.k) {
                return;
            }
            if (this.comparator.compare(this.Tt[i4], this.Tu) > 0) {
                this.Tu = this.Tt[i4];
            }
        }
    }

    private int i(int i, int i2, int i3) {
        Object obj = this.Tt[i3];
        this.Tt[i3] = this.Tt[i2];
        i3 = i;
        while (i < i2) {
            if (this.comparator.compare(this.Tt[i], obj) < 0) {
                C(i3, i);
                i3++;
            }
            i++;
        }
        this.Tt[i2] = this.Tt[i3];
        this.Tt[i3] = obj;
        return i3;
    }

    private void C(int i, int i2) {
        Object obj = this.Tt[i];
        this.Tt[i] = this.Tt[i2];
        this.Tt[i2] = obj;
    }

    public void x(Iterator<? extends T> it) {
        while (it.hasNext()) {
            aB(it.next());
        }
    }

    public List<T> uO() {
        Arrays.sort(this.Tt, 0, this.bufferSize, this.comparator);
        if (this.bufferSize > this.k) {
            Arrays.fill(this.Tt, this.k, this.Tt.length, null);
            this.bufferSize = this.k;
            this.Tu = this.Tt[this.k - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.Tt, this.bufferSize)));
    }
}
