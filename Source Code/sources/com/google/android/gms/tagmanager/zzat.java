package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class zzat implements zzc {
    private static final String zzkot = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", b.VALUE, "expires"});
    private final Context mContext;
    private zze zzata;
    private final Executor zzkou;
    private zzax zzkov;
    private int zzkow;

    public zzat(Context context) {
        this(context, zzi.zzanq(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    private zzat(Context context, zze zze, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzata = zze;
        this.zzkow = 2000;
        this.zzkou = executor;
        this.zzkov = new zzax(this, this.mContext, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f A:{SYNTHETIC, Splitter: B:12:0x001f} */
    private static byte[] zzaj(java.lang.Object r3) {
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0026, all -> 0x001c }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0026, all -> 0x001c }
        r2.writeObject(r3);	 Catch:{ IOException -> 0x0027, all -> 0x0019 }
        r3 = r0.toByteArray();	 Catch:{ IOException -> 0x0027, all -> 0x0019 }
        r2.close();	 Catch:{ IOException -> 0x0018 }
        r0.close();	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        return r3;
    L_0x0019:
        r3 = move-exception;
        r1 = r2;
        goto L_0x001d;
    L_0x001c:
        r3 = move-exception;
    L_0x001d:
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0025 }
    L_0x0022:
        r0.close();	 Catch:{ IOException -> 0x0025 }
    L_0x0025:
        throw r3;
    L_0x0026:
        r2 = r1;
    L_0x0027:
        if (r2 == 0) goto L_0x002c;
    L_0x0029:
        r2.close();	 Catch:{ IOException -> 0x002f }
    L_0x002c:
        r0.close();	 Catch:{ IOException -> 0x002f }
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzaj(java.lang.Object):byte[]");
    }

    private final synchronized void zzb(List<zzay> list, long j) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.zzata.currentTimeMillis();
            zzbh(currentTimeMillis);
            int zzbgg = (zzbgg() - this.zzkow) + list.size();
            if (zzbgg > 0) {
                List zzez = zzez(zzbgg);
                zzbgg = zzez.size();
                StringBuilder stringBuilder = new StringBuilder(64);
                stringBuilder.append("DataLayer store full, deleting ");
                stringBuilder.append(zzbgg);
                stringBuilder.append(" entries to make room.");
                zzdj.zzcy(stringBuilder.toString());
                strArr = (String[]) zzez.toArray(new String[0]);
                if (!(strArr == null || strArr.length == 0)) {
                    SQLiteDatabase zzlq = zzlq("Error opening database for deleteEntries.");
                    if (zzlq != null) {
                        zzlq.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    }
                }
            }
        } catch (SQLiteException unused) {
            String str = "Error deleting entries ";
            String valueOf = String.valueOf(Arrays.toString(strArr));
            zzdj.zzcz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        } catch (Throwable th) {
            zzbgh();
        }
        zzc(list, currentTimeMillis + j);
        zzbgh();
    }

    private final List<zza> zzbge() {
        try {
            zzbh(this.zzata.currentTimeMillis());
            List<zzay> zzbgf = zzbgf();
            List<zza> arrayList = new ArrayList();
            for (zzay zzay : zzbgf) {
                arrayList.add(new zza(zzay.zzbkr, zzy(zzay.zzkpc)));
            }
            return arrayList;
        } finally {
            zzbgh();
        }
    }

    private final List<zzay> zzbgf() {
        SQLiteDatabase zzlq = zzlq("Error opening database for loadSerialized.");
        List<zzay> arrayList = new ArrayList();
        if (zzlq == null) {
            return arrayList;
        }
        Cursor query = zzlq.query("datalayer", new String[]{"key", b.VALUE}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzay(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0036  */
    private final int zzbgg() {
        /*
        r4 = this;
        r0 = "Error opening database for getNumStoredEntries.";
        r0 = r4.zzlq(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = 0;
        r3 = "SELECT COUNT(*) from datalayer";
        r0 = r0.rawQuery(r3, r2);	 Catch:{ SQLiteException -> 0x0029 }
        r2 = r0.moveToFirst();	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        if (r2 == 0) goto L_0x001c;
    L_0x0017:
        r2 = r0.getLong(r1);	 Catch:{ SQLiteException -> 0x0025, all -> 0x0022 }
        r1 = (int) r2;
    L_0x001c:
        if (r0 == 0) goto L_0x0033;
    L_0x001e:
        r0.close();
        return r1;
    L_0x0022:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0034;
    L_0x0025:
        r2 = r0;
        goto L_0x0029;
    L_0x0027:
        r1 = move-exception;
        goto L_0x0034;
    L_0x0029:
        r0 = "Error getting numStoredEntries";
        com.google.android.gms.tagmanager.zzdj.zzcz(r0);	 Catch:{ all -> 0x0027 }
        if (r2 == 0) goto L_0x0033;
    L_0x0030:
        r2.close();
    L_0x0033:
        return r1;
    L_0x0034:
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.close();
    L_0x0039:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzbgg():int");
    }

    private final void zzbgh() {
        try {
            this.zzkov.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzbh(long j) {
        SQLiteDatabase zzlq = zzlq("Error opening database for deleteOlderThan.");
        if (zzlq != null) {
            try {
                int delete = zzlq.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Deleted ");
                stringBuilder.append(delete);
                stringBuilder.append(" expired items");
                zzdj.v(stringBuilder.toString());
            } catch (SQLiteException unused) {
                zzdj.zzcz("Error deleting old entries.");
            }
        }
    }

    private final void zzc(List<zzay> list, long j) {
        SQLiteDatabase zzlq = zzlq("Error opening database for writeEntryToDatabase.");
        if (zzlq != null) {
            for (zzay zzay : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", zzay.zzbkr);
                contentValues.put(b.VALUE, zzay.zzkpc);
                zzlq.insert("datalayer", null, contentValues);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076 A:{Catch:{ all -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A:{Catch:{ all -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    private final java.util.List<java.lang.String> zzez(int r15) {
        /*
        r14 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        if (r15 > 0) goto L_0x000d;
    L_0x0007:
        r15 = "Invalid maxEntries specified. Skipping.";
        com.google.android.gms.tagmanager.zzdj.zzcz(r15);
        return r0;
    L_0x000d:
        r1 = "Error opening database for peekEntryIds.";
        r2 = r14.zzlq(r1);
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = 0;
        r3 = "datalayer";
        r4 = "ID";
        r4 = new java.lang.String[]{r4};	 Catch:{ SQLiteException -> 0x0060 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0060 }
        r11 = "ID";
        r12 = 0;
        r10[r12] = r11;	 Catch:{ SQLiteException -> 0x0060 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0060 }
        r10 = java.lang.Integer.toString(r15);	 Catch:{ SQLiteException -> 0x0060 }
        r15 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0060 }
        r1 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
        if (r1 == 0) goto L_0x0050;
    L_0x003f:
        r1 = r15.getLong(r12);	 Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
        r0.add(r1);	 Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
        r1 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x0059, all -> 0x0056 }
        if (r1 != 0) goto L_0x003f;
    L_0x0050:
        if (r15 == 0) goto L_0x0083;
    L_0x0052:
        r15.close();
        return r0;
    L_0x0056:
        r0 = move-exception;
        r1 = r15;
        goto L_0x0084;
    L_0x0059:
        r1 = move-exception;
        r13 = r1;
        r1 = r15;
        r15 = r13;
        goto L_0x0061;
    L_0x005e:
        r0 = move-exception;
        goto L_0x0084;
    L_0x0060:
        r15 = move-exception;
    L_0x0061:
        r2 = "Error in peekEntries fetching entryIds: ";
        r15 = r15.getMessage();	 Catch:{ all -> 0x005e }
        r15 = java.lang.String.valueOf(r15);	 Catch:{ all -> 0x005e }
        r3 = r15.length();	 Catch:{ all -> 0x005e }
        if (r3 == 0) goto L_0x0076;
    L_0x0071:
        r15 = r2.concat(r15);	 Catch:{ all -> 0x005e }
        goto L_0x007b;
    L_0x0076:
        r15 = new java.lang.String;	 Catch:{ all -> 0x005e }
        r15.<init>(r2);	 Catch:{ all -> 0x005e }
    L_0x007b:
        com.google.android.gms.tagmanager.zzdj.zzcz(r15);	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0083;
    L_0x0080:
        r1.close();
    L_0x0083:
        return r0;
    L_0x0084:
        if (r1 == 0) goto L_0x0089;
    L_0x0086:
        r1.close();
    L_0x0089:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzez(int):java.util.List<java.lang.String>");
    }

    private final void zzlp(String str) {
        SQLiteDatabase zzlq = zzlq("Error opening database for clearKeysWithPrefix.");
        if (zzlq != null) {
            StringBuilder stringBuilder;
            try {
                int delete = zzlq.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
                stringBuilder = new StringBuilder(25);
                stringBuilder.append("Cleared ");
                stringBuilder.append(delete);
                stringBuilder.append(" items");
                zzdj.v(stringBuilder.toString());
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 44) + String.valueOf(valueOf).length());
                stringBuilder.append("Error deleting entries with key prefix: ");
                stringBuilder.append(str);
                stringBuilder.append(" (");
                stringBuilder.append(valueOf);
                stringBuilder.append(").");
                zzdj.zzcz(stringBuilder.toString());
            } finally {
                zzbgh();
            }
        }
    }

    private final SQLiteDatabase zzlq(String str) {
        try {
            return this.zzkov.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdj.zzcz(str);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A:{SYNTHETIC, Splitter: B:12:0x001e} */
    private static java.lang.Object zzy(byte[] r4) {
        /*
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r4);
        r4 = 0;
        r1 = new java.io.ObjectInputStream;	 Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
        r1.<init>(r0);	 Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x001b }
        r2 = r1.readObject();	 Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0026, all -> 0x0016 }
        r1.close();	 Catch:{ IOException -> 0x0015 }
        r0.close();	 Catch:{ IOException -> 0x0015 }
    L_0x0015:
        return r2;
    L_0x0016:
        r4 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r3;
        goto L_0x001c;
    L_0x001b:
        r1 = move-exception;
    L_0x001c:
        if (r4 == 0) goto L_0x0021;
    L_0x001e:
        r4.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0021:
        r0.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0024:
        throw r1;
    L_0x0025:
        r1 = r4;
    L_0x0026:
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.close();	 Catch:{ IOException -> 0x002e }
    L_0x002b:
        r0.close();	 Catch:{ IOException -> 0x002e }
    L_0x002e:
        return r4;
    L_0x002f:
        r1 = r4;
    L_0x0030:
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0035:
        r0.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzy(byte[]):java.lang.Object");
    }

    public final void zza(zzaq zzaq) {
        this.zzkou.execute(new zzav(this, zzaq));
    }

    public final void zza(List<zza> list, long j) {
        List arrayList = new ArrayList();
        for (zza zza : list) {
            arrayList.add(new zzay(zza.zzbkr, zzaj(zza.mValue)));
        }
        this.zzkou.execute(new zzau(this, arrayList, j));
    }

    public final void zzlo(String str) {
        this.zzkou.execute(new zzaw(this, str));
    }
}
