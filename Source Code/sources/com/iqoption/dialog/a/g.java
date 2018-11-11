package com.iqoption.dialog.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.ib;

final /* synthetic */ class g implements an {
    private final LayoutInflater cgk;
    private final c cgl;

    g(LayoutInflater layoutInflater, c cVar) {
        this.cgk = layoutInflater;
        this.cgl = cVar;
    }

    public ViewHolder z(ViewGroup viewGroup, int i) {
        return new b(ib.u(this.cgk, viewGroup, false), this.cgl);
    }
}
