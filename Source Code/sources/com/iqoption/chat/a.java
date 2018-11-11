package com.iqoption.chat;

import com.google.common.b.e;
import com.iqoption.microservice.chat.d;
import com.iqoption.microservice.chat.d.b;
import com.iqoption.microservice.chat.d.f;
import com.iqoption.service.e.g;
import com.iqoption.system.a.h;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, aXE = {"Lcom/iqoption/chat/ChatManager;", "", "()V", "initialize", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: ChatManager.kt */
public final class a {
    public static final a aCG = new a();

    public final void initialize() {
    }

    static {
        new h() {
            @e
            public final void onSocketOpen(g gVar) {
                kotlin.jvm.internal.h.e(gVar, "event");
                d.cPG.a((b) com.iqoption.chat.repository.b.aJu);
                d.cPG.a((f) com.iqoption.chat.repository.f.aJG);
            }
        }.register();
    }

    private a() {
    }
}
