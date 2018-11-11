package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.signals.c;
import java.util.concurrent.atomic.AtomicLong;

final /* synthetic */ class cx implements Observer {
    private final AtomicLong csa;

    cx(AtomicLong atomicLong) {
        this.csa = atomicLong;
    }

    public void onChanged(Object obj) {
        cr.a(this.csa, (c) obj);
    }
}
