package com.iqoption.welcomeonboarding.b;

import android.text.TextWatcher;

final /* synthetic */ class e implements Runnable {
    private final TextWatcher dLR;
    private final c dLX;

    e(c cVar, TextWatcher textWatcher) {
        this.dLX = cVar;
        this.dLR = textWatcher;
    }

    public void run() {
        this.dLX.c(this.dLR);
    }
}
