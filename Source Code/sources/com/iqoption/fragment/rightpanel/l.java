package com.iqoption.fragment.rightpanel;

import android.view.View;
import kotlin.jvm.a.a;

final /* synthetic */ class l implements a {
    private final View cFO;

    private l(View view) {
        this.cFO = view;
    }

    static a bk(View view) {
        return new l(view);
    }

    public Object invoke() {
        return Boolean.valueOf(this.cFO.isLaidOut());
    }
}
