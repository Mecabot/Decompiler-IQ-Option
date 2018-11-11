package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class zzcje extends zzcli {
    private String zzcm;
    private String zzina;
    private String zziqn;
    private String zzjfl;
    private String zzjfs;
    private long zzjfw;
    private int zzjgl;
    private int zzjjy;
    private long zzjjz;

    zzcje(zzckj zzckj) {
        super(zzckj);
    }

    @WorkerThread
    private final String zzayu() {
        zzwj();
        try {
            return FirebaseInstanceId.wj().getId();
        } catch (IllegalStateException unused) {
            zzayp().zzbaw().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    final String getAppId() {
        zzyk();
        return this.zzcm;
    }

    final String getGmpAppId() {
        zzyk();
        return this.zzjfl;
    }

    protected final boolean zzazq() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0141 A:{Catch:{ IllegalStateException -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0147 A:{Catch:{ IllegalStateException -> 0x0159 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0171  */
    protected final void zzbap() {
        /*
        r10 = this;
        r0 = "unknown";
        r1 = "Unknown";
        r2 = "Unknown";
        r3 = r10.getContext();
        r3 = r3.getPackageName();
        r4 = r10.getContext();
        r4 = r4.getPackageManager();
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != 0) goto L_0x002d;
    L_0x001b:
        r4 = r10.zzayp();
        r4 = r4.zzbau();
        r7 = "PackageManager is null, app identity information might be inaccurate. appId";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r3);
        r4.zzj(r7, r8);
        goto L_0x008b;
    L_0x002d:
        r7 = r4.getInstallerPackageName(r3);	 Catch:{ IllegalArgumentException -> 0x0033 }
        r0 = r7;
        goto L_0x0044;
    L_0x0033:
        r7 = r10.zzayp();
        r7 = r7.zzbau();
        r8 = "Error retrieving app installer package name. appId";
        r9 = com.google.android.gms.internal.zzcjj.zzjs(r3);
        r7.zzj(r8, r9);
    L_0x0044:
        if (r0 != 0) goto L_0x0049;
    L_0x0046:
        r0 = "manual_install";
        goto L_0x0053;
    L_0x0049:
        r7 = "com.android.vending";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x0053;
    L_0x0051:
        r0 = "";
    L_0x0053:
        r7 = r10.getContext();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r4.getPackageInfo(r7, r5);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r7 == 0) goto L_0x008b;
    L_0x0061:
        r8 = r7.applicationInfo;	 Catch:{ NameNotFoundException -> 0x007a }
        r4 = r4.getApplicationLabel(r8);	 Catch:{ NameNotFoundException -> 0x007a }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r8 != 0) goto L_0x0072;
    L_0x006d:
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x007a }
        r2 = r4;
    L_0x0072:
        r4 = r7.versionName;	 Catch:{ NameNotFoundException -> 0x007a }
        r1 = r7.versionCode;	 Catch:{ NameNotFoundException -> 0x0079 }
        r6 = r1;
        r1 = r4;
        goto L_0x008b;
    L_0x0079:
        r1 = r4;
    L_0x007a:
        r4 = r10.zzayp();
        r4 = r4.zzbau();
        r7 = "Error retrieving package info. appId, appName";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r3);
        r4.zze(r7, r8, r2);
    L_0x008b:
        r10.zzcm = r3;
        r10.zzjfs = r0;
        r10.zzina = r1;
        r10.zzjjy = r6;
        r10.zziqn = r2;
        r0 = 0;
        r10.zzjjz = r0;
        r2 = r10.getContext();
        r2 = com.google.android.gms.common.api.internal.zzbz.zzcl(r2);
        r4 = 1;
        if (r2 == 0) goto L_0x00ac;
    L_0x00a4:
        r6 = r2.isSuccess();
        if (r6 == 0) goto L_0x00ac;
    L_0x00aa:
        r6 = 1;
        goto L_0x00ad;
    L_0x00ac:
        r6 = 0;
    L_0x00ad:
        if (r6 != 0) goto L_0x00d8;
    L_0x00af:
        if (r2 != 0) goto L_0x00bf;
    L_0x00b1:
        r2 = r10.zzayp();
        r2 = r2.zzbau();
        r7 = "GoogleService failed to initialize (no status)";
        r2.log(r7);
        goto L_0x00d8;
    L_0x00bf:
        r7 = r10.zzayp();
        r7 = r7.zzbau();
        r8 = "GoogleService failed to initialize, status";
        r9 = r2.getStatusCode();
        r9 = java.lang.Integer.valueOf(r9);
        r2 = r2.getStatusMessage();
        r7.zze(r8, r9, r2);
    L_0x00d8:
        if (r6 == 0) goto L_0x0130;
    L_0x00da:
        r2 = r10.zzayr();
        r6 = "firebase_analytics_collection_enabled";
        r2 = r2.zzjf(r6);
        r6 = r10.zzayr();
        r6 = r6.zzazr();
        if (r6 == 0) goto L_0x00fc;
    L_0x00ee:
        r2 = r10.zzayp();
        r2 = r2.zzbay();
        r4 = "Collection disabled with firebase_analytics_collection_deactivated=1";
    L_0x00f8:
        r2.log(r4);
        goto L_0x0130;
    L_0x00fc:
        if (r2 == 0) goto L_0x010f;
    L_0x00fe:
        r6 = r2.booleanValue();
        if (r6 != 0) goto L_0x010f;
    L_0x0104:
        r2 = r10.zzayp();
        r2 = r2.zzbay();
        r4 = "Collection disabled with firebase_analytics_collection_enabled=0";
        goto L_0x00f8;
    L_0x010f:
        if (r2 != 0) goto L_0x0122;
    L_0x0111:
        r2 = com.google.android.gms.common.api.internal.zzbz.zzakr();
        if (r2 == 0) goto L_0x0122;
    L_0x0117:
        r2 = r10.zzayp();
        r2 = r2.zzbay();
        r4 = "Collection disabled with google_app_measurement_enable=0";
        goto L_0x00f8;
    L_0x0122:
        r2 = r10.zzayp();
        r2 = r2.zzbba();
        r6 = "Collection enabled";
        r2.log(r6);
        goto L_0x0131;
    L_0x0130:
        r4 = 0;
    L_0x0131:
        r2 = "";
        r10.zzjfl = r2;
        r10.zzjfw = r0;
        r0 = com.google.android.gms.common.api.internal.zzbz.zzakq();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IllegalStateException -> 0x0159 }
        if (r1 == 0) goto L_0x0143;
    L_0x0141:
        r0 = "";
    L_0x0143:
        r10.zzjfl = r0;	 Catch:{ IllegalStateException -> 0x0159 }
        if (r4 == 0) goto L_0x016b;
    L_0x0147:
        r0 = r10.zzayp();	 Catch:{ IllegalStateException -> 0x0159 }
        r0 = r0.zzbba();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = "App package, google app id";
        r2 = r10.zzcm;	 Catch:{ IllegalStateException -> 0x0159 }
        r4 = r10.zzjfl;	 Catch:{ IllegalStateException -> 0x0159 }
        r0.zze(r1, r2, r4);	 Catch:{ IllegalStateException -> 0x0159 }
        goto L_0x016b;
    L_0x0159:
        r0 = move-exception;
        r1 = r10.zzayp();
        r1 = r1.zzbau();
        r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r3);
        r1.zze(r2, r3, r0);
    L_0x016b:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x017c;
    L_0x0171:
        r0 = r10.getContext();
        r0 = com.google.android.gms.internal.zzbif.zzdb(r0);
        r10.zzjgl = r0;
        return;
    L_0x017c:
        r10.zzjgl = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcje.zzbap():void");
    }

    @WorkerThread
    final String zzbaq() {
        zzayl().zzbcr().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final int zzbar() {
        zzyk();
        return this.zzjjy;
    }

    final int zzbas() {
        zzyk();
        return this.zzjgl;
    }

    @WorkerThread
    final zzcif zzjo(String str) {
        zzwj();
        String appId = getAppId();
        String gmpAppId = getGmpAppId();
        zzyk();
        String str2 = this.zzina;
        long zzbar = (long) zzbar();
        zzyk();
        String str3 = this.zzjfs;
        zzyk();
        zzwj();
        if (this.zzjjz == 0) {
            this.zzjjz = this.zzjev.zzayl().zzab(getContext(), getContext().getPackageName());
        }
        long j = this.zzjjz;
        boolean isEnabled = this.zzjev.isEnabled();
        boolean z = true;
        boolean z2 = zzayq().zzjmf ^ 1;
        String zzayu = zzayu();
        zzyk();
        long zzbbw = this.zzjev.zzbbw();
        int zzbas = zzbas();
        Boolean zzjf = zzayr().zzjf("google_analytics_adid_collection_enabled");
        if (!(zzjf == null || zzjf.booleanValue())) {
            z = false;
        }
        return new zzcif(appId, gmpAppId, str2, zzbar, str3, 12211, j, str, isEnabled, z2, zzayu, 0, zzbbw, zzbas, Boolean.valueOf(z).booleanValue());
    }
}
