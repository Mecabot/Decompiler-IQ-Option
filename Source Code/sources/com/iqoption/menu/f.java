package com.iqoption.menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final /* synthetic */ class f implements OnItemClickListener {
    private final SupportView cPh;

    f(SupportView supportView) {
        this.cPh = supportView;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.cPh.a(adapterView, view, i, j);
    }
}
