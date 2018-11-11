package com.iqoption.core.connect.bus;

import com.iqoption.core.connect.ws.b;
import com.iqoption.core.connect.ws.c;
import com.iqoption.core.f.f;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "Lcom/iqoption/core/connect/ws/WebSocketDelegate;", "invoke"})
/* compiled from: IQBusImpl.kt */
final class IQBusImpl$ws$2 extends Lambda implements a<b> {
    public static final IQBusImpl$ws$2 aNf = new IQBusImpl$ws$2();

    IQBusImpl$ws$2() {
        super(0);
    }

    /* renamed from: Sc */
    public final b invoke() {
        return f.a(f.aSE, "ws-new-lib", false, 2, null) ? new c() : new com.iqoption.core.connect.ws.a();
    }
}
