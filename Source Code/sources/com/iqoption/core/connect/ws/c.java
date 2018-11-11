package com.iqoption.core.connect.ws;

import com.neovisionaries.ws.client.ai;
import java.util.concurrent.TimeUnit;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/connect/ws/ZipWebSocket;", "Lcom/iqoption/core/connect/ws/WebSocketDelegate;", "()V", "factory", "Lcom/neovisionaries/ws/client/WebSocketFactory;", "webSocket", "Lcom/neovisionaries/ws/client/WebSocket;", "close", "", "open", "Lio/reactivex/Flowable;", "", "url", "sendMessage", "message", "Companion", "core_release"})
/* compiled from: ZipWebSocket.kt */
public final class c extends b {
    private static final String TAG = "c";
    public static final a aOn = new a();
    private final ai aOm;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u001e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/connect/ws/ZipWebSocket$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "TAG$annotations", "isLoggingEnabled", "", "()Z", "setLoggingEnabled", "(Z)V", "logDebug", "", "msg", "error", "", "core_release"})
    /* compiled from: ZipWebSocket.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c() {
        ai aiVar = new ai();
        aiVar.ij((int) TimeUnit.SECONDS.toMillis(15));
        aiVar.fR(false);
        this.aOm = aiVar;
    }
}
