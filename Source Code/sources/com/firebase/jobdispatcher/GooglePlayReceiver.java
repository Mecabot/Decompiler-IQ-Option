package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.util.Pair;
import com.firebase.jobdispatcher.n.a;

public class GooglePlayReceiver extends Service implements a {
    private static final p Ka = new p("com.firebase.jobdispatcher.");
    private static final SimpleArrayMap<String, SimpleArrayMap<String, o>> Kg = new SimpleArrayMap(1);
    @VisibleForTesting
    c JL;
    private final f Kb = new f();
    @VisibleForTesting
    Messenger Kc;
    @VisibleForTesting
    ValidationEnforcer Kd;
    private d Ke;
    private int Kf;

    private static void a(o oVar, int i) {
        try {
            oVar.an(i);
        } catch (Throwable th) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", th.getCause());
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                synchronized (Kg) {
                    this.Kf = i2;
                    if (Kg.isEmpty()) {
                        stopSelf(this.Kf);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                oE().a(l(intent));
                synchronized (Kg) {
                    this.Kf = i2;
                    if (Kg.isEmpty()) {
                        stopSelf(this.Kf);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action)) {
                synchronized (Kg) {
                    this.Kf = i2;
                    if (Kg.isEmpty()) {
                        stopSelf(this.Kf);
                    }
                }
                return 2;
            } else {
                Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                synchronized (Kg) {
                    this.Kf = i2;
                    if (Kg.isEmpty()) {
                        stopSelf(this.Kf);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (Kg) {
                this.Kf = i2;
                if (Kg.isEmpty()) {
                    stopSelf(this.Kf);
                }
            }
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return (intent == null || VERSION.SDK_INT < 21 || !"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction())) ? null : oD().getBinder();
    }

    private synchronized Messenger oD() {
        if (this.Kc == null) {
            this.Kc = new Messenger(new j(Looper.getMainLooper(), this));
        }
        return this.Kc;
    }

    synchronized d oE() {
        if (this.Ke == null) {
            this.Ke = new d(this, this);
        }
        return this.Ke;
    }

    @NonNull
    private synchronized c oF() {
        if (this.JL == null) {
            this.JL = new g(getApplicationContext());
        }
        return this.JL;
    }

    @NonNull
    private synchronized ValidationEnforcer oG() {
        if (this.Kd == null) {
            this.Kd = new ValidationEnforcer(oF().oz());
        }
        return this.Kd;
    }

    @Nullable
    @VisibleForTesting
    q l(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
            return null;
        }
        Pair y = this.Kb.y(extras);
        if (y != null) {
            return a((o) y.first, (Bundle) y.second);
        }
        Log.i("FJD.GooglePlayReceiver", "no callback found");
        return null;
    }

    @Nullable
    q a(o oVar, Bundle bundle) {
        q C = Ka.C(bundle);
        if (C == null) {
            Log.e("FJD.GooglePlayReceiver", "unable to decode job");
            a(oVar, 2);
            return null;
        }
        synchronized (Kg) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) Kg.get(C.oN());
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap(1);
                Kg.put(C.oN(), simpleArrayMap);
            }
            simpleArrayMap.put(C.getTag(), oVar);
        }
        return C;
    }

    /* JADX WARNING: Missing block: B:10:0x001f, code:
            return;
     */
    /* JADX WARNING: Missing block: B:19:0x003a, code:
            return;
     */
    /* JADX WARNING: Missing block: B:36:0x0090, code:
            return;
     */
    public void b(@android.support.annotation.NonNull com.firebase.jobdispatcher.q r6, int r7) {
        /*
        r5 = this;
        r0 = Kg;
        monitor-enter(r0);
        r1 = Kg;	 Catch:{ all -> 0x0091 }
        r2 = r6.oN();	 Catch:{ all -> 0x0091 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x0091 }
        r1 = (android.support.v4.util.SimpleArrayMap) r1;	 Catch:{ all -> 0x0091 }
        if (r1 != 0) goto L_0x0020;
    L_0x0011:
        r6 = Kg;	 Catch:{ all -> 0x00a0 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00a0 }
        if (r6 == 0) goto L_0x001e;
    L_0x0019:
        r6 = r5.Kf;	 Catch:{ all -> 0x00a0 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00a0 }
    L_0x001e:
        monitor-exit(r0);	 Catch:{ all -> 0x00a0 }
        return;
    L_0x0020:
        r2 = r6.getTag();	 Catch:{ all -> 0x0091 }
        r2 = r1.remove(r2);	 Catch:{ all -> 0x0091 }
        r2 = (com.firebase.jobdispatcher.o) r2;	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x003b;
    L_0x002c:
        r6 = Kg;	 Catch:{ all -> 0x00a0 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00a0 }
        if (r6 == 0) goto L_0x0039;
    L_0x0034:
        r6 = r5.Kf;	 Catch:{ all -> 0x00a0 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00a0 }
    L_0x0039:
        monitor-exit(r0);	 Catch:{ all -> 0x00a0 }
        return;
    L_0x003b:
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x004a;
    L_0x0041:
        r1 = Kg;	 Catch:{ all -> 0x0091 }
        r3 = r6.oN();	 Catch:{ all -> 0x0091 }
        r1.remove(r3);	 Catch:{ all -> 0x0091 }
    L_0x004a:
        r1 = a(r6, r7);	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x0054;
    L_0x0050:
        r5.b(r6);	 Catch:{ all -> 0x0091 }
        goto L_0x0082;
    L_0x0054:
        r1 = "FJD.GooglePlayReceiver";
        r3 = 2;
        r1 = android.util.Log.isLoggable(r1, r3);	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x007f;
    L_0x005d:
        r1 = "FJD.GooglePlayReceiver";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0091 }
        r3.<init>();	 Catch:{ all -> 0x0091 }
        r4 = "sending jobFinished for ";
        r3.append(r4);	 Catch:{ all -> 0x0091 }
        r6 = r6.getTag();	 Catch:{ all -> 0x0091 }
        r3.append(r6);	 Catch:{ all -> 0x0091 }
        r6 = " = ";
        r3.append(r6);	 Catch:{ all -> 0x0091 }
        r3.append(r7);	 Catch:{ all -> 0x0091 }
        r6 = r3.toString();	 Catch:{ all -> 0x0091 }
        android.util.Log.v(r1, r6);	 Catch:{ all -> 0x0091 }
    L_0x007f:
        a(r2, r7);	 Catch:{ all -> 0x0091 }
    L_0x0082:
        r6 = Kg;	 Catch:{ all -> 0x00a0 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00a0 }
        if (r6 == 0) goto L_0x008f;
    L_0x008a:
        r6 = r5.Kf;	 Catch:{ all -> 0x00a0 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00a0 }
    L_0x008f:
        monitor-exit(r0);	 Catch:{ all -> 0x00a0 }
        return;
    L_0x0091:
        r6 = move-exception;
        r7 = Kg;	 Catch:{ all -> 0x00a0 }
        r7 = r7.isEmpty();	 Catch:{ all -> 0x00a0 }
        if (r7 == 0) goto L_0x009f;
    L_0x009a:
        r7 = r5.Kf;	 Catch:{ all -> 0x00a0 }
        r5.stopSelf(r7);	 Catch:{ all -> 0x00a0 }
    L_0x009f:
        throw r6;	 Catch:{ all -> 0x00a0 }
    L_0x00a0:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a0 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.b(com.firebase.jobdispatcher.q, int):void");
    }

    private void b(q qVar) {
        oF().a(new a(oG(), qVar).V(true).oO());
    }

    private static boolean a(r rVar, int i) {
        if (rVar.oM() && (rVar.oL() instanceof u.a) && i != 1) {
            return true;
        }
        return false;
    }

    static p oH() {
        return Ka;
    }

    static void b(n nVar) {
        synchronized (Kg) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) Kg.get(nVar.oN());
            if (simpleArrayMap == null) {
            } else if (((o) simpleArrayMap.get(nVar.getTag())) == null) {
            } else {
                d.a(new a().cw(nVar.getTag()).cx(nVar.oN()).c(nVar.oL()).oP(), false);
            }
        }
    }
}
