package com.google.common.collect;

import com.google.common.base.i;
import java.lang.reflect.Array;
import java.util.Collection;

/* compiled from: ObjectArrays */
public final class x {
    public static <T> T[] a(Class<T> cls, int i) {
        return (Object[]) Array.newInstance(cls, i);
    }

    public static <T> T[] c(T[] tArr, int i) {
        return z.c(tArr, i);
    }

    static <T> T[] a(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = c(tArr, size);
        }
        b(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    static <T> T[] a(Object[] objArr, int i, int i2, T[] tArr) {
        Object tArr2;
        i.g(i, i + i2, objArr.length);
        if (tArr2.length < i2) {
            tArr2 = c(tArr2, i2);
        } else if (tArr2.length > i2) {
            tArr2[i2] = null;
        }
        System.arraycopy(objArr, i, tArr2, 0, i2);
        return tArr2;
    }

    static Object[] q(Collection<?> collection) {
        return b(collection, new Object[collection.size()]);
    }

    static Object[] a(Object[] objArr, int i, int i2) {
        i.g(i, i + i2, objArr.length);
        if (i2 == 0) {
            return new Object[0];
        }
        Object obj = new Object[i2];
        System.arraycopy(objArr, i, obj, 0, i2);
        return obj;
    }

    private static Object[] b(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        for (Object obj : iterable) {
            int i2 = i + 1;
            objArr[i] = obj;
            i = i2;
        }
        return objArr;
    }

    static Object[] o(Object... objArr) {
        return d(objArr, objArr.length);
    }

    static Object[] d(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            l(objArr[i2], i2);
        }
        return objArr;
    }

    static Object l(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("at index ");
        stringBuilder.append(i);
        throw new NullPointerException(stringBuilder.toString());
    }
}
