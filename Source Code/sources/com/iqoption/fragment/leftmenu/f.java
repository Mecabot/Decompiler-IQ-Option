package com.iqoption.fragment.leftmenu;

import com.google.common.base.Optional;
import io.reactivex.c.e;

final /* synthetic */ class f implements e {
    private final LeftMenuFragment cCB;

    f(LeftMenuFragment leftMenuFragment) {
        this.cCB = leftMenuFragment;
    }

    public void accept(Object obj) {
        this.cCB.b((Optional) obj);
    }
}
