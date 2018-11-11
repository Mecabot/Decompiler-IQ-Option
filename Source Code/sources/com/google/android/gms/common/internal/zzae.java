package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzae implements Callback {
    private final Handler mHandler;
    private final Object mLock = new Object();
    private final zzaf zzggl;
    private final ArrayList<ConnectionCallbacks> zzggm = new ArrayList();
    private ArrayList<ConnectionCallbacks> zzggn = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> zzggo = new ArrayList();
    private volatile boolean zzggp = false;
    private final AtomicInteger zzggq = new AtomicInteger(0);
    private boolean zzggr = false;

    public zzae(Looper looper, zzaf zzaf) {
        this.zzggl = zzaf;
        this.mHandler = new Handler(looper, this);
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.mLock) {
                if (this.zzggp && this.zzggl.isConnected() && this.zzggm.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzggl.zzagp());
                }
            }
            return true;
        }
        int i = message.what;
        StringBuilder stringBuilder = new StringBuilder(45);
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(i);
        Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
        return false;
    }

    public final boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzbq.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            contains = this.zzggm.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzbq.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            contains = this.zzggo.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public final void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzbq.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            if (this.zzggm.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 62);
                stringBuilder.append("registerConnectionCallbacks(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" is already registered");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else {
                this.zzggm.add(connectionCallbacks);
            }
        }
        if (this.zzggl.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (this.zzggo.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 67);
                stringBuilder.append("registerConnectionFailedListener(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" is already registered");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else {
                this.zzggo.add(onConnectionFailedListener);
            }
        }
    }

    public final void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzbq.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            if (!this.zzggm.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 52);
                stringBuilder.append("unregisterConnectionCallbacks(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" not found");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else if (this.zzggr) {
                this.zzggn.add(connectionCallbacks);
            }
        }
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzbq.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (!this.zzggo.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 57);
                stringBuilder.append("unregisterConnectionFailedListener(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" not found");
                Log.w("GmsClientEvents", stringBuilder.toString());
            }
        }
    }

    public final void zzams() {
        this.zzggp = false;
        this.zzggq.incrementAndGet();
    }

    public final void zzamt() {
        this.zzggp = true;
    }

    public final void zzcf(int i) {
        zzbq.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            this.zzggr = true;
            ArrayList arrayList = new ArrayList(this.zzggm);
            int i2 = this.zzggq.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!this.zzggp || this.zzggq.get() != i2) {
                    break;
                } else if (this.zzggm.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzggn.clear();
            this.zzggr = false;
        }
    }

    /* JADX WARNING: Missing block: B:17:0x0055, code:
            return;
     */
    public final void zzk(com.google.android.gms.common.ConnectionResult r8) {
        /*
        r7 = this;
        r0 = android.os.Looper.myLooper();
        r1 = r7.mHandler;
        r1 = r1.getLooper();
        r2 = 0;
        r3 = 1;
        if (r0 != r1) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r1 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.zzbq.zza(r0, r1);
        r0 = r7.mHandler;
        r0.removeMessages(r3);
        r0 = r7.mLock;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0058 }
        r3 = r7.zzggo;	 Catch:{ all -> 0x0058 }
        r1.<init>(r3);	 Catch:{ all -> 0x0058 }
        r3 = r7.zzggq;	 Catch:{ all -> 0x0058 }
        r3 = r3.get();	 Catch:{ all -> 0x0058 }
        r1 = (java.util.ArrayList) r1;	 Catch:{ all -> 0x0058 }
        r4 = r1.size();	 Catch:{ all -> 0x0058 }
    L_0x0031:
        if (r2 >= r4) goto L_0x0056;
    L_0x0033:
        r5 = r1.get(r2);	 Catch:{ all -> 0x0058 }
        r2 = r2 + 1;
        r5 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r5;	 Catch:{ all -> 0x0058 }
        r6 = r7.zzggp;	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x0054;
    L_0x003f:
        r6 = r7.zzggq;	 Catch:{ all -> 0x0058 }
        r6 = r6.get();	 Catch:{ all -> 0x0058 }
        if (r6 == r3) goto L_0x0048;
    L_0x0047:
        goto L_0x0054;
    L_0x0048:
        r6 = r7.zzggo;	 Catch:{ all -> 0x0058 }
        r6 = r6.contains(r5);	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x0031;
    L_0x0050:
        r5.onConnectionFailed(r8);	 Catch:{ all -> 0x0058 }
        goto L_0x0031;
    L_0x0054:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0056:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzae.zzk(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void zzl(Bundle bundle) {
        boolean z = true;
        zzbq.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.mLock) {
            zzbq.checkState(this.zzggr ^ true);
            this.mHandler.removeMessages(1);
            this.zzggr = true;
            if (this.zzggn.size() != 0) {
                z = false;
            }
            zzbq.checkState(z);
            ArrayList arrayList = new ArrayList(this.zzggm);
            int i = this.zzggq.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                if (!this.zzggp || !this.zzggl.isConnected() || this.zzggq.get() != i) {
                    break;
                } else if (!this.zzggn.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzggn.clear();
            this.zzggr = false;
        }
    }
}
