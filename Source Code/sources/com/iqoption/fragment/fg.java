package com.iqoption.fragment;

import com.iqoption.util.p;
import com.iqoption.view.base.BaseHorizontalScrollView.a;

final /* synthetic */ class fg implements a {
    private final p ctz;

    fg(p pVar) {
        this.ctz = pVar;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.ctz.cg(500);
    }
}
