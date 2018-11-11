package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzfjz extends zzfjy<FieldDescriptorType, Object> {
    zzfjz(int i) {
        super(i, null);
    }

    public final void zzbkr() {
        if (!isImmutable()) {
            Entry zzmr;
            for (int i = 0; i < zzdbp(); i++) {
                zzmr = zzmr(i);
                if (((zzfhs) zzmr.getKey()).zzczn()) {
                    zzmr.setValue(Collections.unmodifiableList((List) zzmr.getValue()));
                }
            }
            for (Entry zzmr2 : zzdbq()) {
                if (((zzfhs) zzmr2.getKey()).zzczn()) {
                    zzmr2.setValue(Collections.unmodifiableList((List) zzmr2.getValue()));
                }
            }
        }
        super.zzbkr();
    }
}
