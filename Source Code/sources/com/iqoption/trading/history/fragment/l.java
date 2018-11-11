package com.iqoption.trading.history.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final /* synthetic */ class l implements OnCheckedChangeListener {
    private final b dtr;

    l(b bVar) {
        this.dtr = bVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.dtr.f(compoundButton, z);
    }
}
