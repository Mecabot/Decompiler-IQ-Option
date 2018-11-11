package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzc {
    private static final Object sLock = new Object();
    private static int zzlgg;
    private SparseArray<Integer> zzlgh = new SparseArray();
    private SparseArray<Integer> zzlgi = new SparseArray();

    @Hide
    public final int zzfm(int i) {
        synchronized (sLock) {
            Integer num = (Integer) this.zzlgh.get(i);
            if (num != null) {
                i = num.intValue();
                return i;
            }
            int i2 = zzlgg;
            zzlgg++;
            this.zzlgh.append(i, Integer.valueOf(i2));
            this.zzlgi.append(i2, Integer.valueOf(i));
            return i2;
        }
    }

    @Hide
    public final int zzfn(int i) {
        synchronized (sLock) {
            i = ((Integer) this.zzlgi.get(i)).intValue();
        }
        return i;
    }
}
