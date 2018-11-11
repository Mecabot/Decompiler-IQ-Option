package com.iqoption.fragment.cashbox;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final /* synthetic */ class h implements OnCheckedChangeListener {
    private final f cwQ;

    h(f fVar) {
        this.cwQ = fVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.cwQ.e(compoundButton, z);
    }
}
