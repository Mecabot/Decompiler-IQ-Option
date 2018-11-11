package com.iqoption.dialog.c;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final /* synthetic */ class k implements OnCheckedChangeListener {
    private final b ckw;

    k(b bVar) {
        this.ckw = bVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.ckw.b(compoundButton, z);
    }
}
