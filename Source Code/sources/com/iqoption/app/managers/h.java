package com.iqoption.app.managers;

import com.iqoption.dto.entity.position.Position;

final /* synthetic */ class h implements Runnable {
    private final c amN;
    private final Position amQ;

    h(c cVar, Position position) {
        this.amN = cVar;
        this.amQ = position;
    }

    public void run() {
        this.amN.i(this.amQ);
    }
}
