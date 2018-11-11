package com.iqoption.fragment;

import java.lang.ref.WeakReference;

final /* synthetic */ class dl implements Runnable {
    private final WeakReference aeE;

    dl(WeakReference weakReference) {
        this.aeE = weakReference;
    }

    public void run() {
        cr.d(this.aeE);
    }
}
