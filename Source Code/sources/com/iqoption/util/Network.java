package com.iqoption.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.common.util.concurrent.o;
import com.google.common.util.concurrent.s;
import com.google.common.util.concurrent.y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0003J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, aXE = {"Lcom/iqoption/util/Network;", "", "()V", "connectivityManager", "Landroid/net/ConnectivityManager;", "futures", "Ljava/util/ArrayList;", "Lcom/google/common/util/concurrent/SettableFuture;", "", "networkState", "Lcom/iqoption/util/Network$NetworkState;", "checkNetwork", "", "checkNetworkLollipop", "getStateForNetwork", "network", "Landroid/net/Network;", "hasNetwork", "initialize", "context", "Landroid/content/Context;", "onNetworkStateChanged", "waitForOnline", "Lcom/google/common/util/concurrent/ListenableFuture;", "NetworkState", "IqOption-5.5.1_optionXRelease"})
/* compiled from: Network.kt */
public final class Network {
    private static final ArrayList<y<Boolean>> dwm = new ArrayList();
    private static NetworkState dwn;
    private static ConnectivityManager dwo;
    public static final Network dwp = new Network();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/util/Network$NetworkState;", "", "(Ljava/lang/String;I)V", "NONE", "WIFI", "CELLULAR", "ROAMING", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Network.kt */
    private enum NetworkState {
        NONE,
        WIFI,
        CELLULAR,
        ROAMING
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, aXE = {"com/iqoption/util/Network$initialize$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: Network.kt */
    public static final class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            h.e(context, "context");
            h.e(intent, "intent");
            Network.dwp.aGs();
        }
    }

    private Network() {
    }

    public final void initialize(Context context) {
        h.e(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        dwo = (ConnectivityManager) systemService;
        context.registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final s<Boolean> aGq() {
        if (aGr()) {
            s<Boolean> aR = o.aR(Boolean.valueOf(true));
            h.d(aR, "Futures.immediateFuture(true)");
            return aR;
        }
        y wb = y.wb();
        dwm.add(wb);
        aGs();
        h.d(wb, "future");
        return wb;
    }

    public final synchronized boolean aGr() {
        return dwn != NetworkState.NONE;
    }

    private final void aGs() {
        NetworkState networkState;
        if (VERSION.SDK_INT >= 21) {
            try {
                aGu();
                return;
            } catch (NullPointerException e) {
                Log.e(Network.class.getSimpleName(), e.getMessage(), e);
            }
        }
        ConnectivityManager connectivityManager = dwo;
        if (connectivityManager == null) {
            h.lS("connectivityManager");
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        Object obj = 1;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            networkState = NetworkState.NONE;
        } else if (activeNetworkInfo.getType() == 1) {
            networkState = NetworkState.WIFI;
        } else if (activeNetworkInfo.isRoaming()) {
            networkState = NetworkState.ROAMING;
        } else {
            networkState = NetworkState.CELLULAR;
        }
        synchronized (this) {
            if (dwn != networkState) {
                dwn = networkState;
            } else {
                obj = null;
            }
            l lVar = l.etX;
        }
        if (obj != null) {
            aGt();
        }
    }

    private final void aGt() {
        if (aGr()) {
            Iterator it = dwm.iterator();
            while (it.hasNext()) {
                ((y) it.next()).P(Boolean.valueOf(true));
                it.remove();
            }
        }
    }

    @TargetApi(21)
    private final boolean aGu() {
        NetworkState networkState = NetworkState.NONE;
        ConnectivityManager connectivityManager = dwo;
        if (connectivityManager == null) {
            h.lS("connectivityManager");
        }
        android.net.Network[] allNetworks = connectivityManager.getAllNetworks();
        Object obj = null;
        if (allNetworks != null) {
            NetworkState networkState2 = networkState;
            for (android.net.Network network : allNetworks) {
                if (network != null) {
                    ConnectivityManager connectivityManager2 = dwo;
                    if (connectivityManager2 == null) {
                        h.lS("connectivityManager");
                    }
                    NetworkInfo networkInfo = connectivityManager2.getNetworkInfo(network);
                    if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                        networkState2 = a(network);
                    }
                }
            }
            networkState = networkState2;
        }
        synchronized (this) {
            if (dwn != networkState) {
                dwn = networkState;
                obj = 1;
            }
            l lVar = l.etX;
        }
        if (obj != null) {
            aGt();
        }
        return aGr();
    }

    @TargetApi(21)
    private final NetworkState a(android.net.Network network) {
        ConnectivityManager connectivityManager = dwo;
        if (connectivityManager == null) {
            h.lS("connectivityManager");
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return NetworkState.NONE;
        }
        if (networkInfo.getType() == 1) {
            return NetworkState.WIFI;
        }
        if (networkInfo.isRoaming()) {
            return NetworkState.ROAMING;
        }
        return NetworkState.CELLULAR;
    }
}
