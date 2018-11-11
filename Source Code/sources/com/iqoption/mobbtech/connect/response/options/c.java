package com.iqoption.mobbtech.connect.response.options;

import com.google.common.collect.ImmutableList;

final /* synthetic */ class c implements Runnable {
    private final ImmutableList amP;
    private final b cWz;

    c(b bVar, ImmutableList immutableList) {
        this.cWz = bVar;
        this.amP = immutableList;
    }

    public void run() {
        this.cWz.s(this.amP);
    }
}
