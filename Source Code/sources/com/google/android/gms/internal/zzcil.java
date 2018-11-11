package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzcil extends zzcli {
    private static final String[] zzjgw = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzjgx = new String[]{b.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzjgy = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;"};
    private static final String[] zzjgz = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzjha = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;"};
    private static final String[] zzjhb = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzcio zzjhc = new zzcio(this, getContext(), "google_app_measurement.db");
    private final zzcni zzjhd = new zzcni(zzxx());

    zzcil(zzckj zzckj) {
        super(zzckj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039  */
    @android.support.annotation.WorkerThread
    private final long zza(java.lang.String r3, java.lang.String[] r4, long r5) {
        /*
        r2 = this;
        r0 = r2.getWritableDatabase();
        r1 = 0;
        r4 = r0.rawQuery(r3, r4);	 Catch:{ SQLiteException -> 0x0028 }
        r0 = r4.moveToFirst();	 Catch:{ SQLiteException -> 0x0023, all -> 0x0020 }
        if (r0 == 0) goto L_0x001a;
    L_0x000f:
        r5 = 0;
        r5 = r4.getLong(r5);	 Catch:{ SQLiteException -> 0x0023, all -> 0x0020 }
        if (r4 == 0) goto L_0x0019;
    L_0x0016:
        r4.close();
    L_0x0019:
        return r5;
    L_0x001a:
        if (r4 == 0) goto L_0x001f;
    L_0x001c:
        r4.close();
    L_0x001f:
        return r5;
    L_0x0020:
        r3 = move-exception;
        r1 = r4;
        goto L_0x0037;
    L_0x0023:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0029;
    L_0x0026:
        r3 = move-exception;
        goto L_0x0037;
    L_0x0028:
        r5 = move-exception;
    L_0x0029:
        r4 = r2.zzayp();	 Catch:{ all -> 0x0026 }
        r4 = r4.zzbau();	 Catch:{ all -> 0x0026 }
        r6 = "Database error";
        r4.zze(r6, r3, r5);	 Catch:{ all -> 0x0026 }
        throw r5;	 Catch:{ all -> 0x0026 }
    L_0x0037:
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.close();
    L_0x003c:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zza(java.lang.String, java.lang.String[], long):long");
    }

    @WorkerThread
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzayp().zzbau().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzayp().zzbau().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzayp().zzbau().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        zzbq.zzgv(str);
        zzbq.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzcjj zzcjj, SQLiteDatabase sQLiteDatabase) {
        if (zzcjj == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzcjj.zzbaw().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzcjj.zzbaw().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzcjj.zzbaw().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzcjj.zzbaw().log("Failed to turn on database write permission for owner");
        }
    }

    @WorkerThread
    static void zza(zzcjj zzcjj, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (zzcjj == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzcjj, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            zza(zzcjj, sQLiteDatabase, str, str3, strArr);
        } catch (SQLiteException e) {
            zzcjj.zzbau().zzj("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    @WorkerThread
    private static void zza(zzcjj zzcjj, SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (zzcjj == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Iterable zzb = zzb(sQLiteDatabase, str);
        String[] split = str2.split(",");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str3 = split[i];
            if (zzb.remove(str3)) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length());
                stringBuilder.append("Table ");
                stringBuilder.append(str);
                stringBuilder.append(" is missing required column: ");
                stringBuilder.append(str3);
                throw new SQLiteException(stringBuilder.toString());
            }
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                if (!zzb.remove(strArr[i2])) {
                    sQLiteDatabase.execSQL(strArr[i2 + 1]);
                }
            }
        }
        if (!zzb.isEmpty()) {
            zzcjj.zzbaw().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    @android.support.annotation.WorkerThread
    private static boolean zza(com.google.android.gms.internal.zzcjj r11, android.database.sqlite.SQLiteDatabase r12, java.lang.String r13) {
        /*
        if (r11 != 0) goto L_0x000a;
    L_0x0002:
        r11 = new java.lang.IllegalArgumentException;
        r12 = "Monitor must not be null";
        r11.<init>(r12);
        throw r11;
    L_0x000a:
        r0 = 0;
        r1 = 0;
        r3 = "SQLITE_MASTER";
        r2 = "name";
        r4 = new java.lang.String[]{r2};	 Catch:{ SQLiteException -> 0x0037 }
        r5 = "name=?";
        r2 = 1;
        r6 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x0037 }
        r6[r1] = r13;	 Catch:{ SQLiteException -> 0x0037 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r2 = r12;
        r12 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x0037 }
        r0 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x0030, all -> 0x002d }
        if (r12 == 0) goto L_0x002c;
    L_0x0029:
        r12.close();
    L_0x002c:
        return r0;
    L_0x002d:
        r11 = move-exception;
        r0 = r12;
        goto L_0x0047;
    L_0x0030:
        r0 = move-exception;
        r10 = r0;
        r0 = r12;
        r12 = r10;
        goto L_0x0038;
    L_0x0035:
        r11 = move-exception;
        goto L_0x0047;
    L_0x0037:
        r12 = move-exception;
    L_0x0038:
        r11 = r11.zzbaw();	 Catch:{ all -> 0x0035 }
        r2 = "Error querying for table";
        r11.zze(r2, r13, r12);	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0046;
    L_0x0043:
        r0.close();
    L_0x0046:
        return r1;
    L_0x0047:
        if (r0 == 0) goto L_0x004c;
    L_0x0049:
        r0.close();
    L_0x004c:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zza(com.google.android.gms.internal.zzcjj, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzcns zzcns) {
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        zzbq.checkNotNull(zzcns);
        if (TextUtils.isEmpty(zzcns.zzjsy)) {
            zzayp().zzbaw().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzcjj.zzjs(str), Integer.valueOf(i), String.valueOf(zzcns.zzjsx));
            return false;
        }
        try {
            byte[] bArr = new byte[zzcns.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcns.zza(zzp);
            zzp.zzcyx();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzcns.zzjsx);
            contentValues.put("event_name", zzcns.zzjsy);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzayp().zzbau().zzj("Failed to insert event filter (got -1). appId", zzcjj.zzjs(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzayp().zzbau().zze("Error storing event filter. appId", zzcjj.zzjs(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzayp().zzbau().zze("Configuration loss. Failed to serialize event filter. appId", zzcjj.zzjs(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzcnv zzcnv) {
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        zzbq.checkNotNull(zzcnv);
        if (TextUtils.isEmpty(zzcnv.zzjtn)) {
            zzayp().zzbaw().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzcjj.zzjs(str), Integer.valueOf(i), String.valueOf(zzcnv.zzjsx));
            return false;
        }
        try {
            byte[] bArr = new byte[zzcnv.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcnv.zza(zzp);
            zzp.zzcyx();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzcnv.zzjsx);
            contentValues.put("property_name", zzcnv.zzjtn);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzayp().zzbau().zzj("Failed to insert property filter (got -1). appId", zzcjj.zzjs(str));
                return false;
            } catch (SQLiteException e) {
                zzayp().zzbau().zze("Error storing property filter. appId", zzcjj.zzjs(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzayp().zzbau().zze("Configuration loss. Failed to serialize property filter. appId", zzcjj.zzjs(str), e2);
            return false;
        }
    }

    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        Object hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zzbae() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
    @android.support.annotation.WorkerThread
    private final long zzc(java.lang.String r4, java.lang.String[] r5) {
        /*
        r3 = this;
        r0 = r3.getWritableDatabase();
        r1 = 0;
        r5 = r0.rawQuery(r4, r5);	 Catch:{ SQLiteException -> 0x002a }
        r0 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
        if (r0 == 0) goto L_0x001a;
    L_0x000f:
        r0 = 0;
        r0 = r5.getLong(r0);	 Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
        if (r5 == 0) goto L_0x0019;
    L_0x0016:
        r5.close();
    L_0x0019:
        return r0;
    L_0x001a:
        r0 = new android.database.sqlite.SQLiteException;	 Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
        r1 = "Database returned empty set";
        r0.<init>(r1);	 Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
        throw r0;	 Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
    L_0x0022:
        r4 = move-exception;
        goto L_0x0039;
    L_0x0024:
        r0 = move-exception;
        r1 = r5;
        goto L_0x002b;
    L_0x0027:
        r4 = move-exception;
        r5 = r1;
        goto L_0x0039;
    L_0x002a:
        r0 = move-exception;
    L_0x002b:
        r5 = r3.zzayp();	 Catch:{ all -> 0x0027 }
        r5 = r5.zzbau();	 Catch:{ all -> 0x0027 }
        r2 = "Database error";
        r5.zze(r2, r4, r0);	 Catch:{ all -> 0x0027 }
        throw r0;	 Catch:{ all -> 0x0027 }
    L_0x0039:
        if (r5 == 0) goto L_0x003e;
    L_0x003b:
        r5.close();
    L_0x003e:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzc(java.lang.String, java.lang.String[]):long");
    }

    private final boolean zze(String str, List<Integer> list) {
        zzbq.zzgv(str);
        zzyk();
        zzwj();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (zzc("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, zzayr().zzb(str, zzciz.zzjjs))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(join).length() + 2);
            stringBuilder.append("(");
            stringBuilder.append(join);
            stringBuilder.append(")");
            join = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(join).length() + 140);
            stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            stringBuilder2.append(join);
            stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", stringBuilder2.toString(), new String[]{str, Integer.toString(r2)}) > 0;
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Database error querying filters. appId", zzcjj.zzjs(str), e);
            return false;
        }
    }

    @WorkerThread
    public final void beginTransaction() {
        zzyk();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void endTransaction() {
        zzyk();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    final SQLiteDatabase getWritableDatabase() {
        zzwj();
        try {
            return this.zzjhc.getWritableDatabase();
        } catch (SQLiteException e) {
            zzayp().zzbaw().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzyk();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzcoe zzcoe) {
        zzwj();
        zzyk();
        zzbq.checkNotNull(zzcoe);
        zzbq.zzgv(zzcoe.zzcm);
        try {
            long j;
            Object obj = new byte[zzcoe.zzhs()];
            zzflk zzp = zzflk.zzp(obj, 0, obj.length);
            zzcoe.zza(zzp);
            zzp.zzcyx();
            zzclh zzayl = zzayl();
            zzbq.checkNotNull(obj);
            zzayl.zzwj();
            MessageDigest zzeq = zzcno.zzeq("MD5");
            if (zzeq == null) {
                zzayl.zzayp().zzbau().log("Failed to get MD5");
                j = 0;
            } else {
                j = zzcno.zzt(zzeq.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcoe.zzcm);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzayp().zzbau().zze("Error storing raw event metadata. appId", zzcjj.zzjs(zzcoe.zzcm), e);
                throw e;
            }
        } catch (IOException e2) {
            zzayp().zzbau().zze("Data loss. Failed to serialize event metadata. appId", zzcjj.zzjs(zzcoe.zzcm), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.zzcim zza(long r18, java.lang.String r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25) {
        /*
        r17 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r20);
        r17.zzwj();
        r17.zzyk();
        r2 = 1;
        r3 = new java.lang.String[r2];
        r4 = 0;
        r3[r4] = r20;
        r5 = new com.google.android.gms.internal.zzcim;
        r5.<init>();
        r6 = 0;
        r15 = r17.getWritableDatabase();	 Catch:{ SQLiteException -> 0x010c }
        r8 = "apps";
        r9 = "day";
        r10 = "daily_events_count";
        r11 = "daily_public_events_count";
        r12 = "daily_conversions_count";
        r13 = "daily_error_events_count";
        r14 = "daily_realtime_events_count";
        r9 = new java.lang.String[]{r9, r10, r11, r12, r13, r14};	 Catch:{ SQLiteException -> 0x010c }
        r10 = "app_id=?";
        r11 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x010c }
        r11[r4] = r20;	 Catch:{ SQLiteException -> 0x010c }
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r7 = r15;
        r7 = r7.query(r8, r9, r10, r11, r12, r13, r14);	 Catch:{ SQLiteException -> 0x010c }
        r6 = r7.moveToFirst();	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        if (r6 != 0) goto L_0x0056;
    L_0x003f:
        r2 = r17.zzayp();	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = r2.zzbaw();	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r3 = "Not updating daily counts, app is not known. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r20);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2.zzj(r3, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        if (r7 == 0) goto L_0x0055;
    L_0x0052:
        r7.close();
    L_0x0055:
        return r5;
    L_0x0056:
        r8 = r7.getLong(r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1));
        if (r4 != 0) goto L_0x0080;
    L_0x005e:
        r8 = r7.getLong(r2);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r5.zzjhf = r8;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = 2;
        r8 = r7.getLong(r2);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r5.zzjhe = r8;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = 3;
        r8 = r7.getLong(r2);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r5.zzjhg = r8;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = 4;
        r8 = r7.getLong(r2);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r5.zzjhh = r8;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = 5;
        r8 = r7.getLong(r2);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r5.zzjhi = r8;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x0080:
        r8 = 1;
        if (r21 == 0) goto L_0x008b;
    L_0x0084:
        r12 = r5.zzjhf;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = 0;
        r1 = r12 + r8;
        r5.zzjhf = r1;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x008b:
        if (r22 == 0) goto L_0x0094;
    L_0x008d:
        r1 = r5.zzjhe;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = 0;
        r12 = r1 + r8;
        r5.zzjhe = r12;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x0094:
        if (r23 == 0) goto L_0x009d;
    L_0x0096:
        r1 = r5.zzjhg;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = 0;
        r12 = r1 + r8;
        r5.zzjhg = r12;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x009d:
        if (r24 == 0) goto L_0x00a6;
    L_0x009f:
        r1 = r5.zzjhh;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = 0;
        r12 = r1 + r8;
        r5.zzjhh = r12;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x00a6:
        if (r25 == 0) goto L_0x00af;
    L_0x00a8:
        r1 = r5.zzjhi;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = 0;
        r12 = r1 + r8;
        r5.zzjhi = r12;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
    L_0x00af:
        r1 = new android.content.ContentValues;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "day";
        r4 = java.lang.Long.valueOf(r18);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "daily_public_events_count";
        r8 = r5.zzjhe;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "daily_events_count";
        r8 = r5.zzjhf;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "daily_conversions_count";
        r8 = r5.zzjhg;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "daily_error_events_count";
        r8 = r5.zzjhh;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "daily_realtime_events_count";
        r8 = r5.zzjhi;	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        r2 = "apps";
        r4 = "app_id=?";
        r15.update(r2, r1, r4, r3);	 Catch:{ SQLiteException -> 0x0104, all -> 0x0101 }
        if (r7 == 0) goto L_0x0100;
    L_0x00fd:
        r7.close();
    L_0x0100:
        return r5;
    L_0x0101:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0125;
    L_0x0104:
        r0 = move-exception;
        r1 = r0;
        r6 = r7;
        goto L_0x010e;
    L_0x0108:
        r0 = move-exception;
        r1 = r0;
        r7 = r6;
        goto L_0x0125;
    L_0x010c:
        r0 = move-exception;
        r1 = r0;
    L_0x010e:
        r2 = r17.zzayp();	 Catch:{ all -> 0x0108 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x0108 }
        r3 = "Error updating daily counts. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r20);	 Catch:{ all -> 0x0108 }
        r2.zze(r3, r4, r1);	 Catch:{ all -> 0x0108 }
        if (r6 == 0) goto L_0x0124;
    L_0x0121:
        r6.close();
    L_0x0124:
        return r5;
    L_0x0125:
        if (r7 == 0) goto L_0x012a;
    L_0x0127:
        r7.close();
    L_0x012a:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.zzcim");
    }

    @WorkerThread
    public final void zza(zzcie zzcie) {
        zzbq.checkNotNull(zzcie);
        zzwj();
        zzyk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcie.getAppId());
        contentValues.put("app_instance_id", zzcie.getAppInstanceId());
        contentValues.put("gmp_app_id", zzcie.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzcie.zzayt());
        contentValues.put("last_bundle_index", Long.valueOf(zzcie.zzazc()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzcie.zzayv()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzcie.zzayw()));
        contentValues.put("app_version", zzcie.zzwo());
        contentValues.put("app_store", zzcie.zzayy());
        contentValues.put("gmp_version", Long.valueOf(zzcie.zzayz()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzcie.zzaza()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzcie.zzazb()));
        contentValues.put("day", Long.valueOf(zzcie.zzazg()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzcie.zzazh()));
        contentValues.put("daily_events_count", Long.valueOf(zzcie.zzazi()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzcie.zzazj()));
        contentValues.put("config_fetched_time", Long.valueOf(zzcie.zzazd()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzcie.zzaze()));
        contentValues.put("app_version_int", Long.valueOf(zzcie.zzayx()));
        contentValues.put("firebase_instance_id", zzcie.zzayu());
        contentValues.put("daily_error_events_count", Long.valueOf(zzcie.zzazl()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzcie.zzazk()));
        contentValues.put("health_monitor_sample", zzcie.zzazm());
        contentValues.put("android_id", Long.valueOf(zzcie.zzazo()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzcie.zzazp()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzcie.getAppId()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzayp().zzbau().zzj("Failed to insert/update app (got -1). appId", zzcjj.zzjs(zzcie.getAppId()));
            }
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Error storing app. appId", zzcjj.zzjs(zzcie.getAppId()), e);
        }
    }

    @WorkerThread
    public final void zza(zzcit zzcit) {
        zzbq.checkNotNull(zzcit);
        zzwj();
        zzyk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcit.zzcm);
        contentValues.put("name", zzcit.name);
        contentValues.put("lifetime_count", Long.valueOf(zzcit.zzjhs));
        contentValues.put("current_bundle_count", Long.valueOf(zzcit.zzjht));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzcit.zzjhu));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzcit.zzjhv));
        contentValues.put("last_sampled_complex_event_id", zzcit.zzjhw);
        contentValues.put("last_sampling_rate", zzcit.zzjhx);
        Long valueOf = (zzcit.zzjhy == null || !zzcit.zzjhy.booleanValue()) ? null : Long.valueOf(1);
        contentValues.put("last_exempt_from_sampling", valueOf);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzayp().zzbau().zzj("Failed to insert/update event aggregates (got -1). appId", zzcjj.zzjs(zzcit.zzcm));
            }
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Error storing event aggregates. appId", zzcjj.zzjs(zzcit.zzcm), e);
        }
    }

    @WorkerThread
    final void zza(String str, zzcnr[] zzcnrArr) {
        zzyk();
        zzwj();
        zzbq.zzgv(str);
        zzbq.checkNotNull(zzcnrArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzyk();
            zzwj();
            zzbq.zzgv(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            String[] strArr = new String[1];
            int i = 0;
            strArr[0] = str;
            writableDatabase2.delete("property_filters", "app_id=?", strArr);
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzcnr zzcnr : zzcnrArr) {
                zzyk();
                zzwj();
                zzbq.zzgv(str);
                zzbq.checkNotNull(zzcnr);
                zzbq.checkNotNull(zzcnr.zzjsv);
                zzbq.checkNotNull(zzcnr.zzjsu);
                if (zzcnr.zzjst == null) {
                    zzayp().zzbaw().zzj("Audience with no ID. appId", zzcjj.zzjs(str));
                } else {
                    zzcjl zzbaw;
                    String str2;
                    Object zzjs;
                    Object obj;
                    Object obj2;
                    int intValue = zzcnr.zzjst.intValue();
                    for (zzcns zzcns : zzcnr.zzjsv) {
                        if (zzcns.zzjsx == null) {
                            zzbaw = zzayp().zzbaw();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            zzjs = zzcjj.zzjs(str);
                            obj = zzcnr.zzjst;
                            break;
                        }
                    }
                    for (zzcnv zzcnv : zzcnr.zzjsu) {
                        if (zzcnv.zzjsx == null) {
                            zzbaw = zzayp().zzbaw();
                            str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                            zzjs = zzcjj.zzjs(str);
                            obj = zzcnr.zzjst;
                            zzbaw.zze(str2, zzjs, obj);
                            break;
                        }
                    }
                    for (zzcns zzcns2 : zzcnr.zzjsv) {
                        if (!zza(str, intValue, zzcns2)) {
                            obj2 = null;
                            break;
                        }
                    }
                    obj2 = 1;
                    if (obj2 != null) {
                        for (zzcnv zzcnv2 : zzcnr.zzjsu) {
                            if (!zza(str, intValue, zzcnv2)) {
                                obj2 = null;
                                break;
                            }
                        }
                    }
                    if (obj2 == null) {
                        zzyk();
                        zzwj();
                        zzbq.zzgv(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            int length = zzcnrArr.length;
            while (i < length) {
                arrayList.add(zzcnrArr[i].zzjst);
                i++;
            }
            zze(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public final boolean zza(zzcii zzcii) {
        zzbq.checkNotNull(zzcii);
        zzwj();
        zzyk();
        if (zzag(zzcii.packageName, zzcii.zzjgn.name) == null) {
            if (zzc("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzcii.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcii.packageName);
        contentValues.put(b.ORIGIN, zzcii.zzjgm);
        contentValues.put("name", zzcii.zzjgn.name);
        zza(contentValues, b.VALUE, zzcii.zzjgn.getValue());
        contentValues.put("active", Boolean.valueOf(zzcii.zzjgp));
        contentValues.put("trigger_event_name", zzcii.zzjgq);
        contentValues.put("trigger_timeout", Long.valueOf(zzcii.zzjgs));
        zzayl();
        contentValues.put("timed_out_event", zzcno.zza(zzcii.zzjgr));
        contentValues.put("creation_timestamp", Long.valueOf(zzcii.zzjgo));
        zzayl();
        contentValues.put("triggered_event", zzcno.zza(zzcii.zzjgt));
        contentValues.put("triggered_timestamp", Long.valueOf(zzcii.zzjgn.zzjsi));
        contentValues.put("time_to_live", Long.valueOf(zzcii.zzjgu));
        zzayl();
        contentValues.put("expired_event", zzcno.zza(zzcii.zzjgv));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzayp().zzbau().zzj("Failed to insert/update conditional user property (got -1)", zzcjj.zzjs(zzcii.packageName));
                return true;
            }
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Error storing conditional user property", zzcjj.zzjs(zzcii.packageName), e);
        }
        return true;
    }

    public final boolean zza(zzcis zzcis, long j, boolean z) {
        Object e;
        zzcjl zzbau;
        String str;
        zzwj();
        zzyk();
        zzbq.checkNotNull(zzcis);
        zzbq.zzgv(zzcis.zzcm);
        zzfls zzcob = new zzcob();
        zzcob.zzjuk = Long.valueOf(zzcis.zzjhq);
        zzcob.zzjui = new zzcoc[zzcis.zzjhr.size()];
        Iterator it = zzcis.zzjhr.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            zzcoc zzcoc = new zzcoc();
            int i2 = i + 1;
            zzcob.zzjui[i] = zzcoc;
            zzcoc.name = str2;
            zzayl().zza(zzcoc, zzcis.zzjhr.get(str2));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzcob.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcob.zza(zzp);
            zzp.zzcyx();
            zzayp().zzbba().zze("Saving event, name, data size", zzayk().zzjp(zzcis.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcis.zzcm);
            contentValues.put("name", zzcis.name);
            contentValues.put(Param.TIMESTAMP, Long.valueOf(zzcis.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzayp().zzbau().zzj("Failed to insert raw event (got -1). appId", zzcjj.zzjs(zzcis.zzcm));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzbau = zzayp().zzbau();
                str = "Error storing raw event. appId";
                zzbau.zze(str, zzcjj.zzjs(zzcis.zzcm), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzbau = zzayp().zzbau();
            str = "Data loss. Failed to serialize event params/data. appId";
            zzbau.zze(str, zzcjj.zzjs(zzcis.zzcm), e);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzcnn zzcnn) {
        zzbq.checkNotNull(zzcnn);
        zzwj();
        zzyk();
        if (zzag(zzcnn.zzcm, zzcnn.name) == null) {
            if (zzcno.zzkh(zzcnn.name)) {
                if (zzc("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzcnn.zzcm}) >= 25) {
                    return false;
                }
            }
            if (zzc("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzcnn.zzcm, zzcnn.zzjgm}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzcnn.zzcm);
        contentValues.put(b.ORIGIN, zzcnn.zzjgm);
        contentValues.put("name", zzcnn.name);
        contentValues.put("set_timestamp", Long.valueOf(zzcnn.zzjsi));
        zza(contentValues, b.VALUE, zzcnn.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzayp().zzbau().zzj("Failed to insert/update user property (got -1). appId", zzcjj.zzjs(zzcnn.zzcm));
                return true;
            }
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Error storing user property. appId", zzcjj.zzjs(zzcnn.zzcm), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzcoe zzcoe, boolean z) {
        Object e;
        zzcjl zzbau;
        String str;
        zzwj();
        zzyk();
        zzbq.checkNotNull(zzcoe);
        zzbq.zzgv(zzcoe.zzcm);
        zzbq.checkNotNull(zzcoe.zzjuu);
        zzazy();
        long currentTimeMillis = zzxx().currentTimeMillis();
        if (zzcoe.zzjuu.longValue() < currentTimeMillis - zzcik.zzazs() || zzcoe.zzjuu.longValue() > currentTimeMillis + zzcik.zzazs()) {
            zzayp().zzbaw().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzcjj.zzjs(zzcoe.zzcm), Long.valueOf(currentTimeMillis), zzcoe.zzjuu);
        }
        try {
            byte[] bArr = new byte[zzcoe.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcoe.zza(zzp);
            zzp.zzcyx();
            bArr = zzayl().zzr(bArr);
            zzayp().zzbba().zzj("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzcoe.zzcm);
            contentValues.put("bundle_end_timestamp", zzcoe.zzjuu);
            contentValues.put("data", bArr);
            contentValues.put("has_realtime", Integer.valueOf(z));
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzayp().zzbau().zzj("Failed to insert bundle (got -1). appId", zzcjj.zzjs(zzcoe.zzcm));
                return false;
            } catch (SQLiteException e2) {
                e = e2;
                zzbau = zzayp().zzbau();
                str = "Error storing bundle. appId";
                zzbau.zze(str, zzcjj.zzjs(zzcoe.zzcm), e);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            zzbau = zzayp().zzbau();
            str = "Data loss. Failed to serialize bundle. appId";
            zzbau.zze(str, zzcjj.zzjs(zzcoe.zzcm), e);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzcob zzcob) {
        zzwj();
        zzyk();
        zzbq.checkNotNull(zzcob);
        zzbq.zzgv(str);
        zzbq.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzcob.zzhs()];
            zzflk zzp = zzflk.zzp(bArr, 0, bArr.length);
            zzcob.zza(zzp);
            zzp.zzcyx();
            zzayp().zzbba().zze("Saving complex main event, appId, data size", zzayk().zzjp(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzayp().zzbau().zzj("Failed to insert complex main event (got -1). appId", zzcjj.zzjs(str));
                return false;
            } catch (SQLiteException e) {
                zzayp().zzbau().zze("Error storing complex main event. appId", zzcjj.zzjs(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzayp().zzbau().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzcjj.zzjs(str), l, e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.zzcit zzae(java.lang.String r23, java.lang.String r24) {
        /*
        r22 = this;
        r15 = r24;
        com.google.android.gms.common.internal.zzbq.zzgv(r23);
        com.google.android.gms.common.internal.zzbq.zzgv(r24);
        r22.zzwj();
        r22.zzyk();
        r16 = 0;
        r1 = r22.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r2 = "events";
        r3 = "lifetime_count";
        r4 = "current_bundle_count";
        r5 = "last_fire_timestamp";
        r6 = "last_bundled_timestamp";
        r7 = "last_sampled_complex_event_id";
        r8 = "last_sampling_rate";
        r9 = "last_exempt_from_sampling";
        r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9};	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r4 = "app_id=? and name=?";
        r9 = 2;
        r5 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r10 = 0;
        r5[r10] = r23;	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r11 = 1;
        r5[r11] = r15;	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00ec, all -> 0x00e7 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        if (r1 != 0) goto L_0x0046;
    L_0x0040:
        if (r14 == 0) goto L_0x0045;
    L_0x0042:
        r14.close();
    L_0x0045:
        return r16;
    L_0x0046:
        r4 = r14.getLong(r10);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r6 = r14.getLong(r11);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r8 = r14.getLong(r9);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r1 = 3;
        r2 = r14.isNull(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        if (r2 == 0) goto L_0x005d;
    L_0x0059:
        r1 = 0;
    L_0x005b:
        r12 = r1;
        goto L_0x0062;
    L_0x005d:
        r1 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        goto L_0x005b;
    L_0x0062:
        r1 = 4;
        r2 = r14.isNull(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        if (r2 == 0) goto L_0x006c;
    L_0x0069:
        r17 = r16;
        goto L_0x0076;
    L_0x006c:
        r1 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r17 = r1;
    L_0x0076:
        r1 = 5;
        r2 = r14.isNull(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        if (r2 == 0) goto L_0x0080;
    L_0x007d:
        r18 = r16;
        goto L_0x008a;
    L_0x0080:
        r1 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r18 = r1;
    L_0x008a:
        r1 = 6;
        r2 = r14.isNull(r1);	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        if (r2 != 0) goto L_0x00ad;
    L_0x0091:
        r1 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x00a9, all -> 0x00a4 }
        r19 = 1;
        r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1));
        if (r3 != 0) goto L_0x009c;
    L_0x009b:
        goto L_0x009d;
    L_0x009c:
        r11 = 0;
    L_0x009d:
        r1 = java.lang.Boolean.valueOf(r11);	 Catch:{ SQLiteException -> 0x00a9, all -> 0x00a4 }
        r19 = r1;
        goto L_0x00af;
    L_0x00a4:
        r0 = move-exception;
        r1 = r0;
        r15 = r14;
        goto L_0x0113;
    L_0x00a9:
        r0 = move-exception;
        r1 = r0;
        r15 = r14;
        goto L_0x00f0;
    L_0x00ad:
        r19 = r16;
    L_0x00af:
        r20 = new com.google.android.gms.internal.zzcit;	 Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
        r1 = r20;
        r2 = r23;
        r3 = r15;
        r10 = r12;
        r12 = r17;
        r13 = r18;
        r15 = r14;
        r14 = r19;
        r1.<init>(r2, r3, r4, r6, r8, r10, r12, r13, r14);	 Catch:{ SQLiteException -> 0x00de }
        r1 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x00de }
        if (r1 == 0) goto L_0x00d8;
    L_0x00c7:
        r1 = r22.zzayp();	 Catch:{ SQLiteException -> 0x00de }
        r1 = r1.zzbau();	 Catch:{ SQLiteException -> 0x00de }
        r2 = "Got multiple records for event aggregates, expected one. appId";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r23);	 Catch:{ SQLiteException -> 0x00de }
        r1.zzj(r2, r3);	 Catch:{ SQLiteException -> 0x00de }
    L_0x00d8:
        if (r15 == 0) goto L_0x00dd;
    L_0x00da:
        r15.close();
    L_0x00dd:
        return r20;
    L_0x00de:
        r0 = move-exception;
        goto L_0x00e5;
    L_0x00e0:
        r0 = move-exception;
        r15 = r14;
        goto L_0x0112;
    L_0x00e3:
        r0 = move-exception;
        r15 = r14;
    L_0x00e5:
        r1 = r0;
        goto L_0x00f0;
    L_0x00e7:
        r0 = move-exception;
        r1 = r0;
        r15 = r16;
        goto L_0x0113;
    L_0x00ec:
        r0 = move-exception;
        r1 = r0;
        r15 = r16;
    L_0x00f0:
        r2 = r22.zzayp();	 Catch:{ all -> 0x0111 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x0111 }
        r3 = "Error querying events. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r23);	 Catch:{ all -> 0x0111 }
        r5 = r22.zzayk();	 Catch:{ all -> 0x0111 }
        r6 = r24;
        r5 = r5.zzjp(r6);	 Catch:{ all -> 0x0111 }
        r2.zzd(r3, r4, r5, r1);	 Catch:{ all -> 0x0111 }
        if (r15 == 0) goto L_0x0110;
    L_0x010d:
        r15.close();
    L_0x0110:
        return r16;
    L_0x0111:
        r0 = move-exception;
    L_0x0112:
        r1 = r0;
    L_0x0113:
        if (r15 == 0) goto L_0x0118;
    L_0x0115:
        r15.close();
    L_0x0118:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzae(java.lang.String, java.lang.String):com.google.android.gms.internal.zzcit");
    }

    @WorkerThread
    public final void zzaf(String str, String str2) {
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzwj();
        zzyk();
        try {
            zzayp().zzbba().zzj("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzayp().zzbau().zzd("Error deleting user attribute. appId", zzcjj.zzjs(str), zzayk().zzjr(str2), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.zzcnn zzag(java.lang.String r20, java.lang.String r21) {
        /*
        r19 = this;
        r8 = r21;
        com.google.android.gms.common.internal.zzbq.zzgv(r20);
        com.google.android.gms.common.internal.zzbq.zzgv(r21);
        r19.zzwj();
        r19.zzyk();
        r9 = 0;
        r10 = r19.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r11 = "user_attributes";
        r1 = "set_timestamp";
        r2 = "value";
        r3 = "origin";
        r12 = new java.lang.String[]{r1, r2, r3};	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r13 = "app_id=? and name=?";
        r1 = 2;
        r14 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r2 = 0;
        r14[r2] = r20;	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r3 = 1;
        r14[r3] = r8;	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r15 = 0;
        r16 = 0;
        r17 = 0;
        r10 = r10.query(r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteException -> 0x0084, all -> 0x007e }
        r4 = r10.moveToFirst();	 Catch:{ SQLiteException -> 0x0079, all -> 0x0075 }
        if (r4 != 0) goto L_0x003f;
    L_0x0039:
        if (r10 == 0) goto L_0x003e;
    L_0x003b:
        r10.close();
    L_0x003e:
        return r9;
    L_0x003f:
        r5 = r10.getLong(r2);	 Catch:{ SQLiteException -> 0x0079, all -> 0x0075 }
        r11 = r19;
        r7 = r11.zza(r10, r3);	 Catch:{ SQLiteException -> 0x0073 }
        r3 = r10.getString(r1);	 Catch:{ SQLiteException -> 0x0073 }
        r12 = new com.google.android.gms.internal.zzcnn;	 Catch:{ SQLiteException -> 0x0073 }
        r1 = r12;
        r2 = r20;
        r4 = r8;
        r1.<init>(r2, r3, r4, r5, r7);	 Catch:{ SQLiteException -> 0x0073 }
        r1 = r10.moveToNext();	 Catch:{ SQLiteException -> 0x0073 }
        if (r1 == 0) goto L_0x006d;
    L_0x005c:
        r1 = r19.zzayp();	 Catch:{ SQLiteException -> 0x0073 }
        r1 = r1.zzbau();	 Catch:{ SQLiteException -> 0x0073 }
        r2 = "Got multiple records for user property, expected one. appId";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r20);	 Catch:{ SQLiteException -> 0x0073 }
        r1.zzj(r2, r3);	 Catch:{ SQLiteException -> 0x0073 }
    L_0x006d:
        if (r10 == 0) goto L_0x0072;
    L_0x006f:
        r10.close();
    L_0x0072:
        return r12;
    L_0x0073:
        r0 = move-exception;
        goto L_0x007c;
    L_0x0075:
        r0 = move-exception;
        r11 = r19;
        goto L_0x00a9;
    L_0x0079:
        r0 = move-exception;
        r11 = r19;
    L_0x007c:
        r1 = r0;
        goto L_0x0089;
    L_0x007e:
        r0 = move-exception;
        r11 = r19;
        r1 = r0;
        r10 = r9;
        goto L_0x00aa;
    L_0x0084:
        r0 = move-exception;
        r11 = r19;
        r1 = r0;
        r10 = r9;
    L_0x0089:
        r2 = r19.zzayp();	 Catch:{ all -> 0x00a8 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x00a8 }
        r3 = "Error querying user property. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r20);	 Catch:{ all -> 0x00a8 }
        r5 = r19.zzayk();	 Catch:{ all -> 0x00a8 }
        r5 = r5.zzjr(r8);	 Catch:{ all -> 0x00a8 }
        r2.zzd(r3, r4, r5, r1);	 Catch:{ all -> 0x00a8 }
        if (r10 == 0) goto L_0x00a7;
    L_0x00a4:
        r10.close();
    L_0x00a7:
        return r9;
    L_0x00a8:
        r0 = move-exception;
    L_0x00a9:
        r1 = r0;
    L_0x00aa:
        if (r10 == 0) goto L_0x00af;
    L_0x00ac:
        r10.close();
    L_0x00af:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzag(java.lang.String, java.lang.String):com.google.android.gms.internal.zzcnn");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0120  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.zzcii zzah(java.lang.String r31, java.lang.String r32) {
        /*
        r30 = this;
        r7 = r32;
        com.google.android.gms.common.internal.zzbq.zzgv(r31);
        com.google.android.gms.common.internal.zzbq.zzgv(r32);
        r30.zzwj();
        r30.zzyk();
        r8 = 0;
        r9 = r30.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r10 = "conditional_properties";
        r11 = "origin";
        r12 = "value";
        r13 = "active";
        r14 = "trigger_event_name";
        r15 = "trigger_timeout";
        r16 = "timed_out_event";
        r17 = "creation_timestamp";
        r18 = "triggered_event";
        r19 = "triggered_timestamp";
        r20 = "time_to_live";
        r21 = "expired_event";
        r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21};	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r12 = "app_id=? and name=?";
        r1 = 2;
        r13 = new java.lang.String[r1];	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r2 = 0;
        r13[r2] = r31;	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r3 = 1;
        r13[r3] = r7;	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16);	 Catch:{ SQLiteException -> 0x0100, all -> 0x00fa }
        r4 = r9.moveToFirst();	 Catch:{ SQLiteException -> 0x00f5, all -> 0x00f1 }
        if (r4 != 0) goto L_0x004e;
    L_0x0048:
        if (r9 == 0) goto L_0x004d;
    L_0x004a:
        r9.close();
    L_0x004d:
        return r8;
    L_0x004e:
        r16 = r9.getString(r2);	 Catch:{ SQLiteException -> 0x00f5, all -> 0x00f1 }
        r10 = r30;
        r5 = r10.zza(r9, r3);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r9.getInt(r1);	 Catch:{ SQLiteException -> 0x00ef }
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r20 = 1;
        goto L_0x0063;
    L_0x0061:
        r20 = 0;
    L_0x0063:
        r1 = 3;
        r21 = r9.getString(r1);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = 4;
        r23 = r9.getLong(r1);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r30.zzayl();	 Catch:{ SQLiteException -> 0x00ef }
        r2 = 5;
        r2 = r9.getBlob(r2);	 Catch:{ SQLiteException -> 0x00ef }
        r3 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r1.zzb(r2, r3);	 Catch:{ SQLiteException -> 0x00ef }
        r22 = r1;
        r22 = (com.google.android.gms.internal.zzcix) r22;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = 6;
        r18 = r9.getLong(r1);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r30.zzayl();	 Catch:{ SQLiteException -> 0x00ef }
        r2 = 7;
        r2 = r9.getBlob(r2);	 Catch:{ SQLiteException -> 0x00ef }
        r3 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r1.zzb(r2, r3);	 Catch:{ SQLiteException -> 0x00ef }
        r25 = r1;
        r25 = (com.google.android.gms.internal.zzcix) r25;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = 8;
        r3 = r9.getLong(r1);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = 9;
        r26 = r9.getLong(r1);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r30.zzayl();	 Catch:{ SQLiteException -> 0x00ef }
        r2 = 10;
        r2 = r9.getBlob(r2);	 Catch:{ SQLiteException -> 0x00ef }
        r6 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r1.zzb(r2, r6);	 Catch:{ SQLiteException -> 0x00ef }
        r28 = r1;
        r28 = (com.google.android.gms.internal.zzcix) r28;	 Catch:{ SQLiteException -> 0x00ef }
        r17 = new com.google.android.gms.internal.zzcnl;	 Catch:{ SQLiteException -> 0x00ef }
        r1 = r17;
        r2 = r7;
        r6 = r16;
        r1.<init>(r2, r3, r5, r6);	 Catch:{ SQLiteException -> 0x00ef }
        r1 = new com.google.android.gms.internal.zzcii;	 Catch:{ SQLiteException -> 0x00ef }
        r14 = r1;
        r15 = r31;
        r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28);	 Catch:{ SQLiteException -> 0x00ef }
        r2 = r9.moveToNext();	 Catch:{ SQLiteException -> 0x00ef }
        if (r2 == 0) goto L_0x00e9;
    L_0x00d0:
        r2 = r30.zzayp();	 Catch:{ SQLiteException -> 0x00ef }
        r2 = r2.zzbau();	 Catch:{ SQLiteException -> 0x00ef }
        r3 = "Got multiple records for conditional property, expected one";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r31);	 Catch:{ SQLiteException -> 0x00ef }
        r5 = r30.zzayk();	 Catch:{ SQLiteException -> 0x00ef }
        r5 = r5.zzjr(r7);	 Catch:{ SQLiteException -> 0x00ef }
        r2.zze(r3, r4, r5);	 Catch:{ SQLiteException -> 0x00ef }
    L_0x00e9:
        if (r9 == 0) goto L_0x00ee;
    L_0x00eb:
        r9.close();
    L_0x00ee:
        return r1;
    L_0x00ef:
        r0 = move-exception;
        goto L_0x00f8;
    L_0x00f1:
        r0 = move-exception;
        r10 = r30;
        goto L_0x0125;
    L_0x00f5:
        r0 = move-exception;
        r10 = r30;
    L_0x00f8:
        r1 = r0;
        goto L_0x0105;
    L_0x00fa:
        r0 = move-exception;
        r10 = r30;
        r1 = r0;
        r9 = r8;
        goto L_0x0126;
    L_0x0100:
        r0 = move-exception;
        r10 = r30;
        r1 = r0;
        r9 = r8;
    L_0x0105:
        r2 = r30.zzayp();	 Catch:{ all -> 0x0124 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x0124 }
        r3 = "Error querying conditional property";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r31);	 Catch:{ all -> 0x0124 }
        r5 = r30.zzayk();	 Catch:{ all -> 0x0124 }
        r5 = r5.zzjr(r7);	 Catch:{ all -> 0x0124 }
        r2.zzd(r3, r4, r5, r1);	 Catch:{ all -> 0x0124 }
        if (r9 == 0) goto L_0x0123;
    L_0x0120:
        r9.close();
    L_0x0123:
        return r8;
    L_0x0124:
        r0 = move-exception;
    L_0x0125:
        r1 = r0;
    L_0x0126:
        if (r9 == 0) goto L_0x012b;
    L_0x0128:
        r9.close();
    L_0x012b:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzah(java.lang.String, java.lang.String):com.google.android.gms.internal.zzcii");
    }

    @WorkerThread
    public final int zzai(String str, String str2) {
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzwj();
        zzyk();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzayp().zzbau().zzd("Error deleting conditional property", zzcjj.zzjs(str), zzayk().zzjr(str2), e);
            return 0;
        }
    }

    public final void zzai(List<Long> list) {
        zzbq.checkNotNull(list);
        zzwj();
        zzyk();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = getWritableDatabase().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            zzayp().zzbau().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcns>> zzaj(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzyk();
        r12.zzwj();
        com.google.android.gms.common.internal.zzbq.zzgv(r13);
        com.google.android.gms.common.internal.zzbq.zzgv(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "event_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND event_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.zzflj.zzo(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.zzcns;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zza(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzayp();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzbau();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzayp();	 Catch:{ all -> 0x00af }
        r1 = r1.zzbau();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzaj(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcns>>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcnv>> zzak(java.lang.String r13, java.lang.String r14) {
        /*
        r12 = this;
        r12.zzyk();
        r12.zzwj();
        com.google.android.gms.common.internal.zzbq.zzgv(r13);
        com.google.android.gms.common.internal.zzbq.zzgv(r14);
        r0 = new android.support.v4.util.ArrayMap;
        r0.<init>();
        r1 = r12.getWritableDatabase();
        r9 = 0;
        r2 = "property_filters";
        r3 = "audience_id";
        r4 = "data";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r4 = "app_id=? AND property_name=?";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r10 = 0;
        r5[r10] = r13;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r11 = 1;
        r5[r11] = r14;	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r14 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0096, all -> 0x0093 }
        r1 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x0038:
        r0 = java.util.Collections.emptyMap();	 Catch:{ SQLiteException -> 0x0091 }
        if (r14 == 0) goto L_0x0041;
    L_0x003e:
        r14.close();
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = r14.getBlob(r11);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r1.length;	 Catch:{ SQLiteException -> 0x0091 }
        r1 = com.google.android.gms.internal.zzflj.zzo(r1, r10, r2);	 Catch:{ SQLiteException -> 0x0091 }
        r2 = new com.google.android.gms.internal.zzcnv;	 Catch:{ SQLiteException -> 0x0091 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r2.zza(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = r14.getInt(r10);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = r0.get(r3);	 Catch:{ SQLiteException -> 0x0091 }
        r3 = (java.util.List) r3;	 Catch:{ SQLiteException -> 0x0091 }
        if (r3 != 0) goto L_0x006f;
    L_0x0063:
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0091 }
        r3.<init>();	 Catch:{ SQLiteException -> 0x0091 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x0091 }
        r0.put(r1, r3);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x006f:
        r3.add(r2);	 Catch:{ SQLiteException -> 0x0091 }
        goto L_0x0085;
    L_0x0073:
        r1 = move-exception;
        r2 = r12.zzayp();	 Catch:{ SQLiteException -> 0x0091 }
        r2 = r2.zzbau();	 Catch:{ SQLiteException -> 0x0091 }
        r3 = "Failed to merge filter";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ SQLiteException -> 0x0091 }
        r2.zze(r3, r4, r1);	 Catch:{ SQLiteException -> 0x0091 }
    L_0x0085:
        r1 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x0091 }
        if (r1 != 0) goto L_0x0042;
    L_0x008b:
        if (r14 == 0) goto L_0x0090;
    L_0x008d:
        r14.close();
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = move-exception;
        goto L_0x0098;
    L_0x0093:
        r13 = move-exception;
        r14 = r9;
        goto L_0x00b0;
    L_0x0096:
        r0 = move-exception;
        r14 = r9;
    L_0x0098:
        r1 = r12.zzayp();	 Catch:{ all -> 0x00af }
        r1 = r1.zzbau();	 Catch:{ all -> 0x00af }
        r2 = "Database error querying filters. appId";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ all -> 0x00af }
        r1.zze(r2, r13, r0);	 Catch:{ all -> 0x00af }
        if (r14 == 0) goto L_0x00ae;
    L_0x00ab:
        r14.close();
    L_0x00ae:
        return r9;
    L_0x00af:
        r13 = move-exception;
    L_0x00b0:
        if (r14 == 0) goto L_0x00b5;
    L_0x00b2:
        r14.close();
    L_0x00b5:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzak(java.lang.String, java.lang.String):java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzcnv>>");
    }

    @WorkerThread
    protected final long zzal(String str, String str2) {
        SQLiteException e;
        Throwable th;
        Throwable th2;
        String str3 = str;
        String str4 = str2;
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        zzwj();
        zzyk();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        long zza;
        try {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 32);
            stringBuilder.append("select ");
            stringBuilder.append(str4);
            stringBuilder.append(" from app2 where app_id=?");
            try {
                ContentValues contentValues;
                zza = zza(stringBuilder.toString(), new String[]{str3}, -1);
                if (zza == -1) {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", Integer.valueOf(0));
                    contentValues.put("previous_install_count", Integer.valueOf(0));
                    if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzayp().zzbau().zze("Failed to insert column (got -1). appId", zzcjj.zzjs(str), str4);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
                try {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put(str4, Long.valueOf(zza + 1));
                    if (((long) writableDatabase.update("app2", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                        zzayp().zzbau().zze("Failed to update column (got 0). appId", zzcjj.zzjs(str), str4);
                        writableDatabase.endTransaction();
                        return -1;
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    return zza;
                } catch (SQLiteException e2) {
                    e = e2;
                }
            } catch (SQLiteException e3) {
                e = e3;
                zza = 0;
                try {
                    zzayp().zzbau().zzd("Error inserting column. appId", zzcjj.zzjs(str), str4, e);
                    writableDatabase.endTransaction();
                    return zza;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    writableDatabase.endTransaction();
                    throw th2;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            zza = 0;
            zzayp().zzbau().zzd("Error inserting column. appId", zzcjj.zzjs(str), str4, e);
            writableDatabase.endTransaction();
            return zza;
        } catch (Throwable th4) {
            th = th4;
            th2 = th;
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    protected final boolean zzazq() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    @android.support.annotation.WorkerThread
    public final java.lang.String zzazw() {
        /*
        r6 = this;
        r0 = r6.getWritableDatabase();
        r1 = 0;
        r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;";
        r0 = r0.rawQuery(r2, r1);	 Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
        r2 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0022 }
        if (r2 == 0) goto L_0x001c;
    L_0x0011:
        r2 = 0;
        r2 = r0.getString(r2);	 Catch:{ SQLiteException -> 0x0022 }
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.close();
    L_0x001b:
        return r2;
    L_0x001c:
        if (r0 == 0) goto L_0x0021;
    L_0x001e:
        r0.close();
    L_0x0021:
        return r1;
    L_0x0022:
        r2 = move-exception;
        goto L_0x002b;
    L_0x0024:
        r0 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x003f;
    L_0x0029:
        r2 = move-exception;
        r0 = r1;
    L_0x002b:
        r3 = r6.zzayp();	 Catch:{ all -> 0x003e }
        r3 = r3.zzbau();	 Catch:{ all -> 0x003e }
        r4 = "Database error getting next bundle app id";
        r3.zzj(r4, r2);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0.close();
    L_0x003d:
        return r1;
    L_0x003e:
        r1 = move-exception;
    L_0x003f:
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r0.close();
    L_0x0044:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzazw():java.lang.String");
    }

    public final boolean zzazx() {
        return zzc("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    final void zzazy() {
        zzwj();
        zzyk();
        if (zzbae()) {
            long j = zzayq().zzjlq.get();
            long elapsedRealtime = zzxx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzciz.zzjjl.get()).longValue()) {
                zzayq().zzjlq.set(elapsedRealtime);
                zzwj();
                zzyk();
                if (zzbae()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzxx().currentTimeMillis()), String.valueOf(zzcik.zzazs())});
                    if (delete > 0) {
                        zzayp().zzbba().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @WorkerThread
    public final long zzazz() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008f  */
    public final android.util.Pair<com.google.android.gms.internal.zzcob, java.lang.Long> zzb(java.lang.String r8, java.lang.Long r9) {
        /*
        r7 = this;
        r7.zzwj();
        r7.zzyk();
        r0 = 0;
        r1 = r7.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?";
        r3 = 2;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r4 = 0;
        r3[r4] = r8;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r5 = java.lang.String.valueOf(r9);	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r6 = 1;
        r3[r6] = r5;	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r1 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteException -> 0x0077, all -> 0x0074 }
        r2 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0072 }
        if (r2 != 0) goto L_0x0037;
    L_0x0024:
        r8 = r7.zzayp();	 Catch:{ SQLiteException -> 0x0072 }
        r8 = r8.zzbba();	 Catch:{ SQLiteException -> 0x0072 }
        r9 = "Main event not found";
        r8.log(r9);	 Catch:{ SQLiteException -> 0x0072 }
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.close();
    L_0x0036:
        return r0;
    L_0x0037:
        r2 = r1.getBlob(r4);	 Catch:{ SQLiteException -> 0x0072 }
        r5 = r1.getLong(r6);	 Catch:{ SQLiteException -> 0x0072 }
        r3 = java.lang.Long.valueOf(r5);	 Catch:{ SQLiteException -> 0x0072 }
        r5 = r2.length;	 Catch:{ SQLiteException -> 0x0072 }
        r2 = com.google.android.gms.internal.zzflj.zzo(r2, r4, r5);	 Catch:{ SQLiteException -> 0x0072 }
        r4 = new com.google.android.gms.internal.zzcob;	 Catch:{ SQLiteException -> 0x0072 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0072 }
        r4.zza(r2);	 Catch:{ IOException -> 0x005a }
        r8 = android.util.Pair.create(r4, r3);	 Catch:{ SQLiteException -> 0x0072 }
        if (r1 == 0) goto L_0x0059;
    L_0x0056:
        r1.close();
    L_0x0059:
        return r8;
    L_0x005a:
        r2 = move-exception;
        r3 = r7.zzayp();	 Catch:{ SQLiteException -> 0x0072 }
        r3 = r3.zzbau();	 Catch:{ SQLiteException -> 0x0072 }
        r4 = "Failed to merge main event. appId, eventId";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r8);	 Catch:{ SQLiteException -> 0x0072 }
        r3.zzd(r4, r8, r9, r2);	 Catch:{ SQLiteException -> 0x0072 }
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();
    L_0x0071:
        return r0;
    L_0x0072:
        r8 = move-exception;
        goto L_0x0079;
    L_0x0074:
        r8 = move-exception;
        r1 = r0;
        goto L_0x008d;
    L_0x0077:
        r8 = move-exception;
        r1 = r0;
    L_0x0079:
        r9 = r7.zzayp();	 Catch:{ all -> 0x008c }
        r9 = r9.zzbau();	 Catch:{ all -> 0x008c }
        r2 = "Error selecting main event";
        r9.zzj(r2, r8);	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x008b;
    L_0x0088:
        r1.close();
    L_0x008b:
        return r0;
    L_0x008c:
        r8 = move-exception;
    L_0x008d:
        if (r1 == 0) goto L_0x0092;
    L_0x008f:
        r1.close();
    L_0x0092:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzb(java.lang.String, java.lang.Long):android.util.Pair<com.google.android.gms.internal.zzcob, java.lang.Long>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    public final java.lang.String zzba(long r5) {
        /*
        r4 = this;
        r4.zzwj();
        r4.zzyk();
        r0 = 0;
        r1 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
        r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
        r6 = 0;
        r3[r6] = r5;	 Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
        r5 = r1.rawQuery(r2, r3);	 Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
        r1 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x003e }
        if (r1 != 0) goto L_0x0034;
    L_0x0021:
        r6 = r4.zzayp();	 Catch:{ SQLiteException -> 0x003e }
        r6 = r6.zzbba();	 Catch:{ SQLiteException -> 0x003e }
        r1 = "No expired configs for apps with pending events";
        r6.log(r1);	 Catch:{ SQLiteException -> 0x003e }
        if (r5 == 0) goto L_0x0033;
    L_0x0030:
        r5.close();
    L_0x0033:
        return r0;
    L_0x0034:
        r6 = r5.getString(r6);	 Catch:{ SQLiteException -> 0x003e }
        if (r5 == 0) goto L_0x003d;
    L_0x003a:
        r5.close();
    L_0x003d:
        return r6;
    L_0x003e:
        r6 = move-exception;
        goto L_0x0045;
    L_0x0040:
        r6 = move-exception;
        r5 = r0;
        goto L_0x0059;
    L_0x0043:
        r6 = move-exception;
        r5 = r0;
    L_0x0045:
        r1 = r4.zzayp();	 Catch:{ all -> 0x0058 }
        r1 = r1.zzbau();	 Catch:{ all -> 0x0058 }
        r2 = "Error selecting expired configs";
        r1.zzj(r2, r6);	 Catch:{ all -> 0x0058 }
        if (r5 == 0) goto L_0x0057;
    L_0x0054:
        r5.close();
    L_0x0057:
        return r0;
    L_0x0058:
        r6 = move-exception;
    L_0x0059:
        if (r5 == 0) goto L_0x005e;
    L_0x005b:
        r5.close();
    L_0x005e:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzba(long):java.lang.String");
    }

    @WorkerThread
    public final long zzbaa() {
        return zza("select max(timestamp) from raw_events", null, 0);
    }

    public final boolean zzbab() {
        return zzc("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzbac() {
        return zzc("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    public final long zzbad() {
        /*
        r7 = this;
        r0 = -1;
        r2 = 0;
        r3 = r7.getWritableDatabase();	 Catch:{ SQLiteException -> 0x002e }
        r4 = "select rowid from raw_events order by rowid desc limit 1;";
        r3 = r3.rawQuery(r4, r2);	 Catch:{ SQLiteException -> 0x002e }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0027, all -> 0x0024 }
        if (r2 != 0) goto L_0x0019;
    L_0x0013:
        if (r3 == 0) goto L_0x0018;
    L_0x0015:
        r3.close();
    L_0x0018:
        return r0;
    L_0x0019:
        r2 = 0;
        r4 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0027, all -> 0x0024 }
        if (r3 == 0) goto L_0x0023;
    L_0x0020:
        r3.close();
    L_0x0023:
        return r4;
    L_0x0024:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0042;
    L_0x0027:
        r2 = move-exception;
        r6 = r3;
        r3 = r2;
        r2 = r6;
        goto L_0x002f;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0042;
    L_0x002e:
        r3 = move-exception;
    L_0x002f:
        r4 = r7.zzayp();	 Catch:{ all -> 0x002c }
        r4 = r4.zzbau();	 Catch:{ all -> 0x002c }
        r5 = "Error querying raw events";
        r4.zzj(r5, r3);	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x0041;
    L_0x003e:
        r2.close();
    L_0x0041:
        return r0;
    L_0x0042:
        if (r2 == 0) goto L_0x0047;
    L_0x0044:
        r2.close();
    L_0x0047:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzbad():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012d  */
    public final java.util.List<com.google.android.gms.internal.zzcii> zzd(java.lang.String r26, java.lang.String[] r27) {
        /*
        r25 = this;
        r25.zzwj();
        r25.zzyk();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = r25.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0112 }
        r4 = "conditional_properties";
        r5 = "app_id";
        r6 = "origin";
        r7 = "name";
        r8 = "value";
        r9 = "active";
        r10 = "trigger_event_name";
        r11 = "trigger_timeout";
        r12 = "timed_out_event";
        r13 = "creation_timestamp";
        r14 = "triggered_event";
        r15 = "triggered_timestamp";
        r16 = "time_to_live";
        r17 = "expired_event";
        r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17};	 Catch:{ SQLiteException -> 0x0112 }
        r8 = 0;
        r9 = 0;
        r10 = "rowid";
        r11 = "1001";
        r6 = r26;
        r7 = r27;
        r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x0112 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        if (r2 != 0) goto L_0x004a;
    L_0x0044:
        if (r3 == 0) goto L_0x0049;
    L_0x0046:
        r3.close();
    L_0x0049:
        return r1;
    L_0x004a:
        r2 = r1.size();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r2 < r4) goto L_0x0065;
    L_0x0052:
        r2 = r25.zzayp();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r2 = r2.zzbau();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r5 = "Read more than the max allowed conditional properties, ignoring extra";
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r2.zzj(r5, r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        goto L_0x0101;
    L_0x0065:
        r2 = 0;
        r5 = r3.getString(r2);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 1;
        r12 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 2;
        r7 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 3;
        r15 = r25;
        r10 = r15.zza(r3, r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 4;
        r6 = r3.getInt(r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        if (r6 == 0) goto L_0x0083;
    L_0x0082:
        r2 = 1;
    L_0x0083:
        r4 = 5;
        r13 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 6;
        r16 = r3.getLong(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r25.zzayl();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 7;
        r6 = r3.getBlob(r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r8 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r4.zzb(r6, r8);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r14 = r4;
        r14 = (com.google.android.gms.internal.zzcix) r14;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 8;
        r18 = r3.getLong(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r25.zzayl();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 9;
        r6 = r3.getBlob(r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r8 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r4.zzb(r6, r8);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r20 = r4;
        r20 = (com.google.android.gms.internal.zzcix) r20;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 10;
        r8 = r3.getLong(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = 11;
        r21 = r3.getLong(r4);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r25.zzayl();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = 12;
        r6 = r3.getBlob(r6);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r11 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r4.zzb(r6, r11);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r23 = r4;
        r23 = (com.google.android.gms.internal.zzcix) r23;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r24 = new com.google.android.gms.internal.zzcnl;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r6 = r24;
        r11 = r12;
        r6.<init>(r7, r8, r10, r11);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r11 = new com.google.android.gms.internal.zzcii;	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r4 = r11;
        r6 = r12;
        r7 = r24;
        r8 = r18;
        r10 = r2;
        r2 = r11;
        r11 = r13;
        r12 = r14;
        r13 = r16;
        r15 = r20;
        r16 = r21;
        r18 = r23;
        r4.<init>(r5, r6, r7, r8, r10, r11, r12, r13, r15, r16, r18);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r1.add(r2);	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        r2 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x010a, all -> 0x0107 }
        if (r2 != 0) goto L_0x004a;
    L_0x0101:
        if (r3 == 0) goto L_0x0106;
    L_0x0103:
        r3.close();
    L_0x0106:
        return r1;
    L_0x0107:
        r0 = move-exception;
        r1 = r0;
        goto L_0x012b;
    L_0x010a:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
        goto L_0x0114;
    L_0x010e:
        r0 = move-exception;
        r1 = r0;
        r3 = r2;
        goto L_0x012b;
    L_0x0112:
        r0 = move-exception;
        r1 = r0;
    L_0x0114:
        r3 = r25.zzayp();	 Catch:{ all -> 0x010e }
        r3 = r3.zzbau();	 Catch:{ all -> 0x010e }
        r4 = "Error querying conditional user property value";
        r3.zzj(r4, r1);	 Catch:{ all -> 0x010e }
        r1 = java.util.Collections.emptyList();	 Catch:{ all -> 0x010e }
        if (r2 == 0) goto L_0x012a;
    L_0x0127:
        r2.close();
    L_0x012a:
        return r1;
    L_0x012b:
        if (r3 == 0) goto L_0x0130;
    L_0x012d:
        r3.close();
    L_0x0130:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzd(java.lang.String, java.lang.String[]):java.util.List<com.google.android.gms.internal.zzcii>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{Splitter: B:1:0x000f, ExcHandler: all (r0_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{Splitter: B:1:0x000f, ExcHandler: all (r0_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:0x0032, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:11:0x0033, code:
            r13 = r23;
     */
    /* JADX WARNING: Missing block: B:51:0x0104, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:52:0x0105, code:
            r13 = r23;
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:53:0x0109, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:54:0x010a, code:
            r13 = r23;
            r12 = r24;
     */
    /* JADX WARNING: Missing block: B:60:0x0125, code:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:65:0x012e, code:
            r2.close();
     */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.zzcnn> zzh(java.lang.String r24, java.lang.String r25, java.lang.String r26) {
        /*
        r23 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r24);
        r23.zzwj();
        r23.zzyk();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0109, all -> 0x0104 }
        r4 = 3;
        r3.<init>(r4);	 Catch:{ SQLiteException -> 0x0109, all -> 0x0104 }
        r12 = r24;
        r3.add(r12);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r6 = "app_id=?";
        r5.<init>(r6);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        r6 = android.text.TextUtils.isEmpty(r25);	 Catch:{ SQLiteException -> 0x0100, all -> 0x0104 }
        if (r6 != 0) goto L_0x0037;
    L_0x0027:
        r6 = r25;
        r3.add(r6);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = " and origin=?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        goto L_0x0039;
    L_0x0032:
        r0 = move-exception;
        r13 = r23;
        goto L_0x0110;
    L_0x0037:
        r6 = r25;
    L_0x0039:
        r7 = android.text.TextUtils.isEmpty(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        if (r7 != 0) goto L_0x0051;
    L_0x003f:
        r7 = java.lang.String.valueOf(r26);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r8 = "*";
        r7 = r7.concat(r8);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r3.add(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = " and name glob ?";
        r5.append(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
    L_0x0051:
        r7 = r3.size();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r7 = new java.lang.String[r7];	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r3 = r3.toArray(r7);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r17 = r3;
        r17 = (java.lang.String[]) r17;	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r13 = r23.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r14 = "user_attributes";
        r3 = "name";
        r7 = "set_timestamp";
        r8 = "value";
        r9 = "origin";
        r15 = new java.lang.String[]{r3, r7, r8, r9};	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r16 = r5.toString();	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r18 = 0;
        r19 = 0;
        r20 = "rowid";
        r21 = "1001";
        r3 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21);	 Catch:{ SQLiteException -> 0x0032, all -> 0x0104 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        if (r5 != 0) goto L_0x008d;
    L_0x0087:
        if (r3 == 0) goto L_0x008c;
    L_0x0089:
        r3.close();
    L_0x008c:
        return r1;
    L_0x008d:
        r5 = r1.size();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r5 < r7) goto L_0x00a9;
    L_0x0095:
        r4 = r23.zzayp();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r4 = r4.zzbau();	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = "Read more than the max allowed user properties, ignoring excess";
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r4.zzj(r5, r7);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r13 = r23;
        goto L_0x00ec;
    L_0x00a9:
        r5 = 0;
        r8 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = 1;
        r9 = r3.getLong(r5);	 Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
        r5 = 2;
        r13 = r23;
        r11 = r13.zza(r3, r5);	 Catch:{ SQLiteException -> 0x00f5 }
        r14 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x00f5 }
        if (r11 != 0) goto L_0x00d8;
    L_0x00c0:
        r5 = r23.zzayp();	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x00d4 }
        r6 = "(2)Read invalid user property value, ignoring it";
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r24);	 Catch:{ SQLiteException -> 0x00d4 }
        r15 = r26;
        r5.zzd(r6, r7, r14, r15);	 Catch:{ SQLiteException -> 0x00d4 }
        goto L_0x00e6;
    L_0x00d4:
        r0 = move-exception;
        r1 = r0;
        r6 = r14;
        goto L_0x0112;
    L_0x00d8:
        r15 = r26;
        r7 = new com.google.android.gms.internal.zzcnn;	 Catch:{ SQLiteException -> 0x00d4 }
        r5 = r7;
        r6 = r12;
        r4 = r7;
        r7 = r14;
        r5.<init>(r6, r7, r8, r9, r11);	 Catch:{ SQLiteException -> 0x00d4 }
        r1.add(r4);	 Catch:{ SQLiteException -> 0x00d4 }
    L_0x00e6:
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x00d4 }
        if (r4 != 0) goto L_0x00f2;
    L_0x00ec:
        if (r3 == 0) goto L_0x00f1;
    L_0x00ee:
        r3.close();
    L_0x00f1:
        return r1;
    L_0x00f2:
        r6 = r14;
        r4 = 3;
        goto L_0x008d;
    L_0x00f5:
        r0 = move-exception;
        goto L_0x00fe;
    L_0x00f7:
        r0 = move-exception;
        r13 = r23;
        goto L_0x012a;
    L_0x00fb:
        r0 = move-exception;
        r13 = r23;
    L_0x00fe:
        r1 = r0;
        goto L_0x0112;
    L_0x0100:
        r0 = move-exception;
        r13 = r23;
        goto L_0x010e;
    L_0x0104:
        r0 = move-exception;
        r13 = r23;
        r1 = r0;
        goto L_0x012c;
    L_0x0109:
        r0 = move-exception;
        r13 = r23;
        r12 = r24;
    L_0x010e:
        r6 = r25;
    L_0x0110:
        r1 = r0;
        r3 = r2;
    L_0x0112:
        r4 = r23.zzayp();	 Catch:{ all -> 0x0129 }
        r4 = r4.zzbau();	 Catch:{ all -> 0x0129 }
        r5 = "(2)Error querying user properties";
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r24);	 Catch:{ all -> 0x0129 }
        r4.zzd(r5, r7, r6, r1);	 Catch:{ all -> 0x0129 }
        if (r3 == 0) goto L_0x0128;
    L_0x0125:
        r3.close();
    L_0x0128:
        return r2;
    L_0x0129:
        r0 = move-exception;
    L_0x012a:
        r1 = r0;
        r2 = r3;
    L_0x012c:
        if (r2 == 0) goto L_0x0131;
    L_0x012e:
        r2.close();
    L_0x0131:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzh(java.lang.String, java.lang.String, java.lang.String):java.util.List<com.google.android.gms.internal.zzcnn>");
    }

    @WorkerThread
    public final List<zzcii> zzi(String str, String str2, String str3) {
        zzbq.zzgv(str);
        zzwj();
        zzyk();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return zzd(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    @android.support.annotation.WorkerThread
    public final java.util.List<com.google.android.gms.internal.zzcnn> zzji(java.lang.String r14) {
        /*
        r13 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r14);
        r13.zzwj();
        r13.zzyk();
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r13.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
        r3 = "user_attributes";
        r4 = "name";
        r5 = "origin";
        r6 = "set_timestamp";
        r7 = "value";
        r4 = new java.lang.String[]{r4, r5, r6, r7};	 Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
        r5 = "app_id=?";
        r11 = 1;
        r6 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
        r12 = 0;
        r6[r12] = r14;	 Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = "1000";
        r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
        r3 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x0080 }
        if (r3 != 0) goto L_0x003f;
    L_0x0039:
        if (r2 == 0) goto L_0x003e;
    L_0x003b:
        r2.close();
    L_0x003e:
        return r0;
    L_0x003f:
        r7 = r2.getString(r12);	 Catch:{ SQLiteException -> 0x0080 }
        r3 = r2.getString(r11);	 Catch:{ SQLiteException -> 0x0080 }
        if (r3 != 0) goto L_0x004b;
    L_0x0049:
        r3 = "";
    L_0x004b:
        r6 = r3;
        r3 = 2;
        r8 = r2.getLong(r3);	 Catch:{ SQLiteException -> 0x0080 }
        r3 = 3;
        r10 = r13.zza(r2, r3);	 Catch:{ SQLiteException -> 0x0080 }
        if (r10 != 0) goto L_0x006a;
    L_0x0058:
        r3 = r13.zzayp();	 Catch:{ SQLiteException -> 0x0080 }
        r3 = r3.zzbau();	 Catch:{ SQLiteException -> 0x0080 }
        r4 = "Read invalid user property value, ignoring it. appId";
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r14);	 Catch:{ SQLiteException -> 0x0080 }
        r3.zzj(r4, r5);	 Catch:{ SQLiteException -> 0x0080 }
        goto L_0x0074;
    L_0x006a:
        r3 = new com.google.android.gms.internal.zzcnn;	 Catch:{ SQLiteException -> 0x0080 }
        r4 = r3;
        r5 = r14;
        r4.<init>(r5, r6, r7, r8, r10);	 Catch:{ SQLiteException -> 0x0080 }
        r0.add(r3);	 Catch:{ SQLiteException -> 0x0080 }
    L_0x0074:
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x0080 }
        if (r3 != 0) goto L_0x003f;
    L_0x007a:
        if (r2 == 0) goto L_0x007f;
    L_0x007c:
        r2.close();
    L_0x007f:
        return r0;
    L_0x0080:
        r0 = move-exception;
        goto L_0x0087;
    L_0x0082:
        r14 = move-exception;
        r2 = r1;
        goto L_0x009f;
    L_0x0085:
        r0 = move-exception;
        r2 = r1;
    L_0x0087:
        r3 = r13.zzayp();	 Catch:{ all -> 0x009e }
        r3 = r3.zzbau();	 Catch:{ all -> 0x009e }
        r4 = "Error querying user properties. appId";
        r14 = com.google.android.gms.internal.zzcjj.zzjs(r14);	 Catch:{ all -> 0x009e }
        r3.zze(r4, r14, r0);	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x009d;
    L_0x009a:
        r2.close();
    L_0x009d:
        return r1;
    L_0x009e:
        r14 = move-exception;
    L_0x009f:
        if (r2 == 0) goto L_0x00a4;
    L_0x00a1:
        r2.close();
    L_0x00a4:
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzji(java.lang.String):java.util.List<com.google.android.gms.internal.zzcnn>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01b7  */
    @android.support.annotation.WorkerThread
    public final com.google.android.gms.internal.zzcie zzjj(java.lang.String r30) {
        /*
        r29 = this;
        r1 = r30;
        com.google.android.gms.common.internal.zzbq.zzgv(r30);
        r29.zzwj();
        r29.zzyk();
        r2 = 0;
        r3 = r29.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0196, all -> 0x0190 }
        r4 = "apps";
        r5 = "app_instance_id";
        r6 = "gmp_app_id";
        r7 = "resettable_device_id_hash";
        r8 = "last_bundle_index";
        r9 = "last_bundle_start_timestamp";
        r10 = "last_bundle_end_timestamp";
        r11 = "app_version";
        r12 = "app_store";
        r13 = "gmp_version";
        r14 = "dev_cert_hash";
        r15 = "measurement_enabled";
        r16 = "day";
        r17 = "daily_public_events_count";
        r18 = "daily_events_count";
        r19 = "daily_conversions_count";
        r20 = "config_fetched_time";
        r21 = "failed_config_fetch_time";
        r22 = "app_version_int";
        r23 = "firebase_instance_id";
        r24 = "daily_error_events_count";
        r25 = "daily_realtime_events_count";
        r26 = "health_monitor_sample";
        r27 = "android_id";
        r28 = "adid_reporting_enabled";
        r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};	 Catch:{ SQLiteException -> 0x0196, all -> 0x0190 }
        r6 = "app_id=?";
        r11 = 1;
        r7 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0196, all -> 0x0190 }
        r12 = 0;
        r7[r12] = r1;	 Catch:{ SQLiteException -> 0x0196, all -> 0x0190 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r3 = r3.query(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0196, all -> 0x0190 }
        r4 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x018a, all -> 0x0185 }
        if (r4 != 0) goto L_0x0061;
    L_0x005b:
        if (r3 == 0) goto L_0x0060;
    L_0x005d:
        r3.close();
    L_0x0060:
        return r2;
    L_0x0061:
        r4 = new com.google.android.gms.internal.zzcie;	 Catch:{ SQLiteException -> 0x018a, all -> 0x0185 }
        r5 = r29;
        r6 = r5.zzjev;	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.<init>(r6, r1);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = r3.getString(r12);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zziy(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = r3.getString(r11);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zziz(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 2;
        r6 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzja(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 3;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzaq(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 4;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzal(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 5;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzam(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 6;
        r6 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.setAppVersion(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 7;
        r6 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzjc(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 8;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzao(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 9;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzap(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 10;
        r7 = r3.isNull(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r7 != 0) goto L_0x00cb;
    L_0x00c2:
        r6 = r3.getInt(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r6 == 0) goto L_0x00c9;
    L_0x00c8:
        goto L_0x00cb;
    L_0x00c9:
        r6 = 0;
        goto L_0x00cc;
    L_0x00cb:
        r6 = 1;
    L_0x00cc:
        r4.setMeasurementEnabled(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 11;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzat(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 12;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzau(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 13;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzav(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 14;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzaw(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 15;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzar(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 16;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzas(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 17;
        r7 = r3.isNull(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r7 == 0) goto L_0x0111;
    L_0x010d:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x0116;
    L_0x0111:
        r6 = r3.getInt(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = (long) r6;	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
    L_0x0116:
        r4.zzan(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 18;
        r6 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzjb(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 19;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzay(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 20;
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzax(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 21;
        r6 = r3.getString(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzjd(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 22;
        r7 = r3.isNull(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r7 == 0) goto L_0x0148;
    L_0x0145:
        r6 = 0;
        goto L_0x014c;
    L_0x0148:
        r6 = r3.getLong(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
    L_0x014c:
        r4.zzaz(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = 23;
        r7 = r3.isNull(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r7 != 0) goto L_0x015d;
    L_0x0157:
        r6 = r3.getInt(r6);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r6 == 0) goto L_0x015e;
    L_0x015d:
        r12 = 1;
    L_0x015e:
        r4.zzbq(r12);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r4.zzays();	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        if (r6 == 0) goto L_0x017b;
    L_0x016a:
        r6 = r29.zzayp();	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6 = r6.zzbau();	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r7 = "Got multiple records for app, expected one. appId";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r30);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
        r6.zzj(r7, r8);	 Catch:{ SQLiteException -> 0x0183, all -> 0x0181 }
    L_0x017b:
        if (r3 == 0) goto L_0x0180;
    L_0x017d:
        r3.close();
    L_0x0180:
        return r4;
    L_0x0181:
        r0 = move-exception;
        goto L_0x0188;
    L_0x0183:
        r0 = move-exception;
        goto L_0x018d;
    L_0x0185:
        r0 = move-exception;
        r5 = r29;
    L_0x0188:
        r1 = r0;
        goto L_0x01b5;
    L_0x018a:
        r0 = move-exception;
        r5 = r29;
    L_0x018d:
        r4 = r3;
        r3 = r0;
        goto L_0x019b;
    L_0x0190:
        r0 = move-exception;
        r5 = r29;
        r1 = r0;
        r3 = r2;
        goto L_0x01b5;
    L_0x0196:
        r0 = move-exception;
        r5 = r29;
        r3 = r0;
        r4 = r2;
    L_0x019b:
        r6 = r29.zzayp();	 Catch:{ all -> 0x01b2 }
        r6 = r6.zzbau();	 Catch:{ all -> 0x01b2 }
        r7 = "Error querying app. appId";
        r1 = com.google.android.gms.internal.zzcjj.zzjs(r30);	 Catch:{ all -> 0x01b2 }
        r6.zze(r7, r1, r3);	 Catch:{ all -> 0x01b2 }
        if (r4 == 0) goto L_0x01b1;
    L_0x01ae:
        r4.close();
    L_0x01b1:
        return r2;
    L_0x01b2:
        r0 = move-exception;
        r1 = r0;
        r3 = r4;
    L_0x01b5:
        if (r3 == 0) goto L_0x01ba;
    L_0x01b7:
        r3.close();
    L_0x01ba:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzjj(java.lang.String):com.google.android.gms.internal.zzcie");
    }

    public final long zzjk(String str) {
        zzbq.zzgv(str);
        zzwj();
        zzyk();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzayr().zzb(str, zzciz.zzjjc))));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzayp().zzbau().zze("Error deleting over the limit events. appId", zzcjj.zzjs(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    @android.support.annotation.WorkerThread
    public final byte[] zzjl(java.lang.String r11) {
        /*
        r10 = this;
        com.google.android.gms.common.internal.zzbq.zzgv(r11);
        r10.zzwj();
        r10.zzyk();
        r0 = 0;
        r1 = r10.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
        r2 = "apps";
        r3 = "remote_config";
        r3 = new java.lang.String[]{r3};	 Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
        r4 = "app_id=?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
        r9 = 0;
        r5[r9] = r11;	 Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
        r2 = r1.moveToFirst();	 Catch:{ SQLiteException -> 0x0052 }
        if (r2 != 0) goto L_0x0031;
    L_0x002b:
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();
    L_0x0030:
        return r0;
    L_0x0031:
        r2 = r1.getBlob(r9);	 Catch:{ SQLiteException -> 0x0052 }
        r3 = r1.moveToNext();	 Catch:{ SQLiteException -> 0x0052 }
        if (r3 == 0) goto L_0x004c;
    L_0x003b:
        r3 = r10.zzayp();	 Catch:{ SQLiteException -> 0x0052 }
        r3 = r3.zzbau();	 Catch:{ SQLiteException -> 0x0052 }
        r4 = "Got multiple records for app config, expected one. appId";
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ SQLiteException -> 0x0052 }
        r3.zzj(r4, r5);	 Catch:{ SQLiteException -> 0x0052 }
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();
    L_0x0051:
        return r2;
    L_0x0052:
        r2 = move-exception;
        goto L_0x0059;
    L_0x0054:
        r11 = move-exception;
        r1 = r0;
        goto L_0x0071;
    L_0x0057:
        r2 = move-exception;
        r1 = r0;
    L_0x0059:
        r3 = r10.zzayp();	 Catch:{ all -> 0x0070 }
        r3 = r3.zzbau();	 Catch:{ all -> 0x0070 }
        r4 = "Error querying remote config. appId";
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ all -> 0x0070 }
        r3.zze(r4, r11, r2);	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x006f;
    L_0x006c:
        r1.close();
    L_0x006f:
        return r0;
    L_0x0070:
        r11 = move-exception;
    L_0x0071:
        if (r1 == 0) goto L_0x0076;
    L_0x0073:
        r1.close();
    L_0x0076:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzjl(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    final java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcof> zzjm(java.lang.String r12) {
        /*
        r11 = this;
        r11.zzyk();
        r11.zzwj();
        com.google.android.gms.common.internal.zzbq.zzgv(r12);
        r0 = r11.getWritableDatabase();
        r8 = 0;
        r1 = "audience_filter_values";
        r2 = "audience_id";
        r3 = "current_results";
        r2 = new java.lang.String[]{r2, r3};	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r3 = "app_id=?";
        r9 = 1;
        r4 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r10 = 0;
        r4[r10] = r12;	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
        r1 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0077 }
        if (r1 != 0) goto L_0x0033;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        return r8;
    L_0x0033:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ SQLiteException -> 0x0077 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x0077 }
    L_0x0038:
        r2 = r0.getInt(r10);	 Catch:{ SQLiteException -> 0x0077 }
        r3 = r0.getBlob(r9);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r3.length;	 Catch:{ SQLiteException -> 0x0077 }
        r3 = com.google.android.gms.internal.zzflj.zzo(r3, r10, r4);	 Catch:{ SQLiteException -> 0x0077 }
        r4 = new com.google.android.gms.internal.zzcof;	 Catch:{ SQLiteException -> 0x0077 }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0077 }
        r4.zza(r3);	 Catch:{ IOException -> 0x0055 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r1.put(r2, r4);	 Catch:{ SQLiteException -> 0x0077 }
        goto L_0x006b;
    L_0x0055:
        r3 = move-exception;
        r4 = r11.zzayp();	 Catch:{ SQLiteException -> 0x0077 }
        r4 = r4.zzbau();	 Catch:{ SQLiteException -> 0x0077 }
        r5 = "Failed to merge filter results. appId, audienceId, error";
        r6 = com.google.android.gms.internal.zzcjj.zzjs(r12);	 Catch:{ SQLiteException -> 0x0077 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ SQLiteException -> 0x0077 }
        r4.zzd(r5, r6, r2, r3);	 Catch:{ SQLiteException -> 0x0077 }
    L_0x006b:
        r2 = r0.moveToNext();	 Catch:{ SQLiteException -> 0x0077 }
        if (r2 != 0) goto L_0x0038;
    L_0x0071:
        if (r0 == 0) goto L_0x0076;
    L_0x0073:
        r0.close();
    L_0x0076:
        return r1;
    L_0x0077:
        r1 = move-exception;
        goto L_0x007e;
    L_0x0079:
        r12 = move-exception;
        r0 = r8;
        goto L_0x0096;
    L_0x007c:
        r1 = move-exception;
        r0 = r8;
    L_0x007e:
        r2 = r11.zzayp();	 Catch:{ all -> 0x0095 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x0095 }
        r3 = "Database error querying filter results. appId";
        r12 = com.google.android.gms.internal.zzcjj.zzjs(r12);	 Catch:{ all -> 0x0095 }
        r2.zze(r3, r12, r1);	 Catch:{ all -> 0x0095 }
        if (r0 == 0) goto L_0x0094;
    L_0x0091:
        r0.close();
    L_0x0094:
        return r8;
    L_0x0095:
        r12 = move-exception;
    L_0x0096:
        if (r0 == 0) goto L_0x009b;
    L_0x0098:
        r0.close();
    L_0x009b:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzjm(java.lang.String):java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzcof>");
    }

    public final long zzjn(String str) {
        zzbq.zzgv(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2 A:{SYNTHETIC, EDGE_INSN: B:59:0x00b2->B:41:0x00b2 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b0 A:{LOOP_END, LOOP:0: B:20:0x0052->B:40:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b0 A:{LOOP_END, LOOP:0: B:20:0x0052->B:40:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b2 A:{SYNTHETIC, EDGE_INSN: B:59:0x00b2->B:41:0x00b2 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d8  */
    @android.support.annotation.WorkerThread
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.zzcoe, java.lang.Long>> zzl(java.lang.String r13, int r14, int r15) {
        /*
        r12 = this;
        r12.zzwj();
        r12.zzyk();
        r0 = 1;
        r1 = 0;
        if (r14 <= 0) goto L_0x000c;
    L_0x000a:
        r2 = 1;
        goto L_0x000d;
    L_0x000c:
        r2 = 0;
    L_0x000d:
        com.google.android.gms.common.internal.zzbq.checkArgument(r2);
        if (r15 <= 0) goto L_0x0014;
    L_0x0012:
        r2 = 1;
        goto L_0x0015;
    L_0x0014:
        r2 = 0;
    L_0x0015:
        com.google.android.gms.common.internal.zzbq.checkArgument(r2);
        com.google.android.gms.common.internal.zzbq.zzgv(r13);
        r2 = 0;
        r3 = r12.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00c0 }
        r4 = "queue";
        r5 = "rowid";
        r6 = "data";
        r5 = new java.lang.String[]{r5, r6};	 Catch:{ SQLiteException -> 0x00c0 }
        r6 = "app_id=?";
        r7 = new java.lang.String[r0];	 Catch:{ SQLiteException -> 0x00c0 }
        r7[r1] = r13;	 Catch:{ SQLiteException -> 0x00c0 }
        r8 = 0;
        r9 = 0;
        r10 = "rowid";
        r11 = java.lang.String.valueOf(r14);	 Catch:{ SQLiteException -> 0x00c0 }
        r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ SQLiteException -> 0x00c0 }
        r2 = r14.moveToFirst();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        if (r2 != 0) goto L_0x004c;
    L_0x0042:
        r15 = java.util.Collections.emptyList();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        if (r14 == 0) goto L_0x004b;
    L_0x0048:
        r14.close();
    L_0x004b:
        return r15;
    L_0x004c:
        r2 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r2.<init>();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r3 = 0;
    L_0x0052:
        r4 = r14.getLong(r1);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r6 = r14.getBlob(r0);	 Catch:{ IOException -> 0x009a }
        r7 = r12.zzayl();	 Catch:{ IOException -> 0x009a }
        r6 = r7.zzs(r6);	 Catch:{ IOException -> 0x009a }
        r7 = r2.isEmpty();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        if (r7 != 0) goto L_0x006c;
    L_0x0068:
        r7 = r6.length;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r7 = r7 + r3;
        if (r7 > r15) goto L_0x00b2;
    L_0x006c:
        r7 = r6.length;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r7 = com.google.android.gms.internal.zzflj.zzo(r6, r1, r7);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r8 = new com.google.android.gms.internal.zzcoe;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r8.<init>();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r8.zza(r7);	 Catch:{ IOException -> 0x0087 }
        r6 = r6.length;	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r3 = r3 + r6;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r4 = android.util.Pair.create(r8, r4);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r2.add(r4);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        goto L_0x00aa;
    L_0x0087:
        r4 = move-exception;
        r5 = r12.zzayp();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r6 = "Failed to merge queued bundle. appId";
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
    L_0x0096:
        r5.zze(r6, r7, r4);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        goto L_0x00aa;
    L_0x009a:
        r4 = move-exception;
        r5 = r12.zzayp();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        r6 = "Failed to unzip queued bundle. appId";
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        goto L_0x0096;
    L_0x00aa:
        r4 = r14.moveToNext();	 Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
        if (r4 == 0) goto L_0x00b2;
    L_0x00b0:
        if (r3 <= r15) goto L_0x0052;
    L_0x00b2:
        if (r14 == 0) goto L_0x00b7;
    L_0x00b4:
        r14.close();
    L_0x00b7:
        return r2;
    L_0x00b8:
        r13 = move-exception;
        goto L_0x00dc;
    L_0x00ba:
        r15 = move-exception;
        r2 = r14;
        goto L_0x00c1;
    L_0x00bd:
        r13 = move-exception;
        r14 = r2;
        goto L_0x00dc;
    L_0x00c0:
        r15 = move-exception;
    L_0x00c1:
        r14 = r12.zzayp();	 Catch:{ all -> 0x00bd }
        r14 = r14.zzbau();	 Catch:{ all -> 0x00bd }
        r0 = "Error querying bundles. appId";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r13);	 Catch:{ all -> 0x00bd }
        r14.zze(r0, r13, r15);	 Catch:{ all -> 0x00bd }
        r13 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00bd }
        if (r2 == 0) goto L_0x00db;
    L_0x00d8:
        r2.close();
    L_0x00db:
        return r13;
    L_0x00dc:
        if (r14 == 0) goto L_0x00e1;
    L_0x00de:
        r14.close();
    L_0x00e1:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcil.zzl(java.lang.String, int, int):java.util.List<android.util.Pair<com.google.android.gms.internal.zzcoe, java.lang.Long>>");
    }
}
