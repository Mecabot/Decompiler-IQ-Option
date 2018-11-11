package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzo;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzart extends zzari implements Closeable {
    private static final String zzdzv = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzdzw = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zzaru zzdzx;
    private final zzatp zzdzy = new zzatp(zzxx());
    private final zzatp zzdzz = new zzatp(zzxx());

    zzart(zzark zzark) {
        super(zzark);
        this.zzdzx = new zzaru(this, zzark.getContext(), "google_analytics_v4.db");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0033  */
    private final long zza(java.lang.String r1, java.lang.String[] r2, long r3) {
        /*
        r0 = this;
        r3 = r0.getWritableDatabase();
        r4 = 0;
        r2 = r3.rawQuery(r1, r2);	 Catch:{ SQLiteException -> 0x002a }
        r3 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        if (r3 == 0) goto L_0x001a;
    L_0x000f:
        r3 = 0;
        r3 = r2.getLong(r3);	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        if (r2 == 0) goto L_0x0019;
    L_0x0016:
        r2.close();
    L_0x0019:
        return r3;
    L_0x001a:
        if (r2 == 0) goto L_0x001f;
    L_0x001c:
        r2.close();
    L_0x001f:
        r1 = 0;
        return r1;
    L_0x0022:
        r1 = move-exception;
        r4 = r2;
        goto L_0x0031;
    L_0x0025:
        r3 = move-exception;
        r4 = r2;
        goto L_0x002b;
    L_0x0028:
        r1 = move-exception;
        goto L_0x0031;
    L_0x002a:
        r3 = move-exception;
    L_0x002b:
        r2 = "Database error";
        r0.zzd(r2, r1, r3);	 Catch:{ all -> 0x0028 }
        throw r3;	 Catch:{ all -> 0x0028 }
    L_0x0031:
        if (r4 == 0) goto L_0x0036;
    L_0x0033:
        r4.close();
    L_0x0036:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzart.zza(java.lang.String, java.lang.String[], long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0035  */
    private final long zzc(java.lang.String r4, java.lang.String[] r5) {
        /*
        r3 = this;
        r5 = r3.getWritableDatabase();
        r0 = 0;
        r5 = r5.rawQuery(r4, r0);	 Catch:{ SQLiteException -> 0x0029, all -> 0x0026 }
        r0 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0024 }
        if (r0 == 0) goto L_0x001a;
    L_0x000f:
        r0 = 0;
        r0 = r5.getLong(r0);	 Catch:{ SQLiteException -> 0x0024 }
        if (r5 == 0) goto L_0x0019;
    L_0x0016:
        r5.close();
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = new android.database.sqlite.SQLiteException;	 Catch:{ SQLiteException -> 0x0024 }
        r1 = "Database returned empty set";
        r0.<init>(r1);	 Catch:{ SQLiteException -> 0x0024 }
        throw r0;	 Catch:{ SQLiteException -> 0x0024 }
    L_0x0022:
        r4 = move-exception;
        goto L_0x0033;
    L_0x0024:
        r0 = move-exception;
        goto L_0x002d;
    L_0x0026:
        r4 = move-exception;
        r5 = r0;
        goto L_0x0033;
    L_0x0029:
        r5 = move-exception;
        r2 = r0;
        r0 = r5;
        r5 = r2;
    L_0x002d:
        r1 = "Database error";
        r3.zzd(r1, r4, r0);	 Catch:{ all -> 0x0022 }
        throw r0;	 Catch:{ all -> 0x0022 }
    L_0x0033:
        if (r5 == 0) goto L_0x0038;
    L_0x0035:
        r5.close();
    L_0x0038:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzart.zzc(java.lang.String, java.lang.String[]):long");
    }

    private final Map<String, String> zzef(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String str2 = "?";
                str = String.valueOf(str);
                str = str.length() != 0 ? str2.concat(str) : new String(str2);
            }
            return zzo.zza(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    private final Map<String, String> zzeg(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String str2 = "?";
            str = String.valueOf(str);
            return zzo.zza(new URI(str.length() != 0 ? str2.concat(str) : new String(str2)), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
    private final java.util.List<java.lang.Long> zzn(long r14) {
        /*
        r13 = this;
        com.google.android.gms.analytics.zzk.zzwj();
        r13.zzyk();
        r0 = 0;
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0011;
    L_0x000c:
        r14 = java.util.Collections.emptyList();
        return r14;
    L_0x0011:
        r0 = r13.getWritableDatabase();
        r9 = new java.util.ArrayList;
        r9.<init>();
        r10 = 0;
        r1 = "hits2";
        r2 = "hit_id";
        r2 = new java.lang.String[]{r2};	 Catch:{ SQLiteException -> 0x0062 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "%s ASC";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ SQLiteException -> 0x0062 }
        r11 = "hit_id";
        r12 = 0;
        r8[r12] = r11;	 Catch:{ SQLiteException -> 0x0062 }
        r7 = java.lang.String.format(r7, r8);	 Catch:{ SQLiteException -> 0x0062 }
        r8 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x0062 }
        r14 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0062 }
        r15 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
        if (r15 == 0) goto L_0x0054;
    L_0x0043:
        r0 = r14.getLong(r12);	 Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
        r15 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
        r9.add(r15);	 Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
        r15 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
        if (r15 != 0) goto L_0x0043;
    L_0x0054:
        if (r14 == 0) goto L_0x006d;
    L_0x0056:
        r14.close();
        return r9;
    L_0x005a:
        r15 = move-exception;
        r10 = r14;
        goto L_0x006e;
    L_0x005d:
        r15 = move-exception;
        r10 = r14;
        goto L_0x0063;
    L_0x0060:
        r15 = move-exception;
        goto L_0x006e;
    L_0x0062:
        r15 = move-exception;
    L_0x0063:
        r14 = "Error selecting hit ids";
        r13.zzd(r14, r15);	 Catch:{ all -> 0x0060 }
        if (r10 == 0) goto L_0x006d;
    L_0x006a:
        r10.close();
    L_0x006d:
        return r9;
    L_0x006e:
        if (r10 == 0) goto L_0x0073;
    L_0x0070:
        r10.close();
    L_0x0073:
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzart.zzn(long):java.util.List<java.lang.Long>");
    }

    private final long zzyu() {
        zzk.zzwj();
        zzyk();
        return zzc("SELECT COUNT(*) FROM hits2", null);
    }

    private static String zzzb() {
        return "google_analytics_v4.db";
    }

    public final void beginTransaction() {
        zzyk();
        getWritableDatabase().beginTransaction();
    }

    public final void close() {
        Object e;
        String str;
        try {
            this.zzdzx.close();
        } catch (SQLiteException e2) {
            e = e2;
            str = "Sql error closing database";
            zze(str, e);
        } catch (IllegalStateException e3) {
            e = e3;
            str = "Error closing database";
            zze(str, e);
        }
    }

    public final void endTransaction() {
        zzyk();
        getWritableDatabase().endTransaction();
    }

    final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzdzx.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    @Hide
    final boolean isEmpty() {
        return zzyu() == 0;
    }

    public final void setTransactionSuccessful() {
        zzyk();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(long j, String str, String str2) {
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzyk();
        zzk.zzwj();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public final void zzc(zzasy zzasy) {
        zzbq.checkNotNull(zzasy);
        zzk.zzwj();
        zzyk();
        zzbq.checkNotNull(zzasy);
        Builder builder = new Builder();
        for (Entry entry : zzasy.zzjq().entrySet()) {
            String str = (String) entry.getKey();
            if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str))) {
                builder.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            zzh().zza(zzasy, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = ((Integer) zzast.zzebq.get()).intValue();
        long zzyu = zzyu();
        if (zzyu > ((long) (intValue - 1))) {
            List zzn = zzn((zzyu - ((long) intValue)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzn.size()));
            zzs(zzn);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzasy.zzaan()));
        contentValues.put("hit_app_id", Integer.valueOf(zzasy.zzaal()));
        contentValues.put("hit_url", zzasy.zzaap() ? zzasl.zzaab() : zzasl.zzaac());
        try {
            long insert = writableDatabase.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzee("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzasy);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    public final java.util.List<com.google.android.gms.internal.zzasy> zzo(long r14) {
        /*
        r13 = this;
        r0 = 0;
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        r0 = 0;
        r1 = 1;
        if (r2 < 0) goto L_0x000a;
    L_0x0008:
        r2 = 1;
        goto L_0x000b;
    L_0x000a:
        r2 = 0;
    L_0x000b:
        com.google.android.gms.common.internal.zzbq.checkArgument(r2);
        com.google.android.gms.analytics.zzk.zzwj();
        r13.zzyk();
        r3 = r13.getWritableDatabase();
        r2 = 0;
        r4 = "hits2";
        r5 = "hit_id";
        r6 = "hit_time";
        r7 = "hit_string";
        r8 = "hit_url";
        r9 = "hit_app_id";
        r5 = new java.lang.String[]{r5, r6, r7, r8, r9};	 Catch:{ SQLiteException -> 0x0089 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = "%s ASC";
        r11 = new java.lang.Object[r1];	 Catch:{ SQLiteException -> 0x0089 }
        r12 = "hit_id";
        r11[r0] = r12;	 Catch:{ SQLiteException -> 0x0089 }
        r10 = java.lang.String.format(r10, r11);	 Catch:{ SQLiteException -> 0x0089 }
        r11 = java.lang.Long.toString(r14);	 Catch:{ SQLiteException -> 0x0089 }
        r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x0089 }
        r15 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r15.<init>();	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r2 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        if (r2 == 0) goto L_0x007b;
    L_0x004c:
        r9 = r14.getLong(r0);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r6 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r2 = 2;
        r2 = r14.getString(r2);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r3 = 3;
        r3 = r14.getString(r3);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r4 = 4;
        r11 = r14.getInt(r4);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r5 = r13.zzef(r2);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r8 = com.google.android.gms.internal.zzatt.zzer(r3);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r2 = new com.google.android.gms.internal.zzasy;	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r3 = r2;
        r4 = r13;
        r3.<init>(r4, r5, r6, r8, r9, r11);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r15.add(r2);	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        r2 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0084, all -> 0x0081 }
        if (r2 != 0) goto L_0x004c;
    L_0x007b:
        if (r14 == 0) goto L_0x0080;
    L_0x007d:
        r14.close();
    L_0x0080:
        return r15;
    L_0x0081:
        r15 = move-exception;
        r2 = r14;
        goto L_0x0090;
    L_0x0084:
        r15 = move-exception;
        r2 = r14;
        goto L_0x008a;
    L_0x0087:
        r15 = move-exception;
        goto L_0x0090;
    L_0x0089:
        r15 = move-exception;
    L_0x008a:
        r14 = "Error loading hits from the database";
        r13.zze(r14, r15);	 Catch:{ all -> 0x0087 }
        throw r15;	 Catch:{ all -> 0x0087 }
    L_0x0090:
        if (r2 == 0) goto L_0x0095;
    L_0x0092:
        r2.close();
    L_0x0095:
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzart.zzo(long):java.util.List<com.google.android.gms.internal.zzasy>");
    }

    public final void zzp(long j) {
        zzk.zzwj();
        zzyk();
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzs(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    public final java.util.List<com.google.android.gms.internal.zzarn> zzq(long r12) {
        /*
        r11 = this;
        r11.zzyk();
        com.google.android.gms.analytics.zzk.zzwj();
        r0 = r11.getWritableDatabase();
        r12 = 0;
        r13 = "cid";
        r1 = "tid";
        r2 = "adid";
        r3 = "hits_count";
        r4 = "params";
        r2 = new java.lang.String[]{r13, r1, r2, r3, r4};	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r13 = com.google.android.gms.internal.zzast.zzebs;	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r13 = r13.get();	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r13 = (java.lang.Integer) r13;	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r13 = r13.intValue();	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r8 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r3 = "app_uid=?";
        r1 = "0";
        r4 = new java.lang.String[]{r1};	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r1 = "properties";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00a3, all -> 0x009f }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x009d }
        r12.<init>();	 Catch:{ SQLiteException -> 0x009d }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x009d }
        if (r1 == 0) goto L_0x008c;
    L_0x0045:
        r1 = 0;
        r5 = r0.getString(r1);	 Catch:{ SQLiteException -> 0x009d }
        r2 = 1;
        r6 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x009d }
        r3 = 2;
        r3 = r0.getInt(r3);	 Catch:{ SQLiteException -> 0x009d }
        if (r3 == 0) goto L_0x0058;
    L_0x0056:
        r7 = 1;
        goto L_0x0059;
    L_0x0058:
        r7 = 0;
    L_0x0059:
        r1 = 3;
        r1 = r0.getInt(r1);	 Catch:{ SQLiteException -> 0x009d }
        r8 = (long) r1;	 Catch:{ SQLiteException -> 0x009d }
        r1 = 4;
        r1 = r0.getString(r1);	 Catch:{ SQLiteException -> 0x009d }
        r10 = r11.zzeg(r1);	 Catch:{ SQLiteException -> 0x009d }
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteException -> 0x009d }
        if (r1 != 0) goto L_0x0081;
    L_0x006e:
        r1 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SQLiteException -> 0x009d }
        if (r1 == 0) goto L_0x0075;
    L_0x0074:
        goto L_0x0081;
    L_0x0075:
        r1 = new com.google.android.gms.internal.zzarn;	 Catch:{ SQLiteException -> 0x009d }
        r3 = 0;
        r2 = r1;
        r2.<init>(r3, r5, r6, r7, r8, r10);	 Catch:{ SQLiteException -> 0x009d }
        r12.add(r1);	 Catch:{ SQLiteException -> 0x009d }
        goto L_0x0086;
    L_0x0081:
        r1 = "Read property with empty client id or tracker id";
        r11.zzc(r1, r5, r6);	 Catch:{ SQLiteException -> 0x009d }
    L_0x0086:
        r1 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x009d }
        if (r1 != 0) goto L_0x0045;
    L_0x008c:
        r1 = r12.size();	 Catch:{ SQLiteException -> 0x009d }
        if (r1 < r13) goto L_0x0097;
    L_0x0092:
        r13 = "Sending hits to too many properties. Campaign report might be incorrect";
        r11.zzed(r13);	 Catch:{ SQLiteException -> 0x009d }
    L_0x0097:
        if (r0 == 0) goto L_0x009c;
    L_0x0099:
        r0.close();
    L_0x009c:
        return r12;
    L_0x009d:
        r12 = move-exception;
        goto L_0x00a6;
    L_0x009f:
        r13 = move-exception;
        r0 = r12;
        r12 = r13;
        goto L_0x00ad;
    L_0x00a3:
        r13 = move-exception;
        r0 = r12;
        r12 = r13;
    L_0x00a6:
        r13 = "Error loading hits from the database";
        r11.zze(r13, r12);	 Catch:{ all -> 0x00ac }
        throw r12;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r12 = move-exception;
    L_0x00ad:
        if (r0 == 0) goto L_0x00b2;
    L_0x00af:
        r0.close();
    L_0x00b2:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzart.zzq(long):java.util.List<com.google.android.gms.internal.zzarn>");
    }

    public final void zzs(List<Long> list) {
        zzbq.checkNotNull(list);
        zzk.zzwj();
        zzyk();
        if (!list.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder("hit_id");
            stringBuilder.append(" in (");
            for (i = 0; i < list.size(); i++) {
                Long l = (Long) list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(l);
            }
            stringBuilder.append(")");
            String stringBuilder2 = stringBuilder.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                i = writableDatabase.delete("hits2", stringBuilder2, null);
                if (i != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(i), stringBuilder2);
                }
            } catch (SQLiteException e) {
                zze("Error deleting hits", e);
                throw e;
            }
        }
    }

    protected final void zzwk() {
    }

    public final int zzyz() {
        zzk.zzwj();
        zzyk();
        if (!this.zzdzy.zzu(86400000)) {
            return 0;
        }
        this.zzdzy.start();
        zzea("Deleting stale hits (if any)");
        long currentTimeMillis = zzxx().currentTimeMillis() - 2592000000L;
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(currentTimeMillis)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long zzza() {
        zzk.zzwj();
        zzyk();
        return zza(zzdzw, null, 0);
    }
}
