package com.iqoption.mobbtech.connect.request.a.a;

import com.google.common.base.n;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.y;
import com.iqoption.core.d.a;
import java.util.concurrent.TimeUnit;

final /* synthetic */ class e implements n {
    private final long bVB;
    private final y cVj;

    e(y yVar, long j) {
        this.cVj = yVar;
        this.bVB = j;
    }

    public Object get() {
        return o.a(this.cVj, this.bVB, TimeUnit.MILLISECONDS, a.aSd);
    }
}
