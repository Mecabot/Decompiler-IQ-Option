package com.iqoption.fragment;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final /* synthetic */ class aw implements OnCheckedChangeListener {
    private final at cpi;

    aw(at atVar) {
        this.cpi = atVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.cpi.d(compoundButton, z);
    }
}
