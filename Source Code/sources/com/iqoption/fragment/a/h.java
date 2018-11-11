package com.iqoption.fragment.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.app.af;

final /* synthetic */ class h implements OnCheckedChangeListener {
    private final af czM;

    h(af afVar) {
        this.czM = afVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        g.a(this.czM, compoundButton, z);
    }
}
