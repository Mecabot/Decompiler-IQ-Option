package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;
import java.util.UUID;
import java.util.concurrent.Future;

@Hide
public final class zzasc extends zzari {
    private volatile String zzdxk;
    private Future<String> zzeat;

    protected zzasc(zzark zzark) {
        super(zzark);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0080 A:{SYNTHETIC, Splitter: B:43:0x0080} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008e A:{SYNTHETIC, Splitter: B:51:0x008e} */
    private final java.lang.String zzbm(android.content.Context r7) {
        /*
        r6 = this;
        r0 = "ClientId should be loaded from worker thread";
        com.google.android.gms.common.internal.zzbq.zzgw(r0);
        r0 = 0;
        r1 = "gaClientId";
        r1 = r7.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x0099, IOException -> 0x0072, all -> 0x006f }
        r2 = 36;
        r3 = new byte[r2];	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r4 = 0;
        r2 = r1.read(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5 = r1.available();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r5 <= 0) goto L_0x0035;
    L_0x001b:
        r2 = "clientId file seems corrupted, deleting it.";
        r6.zzed(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "gaClientId";
        r7.deleteFile(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x0034;
    L_0x002a:
        r1.close();	 Catch:{ IOException -> 0x002e }
        return r0;
    L_0x002e:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.zze(r1, r7);
    L_0x0034:
        return r0;
    L_0x0035:
        r5 = 14;
        if (r2 >= r5) goto L_0x0053;
    L_0x0039:
        r2 = "clientId file is empty, deleting it.";
        r6.zzed(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "gaClientId";
        r7.deleteFile(r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x0052;
    L_0x0048:
        r1.close();	 Catch:{ IOException -> 0x004c }
        return r0;
    L_0x004c:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.zze(r1, r7);
    L_0x0052:
        return r0;
    L_0x0053:
        r1.close();	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r5.<init>(r3, r4, r2);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        r2 = "Read client id from disk";
        r6.zza(r2, r5);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x006d }
        if (r1 == 0) goto L_0x006c;
    L_0x0062:
        r1.close();	 Catch:{ IOException -> 0x0066 }
        return r5;
    L_0x0066:
        r7 = move-exception;
        r0 = "Failed to close client id reading stream";
        r6.zze(r0, r7);
    L_0x006c:
        return r5;
    L_0x006d:
        r2 = move-exception;
        goto L_0x0074;
    L_0x006f:
        r7 = move-exception;
        r1 = r0;
        goto L_0x008c;
    L_0x0072:
        r2 = move-exception;
        r1 = r0;
    L_0x0074:
        r3 = "Error reading client id file, deleting it";
        r6.zze(r3, r2);	 Catch:{ all -> 0x008b }
        r2 = "gaClientId";
        r7.deleteFile(r2);	 Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x008a;
    L_0x0080:
        r1.close();	 Catch:{ IOException -> 0x0084 }
        return r0;
    L_0x0084:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.zze(r1, r7);
    L_0x008a:
        return r0;
    L_0x008b:
        r7 = move-exception;
    L_0x008c:
        if (r1 == 0) goto L_0x0098;
    L_0x008e:
        r1.close();	 Catch:{ IOException -> 0x0092 }
        goto L_0x0098;
    L_0x0092:
        r0 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.zze(r1, r0);
    L_0x0098:
        throw r7;
    L_0x0099:
        r1 = r0;
    L_0x009a:
        if (r1 == 0) goto L_0x00a6;
    L_0x009c:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        return r0;
    L_0x00a0:
        r7 = move-exception;
        r1 = "Failed to close client id reading stream";
        r6.zze(r1, r7);
    L_0x00a6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzasc.zzbm(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0050 A:{SYNTHETIC, Splitter: B:33:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A:{SYNTHETIC, Splitter: B:23:0x003d} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005d A:{SYNTHETIC, Splitter: B:40:0x005d} */
    private final boolean zzo(android.content.Context r4, java.lang.String r5) {
        /*
        r3 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r5);
        r0 = "ClientId should be saved from worker thread";
        com.google.android.gms.common.internal.zzbq.zzgw(r0);
        r0 = 0;
        r1 = 0;
        r2 = "Storing clientId";
        r3.zza(r2, r5);	 Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x0035 }
        r2 = "gaClientId";
        r4 = r4.openFileOutput(r2, r0);	 Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x0035 }
        r5 = r5.getBytes();	 Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
        r4.write(r5);	 Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002d, all -> 0x002a }
        if (r4 == 0) goto L_0x0028;
    L_0x001e:
        r4.close();	 Catch:{ IOException -> 0x0022 }
        goto L_0x0028;
    L_0x0022:
        r4 = move-exception;
        r5 = "Failed to close clientId writing stream";
        r3.zze(r5, r4);
    L_0x0028:
        r4 = 1;
        return r4;
    L_0x002a:
        r5 = move-exception;
        r1 = r4;
        goto L_0x005b;
    L_0x002d:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0036;
    L_0x0030:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0049;
    L_0x0033:
        r5 = move-exception;
        goto L_0x005b;
    L_0x0035:
        r5 = move-exception;
    L_0x0036:
        r4 = "Error writing to clientId file";
        r3.zze(r4, r5);	 Catch:{ all -> 0x0033 }
        if (r1 == 0) goto L_0x0047;
    L_0x003d:
        r1.close();	 Catch:{ IOException -> 0x0041 }
        return r0;
    L_0x0041:
        r4 = move-exception;
        r5 = "Failed to close clientId writing stream";
        r3.zze(r5, r4);
    L_0x0047:
        return r0;
    L_0x0048:
        r5 = move-exception;
    L_0x0049:
        r4 = "Error creating clientId file";
        r3.zze(r4, r5);	 Catch:{ all -> 0x0033 }
        if (r1 == 0) goto L_0x005a;
    L_0x0050:
        r1.close();	 Catch:{ IOException -> 0x0054 }
        return r0;
    L_0x0054:
        r4 = move-exception;
        r5 = "Failed to close clientId writing stream";
        r3.zze(r5, r4);
    L_0x005a:
        return r0;
    L_0x005b:
        if (r1 == 0) goto L_0x0067;
    L_0x005d:
        r1.close();	 Catch:{ IOException -> 0x0061 }
        goto L_0x0067;
    L_0x0061:
        r4 = move-exception;
        r0 = "Failed to close clientId writing stream";
        r3.zze(r0, r4);
    L_0x0067:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzasc.zzo(android.content.Context, java.lang.String):boolean");
    }

    private final String zzzs() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            if (!zzo(zzya().getContext(), toLowerCase)) {
                toLowerCase = "0";
            }
            return toLowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    protected final void zzwk() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A:{Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }} */
    public final java.lang.String zzzp() {
        /*
        r2 = this;
        r2.zzyk();
        monitor-enter(r2);
        r0 = r2.zzdxk;	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r2.zzya();	 Catch:{ all -> 0x0050 }
        r1 = new com.google.android.gms.internal.zzasd;	 Catch:{ all -> 0x0050 }
        r1.<init>(r2);	 Catch:{ all -> 0x0050 }
        r0 = r0.zza(r1);	 Catch:{ all -> 0x0050 }
        r2.zzeat = r0;	 Catch:{ all -> 0x0050 }
    L_0x0017:
        r0 = r2.zzeat;	 Catch:{ all -> 0x0050 }
        if (r0 == 0) goto L_0x004c;
    L_0x001b:
        r0 = r2.zzeat;	 Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
        r0 = (java.lang.String) r0;	 Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
        r2.zzdxk = r0;	 Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
        goto L_0x003a;
    L_0x0026:
        r0 = move-exception;
        r1 = "Failed to load or generate client id";
        r2.zze(r1, r0);	 Catch:{ all -> 0x0050 }
        r0 = "0";
    L_0x002e:
        r2.zzdxk = r0;	 Catch:{ all -> 0x0050 }
        goto L_0x003a;
    L_0x0031:
        r0 = move-exception;
        r1 = "ClientId loading or generation was interrupted";
        r2.zzd(r1, r0);	 Catch:{ all -> 0x0050 }
        r0 = "0";
        goto L_0x002e;
    L_0x003a:
        r0 = r2.zzdxk;	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0042;
    L_0x003e:
        r0 = "0";
        r2.zzdxk = r0;	 Catch:{ all -> 0x0050 }
    L_0x0042:
        r0 = "Loaded clientId";
        r1 = r2.zzdxk;	 Catch:{ all -> 0x0050 }
        r2.zza(r0, r1);	 Catch:{ all -> 0x0050 }
        r0 = 0;
        r2.zzeat = r0;	 Catch:{ all -> 0x0050 }
    L_0x004c:
        r0 = r2.zzdxk;	 Catch:{ all -> 0x0050 }
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
        return r0;
    L_0x0050:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0050 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzasc.zzzp():java.lang.String");
    }

    final String zzzq() {
        synchronized (this) {
            this.zzdxk = null;
            this.zzeat = zzya().zza(new zzase(this));
        }
        return zzzp();
    }

    final String zzzr() {
        String zzbm = zzbm(zzya().getContext());
        return zzbm == null ? zzzs() : zzbm;
    }
}
