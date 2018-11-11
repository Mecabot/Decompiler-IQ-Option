package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.Collections;
import java.util.List;

final class zzec implements zzcc {
    private static final String zzdzv = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private final Context mContext;
    private zze zzata;
    private final zzee zzkra;
    private volatile zzbe zzkrb;
    private final zzcd zzkrc;
    private final String zzkrd;
    private long zzkre;
    private final int zzkrf;

    zzec(zzcd zzcd, Context context) {
        this(zzcd, context, "gtm_urls.db", 2000);
    }

    private zzec(zzcd zzcd, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzkrd = str;
        this.zzkrc = zzcd;
        this.zzata = zzi.zzanq();
        this.zzkra = new zzee(this, this.mContext, this.zzkrd);
        this.zzkrb = new zzfv(this.mContext, new zzed(this));
        this.zzkre = 0;
        this.zzkrf = 2000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0036  */
    private final int zzbhe() {
        /*
        r4 = this;
        r0 = "Error opening database for getNumStoredHits.";
        r0 = r4.zzlq(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = 0;
        r3 = "SELECT COUNT(*) from gtm_hits";
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
        r0 = "Error getting numStoredHits";
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzec.zzbhe():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e  */
    private final int zzbhf() {
        /*
        r10 = this;
        r0 = "Error opening database for getNumStoredHits.";
        r1 = r10.zzlq(r0);
        r0 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r9 = 0;
        r2 = "gtm_hits";
        r3 = "hit_id";
        r4 = "hit_first_send_time";
        r3 = new java.lang.String[]{r3, r4};	 Catch:{ SQLiteException -> 0x0031 }
        r4 = "hit_first_send_time=0";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x0031 }
        r2 = r1.getCount();	 Catch:{ SQLiteException -> 0x002d, all -> 0x002a }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r1.close();
    L_0x0028:
        r0 = r2;
        return r0;
    L_0x002a:
        r0 = move-exception;
        r9 = r1;
        goto L_0x003c;
    L_0x002d:
        r9 = r1;
        goto L_0x0031;
    L_0x002f:
        r0 = move-exception;
        goto L_0x003c;
    L_0x0031:
        r1 = "Error getting num untried hits";
        com.google.android.gms.tagmanager.zzdj.zzcz(r1);	 Catch:{ all -> 0x002f }
        if (r9 == 0) goto L_0x003b;
    L_0x0038:
        r9.close();
    L_0x003b:
        return r0;
    L_0x003c:
        if (r9 == 0) goto L_0x0041;
    L_0x003e:
        r9.close();
    L_0x0041:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzec.zzbhf():int");
    }

    private final void zze(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzlq = zzlq("Error opening database for deleteHits.");
            if (zzlq != null) {
                boolean z = true;
                try {
                    zzlq.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    zzcd zzcd = this.zzkrc;
                    if (zzbhe() != 0) {
                        z = false;
                    }
                    zzcd.zzbz(z);
                } catch (SQLiteException unused) {
                    zzdj.zzcz("Error deleting hits");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076 A:{Catch:{ all -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A:{Catch:{ all -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    private final java.util.List<java.lang.String> zzfe(int r15) {
        /*
        r14 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        if (r15 > 0) goto L_0x000d;
    L_0x0007:
        r15 = "Invalid maxHits specified. Skipping";
        com.google.android.gms.tagmanager.zzdj.zzcz(r15);
        return r0;
    L_0x000d:
        r1 = "Error opening database for peekHitIds.";
        r2 = r14.zzlq(r1);
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r1 = 0;
        r3 = "gtm_hits";
        r4 = "hit_id";
        r4 = new java.lang.String[]{r4};	 Catch:{ SQLiteException -> 0x0060 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0060 }
        r11 = "hit_id";
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
        r2 = "Error in peekHits fetching hitIds: ";
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzec.zzfe(int):java.util.List<java.lang.String>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0112 A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010d A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129 A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010d A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0112 A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0129 A:{Catch:{ all -> 0x0148 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0183 A:{Catch:{ all -> 0x0191 }} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x017e A:{Catch:{ all -> 0x0191 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x017e A:{Catch:{ all -> 0x0191 }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0183 A:{Catch:{ all -> 0x0191 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0158 A:{Splitter: B:5:0x003d, ExcHandler: all (r0_11 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:68:0x0150, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:69:0x0151, code:
            r2 = r11;
            r1 = r0;
            r13 = r12;
     */
    /* JADX WARNING: Missing block: B:70:0x0158, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:71:0x0159, code:
            r1 = r0;
            r13 = r12;
     */
    private final java.util.List<com.google.android.gms.tagmanager.zzbx> zzff(int r19) {
        /*
        r18 = this;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "Error opening database for peekHits";
        r3 = r18;
        r2 = r3.zzlq(r2);
        if (r2 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r5 = "gtm_hits";
        r4 = "hit_id";
        r6 = "hit_time";
        r7 = "hit_first_send_time";
        r6 = new java.lang.String[]{r4, r6, r7};	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r4 = "%s ASC";
        r14 = 1;
        r11 = new java.lang.Object[r14];	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r12 = "hit_id";
        r15 = 0;
        r11[r15] = r12;	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r11 = java.lang.String.format(r4, r11);	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r12 = 40;
        r16 = java.lang.Integer.toString(r12);	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r4 = r2;
        r13 = 40;
        r12 = r16;
        r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ SQLiteException -> 0x016a, all -> 0x0166 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x015f, all -> 0x0158 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x015f, all -> 0x0158 }
        r1 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x0150, all -> 0x0158 }
        if (r1 == 0) goto L_0x006f;
    L_0x0048:
        r1 = new com.google.android.gms.tagmanager.zzbx;	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r5 = r12.getLong(r15);	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r7 = r12.getLong(r14);	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r4 = 2;
        r9 = r12.getLong(r4);	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r4 = r1;
        r4.<init>(r5, r7, r9);	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r11.add(r1);	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        r1 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x006a, all -> 0x0065 }
        if (r1 != 0) goto L_0x0048;
    L_0x0064:
        goto L_0x006f;
    L_0x0065:
        r0 = move-exception;
        r1 = r0;
        r13 = r12;
        goto L_0x0193;
    L_0x006a:
        r0 = move-exception;
        r1 = r0;
        r13 = r12;
        goto L_0x016e;
    L_0x006f:
        if (r12 == 0) goto L_0x0074;
    L_0x0071:
        r12.close();
    L_0x0074:
        r5 = "gtm_hits";
        r1 = "hit_id";
        r4 = "hit_url";
        r6 = new java.lang.String[]{r1, r4};	 Catch:{ SQLiteException -> 0x00f8, all -> 0x00f3 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r1 = "%s ASC";
        r4 = new java.lang.Object[r14];	 Catch:{ SQLiteException -> 0x00f8, all -> 0x00f3 }
        r16 = "hit_id";
        r4[r15] = r16;	 Catch:{ SQLiteException -> 0x00f8, all -> 0x00f3 }
        r1 = java.lang.String.format(r1, r4);	 Catch:{ SQLiteException -> 0x00f8, all -> 0x00f3 }
        r13 = java.lang.Integer.toString(r13);	 Catch:{ SQLiteException -> 0x00f8, all -> 0x00f3 }
        r4 = r2;
        r2 = r11;
        r11 = r1;
        r16 = r12;
        r12 = r13;
        r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ SQLiteException -> 0x00ee, all -> 0x00e9 }
        r1 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x00e7 }
        if (r1 == 0) goto L_0x00e1;
    L_0x00a2:
        r1 = 0;
    L_0x00a3:
        r4 = r12;
        r4 = (android.database.sqlite.SQLiteCursor) r4;	 Catch:{ SQLiteException -> 0x00e7 }
        r4 = r4.getWindow();	 Catch:{ SQLiteException -> 0x00e7 }
        r4 = r4.getNumRows();	 Catch:{ SQLiteException -> 0x00e7 }
        if (r4 <= 0) goto L_0x00be;
    L_0x00b0:
        r4 = r2.get(r1);	 Catch:{ SQLiteException -> 0x00e7 }
        r4 = (com.google.android.gms.tagmanager.zzbx) r4;	 Catch:{ SQLiteException -> 0x00e7 }
        r5 = r12.getString(r14);	 Catch:{ SQLiteException -> 0x00e7 }
        r4.zzlv(r5);	 Catch:{ SQLiteException -> 0x00e7 }
        goto L_0x00d9;
    L_0x00be:
        r4 = "HitString for hitId %d too large.  Hit will be deleted.";
        r5 = new java.lang.Object[r14];	 Catch:{ SQLiteException -> 0x00e7 }
        r6 = r2.get(r1);	 Catch:{ SQLiteException -> 0x00e7 }
        r6 = (com.google.android.gms.tagmanager.zzbx) r6;	 Catch:{ SQLiteException -> 0x00e7 }
        r6 = r6.zzbgr();	 Catch:{ SQLiteException -> 0x00e7 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SQLiteException -> 0x00e7 }
        r5[r15] = r6;	 Catch:{ SQLiteException -> 0x00e7 }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ SQLiteException -> 0x00e7 }
        com.google.android.gms.tagmanager.zzdj.zzcz(r4);	 Catch:{ SQLiteException -> 0x00e7 }
    L_0x00d9:
        r1 = r1 + 1;
        r4 = r12.moveToNext();	 Catch:{ SQLiteException -> 0x00e7 }
        if (r4 != 0) goto L_0x00a3;
    L_0x00e1:
        if (r12 == 0) goto L_0x00e6;
    L_0x00e3:
        r12.close();
    L_0x00e6:
        return r2;
    L_0x00e7:
        r0 = move-exception;
        goto L_0x00fc;
    L_0x00e9:
        r0 = move-exception;
        r1 = r0;
        r12 = r16;
        goto L_0x014a;
    L_0x00ee:
        r0 = move-exception;
        r1 = r0;
        r12 = r16;
        goto L_0x00fd;
    L_0x00f3:
        r0 = move-exception;
        r16 = r12;
    L_0x00f6:
        r1 = r0;
        goto L_0x014a;
    L_0x00f8:
        r0 = move-exception;
        r2 = r11;
        r16 = r12;
    L_0x00fc:
        r1 = r0;
    L_0x00fd:
        r4 = "Error in peekHits fetching hit url: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0148 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0148 }
        r5 = r1.length();	 Catch:{ all -> 0x0148 }
        if (r5 == 0) goto L_0x0112;
    L_0x010d:
        r1 = r4.concat(r1);	 Catch:{ all -> 0x0148 }
        goto L_0x0117;
    L_0x0112:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0148 }
        r1.<init>(r4);	 Catch:{ all -> 0x0148 }
    L_0x0117:
        com.google.android.gms.tagmanager.zzdj.zzcz(r1);	 Catch:{ all -> 0x0148 }
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0148 }
        r1.<init>();	 Catch:{ all -> 0x0148 }
        r11 = r2;
        r11 = (java.util.ArrayList) r11;	 Catch:{ all -> 0x0148 }
        r2 = r11.size();	 Catch:{ all -> 0x0148 }
        r4 = 0;
    L_0x0127:
        if (r15 >= r2) goto L_0x0142;
    L_0x0129:
        r5 = r11.get(r15);	 Catch:{ all -> 0x0148 }
        r15 = r15 + 1;
        r5 = (com.google.android.gms.tagmanager.zzbx) r5;	 Catch:{ all -> 0x0148 }
        r6 = r5.zzbgt();	 Catch:{ all -> 0x0148 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0148 }
        if (r6 == 0) goto L_0x013e;
    L_0x013b:
        if (r4 != 0) goto L_0x0142;
    L_0x013d:
        r4 = 1;
    L_0x013e:
        r1.add(r5);	 Catch:{ all -> 0x0148 }
        goto L_0x0127;
    L_0x0142:
        if (r12 == 0) goto L_0x0147;
    L_0x0144:
        r12.close();
    L_0x0147:
        return r1;
    L_0x0148:
        r0 = move-exception;
        goto L_0x00f6;
    L_0x014a:
        if (r12 == 0) goto L_0x014f;
    L_0x014c:
        r12.close();
    L_0x014f:
        throw r1;
    L_0x0150:
        r0 = move-exception;
        r2 = r11;
        r16 = r12;
        r1 = r0;
        r13 = r16;
        goto L_0x016e;
    L_0x0158:
        r0 = move-exception;
        r16 = r12;
        r1 = r0;
        r13 = r16;
        goto L_0x0193;
    L_0x015f:
        r0 = move-exception;
        r16 = r12;
        r11 = r1;
        r13 = r16;
        goto L_0x016d;
    L_0x0166:
        r0 = move-exception;
        r1 = r0;
        r13 = 0;
        goto L_0x0193;
    L_0x016a:
        r0 = move-exception;
        r11 = r1;
        r13 = 0;
    L_0x016d:
        r1 = r0;
    L_0x016e:
        r2 = "Error in peekHits fetching hitIds: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0191 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0191 }
        r4 = r1.length();	 Catch:{ all -> 0x0191 }
        if (r4 == 0) goto L_0x0183;
    L_0x017e:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0191 }
        goto L_0x0188;
    L_0x0183:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0191 }
        r1.<init>(r2);	 Catch:{ all -> 0x0191 }
    L_0x0188:
        com.google.android.gms.tagmanager.zzdj.zzcz(r1);	 Catch:{ all -> 0x0191 }
        if (r13 == 0) goto L_0x0190;
    L_0x018d:
        r13.close();
    L_0x0190:
        return r11;
    L_0x0191:
        r0 = move-exception;
        r1 = r0;
    L_0x0193:
        if (r13 == 0) goto L_0x0198;
    L_0x0195:
        r13.close();
    L_0x0198:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzec.zzff(int):java.util.List<com.google.android.gms.tagmanager.zzbx>");
    }

    private final void zzh(long j, long j2) {
        SQLiteDatabase zzlq = zzlq("Error opening database for getNumStoredHits.");
        if (zzlq != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzlq.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException unused) {
                StringBuilder stringBuilder = new StringBuilder(69);
                stringBuilder.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
                stringBuilder.append(j);
                zzdj.zzcz(stringBuilder.toString());
                zzp(j);
            }
        }
    }

    private final SQLiteDatabase zzlq(String str) {
        try {
            return this.zzkra.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdj.zzcz(str);
            return null;
        }
    }

    private final void zzp(long j) {
        zze(new String[]{String.valueOf(j)});
    }

    public final void dispatch() {
        zzdj.v("GTM Dispatch running...");
        if (this.zzkrb.zzbgj()) {
            List zzff = zzff(40);
            if (zzff.isEmpty()) {
                zzdj.v("...nothing to dispatch");
                this.zzkrc.zzbz(true);
                return;
            }
            this.zzkrb.zzam(zzff);
            if (zzbhf() > 0) {
                zzfo.zzbhz().dispatch();
            }
        }
    }

    public final void zzb(long j, String str) {
        SQLiteDatabase zzlq;
        long currentTimeMillis = this.zzata.currentTimeMillis();
        if (currentTimeMillis > this.zzkre + 86400000) {
            this.zzkre = currentTimeMillis;
            zzlq = zzlq("Error opening database for deleteStaleHits.");
            if (zzlq != null) {
                long currentTimeMillis2 = this.zzata.currentTimeMillis() - 2592000000L;
                zzlq.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(currentTimeMillis2)});
                this.zzkrc.zzbz(zzbhe() == 0);
            }
        }
        int zzbhe = (zzbhe() - this.zzkrf) + 1;
        if (zzbhe > 0) {
            List zzfe = zzfe(zzbhe);
            int size = zzfe.size();
            StringBuilder stringBuilder = new StringBuilder(51);
            stringBuilder.append("Store full, deleting ");
            stringBuilder.append(size);
            stringBuilder.append(" hits to make room.");
            zzdj.v(stringBuilder.toString());
            zze((String[]) zzfe.toArray(new String[0]));
        }
        zzlq = zzlq("Error opening database for putHit");
        if (zzlq != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            try {
                zzlq.insert("gtm_hits", null, contentValues);
                this.zzkrc.zzbz(false);
            } catch (SQLiteException unused) {
                zzdj.zzcz("Error storing hit");
            }
        }
    }
}
