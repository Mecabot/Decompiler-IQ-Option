package com.iqoption.dialog.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iqoption.d.hz;

final /* synthetic */ class f implements an {
    private final LayoutInflater cgk;
    private final c cgl;

    f(LayoutInflater layoutInflater, c cVar) {
        this.cgk = layoutInflater;
        this.cgl = cVar;
    }

    public ViewHolder z(ViewGroup viewGroup, int i) {
        return new a(hz.t(this.cgk, viewGroup, false), this.cgl);
    }
}
