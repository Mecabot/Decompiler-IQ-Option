package com.iqoption.c;

import com.google.common.base.n;
import com.iqoption.app.IQApp;
import com.iqoption.microservice.authorization.a;

final /* synthetic */ class b implements n {
    private final String afd;
    private final String alY;
    private final boolean aqY;
    private final String je;

    b(String str, String str2, String str3, boolean z) {
        this.alY = str;
        this.afd = str2;
        this.je = str3;
        this.aqY = z;
    }

    public Object get() {
        return a.d(IQApp.Dk(), this.alY, this.afd, this.je, this.aqY);
    }
}
