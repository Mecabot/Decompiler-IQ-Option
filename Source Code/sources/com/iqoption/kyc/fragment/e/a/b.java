package com.iqoption.kyc.fragment.e.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.d.md;

final /* synthetic */ class b implements OnCheckedChangeListener {
    private final a cNf;
    private final md cNg;

    b(a aVar, md mdVar) {
        this.cNf = aVar;
        this.cNg = mdVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.cNf.a(this.cNg, compoundButton, z);
    }
}
