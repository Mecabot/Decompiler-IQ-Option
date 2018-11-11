package com.iqoption.dialog.c;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final /* synthetic */ class m implements OnCheckedChangeListener {
    private final b ckw;

    m(b bVar) {
        this.ckw = bVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.ckw.a(compoundButton, z);
    }
}
