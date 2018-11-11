package com.iqoption.activity;

import android.view.View;
import com.google.common.base.n;
import com.iqoption.fragment.leftmenu.LeftMenuFragment;

final /* synthetic */ class v implements n {
    private final b aeD;
    private final View aeQ;
    private final View aeR;
    private final LeftMenuFragment aeS;

    v(b bVar, View view, View view2, LeftMenuFragment leftMenuFragment) {
        this.aeD = bVar;
        this.aeQ = view;
        this.aeR = view2;
        this.aeS = leftMenuFragment;
    }

    public Object get() {
        return this.aeD.b(this.aeQ, this.aeR, this.aeS);
    }
}
