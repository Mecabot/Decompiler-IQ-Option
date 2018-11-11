package com.iqoption.core.f;

import com.iqoption.core.connect.bus.b;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020!J\u001d\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\bJ\u001d\u0010(\u001a\u00020!2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\bJ\u000e\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n8F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, aXE = {"Lcom/iqoption/core/manager/TimeManager;", "Lcom/iqoption/core/TimeServer;", "()V", "LOGGING_ENABLED", "", "getLOGGING_ENABLED", "()Z", "setLOGGING_ENABLED", "(Z)V", "MAX_TIME_LAG", "", "TAG", "", "kotlin.jvm.PlatformType", "listeners", "", "Lcom/iqoption/core/manager/TimeManager$OnSyncChangeListener;", "<set-?>", "localSync", "getLocalSync", "()J", "setLocalSync", "(J)V", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "value", "serverSync", "getServerSync", "setServerSync", "systemSync", "getSystemSync", "timestampWithMsReceived", "addListener", "", "l", "init", "logDebug", "msg", "error", "", "logError", "removeListener", "OnSyncChangeListener", "core_release"})
/* compiled from: TimeManager.kt */
public final class e {
    private static final String TAG = "e";
    public static final e aSt = new e();
    private static final long anP = TimeUnit.MINUTES.toMillis(30);
    private static final Set<Object> oE = new LinkedHashSet();
    private static final ReentrantReadWriteLock yV = new ReentrantReadWriteLock();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/core/manager/TimeManager$init$1", "Lcom/iqoption/core/connect/bus/IQBusImpl$TimeListener;", "onUpdate", "", "time", "", "core_release"})
    /* compiled from: TimeManager.kt */
    public static final class a implements com.iqoption.core.connect.bus.b.a {
        a() {
        }
    }

    private e() {
    }

    public final void init() {
        b.aNe.a(new a());
    }
}
