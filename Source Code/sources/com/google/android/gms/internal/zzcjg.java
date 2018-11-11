package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.WorkerThread;

final class zzcjg extends SQLiteOpenHelper {
    private /* synthetic */ zzcjf zzjkc;

    zzcjg(zzcjf zzcjf, Context context, String str) {
        this.zzjkc = zzcjf;
        super(context, str, null, 1);
    }

    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            this.zzjkc.zzayp().zzbau().log("Opening the local database failed, dropping and recreating it");
            String str = "google_app_measurement_local.db";
            if (!this.zzjkc.getContext().getDatabasePath(str).delete()) {
                this.zzjkc.zzayp().zzbau().zzj("Failed to delete corrupted local db file", str);
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                this.zzjkc.zzayp().zzbau().zzj("Failed to open local database. Events will bypass local storage", e2);
                return null;
            }
        }
    }

    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzcil.zza(this.zzjkc.zzayp(), sQLiteDatabase);
    }

    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001c  */
    @android.support.annotation.WorkerThread
    public final void onOpen(android.database.sqlite.SQLiteDatabase r8) {
        /*
        r7 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 15;
        if (r0 >= r1) goto L_0x0020;
    L_0x0006:
        r0 = 0;
        r1 = "PRAGMA journal_mode=memory";
        r1 = r8.rawQuery(r1, r0);	 Catch:{ all -> 0x0019 }
        r1.moveToFirst();	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0020;
    L_0x0012:
        r1.close();
        goto L_0x0020;
    L_0x0016:
        r8 = move-exception;
        r0 = r1;
        goto L_0x001a;
    L_0x0019:
        r8 = move-exception;
    L_0x001a:
        if (r0 == 0) goto L_0x001f;
    L_0x001c:
        r0.close();
    L_0x001f:
        throw r8;
    L_0x0020:
        r0 = r7.zzjkc;
        r1 = r0.zzayp();
        r3 = "messages";
        r4 = "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)";
        r5 = "type,entry";
        r6 = 0;
        r2 = r8;
        com.google.android.gms.internal.zzcil.zza(r1, r2, r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjg.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
