package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzdnm {
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzlxf = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzlxg = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzlxh = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzlxi = new AtomicBoolean();
    private static HashMap<String, String> zzlxj;
    private static HashMap<String, Boolean> zzlxk = new HashMap();
    private static HashMap<String, Integer> zzlxl = new HashMap();
    private static HashMap<String, Long> zzlxm = new HashMap();
    private static HashMap<String, Float> zzlxn = new HashMap();
    private static Object zzlxo;
    private static boolean zzlxp;
    private static String[] zzlxq = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Object zzb = zzb(contentResolver);
        long j2 = 0;
        Object obj = (Long) zza(zzlxm, str, Long.valueOf(0));
        if (obj != null) {
            return obj.longValue();
        }
        String zza = zza(contentResolver, str, null);
        if (zza != null) {
            try {
                long parseLong = Long.parseLong(zza);
                obj = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException unused) {
                zza(zzb, zzlxm, str, obj);
                return j2;
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0012, code:
            return r2;
     */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
        r0 = com.google.android.gms.internal.zzdnm.class;
        monitor-enter(r0);
        r1 = r2.containsKey(r3);	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0013;
    L_0x0009:
        r2 = r2.get(r3);	 Catch:{ all -> 0x0016 }
        if (r2 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0011;
    L_0x0010:
        r2 = r4;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        return r2;
    L_0x0013:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        r2 = 0;
        return r2;
    L_0x0016:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdnm.zza(java.util.HashMap, java.lang.String, java.lang.Object):T");
    }

    /* JADX WARNING: Missing block: B:9:0x001e, code:
            return r13;
     */
    /* JADX WARNING: Missing block: B:25:0x005d, code:
            return r13;
     */
    /* JADX WARNING: Missing block: B:27:0x005f, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:30:0x0064, code:
            r13 = r13.query(CONTENT_URI, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Missing block: B:31:0x0072, code:
            if (r13 == null) goto L_0x0097;
     */
    /* JADX WARNING: Missing block: B:34:0x0078, code:
            if (r13.moveToFirst() != false) goto L_0x007b;
     */
    /* JADX WARNING: Missing block: B:35:0x007b, code:
            r15 = r13.getString(1);
     */
    /* JADX WARNING: Missing block: B:36:0x007f, code:
            if (r15 == null) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:38:0x0085, code:
            if (r15.equals(null) == false) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:39:0x0087, code:
            r15 = null;
     */
    /* JADX WARNING: Missing block: B:40:0x0088, code:
            zza(r0, r14, r15);
     */
    /* JADX WARNING: Missing block: B:41:0x008b, code:
            if (r15 == null) goto L_0x008e;
     */
    /* JADX WARNING: Missing block: B:42:0x008e, code:
            r15 = null;
     */
    /* JADX WARNING: Missing block: B:43:0x008f, code:
            if (r13 == null) goto L_0x0094;
     */
    /* JADX WARNING: Missing block: B:44:0x0091, code:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:45:0x0094, code:
            return r15;
     */
    /* JADX WARNING: Missing block: B:48:?, code:
            zza(r0, r14, null);
     */
    /* JADX WARNING: Missing block: B:49:0x009a, code:
            if (r13 == null) goto L_0x009f;
     */
    /* JADX WARNING: Missing block: B:50:0x009c, code:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:51:0x009f, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:52:0x00a0, code:
            if (r13 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Missing block: B:53:0x00a2, code:
            r13.close();
     */
    public static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
        r15 = com.google.android.gms.internal.zzdnm.class;
        monitor-enter(r15);
        zza(r13);	 Catch:{ all -> 0x00a6 }
        r0 = zzlxo;	 Catch:{ all -> 0x00a6 }
        r1 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r1 = r1.containsKey(r14);	 Catch:{ all -> 0x00a6 }
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0011:
        r13 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a6 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r13 = r2;
    L_0x001d:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r13;
    L_0x001f:
        r1 = zzlxq;	 Catch:{ all -> 0x00a6 }
        r3 = r1.length;	 Catch:{ all -> 0x00a6 }
        r4 = 0;
        r5 = 0;
    L_0x0024:
        r6 = 1;
        if (r5 >= r3) goto L_0x0063;
    L_0x0027:
        r7 = r1[r5];	 Catch:{ all -> 0x00a6 }
        r7 = r14.startsWith(r7);	 Catch:{ all -> 0x00a6 }
        if (r7 == 0) goto L_0x0060;
    L_0x002f:
        r0 = zzlxp;	 Catch:{ all -> 0x00a6 }
        if (r0 == 0) goto L_0x003b;
    L_0x0033:
        r0 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00a6 }
        if (r0 == 0) goto L_0x005e;
    L_0x003b:
        r0 = zzlxq;	 Catch:{ all -> 0x00a6 }
        r1 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r13 = zza(r13, r0);	 Catch:{ all -> 0x00a6 }
        r1.putAll(r13);	 Catch:{ all -> 0x00a6 }
        zzlxp = r6;	 Catch:{ all -> 0x00a6 }
        r13 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r13 = r13.containsKey(r14);	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x005e;
    L_0x0050:
        r13 = zzlxj;	 Catch:{ all -> 0x00a6 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a6 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x005c;
    L_0x005b:
        r13 = r2;
    L_0x005c:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r13;
    L_0x005e:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r2;
    L_0x0060:
        r5 = r5 + 1;
        goto L_0x0024;
    L_0x0063:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        r8 = CONTENT_URI;
        r9 = 0;
        r10 = 0;
        r11 = new java.lang.String[r6];
        r11[r4] = r14;
        r12 = 0;
        r7 = r13;
        r13 = r7.query(r8, r9, r10, r11, r12);
        if (r13 == 0) goto L_0x0097;
    L_0x0074:
        r15 = r13.moveToFirst();	 Catch:{ all -> 0x0095 }
        if (r15 != 0) goto L_0x007b;
    L_0x007a:
        goto L_0x0097;
    L_0x007b:
        r15 = r13.getString(r6);	 Catch:{ all -> 0x0095 }
        if (r15 == 0) goto L_0x0088;
    L_0x0081:
        r1 = r15.equals(r2);	 Catch:{ all -> 0x0095 }
        if (r1 == 0) goto L_0x0088;
    L_0x0087:
        r15 = r2;
    L_0x0088:
        zza(r0, r14, r15);	 Catch:{ all -> 0x0095 }
        if (r15 == 0) goto L_0x008e;
    L_0x008d:
        goto L_0x008f;
    L_0x008e:
        r15 = r2;
    L_0x008f:
        if (r13 == 0) goto L_0x0094;
    L_0x0091:
        r13.close();
    L_0x0094:
        return r15;
    L_0x0095:
        r14 = move-exception;
        goto L_0x00a0;
    L_0x0097:
        zza(r0, r14, r2);	 Catch:{ all -> 0x0095 }
        if (r13 == 0) goto L_0x009f;
    L_0x009c:
        r13.close();
    L_0x009f:
        return r2;
    L_0x00a0:
        if (r13 == 0) goto L_0x00a5;
    L_0x00a2:
        r13.close();
    L_0x00a5:
        throw r14;
    L_0x00a6:
        r13 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdnm.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzlxf, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzlxj == null) {
            zzlxi.set(false);
            zzlxj = new HashMap();
            zzlxo = new Object();
            zzlxp = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzdnn(null));
            return;
        }
        if (zzlxi.getAndSet(false)) {
            zzlxj.clear();
            zzlxk.clear();
            zzlxl.clear();
            zzlxm.clear();
            zzlxn.clear();
            zzlxo = new Object();
            zzlxp = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzdnm.class) {
            if (obj == zzlxo) {
                zzlxj.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdnm.class) {
            if (obj == zzlxo) {
                hashMap.put(str, t);
                zzlxj.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzlxk, str, Boolean.valueOf(z));
        if (obj != null) {
            return obj.booleanValue();
        }
        Object zza = zza(contentResolver, str, null);
        if (!(zza == null || zza.equals(""))) {
            if (zzlxg.matcher(zza).matches()) {
                obj = Boolean.valueOf(true);
                z = true;
            } else if (zzlxh.matcher(zza).matches()) {
                obj = Boolean.valueOf(false);
                z = false;
            } else {
                StringBuilder stringBuilder = new StringBuilder("attempt to read gservices key ");
                stringBuilder.append(str);
                stringBuilder.append(" (value \"");
                stringBuilder.append(zza);
                stringBuilder.append("\") as boolean");
                Log.w("Gservices", stringBuilder.toString());
            }
        }
        zza(zzb, zzlxk, str, obj);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdnm.class) {
            zza(contentResolver);
            obj = zzlxo;
        }
        return obj;
    }
}
