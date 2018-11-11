package com.iqoption.dialog.a;

import com.google.common.base.n;
import com.iqoption.core.data.model.InstrumentType;

final /* synthetic */ class j implements n {
    private final String afd;
    private final InstrumentType cgH;

    j(InstrumentType instrumentType, String str) {
        this.cgH = instrumentType;
        this.afd = str;
    }

    public Object get() {
        return h.c(this.cgH, this.afd);
    }
}
