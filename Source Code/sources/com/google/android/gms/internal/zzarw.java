package com.google.android.gms.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Hide
final class zzarw extends zzari {
    private boolean mStarted;
    private final zzart zzeab;
    private final zzatf zzeac;
    private final zzate zzead;
    private final zzaro zzeae;
    private long zzeaf = Long.MIN_VALUE;
    private final zzasn zzeag;
    private final zzasn zzeah;
    private final zzatp zzeai;
    private long zzeaj;
    private boolean zzeak;

    protected zzarw(zzark zzark, zzarm zzarm) {
        super(zzark);
        zzbq.checkNotNull(zzarm);
        this.zzead = new zzate(zzark);
        this.zzeab = new zzart(zzark);
        this.zzeac = new zzatf(zzark);
        this.zzeae = new zzaro(zzark);
        this.zzeai = new zzatp(zzxx());
        this.zzeag = new zzarx(this, zzark);
        this.zzeah = new zzary(this, zzark);
    }

    private final void zza(zzarn zzarn, zzaqm zzaqm) {
        zzbq.checkNotNull(zzarn);
        zzbq.checkNotNull(zzaqm);
        zzj zza = new zza(zzxw());
        zza.zzdk(zzarn.zzys());
        zza.enableAdvertisingIdCollection(zzarn.zzyt());
        zzg zzvs = zza.zzvs();
        zzaqu zzaqu = (zzaqu) zzvs.zzb(zzaqu.class);
        zzaqu.zzdv("data");
        zzaqu.zzan(true);
        zzvs.zza((zzi) zzaqm);
        zzaqp zzaqp = (zzaqp) zzvs.zzb(zzaqp.class);
        zzaql zzaql = (zzaql) zzvs.zzb(zzaql.class);
        for (Entry entry : zzarn.zzjq().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzaql.setAppName(str2);
            } else if ("av".equals(str)) {
                zzaql.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzaql.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzaql.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                zzaqu.setUserId(str2);
            } else {
                zzaqp.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzarn.zzys(), zzaqm);
        zzvs.zzl(zzyf().zzaba());
        zzvs.zzwa();
    }

    private final boolean zzeh(String str) {
        return zzbih.zzdd(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    private final long zzza() {
        zzk.zzwj();
        zzyk();
        try {
            return this.zzeab.zzza();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private final void zzzf() {
        zzb(new zzasa(this));
    }

    private final void zzzg() {
        try {
            this.zzeab.zzyz();
            zzzk();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzeah.zzs(86400000);
    }

    private final void zzzh() {
        if (!this.zzeak && zzasl.zzzv() && !this.zzeae.isConnected()) {
            if (this.zzeai.zzu(((Long) zzast.zzecz.get()).longValue())) {
                this.zzeai.start();
                zzea("Connecting to service");
                if (this.zzeae.connect()) {
                    zzea("Connected to service");
                    this.zzeai.clear();
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:26:0x0090, code:
            zzd("Database contains successfully uploaded hit", java.lang.Long.valueOf(r4), java.lang.Integer.valueOf(r6.size()));
            zzzm();
     */
    private final boolean zzzi() {
        /*
        r11 = this;
        com.google.android.gms.analytics.zzk.zzwj();
        r11.zzyk();
        r0 = "Dispatching a batch of local hits";
        r11.zzea(r0);
        r0 = r11.zzeae;
        r0 = r0.isConnected();
        r0 = r0 ^ 1;
        r1 = r11.zzeac;
        r1 = r1.zzaax();
        r1 = r1 ^ 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0026;
    L_0x001e:
        if (r1 == 0) goto L_0x0026;
    L_0x0020:
        r0 = "No network or service available. Will retry later";
        r11.zzea(r0);
        return r2;
    L_0x0026:
        r0 = com.google.android.gms.internal.zzasl.zzzz();
        r1 = com.google.android.gms.internal.zzasl.zzaaa();
        r0 = java.lang.Math.max(r0, r1);
        r0 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x003a:
        r6 = r11.zzeab;	 Catch:{ all -> 0x01ba }
        r6.beginTransaction();	 Catch:{ all -> 0x01ba }
        r3.clear();	 Catch:{ all -> 0x01ba }
        r6 = r11.zzeab;	 Catch:{ SQLiteException -> 0x019c }
        r6 = r6.zzo(r0);	 Catch:{ SQLiteException -> 0x019c }
        r7 = r6.isEmpty();	 Catch:{ SQLiteException -> 0x019c }
        if (r7 == 0) goto L_0x006b;
    L_0x004e:
        r0 = "Store is empty, nothing to dispatch";
        r11.zzea(r0);	 Catch:{ SQLiteException -> 0x019c }
        r11.zzzm();	 Catch:{ SQLiteException -> 0x019c }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0061 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0061 }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0061 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0061 }
        return r2;
    L_0x0061:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x006b:
        r7 = "Hits loaded from store. count";
        r8 = r6.size();	 Catch:{ SQLiteException -> 0x019c }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ SQLiteException -> 0x019c }
        r11.zza(r7, r8);	 Catch:{ SQLiteException -> 0x019c }
        r7 = r6.iterator();	 Catch:{ all -> 0x01ba }
    L_0x007c:
        r8 = r7.hasNext();	 Catch:{ all -> 0x01ba }
        if (r8 == 0) goto L_0x00b9;
    L_0x0082:
        r8 = r7.next();	 Catch:{ all -> 0x01ba }
        r8 = (com.google.android.gms.internal.zzasy) r8;	 Catch:{ all -> 0x01ba }
        r8 = r8.zzaam();	 Catch:{ all -> 0x01ba }
        r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r10 != 0) goto L_0x007c;
    L_0x0090:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01ba }
        r3 = r6.size();	 Catch:{ all -> 0x01ba }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01ba }
        r11.zzd(r0, r1, r3);	 Catch:{ all -> 0x01ba }
        r11.zzzm();	 Catch:{ all -> 0x01ba }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x00af }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00af }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x00af }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00af }
        return r2;
    L_0x00af:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x00b9:
        r7 = r11.zzeae;	 Catch:{ all -> 0x01ba }
        r7 = r7.isConnected();	 Catch:{ all -> 0x01ba }
        if (r7 == 0) goto L_0x011d;
    L_0x00c1:
        r7 = "Service connected, sending hits to the service";
        r11.zzea(r7);	 Catch:{ all -> 0x01ba }
    L_0x00c6:
        r7 = r6.isEmpty();	 Catch:{ all -> 0x01ba }
        if (r7 != 0) goto L_0x011d;
    L_0x00cc:
        r7 = r6.get(r2);	 Catch:{ all -> 0x01ba }
        r7 = (com.google.android.gms.internal.zzasy) r7;	 Catch:{ all -> 0x01ba }
        r8 = r11.zzeae;	 Catch:{ all -> 0x01ba }
        r8 = r8.zzb(r7);	 Catch:{ all -> 0x01ba }
        if (r8 == 0) goto L_0x011d;
    L_0x00da:
        r8 = r7.zzaam();	 Catch:{ all -> 0x01ba }
        r4 = java.lang.Math.max(r4, r8);	 Catch:{ all -> 0x01ba }
        r6.remove(r7);	 Catch:{ all -> 0x01ba }
        r8 = "Hit sent do device AnalyticsService for delivery";
        r11.zzb(r8, r7);	 Catch:{ all -> 0x01ba }
        r8 = r11.zzeab;	 Catch:{ SQLiteException -> 0x00ff }
        r9 = r7.zzaam();	 Catch:{ SQLiteException -> 0x00ff }
        r8.zzp(r9);	 Catch:{ SQLiteException -> 0x00ff }
        r7 = r7.zzaam();	 Catch:{ SQLiteException -> 0x00ff }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteException -> 0x00ff }
        r3.add(r7);	 Catch:{ SQLiteException -> 0x00ff }
        goto L_0x00c6;
    L_0x00ff:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r11.zze(r1, r0);	 Catch:{ all -> 0x01ba }
        r11.zzzm();	 Catch:{ all -> 0x01ba }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0113 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0113 }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0113 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0113 }
        return r2;
    L_0x0113:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x011d:
        r7 = r11.zzeac;	 Catch:{ all -> 0x01ba }
        r7 = r7.zzaax();	 Catch:{ all -> 0x01ba }
        if (r7 == 0) goto L_0x016b;
    L_0x0125:
        r7 = r11.zzeac;	 Catch:{ all -> 0x01ba }
        r6 = r7.zzu(r6);	 Catch:{ all -> 0x01ba }
        r7 = r6.iterator();	 Catch:{ all -> 0x01ba }
    L_0x012f:
        r8 = r7.hasNext();	 Catch:{ all -> 0x01ba }
        if (r8 == 0) goto L_0x0144;
    L_0x0135:
        r8 = r7.next();	 Catch:{ all -> 0x01ba }
        r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x01ba }
        r8 = r8.longValue();	 Catch:{ all -> 0x01ba }
        r4 = java.lang.Math.max(r4, r8);	 Catch:{ all -> 0x01ba }
        goto L_0x012f;
    L_0x0144:
        r7 = r11.zzeab;	 Catch:{ SQLiteException -> 0x014d }
        r7.zzs(r6);	 Catch:{ SQLiteException -> 0x014d }
        r3.addAll(r6);	 Catch:{ SQLiteException -> 0x014d }
        goto L_0x016b;
    L_0x014d:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r11.zze(r1, r0);	 Catch:{ all -> 0x01ba }
        r11.zzzm();	 Catch:{ all -> 0x01ba }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0161 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0161 }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0161 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0161 }
        return r2;
    L_0x0161:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x016b:
        r6 = r3.isEmpty();	 Catch:{ all -> 0x01ba }
        if (r6 == 0) goto L_0x0186;
    L_0x0171:
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x017c }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x017c }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x017c }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x017c }
        return r2;
    L_0x017c:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x0186:
        r6 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0192 }
        r6.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0192 }
        r6 = r11.zzeab;	 Catch:{ SQLiteException -> 0x0192 }
        r6.endTransaction();	 Catch:{ SQLiteException -> 0x0192 }
        goto L_0x003a;
    L_0x0192:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x019c:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r11.zzd(r1, r0);	 Catch:{ all -> 0x01ba }
        r11.zzzm();	 Catch:{ all -> 0x01ba }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x01b0 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01b0 }
        r0 = r11.zzeab;	 Catch:{ SQLiteException -> 0x01b0 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01b0 }
        return r2;
    L_0x01b0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
    L_0x01ba:
        r0 = move-exception;
        r1 = r11.zzeab;	 Catch:{ SQLiteException -> 0x01c6 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01c6 }
        r1 = r11.zzeab;	 Catch:{ SQLiteException -> 0x01c6 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01c6 }
        throw r0;
    L_0x01c6:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r11.zze(r1, r0);
        r11.zzzm();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzarw.zzzi():boolean");
    }

    private final void zzzl() {
        zzasq zzyd = zzyd();
        if (zzyd.zzaaj() && !zzyd.zzea()) {
            long zzza = zzza();
            if (zzza != 0 && Math.abs(zzxx().currentTimeMillis() - zzza) <= ((Long) zzast.zzeby.get()).longValue()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzasl.zzzy()));
                zzyd.schedule();
            }
        }
    }

    private final void zzzm() {
        if (this.zzeag.zzea()) {
            zzea("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzeag.cancel();
        zzasq zzyd = zzyd();
        if (zzyd.zzea()) {
            zzyd.cancel();
        }
    }

    private final long zzzn() {
        if (this.zzeaf != Long.MIN_VALUE) {
            return this.zzeaf;
        }
        long longValue = ((Long) zzast.zzebt.get()).longValue();
        zzari zzye = zzye();
        zzye.zzyk();
        if (zzye.zzeez) {
            zzari zzye2 = zzye();
            zzye2.zzyk();
            longValue = ((long) zzye2.zzedg) * 1000;
        }
        return longValue;
    }

    private final void zzzo() {
        zzyk();
        zzk.zzwj();
        this.zzeak = true;
        this.zzeae.disconnect();
        zzzk();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A:{LOOP_START, LOOP:1: B:15:0x0044->B:24:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0040 A:{SYNTHETIC} */
    protected final void onServiceConnected() {
        /*
        r5 = this;
        com.google.android.gms.analytics.zzk.zzwj();
        com.google.android.gms.analytics.zzk.zzwj();
        r5.zzyk();
        r0 = com.google.android.gms.internal.zzasl.zzzv();
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r5.zzed(r0);
    L_0x0014:
        r0 = r5.zzeae;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r0 = "Service not connected";
        r5.zzea(r0);
        return;
    L_0x0022:
        r0 = r5.zzeab;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x007d;
    L_0x002a:
        r0 = "Dispatching local hits to device AnalyticsService";
        r5.zzea(r0);
    L_0x002f:
        r0 = r5.zzeab;	 Catch:{ SQLiteException -> 0x0074 }
        r1 = com.google.android.gms.internal.zzasl.zzzz();	 Catch:{ SQLiteException -> 0x0074 }
        r1 = (long) r1;	 Catch:{ SQLiteException -> 0x0074 }
        r0 = r0.zzo(r1);	 Catch:{ SQLiteException -> 0x0074 }
        r1 = r0.isEmpty();	 Catch:{ SQLiteException -> 0x0074 }
        if (r1 == 0) goto L_0x0044;
    L_0x0040:
        r5.zzzk();	 Catch:{ SQLiteException -> 0x0074 }
        return;
    L_0x0044:
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x002f;
    L_0x004a:
        r1 = 0;
        r1 = r0.get(r1);
        r1 = (com.google.android.gms.internal.zzasy) r1;
        r2 = r5.zzeae;
        r2 = r2.zzb(r1);
        if (r2 != 0) goto L_0x005d;
    L_0x0059:
        r5.zzzk();
        return;
    L_0x005d:
        r0.remove(r1);
        r2 = r5.zzeab;	 Catch:{ SQLiteException -> 0x006a }
        r3 = r1.zzaam();	 Catch:{ SQLiteException -> 0x006a }
        r2.zzp(r3);	 Catch:{ SQLiteException -> 0x006a }
        goto L_0x0044;
    L_0x006a:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r5.zze(r1, r0);
        r5.zzzm();
        return;
    L_0x0074:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r5.zze(r1, r0);
        r5.zzzm();
    L_0x007d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzarw.onServiceConnected():void");
    }

    final void start() {
        zzyk();
        zzbq.zza(this.mStarted ^ true, (Object) "Analytics backend already started");
        this.mStarted = true;
        zzya().zzd(new zzarz(this));
    }

    public final long zza(zzarn zzarn, boolean z) {
        zzbq.checkNotNull(zzarn);
        zzyk();
        zzk.zzwj();
        try {
            this.zzeab.beginTransaction();
            zzarh zzarh = this.zzeab;
            long zzyr = zzarn.zzyr();
            zzbq.zzgv(zzarn.zzxe());
            zzarh.zzyk();
            zzk.zzwj();
            int delete = zzarh.getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzyr), r4});
            if (delete > 0) {
                zzarh.zza("Deleted property records", Integer.valueOf(delete));
            }
            zzyr = this.zzeab.zza(zzarn.zzyr(), zzarn.zzxe(), zzarn.zzys());
            zzarn.zzm(zzyr + 1);
            zzarh = this.zzeab;
            zzbq.checkNotNull(zzarn);
            zzarh.zzyk();
            zzk.zzwj();
            SQLiteDatabase writableDatabase = zzarh.getWritableDatabase();
            Map zzjq = zzarn.zzjq();
            zzbq.checkNotNull(zzjq);
            Builder builder = new Builder();
            for (Entry entry : zzjq.entrySet()) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                encodedQuery = "";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(zzarn.zzyr()));
            contentValues.put("cid", zzarn.zzxe());
            contentValues.put("tid", zzarn.zzys());
            contentValues.put("adid", Integer.valueOf(zzarn.zzyt()));
            contentValues.put("hits_count", Long.valueOf(zzarn.zzyu()));
            contentValues.put("params", encodedQuery);
            try {
                if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    zzarh.zzee("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e) {
                zzarh.zze("Error storing a property", e);
            }
            this.zzeab.setTransactionSuccessful();
            try {
                this.zzeab.endTransaction();
                return zzyr;
            } catch (SQLiteException e2) {
                zze("Failed to end transaction", e2);
                return zzyr;
            }
        } catch (SQLiteException e22) {
            zze("Failed to update Analytics property", e22);
            try {
                this.zzeab.endTransaction();
                return -1;
            } catch (SQLiteException e222) {
                zze("Failed to end transaction", e222);
                return -1;
            }
        } catch (Throwable th) {
            try {
                this.zzeab.endTransaction();
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
            throw th;
        }
    }

    public final void zza(zzasy zzasy) {
        zzbq.checkNotNull(zzasy);
        zzk.zzwj();
        zzyk();
        if (this.zzeak) {
            zzeb("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzasy);
        }
        if (TextUtils.isEmpty(zzasy.zzaar())) {
            Pair zzabh = zzyf().zzabf().zzabh();
            if (zzabh != null) {
                Long l = (Long) zzabh.second;
                String str = (String) zzabh.first;
                String valueOf = String.valueOf(l);
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length());
                stringBuilder.append(valueOf);
                stringBuilder.append(":");
                stringBuilder.append(str);
                str = stringBuilder.toString();
                Map hashMap = new HashMap(zzasy.zzjq());
                hashMap.put("_m", str);
                zzasy = new zzasy(this, hashMap, zzasy.zzaan(), zzasy.zzaap(), zzasy.zzaam(), zzasy.zzaal(), zzasy.zzaao());
            }
        }
        zzzh();
        if (this.zzeae.zzb(zzasy)) {
            zzeb("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzeab.zzc(zzasy);
            zzzk();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzh().zza(zzasy, "deliver: failed to insert hit to database");
        }
    }

    protected final void zzb(zzarn zzarn) {
        zzk.zzwj();
        zzb("Sending first hit to property", zzarn.zzys());
        if (!zzyf().zzabb().zzu(zzasl.zzaaf())) {
            String zzabe = zzyf().zzabe();
            if (!TextUtils.isEmpty(zzabe)) {
                zzaqm zza = zzatt.zza(zzh(), zzabe);
                zzb("Found relevant installation campaign", zza);
                zza(zzarn, zza);
            }
        }
    }

    public final void zzb(zzasr zzasr) {
        long j = this.zzeaj;
        zzk.zzwj();
        zzyk();
        long zzabc = zzyf().zzabc();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzabc != 0 ? Math.abs(zzxx().currentTimeMillis() - zzabc) : -1));
        zzzh();
        try {
            zzzi();
            zzyf().zzabd();
            zzzk();
            if (zzasr != null) {
                zzasr.zze(null);
            }
            if (this.zzeaj != j) {
                this.zzead.zzaaw();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzyf().zzabd();
            zzzk();
            if (zzasr != null) {
                zzasr.zze(th);
            }
        }
    }

    public final void zzei(String str) {
        zzbq.zzgv(str);
        zzk.zzwj();
        zzaqm zza = zzatt.zza(zzh(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence zzabe = zzyf().zzabe();
        if (str.equals(zzabe)) {
            zzed("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(zzabe)) {
            zzyf().zzel(str);
            if (zzyf().zzabb().zzu(zzasl.zzaaf())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzarn zza2 : this.zzeab.zzq(0)) {
                zza(zza2, zza);
            }
        } else {
            zzd("Ignoring multiple install campaigns. original, new", zzabe, str);
        }
    }

    public final void zzr(long j) {
        zzk.zzwj();
        zzyk();
        if (j < 0) {
            j = 0;
        }
        this.zzeaf = j;
        zzzk();
    }

    protected final void zzwk() {
        this.zzeab.initialize();
        this.zzeac.initialize();
        this.zzeae.initialize();
    }

    public final void zzxr() {
        zzk.zzwj();
        zzyk();
        zzea("Delete all hits from local store");
        try {
            zzari zzari = this.zzeab;
            zzk.zzwj();
            zzari.zzyk();
            zzari.getWritableDatabase().delete("hits2", null, null);
            zzari = this.zzeab;
            zzk.zzwj();
            zzari.zzyk();
            zzari.getWritableDatabase().delete("properties", null, null);
            zzzk();
        } catch (SQLiteException e) {
            zzd("Failed to delete hits from store", e);
        }
        zzzh();
        if (this.zzeae.zzyv()) {
            zzea("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    final void zzxv() {
        zzk.zzwj();
        this.zzeaj = zzxx().currentTimeMillis();
    }

    protected final void zzze() {
        zzyk();
        zzk.zzwj();
        Context context = zzxw().getContext();
        if (!zzatk.zzbj(context)) {
            zzed("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzatl.zzbn(context)) {
            zzee("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzbj(context)) {
            zzed("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzyf().zzaba();
        if (!zzeh("android.permission.ACCESS_NETWORK_STATE")) {
            zzee("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzzo();
        }
        if (!zzeh("android.permission.INTERNET")) {
            zzee("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzzo();
        }
        if (zzatl.zzbn(getContext())) {
            zzea("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzed("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.zzeak || this.zzeab.isEmpty())) {
            zzzh();
        }
        zzzk();
    }

    public final void zzzj() {
        zzk.zzwj();
        zzyk();
        zzeb("Sync dispatching local hits");
        long j = this.zzeaj;
        zzzh();
        try {
            zzzi();
            zzyf().zzabd();
            zzzk();
            if (this.zzeaj != j) {
                this.zzead.zzaaw();
            }
        } catch (Throwable th) {
            zze("Sync local dispatch failed", th);
            zzzk();
        }
    }

    /* JADX WARNING: Missing block: B:20:0x0074, code:
            if (r6 > 0) goto L_0x007f;
     */
    public final void zzzk() {
        /*
        r10 = this;
        com.google.android.gms.analytics.zzk.zzwj();
        r10.zzyk();
        r0 = r10.zzeak;
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x0017;
    L_0x000d:
        r4 = r10.zzzn();
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0017;
    L_0x0015:
        r0 = 1;
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        if (r0 != 0) goto L_0x0023;
    L_0x001a:
        r0 = r10.zzead;
        r0.unregister();
        r10.zzzm();
        return;
    L_0x0023:
        r0 = r10.zzeab;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0034;
    L_0x002b:
        r0 = r10.zzead;
        r0.unregister();
        r10.zzzm();
        return;
    L_0x0034:
        r0 = com.google.android.gms.internal.zzast.zzecu;
        r0 = r0.get();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x004d;
    L_0x0042:
        r0 = r10.zzead;
        r0.zzaau();
        r0 = r10.zzead;
        r1 = r0.isConnected();
    L_0x004d:
        if (r1 == 0) goto L_0x00aa;
    L_0x004f:
        r10.zzzl();
        r0 = r10.zzzn();
        r4 = r10.zzyf();
        r4 = r4.zzabc();
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r6 == 0) goto L_0x0077;
    L_0x0062:
        r6 = r10.zzxx();
        r6 = r6.currentTimeMillis();
        r8 = r6 - r4;
        r4 = java.lang.Math.abs(r8);
        r6 = r0 - r4;
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0077;
    L_0x0076:
        goto L_0x007f;
    L_0x0077:
        r2 = com.google.android.gms.internal.zzasl.zzzx();
        r6 = java.lang.Math.min(r2, r0);
    L_0x007f:
        r0 = "Dispatch scheduled (ms)";
        r1 = java.lang.Long.valueOf(r6);
        r10.zza(r0, r1);
        r0 = r10.zzeag;
        r0 = r0.zzea();
        if (r0 == 0) goto L_0x00a4;
    L_0x0090:
        r0 = 1;
        r2 = r10.zzeag;
        r2 = r2.zzaag();
        r4 = r6 + r2;
        r0 = java.lang.Math.max(r0, r4);
        r2 = r10.zzeag;
        r2.zzt(r0);
        return;
    L_0x00a4:
        r0 = r10.zzeag;
        r0.zzs(r6);
        return;
    L_0x00aa:
        r10.zzzm();
        r10.zzzl();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzarw.zzzk():void");
    }
}
