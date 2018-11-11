package com.iqoption.dialog.a;

import android.support.v7.widget.RecyclerView.Adapter;
import com.google.common.collect.ImmutableList;

final /* synthetic */ class ag implements a {
    private final ImmutableList amP;
    private final ab chb;

    ag(ab abVar, ImmutableList immutableList) {
        this.chb = abVar;
        this.amP = immutableList;
    }

    public Adapter aeE() {
        return this.chb.l(this.amP);
    }
}
