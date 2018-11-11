package io.reactivex.internal.util;

/* compiled from: OpenHashSet */
public final class e<T> {
    final float Sz;
    T[] keys;
    int mask;
    int maxSize;
    int size;

    static int jj(int i) {
        i *= -1640531527;
        return i ^ (i >>> 16);
    }

    public e() {
        this(16, 0.75f);
    }

    public e(int i, float f) {
        this.Sz = f;
        i = f.jk(i);
        this.mask = i - 1;
        this.maxSize = (int) (f * ((float) i));
        this.keys = new Object[i];
    }

    public boolean add(T t) {
        Object[] objArr = this.keys;
        int i = this.mask;
        int jj = jj(t.hashCode()) & i;
        Object obj = objArr[jj];
        if (obj != null) {
            if (obj.equals(t)) {
                return false;
            }
            do {
                jj = (jj + 1) & i;
                obj = objArr[jj];
                if (obj == null) {
                }
            } while (!obj.equals(t));
            return false;
        }
        objArr[jj] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        Object[] objArr = this.keys;
        int i = this.mask;
        int jj = jj(t.hashCode()) & i;
        Object obj = objArr[jj];
        if (obj == null) {
            return false;
        }
        if (obj.equals(t)) {
            return a(jj, objArr, i);
        }
        do {
            jj = (jj + 1) & i;
            obj = objArr[jj];
            if (obj == null) {
                return false;
            }
        } while (!obj.equals(t));
        return a(jj, objArr, i);
    }

    boolean a(int i, T[] tArr, int i2) {
        this.size--;
        while (true) {
            Object obj;
            int i3 = i + 1;
            while (true) {
                i3 &= i2;
                obj = tArr[i3];
                if (obj == null) {
                    tArr[i] = null;
                    return true;
                }
                int jj = jj(obj.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= jj || jj > i3) {
                        break;
                    }
                    i3++;
                } else {
                    if (i >= jj && jj > i3) {
                        break;
                    }
                    i3++;
                }
            }
            tArr[i] = obj;
            i = i3;
        }
    }

    void rehash() {
        Object[] objArr = this.keys;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.size;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                while (true) {
                    length--;
                    if (objArr[length] != null) {
                        break;
                    }
                }
                i3 = jj(objArr[length].hashCode()) & i2;
                if (objArr2[i3] != null) {
                    do {
                        i3 = (i3 + 1) & i2;
                    } while (objArr2[i3] != null);
                }
                objArr2[i3] = objArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (((float) i) * this.Sz);
                this.keys = objArr2;
                return;
            }
        }
    }

    public Object[] keys() {
        return this.keys;
    }
}
