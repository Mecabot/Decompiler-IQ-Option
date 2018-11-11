package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class zzaj implements zzm {
    private static boolean DEBUG = zzaf.DEBUG;
    @Deprecated
    private zzar zzbo;
    private final zzai zzbp;
    private zzak zzbq;

    public zzaj(zzai zzai) {
        this(zzai, new zzak(4096));
    }

    private zzaj(zzai zzai, zzak zzak) {
        this.zzbp = zzai;
        this.zzbo = zzai;
        this.zzbq = zzak;
    }

    @Deprecated
    public zzaj(zzar zzar) {
        this(zzar, new zzak(4096));
    }

    @Deprecated
    private zzaj(zzar zzar, zzak zzak) {
        this.zzbo = zzar;
        this.zzbp = new zzah(zzar);
        this.zzbq = zzak;
    }

    private static List<zzl> zza(List<zzl> list, zzc zzc) {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (zzl name : list) {
                treeSet.add(name.getName());
            }
        }
        List<zzl> arrayList = new ArrayList(list);
        if (zzc.zzg != null) {
            if (!zzc.zzg.isEmpty()) {
                for (zzl zzl : zzc.zzg) {
                    if (!treeSet.contains(zzl.getName())) {
                        arrayList.add(zzl);
                    }
                }
            }
        } else if (!zzc.zzf.isEmpty()) {
            for (Entry entry : zzc.zzf.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(String str, zzr<?> zzr, zzae zzae) {
        zzab zzi = zzr.zzi();
        int zzh = zzr.zzh();
        try {
            zzi.zza(zzae);
            zzr.zzb(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
        } catch (zzae zzae2) {
            zzr.zzb(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzh)}));
            throw zzae2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A:{SYNTHETIC, Splitter: B:21:0x0046} */
    private final byte[] zza(java.io.InputStream r6, int r7) {
        /*
        r5 = this;
        r0 = new com.google.android.gms.internal.zzau;
        r1 = r5.zzbq;
        r0.<init>(r1, r7);
        r7 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0013;
    L_0x000b:
        r2 = new com.google.android.gms.internal.zzac;	 Catch:{ all -> 0x0011 }
        r2.<init>();	 Catch:{ all -> 0x0011 }
        throw r2;	 Catch:{ all -> 0x0011 }
    L_0x0011:
        r2 = move-exception;
        goto L_0x0044;
    L_0x0013:
        r2 = r5.zzbq;	 Catch:{ all -> 0x0011 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = r2.zzb(r3);	 Catch:{ all -> 0x0011 }
    L_0x001b:
        r1 = r6.read(r2);	 Catch:{ all -> 0x0040 }
        r3 = -1;
        if (r1 == r3) goto L_0x0026;
    L_0x0022:
        r0.write(r2, r7, r1);	 Catch:{ all -> 0x0040 }
        goto L_0x001b;
    L_0x0026:
        r1 = r0.toByteArray();	 Catch:{ all -> 0x0040 }
        if (r6 == 0) goto L_0x0037;
    L_0x002c:
        r6.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0037;
    L_0x0030:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzaf.zza(r6, r7);
    L_0x0037:
        r6 = r5.zzbq;
        r6.zza(r2);
        r0.close();
        return r1;
    L_0x0040:
        r1 = move-exception;
        r4 = r2;
        r2 = r1;
        r1 = r4;
    L_0x0044:
        if (r6 == 0) goto L_0x0051;
    L_0x0046:
        r6.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0051;
    L_0x004a:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzaf.zza(r6, r7);
    L_0x0051:
        r6 = r5.zzbq;
        r6.zza(r1);
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaj.zza(java.io.InputStream, int):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b8 A:{Splitter: B:2:0x000e, ExcHandler: java.net.SocketTimeoutException (unused java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0196 A:{Splitter: B:2:0x000e, ExcHandler: java.net.MalformedURLException (r0_9 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0190 A:{SYNTHETIC} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:25:0x0086, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:0x0087, code:
            r5 = r0;
            r13 = null;
            r17 = r11;
     */
    /* JADX WARNING: Missing block: B:43:0x00c5, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:44:0x00c6, code:
            r13 = r5;
            r17 = r11;
     */
    /* JADX WARNING: Missing block: B:59:0x010c, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:60:0x010e, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:61:0x010f, code:
            r7 = r11;
     */
    /* JADX WARNING: Missing block: B:62:0x0110, code:
            r13 = r5;
            r17 = r7;
     */
    /* JADX WARNING: Missing block: B:65:0x011b, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:66:0x011c, code:
            r17 = r5;
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:67:0x0120, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:68:0x0121, code:
            r17 = r5;
            r10 = null;
            r13 = r10;
     */
    /* JADX WARNING: Missing block: B:69:0x0125, code:
            r5 = r0;
     */
    /* JADX WARNING: Missing block: B:71:0x0128, code:
            r5 = r10.getStatusCode();
            com.google.android.gms.internal.zzaf.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r5), r28.getUrl());
     */
    /* JADX WARNING: Missing block: B:72:0x0141, code:
            if (r13 != null) goto L_0x0143;
     */
    /* JADX WARNING: Missing block: B:73:0x0143, code:
            r11 = new com.google.android.gms.internal.zzp(r5, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Missing block: B:74:0x0153, code:
            if (r5 == com.jumio.commons.remote.exception.UnexpectedResponseException.STATUS_CODE_UNAUTHORIZED) goto L_0x017c;
     */
    /* JADX WARNING: Missing block: B:78:0x015c, code:
            if (r5 < 400) goto L_0x0168;
     */
    /* JADX WARNING: Missing block: B:82:0x0167, code:
            throw new com.google.android.gms.internal.zzg(r11);
     */
    /* JADX WARNING: Missing block: B:84:0x016a, code:
            if (r5 < 500) goto L_0x0176;
     */
    /* JADX WARNING: Missing block: B:88:0x0175, code:
            throw new com.google.android.gms.internal.zzac(r11);
     */
    /* JADX WARNING: Missing block: B:90:0x017b, code:
            throw new com.google.android.gms.internal.zzac(r11);
     */
    /* JADX WARNING: Missing block: B:91:0x017c, code:
            zza("auth", r2, new com.google.android.gms.internal.zza(r11));
     */
    /* JADX WARNING: Missing block: B:92:0x0188, code:
            r5 = "network";
            r6 = new com.google.android.gms.internal.zzo();
     */
    /* JADX WARNING: Missing block: B:94:0x0195, code:
            throw new com.google.android.gms.internal.zzq(r5);
     */
    /* JADX WARNING: Missing block: B:95:0x0196, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:96:0x0197, code:
            r3 = r0;
            r5 = "Bad URL ";
            r2 = java.lang.String.valueOf(r28.getUrl());
     */
    /* JADX WARNING: Missing block: B:97:0x01a8, code:
            if (r2.length() != 0) goto L_0x01aa;
     */
    /* JADX WARNING: Missing block: B:98:0x01aa, code:
            r2 = r5.concat(r2);
     */
    /* JADX WARNING: Missing block: B:99:0x01af, code:
            r2 = new java.lang.String(r5);
     */
    /* JADX WARNING: Missing block: B:101:0x01b7, code:
            throw new java.lang.RuntimeException(r2, r3);
     */
    /* JADX WARNING: Missing block: B:102:0x01b8, code:
            r5 = "socket";
            r6 = new com.google.android.gms.internal.zzad();
     */
    /* JADX WARNING: Missing block: B:103:0x01bf, code:
            zza(r5, r2, r6);
     */
    public com.google.android.gms.internal.zzp zzc(com.google.android.gms.internal.zzr<?> r28) {
        /*
        r27 = this;
        r1 = r27;
        r2 = r28;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyList();
        r8 = 0;
        r9 = 0;
        r10 = r28.zze();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        if (r10 != 0) goto L_0x0019;
    L_0x0014:
        r10 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        goto L_0x003d;
    L_0x0019:
        r11 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r11.<init>();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r12 = r10.zza;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        if (r12 == 0) goto L_0x0029;
    L_0x0022:
        r12 = "If-None-Match";
        r13 = r10.zza;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r11.put(r12, r13);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
    L_0x0029:
        r12 = r10.zzc;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r14 = 0;
        r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r16 <= 0) goto L_0x003c;
    L_0x0031:
        r12 = "If-Modified-Since";
        r13 = r10.zzc;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r10 = com.google.android.gms.internal.zzap.zzb(r13);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r11.put(r12, r10);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
    L_0x003c:
        r10 = r11;
    L_0x003d:
        r11 = r1.zzbp;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r10 = r11.zza(r2, r10);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0120 }
        r12 = r10.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x011b }
        r11 = r10.zzp();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x011b }
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r12 != r5) goto L_0x008d;
    L_0x004f:
        r5 = r28.zze();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        if (r5 != 0) goto L_0x006b;
    L_0x0055:
        r5 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r14 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r15 = 0;
        r16 = 1;
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r17 = 0;
        r17 = r12 - r3;
        r13 = r5;
        r19 = r11;
        r13.<init>(r14, r15, r16, r17, r19);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        return r5;
    L_0x006b:
        r25 = zza(r11, r5);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r12 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r5 = r5.data;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r22 = 1;
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r15 = 0;
        r23 = r13 - r3;
        r19 = r12;
        r21 = r5;
        r19.<init>(r20, r21, r22, r23, r25);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        return r12;
    L_0x0086:
        r0 = move-exception;
        r5 = r0;
        r13 = r8;
        r17 = r11;
        goto L_0x0126;
    L_0x008d:
        r5 = r10.getContent();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0114 }
        if (r5 == 0) goto L_0x009c;
    L_0x0093:
        r13 = r10.getContentLength();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        r5 = r1.zza(r5, r13);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0086 }
        goto L_0x009e;
    L_0x009c:
        r5 = new byte[r9];	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x0114 }
    L_0x009e:
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r8 = 0;
        r6 = r13 - r3;
        r8 = DEBUG;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        if (r8 != 0) goto L_0x00af;
    L_0x00a9:
        r13 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1));
        if (r8 <= 0) goto L_0x00e9;
    L_0x00af:
        r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
        r13 = 5;
        r13 = new java.lang.Object[r13];	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r13[r9] = r2;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r7 = 1;
        r13[r7] = r6;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        if (r5 == 0) goto L_0x00cb;
    L_0x00bf:
        r6 = r5.length;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x00c5 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x00c5 }
        goto L_0x00cd;
    L_0x00c5:
        r0 = move-exception;
        r13 = r5;
        r17 = r11;
        goto L_0x0125;
    L_0x00cb:
        r6 = "null";
    L_0x00cd:
        r7 = 2;
        r13[r7] = r6;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r6 = 3;
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r13[r6] = r7;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r6 = 4;
        r7 = r28.zzi();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r7 = r7.zzc();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r13[r6] = r7;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        com.google.android.gms.internal.zzaf.zzb(r8, r13);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
    L_0x00e9:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r12 < r6) goto L_0x0105;
    L_0x00ed:
        r6 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r12 <= r6) goto L_0x00f2;
    L_0x00f1:
        goto L_0x0105;
    L_0x00f2:
        r6 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r14 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010e }
        r13 = 0;
        r15 = r7 - r3;
        r7 = r11;
        r11 = r6;
        r13 = r5;
        r17 = r7;
        r11.<init>(r12, r13, r14, r15, r17);	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010c }
        return r6;
    L_0x0105:
        r7 = r11;
        r6 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010c }
        r6.<init>();	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010c }
        throw r6;	 Catch:{ SocketTimeoutException -> 0x01b8, MalformedURLException -> 0x0196, IOException -> 0x010c }
    L_0x010c:
        r0 = move-exception;
        goto L_0x0110;
    L_0x010e:
        r0 = move-exception;
        r7 = r11;
    L_0x0110:
        r13 = r5;
        r17 = r7;
        goto L_0x0125;
    L_0x0114:
        r0 = move-exception;
        r7 = r11;
        r5 = r0;
        r17 = r7;
        r13 = r8;
        goto L_0x0126;
    L_0x011b:
        r0 = move-exception;
        r17 = r5;
        r13 = r8;
        goto L_0x0125;
    L_0x0120:
        r0 = move-exception;
        r17 = r5;
        r10 = r8;
        r13 = r10;
    L_0x0125:
        r5 = r0;
    L_0x0126:
        if (r10 == 0) goto L_0x0190;
    L_0x0128:
        r5 = r10.getStatusCode();
        r6 = "Unexpected response code %d for %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = java.lang.Integer.valueOf(r5);
        r7[r9] = r8;
        r8 = r28.getUrl();
        r9 = 1;
        r7[r9] = r8;
        com.google.android.gms.internal.zzaf.zzc(r6, r7);
        if (r13 == 0) goto L_0x0188;
    L_0x0143:
        r6 = new com.google.android.gms.internal.zzp;
        r14 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();
        r15 = r7 - r3;
        r11 = r6;
        r12 = r5;
        r11.<init>(r12, r13, r14, r15, r17);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r5 == r7) goto L_0x017c;
    L_0x0155:
        r7 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 != r7) goto L_0x015a;
    L_0x0159:
        goto L_0x017c;
    L_0x015a:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r5 < r2) goto L_0x0168;
    L_0x015e:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r5 > r2) goto L_0x0168;
    L_0x0162:
        r2 = new com.google.android.gms.internal.zzg;
        r2.<init>(r6);
        throw r2;
    L_0x0168:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r2) goto L_0x0176;
    L_0x016c:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r5 > r2) goto L_0x0176;
    L_0x0170:
        r2 = new com.google.android.gms.internal.zzac;
        r2.<init>(r6);
        throw r2;
    L_0x0176:
        r2 = new com.google.android.gms.internal.zzac;
        r2.<init>(r6);
        throw r2;
    L_0x017c:
        r5 = "auth";
        r7 = new com.google.android.gms.internal.zza;
        r7.<init>(r6);
        zza(r5, r2, r7);
        goto L_0x0008;
    L_0x0188:
        r5 = "network";
        r6 = new com.google.android.gms.internal.zzo;
        r6.<init>();
        goto L_0x01bf;
    L_0x0190:
        r2 = new com.google.android.gms.internal.zzq;
        r2.<init>(r5);
        throw r2;
    L_0x0196:
        r0 = move-exception;
        r3 = r0;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r28.getUrl();
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x01af;
    L_0x01aa:
        r2 = r5.concat(r2);
        goto L_0x01b4;
    L_0x01af:
        r2 = new java.lang.String;
        r2.<init>(r5);
    L_0x01b4:
        r4.<init>(r2, r3);
        throw r4;
    L_0x01b8:
        r5 = "socket";
        r6 = new com.google.android.gms.internal.zzad;
        r6.<init>();
    L_0x01bf:
        zza(r5, r2, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaj.zzc(com.google.android.gms.internal.zzr):com.google.android.gms.internal.zzp");
    }
}
