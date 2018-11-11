package com.iqoption.fragment;

import com.google.common.base.d;
import com.iqoption.app.helpers.a;
import java.util.Map.Entry;

final /* synthetic */ class fu implements d {
    private final a ctL;
    private final m ctM;

    fu(m mVar, a aVar) {
        this.ctM = mVar;
        this.ctL = aVar;
    }

    public Object apply(Object obj) {
        return this.ctM.b(this.ctL, (Entry) obj);
    }
}
