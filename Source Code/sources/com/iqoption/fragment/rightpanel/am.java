package com.iqoption.fragment.rightpanel;

import com.iqoption.app.managers.a.k.b;

final /* synthetic */ class am implements Runnable {
    private final a cHf;
    private final b cHj;

    am(a aVar, b bVar) {
        this.cHf = aVar;
        this.cHj = bVar;
    }

    public void run() {
        this.cHf.a(this.cHj);
    }
}
