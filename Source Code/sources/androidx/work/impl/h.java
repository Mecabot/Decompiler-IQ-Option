package androidx.work.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.WorkerThread;
import androidx.work.State;
import androidx.work.Worker;
import androidx.work.Worker.Result;
import androidx.work.e;
import androidx.work.impl.b.b;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.a.c;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: WorkerWrapper */
public class h implements Runnable {
    private j dW;
    String eM;
    a eN;
    Worker eO;
    private k eP = this.ej.bu();
    private b eQ = this.ej.bv();
    private n eR = this.ej.bw();
    private List<String> eS;
    private String eT;
    private volatile boolean eU;
    private androidx.work.impl.Extras.a ed;
    private androidx.work.a ei;
    private WorkDatabase ej;
    private List<c> el;
    private Context mAppContext;

    @RestrictTo({Scope.LIBRARY_GROUP})
    /* compiled from: WorkerWrapper */
    public static class a {
        String eM;
        a eN;
        @Nullable
        Worker eO;
        androidx.work.impl.Extras.a ed;
        androidx.work.a ei;
        WorkDatabase ej;
        List<c> el;
        Context mAppContext;

        public a(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.mAppContext = context.getApplicationContext();
            this.ei = aVar;
            this.ej = workDatabase;
            this.eM = str;
        }

        public a c(a aVar) {
            this.eN = aVar;
            return this;
        }

        public a f(List<c> list) {
            this.el = list;
            return this;
        }

        public a a(androidx.work.impl.Extras.a aVar) {
            this.ed = aVar;
            return this;
        }

        public h bP() {
            return new h(this);
        }
    }

    h(a aVar) {
        this.mAppContext = aVar.mAppContext;
        this.eM = aVar.eM;
        this.eN = aVar.eN;
        this.el = aVar.el;
        this.ed = aVar.ed;
        this.eO = aVar.eO;
        this.ei = aVar.ei;
        this.ej = aVar.ej;
    }

    @WorkerThread
    public void run() {
        this.eS = this.eR.T(this.eM);
        this.eT = e(this.eS);
        bI();
        d.a(this.ei, this.ej, this.el);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ef A:{Splitter: B:37:0x00e8, ExcHandler: java.lang.Exception (r0_31 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:39:0x00ef, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x00f0, code:
            r3 = androidx.work.Worker.Result.FAILURE;
            androidx.work.e.e("WorkerWrapper", java.lang.String.format("%s failed because it threw an exception/error", new java.lang.Object[]{r8.eT}), r0);
            r0 = r3;
     */
    private void bI() {
        /*
        r8 = this;
        r0 = r8.bK();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r8.ej;
        r0.beginTransaction();
        r0 = r8.eP;	 Catch:{ all -> 0x0148 }
        r1 = r8.eM;	 Catch:{ all -> 0x0148 }
        r0 = r0.M(r1);	 Catch:{ all -> 0x0148 }
        r8.dW = r0;	 Catch:{ all -> 0x0148 }
        r0 = r8.dW;	 Catch:{ all -> 0x0148 }
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0038;
    L_0x001c:
        r0 = "WorkerWrapper";
        r3 = "Didn't find WorkSpec for id %s";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0148 }
        r4 = r8.eM;	 Catch:{ all -> 0x0148 }
        r1[r2] = r4;	 Catch:{ all -> 0x0148 }
        r1 = java.lang.String.format(r3, r1);	 Catch:{ all -> 0x0148 }
        r3 = new java.lang.Throwable[r2];	 Catch:{ all -> 0x0148 }
        androidx.work.e.e(r0, r1, r3);	 Catch:{ all -> 0x0148 }
        r8.b(r2, r2);	 Catch:{ all -> 0x0148 }
        r0 = r8.ej;
        r0.endTransaction();
        return;
    L_0x0038:
        r0 = r8.dW;	 Catch:{ all -> 0x0148 }
        r0 = r0.gn;	 Catch:{ all -> 0x0148 }
        r3 = androidx.work.State.ENQUEUED;	 Catch:{ all -> 0x0148 }
        if (r0 == r3) goto L_0x004e;
    L_0x0040:
        r8.bJ();	 Catch:{ all -> 0x0148 }
        r0 = r8.ej;	 Catch:{ all -> 0x0148 }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0148 }
        r0 = r8.ej;
        r0.endTransaction();
        return;
    L_0x004e:
        r0 = r8.ej;	 Catch:{ all -> 0x0148 }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0148 }
        r0 = r8.ej;
        r0.endTransaction();
        r0 = r8.dW;
        r0 = r0.isPeriodic();
        if (r0 == 0) goto L_0x0065;
    L_0x0060:
        r0 = r8.dW;
        r0 = r0.gq;
        goto L_0x00a3;
    L_0x0065:
        r0 = r8.dW;
        r0 = r0.gp;
        r0 = androidx.work.d.o(r0);
        if (r0 != 0) goto L_0x0088;
    L_0x006f:
        r0 = "WorkerWrapper";
        r3 = "Could not create Input Merger %s";
        r1 = new java.lang.Object[r1];
        r4 = r8.dW;
        r4 = r4.gp;
        r1[r2] = r4;
        r1 = java.lang.String.format(r3, r1);
        r2 = new java.lang.Throwable[r2];
        androidx.work.e.e(r0, r1, r2);
        r8.bM();
        return;
    L_0x0088:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = r8.dW;
        r4 = r4.gq;
        r3.add(r4);
        r4 = r8.eP;
        r5 = r8.eM;
        r4 = r4.R(r5);
        r3.addAll(r4);
        r0 = r0.b(r3);
    L_0x00a3:
        r3 = new androidx.work.impl.Extras;
        r4 = r8.eS;
        r5 = r8.ed;
        r6 = r8.dW;
        r6 = r6.gw;
        r3.<init>(r0, r4, r5, r6);
        r0 = r8.eO;
        if (r0 != 0) goto L_0x00be;
    L_0x00b4:
        r0 = r8.mAppContext;
        r4 = r8.dW;
        r0 = a(r0, r4, r3);
        r8.eO = r0;
    L_0x00be:
        r0 = r8.eO;
        if (r0 != 0) goto L_0x00db;
    L_0x00c2:
        r0 = "WorkerWrapper";
        r3 = "Could for create Worker %s";
        r1 = new java.lang.Object[r1];
        r4 = r8.dW;
        r4 = r4.go;
        r1[r2] = r4;
        r1 = java.lang.String.format(r3, r1);
        r2 = new java.lang.Throwable[r2];
        androidx.work.e.e(r0, r1, r2);
        r8.bM();
        return;
    L_0x00db:
        r0 = r8.bL();
        if (r0 == 0) goto L_0x0144;
    L_0x00e1:
        r0 = r8.bK();
        if (r0 == 0) goto L_0x00e8;
    L_0x00e7:
        return;
    L_0x00e8:
        r0 = r8.eO;	 Catch:{ Exception -> 0x00ef, Exception -> 0x00ef }
        r0 = r0.bh();	 Catch:{ Exception -> 0x00ef, Exception -> 0x00ef }
        goto L_0x0108;
    L_0x00ef:
        r0 = move-exception;
        r3 = androidx.work.Worker.Result.FAILURE;
        r4 = "WorkerWrapper";
        r5 = "%s failed because it threw an exception/error";
        r6 = new java.lang.Object[r1];
        r7 = r8.eT;
        r6[r2] = r7;
        r5 = java.lang.String.format(r5, r6);
        r1 = new java.lang.Throwable[r1];
        r1[r2] = r0;
        androidx.work.e.e(r4, r5, r1);
        r0 = r3;
    L_0x0108:
        r1 = r8.ej;	 Catch:{ all -> 0x013d }
        r1.beginTransaction();	 Catch:{ all -> 0x013d }
        r1 = r8.bK();	 Catch:{ all -> 0x013d }
        if (r1 != 0) goto L_0x0137;
    L_0x0113:
        r1 = r8.eP;	 Catch:{ all -> 0x013d }
        r3 = r8.eM;	 Catch:{ all -> 0x013d }
        r1 = r1.Q(r3);	 Catch:{ all -> 0x013d }
        if (r1 != 0) goto L_0x0121;
    L_0x011d:
        r8.b(r2, r2);	 Catch:{ all -> 0x013d }
        goto L_0x0132;
    L_0x0121:
        r2 = androidx.work.State.RUNNING;	 Catch:{ all -> 0x013d }
        if (r1 != r2) goto L_0x0129;
    L_0x0125:
        r8.a(r0);	 Catch:{ all -> 0x013d }
        goto L_0x0132;
    L_0x0129:
        r0 = r1.isFinished();	 Catch:{ all -> 0x013d }
        if (r0 != 0) goto L_0x0132;
    L_0x012f:
        r8.bN();	 Catch:{ all -> 0x013d }
    L_0x0132:
        r0 = r8.ej;	 Catch:{ all -> 0x013d }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x013d }
    L_0x0137:
        r0 = r8.ej;
        r0.endTransaction();
        goto L_0x0147;
    L_0x013d:
        r0 = move-exception;
        r1 = r8.ej;
        r1.endTransaction();
        throw r0;
    L_0x0144:
        r8.bJ();
    L_0x0147:
        return;
    L_0x0148:
        r0 = move-exception;
        r1 = r8.ej;
        r1.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.h.bI():void");
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void s(boolean z) {
        this.eU = true;
        if (this.eO != null) {
            this.eO.q(z);
        }
    }

    private void bJ() {
        if (this.eP.Q(this.eM) == State.RUNNING) {
            e.b("WorkerWrapper", String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.eM}), new Throwable[0]);
            b(false, true);
            return;
        }
        e.b("WorkerWrapper", String.format("Status for %s is %s; not doing any work", new Object[]{this.eM, this.eP.Q(this.eM)}), new Throwable[0]);
        b(false, false);
    }

    private boolean bK() {
        boolean z = false;
        if (!this.eU) {
            return false;
        }
        e.c("WorkerWrapper", String.format("Work interrupted for %s", new Object[]{this.eT}), new Throwable[0]);
        State Q = this.eP.Q(this.eM);
        if (Q == null) {
            b(false, false);
        } else {
            if (Q == State.SUCCEEDED) {
                z = true;
            }
            b(z, Q.isFinished() ^ true);
        }
        return true;
    }

    private void b(final boolean z, final boolean z2) {
        if (this.eN != null) {
            try {
                this.ej.beginTransaction();
                List cw = this.ej.bu().cw();
                Object obj = (cw == null || cw.isEmpty()) ? 1 : null;
                if (obj != null) {
                    androidx.work.impl.utils.e.a(this.mAppContext, RescheduleReceiver.class, false);
                }
                c.cG().b(new Runnable() {
                    public void run() {
                        h.this.eN.a(h.this.eM, z, z2);
                    }
                });
                this.ej.setTransactionSuccessful();
            } finally {
                this.ej.endTransaction();
            }
        }
    }

    private void a(Result result) {
        switch (result) {
            case SUCCESS:
                e.c("WorkerWrapper", String.format("Worker result SUCCESS for %s", new Object[]{this.eT}), new Throwable[0]);
                if (this.dW.isPeriodic()) {
                    t(true);
                    return;
                } else {
                    bO();
                    return;
                }
            case RETRY:
                e.c("WorkerWrapper", String.format("Worker result RETRY for %s", new Object[]{this.eT}), new Throwable[0]);
                bN();
                return;
            default:
                e.c("WorkerWrapper", String.format("Worker result FAILURE for %s", new Object[]{this.eT}), new Throwable[0]);
                if (this.dW.isPeriodic()) {
                    t(false);
                    return;
                } else {
                    bM();
                    return;
                }
        }
    }

    private boolean bL() {
        this.ej.beginTransaction();
        try {
            boolean z = true;
            if (this.eP.Q(this.eM) == State.ENQUEUED) {
                this.eP.a(State.RUNNING, this.eM);
                this.eP.O(this.eM);
            } else {
                z = false;
            }
            this.ej.setTransactionSuccessful();
            return z;
        } finally {
            this.ej.endTransaction();
        }
    }

    private void bM() {
        this.ej.beginTransaction();
        try {
            A(this.eM);
            if (this.eO != null) {
                this.eP.a(this.eM, this.eO.bi());
            }
            this.ej.setTransactionSuccessful();
        } finally {
            this.ej.endTransaction();
            b(false, false);
        }
    }

    private void A(String str) {
        for (String A : this.eQ.I(str)) {
            A(A);
        }
        if (this.eP.Q(str) != State.CANCELLED) {
            this.eP.a(State.FAILED, str);
        }
    }

    private void bN() {
        this.ej.beginTransaction();
        try {
            this.eP.a(State.ENQUEUED, this.eM);
            this.eP.b(this.eM, System.currentTimeMillis());
            this.ej.setTransactionSuccessful();
        } finally {
            this.ej.endTransaction();
            b(false, true);
        }
    }

    private void t(boolean z) {
        this.ej.beginTransaction();
        try {
            this.eP.b(this.eM, this.dW.gz + this.dW.gt);
            this.eP.a(State.ENQUEUED, this.eM);
            this.eP.P(this.eM);
            if (VERSION.SDK_INT < 23) {
                this.eP.c(this.eM, -1);
            }
            this.ej.setTransactionSuccessful();
        } finally {
            this.ej.endTransaction();
            b(z, false);
        }
    }

    private void bO() {
        this.ej.beginTransaction();
        try {
            this.eP.a(State.SUCCEEDED, this.eM);
            this.eP.a(this.eM, this.eO.bi());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.eQ.I(this.eM)) {
                if (this.eQ.H(str)) {
                    e.c("WorkerWrapper", String.format("Setting status to enqueued for %s", new Object[]{str}), new Throwable[0]);
                    this.eP.a(State.ENQUEUED, str);
                    this.eP.b(str, currentTimeMillis);
                }
            }
            this.ej.setTransactionSuccessful();
        } finally {
            this.ej.endTransaction();
            b(true, false);
        }
    }

    private String e(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder("Work [ id=");
        stringBuilder.append(this.eM);
        stringBuilder.append(", tags={ ");
        Object obj = 1;
        for (String str : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(" } ]");
        return stringBuilder.toString();
    }

    static Worker a(@NonNull Context context, @NonNull j jVar, @NonNull Extras extras) {
        return a(context, jVar.go, UUID.fromString(jVar.id), extras);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Worker a(@NonNull Context context, @NonNull String str, @NonNull UUID uuid, @NonNull Extras extras) {
        context = context.getApplicationContext();
        try {
            Worker worker = (Worker) Class.forName(str).newInstance();
            Method declaredMethod = Worker.class.getDeclaredMethod("internalInit", new Class[]{Context.class, UUID.class, Extras.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(worker, new Object[]{context, uuid, extras});
            return worker;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trouble instantiating ");
            stringBuilder.append(str);
            e.e("WorkerWrapper", stringBuilder.toString(), e);
            return null;
        }
    }
}
