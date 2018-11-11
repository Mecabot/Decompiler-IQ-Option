package com.google.android.gms.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;

public final class zzcjf extends zzcli {
    private final zzcjg zzjka = new zzcjg(this, getContext(), "google_app_measurement_local.db");
    private boolean zzjkb;

    zzcjf(zzckj zzckj) {
        super(zzckj);
    }

    @WorkerThread
    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzjkb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzjka.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzjkb = true;
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1 A:{SYNTHETIC, Splitter: B:58:0x00f1} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1 A:{SYNTHETIC, Splitter: B:58:0x00f1} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A:{Splitter: B:9:0x002d, ExcHandler: android.database.sqlite.SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f1 A:{SYNTHETIC, Splitter: B:58:0x00f1} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149 A:{SYNTHETIC} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:14:0x0035, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:15:0x0036, code:
            r3 = r0;
            r12 = null;
     */
    /* JADX WARNING: Missing block: B:18:0x003e, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:50:0x00de, code:
            r7 = null;
     */
    @android.support.annotation.WorkerThread
    private final boolean zzb(int r20, byte[] r21) {
        /*
        r19 = this;
        r1 = r19;
        r19.zzwj();
        r2 = r1.zzjkb;
        r3 = 0;
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r2 = new android.content.ContentValues;
        r2.<init>();
        r4 = "type";
        r5 = java.lang.Integer.valueOf(r20);
        r2.put(r4, r5);
        r4 = "entry";
        r5 = r21;
        r2.put(r4, r5);
        r4 = 5;
        r5 = 0;
        r6 = 5;
    L_0x0023:
        if (r5 >= r4) goto L_0x015d;
    L_0x0025:
        r7 = 0;
        r8 = 1;
        r9 = r19.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x012d, SQLiteDatabaseLockedException -> 0x011a, SQLiteException -> 0x00eb, all -> 0x00e4 }
        if (r9 != 0) goto L_0x0042;
    L_0x002d:
        r1.zzjkb = r8;	 Catch:{ SQLiteFullException -> 0x003e, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x0035 }
        if (r9 == 0) goto L_0x0034;
    L_0x0031:
        r9.close();
    L_0x0034:
        return r3;
    L_0x0035:
        r0 = move-exception;
        r3 = r0;
        r12 = r7;
    L_0x0038:
        r7 = r9;
        goto L_0x00ef;
    L_0x003b:
        r4 = r7;
        goto L_0x00de;
    L_0x003e:
        r0 = move-exception;
    L_0x003f:
        r3 = r0;
        goto L_0x0131;
    L_0x0042:
        r9.beginTransaction();	 Catch:{ SQLiteFullException -> 0x00e0, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x00d8, all -> 0x00d2 }
        r10 = 0;
        r12 = "select count(1) from messages";
        r12 = r9.rawQuery(r12, r7);	 Catch:{ SQLiteFullException -> 0x00e0, SQLiteDatabaseLockedException -> 0x003b, SQLiteException -> 0x00d8, all -> 0x00d2 }
        if (r12 == 0) goto L_0x0066;
    L_0x004f:
        r13 = r12.moveToFirst();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        if (r13 == 0) goto L_0x0066;
    L_0x0055:
        r10 = r12.getLong(r3);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        goto L_0x0066;
    L_0x005a:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0152;
    L_0x005e:
        r0 = move-exception;
        r3 = r0;
        goto L_0x0038;
    L_0x0061:
        r0 = move-exception;
        r3 = r0;
        r7 = r12;
        goto L_0x0131;
    L_0x0066:
        r13 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));
        if (r15 < 0) goto L_0x00b7;
    L_0x006d:
        r15 = r19.zzayp();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r15 = r15.zzbau();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r4 = "Data loss, local db full";
        r15.log(r4);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r4 = 0;
        r16 = r13 - r10;
        r10 = 1;
        r13 = r16 + r10;
        r4 = "messages";
        r10 = "rowid in (select rowid from messages order by rowid asc limit ?)";
        r11 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r15 = java.lang.Long.toString(r13);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r11[r3] = r15;	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r4 = r9.delete(r4, r10, r11);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r10 = (long) r4;	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1));
        if (r4 == 0) goto L_0x00b7;
    L_0x0096:
        r4 = r19.zzayp();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r4 = r4.zzbau();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r15 = "Different delete count than expected in local db. expected, received, difference";
        r3 = java.lang.Long.valueOf(r13);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r16 = 0;
        r18 = r8;
        r7 = r13 - r10;
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r8 = r18;
        r4.zzd(r15, r3, r8, r7);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
    L_0x00b7:
        r3 = "messages";
        r4 = 0;
        r9.insertOrThrow(r3, r4, r2);	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r9.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        r9.endTransaction();	 Catch:{ SQLiteFullException -> 0x0061, SQLiteDatabaseLockedException -> 0x00cf, SQLiteException -> 0x005e, all -> 0x005a }
        if (r12 == 0) goto L_0x00c8;
    L_0x00c5:
        r12.close();
    L_0x00c8:
        if (r9 == 0) goto L_0x00cd;
    L_0x00ca:
        r9.close();
    L_0x00cd:
        r2 = 1;
        return r2;
    L_0x00cf:
        r7 = r12;
        goto L_0x011c;
    L_0x00d2:
        r0 = move-exception;
        r4 = r7;
        r2 = r0;
        r12 = r4;
        goto L_0x0152;
    L_0x00d8:
        r0 = move-exception;
        r4 = r7;
        r3 = r0;
        r12 = r4;
        goto L_0x0038;
    L_0x00de:
        r7 = r4;
        goto L_0x011c;
    L_0x00e0:
        r0 = move-exception;
        r4 = r7;
        goto L_0x003f;
    L_0x00e4:
        r0 = move-exception;
        r4 = r7;
        r2 = r0;
        r9 = r4;
        r12 = r9;
        goto L_0x0152;
    L_0x00eb:
        r0 = move-exception;
        r4 = r7;
        r3 = r0;
        r12 = r7;
    L_0x00ef:
        if (r7 == 0) goto L_0x00ff;
    L_0x00f1:
        r4 = r7.inTransaction();	 Catch:{ all -> 0x00fb }
        if (r4 == 0) goto L_0x00ff;
    L_0x00f7:
        r7.endTransaction();	 Catch:{ all -> 0x00fb }
        goto L_0x00ff;
    L_0x00fb:
        r0 = move-exception;
        r2 = r0;
        r9 = r7;
        goto L_0x0152;
    L_0x00ff:
        r4 = r19.zzayp();	 Catch:{ all -> 0x00fb }
        r4 = r4.zzbau();	 Catch:{ all -> 0x00fb }
        r8 = "Error writing entry to local database";
        r4.zzj(r8, r3);	 Catch:{ all -> 0x00fb }
        r3 = 1;
        r1.zzjkb = r3;	 Catch:{ all -> 0x00fb }
        if (r12 == 0) goto L_0x0114;
    L_0x0111:
        r12.close();
    L_0x0114:
        if (r7 == 0) goto L_0x0149;
    L_0x0116:
        r7.close();
        goto L_0x0149;
    L_0x011a:
        r4 = r7;
        r9 = r7;
    L_0x011c:
        r3 = (long) r6;
        android.os.SystemClock.sleep(r3);	 Catch:{ all -> 0x014f }
        r6 = r6 + 20;
        if (r7 == 0) goto L_0x0127;
    L_0x0124:
        r7.close();
    L_0x0127:
        if (r9 == 0) goto L_0x0149;
    L_0x0129:
        r9.close();
        goto L_0x0149;
    L_0x012d:
        r0 = move-exception;
        r4 = r7;
        r3 = r0;
        r9 = r7;
    L_0x0131:
        r4 = r19.zzayp();	 Catch:{ all -> 0x014f }
        r4 = r4.zzbau();	 Catch:{ all -> 0x014f }
        r8 = "Error writing entry to local database";
        r4.zzj(r8, r3);	 Catch:{ all -> 0x014f }
        r3 = 1;
        r1.zzjkb = r3;	 Catch:{ all -> 0x014f }
        if (r7 == 0) goto L_0x0146;
    L_0x0143:
        r7.close();
    L_0x0146:
        if (r9 == 0) goto L_0x0149;
    L_0x0148:
        goto L_0x0129;
    L_0x0149:
        r5 = r5 + 1;
        r3 = 0;
        r4 = 5;
        goto L_0x0023;
    L_0x014f:
        r0 = move-exception;
        r2 = r0;
        r12 = r7;
    L_0x0152:
        if (r12 == 0) goto L_0x0157;
    L_0x0154:
        r12.close();
    L_0x0157:
        if (r9 == 0) goto L_0x015c;
    L_0x0159:
        r9.close();
    L_0x015c:
        throw r2;
    L_0x015d:
        r2 = r19.zzayp();
        r2 = r2.zzbaw();
        r3 = "Failed to write entry to local database";
        r2.log(r3);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjf.zzb(int, byte[]):boolean");
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzwj();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzayp().zzbba().zzj("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzayp().zzbau().zzj("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzcix zzcix) {
        Parcel obtain = Parcel.obtain();
        zzcix.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(0, marshall);
        }
        zzayp().zzbaw().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzcnl zzcnl) {
        Parcel obtain = Parcel.obtain();
        zzcnl.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(1, marshall);
        }
        zzayp().zzbaw().log("User property too long for local database. Sending directly to service");
        return false;
    }

    protected final boolean zzazq() {
        return false;
    }

    public final boolean zzc(zzcii zzcii) {
        zzayl();
        byte[] zza = zzcno.zza((Parcelable) zzcii);
        if (zza.length <= 131072) {
            return zzb(2, zza);
        }
        zzayp().zzbaw().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040 A:{Splitter: B:12:0x002e, ExcHandler: android.database.sqlite.SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0192 A:{SYNTHETIC, Splitter: B:115:0x0192} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01e5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01e5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0192 A:{SYNTHETIC, Splitter: B:115:0x0192} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01e5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01e5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0192 A:{SYNTHETIC, Splitter: B:115:0x0192} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01e5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f4  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:17:0x0036, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:18:0x0037, code:
            r2 = r0;
            r9 = null;
     */
    /* JADX WARNING: Missing block: B:19:0x003b, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x003c, code:
            r4 = r0;
            r9 = null;
     */
    /* JADX WARNING: Missing block: B:21:0x0040, code:
            r4 = r15;
     */
    /* JADX WARNING: Missing block: B:22:0x0043, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0044, code:
            r4 = r0;
            r9 = null;
     */
    /* JADX WARNING: Missing block: B:46:?, code:
            zzayp().zzbau().log("Failed to load event from local database");
     */
    /* JADX WARNING: Missing block: B:48:?, code:
            r12.recycle();
     */
    /* JADX WARNING: Missing block: B:60:?, code:
            zzayp().zzbau().log("Failed to load user property from local database");
     */
    /* JADX WARNING: Missing block: B:62:?, code:
            r12.recycle();
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:75:?, code:
            zzayp().zzbau().log("Failed to load user property from local database");
     */
    /* JADX WARNING: Missing block: B:77:?, code:
            r12.recycle();
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:117:0x0196, code:
            if (r15.inTransaction() != false) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:118:0x0198, code:
            r15.endTransaction();
     */
    /* JADX WARNING: Missing block: B:121:0x01ac, code:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:143:0x01ea, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:144:0x01eb, code:
            r2 = r0;
     */
    public final java.util.List<com.google.android.gms.internal.zzbgl> zzep(int r21) {
        /*
        r20 = this;
        r1 = r20;
        r20.zzwj();
        r2 = r1.zzjkb;
        r3 = 0;
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r4 = r20.getContext();
        r5 = "google_app_measurement_local.db";
        r4 = r4.getDatabasePath(r5);
        r4 = r4.exists();
        if (r4 != 0) goto L_0x0021;
    L_0x0020:
        return r2;
    L_0x0021:
        r4 = 5;
        r5 = 0;
        r6 = 0;
        r7 = 5;
    L_0x0025:
        if (r6 >= r4) goto L_0x01f8;
    L_0x0027:
        r8 = 1;
        r15 = r20.getWritableDatabase();	 Catch:{ SQLiteFullException -> 0x01c8, SQLiteDatabaseLockedException -> 0x01b2, SQLiteException -> 0x018c, all -> 0x0186 }
        if (r15 != 0) goto L_0x0048;
    L_0x002e:
        r1.zzjkb = r8;	 Catch:{ SQLiteFullException -> 0x0043, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x003b, all -> 0x0036 }
        if (r15 == 0) goto L_0x0035;
    L_0x0032:
        r15.close();
    L_0x0035:
        return r3;
    L_0x0036:
        r0 = move-exception;
        r2 = r0;
        r9 = r3;
        goto L_0x01ec;
    L_0x003b:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x0190;
    L_0x0040:
        r4 = r15;
        goto L_0x017f;
    L_0x0043:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        goto L_0x01cc;
    L_0x0048:
        r15.beginTransaction();	 Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x017a, all -> 0x0174 }
        r10 = "messages";
        r9 = "rowid";
        r11 = "type";
        r12 = "entry";
        r11 = new java.lang.String[]{r9, r11, r12};	 Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x017a, all -> 0x0174 }
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r16 = 0;
        r17 = "rowid asc";
        r9 = 100;
        r18 = java.lang.Integer.toString(r9);	 Catch:{ SQLiteFullException -> 0x0181, SQLiteDatabaseLockedException -> 0x0040, SQLiteException -> 0x017a, all -> 0x0174 }
        r9 = r15;
        r4 = r15;
        r15 = r16;
        r16 = r17;
        r17 = r18;
        r9 = r9.query(r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ SQLiteFullException -> 0x0170, SQLiteDatabaseLockedException -> 0x017f, SQLiteException -> 0x016c, all -> 0x016a }
        r10 = -1;
    L_0x0072:
        r12 = r9.moveToNext();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        if (r12 == 0) goto L_0x0132;
    L_0x0078:
        r10 = r9.getLong(r5);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r12 = r9.getInt(r8);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = 2;
        r14 = r9.getBlob(r13);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        if (r12 != 0) goto L_0x00bb;
    L_0x0087:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = r14.length;	 Catch:{ zzbgn -> 0x00a6 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbgn -> 0x00a6 }
        r12.setDataPosition(r5);	 Catch:{ zzbgn -> 0x00a6 }
        r13 = com.google.android.gms.internal.zzcix.CREATOR;	 Catch:{ zzbgn -> 0x00a6 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbgn -> 0x00a6 }
        r13 = (com.google.android.gms.internal.zzcix) r13;	 Catch:{ zzbgn -> 0x00a6 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        if (r13 == 0) goto L_0x0072;
    L_0x009f:
        r2.add(r13);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        goto L_0x0072;
    L_0x00a3:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00b7;
    L_0x00a6:
        r13 = r20.zzayp();	 Catch:{ all -> 0x00a3 }
        r13 = r13.zzbau();	 Catch:{ all -> 0x00a3 }
        r14 = "Failed to load event from local database";
        r13.log(r14);	 Catch:{ all -> 0x00a3 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        goto L_0x0072;
    L_0x00b7:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
    L_0x00bb:
        if (r12 != r8) goto L_0x00ef;
    L_0x00bd:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = r14.length;	 Catch:{ zzbgn -> 0x00d7 }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbgn -> 0x00d7 }
        r12.setDataPosition(r5);	 Catch:{ zzbgn -> 0x00d7 }
        r13 = com.google.android.gms.internal.zzcnl.CREATOR;	 Catch:{ zzbgn -> 0x00d7 }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbgn -> 0x00d7 }
        r13 = (com.google.android.gms.internal.zzcnl) r13;	 Catch:{ zzbgn -> 0x00d7 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        goto L_0x00e8;
    L_0x00d4:
        r0 = move-exception;
        r10 = r0;
        goto L_0x00eb;
    L_0x00d7:
        r13 = r20.zzayp();	 Catch:{ all -> 0x00d4 }
        r13 = r13.zzbau();	 Catch:{ all -> 0x00d4 }
        r14 = "Failed to load user property from local database";
        r13.log(r14);	 Catch:{ all -> 0x00d4 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = r3;
    L_0x00e8:
        if (r13 == 0) goto L_0x0072;
    L_0x00ea:
        goto L_0x009f;
    L_0x00eb:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
    L_0x00ef:
        if (r12 != r13) goto L_0x0123;
    L_0x00f1:
        r12 = android.os.Parcel.obtain();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = r14.length;	 Catch:{ zzbgn -> 0x010b }
        r12.unmarshall(r14, r5, r13);	 Catch:{ zzbgn -> 0x010b }
        r12.setDataPosition(r5);	 Catch:{ zzbgn -> 0x010b }
        r13 = com.google.android.gms.internal.zzcii.CREATOR;	 Catch:{ zzbgn -> 0x010b }
        r13 = r13.createFromParcel(r12);	 Catch:{ zzbgn -> 0x010b }
        r13 = (com.google.android.gms.internal.zzcii) r13;	 Catch:{ zzbgn -> 0x010b }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        goto L_0x011c;
    L_0x0108:
        r0 = move-exception;
        r10 = r0;
        goto L_0x011f;
    L_0x010b:
        r13 = r20.zzayp();	 Catch:{ all -> 0x0108 }
        r13 = r13.zzbau();	 Catch:{ all -> 0x0108 }
        r14 = "Failed to load user property from local database";
        r13.log(r14);	 Catch:{ all -> 0x0108 }
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = r3;
    L_0x011c:
        if (r13 == 0) goto L_0x0072;
    L_0x011e:
        goto L_0x009f;
    L_0x011f:
        r12.recycle();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        throw r10;	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
    L_0x0123:
        r12 = r20.zzayp();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r12 = r12.zzbau();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r13 = "Unknown record type in local database";
        r12.log(r13);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        goto L_0x0072;
    L_0x0132:
        r12 = "messages";
        r13 = "rowid <= ?";
        r14 = new java.lang.String[r8];	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r10 = java.lang.Long.toString(r10);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r14[r5] = r10;	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r10 = r4.delete(r12, r13, r14);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r11 = r2.size();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        if (r10 >= r11) goto L_0x0155;
    L_0x0148:
        r10 = r20.zzayp();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r10 = r10.zzbau();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r11 = "Fewer entries removed from local database than expected";
        r10.log(r11);	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
    L_0x0155:
        r4.setTransactionSuccessful();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        r4.endTransaction();	 Catch:{ SQLiteFullException -> 0x0168, SQLiteDatabaseLockedException -> 0x01b4, SQLiteException -> 0x0166 }
        if (r9 == 0) goto L_0x0160;
    L_0x015d:
        r9.close();
    L_0x0160:
        if (r4 == 0) goto L_0x0165;
    L_0x0162:
        r4.close();
    L_0x0165:
        return r2;
    L_0x0166:
        r0 = move-exception;
        goto L_0x016e;
    L_0x0168:
        r0 = move-exception;
        goto L_0x0172;
    L_0x016a:
        r0 = move-exception;
        goto L_0x0176;
    L_0x016c:
        r0 = move-exception;
        r9 = r3;
    L_0x016e:
        r15 = r4;
        goto L_0x017d;
    L_0x0170:
        r0 = move-exception;
        r9 = r3;
    L_0x0172:
        r15 = r4;
        goto L_0x0184;
    L_0x0174:
        r0 = move-exception;
        r4 = r15;
    L_0x0176:
        r2 = r0;
        r9 = r3;
        goto L_0x01ed;
    L_0x017a:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x017d:
        r4 = r0;
        goto L_0x0190;
    L_0x017f:
        r9 = r3;
        goto L_0x01b4;
    L_0x0181:
        r0 = move-exception;
        r4 = r15;
        r9 = r3;
    L_0x0184:
        r4 = r0;
        goto L_0x01cc;
    L_0x0186:
        r0 = move-exception;
        r2 = r0;
        r4 = r3;
        r9 = r4;
        goto L_0x01ed;
    L_0x018c:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x0190:
        if (r15 == 0) goto L_0x019b;
    L_0x0192:
        r10 = r15.inTransaction();	 Catch:{ all -> 0x01ea }
        if (r10 == 0) goto L_0x019b;
    L_0x0198:
        r15.endTransaction();	 Catch:{ all -> 0x01ea }
    L_0x019b:
        r10 = r20.zzayp();	 Catch:{ all -> 0x01ea }
        r10 = r10.zzbau();	 Catch:{ all -> 0x01ea }
        r11 = "Error reading entries from local database";
        r10.zzj(r11, r4);	 Catch:{ all -> 0x01ea }
        r1.zzjkb = r8;	 Catch:{ all -> 0x01ea }
        if (r9 == 0) goto L_0x01af;
    L_0x01ac:
        r9.close();
    L_0x01af:
        if (r15 == 0) goto L_0x01e5;
    L_0x01b1:
        goto L_0x01e2;
    L_0x01b2:
        r4 = r3;
        r9 = r4;
    L_0x01b4:
        r10 = (long) r7;
        android.os.SystemClock.sleep(r10);	 Catch:{ all -> 0x01c5 }
        r7 = r7 + 20;
        if (r9 == 0) goto L_0x01bf;
    L_0x01bc:
        r9.close();
    L_0x01bf:
        if (r4 == 0) goto L_0x01e5;
    L_0x01c1:
        r4.close();
        goto L_0x01e5;
    L_0x01c5:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01ed;
    L_0x01c8:
        r0 = move-exception;
        r4 = r0;
        r9 = r3;
        r15 = r9;
    L_0x01cc:
        r10 = r20.zzayp();	 Catch:{ all -> 0x01ea }
        r10 = r10.zzbau();	 Catch:{ all -> 0x01ea }
        r11 = "Error reading entries from local database";
        r10.zzj(r11, r4);	 Catch:{ all -> 0x01ea }
        r1.zzjkb = r8;	 Catch:{ all -> 0x01ea }
        if (r9 == 0) goto L_0x01e0;
    L_0x01dd:
        r9.close();
    L_0x01e0:
        if (r15 == 0) goto L_0x01e5;
    L_0x01e2:
        r15.close();
    L_0x01e5:
        r6 = r6 + 1;
        r4 = 5;
        goto L_0x0025;
    L_0x01ea:
        r0 = move-exception;
        r2 = r0;
    L_0x01ec:
        r4 = r15;
    L_0x01ed:
        if (r9 == 0) goto L_0x01f2;
    L_0x01ef:
        r9.close();
    L_0x01f2:
        if (r4 == 0) goto L_0x01f7;
    L_0x01f4:
        r4.close();
    L_0x01f7:
        throw r2;
    L_0x01f8:
        r2 = r20.zzayp();
        r2 = r2.zzbaw();
        r4 = "Failed to read events from database in reasonable time";
        r2.log(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjf.zzep(int):java.util.List<com.google.android.gms.internal.zzbgl>");
    }
}
