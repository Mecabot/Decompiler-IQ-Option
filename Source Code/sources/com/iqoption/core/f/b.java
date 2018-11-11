package com.iqoption.core.f;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.iqoption.core.f;
import io.reactivex.e;
import java.util.concurrent.TimeUnit;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\r¨\u0006\u0010"}, aXE = {"Lcom/iqoption/core/manager/NetworkManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "isConnected", "", "()Z", "isConnectedProcessor", "Lcom/iqoption/core/rx/IQBehaviorProcessor;", "isConnectedStream", "Lio/reactivex/Flowable;", "()Lio/reactivex/Flowable;", "init", "", "core_release"})
/* compiled from: NetworkManager.kt */
public final class b {
    private static final String TAG = "b";
    private static final com.iqoption.core.h.a<Boolean> aSj = com.iqoption.core.h.a.baf.Yd();
    private static final e<Boolean> aSk = aSj;
    public static final b aSl = new b();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, aXE = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"})
    /* compiled from: NetworkManager.kt */
    static final class a<T> implements io.reactivex.c.e<Boolean> {
        public static final a aSm = new a();

        a() {
        }

        /* renamed from: j */
        public final void accept(Boolean bool) {
            if ((h.E(bool, Boolean.valueOf(b.aSl.isConnected())) ^ 1) != 0) {
                String a = b.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Connection to network changed: ");
                h.d(bool, "it");
                stringBuilder.append(bool.booleanValue() ? "connected" : "disconnected");
                com.iqoption.core.i.d(a, stringBuilder.toString());
                b.aSj.e(bool);
            }
        }
    }

    private b() {
    }

    public final boolean isConnected() {
        Boolean bool = (Boolean) aSj.getValue();
        return bool != null ? bool.booleanValue() : true;
    }

    public final void init() {
        e d;
        ConnectivityManager be = com.iqoption.core.ext.a.be(f.RR());
        NetworkInfo activeNetworkInfo = be.getActiveNetworkInfo();
        com.iqoption.core.h.a aVar = aSj;
        Object obj = null;
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        aVar.e(Boolean.valueOf(z));
        if (VERSION.SDK_INT >= 26) {
            obj = 1;
        }
        if (obj != null) {
            d = c.b(be);
        } else {
            d = c.c(be);
        }
        d.d(com.iqoption.core.h.i.Yr()).f(500, TimeUnit.MILLISECONDS).c((io.reactivex.c.e) a.aSm);
    }
}
