package com.iqoption.fragment;

import com.google.common.base.d;
import com.iqoption.app.helpers.a;
import java.util.Map.Entry;

final /* synthetic */ class fq implements d {
    private final k ctK;
    private final a ctL;

    fq(k kVar, a aVar) {
        this.ctK = kVar;
        this.ctL = aVar;
    }

    public Object apply(Object obj) {
        return this.ctK.a(this.ctL, (Entry) obj);
    }
}
