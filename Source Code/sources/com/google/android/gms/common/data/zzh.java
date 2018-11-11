package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Hide;
import java.util.NoSuchElementException;

@Hide
public final class zzh<T> extends zzb<T> {
    private T zzgda;

    public zzh(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public final T next() {
        StringBuilder stringBuilder;
        if (hasNext()) {
            this.zzgcf++;
            if (this.zzgcf == 0) {
                this.zzgda = this.zzgce.get(0);
                if (!(this.zzgda instanceof zzc)) {
                    String valueOf = String.valueOf(this.zzgda.getClass());
                    stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 44);
                    stringBuilder.append("DataBuffer reference of type ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" is not movable");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            ((zzc) this.zzgda).zzbw(this.zzgcf);
            return this.zzgda;
        }
        int i = this.zzgcf;
        stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(i);
        throw new NoSuchElementException(stringBuilder.toString());
    }
}
