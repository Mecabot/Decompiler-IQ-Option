package com.iqoption.core.f;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import io.reactivex.BackpressureStrategy;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0004H\u0002¨\u0006\n"}, aXE = {"createNetworkFlowable", "Lio/reactivex/Flowable;", "", "networkService", "Landroid/net/ConnectivityManager;", "createNetworkFlowableOreo", "emmitNext", "", "Lio/reactivex/FlowableEmitter;", "isConnected", "core_release"})
/* compiled from: NetworkManager.kt */
public final class c {

    @i(aXC = {1, 1, 11}, aXD = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, aXE = {"com/iqoption/core/manager/NetworkManagerKt$createNetworkFlowable$NetworkReceiver", "Landroid/content/BroadcastReceiver;", "(Landroid/net/ConnectivityManager;)V", "emitter", "Lio/reactivex/FlowableEmitter;", "", "getEmitter", "()Lio/reactivex/FlowableEmitter;", "setEmitter", "(Lio/reactivex/FlowableEmitter;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_release"})
    /* compiled from: NetworkManager.kt */
    public static final class d extends BroadcastReceiver {
        private io.reactivex.f<Boolean> aSo;
        final /* synthetic */ ConnectivityManager aSp;

        public d(ConnectivityManager connectivityManager) {
            this.aSp = connectivityManager;
        }

        public final void b(io.reactivex.f<Boolean> fVar) {
            this.aSo = fVar;
        }

        public void onReceive(Context context, Intent intent) {
            io.reactivex.f fVar = this.aSo;
            if (fVar != null) {
                c.a(fVar, this.aSp);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, aXE = {"com/iqoption/core/manager/NetworkManagerKt$createNetworkFlowableOreo$NetworkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "(Landroid/net/ConnectivityManager;)V", "emitter", "Lio/reactivex/FlowableEmitter;", "", "getEmitter", "()Lio/reactivex/FlowableEmitter;", "setEmitter", "(Lio/reactivex/FlowableEmitter;)V", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "core_release"})
    /* compiled from: NetworkManager.kt */
    public static final class h extends NetworkCallback {
        private io.reactivex.f<Boolean> aSo;
        final /* synthetic */ ConnectivityManager aSp;

        public h(ConnectivityManager connectivityManager) {
            this.aSp = connectivityManager;
        }

        public final void b(io.reactivex.f<Boolean> fVar) {
            this.aSo = fVar;
        }

        public void onAvailable(Network network) {
            io.reactivex.f fVar = this.aSo;
            if (fVar != null) {
                c.a(fVar, this.aSp);
            }
        }

        public void onLost(Network network) {
            io.reactivex.f fVar = this.aSo;
            if (fVar != null) {
                c.a(fVar, this.aSp);
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "emitter", "Lio/reactivex/FlowableEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: NetworkManager.kt */
    static final class a<T> implements io.reactivex.g<T> {
        final /* synthetic */ d aSn;

        a(d dVar) {
            this.aSn = dVar;
        }

        public final void a(io.reactivex.f<Boolean> fVar) {
            kotlin.jvm.internal.h.e(fVar, "emitter");
            this.aSn.b(fVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lorg/reactivestreams/Subscription;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: NetworkManager.kt */
    static final class b<T> implements io.reactivex.c.e<org.a.d> {
        final /* synthetic */ d aSn;

        b(d dVar) {
            this.aSn = dVar;
        }

        public final void accept(org.a.d dVar) {
            com.iqoption.core.f.RR().registerReceiver(this.aSn, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: NetworkManager.kt */
    static final class c implements io.reactivex.c.a {
        final /* synthetic */ d aSn;

        c(d dVar) {
            this.aSn = dVar;
        }

        public final void run() {
            com.iqoption.core.f.RR().unregisterReceiver(this.aSn);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "emitter", "Lio/reactivex/FlowableEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: NetworkManager.kt */
    static final class e<T> implements io.reactivex.g<T> {
        final /* synthetic */ h aSq;

        e(h hVar) {
            this.aSq = hVar;
        }

        public final void a(io.reactivex.f<Boolean> fVar) {
            kotlin.jvm.internal.h.e(fVar, "emitter");
            this.aSq.b(fVar);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Lorg/reactivestreams/Subscription;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: NetworkManager.kt */
    static final class f<T> implements io.reactivex.c.e<org.a.d> {
        final /* synthetic */ ConnectivityManager aSp;
        final /* synthetic */ h aSq;

        f(ConnectivityManager connectivityManager, h hVar) {
            this.aSp = connectivityManager;
            this.aSq = hVar;
        }

        public final void accept(org.a.d dVar) {
            this.aSp.registerDefaultNetworkCallback(this.aSq, com.iqoption.core.h.i.Yn().getHandler());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "run"})
    /* compiled from: NetworkManager.kt */
    static final class g implements io.reactivex.c.a {
        final /* synthetic */ ConnectivityManager aSp;
        final /* synthetic */ h aSq;

        g(ConnectivityManager connectivityManager, h hVar) {
            this.aSp = connectivityManager;
            this.aSq = hVar;
        }

        public final void run() {
            this.aSp.unregisterNetworkCallback(this.aSq);
        }
    }

    private static final boolean a(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private static final void a(io.reactivex.f<Boolean> fVar, ConnectivityManager connectivityManager) {
        if (!fVar.isCancelled()) {
            fVar.e(Boolean.valueOf(a(connectivityManager)));
        }
    }

    @TargetApi(26)
    private static final io.reactivex.e<Boolean> b(ConnectivityManager connectivityManager) {
        h hVar = new h(connectivityManager);
        io.reactivex.e<Boolean> d = io.reactivex.e.a((io.reactivex.g) new e(hVar), BackpressureStrategy.LATEST).b((io.reactivex.c.e) new f(connectivityManager, hVar)).d((io.reactivex.c.a) new g(connectivityManager, hVar));
        kotlin.jvm.internal.h.d(d, "Flowable\n            .cr…k(callback)\n            }");
        return d;
    }

    private static final io.reactivex.e<Boolean> c(ConnectivityManager connectivityManager) {
        d dVar = new d(connectivityManager);
        io.reactivex.e<Boolean> d = io.reactivex.e.a((io.reactivex.g) new a(dVar), BackpressureStrategy.LATEST).b((io.reactivex.c.e) new b(dVar)).d((io.reactivex.c.a) new c(dVar));
        kotlin.jvm.internal.h.d(d, "Flowable\n            .cr…r(receiver)\n            }");
        return d;
    }
}
