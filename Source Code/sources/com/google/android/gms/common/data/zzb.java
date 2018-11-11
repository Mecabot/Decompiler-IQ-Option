package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.Iterator;
import java.util.NoSuchElementException;

@Hide
public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzgce;
    protected int zzgcf = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzgce = (DataBuffer) zzbq.checkNotNull(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzgcf < this.zzgce.getCount() - 1;
    }

    public T next() {
        int i;
        if (hasNext()) {
            DataBuffer dataBuffer = this.zzgce;
            i = this.zzgcf + 1;
            this.zzgcf = i;
            return dataBuffer.get(i);
        }
        i = this.zzgcf;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(i);
        throw new NoSuchElementException(stringBuilder.toString());
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
