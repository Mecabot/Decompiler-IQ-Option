package com.iqoption.gl;

import com.iqoption.app.IQApp;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.gl.NativeHandler.h;

final /* synthetic */ class r implements Runnable {
    private final String alY;

    r(String str) {
        this.alY = str;
    }

    public void run() {
        IQApp.Dn().aE(new h().setValue((Long) Position.parsePositionSplitId(this.alY)[0]));
    }
}
