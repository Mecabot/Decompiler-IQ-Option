package com.iqoption.app.managers;

import com.iqoption.mobbtech.connect.response.ArrayBuybackResponse.Map;

final /* synthetic */ class m implements Runnable {
    private final b amU;
    private final Map amV;

    m(b bVar, Map map) {
        this.amU = bVar;
        this.amV = map;
    }

    public void run() {
        this.amU.a(this.amV);
    }
}
