package com.iqoption.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import com.iqoption.signals.l;

final /* synthetic */ class fj implements Observer {
    private final g ctE;
    private final LiveData ctF;

    fj(g gVar, LiveData liveData) {
        this.ctE = gVar;
        this.ctF = liveData;
    }

    public void onChanged(Object obj) {
        this.ctE.a(this.ctF, (l) obj);
    }
}
