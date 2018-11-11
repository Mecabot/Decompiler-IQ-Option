package com.iqoption.app.managers.tab;

import com.iqoption.app.managers.tab.a.b;
import com.iqoption.gl.NativeHandler.n;

final /* synthetic */ class e implements Runnable {
    private final String afd;
    private final b apl;
    private final n apm;

    e(b bVar, String str, n nVar) {
        this.apl = bVar;
        this.afd = str;
        this.apm = nVar;
    }

    public void run() {
        this.apl.a(this.afd, this.apm);
    }
}
