package com.iqoption.view.toppanel;

import com.iqoption.gl.NativeHandler.o;

final /* synthetic */ class r implements Runnable {
    private final a dKG;
    private final o dKI;

    r(a aVar, o oVar) {
        this.dKG = aVar;
        this.dKI = oVar;
    }

    public void run() {
        this.dKG.a(this.dKI);
    }
}
