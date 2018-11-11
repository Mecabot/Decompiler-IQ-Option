package com.iqoption.util.d;

import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import java.util.Iterator;

/* compiled from: SparseArrays */
public final class b {
    public static <T> Iterable<T> a(final LongSparseArray<T> longSparseArray) {
        return new Iterable<T>() {
            @NonNull
            public Iterator<T> iterator() {
                return new a(longSparseArray);
            }
        };
    }
}
