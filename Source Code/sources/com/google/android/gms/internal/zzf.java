package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzf implements zzt {
    private final Map<String, List<zzr<?>>> zzp = new HashMap();
    private final zzd zzq;

    zzf(zzd zzd) {
        this.zzq = zzd;
    }

    /* JADX WARNING: Missing block: B:11:0x0039, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x0051, code:
            return false;
     */
    private final synchronized boolean zzb(com.google.android.gms.internal.zzr<?> r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r6.getUrl();	 Catch:{ all -> 0x0052 }
        r1 = r5.zzp;	 Catch:{ all -> 0x0052 }
        r1 = r1.containsKey(r0);	 Catch:{ all -> 0x0052 }
        r2 = 0;
        r3 = 1;
        if (r1 == 0) goto L_0x003a;
    L_0x000f:
        r1 = r5.zzp;	 Catch:{ all -> 0x0052 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0052 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x0052 }
        if (r1 != 0) goto L_0x001e;
    L_0x0019:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0052 }
        r1.<init>();	 Catch:{ all -> 0x0052 }
    L_0x001e:
        r4 = "waiting-for-response";
        r6.zzb(r4);	 Catch:{ all -> 0x0052 }
        r1.add(r6);	 Catch:{ all -> 0x0052 }
        r6 = r5.zzp;	 Catch:{ all -> 0x0052 }
        r6.put(r0, r1);	 Catch:{ all -> 0x0052 }
        r6 = com.google.android.gms.internal.zzaf.DEBUG;	 Catch:{ all -> 0x0052 }
        if (r6 == 0) goto L_0x0038;
    L_0x002f:
        r6 = "Request for cacheKey=%s is in flight, putting on hold.";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0052 }
        r1[r2] = r0;	 Catch:{ all -> 0x0052 }
        com.google.android.gms.internal.zzaf.zzb(r6, r1);	 Catch:{ all -> 0x0052 }
    L_0x0038:
        monitor-exit(r5);
        return r3;
    L_0x003a:
        r1 = r5.zzp;	 Catch:{ all -> 0x0052 }
        r4 = 0;
        r1.put(r0, r4);	 Catch:{ all -> 0x0052 }
        r6.zza(r5);	 Catch:{ all -> 0x0052 }
        r6 = com.google.android.gms.internal.zzaf.DEBUG;	 Catch:{ all -> 0x0052 }
        if (r6 == 0) goto L_0x0050;
    L_0x0047:
        r6 = "new request, sending to network %s";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0052 }
        r1[r2] = r0;	 Catch:{ all -> 0x0052 }
        com.google.android.gms.internal.zzaf.zzb(r6, r1);	 Catch:{ all -> 0x0052 }
    L_0x0050:
        monitor-exit(r5);
        return r2;
    L_0x0052:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzf.zzb(com.google.android.gms.internal.zzr):boolean");
    }

    public final synchronized void zza(zzr<?> zzr) {
        String url = zzr.getUrl();
        List list = (List) this.zzp.remove(url);
        if (!(list == null || list.isEmpty())) {
            if (zzaf.DEBUG) {
                zzaf.zza("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), url);
            }
            zzr zzr2 = (zzr) list.remove(0);
            this.zzp.put(url, list);
            zzr2.zza((zzt) this);
            try {
                this.zzq.zzi.put(zzr2);
            } catch (InterruptedException e) {
                zzaf.zzc("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzq.quit();
            }
        }
    }

    public final void zza(zzr<?> zzr, zzx<?> zzx) {
        if (zzx.zzbg == null || zzx.zzbg.zza()) {
            zza(zzr);
            return;
        }
        List<zzr> list;
        String url = zzr.getUrl();
        synchronized (this) {
            list = (List) this.zzp.remove(url);
        }
        if (list != null) {
            if (zzaf.DEBUG) {
                zzaf.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), url);
            }
            for (zzr zzb : list) {
                this.zzq.zzk.zzb(zzb, zzx);
            }
        }
    }
}
