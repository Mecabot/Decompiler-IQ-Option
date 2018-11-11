package com.iqoption.dialog.a;

import java.util.List;

final /* synthetic */ class s implements Runnable {
    private final h cgK;
    private final List cgL;

    s(h hVar, List list) {
        this.cgK = hVar;
        this.cgL = list;
    }

    public void run() {
        this.cgK.av(this.cgL);
    }
}
