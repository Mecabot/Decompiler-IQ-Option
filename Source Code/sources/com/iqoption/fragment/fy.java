package com.iqoption.fragment;

import com.google.common.base.d;
import com.iqoption.app.helpers.a;
import java.util.Map.Entry;

final /* synthetic */ class fy implements d {
    private final a ctL;
    private final q ctP;

    fy(q qVar, a aVar) {
        this.ctP = qVar;
        this.ctL = aVar;
    }

    public Object apply(Object obj) {
        return this.ctP.c(this.ctL, (Entry) obj);
    }
}
