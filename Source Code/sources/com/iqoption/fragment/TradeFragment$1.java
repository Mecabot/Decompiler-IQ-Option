package com.iqoption.fragment;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.iqoption.charttools.f;
import com.iqoption.core.h.i;

class TradeFragment$1 implements LifecycleObserver {
    final /* synthetic */ cr csc;

    TradeFragment$1(cr crVar) {
        this.csc = crVar;
    }

    @OnLifecycleEvent(R = Event.ON_STOP)
    public void saveIndicators() {
        f.arM.JY().b(i.Yo()).aVS();
    }
}
