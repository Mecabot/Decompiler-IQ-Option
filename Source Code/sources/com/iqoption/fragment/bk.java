package com.iqoption.fragment;

import android.arch.lifecycle.Observer;

final /* synthetic */ class bk implements Observer {
    private final MenuFragment cpQ;

    bk(MenuFragment menuFragment) {
        this.cpQ = menuFragment;
    }

    public void onChanged(Object obj) {
        this.cpQ.l((Boolean) obj);
    }
}
