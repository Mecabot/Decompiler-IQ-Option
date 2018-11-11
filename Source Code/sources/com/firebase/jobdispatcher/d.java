package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

/* compiled from: ExecutionDelegator */
class d {
    private static final SimpleArrayMap<String, t> JH = new SimpleArrayMap();
    private final l JI = new com.firebase.jobdispatcher.l.a() {
        public void a(Bundle bundle, int i) {
            a D = GooglePlayReceiver.oH().D(bundle);
            if (D == null) {
                Log.wtf("FJD.ExternalReceiver", "jobFinished: unknown invocation provided");
            } else {
                d.this.a(D.oP(), i);
            }
        }
    };
    private final a JJ;
    private final Context context;

    /* compiled from: ExecutionDelegator */
    interface a {
        void b(@NonNull q qVar, int i);
    }

    d(Context context, a aVar) {
        this.context = context;
        this.JJ = aVar;
    }

    /* JADX WARNING: Missing block: B:22:0x006b, code:
            return;
     */
    void a(com.firebase.jobdispatcher.q r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = JH;
        monitor-enter(r0);
        r1 = JH;	 Catch:{ all -> 0x006c }
        r2 = r6.oN();	 Catch:{ all -> 0x006c }
        r1 = r1.get(r2);	 Catch:{ all -> 0x006c }
        r1 = (com.firebase.jobdispatcher.t) r1;	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x0028;
    L_0x0014:
        r2 = r1.oQ();	 Catch:{ all -> 0x006c }
        if (r2 != 0) goto L_0x0028;
    L_0x001a:
        r2 = r1.e(r6);	 Catch:{ all -> 0x006c }
        if (r2 == 0) goto L_0x003a;
    L_0x0020:
        r2 = r1.isConnected();	 Catch:{ all -> 0x006c }
        if (r2 != 0) goto L_0x003a;
    L_0x0026:
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return;
    L_0x0028:
        r1 = new com.firebase.jobdispatcher.t;	 Catch:{ all -> 0x006c }
        r2 = r5.JI;	 Catch:{ all -> 0x006c }
        r3 = r5.context;	 Catch:{ all -> 0x006c }
        r1.<init>(r2, r3);	 Catch:{ all -> 0x006c }
        r2 = JH;	 Catch:{ all -> 0x006c }
        r3 = r6.oN();	 Catch:{ all -> 0x006c }
        r2.put(r3, r1);	 Catch:{ all -> 0x006c }
    L_0x003a:
        r2 = r1.d(r6);	 Catch:{ all -> 0x006c }
        if (r2 != 0) goto L_0x006a;
    L_0x0040:
        r2 = r5.context;	 Catch:{ all -> 0x006c }
        r3 = r5.d(r6);	 Catch:{ all -> 0x006c }
        r4 = 1;
        r2 = r2.bindService(r3, r1, r4);	 Catch:{ all -> 0x006c }
        if (r2 != 0) goto L_0x006a;
    L_0x004d:
        r2 = "FJD.ExternalReceiver";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r3.<init>();	 Catch:{ all -> 0x006c }
        r4 = "Unable to bind to ";
        r3.append(r4);	 Catch:{ all -> 0x006c }
        r6 = r6.oN();	 Catch:{ all -> 0x006c }
        r3.append(r6);	 Catch:{ all -> 0x006c }
        r6 = r3.toString();	 Catch:{ all -> 0x006c }
        android.util.Log.e(r2, r6);	 Catch:{ all -> 0x006c }
        r1.unbind();	 Catch:{ all -> 0x006c }
    L_0x006a:
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return;
    L_0x006c:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.d.a(com.firebase.jobdispatcher.q):void");
    }

    @NonNull
    private Intent d(r rVar) {
        Intent intent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
        intent.setClassName(this.context, rVar.oN());
        return intent;
    }

    static void a(q qVar, boolean z) {
        synchronized (JH) {
            t tVar = (t) JH.get(qVar.oN());
            if (tVar != null) {
                tVar.b(qVar, z);
                if (tVar.oQ()) {
                    JH.remove(qVar.oN());
                }
            }
        }
    }

    private void a(q qVar, int i) {
        synchronized (JH) {
            t tVar = (t) JH.get(qVar.oN());
            if (tVar != null) {
                tVar.c(qVar);
                if (tVar.oQ()) {
                    JH.remove(qVar.oN());
                }
            }
        }
        this.JJ.b(qVar, i);
    }
}
