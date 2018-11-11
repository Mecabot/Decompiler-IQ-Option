package com.iqoption.dialog.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import com.iqoption.mobbtech.connect.response.options.e;

final /* synthetic */ class ac implements am {
    private final ImmutableList cgg;
    private final ab chb;
    private final a chc;
    private final e chd;

    ac(ab abVar, a aVar, ImmutableList immutableList, e eVar) {
        this.chb = abVar;
        this.chc = aVar;
        this.cgg = immutableList;
        this.chd = eVar;
    }

    public View d(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.chb.a(this.chc, this.cgg, this.chd, layoutInflater, viewGroup);
    }
}
