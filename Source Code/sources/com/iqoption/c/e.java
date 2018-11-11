package com.iqoption.c;

import com.google.common.base.n;
import com.iqoption.microservice.authorization.a;

final /* synthetic */ class e implements n {
    private final String afd;
    private final long alZ;

    e(long j, String str) {
        this.alZ = j;
        this.afd = str;
    }

    public Object get() {
        return a.g(this.alZ, this.afd);
    }
}
