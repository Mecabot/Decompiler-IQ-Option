package com.iqoption.gl;

import com.google.common.collect.ImmutableList;
import com.iqoption.mobbtech.connect.response.options.OptionEvents.h;

final /* synthetic */ class y implements Runnable {
    private final ImmutableList amP;
    private final h cIU;

    y(h hVar, ImmutableList immutableList) {
        this.cIU = hVar;
        this.amP = immutableList;
    }

    public void run() {
        i.a(this.cIU, this.amP);
    }
}
