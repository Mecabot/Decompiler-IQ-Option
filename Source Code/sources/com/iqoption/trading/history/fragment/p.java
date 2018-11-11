package com.iqoption.trading.history.fragment;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

final /* synthetic */ class p implements OnCheckedChangeListener {
    private final m dtx;

    p(m mVar) {
        this.dtx = mVar;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.dtx.a(radioGroup, i);
    }
}
