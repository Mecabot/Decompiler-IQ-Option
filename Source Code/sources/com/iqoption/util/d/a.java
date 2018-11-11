package com.iqoption.util.d;

import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import com.google.common.base.i;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: LongSparseArrayIterator */
public class a<T> implements Iterator<T> {
    private int aCH = 0;
    private final LongSparseArray<T> dxg;
    private final int size;

    public a(@NonNull LongSparseArray<T> longSparseArray) {
        i.checkNotNull(longSparseArray);
        this.dxg = longSparseArray;
        this.size = longSparseArray.size();
    }

    public boolean hasNext() {
        return this.aCH < this.size;
    }

    public T next() {
        if (hasNext()) {
            LongSparseArray longSparseArray = this.dxg;
            int i = this.aCH;
            this.aCH = i + 1;
            return longSparseArray.valueAt(i);
        }
        throw new NoSuchElementException();
    }
}
