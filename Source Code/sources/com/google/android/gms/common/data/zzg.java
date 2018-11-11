package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Hide;
import java.util.ArrayList;

@Hide
public abstract class zzg<T> extends AbstractDataBuffer<T> {
    private boolean zzgcy = false;
    private ArrayList<Integer> zzgcz;

    protected zzg(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zzalk() {
        synchronized (this) {
            if (!this.zzgcy) {
                int i = this.zzfxb.zzgcq;
                this.zzgcz = new ArrayList();
                if (i > 0) {
                    this.zzgcz.add(Integer.valueOf(0));
                    String zzalj = zzalj();
                    Object zzd = this.zzfxb.zzd(zzalj, 0, this.zzfxb.zzby(0));
                    for (int i2 = 1; i2 < i; i2++) {
                        int zzby = this.zzfxb.zzby(i2);
                        String zzd2 = this.zzfxb.zzd(zzalj, i2, zzby);
                        if (zzd2 == null) {
                            StringBuilder stringBuilder = new StringBuilder(String.valueOf(zzalj).length() + 78);
                            stringBuilder.append("Missing value for markerColumn: ");
                            stringBuilder.append(zzalj);
                            stringBuilder.append(", at row: ");
                            stringBuilder.append(i2);
                            stringBuilder.append(", for window: ");
                            stringBuilder.append(zzby);
                            throw new NullPointerException(stringBuilder.toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.zzgcz.add(Integer.valueOf(i2));
                            zzd = zzd2;
                        }
                    }
                }
                this.zzgcy = true;
            }
        }
    }

    private final int zzcb(int i) {
        if (i >= 0 && i < this.zzgcz.size()) {
            return ((Integer) this.zzgcz.get(i)).intValue();
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("Position ");
        stringBuilder.append(i);
        stringBuilder.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final T get(int i) {
        int i2;
        zzalk();
        int zzcb = zzcb(i);
        if (i < 0 || i == this.zzgcz.size()) {
            i2 = 0;
        } else {
            i2 = (i == this.zzgcz.size() - 1 ? this.zzfxb.zzgcq : ((Integer) this.zzgcz.get(i + 1)).intValue()) - ((Integer) this.zzgcz.get(i)).intValue();
            if (i2 == 1) {
                this.zzfxb.zzby(zzcb(i));
            }
        }
        return zzl(zzcb, i2);
    }

    public int getCount() {
        zzalk();
        return this.zzgcz.size();
    }

    @Hide
    protected abstract String zzalj();

    @Hide
    protected abstract T zzl(int i, int i2);
}
