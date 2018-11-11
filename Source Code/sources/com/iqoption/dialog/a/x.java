package com.iqoption.dialog.a;

import java.util.List;

final /* synthetic */ class x implements Runnable {
    private final h cgK;
    private final List cgL;

    x(h hVar, List list) {
        this.cgK = hVar;
        this.cgL = list;
    }

    public void run() {
        a.b(this.cgK, this.cgL);
    }
}
