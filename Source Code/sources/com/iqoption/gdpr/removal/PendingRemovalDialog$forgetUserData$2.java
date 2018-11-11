package com.iqoption.gdpr.removal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lcom/iqoption/core/microservices/busapi/response/ForgetUserData;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: PendingRemovalDialog.kt */
final class PendingRemovalDialog$forgetUserData$2 extends Lambda implements a<com.iqoption.core.microservices.busapi.response.a> {
    final /* synthetic */ a this$0;

    PendingRemovalDialog$forgetUserData$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aot */
    public final com.iqoption.core.microservices.busapi.response.a invoke() {
        return (com.iqoption.core.microservices.busapi.response.a) com.iqoption.core.ext.a.o(this.this$0).getParcelable("ARG_FORGET_USER_DATA");
    }
}
