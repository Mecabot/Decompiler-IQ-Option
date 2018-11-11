package com.iqoption.gl;

import com.iqoption.mobbtech.connect.response.options.OptionEvents.i;

final /* synthetic */ class z implements Runnable {
    private final i cIV;

    z(i iVar) {
        this.cIV = iVar;
    }

    public void run() {
        i.a(this.cIV);
    }
}
