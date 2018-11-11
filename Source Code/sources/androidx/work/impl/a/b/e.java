package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.net.ConnectivityManagerCompat;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: NetworkStateTracker */
public class e extends d<androidx.work.impl.a.b> {
    private final ConnectivityManager fT = ((ConnectivityManager) this.mAppContext.getSystemService("connectivity"));
    @RequiresApi(24)
    private b fU;
    private a fV;

    /* compiled from: NetworkStateTracker */
    private class a extends BroadcastReceiver {
        a() {
        }

        /* JADX WARNING: Missing block: B:7:0x002b, code:
            return;
     */
        public void onReceive(android.content.Context r2, android.content.Intent r3) {
            /*
            r1 = this;
            if (r3 == 0) goto L_0x002b;
        L_0x0002:
            r2 = r3.getAction();
            if (r2 != 0) goto L_0x0009;
        L_0x0008:
            goto L_0x002b;
        L_0x0009:
            r2 = r3.getAction();
            r3 = "android.net.conn.CONNECTIVITY_CHANGE";
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x002a;
        L_0x0015:
            r2 = "NetworkStateTracker";
            r3 = "Network broadcast received";
            r0 = 0;
            r0 = new java.lang.Throwable[r0];
            androidx.work.e.b(r2, r3, r0);
            r2 = androidx.work.impl.a.b.e.this;
            r3 = androidx.work.impl.a.b.e.this;
            r3 = r3.cm();
            r2.setState(r3);
        L_0x002a:
            return;
        L_0x002b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.a.b.e.a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    @RequiresApi(24)
    /* compiled from: NetworkStateTracker */
    private class b extends NetworkCallback {
        b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            androidx.work.e.b("NetworkStateTracker", String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            e.this.setState(e.this.cm());
        }

        public void onLost(Network network) {
            androidx.work.e.b("NetworkStateTracker", "Network connection lost", new Throwable[0]);
            e.this.setState(e.this.cm());
        }
    }

    public e(Context context) {
        super(context);
        if (cl()) {
            this.fU = new b();
        } else {
            this.fV = new a();
        }
    }

    /* renamed from: ck */
    public androidx.work.impl.a.b ci() {
        return cm();
    }

    public void startTracking() {
        if (cl()) {
            androidx.work.e.b("NetworkStateTracker", "Registering network callback", new Throwable[0]);
            this.fT.registerDefaultNetworkCallback(this.fU);
            return;
        }
        androidx.work.e.b("NetworkStateTracker", "Registering broadcast receiver", new Throwable[0]);
        this.mAppContext.registerReceiver(this.fV, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void cj() {
        if (cl()) {
            androidx.work.e.b("NetworkStateTracker", "Unregistering network callback", new Throwable[0]);
            this.fT.unregisterNetworkCallback(this.fU);
            return;
        }
        androidx.work.e.b("NetworkStateTracker", "Unregistering broadcast receiver", new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.fV);
    }

    private static boolean cl() {
        return VERSION.SDK_INT >= 24;
    }

    androidx.work.impl.a.b cm() {
        NetworkInfo activeNetworkInfo = this.fT.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean cn = cn();
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.fT);
        if (!(activeNetworkInfo == null || activeNetworkInfo.isRoaming())) {
            z = true;
        }
        return new androidx.work.impl.a.b(z2, cn, isActiveNetworkMetered, z);
    }

    private boolean cn() {
        boolean z = false;
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        NetworkCapabilities networkCapabilities = this.fT.getNetworkCapabilities(this.fT.getActiveNetwork());
        if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
            z = true;
        }
        return z;
    }
}
