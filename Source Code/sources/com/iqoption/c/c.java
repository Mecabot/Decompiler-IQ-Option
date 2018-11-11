package com.iqoption.c;

import com.google.common.util.concurrent.g;
import com.google.common.util.concurrent.s;
import com.iqoption.dto.Event.Builder;
import com.iqoption.microservice.authorization.a.b;

final /* synthetic */ class c implements g {
    private final a aqZ;
    private final Builder ara;
    private final String arb;
    private final String arc;
    private final boolean ard;
    private final String je;

    c(a aVar, Builder builder, String str, String str2, String str3, boolean z) {
        this.aqZ = aVar;
        this.ara = builder;
        this.je = str;
        this.arb = str2;
        this.arc = str3;
        this.ard = z;
    }

    public s aP(Object obj) {
        return this.aqZ.a(this.ara, this.je, this.arb, this.arc, this.ard, (b) obj);
    }
}
