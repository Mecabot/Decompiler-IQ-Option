package com.iqoption.dialog.a;

import java.util.List;

final /* synthetic */ class o implements Runnable {
    private final h cgK;
    private final List cgL;

    o(h hVar, List list) {
        this.cgK = hVar;
        this.cgL = list;
    }

    public void run() {
        this.cgK.aw(this.cgL);
    }
}
