package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Set;

final class zzee extends SQLiteOpenHelper {
    private /* synthetic */ zzec zzkrg;
    private boolean zzkrh;
    private long zzkri = 0;

    zzee(zzec zzec, Context context, String str) {
        this.zzkrg = zzec;
        super(context, str, null, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    private static boolean zza(java.lang.String r10, android.database.sqlite.SQLiteDatabase r11) {
        /*
        r0 = 0;
        r1 = 0;
        r3 = "SQLITE_MASTER";
        r2 = "name";
        r4 = new java.lang.String[]{r2};	 Catch:{ SQLiteException -> 0x002a }
        r5 = "name=?";
        r2 = 1;
        r6 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x002a }
        r6[r0] = r10;	 Catch:{ SQLiteException -> 0x002a }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r2 = r11;
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ SQLiteException -> 0x002a }
        r1 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x0026, all -> 0x0023 }
        if (r11 == 0) goto L_0x0022;
    L_0x001f:
        r11.close();
    L_0x0022:
        return r1;
    L_0x0023:
        r10 = move-exception;
        r1 = r11;
        goto L_0x0049;
    L_0x0026:
        r1 = r11;
        goto L_0x002a;
    L_0x0028:
        r10 = move-exception;
        goto L_0x0049;
    L_0x002a:
        r11 = "Error querying for table ";
        r10 = java.lang.String.valueOf(r10);	 Catch:{ all -> 0x0028 }
        r2 = r10.length();	 Catch:{ all -> 0x0028 }
        if (r2 == 0) goto L_0x003b;
    L_0x0036:
        r10 = r11.concat(r10);	 Catch:{ all -> 0x0028 }
        goto L_0x0040;
    L_0x003b:
        r10 = new java.lang.String;	 Catch:{ all -> 0x0028 }
        r10.<init>(r11);	 Catch:{ all -> 0x0028 }
    L_0x0040:
        com.google.android.gms.tagmanager.zzdj.zzcz(r10);	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();
    L_0x0048:
        return r0;
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();
    L_0x004e:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzee.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzkrh || this.zzkri + 3600000 <= this.zzkrg.zzata.currentTimeMillis()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.zzkrh = true;
            this.zzkri = this.zzkrg.zzata.currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zzkrg.mContext.getDatabasePath(this.zzkrg.zzkrd).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.zzkrh = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzbs.zzlu(sQLiteDatabase.getPath());
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (zza("gtm_hits", sQLiteDatabase)) {
            Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery2.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery2.close();
            }
        } else {
            sQLiteDatabase.execSQL(zzec.zzdzv);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
