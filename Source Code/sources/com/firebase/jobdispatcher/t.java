package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.firebase.jobdispatcher.m.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@VisibleForTesting
/* compiled from: JobServiceConnection */
class t implements ServiceConnection {
    private final l KA;
    private boolean KB = false;
    private m KC;
    private final Map<q, Boolean> Kz = new HashMap();
    private final Context context;

    t(l lVar, Context context) {
        this.KA = lVar;
        this.context = context;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (oQ()) {
            Log.w("FJD.ExternalReceiver", "Connection have been used already.");
            return;
        }
        this.KC = a.b(iBinder);
        Set<q> hashSet = new HashSet();
        for (Entry entry : this.Kz.entrySet()) {
            if (Boolean.FALSE.equals(entry.getValue())) {
                try {
                    this.KC.a(f((r) entry.getKey()), this.KA);
                    hashSet.add(entry.getKey());
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to start job ");
                    stringBuilder.append(entry.getKey());
                    Log.e("FJD.ExternalReceiver", stringBuilder.toString(), e);
                    unbind();
                    return;
                }
            }
        }
        for (q put : hashSet) {
            this.Kz.put(put, Boolean.valueOf(true));
        }
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        unbind();
    }

    synchronized boolean oQ() {
        return this.KB;
    }

    synchronized boolean isConnected() {
        return this.KC != null;
    }

    synchronized void b(q qVar, boolean z) {
        if (oQ()) {
            Log.w("FJD.ExternalReceiver", "Can't send stop request because service was unbound.");
        } else {
            if (Boolean.TRUE.equals(this.Kz.remove(qVar)) && isConnected()) {
                a(z, qVar);
            }
            if (!z && this.Kz.isEmpty()) {
                unbind();
            }
        }
    }

    private synchronized void a(boolean z, q qVar) {
        try {
            this.KC.a(f(qVar), z);
        } catch (Throwable e) {
            Log.e("FJD.ExternalReceiver", "Failed to stop a job", e);
            unbind();
        }
        return;
    }

    synchronized void unbind() {
        if (!oQ()) {
            this.KC = null;
            this.KB = true;
            try {
                this.context.unbindService(this);
            } catch (IllegalArgumentException e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error unbinding service: ");
                stringBuilder.append(e.getMessage());
                Log.w("FJD.ExternalReceiver", stringBuilder.toString());
            }
        }
        return;
    }

    synchronized void c(q qVar) {
        this.Kz.remove(qVar);
        if (this.Kz.isEmpty()) {
            unbind();
        }
    }

    synchronized boolean d(q qVar) {
        boolean isConnected;
        isConnected = isConnected();
        if (isConnected) {
            StringBuilder stringBuilder;
            if (Boolean.TRUE.equals((Boolean) this.Kz.get(qVar))) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Received an execution request for already running job ");
                stringBuilder.append(qVar);
                Log.w("FJD.ExternalReceiver", stringBuilder.toString());
                a(false, qVar);
            }
            try {
                this.KC.a(f(qVar), this.KA);
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to start the job ");
                stringBuilder.append(qVar);
                Log.e("FJD.ExternalReceiver", stringBuilder.toString(), e);
                unbind();
                return false;
            }
        }
        this.Kz.put(qVar, Boolean.valueOf(isConnected));
        return isConnected;
    }

    private static Bundle f(r rVar) {
        return GooglePlayReceiver.oH().e(rVar, new Bundle());
    }

    @VisibleForTesting
    synchronized boolean e(q qVar) {
        return this.Kz.containsKey(qVar);
    }
}
