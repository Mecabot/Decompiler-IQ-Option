package com.iqoption.app.helpers;

import com.iqoption.core.data.model.InstrumentType;
import java.util.HashMap;

final /* synthetic */ class o implements Runnable {
    private final a alW;
    private final InstrumentType amb;
    private final HashMap amc;

    o(a aVar, InstrumentType instrumentType, HashMap hashMap) {
        this.alW = aVar;
        this.amb = instrumentType;
        this.amc = hashMap;
    }

    public void run() {
        this.alW.c(this.amb, this.amc);
    }
}
