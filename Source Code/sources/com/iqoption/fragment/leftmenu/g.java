package com.iqoption.fragment.leftmenu;

import com.iqoption.core.i;
import io.reactivex.c.e;

final /* synthetic */ class g implements e {
    static final e cpR = new g();

    private g() {
    }

    public void accept(Object obj) {
        i.e(LeftMenuFragment.TAG, "protrader status error", (Throwable) obj);
    }
}
