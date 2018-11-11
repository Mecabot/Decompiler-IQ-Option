package com.iqoption.fragment;

import android.arch.lifecycle.Observer;
import com.iqoption.core.microservices.configuration.a.c;

final /* synthetic */ class k implements Observer {
    private final a cnA;

    k(a aVar) {
        this.cnA = aVar;
    }

    public void onChanged(Object obj) {
        this.cnA.b((c) obj);
    }
}
