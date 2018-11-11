package com.iqoption.dialog.a;

import com.google.common.base.n;
import com.iqoption.core.data.model.InstrumentType;
import java.util.ArrayList;

final /* synthetic */ class p implements n {
    private final InstrumentType cgH;
    private final ArrayList cgM;

    p(InstrumentType instrumentType, ArrayList arrayList) {
        this.cgH = instrumentType;
        this.cgM = arrayList;
    }

    public Object get() {
        return h.a(this.cgH, this.cgM);
    }
}
