package com.iqoption.core.connect.bus;

import com.iqoption.core.connect.g;
import com.iqoption.core.e.c;
import io.reactivex.e;
import io.reactivex.n;
import io.reactivex.processors.PublishProcessor;
import java.util.concurrent.Executors;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002noB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0004H\u0016J\b\u0010U\u001a\u00020SH\u0016J\u0010\u0010V\u001a\u00020W2\u0006\u0010T\u001a\u00020\u0004H\u0002J\u0014\u0010X\u001a\u00020W2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010$H\u0002J\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020-0;2\u0006\u0010[\u001a\u00020\u0004J\u001d\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_H\bJ\u001d\u0010`\u001a\u00020W2\u0006\u0010]\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_H\bJ:\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hd0c0b\"\u0004\b\u0000\u0010d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002Hd0f2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u0002Hd0hJ\u000e\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020lJ\u000e\u0010m\u001a\u0004\u0018\u00010\u0004*\u00020iH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u000e\u0010\u0018\u001a\u00020\u0019XT¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u001c0\u001c0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R+\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$8B@BX\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010,\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010-0-0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020509X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u0002050;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020C8VX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020C09X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020C0;X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010=R\u001c\u0010I\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R\u001b\u0010L\u001a\u00020M8@X\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bN\u0010O¨\u0006p"}, aXE = {"Lcom/iqoption/core/connect/bus/IQBusImpl;", "Lcom/iqoption/core/connect/IQBus;", "()V", "EVENT_HEARTBEAT", "", "EVENT_PROFILE", "EVENT_TIME_SYNC", "KEY_MSG", "KEY_NAME", "KEY_REQUEST_ID", "KEY_STATUS", "LOGGING_ENABLED", "", "getLOGGING_ENABLED", "()Z", "setLOGGING_ENABLED", "(Z)V", "MESSAGE_SEND", "MESSAGE_SUBSCRIBE", "MESSAGE_UNSUBSCRIBE", "PATH_WS", "TAG", "kotlin.jvm.PlatformType", "TAG$annotations", "TIMEOUT", "", "commandProcessor", "Lio/reactivex/processors/FlowableProcessor;", "Lcom/iqoption/core/connect/bus/CommandMessage;", "getCommandProcessor$core_release", "()Lio/reactivex/processors/FlowableProcessor;", "connection", "Lio/reactivex/disposables/CompositeDisposable;", "disconnectLock", "", "<set-?>", "Lcom/iqoption/core/connect/bus/IQBusError;", "disconnectReason", "getDisconnectReason", "()Lcom/iqoption/core/connect/bus/IQBusError;", "setDisconnectReason", "(Lcom/iqoption/core/connect/bus/IQBusError;)V", "disconnectReason$delegate", "Lkotlin/properties/ReadWriteProperty;", "eventProcessor", "Lcom/iqoption/core/connect/bus/IQBusMessage;", "heartbeatListener", "Lcom/iqoption/core/connect/bus/IQBusImpl$TimeListener;", "getHeartbeatListener", "()Lcom/iqoption/core/connect/bus/IQBusImpl$TimeListener;", "setHeartbeatListener", "(Lcom/iqoption/core/connect/bus/IQBusImpl$TimeListener;)V", "profile", "Lcom/iqoption/core/microservices/auth/response/Profile;", "getProfile", "()Lcom/iqoption/core/microservices/auth/response/Profile;", "profileProcessor", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "profileStream", "Lio/reactivex/Flowable;", "getProfileStream", "()Lio/reactivex/Flowable;", "scheduler", "Lio/reactivex/Scheduler;", "selfDisconnect", "Lio/reactivex/disposables/SerialDisposable;", "state", "Lcom/iqoption/core/connect/bus/IQBusState;", "getState", "()Lcom/iqoption/core/connect/bus/IQBusState;", "stateProcessor", "stateStream", "getStateStream", "timeSyncListener", "getTimeSyncListener", "setTimeSyncListener", "ws", "Lcom/iqoption/core/connect/ws/WebSocketDelegate;", "getWs$core_release", "()Lcom/iqoption/core/connect/ws/WebSocketDelegate;", "ws$delegate", "Lkotlin/Lazy;", "connect", "Lio/reactivex/Completable;", "ssid", "disconnect", "doConnect", "", "doDisconnect", "reason", "getEventStream", "name", "logDebug", "msg", "error", "", "logError", "sendCommand", "Lio/reactivex/Single;", "Lcom/iqoption/core/connect/bus/CommandResult;", "T", "command", "Lcom/iqoption/core/connect/bus/Command;", "parser", "Lkotlin/Function1;", "Lcom/google/gson/stream/JsonReader;", "sendSubscription", "subscription", "Lcom/iqoption/core/connect/bus/Subscription;", "readName", "Parser", "TimeListener", "core_release"})
/* compiled from: IQBusImpl.kt */
public final class b implements g {
    private static final String TAG = "b";
    private static final d aMS = g.f(IQBusImpl$ws$2.aNf);
    private static final io.reactivex.processors.a<Object> aMT = PublishProcessor.aXq().aXp();
    private static final io.reactivex.processors.a<Object> aMU = PublishProcessor.aXq().aXp();
    private static final io.reactivex.disposables.a aMV = new io.reactivex.disposables.a();
    private static final io.reactivex.disposables.d aMW = new io.reactivex.disposables.d();
    private static final Object aMX = new Object();
    private static final com.iqoption.core.h.a<IQBusState> aMY = com.iqoption.core.h.a.baf.bi(IQBusState.DISCONNECTED);
    private static final e<IQBusState> aMZ = aMY;
    private static final kotlin.e.d aNa = c.bg(c.aNg);
    private static final com.iqoption.core.h.a<com.iqoption.core.microservices.a.a.a> aNb = com.iqoption.core.h.a.baf.bi(com.iqoption.core.microservices.a.a.a.aSO.Uo());
    private static final e<com.iqoption.core.microservices.a.a.a> aNc = aNb;
    private static a aNd;
    public static final b aNe = new b();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "ws", "getWs$core_release()Lcom/iqoption/core/connect/ws/WebSocketDelegate;")), kotlin.jvm.internal.j.a(new MutablePropertyReference1Impl(kotlin.jvm.internal.j.F(b.class), "disconnectReason", "getDisconnectReason()Lcom/iqoption/core/connect/bus/IQBusError;"))};
    private static final n scheduler = io.reactivex.e.a.a(Executors.newSingleThreadExecutor());

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, aXE = {"Lcom/iqoption/core/connect/bus/IQBusImpl$TimeListener;", "", "onUpdate", "", "time", "", "core_release"})
    /* compiled from: IQBusImpl.kt */
    public interface a {
    }

    private b() {
    }

    public e<IQBusState> RY() {
        return aMZ;
    }

    public IQBusState RZ() {
        IQBusState iQBusState = (IQBusState) aMY.getValue();
        return iQBusState != null ? iQBusState : IQBusState.DISCONNECTED;
    }

    public final void a(a aVar) {
        aNd = aVar;
    }
}
