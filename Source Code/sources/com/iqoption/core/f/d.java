package com.iqoption.core.f;

import com.iqoption.core.f;
import com.iqoption.core.h.a;
import io.reactivex.c.e;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, aXE = {"Lcom/iqoption/core/manager/SocketManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "isConnected", "Lio/reactivex/Flowable;", "", "()Lio/reactivex/Flowable;", "isConnectedImmediate", "()Z", "isConnectedProcessor", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "connect", "Lio/reactivex/Completable;", "disconnect", "core_release"})
/* compiled from: SocketManager.kt */
public final class d {
    private static final String TAG = "d";
    private static final a<Boolean> aSj = a.baf.bi(Boolean.valueOf(false));
    public static final d aSr = new d();

    static {
        f.RS().RY().d(com.iqoption.core.h.i.Yo()).c(com.iqoption.core.h.i.Yo()).c((e) AnonymousClass1.aSs);
    }

    private d() {
    }

    public final io.reactivex.e<Boolean> Ug() {
        return aSj;
    }

    public final boolean Uh() {
        Boolean bool = (Boolean) aSj.getValue();
        return bool != null ? bool.booleanValue() : false;
    }
}
