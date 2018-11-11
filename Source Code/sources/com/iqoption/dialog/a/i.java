package com.iqoption.dialog.a;

import com.google.common.base.n;
import com.iqoption.core.data.model.InstrumentType;

final /* synthetic */ class i implements n {
    private final InstrumentType cgH;
    private final long[] cgI;

    i(InstrumentType instrumentType, long[] jArr) {
        this.cgH = instrumentType;
        this.cgI = jArr;
    }

    public Object get() {
        return h.a(this.cgH, this.cgI);
    }
}
