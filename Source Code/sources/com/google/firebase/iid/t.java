package com.google.firebase.iid;

final /* synthetic */ class t implements Runnable {
    private final q YF;

    t(q qVar) {
        this.YF = qVar;
    }

    /* JADX WARNING: Missing block: B:15:0x0040, code:
            if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0066;
     */
    /* JADX WARNING: Missing block: B:16:0x0042, code:
            r4 = java.lang.String.valueOf(r1);
            r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r4).length() + 8);
            r6.append("Sending ");
            r6.append(r4);
            android.util.Log.d("MessengerIpcClient", r6.toString());
     */
    /* JADX WARNING: Missing block: B:17:0x0066, code:
            r3 = r0.YD.zzaiq;
            r4 = r0.Yz;
            r5 = android.os.Message.obtain();
            r5.what = r1.what;
            r5.arg1 = r1.YI;
            r5.replyTo = r4;
            r4 = new android.os.Bundle();
            r4.putBoolean("oneWay", r1.wI());
            r4.putString("pkg", r3.getPackageName());
            r4.putBundle("data", r1.YK);
            r5.setData(r4);
     */
    /* JADX WARNING: Missing block: B:19:?, code:
            r0.YA.send(r5);
     */
    /* JADX WARNING: Missing block: B:21:0x00a4, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:0x00a5, code:
            r0.d(2, r1.getMessage());
     */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.YF;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.state;	 Catch:{ all -> 0x00ae }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        return;
    L_0x000a:
        r1 = r0.YB;	 Catch:{ all -> 0x00ae }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00ae }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.wG();	 Catch:{ all -> 0x00ae }
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        return;
    L_0x0017:
        r1 = r0.YB;	 Catch:{ all -> 0x00ae }
        r1 = r1.poll();	 Catch:{ all -> 0x00ae }
        r1 = (com.google.firebase.iid.x) r1;	 Catch:{ all -> 0x00ae }
        r3 = r0.YC;	 Catch:{ all -> 0x00ae }
        r4 = r1.YI;	 Catch:{ all -> 0x00ae }
        r3.put(r4, r1);	 Catch:{ all -> 0x00ae }
        r3 = r0.YD;	 Catch:{ all -> 0x00ae }
        r3 = r3.Yw;	 Catch:{ all -> 0x00ae }
        r4 = new com.google.firebase.iid.u;	 Catch:{ all -> 0x00ae }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00ae }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00ae }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00ae }
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        r3 = "MessengerIpcClient";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0066;
    L_0x0042:
        r3 = "MessengerIpcClient";
        r4 = java.lang.String.valueOf(r1);
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 8;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Sending ";
        r6.append(r5);
        r6.append(r4);
        r4 = r6.toString();
        android.util.Log.d(r3, r4);
    L_0x0066:
        r3 = r0.YD;
        r3 = r3.zzaiq;
        r4 = r0.Yz;
        r5 = android.os.Message.obtain();
        r6 = r1.what;
        r5.what = r6;
        r6 = r1.YI;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = "oneWay";
        r7 = r1.wI();
        r4.putBoolean(r6, r7);
        r6 = "pkg";
        r3 = r3.getPackageName();
        r4.putString(r6, r3);
        r3 = "data";
        r1 = r1.YK;
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.YA;	 Catch:{ RemoteException -> 0x00a4 }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00a4 }
        goto L_0x0002;
    L_0x00a4:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.d(r2, r1);
        goto L_0x0002;
    L_0x00ae:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.t.run():void");
    }
}
