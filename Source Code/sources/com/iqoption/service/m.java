package com.iqoption.service;

import com.google.gson.JsonArray;
import com.iqoption.core.data.model.InstrumentType;

final /* synthetic */ class m implements Runnable {
    private final InstrumentType amb;
    private final JsonArray dqm;

    m(JsonArray jsonArray, InstrumentType instrumentType) {
        this.dqm = jsonArray;
        this.amb = instrumentType;
    }

    public void run() {
        WebSocketHandler.a(this.dqm, this.amb);
    }
}
