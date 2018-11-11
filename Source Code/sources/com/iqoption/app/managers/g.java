package com.iqoption.app.managers;

import com.google.common.collect.ImmutableList;

final /* synthetic */ class g implements Runnable {
    private final c amN;
    private final ImmutableList amP;

    g(c cVar, ImmutableList immutableList) {
        this.amN = cVar;
        this.amP = immutableList;
    }

    public void run() {
        this.amN.h(this.amP);
    }
}
