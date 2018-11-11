package com.iqoption.gl;

import com.iqoption.app.IQApp;
import com.iqoption.dto.entity.position.Position;
import com.iqoption.gl.NativeHandler.l;

final /* synthetic */ class q implements Runnable {
    private final String alY;

    q(String str) {
        this.alY = str;
    }

    public void run() {
        IQApp.Dn().aE(new l().setValue((Long) Position.parsePositionSplitId(this.alY)[0]));
    }
}
