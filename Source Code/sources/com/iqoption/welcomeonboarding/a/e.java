package com.iqoption.welcomeonboarding.a;

import android.text.TextWatcher;

final /* synthetic */ class e implements Runnable {
    private final b dLQ;
    private final TextWatcher dLR;

    e(b bVar, TextWatcher textWatcher) {
        this.dLQ = bVar;
        this.dLR = textWatcher;
    }

    public void run() {
        this.dLQ.b(this.dLR);
    }
}
