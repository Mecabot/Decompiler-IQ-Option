package com.iqoption.core.microservices.core;

import com.iqoption.core.f;
import com.iqoption.core.microservices.core.a.c;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/core/response/RegistrationCurrenciesResponse;", "it", "", "invoke"})
/* compiled from: CoreRequests.kt */
final class CoreRequests$getRegistrationCurrencies$1 extends Lambda implements b<String, c> {
    public static final CoreRequests$getRegistrationCurrencies$1 aVz = new CoreRequests$getRegistrationCurrencies$1();

    CoreRequests$getRegistrationCurrencies$1() {
        super(1);
    }

    /* renamed from: gE */
    public final c invoke(String str) {
        h.e(str, "it");
        return (c) f.RQ().Dq().fromJson(str, c.class);
    }
}
