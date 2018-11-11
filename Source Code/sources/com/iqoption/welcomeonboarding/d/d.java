package com.iqoption.welcomeonboarding.d;

import android.text.TextWatcher;

final /* synthetic */ class d implements Runnable {
    private final TextWatcher dLR;
    private final b dNM;

    d(b bVar, TextWatcher textWatcher) {
        this.dNM = bVar;
        this.dLR = textWatcher;
    }

    public void run() {
        this.dNM.d(this.dLR);
    }
}
