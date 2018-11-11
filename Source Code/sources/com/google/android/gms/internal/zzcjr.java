package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;
import java.net.URL;
import java.util.Map;

@WorkerThread
final class zzcjr implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzjlc;
    private final zzcjp zzjld;
    private final Map<String, String> zzjle;
    private /* synthetic */ zzcjn zzjlf;

    public zzcjr(zzcjn zzcjn, String str, URL url, byte[] bArr, Map<String, String> map, zzcjp zzcjp) {
        this.zzjlf = zzcjn;
        zzbq.zzgv(str);
        zzbq.checkNotNull(url);
        zzbq.checkNotNull(zzcjp);
        this.url = url;
        this.zzjlc = bArr;
        this.zzjld = zzcjp;
        this.packageName = str;
        this.zzjle = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101 A:{SYNTHETIC, Splitter: B:58:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c4 A:{SYNTHETIC, Splitter: B:45:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c4 A:{SYNTHETIC, Splitter: B:45:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101 A:{SYNTHETIC, Splitter: B:58:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c4 A:{SYNTHETIC, Splitter: B:45:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0101 A:{SYNTHETIC, Splitter: B:58:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c4 A:{SYNTHETIC, Splitter: B:45:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0  */
    public final void run() {
        /*
        r12 = this;
        r0 = r12.zzjlf;
        r0.zzaya();
        r0 = 0;
        r1 = 0;
        r2 = r12.zzjlf;	 Catch:{ IOException -> 0x00fa, all -> 0x00be }
        r3 = r12.url;	 Catch:{ IOException -> 0x00fa, all -> 0x00be }
        r2 = r2.zzb(r3);	 Catch:{ IOException -> 0x00fa, all -> 0x00be }
        r3 = r12.zzjle;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        if (r3 == 0) goto L_0x0039;
    L_0x0013:
        r3 = r12.zzjle;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r3 = r3.entrySet();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r3 = r3.iterator();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
    L_0x001d:
        r4 = r3.hasNext();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        if (r4 == 0) goto L_0x0039;
    L_0x0023:
        r4 = r3.next();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r5 = r4.getKey();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r4.getValue();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = (java.lang.String) r4;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r2.addRequestProperty(r5, r4);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        goto L_0x001d;
    L_0x0039:
        r3 = r12.zzjlc;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        if (r3 == 0) goto L_0x0084;
    L_0x003d:
        r3 = r12.zzjlf;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r3 = r3.zzayl();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r12.zzjlc;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r3 = r3.zzr(r4);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r12.zzjlf;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r4.zzayp();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r4.zzbba();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r5 = "Uploading data. size";
        r6 = r3.length;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4.zzj(r5, r6);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = "Content-Encoding";
        r5 = "gzip";
        r2.addRequestProperty(r4, r5);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r3.length;	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r2.connect();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4 = r2.getOutputStream();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r4.write(r3);	 Catch:{ IOException -> 0x007e, all -> 0x007a }
        r4.close();	 Catch:{ IOException -> 0x007e, all -> 0x007a }
        goto L_0x0084;
    L_0x007a:
        r3 = move-exception;
        r10 = r0;
        r0 = r4;
        goto L_0x00c1;
    L_0x007e:
        r3 = move-exception;
        r10 = r0;
        r8 = r3;
        r0 = r4;
        goto L_0x00fe;
    L_0x0084:
        r7 = r2.getResponseCode();	 Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
        r10 = r2.getHeaderFields();	 Catch:{ IOException -> 0x00b4, all -> 0x00b1 }
        r1 = r12.zzjlf;	 Catch:{ IOException -> 0x00af, all -> 0x00ad }
        r9 = com.google.android.gms.internal.zzcjn.zzc(r2);	 Catch:{ IOException -> 0x00af, all -> 0x00ad }
        if (r2 == 0) goto L_0x0097;
    L_0x0094:
        r2.disconnect();
    L_0x0097:
        r0 = r12.zzjlf;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzcjq;
        r5 = r12.packageName;
        r6 = r12.zzjld;
        r8 = 0;
        r11 = 0;
        r4 = r1;
        r4.<init>(r5, r6, r7, r8, r9, r10);
    L_0x00a9:
        r0.zzh(r1);
        return;
    L_0x00ad:
        r3 = move-exception;
        goto L_0x00c2;
    L_0x00af:
        r3 = move-exception;
        goto L_0x00b6;
    L_0x00b1:
        r3 = move-exception;
        r10 = r0;
        goto L_0x00c2;
    L_0x00b4:
        r3 = move-exception;
        r10 = r0;
    L_0x00b6:
        r8 = r3;
        goto L_0x00ff;
    L_0x00b8:
        r3 = move-exception;
        r10 = r0;
        goto L_0x00c1;
    L_0x00bb:
        r3 = move-exception;
        r10 = r0;
        goto L_0x00fd;
    L_0x00be:
        r3 = move-exception;
        r2 = r0;
        r10 = r2;
    L_0x00c1:
        r7 = 0;
    L_0x00c2:
        if (r0 == 0) goto L_0x00de;
    L_0x00c4:
        r0.close();	 Catch:{ IOException -> 0x00c8 }
        goto L_0x00de;
    L_0x00c8:
        r0 = move-exception;
        r1 = r12.zzjlf;
        r1 = r1.zzayp();
        r1 = r1.zzbau();
        r4 = "Error closing HTTP compressed POST connection output stream. appId";
        r5 = r12.packageName;
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r5);
        r1.zze(r4, r5, r0);
    L_0x00de:
        if (r2 == 0) goto L_0x00e3;
    L_0x00e0:
        r2.disconnect();
    L_0x00e3:
        r0 = r12.zzjlf;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzcjq;
        r5 = r12.packageName;
        r6 = r12.zzjld;
        r8 = 0;
        r9 = 0;
        r11 = 0;
        r4 = r1;
        r4.<init>(r5, r6, r7, r8, r9, r10);
        r0.zzh(r1);
        throw r3;
    L_0x00fa:
        r3 = move-exception;
        r2 = r0;
        r10 = r2;
    L_0x00fd:
        r8 = r3;
    L_0x00fe:
        r7 = 0;
    L_0x00ff:
        if (r0 == 0) goto L_0x011b;
    L_0x0101:
        r0.close();	 Catch:{ IOException -> 0x0105 }
        goto L_0x011b;
    L_0x0105:
        r0 = move-exception;
        r1 = r12.zzjlf;
        r1 = r1.zzayp();
        r1 = r1.zzbau();
        r3 = "Error closing HTTP compressed POST connection output stream. appId";
        r4 = r12.packageName;
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r4);
        r1.zze(r3, r4, r0);
    L_0x011b:
        if (r2 == 0) goto L_0x0120;
    L_0x011d:
        r2.disconnect();
    L_0x0120:
        r0 = r12.zzjlf;
        r0 = r0.zzayo();
        r1 = new com.google.android.gms.internal.zzcjq;
        r5 = r12.packageName;
        r6 = r12.zzjld;
        r9 = 0;
        r11 = 0;
        r4 = r1;
        r4.<init>(r5, r6, r7, r8, r9, r10);
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjr.run():void");
    }
}
