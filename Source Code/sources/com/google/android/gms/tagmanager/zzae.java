package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.zzbs;

final class zzae implements zzdi<zzbs> {
    private /* synthetic */ zzy zzkod;

    private zzae(zzy zzy) {
        this.zzkod = zzy;
    }

    /* synthetic */ zzae(zzy zzy, zzz zzz) {
        this(zzy);
    }

    /* JADX WARNING: Missing block: B:15:0x0076, code:
            return;
     */
    public final /* synthetic */ void onSuccess(java.lang.Object r6) {
        /*
        r5 = this;
        r6 = (com.google.android.gms.internal.zzbs) r6;
        r0 = r5.zzkod;
        r0 = r0.zzknu;
        r0.zzbfz();
        r0 = r5.zzkod;
        monitor-enter(r0);
        r1 = r6.zzyi;	 Catch:{ all -> 0x0077 }
        if (r1 != 0) goto L_0x003c;
    L_0x0012:
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzknz;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzyi;	 Catch:{ all -> 0x0077 }
        if (r1 != 0) goto L_0x0032;
    L_0x001c:
        r6 = "Current resource is null; network resource is also null";
        com.google.android.gms.tagmanager.zzdj.e(r6);	 Catch:{ all -> 0x0077 }
        r6 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r6 = r6.zzknu;	 Catch:{ all -> 0x0077 }
        r1 = r6.zzbfx();	 Catch:{ all -> 0x0077 }
        r6 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r6.zzbg(r1);	 Catch:{ all -> 0x0077 }
        monitor-exit(r0);	 Catch:{ all -> 0x0077 }
        return;
    L_0x0032:
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzknz;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzyi;	 Catch:{ all -> 0x0077 }
        r6.zzyi = r1;	 Catch:{ all -> 0x0077 }
    L_0x003c:
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r2 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r2 = r2.zzata;	 Catch:{ all -> 0x0077 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0077 }
        r4 = 0;
        r1.zza(r6, r2, r4);	 Catch:{ all -> 0x0077 }
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzknh;	 Catch:{ all -> 0x0077 }
        r3 = 58;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0077 }
        r4.<init>(r3);	 Catch:{ all -> 0x0077 }
        r3 = "setting refresh time to current time: ";
        r4.append(r3);	 Catch:{ all -> 0x0077 }
        r4.append(r1);	 Catch:{ all -> 0x0077 }
        r1 = r4.toString();	 Catch:{ all -> 0x0077 }
        com.google.android.gms.tagmanager.zzdj.v(r1);	 Catch:{ all -> 0x0077 }
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r1 = r1.zzbft();	 Catch:{ all -> 0x0077 }
        if (r1 != 0) goto L_0x0075;
    L_0x0070:
        r1 = r5.zzkod;	 Catch:{ all -> 0x0077 }
        r1.zza(r6);	 Catch:{ all -> 0x0077 }
    L_0x0075:
        monitor-exit(r0);	 Catch:{ all -> 0x0077 }
        return;
    L_0x0077:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0077 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzae.onSuccess(java.lang.Object):void");
    }

    public final void zzbfu() {
    }

    public final void zzex(int i) {
        if (i == zzda.zzkqq) {
            this.zzkod.zzknu.zzbfy();
        }
        synchronized (this.zzkod) {
            if (!this.zzkod.isReady()) {
                BasePendingResult basePendingResult;
                Result zzb;
                if (this.zzkod.zzknx != null) {
                    basePendingResult = this.zzkod;
                    zzb = this.zzkod.zzknx;
                } else {
                    basePendingResult = this.zzkod;
                    zzb = this.zzkod.zzb(Status.zzftt);
                }
                basePendingResult.setResult(zzb);
            }
        }
        this.zzkod.zzbg(this.zzkod.zzknu.zzbfx());
    }
}
