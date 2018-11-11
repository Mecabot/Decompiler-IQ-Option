package com.iqoption.chat.service;

import com.iqoption.mobbtech.connect.RequestManager;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import okhttp3.OkHttpClient;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "Lokhttp3/OkHttpClient;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: SendFileMessageService.kt */
final class SendFileMessageService$Companion$CLIENT$2 extends Lambda implements a<OkHttpClient> {
    public static final SendFileMessageService$Companion$CLIENT$2 aJX = new SendFileMessageService$Companion$CLIENT$2();

    SendFileMessageService$Companion$CLIENT$2() {
        super(0);
    }

    /* renamed from: QA */
    public final OkHttpClient invoke() {
        RequestManager atO = RequestManager.atO();
        h.d(atO, "RequestManager.getInstance()");
        return atO.atP().build();
    }
}
