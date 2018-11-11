package com.google.common.primitives;

import com.google.common.base.i;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Ints {

    private static class IntArrayAsList extends AbstractList<Integer> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        /* renamed from: bx */
        public Integer get(int i) {
            i.s(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.b(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                int d = Ints.b(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (d >= 0) {
                    return d - this.start;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                int e = Ints.c(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (e >= 0) {
                    return e - this.start;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public Integer set(int i, Integer num) {
            i.s(i, size());
            int i2 = this.array[this.start + i];
            this.array[this.start + i] = ((Integer) i.checkNotNull(num)).intValue();
            return Integer.valueOf(i2);
        }

        public List<Integer> subList(int i, int i2) {
            i.g(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new IntArrayAsList(this.array, this.start + i, this.start + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Ints.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size() * 5);
            stringBuilder.append('[');
            stringBuilder.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    stringBuilder.append(", ");
                    stringBuilder.append(this.array[i]);
                } else {
                    stringBuilder.append(']');
                    return stringBuilder.toString();
                }
            }
        }

        int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    public static int I(long j) {
        return j > 2147483647L ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : j < -2147483648L ? Integer.MIN_VALUE : (int) j;
    }

    public static int compare(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static int hashCode(int i) {
        return i;
    }

    private static int b(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int c(int[] iArr, int i, int i2, int i3) {
        for (i3--; i3 >= i2; i3--) {
            if (iArr[i3] == i) {
                return i3;
            }
        }
        return -1;
    }

    public static int max(int... iArr) {
        i.checkArgument(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static int[] s(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).toIntArray();
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) i.checkNotNull(toArray[i])).intValue();
        }
        return iArr;
    }

    public static Integer cM(String str) {
        return q(str, 10);
    }

    public static Integer q(String str, int i) {
        Long r = Longs.r(str, i);
        return (r == null || r.longValue() != ((long) r.intValue())) ? null : Integer.valueOf(r.intValue());
    }
}
