package com.google.android.gms.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.jumio.analytics.MobileEvents;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class zzckj {
    private static volatile zzckj zzjnr;
    private boolean initialized = false;
    private final Context zzaiq;
    private final zze zzdir;
    private final long zzjgk;
    private final zzcik zzjns;
    private final zzcju zzjnt;
    private final zzcjj zzjnu;
    private final zzcke zzjnv;
    private final zzcnd zzjnw;
    private final zzckd zzjnx;
    private final AppMeasurement zzjny;
    private final FirebaseAnalytics zzjnz;
    private final zzcno zzjoa;
    private final zzcjh zzjob;
    private final zzcjn zzjoc;
    private final zzcma zzjod;
    private final zzclk zzjoe;
    private final zzcia zzjof;
    private zzcil zzjog;
    private zzcjf zzjoh;
    private zzcme zzjoi;
    private zzcir zzjoj;
    private zzcje zzjok;
    private zzcjs zzjol;
    private zzcnj zzjom;
    private zzcih zzjon;
    private boolean zzjoo;
    private Boolean zzjop;
    private long zzjoq;
    private FileLock zzjor;
    private FileChannel zzjos;
    private List<Long> zzjot;
    private List<Runnable> zzjou;
    private int zzjov;
    private int zzjow;
    private long zzjox;
    private long zzjoy;
    private boolean zzjoz;
    private boolean zzjpa;
    private boolean zzjpb;

    class zza implements zzcin {
        List<zzcob> zzaoz;
        zzcoe zzjpe;
        List<Long> zzjpf;
        private long zzjpg;

        private zza() {
        }

        /* synthetic */ zza(zzckj zzckj, zzckk zzckk) {
            this();
        }

        private static long zza(zzcob zzcob) {
            return ((zzcob.zzjuj.longValue() / 1000) / 60) / 60;
        }

        public final boolean zza(long j, zzcob zzcob) {
            zzbq.checkNotNull(zzcob);
            if (this.zzaoz == null) {
                this.zzaoz = new ArrayList();
            }
            if (this.zzjpf == null) {
                this.zzjpf = new ArrayList();
            }
            if (this.zzaoz.size() > 0 && zza((zzcob) this.zzaoz.get(0)) != zza(zzcob)) {
                return false;
            }
            long zzhs = this.zzjpg + ((long) zzcob.zzhs());
            if (zzhs >= ((long) Math.max(0, ((Integer) zzciz.zzjiv.get()).intValue()))) {
                return false;
            }
            this.zzjpg = zzhs;
            this.zzaoz.add(zzcob);
            this.zzjpf.add(Long.valueOf(j));
            return this.zzaoz.size() < Math.max(1, ((Integer) zzciz.zzjiw.get()).intValue());
        }

        public final void zzb(zzcoe zzcoe) {
            zzbq.checkNotNull(zzcoe);
            this.zzjpe = zzcoe;
        }
    }

    private zzckj(zzclj zzclj) {
        zzcjl zzbba;
        String str;
        zzbq.checkNotNull(zzclj);
        this.zzaiq = zzclj.zzaiq;
        this.zzjox = -1;
        this.zzdir = zzi.zzanq();
        this.zzjgk = this.zzdir.currentTimeMillis();
        this.zzjns = new zzcik(this);
        zzcli zzcju = new zzcju(this);
        zzcju.initialize();
        this.zzjnt = zzcju;
        zzcju = new zzcjj(this);
        zzcju.initialize();
        this.zzjnu = zzcju;
        zzcju = new zzcno(this);
        zzcju.initialize();
        this.zzjoa = zzcju;
        zzcju = new zzcjh(this);
        zzcju.initialize();
        this.zzjob = zzcju;
        this.zzjof = new zzcia(this);
        zzcju = new zzcjn(this);
        zzcju.initialize();
        this.zzjoc = zzcju;
        zzcju = new zzcma(this);
        zzcju.initialize();
        this.zzjod = zzcju;
        zzcju = new zzclk(this);
        zzcju.initialize();
        this.zzjoe = zzcju;
        this.zzjny = new AppMeasurement(this);
        this.zzjnz = new FirebaseAnalytics(this);
        zzcju = new zzcnd(this);
        zzcju.initialize();
        this.zzjnw = zzcju;
        zzcju = new zzckd(this);
        zzcju.initialize();
        this.zzjnx = zzcju;
        zzcju = new zzcke(this);
        zzcju.initialize();
        this.zzjnv = zzcju;
        if (this.zzaiq.getApplicationContext() instanceof Application) {
            zzclh zzayd = zzayd();
            if (zzayd.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzayd.getContext().getApplicationContext();
                if (zzayd.zzjpt == null) {
                    zzayd.zzjpt = new zzcly(zzayd, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzayd.zzjpt);
                application.registerActivityLifecycleCallbacks(zzayd.zzjpt);
                zzbba = zzayd.zzayp().zzbba();
                str = "Registered activity lifecycle callback";
            }
            this.zzjnv.zzh(new zzckk(this, zzclj));
        }
        zzbba = zzayp().zzbaw();
        str = "Application context is not an Application";
        zzbba.log(str);
        this.zzjnv.zzh(new zzckk(this, zzclj));
    }

    @WorkerThread
    private final int zza(FileChannel fileChannel) {
        zzayo().zzwj();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzayp().zzbau().log("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    zzayp().zzbaw().zzj("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzayp().zzbau().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    private final zzcif zza(Context context, String str, String str2, boolean z, boolean z2) {
        String str3 = str;
        String str4 = "Unknown";
        String str5 = "Unknown";
        String str6 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzayp().zzbau().log("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str3);
        } catch (IllegalArgumentException unused) {
            zzayp().zzbau().zzj("Error retrieving installer package name. appId", zzcjj.zzjs(str));
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str7 = str4;
        try {
            int i;
            PackageInfo packageInfo = zzbih.zzdd(context).getPackageInfo(str3, 0);
            if (packageInfo != null) {
                CharSequence zzhc = zzbih.zzdd(context).zzhc(str3);
                if (!TextUtils.isEmpty(zzhc)) {
                    str6 = zzhc.toString();
                }
                str5 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                i = Integer.MIN_VALUE;
            }
            return new zzcif(str3, str2, str5, (long) i, str7, 12211, zzayl().zzab(context, str3), null, z, false, "", 0, 0, 0, z2);
        } catch (NameNotFoundException unused2) {
            zzayp().zzbau().zze("Error retrieving newly installed package info. appId, appName", zzcjj.zzjs(str), str6);
            return null;
        }
    }

    private static void zza(zzclh zzclh) {
        if (zzclh == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzcli zzcli) {
        if (zzcli == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzcli.isInitialized()) {
            String valueOf = String.valueOf(zzcli.getClass());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append(valueOf);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    @WorkerThread
    private final void zza(zzclj zzclj) {
        zzcjl zzbay;
        zzayo().zzwj();
        zzcli zzcir = new zzcir(this);
        zzcir.initialize();
        this.zzjoj = zzcir;
        zzcir = new zzcje(this);
        zzcir.initialize();
        this.zzjok = zzcir;
        zzcli zzcil = new zzcil(this);
        zzcil.initialize();
        this.zzjog = zzcil;
        zzcil = new zzcjf(this);
        zzcil.initialize();
        this.zzjoh = zzcil;
        zzcil = new zzcih(this);
        zzcil.initialize();
        this.zzjon = zzcil;
        zzcil = new zzcme(this);
        zzcil.initialize();
        this.zzjoi = zzcil;
        zzcil = new zzcnj(this);
        zzcil.initialize();
        this.zzjom = zzcil;
        this.zzjol = new zzcjs(this);
        this.zzjoa.zzbcf();
        this.zzjnt.zzbcf();
        this.zzjok.zzbcf();
        zzayp().zzbay().zzj("App measurement is starting up, version", Long.valueOf(12211));
        zzayp().zzbay().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String appId = zzcir.getAppId();
        if (zzayl().zzkq(appId)) {
            zzbay = zzayp().zzbay();
            appId = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzbay = zzayp().zzbay();
            String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
            appId = String.valueOf(appId);
            appId = appId.length() != 0 ? str.concat(appId) : new String(str);
        }
        zzbay.log(appId);
        zzayp().zzbaz().log("Debug-level message logging enabled");
        if (this.zzjov != this.zzjow) {
            zzayp().zzbau().zze("Not all components initialized", Integer.valueOf(this.zzjov), Integer.valueOf(this.zzjow));
        }
        this.initialized = true;
    }

    @WorkerThread
    private final boolean zza(int i, FileChannel fileChannel) {
        zzayo().zzwj();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzayp().zzbau().log("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzayp().zzbau().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            zzayp().zzbau().zzj("Failed to write to channel", e);
            return false;
        }
    }

    private static boolean zza(zzcob zzcob, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        zzcoc[] zzcocArr = zzcob.zzjui;
        int length = zzcocArr.length;
        int i = 0;
        while (i < length) {
            zzcoc zzcoc = zzcocArr[i];
            if (str.equals(zzcoc.name)) {
                return ((obj instanceof Long) && obj.equals(zzcoc.zzjum)) || (((obj instanceof String) && obj.equals(zzcoc.zzgim)) || ((obj instanceof Double) && obj.equals(zzcoc.zzjsl)));
            } else {
                i++;
            }
        }
        return false;
    }

    private final boolean zza(String str, zzcix zzcix) {
        long round;
        Object string = zzcix.zzjhr.getString(b.CURRENCY);
        if (a.ECOMMERCE_PURCHASE.equals(zzcix.name)) {
            double doubleValue = zzcix.zzjhr.getDouble(b.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzcix.zzjhr.getLong(b.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzayp().zzbaw().zze("Data lost. Currency value is too big. appId", zzcjj.zzjs(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = zzcix.zzjhr.getLong(b.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String toUpperCase = string.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                zzcnn zzag = zzayj().zzag(str, concat);
                if (zzag == null || !(zzag.value instanceof Long)) {
                    zzclh zzayj = zzayj();
                    int zzb = this.zzjns.zzb(str, zzciz.zzjjr) - 1;
                    zzbq.zzgv(str);
                    zzayj.zzwj();
                    zzayj.zzyk();
                    try {
                        zzayj.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzayj.zzayp().zzbau().zze("Error pruning currencies. appId", zzcjj.zzjs(str), e);
                    }
                    zzcnn zzcnn = new zzcnn(str, zzcix.zzjgm, concat, this.zzdir.currentTimeMillis(), Long.valueOf(round));
                } else {
                    zzag = new zzcnn(str, zzcix.zzjgm, concat, this.zzdir.currentTimeMillis(), Long.valueOf(((Long) zzag.value).longValue() + round));
                }
                if (!zzayj().zza(zzag)) {
                    zzayp().zzbau().zzd("Too many unique user properties are set. Ignoring user property. appId", zzcjj.zzjs(str), zzayk().zzjr(zzag.name), zzag.value);
                    zzayl().zza(str, 9, null, null, 0);
                }
            }
        }
        return true;
    }

    private final zzcoa[] zza(String str, zzcog[] zzcogArr, zzcob[] zzcobArr) {
        zzbq.zzgv(str);
        return zzayc().zza(str, zzcobArr, zzcogArr);
    }

    static void zzaxz() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    @WorkerThread
    private final void zzb(zzcie zzcie) {
        zzayo().zzwj();
        if (TextUtils.isEmpty(zzcie.getGmpAppId())) {
            zzb(zzcie.getAppId(), 204, null, null, null);
            return;
        }
        String gmpAppId = zzcie.getGmpAppId();
        String appInstanceId = zzcie.getAppInstanceId();
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) zzciz.zzjir.get()).encodedAuthority((String) zzciz.zzjis.get());
        String str = "config/app/";
        gmpAppId = String.valueOf(gmpAppId);
        encodedAuthority.path(gmpAppId.length() != 0 ? str.concat(gmpAppId) : new String(str)).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12211");
        gmpAppId = builder.build().toString();
        try {
            Map map;
            URL url = new URL(gmpAppId);
            zzayp().zzbba().zzj("Fetching remote configuration", zzcie.getAppId());
            zzcny zzka = zzaym().zzka(zzcie.getAppId());
            CharSequence zzkb = zzaym().zzkb(zzcie.getAppId());
            if (zzka == null || TextUtils.isEmpty(zzkb)) {
                map = null;
            } else {
                Map arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", zzkb);
                map = arrayMap;
            }
            this.zzjoz = true;
            zzclh zzbbs = zzbbs();
            String appId = zzcie.getAppId();
            zzcjp zzckn = new zzckn(this);
            zzbbs.zzwj();
            zzbbs.zzyk();
            zzbq.checkNotNull(url);
            zzbq.checkNotNull(zzckn);
            zzbbs.zzayo().zzi(new zzcjr(zzbbs, appId, url, null, map, zzckn));
        } catch (MalformedURLException unused) {
            zzayp().zzbau().zze("Failed to parse config URL. Not fetching. appId", zzcjj.zzjs(zzcie.getAppId()), gmpAppId);
        }
    }

    private final zzcjs zzbbt() {
        if (this.zzjol != null) {
            return this.zzjol;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzcnj zzbbu() {
        zza(this.zzjom);
        return this.zzjom;
    }

    @WorkerThread
    private final boolean zzbbv() {
        Object e;
        zzcjl zzbau;
        String str;
        zzayo().zzwj();
        try {
            this.zzjos = new RandomAccessFile(new File(this.zzaiq.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzjor = this.zzjos.tryLock();
            if (this.zzjor != null) {
                zzayp().zzbba().log("Storage concurrent access okay");
                return true;
            }
            zzayp().zzbau().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            e = e2;
            zzbau = zzayp().zzbau();
            str = "Failed to acquire storage lock";
            zzbau.zzj(str, e);
            return false;
        } catch (IOException e3) {
            e = e3;
            zzbau = zzayp().zzbau();
            str = "Failed to access storage lock file";
            zzbau.zzj(str, e);
            return false;
        }
    }

    private final long zzbbx() {
        long currentTimeMillis = this.zzdir.currentTimeMillis();
        zzclh zzayq = zzayq();
        zzayq.zzyk();
        zzayq.zzwj();
        long j = zzayq.zzjlr.get();
        if (j == 0) {
            j = (long) (zzayq.zzayl().zzbcr().nextInt(86400000) + 1);
            zzayq.zzjlr.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzbbz() {
        zzayo().zzwj();
        zzyk();
        return zzayj().zzbab() || !TextUtils.isEmpty(zzayj().zzazw());
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0172  */
    @android.support.annotation.WorkerThread
    private final void zzbca() {
        /*
        r19 = this;
        r0 = r19;
        r1 = r19.zzayo();
        r1.zzwj();
        r19.zzyk();
        r1 = r19.zzbcd();
        if (r1 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r1 = r0.zzjoy;
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0054;
    L_0x001b:
        r1 = r0.zzdir;
        r1 = r1.elapsedRealtime();
        r5 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r7 = r0.zzjoy;
        r9 = r1 - r7;
        r1 = java.lang.Math.abs(r9);
        r7 = r5 - r1;
        r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0052;
    L_0x0032:
        r1 = r19.zzayp();
        r1 = r1.zzbba();
        r2 = "Upload has been suspended. Will update scheduling later in approximately ms";
        r3 = java.lang.Long.valueOf(r7);
        r1.zzj(r2, r3);
        r1 = r19.zzbbt();
        r1.unregister();
        r1 = r19.zzbbu();
        r1.cancel();
        return;
    L_0x0052:
        r0.zzjoy = r3;
    L_0x0054:
        r1 = r19.zzbbn();
        if (r1 == 0) goto L_0x0229;
    L_0x005a:
        r1 = r19.zzbbz();
        if (r1 != 0) goto L_0x0062;
    L_0x0060:
        goto L_0x0229;
    L_0x0062:
        r1 = r0.zzdir;
        r1 = r1.currentTimeMillis();
        r5 = com.google.android.gms.internal.zzciz.zzjjn;
        r5 = r5.get();
        r5 = (java.lang.Long) r5;
        r5 = r5.longValue();
        r5 = java.lang.Math.max(r3, r5);
        r7 = r19.zzayj();
        r7 = r7.zzbac();
        if (r7 != 0) goto L_0x008f;
    L_0x0082:
        r7 = r19.zzayj();
        r7 = r7.zzazx();
        if (r7 == 0) goto L_0x008d;
    L_0x008c:
        goto L_0x008f;
    L_0x008d:
        r7 = 0;
        goto L_0x0090;
    L_0x008f:
        r7 = 1;
    L_0x0090:
        if (r7 == 0) goto L_0x00ac;
    L_0x0092:
        r10 = r0.zzjns;
        r10 = r10.zzazu();
        r11 = android.text.TextUtils.isEmpty(r10);
        if (r11 != 0) goto L_0x00a9;
    L_0x009e:
        r11 = ".none.";
        r10 = r11.equals(r10);
        if (r10 != 0) goto L_0x00a9;
    L_0x00a6:
        r10 = com.google.android.gms.internal.zzciz.zzjji;
        goto L_0x00ae;
    L_0x00a9:
        r10 = com.google.android.gms.internal.zzciz.zzjjh;
        goto L_0x00ae;
    L_0x00ac:
        r10 = com.google.android.gms.internal.zzciz.zzjjg;
    L_0x00ae:
        r10 = r10.get();
        r10 = (java.lang.Long) r10;
        r10 = r10.longValue();
        r10 = java.lang.Math.max(r3, r10);
        r12 = r19.zzayq();
        r12 = r12.zzjln;
        r12 = r12.get();
        r14 = r19.zzayq();
        r14 = r14.zzjlo;
        r14 = r14.get();
        r8 = r19.zzayj();
        r16 = r10;
        r9 = r8.zzazz();
        r8 = r19.zzayj();
        r18 = r7;
        r7 = r8.zzbaa();
        r7 = java.lang.Math.max(r9, r7);
        r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r9 != 0) goto L_0x00ef;
    L_0x00ec:
        r5 = r3;
        goto L_0x016e;
    L_0x00ef:
        r9 = 0;
        r9 = r7 - r1;
        r7 = java.lang.Math.abs(r9);
        r9 = r1 - r7;
        r7 = r12 - r1;
        r7 = java.lang.Math.abs(r7);
        r11 = r1 - r7;
        r7 = r14 - r1;
        r7 = java.lang.Math.abs(r7);
        r13 = r1 - r7;
        r1 = java.lang.Math.max(r11, r13);
        r7 = r9 + r5;
        if (r18 == 0) goto L_0x011a;
    L_0x0110:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x011a;
    L_0x0114:
        r5 = java.lang.Math.min(r9, r1);
        r7 = r5 + r16;
    L_0x011a:
        r5 = r19.zzayl();
        r11 = r16;
        r5 = r5.zzf(r1, r11);
        if (r5 != 0) goto L_0x0129;
    L_0x0126:
        r5 = r1 + r11;
        goto L_0x012a;
    L_0x0129:
        r5 = r7;
    L_0x012a:
        r1 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1));
        if (r1 == 0) goto L_0x016e;
    L_0x012e:
        r1 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1));
        if (r1 < 0) goto L_0x016e;
    L_0x0132:
        r1 = 0;
    L_0x0133:
        r2 = 20;
        r7 = com.google.android.gms.internal.zzciz.zzjjp;
        r7 = r7.get();
        r7 = (java.lang.Integer) r7;
        r7 = r7.intValue();
        r8 = 0;
        r7 = java.lang.Math.max(r8, r7);
        r2 = java.lang.Math.min(r2, r7);
        if (r1 >= r2) goto L_0x00ec;
    L_0x014c:
        r2 = 1;
        r7 = r2 << r1;
        r9 = (long) r7;
        r7 = com.google.android.gms.internal.zzciz.zzjjo;
        r7 = r7.get();
        r7 = (java.lang.Long) r7;
        r11 = r7.longValue();
        r11 = java.lang.Math.max(r3, r11);
        r11 = r11 * r9;
        r9 = r5 + r11;
        r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1));
        if (r5 <= 0) goto L_0x016a;
    L_0x0168:
        r5 = r9;
        goto L_0x016e;
    L_0x016a:
        r1 = r1 + 1;
        r5 = r9;
        goto L_0x0133;
    L_0x016e:
        r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r1 != 0) goto L_0x018e;
    L_0x0172:
        r1 = r19.zzayp();
        r1 = r1.zzbba();
        r2 = "Next upload time is 0";
        r1.log(r2);
        r1 = r19.zzbbt();
        r1.unregister();
        r1 = r19.zzbbu();
        r1.cancel();
        return;
    L_0x018e:
        r1 = r19.zzbbs();
        r1 = r1.zzaax();
        if (r1 != 0) goto L_0x01b4;
    L_0x0198:
        r1 = r19.zzayp();
        r1 = r1.zzbba();
        r2 = "No network";
        r1.log(r2);
        r1 = r19.zzbbt();
        r1.zzaau();
        r1 = r19.zzbbu();
        r1.cancel();
        return;
    L_0x01b4:
        r1 = r19.zzayq();
        r1 = r1.zzjlp;
        r1 = r1.get();
        r7 = com.google.android.gms.internal.zzciz.zzjje;
        r7 = r7.get();
        r7 = (java.lang.Long) r7;
        r7 = r7.longValue();
        r7 = java.lang.Math.max(r3, r7);
        r9 = r19.zzayl();
        r9 = r9.zzf(r1, r7);
        if (r9 != 0) goto L_0x01de;
    L_0x01d8:
        r9 = r1 + r7;
        r5 = java.lang.Math.max(r5, r9);
    L_0x01de:
        r1 = r19.zzbbt();
        r1.unregister();
        r1 = r0.zzdir;
        r1 = r1.currentTimeMillis();
        r7 = r5 - r1;
        r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r1 > 0) goto L_0x0210;
    L_0x01f1:
        r1 = com.google.android.gms.internal.zzciz.zzjjj;
        r1 = r1.get();
        r1 = (java.lang.Long) r1;
        r1 = r1.longValue();
        r7 = java.lang.Math.max(r3, r1);
        r1 = r19.zzayq();
        r1 = r1.zzjln;
        r2 = r0.zzdir;
        r2 = r2.currentTimeMillis();
        r1.set(r2);
    L_0x0210:
        r1 = r19.zzayp();
        r1 = r1.zzbba();
        r2 = "Upload scheduled in approximately ms";
        r3 = java.lang.Long.valueOf(r7);
        r1.zzj(r2, r3);
        r1 = r19.zzbbu();
        r1.zzs(r7);
        return;
    L_0x0229:
        r1 = r19.zzayp();
        r1 = r1.zzbba();
        r2 = "Nothing to upload or uploading impossible";
        r1.log(r2);
        r1 = r19.zzbbt();
        r1.unregister();
        r1 = r19.zzbbu();
        r1.cancel();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzbca():void");
    }

    @WorkerThread
    private final boolean zzbcd() {
        zzayo().zzwj();
        zzyk();
        return this.zzjoo;
    }

    @WorkerThread
    private final void zzbce() {
        zzayo().zzwj();
        if (this.zzjoz || this.zzjpa || this.zzjpb) {
            zzayp().zzbba().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzjoz), Boolean.valueOf(this.zzjpa), Boolean.valueOf(this.zzjpb));
            return;
        }
        zzayp().zzbba().log("Stopping uploading service(s)");
        if (this.zzjou != null) {
            for (Runnable run : this.zzjou) {
                run.run();
            }
            this.zzjou.clear();
        }
    }

    @WorkerThread
    private final Boolean zzc(zzcie zzcie) {
        try {
            if (zzcie.zzayx() != -2147483648L) {
                if (zzcie.zzayx() == ((long) zzbih.zzdd(this.zzaiq).getPackageInfo(zzcie.getAppId(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            }
            String str = zzbih.zzdd(this.zzaiq).getPackageInfo(zzcie.getAppId(), 0).versionName;
            if (zzcie.zzwo() != null && zzcie.zzwo().equals(str)) {
                return Boolean.valueOf(true);
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:137:0x057b, code:
            if (r6.zzjhi < ((long) r11.zzjns.zzje(r13.zzcm))) goto L_0x057f;
     */
    @android.support.annotation.WorkerThread
    private final void zzc(com.google.android.gms.internal.zzcix r34, com.google.android.gms.internal.zzcif r35) {
        /*
        r33 = this;
        r11 = r33;
        r1 = r34;
        r12 = r35;
        com.google.android.gms.common.internal.zzbq.checkNotNull(r35);
        r2 = r12.packageName;
        com.google.android.gms.common.internal.zzbq.zzgv(r2);
        r13 = java.lang.System.nanoTime();
        r2 = r33.zzayo();
        r2.zzwj();
        r33.zzyk();
        r10 = r12.packageName;
        r33.zzayl();
        r2 = com.google.android.gms.internal.zzcno.zzd(r34, r35);
        if (r2 != 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r2 = r12.zzjfv;
        if (r2 != 0) goto L_0x0030;
    L_0x002c:
        r11.zzg(r12);
        return;
    L_0x0030:
        r2 = r33.zzaym();
        r3 = r1.name;
        r2 = r2.zzan(r10, r3);
        if (r2 == 0) goto L_0x00cf;
    L_0x003c:
        r2 = r33.zzayp();
        r2 = r2.zzbaw();
        r3 = "Dropping blacklisted event. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r10);
        r5 = r33.zzayk();
        r6 = r1.name;
        r5 = r5.zzjp(r6);
        r2.zze(r3, r4, r5);
        r2 = r33.zzayl();
        r2 = r2.zzks(r10);
        if (r2 != 0) goto L_0x006e;
    L_0x0061:
        r2 = r33.zzayl();
        r2 = r2.zzkt(r10);
        if (r2 == 0) goto L_0x006c;
    L_0x006b:
        goto L_0x006e;
    L_0x006c:
        r9 = 0;
        goto L_0x006f;
    L_0x006e:
        r9 = 1;
    L_0x006f:
        if (r9 != 0) goto L_0x008a;
    L_0x0071:
        r2 = "_err";
        r3 = r1.name;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x008a;
    L_0x007b:
        r3 = r33.zzayl();
        r5 = 11;
        r6 = "_ev";
        r7 = r1.name;
        r8 = 0;
        r4 = r10;
        r3.zza(r4, r5, r6, r7, r8);
    L_0x008a:
        if (r9 == 0) goto L_0x00ce;
    L_0x008c:
        r1 = r33.zzayj();
        r1 = r1.zzjj(r10);
        if (r1 == 0) goto L_0x00ce;
    L_0x0096:
        r2 = r1.zzaze();
        r4 = r1.zzazd();
        r2 = java.lang.Math.max(r2, r4);
        r4 = r11.zzdir;
        r4 = r4.currentTimeMillis();
        r6 = r4 - r2;
        r2 = java.lang.Math.abs(r6);
        r4 = com.google.android.gms.internal.zzciz.zzjjm;
        r4 = r4.get();
        r4 = (java.lang.Long) r4;
        r4 = r4.longValue();
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x00ce;
    L_0x00be:
        r2 = r33.zzayp();
        r2 = r2.zzbaz();
        r3 = "Fetching config for blacklisted app";
        r2.log(r3);
        r11.zzb(r1);
    L_0x00ce:
        return;
    L_0x00cf:
        r2 = r33.zzayp();
        r6 = 2;
        r2 = r2.zzae(r6);
        if (r2 == 0) goto L_0x00ef;
    L_0x00da:
        r2 = r33.zzayp();
        r2 = r2.zzbba();
        r3 = "Logging event";
        r4 = r33.zzayk();
        r4 = r4.zzb(r1);
        r2.zzj(r3, r4);
    L_0x00ef:
        r2 = r33.zzayj();
        r2.beginTransaction();
        r11.zzg(r12);	 Catch:{ all -> 0x05f1 }
        r2 = "_iap";
        r3 = r1.name;	 Catch:{ all -> 0x05f1 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x05f1 }
        if (r2 != 0) goto L_0x010d;
    L_0x0103:
        r2 = "ecommerce_purchase";
        r3 = r1.name;	 Catch:{ all -> 0x05f1 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x05f1 }
        if (r2 == 0) goto L_0x0122;
    L_0x010d:
        r2 = r11.zza(r10, r1);	 Catch:{ all -> 0x05f1 }
        if (r2 != 0) goto L_0x0122;
    L_0x0113:
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();
        r1.endTransaction();
        return;
    L_0x0122:
        r2 = r1.name;	 Catch:{ all -> 0x05f1 }
        r24 = com.google.android.gms.internal.zzcno.zzkh(r2);	 Catch:{ all -> 0x05f1 }
        r2 = "_err";
        r3 = r1.name;	 Catch:{ all -> 0x05f1 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x05f1 }
        r15 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r16 = r33.zzbbx();	 Catch:{ all -> 0x05f1 }
        r19 = 1;
        r21 = 0;
        r23 = 0;
        r18 = r10;
        r20 = r24;
        r22 = r2;
        r3 = r15.zza(r16, r18, r19, r20, r21, r22, r23);	 Catch:{ all -> 0x05f1 }
        r4 = r3.zzjhf;	 Catch:{ all -> 0x05f1 }
        r7 = com.google.android.gms.internal.zzciz.zzjix;	 Catch:{ all -> 0x05f1 }
        r7 = r7.get();	 Catch:{ all -> 0x05f1 }
        r7 = (java.lang.Integer) r7;	 Catch:{ all -> 0x05f1 }
        r7 = r7.intValue();	 Catch:{ all -> 0x05f1 }
        r6 = (long) r7;	 Catch:{ all -> 0x05f1 }
        r15 = r4 - r6;
        r6 = 0;
        r4 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1));
        r17 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8 = 1;
        if (r4 <= 0) goto L_0x018f;
    L_0x0163:
        r15 = r15 % r17;
        r1 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x0180;
    L_0x0169:
        r1 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzbau();	 Catch:{ all -> 0x05f1 }
        r2 = "Data loss. Too many events logged. appId, count";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r10);	 Catch:{ all -> 0x05f1 }
        r5 = r3.zzjhf;	 Catch:{ all -> 0x05f1 }
        r3 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x05f1 }
        r1.zze(r2, r4, r3);	 Catch:{ all -> 0x05f1 }
    L_0x0180:
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();
        r1.endTransaction();
        return;
    L_0x018f:
        if (r24 == 0) goto L_0x01e3;
    L_0x0191:
        r4 = r3.zzjhe;	 Catch:{ all -> 0x05f1 }
        r15 = com.google.android.gms.internal.zzciz.zzjiz;	 Catch:{ all -> 0x05f1 }
        r15 = r15.get();	 Catch:{ all -> 0x05f1 }
        r15 = (java.lang.Integer) r15;	 Catch:{ all -> 0x05f1 }
        r15 = r15.intValue();	 Catch:{ all -> 0x05f1 }
        r8 = (long) r15;	 Catch:{ all -> 0x05f1 }
        r15 = r4 - r8;
        r4 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x01e3;
    L_0x01a6:
        r15 = r15 % r17;
        r4 = 1;
        r2 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x01c5;
    L_0x01ae:
        r2 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r2 = r2.zzbau();	 Catch:{ all -> 0x05f1 }
        r4 = "Data loss. Too many public events logged. appId, count";
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r10);	 Catch:{ all -> 0x05f1 }
        r6 = r3.zzjhe;	 Catch:{ all -> 0x05f1 }
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x05f1 }
        r2.zze(r4, r5, r3);	 Catch:{ all -> 0x05f1 }
    L_0x01c5:
        r3 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r5 = 16;
        r6 = "_ev";
        r7 = r1.name;	 Catch:{ all -> 0x05f1 }
        r8 = 0;
        r4 = r10;
        r3.zza(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();
        r1.endTransaction();
        return;
    L_0x01e3:
        if (r2 == 0) goto L_0x0230;
    L_0x01e5:
        r4 = r3.zzjhh;	 Catch:{ all -> 0x05f1 }
        r2 = r11.zzjns;	 Catch:{ all -> 0x05f1 }
        r8 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r9 = com.google.android.gms.internal.zzciz.zzjiy;	 Catch:{ all -> 0x05f1 }
        r2 = r2.zzb(r8, r9);	 Catch:{ all -> 0x05f1 }
        r8 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = java.lang.Math.min(r8, r2);	 Catch:{ all -> 0x05f1 }
        r8 = 0;
        r2 = java.lang.Math.max(r8, r2);	 Catch:{ all -> 0x05f1 }
        r8 = (long) r2;	 Catch:{ all -> 0x05f1 }
        r15 = r4 - r8;
        r2 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0230;
    L_0x0204:
        r4 = 1;
        r1 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0221;
    L_0x020a:
        r1 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzbau();	 Catch:{ all -> 0x05f1 }
        r2 = "Too many error events logged. appId, count";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r10);	 Catch:{ all -> 0x05f1 }
        r5 = r3.zzjhh;	 Catch:{ all -> 0x05f1 }
        r3 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x05f1 }
        r1.zze(r2, r4, r3);	 Catch:{ all -> 0x05f1 }
    L_0x0221:
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();
        r1.endTransaction();
        return;
    L_0x0230:
        r2 = r1.zzjhr;	 Catch:{ all -> 0x05f1 }
        r15 = r2.zzbao();	 Catch:{ all -> 0x05f1 }
        r2 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r3 = "_o";
        r4 = r1.zzjgm;	 Catch:{ all -> 0x05f1 }
        r2.zza(r15, r3, r4);	 Catch:{ all -> 0x05f1 }
        r2 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r2 = r2.zzkq(r10);	 Catch:{ all -> 0x05f1 }
        if (r2 == 0) goto L_0x0267;
    L_0x024b:
        r2 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r3 = "_dbg";
        r4 = 1;
        r8 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x05f1 }
        r2.zza(r15, r3, r8);	 Catch:{ all -> 0x05f1 }
        r2 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r3 = "_r";
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x05f1 }
        r2.zza(r15, r3, r4);	 Catch:{ all -> 0x05f1 }
    L_0x0267:
        r2 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r2 = r2.zzjk(r10);	 Catch:{ all -> 0x05f1 }
        r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0288;
    L_0x0273:
        r4 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzbaw();	 Catch:{ all -> 0x05f1 }
        r5 = "Data lost. Too many events stored on disk, deleted. appId";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r10);	 Catch:{ all -> 0x05f1 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x05f1 }
        r4.zze(r5, r8, r2);	 Catch:{ all -> 0x05f1 }
    L_0x0288:
        r8 = new com.google.android.gms.internal.zzcis;	 Catch:{ all -> 0x05f1 }
        r3 = r1.zzjgm;	 Catch:{ all -> 0x05f1 }
        r5 = r1.name;	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzjib;	 Catch:{ all -> 0x05f1 }
        r16 = 0;
        r18 = r1;
        r1 = r8;
        r2 = r11;
        r4 = r10;
        r30 = r13;
        r9 = 2;
        r13 = r6;
        r6 = r18;
        r13 = r8;
        r14 = 1;
        r29 = 0;
        r8 = r16;
        r14 = r10;
        r10 = r15;
        r1.<init>(r2, r3, r4, r5, r6, r8, r10);	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r2 = r13.name;	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzae(r14, r2);	 Catch:{ all -> 0x05f1 }
        if (r1 != 0) goto L_0x0317;
    L_0x02b4:
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzjn(r14);	 Catch:{ all -> 0x05f1 }
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x02fa;
    L_0x02c2:
        if (r24 == 0) goto L_0x02fa;
    L_0x02c4:
        r1 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzbau();	 Catch:{ all -> 0x05f1 }
        r2 = "Too many event names used, ignoring event. appId, name, supported count";
        r3 = com.google.android.gms.internal.zzcjj.zzjs(r14);	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayk();	 Catch:{ all -> 0x05f1 }
        r5 = r13.name;	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzjp(r5);	 Catch:{ all -> 0x05f1 }
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x05f1 }
        r1.zzd(r2, r3, r4, r5);	 Catch:{ all -> 0x05f1 }
        r3 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r5 = 8;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r4 = r14;
        r3.zza(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayj();
        r1.endTransaction();
        return;
    L_0x02fa:
        r1 = new com.google.android.gms.internal.zzcit;	 Catch:{ all -> 0x05f1 }
        r2 = r13.name;	 Catch:{ all -> 0x05f1 }
        r18 = 0;
        r20 = 0;
        r3 = r13.timestamp;	 Catch:{ all -> 0x05f1 }
        r24 = 0;
        r26 = 0;
        r27 = 0;
        r28 = 0;
        r15 = r1;
        r16 = r14;
        r17 = r2;
        r22 = r3;
        r15.<init>(r16, r17, r18, r20, r22, r24, r26, r27, r28);	 Catch:{ all -> 0x05f1 }
        goto L_0x0324;
    L_0x0317:
        r2 = r1.zzjhu;	 Catch:{ all -> 0x05f1 }
        r8 = r13.zza(r11, r2);	 Catch:{ all -> 0x05f1 }
        r2 = r8.timestamp;	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzbb(r2);	 Catch:{ all -> 0x05f1 }
        r13 = r8;
    L_0x0324:
        r2 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r2.zza(r1);	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayo();	 Catch:{ all -> 0x05f1 }
        r1.zzwj();	 Catch:{ all -> 0x05f1 }
        r33.zzyk();	 Catch:{ all -> 0x05f1 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r13);	 Catch:{ all -> 0x05f1 }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r35);	 Catch:{ all -> 0x05f1 }
        r1 = r13.zzcm;	 Catch:{ all -> 0x05f1 }
        com.google.android.gms.common.internal.zzbq.zzgv(r1);	 Catch:{ all -> 0x05f1 }
        r1 = r13.zzcm;	 Catch:{ all -> 0x05f1 }
        r2 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x05f1 }
        com.google.android.gms.common.internal.zzbq.checkArgument(r1);	 Catch:{ all -> 0x05f1 }
        r1 = new com.google.android.gms.internal.zzcoe;	 Catch:{ all -> 0x05f1 }
        r1.<init>();	 Catch:{ all -> 0x05f1 }
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x05f1 }
        r1.zzjup = r3;	 Catch:{ all -> 0x05f1 }
        r3 = "android";
        r1.zzjux = r3;	 Catch:{ all -> 0x05f1 }
        r3 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r1.zzcm = r3;	 Catch:{ all -> 0x05f1 }
        r3 = r12.zzjfs;	 Catch:{ all -> 0x05f1 }
        r1.zzjfs = r3;	 Catch:{ all -> 0x05f1 }
        r3 = r12.zzina;	 Catch:{ all -> 0x05f1 }
        r1.zzina = r3;	 Catch:{ all -> 0x05f1 }
        r3 = r12.zzjfr;	 Catch:{ all -> 0x05f1 }
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        r3 = 0;
        if (r7 != 0) goto L_0x0373;
    L_0x0371:
        r4 = r3;
        goto L_0x037a;
    L_0x0373:
        r4 = r12.zzjfr;	 Catch:{ all -> 0x05f1 }
        r4 = (int) r4;	 Catch:{ all -> 0x05f1 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x05f1 }
    L_0x037a:
        r1.zzjvi = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjft;	 Catch:{ all -> 0x05f1 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x05f1 }
        r1.zzjva = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfl;	 Catch:{ all -> 0x05f1 }
        r1.zzjfl = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfu;	 Catch:{ all -> 0x05f1 }
        r6 = 0;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x0392;
    L_0x0390:
        r4 = r3;
        goto L_0x0398;
    L_0x0392:
        r4 = r12.zzjfu;	 Catch:{ all -> 0x05f1 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x05f1 }
    L_0x0398:
        r1.zzjve = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayq();	 Catch:{ all -> 0x05f1 }
        r5 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzju(r5);	 Catch:{ all -> 0x05f1 }
        if (r4 == 0) goto L_0x03c1;
    L_0x03a6:
        r5 = r4.first;	 Catch:{ all -> 0x05f1 }
        r5 = (java.lang.CharSequence) r5;	 Catch:{ all -> 0x05f1 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x05f1 }
        if (r5 != 0) goto L_0x03c1;
    L_0x03b0:
        r5 = r12.zzjfx;	 Catch:{ all -> 0x05f1 }
        if (r5 == 0) goto L_0x040c;
    L_0x03b4:
        r5 = r4.first;	 Catch:{ all -> 0x05f1 }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x05f1 }
        r1.zzjvc = r5;	 Catch:{ all -> 0x05f1 }
        r4 = r4.second;	 Catch:{ all -> 0x05f1 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x05f1 }
        r1.zzjvd = r4;	 Catch:{ all -> 0x05f1 }
        goto L_0x040c;
    L_0x03c1:
        r4 = r33.zzayf();	 Catch:{ all -> 0x05f1 }
        r5 = r11.zzaiq;	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzec(r5);	 Catch:{ all -> 0x05f1 }
        if (r4 != 0) goto L_0x040c;
    L_0x03cd:
        r4 = r11.zzaiq;	 Catch:{ all -> 0x05f1 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x05f1 }
        r5 = "android_id";
        r4 = android.provider.Settings.Secure.getString(r4, r5);	 Catch:{ all -> 0x05f1 }
        if (r4 != 0) goto L_0x03f1;
    L_0x03db:
        r4 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzbaw();	 Catch:{ all -> 0x05f1 }
        r5 = "null secure ID. appId";
        r6 = r1.zzcm;	 Catch:{ all -> 0x05f1 }
        r6 = com.google.android.gms.internal.zzcjj.zzjs(r6);	 Catch:{ all -> 0x05f1 }
        r4.zzj(r5, r6);	 Catch:{ all -> 0x05f1 }
        r4 = "null";
        goto L_0x040a;
    L_0x03f1:
        r5 = r4.isEmpty();	 Catch:{ all -> 0x05f1 }
        if (r5 == 0) goto L_0x040a;
    L_0x03f7:
        r5 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r5 = r5.zzbaw();	 Catch:{ all -> 0x05f1 }
        r6 = "empty secure ID. appId";
        r7 = r1.zzcm;	 Catch:{ all -> 0x05f1 }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x05f1 }
        r5.zzj(r6, r7);	 Catch:{ all -> 0x05f1 }
    L_0x040a:
        r1.zzjvl = r4;	 Catch:{ all -> 0x05f1 }
    L_0x040c:
        r4 = r33.zzayf();	 Catch:{ all -> 0x05f1 }
        r4.zzyk();	 Catch:{ all -> 0x05f1 }
        r4 = android.os.Build.MODEL;	 Catch:{ all -> 0x05f1 }
        r1.zzjuy = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayf();	 Catch:{ all -> 0x05f1 }
        r4.zzyk();	 Catch:{ all -> 0x05f1 }
        r4 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x05f1 }
        r1.zzda = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayf();	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzbal();	 Catch:{ all -> 0x05f1 }
        r4 = (int) r4;	 Catch:{ all -> 0x05f1 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x05f1 }
        r1.zzjuz = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayf();	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzbam();	 Catch:{ all -> 0x05f1 }
        r1.zzjho = r4;	 Catch:{ all -> 0x05f1 }
        r1.zzjvb = r3;	 Catch:{ all -> 0x05f1 }
        r1.zzjus = r3;	 Catch:{ all -> 0x05f1 }
        r1.zzjut = r3;	 Catch:{ all -> 0x05f1 }
        r1.zzjuu = r3;	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfw;	 Catch:{ all -> 0x05f1 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x05f1 }
        r1.zzfqm = r4;	 Catch:{ all -> 0x05f1 }
        r4 = r33.isEnabled();	 Catch:{ all -> 0x05f1 }
        if (r4 == 0) goto L_0x0459;
    L_0x0451:
        r4 = com.google.android.gms.internal.zzcik.zzazv();	 Catch:{ all -> 0x05f1 }
        if (r4 == 0) goto L_0x0459;
    L_0x0457:
        r1.zzjvn = r3;	 Catch:{ all -> 0x05f1 }
    L_0x0459:
        r3 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r4 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r3 = r3.zzjj(r4);	 Catch:{ all -> 0x05f1 }
        if (r3 != 0) goto L_0x04c3;
    L_0x0465:
        r3 = new com.google.android.gms.internal.zzcie;	 Catch:{ all -> 0x05f1 }
        r4 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r3.<init>(r11, r4);	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzaye();	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzbaq();	 Catch:{ all -> 0x05f1 }
        r3.zziy(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfn;	 Catch:{ all -> 0x05f1 }
        r3.zzjb(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfl;	 Catch:{ all -> 0x05f1 }
        r3.zziz(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayq();	 Catch:{ all -> 0x05f1 }
        r5 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r4 = r4.zzjv(r5);	 Catch:{ all -> 0x05f1 }
        r3.zzja(r4);	 Catch:{ all -> 0x05f1 }
        r4 = 0;
        r3.zzaq(r4);	 Catch:{ all -> 0x05f1 }
        r3.zzal(r4);	 Catch:{ all -> 0x05f1 }
        r3.zzam(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzina;	 Catch:{ all -> 0x05f1 }
        r3.setAppVersion(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfr;	 Catch:{ all -> 0x05f1 }
        r3.zzan(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfs;	 Catch:{ all -> 0x05f1 }
        r3.zzjc(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjft;	 Catch:{ all -> 0x05f1 }
        r3.zzao(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfu;	 Catch:{ all -> 0x05f1 }
        r3.zzap(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfv;	 Catch:{ all -> 0x05f1 }
        r3.setMeasurementEnabled(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r12.zzjfw;	 Catch:{ all -> 0x05f1 }
        r3.zzaz(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r4.zza(r3);	 Catch:{ all -> 0x05f1 }
    L_0x04c3:
        r4 = r3.getAppInstanceId();	 Catch:{ all -> 0x05f1 }
        r1.zzjfk = r4;	 Catch:{ all -> 0x05f1 }
        r3 = r3.zzayu();	 Catch:{ all -> 0x05f1 }
        r1.zzjfn = r3;	 Catch:{ all -> 0x05f1 }
        r3 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r4 = r12.packageName;	 Catch:{ all -> 0x05f1 }
        r3 = r3.zzji(r4);	 Catch:{ all -> 0x05f1 }
        r4 = r3.size();	 Catch:{ all -> 0x05f1 }
        r4 = new com.google.android.gms.internal.zzcog[r4];	 Catch:{ all -> 0x05f1 }
        r1.zzjur = r4;	 Catch:{ all -> 0x05f1 }
        r4 = 0;
    L_0x04e2:
        r5 = r3.size();	 Catch:{ all -> 0x05f1 }
        if (r4 >= r5) goto L_0x051b;
    L_0x04e8:
        r5 = new com.google.android.gms.internal.zzcog;	 Catch:{ all -> 0x05f1 }
        r5.<init>();	 Catch:{ all -> 0x05f1 }
        r6 = r1.zzjur;	 Catch:{ all -> 0x05f1 }
        r6[r4] = r5;	 Catch:{ all -> 0x05f1 }
        r6 = r3.get(r4);	 Catch:{ all -> 0x05f1 }
        r6 = (com.google.android.gms.internal.zzcnn) r6;	 Catch:{ all -> 0x05f1 }
        r6 = r6.name;	 Catch:{ all -> 0x05f1 }
        r5.name = r6;	 Catch:{ all -> 0x05f1 }
        r6 = r3.get(r4);	 Catch:{ all -> 0x05f1 }
        r6 = (com.google.android.gms.internal.zzcnn) r6;	 Catch:{ all -> 0x05f1 }
        r6 = r6.zzjsi;	 Catch:{ all -> 0x05f1 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x05f1 }
        r5.zzjvr = r6;	 Catch:{ all -> 0x05f1 }
        r6 = r33.zzayl();	 Catch:{ all -> 0x05f1 }
        r7 = r3.get(r4);	 Catch:{ all -> 0x05f1 }
        r7 = (com.google.android.gms.internal.zzcnn) r7;	 Catch:{ all -> 0x05f1 }
        r7 = r7.value;	 Catch:{ all -> 0x05f1 }
        r6.zza(r5, r7);	 Catch:{ all -> 0x05f1 }
        r4 = r4 + 1;
        goto L_0x04e2;
    L_0x051b:
        r3 = r33.zzayj();	 Catch:{ IOException -> 0x058a }
        r3 = r3.zza(r1);	 Catch:{ IOException -> 0x058a }
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r5 = r13.zzjhr;	 Catch:{ all -> 0x05f1 }
        if (r5 == 0) goto L_0x057e;
    L_0x052b:
        r5 = r13.zzjhr;	 Catch:{ all -> 0x05f1 }
        r5 = r5.iterator();	 Catch:{ all -> 0x05f1 }
    L_0x0531:
        r6 = r5.hasNext();	 Catch:{ all -> 0x05f1 }
        if (r6 == 0) goto L_0x0546;
    L_0x0537:
        r6 = r5.next();	 Catch:{ all -> 0x05f1 }
        r6 = (java.lang.String) r6;	 Catch:{ all -> 0x05f1 }
        r7 = "_r";
        r6 = r7.equals(r6);	 Catch:{ all -> 0x05f1 }
        if (r6 == 0) goto L_0x0531;
    L_0x0545:
        goto L_0x057f;
    L_0x0546:
        r5 = r33.zzaym();	 Catch:{ all -> 0x05f1 }
        r6 = r13.zzcm;	 Catch:{ all -> 0x05f1 }
        r7 = r13.name;	 Catch:{ all -> 0x05f1 }
        r5 = r5.zzao(r6, r7);	 Catch:{ all -> 0x05f1 }
        r14 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r15 = r33.zzbbx();	 Catch:{ all -> 0x05f1 }
        r6 = r13.zzcm;	 Catch:{ all -> 0x05f1 }
        r18 = 0;
        r19 = 0;
        r20 = 0;
        r21 = 0;
        r22 = 0;
        r17 = r6;
        r6 = r14.zza(r15, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x05f1 }
        if (r5 == 0) goto L_0x057e;
    L_0x056e:
        r5 = r6.zzjhi;	 Catch:{ all -> 0x05f1 }
        r7 = r11.zzjns;	 Catch:{ all -> 0x05f1 }
        r8 = r13.zzcm;	 Catch:{ all -> 0x05f1 }
        r7 = r7.zzje(r8);	 Catch:{ all -> 0x05f1 }
        r7 = (long) r7;	 Catch:{ all -> 0x05f1 }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r9 >= 0) goto L_0x057e;
    L_0x057d:
        goto L_0x057f;
    L_0x057e:
        r2 = 0;
    L_0x057f:
        r1 = r1.zza(r13, r3, r2);	 Catch:{ all -> 0x05f1 }
        if (r1 == 0) goto L_0x059f;
    L_0x0585:
        r1 = 0;
        r11.zzjoy = r1;	 Catch:{ all -> 0x05f1 }
        goto L_0x059f;
    L_0x058a:
        r0 = move-exception;
        r2 = r0;
        r3 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r3 = r3.zzbau();	 Catch:{ all -> 0x05f1 }
        r4 = "Data loss. Failed to insert raw event metadata. appId";
        r1 = r1.zzcm;	 Catch:{ all -> 0x05f1 }
        r1 = com.google.android.gms.internal.zzcjj.zzjs(r1);	 Catch:{ all -> 0x05f1 }
        r3.zze(r4, r1, r2);	 Catch:{ all -> 0x05f1 }
    L_0x059f:
        r1 = r33.zzayj();	 Catch:{ all -> 0x05f1 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x05f1 }
        r1 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r2 = 2;
        r1 = r1.zzae(r2);	 Catch:{ all -> 0x05f1 }
        if (r1 == 0) goto L_0x05c6;
    L_0x05b1:
        r1 = r33.zzayp();	 Catch:{ all -> 0x05f1 }
        r1 = r1.zzbba();	 Catch:{ all -> 0x05f1 }
        r2 = "Event recorded";
        r3 = r33.zzayk();	 Catch:{ all -> 0x05f1 }
        r3 = r3.zza(r13);	 Catch:{ all -> 0x05f1 }
        r1.zzj(r2, r3);	 Catch:{ all -> 0x05f1 }
    L_0x05c6:
        r1 = r33.zzayj();
        r1.endTransaction();
        r33.zzbca();
        r1 = r33.zzayp();
        r1 = r1.zzbba();
        r2 = "Background event processing time, ms";
        r3 = java.lang.System.nanoTime();
        r5 = r3 - r30;
        r3 = 500000; // 0x7a120 float:7.00649E-40 double:2.47033E-318;
        r7 = r5 + r3;
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r7 = r7 / r3;
        r3 = java.lang.Long.valueOf(r7);
        r1.zzj(r2, r3);
        return;
    L_0x05f1:
        r0 = move-exception;
        r1 = r0;
        r2 = r33.zzayj();
        r2.endTransaction();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzc(com.google.android.gms.internal.zzcix, com.google.android.gms.internal.zzcif):void");
    }

    public static zzckj zzed(Context context) {
        zzbq.checkNotNull(context);
        zzbq.checkNotNull(context.getApplicationContext());
        if (zzjnr == null) {
            synchronized (zzckj.class) {
                if (zzjnr == null) {
                    zzjnr = new zzckj(new zzclj(context));
                }
            }
        }
        return zzjnr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013e  */
    @android.support.annotation.WorkerThread
    private final void zzg(com.google.android.gms.internal.zzcif r9) {
        /*
        r8 = this;
        r0 = r8.zzayo();
        r0.zzwj();
        r8.zzyk();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r9);
        r0 = r9.packageName;
        com.google.android.gms.common.internal.zzbq.zzgv(r0);
        r0 = r8.zzayj();
        r1 = r9.packageName;
        r0 = r0.zzjj(r1);
        r1 = r8.zzayq();
        r2 = r9.packageName;
        r1 = r1.zzjv(r2);
        r2 = 1;
        if (r0 != 0) goto L_0x0040;
    L_0x0029:
        r0 = new com.google.android.gms.internal.zzcie;
        r3 = r9.packageName;
        r0.<init>(r8, r3);
        r3 = r8.zzaye();
        r3 = r3.zzbaq();
        r0.zziy(r3);
        r0.zzja(r1);
    L_0x003e:
        r1 = 1;
        goto L_0x005a;
    L_0x0040:
        r3 = r0.zzayt();
        r3 = r1.equals(r3);
        if (r3 != 0) goto L_0x0059;
    L_0x004a:
        r0.zzja(r1);
        r1 = r8.zzaye();
        r1 = r1.zzbaq();
        r0.zziy(r1);
        goto L_0x003e;
    L_0x0059:
        r1 = 0;
    L_0x005a:
        r3 = r9.zzjfl;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0074;
    L_0x0062:
        r3 = r9.zzjfl;
        r4 = r0.getGmpAppId();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0074;
    L_0x006e:
        r1 = r9.zzjfl;
        r0.zziz(r1);
        r1 = 1;
    L_0x0074:
        r3 = r9.zzjfn;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x008e;
    L_0x007c:
        r3 = r9.zzjfn;
        r4 = r0.zzayu();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x008e;
    L_0x0088:
        r1 = r9.zzjfn;
        r0.zzjb(r1);
        r1 = 1;
    L_0x008e:
        r3 = r9.zzjft;
        r5 = 0;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x00a6;
    L_0x0096:
        r3 = r9.zzjft;
        r5 = r0.zzayz();
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x00a6;
    L_0x00a0:
        r3 = r9.zzjft;
        r0.zzao(r3);
        r1 = 1;
    L_0x00a6:
        r3 = r9.zzina;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x00c0;
    L_0x00ae:
        r3 = r9.zzina;
        r4 = r0.zzwo();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00c0;
    L_0x00ba:
        r1 = r9.zzina;
        r0.setAppVersion(r1);
        r1 = 1;
    L_0x00c0:
        r3 = r9.zzjfr;
        r5 = r0.zzayx();
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x00d0;
    L_0x00ca:
        r3 = r9.zzjfr;
        r0.zzan(r3);
        r1 = 1;
    L_0x00d0:
        r3 = r9.zzjfs;
        if (r3 == 0) goto L_0x00e6;
    L_0x00d4:
        r3 = r9.zzjfs;
        r4 = r0.zzayy();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00e6;
    L_0x00e0:
        r1 = r9.zzjfs;
        r0.zzjc(r1);
        r1 = 1;
    L_0x00e6:
        r3 = r9.zzjfu;
        r5 = r0.zzaza();
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x00f6;
    L_0x00f0:
        r3 = r9.zzjfu;
        r0.zzap(r3);
        r1 = 1;
    L_0x00f6:
        r3 = r9.zzjfv;
        r4 = r0.zzazb();
        if (r3 == r4) goto L_0x0104;
    L_0x00fe:
        r1 = r9.zzjfv;
        r0.setMeasurementEnabled(r1);
        r1 = 1;
    L_0x0104:
        r3 = r9.zzjgi;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x011e;
    L_0x010c:
        r3 = r9.zzjgi;
        r4 = r0.zzazm();
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x011e;
    L_0x0118:
        r1 = r9.zzjgi;
        r0.zzjd(r1);
        r1 = 1;
    L_0x011e:
        r3 = r9.zzjfw;
        r5 = r0.zzazo();
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x012e;
    L_0x0128:
        r3 = r9.zzjfw;
        r0.zzaz(r3);
        r1 = 1;
    L_0x012e:
        r3 = r9.zzjfx;
        r4 = r0.zzazp();
        if (r3 == r4) goto L_0x013c;
    L_0x0136:
        r9 = r9.zzjfx;
        r0.zzbq(r9);
        r1 = 1;
    L_0x013c:
        if (r1 == 0) goto L_0x0145;
    L_0x013e:
        r9 = r8.zzayj();
        r9.zza(r0);
    L_0x0145:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzg(com.google.android.gms.internal.zzcif):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:345:0x0935 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x098a A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0974 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x09e9 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a73 A:{SYNTHETIC, Splitter: B:391:0x0a73} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0290 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0282 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0290 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a73 A:{SYNTHETIC, Splitter: B:391:0x0a73} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0146 A:{SYNTHETIC, Splitter: B:68:0x0146} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0124 A:{SYNTHETIC, Splitter: B:59:0x0124} */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0282 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a73 A:{SYNTHETIC, Splitter: B:391:0x0a73} */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0290 A:{Catch:{ SQLiteException -> 0x0a50, all -> 0x0a8b }} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a87 A:{SYNTHETIC, Splitter: B:398:0x0a87} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a87 A:{SYNTHETIC, Splitter: B:398:0x0a87} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a87 A:{SYNTHETIC, Splitter: B:398:0x0a87} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a87 A:{SYNTHETIC, Splitter: B:398:0x0a87} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a87 A:{SYNTHETIC, Splitter: B:398:0x0a87} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A:{PHI: r3 , Splitter: B:9:0x0031, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A:{PHI: r3 , Splitter: B:9:0x0031, ExcHandler: all (r0_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:11:0x0040, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:0x0041, code:
            r2 = r0;
            r9 = r3;
     */
    /* JADX WARNING: Missing block: B:13:0x0045, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:14:0x0046, code:
            r9 = null;
            r12 = r9;
     */
    /* JADX WARNING: Missing block: B:28:0x0086, code:
            if (r3 != null) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:36:0x009e, code:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:37:0x009f, code:
            r9 = r3;
     */
    /* JADX WARNING: Missing block: B:51:0x00ea, code:
            if (r3 != null) goto L_0x0088;
     */
    /* JADX WARNING: Missing block: B:94:0x01cd, code:
            if (r5 != null) goto L_0x01cf;
     */
    /* JADX WARNING: Missing block: B:104:0x0200, code:
            if (r5 != null) goto L_0x01cf;
     */
    /* JADX WARNING: Missing block: B:109:0x021b, code:
            if (r5 != null) goto L_0x01cf;
     */
    /* JADX WARNING: Missing block: B:119:0x023f, code:
            if (r9 == null) goto L_0x027e;
     */
    /* JADX WARNING: Missing block: B:121:?, code:
            r9.close();
     */
    /* JADX WARNING: Missing block: B:140:0x027b, code:
            if (r9 == null) goto L_0x027e;
     */
    @android.support.annotation.WorkerThread
    private final boolean zzg(java.lang.String r61, long r62) {
        /*
        r60 = this;
        r1 = r60;
        r2 = r60.zzayj();
        r2.beginTransaction();
        r2 = new com.google.android.gms.internal.zzckj$zza;	 Catch:{ all -> 0x0a8b }
        r3 = 0;
        r2.<init>(r1, r3);	 Catch:{ all -> 0x0a8b }
        r4 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r5 = r1.zzjox;	 Catch:{ all -> 0x0a8b }
        com.google.android.gms.common.internal.zzbq.checkNotNull(r2);	 Catch:{ all -> 0x0a8b }
        r4.zzwj();	 Catch:{ all -> 0x0a8b }
        r4.zzyk();	 Catch:{ all -> 0x0a8b }
        r7 = -1;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r15 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        if (r12 == 0) goto L_0x00a1;
    L_0x002d:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x004b;
    L_0x0031:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r62);	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
        goto L_0x0053;
    L_0x0040:
        r0 = move-exception;
        r2 = r0;
        r9 = r3;
        goto L_0x0a85;
    L_0x0045:
        r0 = move-exception;
        r9 = r3;
        r12 = r9;
    L_0x0048:
        r3 = r0;
        goto L_0x026a;
    L_0x004b:
        r12 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r13 = java.lang.String.valueOf(r62);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
    L_0x0053:
        r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r13 == 0) goto L_0x005a;
    L_0x0057:
        r13 = "rowid <= ? and ";
        goto L_0x005c;
    L_0x005a:
        r13 = "";
    L_0x005c:
        r14 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r14 = r14.length();	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r14 = r14 + 148;
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3.<init>(r14);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r14 = "select app_id, metadata_fingerprint from raw_events where ";
        r3.append(r14);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3.append(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r13 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r3.append(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3 = r3.toString();	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3 = r15.rawQuery(r3, r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025c, all -> 0x0040 }
        if (r12 != 0) goto L_0x008d;
    L_0x0086:
        if (r3 == 0) goto L_0x027e;
    L_0x0088:
        r3.close();	 Catch:{ all -> 0x0a8b }
        goto L_0x027e;
    L_0x008d:
        r12 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025c, all -> 0x0040 }
        r13 = r3.getString(r11);	 Catch:{ SQLiteException -> 0x009e, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x009e, all -> 0x0040 }
        r22 = r3;
        r3 = r12;
        r21 = r13;
        goto L_0x00f9;
    L_0x009e:
        r0 = move-exception;
        r9 = r3;
        goto L_0x0048;
    L_0x00a1:
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 == 0) goto L_0x00b2;
    L_0x00a5:
        r3 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = 0;
        r3[r10] = r12;	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3[r11] = r12;	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = r3;
        goto L_0x00b7;
    L_0x00b2:
        r3 = 0;
        r12 = new java.lang.String[]{r3};	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
    L_0x00b7:
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 == 0) goto L_0x00be;
    L_0x00bb:
        r3 = " and rowid <= ?";
        goto L_0x00c0;
    L_0x00be:
        r3 = "";
    L_0x00c0:
        r13 = java.lang.String.valueOf(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r13 = r13.length();	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r13 = r13 + 84;
        r14 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r14.<init>(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r13 = "select metadata_fingerprint from raw_events where app_id = ?";
        r14.append(r13);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3 = " order by rowid limit 1;";
        r14.append(r3);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3 = r14.toString();	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r3 = r15.rawQuery(r3, r12);	 Catch:{ SQLiteException -> 0x0266, all -> 0x0261 }
        r12 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x025c, all -> 0x0040 }
        if (r12 != 0) goto L_0x00ed;
    L_0x00ea:
        if (r3 == 0) goto L_0x027e;
    L_0x00ec:
        goto L_0x0088;
    L_0x00ed:
        r13 = r3.getString(r10);	 Catch:{ SQLiteException -> 0x025c, all -> 0x0040 }
        r3.close();	 Catch:{ SQLiteException -> 0x025c, all -> 0x0040 }
        r22 = r3;
        r21 = r13;
        r3 = 0;
    L_0x00f9:
        r13 = "raw_events_metadata";
        r12 = "metadata";
        r14 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0256, all -> 0x0250 }
        r16 = "app_id = ? and metadata_fingerprint = ?";
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0256, all -> 0x0250 }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x0256, all -> 0x0250 }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x0256, all -> 0x0250 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = "2";
        r23 = r12;
        r12 = r15;
        r24 = r15;
        r15 = r16;
        r16 = r23;
        r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0256, all -> 0x0250 }
        r12 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        if (r12 != 0) goto L_0x0146;
    L_0x0124:
        r5 = r4.zzayp();	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r6 = "Raw event metadata record is missing. appId";
        r12 = com.google.android.gms.internal.zzcjj.zzjs(r3);	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r5.zzj(r6, r12);	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        if (r15 == 0) goto L_0x027e;
    L_0x0137:
        r15.close();	 Catch:{ all -> 0x0a8b }
        goto L_0x027e;
    L_0x013c:
        r0 = move-exception;
        r2 = r0;
        r9 = r15;
        goto L_0x0a85;
    L_0x0141:
        r0 = move-exception;
        r12 = r3;
        r9 = r15;
        goto L_0x0048;
    L_0x0146:
        r12 = r15.getBlob(r10);	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r13 = r12.length;	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r12 = com.google.android.gms.internal.zzflj.zzo(r12, r10, r13);	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r13 = new com.google.android.gms.internal.zzcoe;	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r13.<init>();	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r13.zza(r12);	 Catch:{ IOException -> 0x022c }
        r12 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        if (r12 == 0) goto L_0x016e;
    L_0x015d:
        r12 = r4.zzayp();	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r12 = r12.zzbaw();	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r14 = "Get multiple raw event metadata records, expected one. appId";
        r9 = com.google.android.gms.internal.zzcjj.zzjs(r3);	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r12.zzj(r14, r9);	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
    L_0x016e:
        r15.close();	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r2.zzb(r13);	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        r14 = 3;
        if (r9 == 0) goto L_0x018c;
    L_0x0179:
        r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r12 = new java.lang.String[r14];	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r6 = 2;
        r12[r6] = r5;	 Catch:{ SQLiteException -> 0x0141, all -> 0x013c }
        r5 = r9;
        r16 = r12;
        goto L_0x0197;
    L_0x018c:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r9 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r9[r10] = r3;	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r9[r11] = r21;	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r16 = r9;
    L_0x0197:
        r13 = "raw_events";
        r6 = "rowid";
        r9 = "name";
        r12 = "timestamp";
        r14 = "data";
        r14 = new java.lang.String[]{r6, r9, r12, r14};	 Catch:{ SQLiteException -> 0x024b, all -> 0x0247 }
        r17 = 0;
        r18 = 0;
        r19 = "rowid";
        r20 = 0;
        r12 = r24;
        r6 = 3;
        r9 = r15;
        r15 = r5;
        r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0245 }
        r9 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        if (r9 != 0) goto L_0x01d4;
    L_0x01bc:
        r6 = r4.zzayp();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6 = r6.zzbaw();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r9 = "Raw event data disappeared while in transaction. appId";
        r12 = com.google.android.gms.internal.zzcjj.zzjs(r3);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6.zzj(r9, r12);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        if (r5 == 0) goto L_0x027e;
    L_0x01cf:
        r5.close();	 Catch:{ all -> 0x0a8b }
        goto L_0x027e;
    L_0x01d4:
        r12 = r5.getLong(r10);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r9 = r5.getBlob(r6);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14 = r9.length;	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r9 = com.google.android.gms.internal.zzflj.zzo(r9, r10, r14);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14 = new com.google.android.gms.internal.zzcob;	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14.<init>();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14.zza(r9);	 Catch:{ IOException -> 0x0203 }
        r9 = r5.getString(r11);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14.name = r9;	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r9 = 2;
        r6 = r5.getLong(r9);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r14.zzjuj = r6;	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6 = r2.zza(r12, r14);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        if (r6 != 0) goto L_0x0215;
    L_0x0200:
        if (r5 == 0) goto L_0x027e;
    L_0x0202:
        goto L_0x01cf;
    L_0x0203:
        r0 = move-exception;
        r6 = r4.zzayp();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6 = r6.zzbau();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r7 = "Data loss. Failed to merge raw event. appId";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r3);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        r6.zze(r7, r8, r0);	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
    L_0x0215:
        r6 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x0227, all -> 0x0222 }
        if (r6 != 0) goto L_0x021e;
    L_0x021b:
        if (r5 == 0) goto L_0x027e;
    L_0x021d:
        goto L_0x01cf;
    L_0x021e:
        r6 = 3;
        r7 = -1;
        goto L_0x01d4;
    L_0x0222:
        r0 = move-exception;
        r2 = r0;
        r9 = r5;
        goto L_0x0a85;
    L_0x0227:
        r0 = move-exception;
        r12 = r3;
        r9 = r5;
        goto L_0x0048;
    L_0x022c:
        r0 = move-exception;
        r9 = r15;
        r5 = r4.zzayp();	 Catch:{ SQLiteException -> 0x0245 }
        r5 = r5.zzbau();	 Catch:{ SQLiteException -> 0x0245 }
        r6 = "Data loss. Failed to merge raw event metadata. appId";
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r3);	 Catch:{ SQLiteException -> 0x0245 }
        r5.zze(r6, r7, r0);	 Catch:{ SQLiteException -> 0x0245 }
        if (r9 == 0) goto L_0x027e;
    L_0x0241:
        r9.close();	 Catch:{ all -> 0x0a8b }
        goto L_0x027e;
    L_0x0245:
        r0 = move-exception;
        goto L_0x024d;
    L_0x0247:
        r0 = move-exception;
        r9 = r15;
        goto L_0x0a84;
    L_0x024b:
        r0 = move-exception;
        r9 = r15;
    L_0x024d:
        r12 = r3;
        goto L_0x0048;
    L_0x0250:
        r0 = move-exception;
        r2 = r0;
        r9 = r22;
        goto L_0x0a85;
    L_0x0256:
        r0 = move-exception;
        r12 = r3;
        r9 = r22;
        goto L_0x0048;
    L_0x025c:
        r0 = move-exception;
        r9 = r3;
        r12 = 0;
        goto L_0x0048;
    L_0x0261:
        r0 = move-exception;
        r2 = r0;
        r9 = 0;
        goto L_0x0a85;
    L_0x0266:
        r0 = move-exception;
        r3 = r0;
        r9 = 0;
        r12 = 0;
    L_0x026a:
        r4 = r4.zzayp();	 Catch:{ all -> 0x0a83 }
        r4 = r4.zzbau();	 Catch:{ all -> 0x0a83 }
        r5 = "Data loss. Error selecting raw event. appId";
        r6 = com.google.android.gms.internal.zzcjj.zzjs(r12);	 Catch:{ all -> 0x0a83 }
        r4.zze(r5, r6, r3);	 Catch:{ all -> 0x0a83 }
        if (r9 == 0) goto L_0x027e;
    L_0x027d:
        goto L_0x0241;
    L_0x027e:
        r3 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        if (r3 == 0) goto L_0x028d;
    L_0x0282:
        r3 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        r3 = r3.isEmpty();	 Catch:{ all -> 0x0a8b }
        if (r3 == 0) goto L_0x028b;
    L_0x028a:
        goto L_0x028d;
    L_0x028b:
        r3 = 0;
        goto L_0x028e;
    L_0x028d:
        r3 = 1;
    L_0x028e:
        if (r3 != 0) goto L_0x0a73;
    L_0x0290:
        r3 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r4 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        r4 = r4.size();	 Catch:{ all -> 0x0a8b }
        r4 = new com.google.android.gms.internal.zzcob[r4];	 Catch:{ all -> 0x0a8b }
        r3.zzjuq = r4;	 Catch:{ all -> 0x0a8b }
        r4 = r1.zzjns;	 Catch:{ all -> 0x0a8b }
        r5 = r3.zzcm;	 Catch:{ all -> 0x0a8b }
        r4 = r4.zzjh(r5);	 Catch:{ all -> 0x0a8b }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r12 = 0;
    L_0x02a9:
        r14 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        r14 = r14.size();	 Catch:{ all -> 0x0a8b }
        if (r7 >= r14) goto L_0x059e;
    L_0x02b1:
        r14 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        r14 = r14.get(r7);	 Catch:{ all -> 0x0a8b }
        r14 = (com.google.android.gms.internal.zzcob) r14;	 Catch:{ all -> 0x0a8b }
        r15 = r60.zzaym();	 Catch:{ all -> 0x0a8b }
        r11 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r11 = r11.zzcm;	 Catch:{ all -> 0x0a8b }
        r5 = r14.name;	 Catch:{ all -> 0x0a8b }
        r5 = r15.zzan(r11, r5);	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x032f;
    L_0x02c9:
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbaw();	 Catch:{ all -> 0x0a8b }
        r6 = "Dropping blacklisted raw event. appId";
        r11 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r11 = r11.zzcm;	 Catch:{ all -> 0x0a8b }
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ all -> 0x0a8b }
        r15 = r60.zzayk();	 Catch:{ all -> 0x0a8b }
        r10 = r14.name;	 Catch:{ all -> 0x0a8b }
        r10 = r15.zzjp(r10);	 Catch:{ all -> 0x0a8b }
        r5.zze(r6, r11, r10);	 Catch:{ all -> 0x0a8b }
        r5 = r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r6 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzcm;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzks(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x0307;
    L_0x02f6:
        r5 = r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r6 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzcm;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzkt(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x0305;
    L_0x0304:
        goto L_0x0307;
    L_0x0305:
        r5 = 0;
        goto L_0x0308;
    L_0x0307:
        r5 = 1;
    L_0x0308:
        if (r5 != 0) goto L_0x032b;
    L_0x030a:
        r5 = "_err";
        r6 = r14.name;	 Catch:{ all -> 0x0a8b }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x032b;
    L_0x0314:
        r15 = r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r5 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzcm;	 Catch:{ all -> 0x0a8b }
        r17 = 11;
        r18 = "_ev";
        r6 = r14.name;	 Catch:{ all -> 0x0a8b }
        r20 = 0;
        r16 = r5;
        r19 = r6;
        r15.zza(r16, r17, r18, r19, r20);	 Catch:{ all -> 0x0a8b }
    L_0x032b:
        r28 = r7;
        goto L_0x0598;
    L_0x032f:
        r5 = r60.zzaym();	 Catch:{ all -> 0x0a8b }
        r6 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzcm;	 Catch:{ all -> 0x0a8b }
        r10 = r14.name;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzao(r6, r10);	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x034f;
    L_0x033f:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r6 = r14.name;	 Catch:{ all -> 0x0a8b }
        r6 = com.google.android.gms.internal.zzcno.zzku(r6);	 Catch:{ all -> 0x0a8b }
        if (r6 == 0) goto L_0x034b;
    L_0x034a:
        goto L_0x034f;
    L_0x034b:
        r28 = r7;
        goto L_0x053b;
    L_0x034f:
        r6 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        if (r6 != 0) goto L_0x0358;
    L_0x0353:
        r6 = 0;
        r10 = new com.google.android.gms.internal.zzcoc[r6];	 Catch:{ all -> 0x0a8b }
        r14.zzjui = r10;	 Catch:{ all -> 0x0a8b }
    L_0x0358:
        r6 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r10 = r6.length;	 Catch:{ all -> 0x0a8b }
        r11 = 0;
        r15 = 0;
        r16 = 0;
    L_0x035f:
        if (r11 >= r10) goto L_0x03a0;
    L_0x0361:
        r25 = r10;
        r10 = r6[r11];	 Catch:{ all -> 0x0a8b }
        r26 = r6;
        r6 = "_c";
        r27 = r8;
        r8 = r10.name;	 Catch:{ all -> 0x0a8b }
        r6 = r6.equals(r8);	 Catch:{ all -> 0x0a8b }
        if (r6 == 0) goto L_0x037f;
    L_0x0373:
        r28 = r7;
        r6 = 1;
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r10.zzjum = r8;	 Catch:{ all -> 0x0a8b }
        r15 = 1;
        goto L_0x0395;
    L_0x037f:
        r28 = r7;
        r6 = "_r";
        r7 = r10.name;	 Catch:{ all -> 0x0a8b }
        r6 = r6.equals(r7);	 Catch:{ all -> 0x0a8b }
        if (r6 == 0) goto L_0x0395;
    L_0x038b:
        r6 = 1;
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r10.zzjum = r8;	 Catch:{ all -> 0x0a8b }
        r16 = 1;
    L_0x0395:
        r11 = r11 + 1;
        r10 = r25;
        r6 = r26;
        r8 = r27;
        r7 = r28;
        goto L_0x035f;
    L_0x03a0:
        r28 = r7;
        r27 = r8;
        if (r15 != 0) goto L_0x03e4;
    L_0x03a6:
        if (r5 == 0) goto L_0x03e4;
    L_0x03a8:
        r6 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzbba();	 Catch:{ all -> 0x0a8b }
        r7 = "Marking event as conversion";
        r8 = r60.zzayk();	 Catch:{ all -> 0x0a8b }
        r10 = r14.name;	 Catch:{ all -> 0x0a8b }
        r8 = r8.zzjp(r10);	 Catch:{ all -> 0x0a8b }
        r6.zzj(r7, r8);	 Catch:{ all -> 0x0a8b }
        r6 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        r8 = 1;
        r7 = r7 + r8;
        r6 = java.util.Arrays.copyOf(r6, r7);	 Catch:{ all -> 0x0a8b }
        r6 = (com.google.android.gms.internal.zzcoc[]) r6;	 Catch:{ all -> 0x0a8b }
        r7 = new com.google.android.gms.internal.zzcoc;	 Catch:{ all -> 0x0a8b }
        r7.<init>();	 Catch:{ all -> 0x0a8b }
        r8 = "_c";
        r7.name = r8;	 Catch:{ all -> 0x0a8b }
        r10 = 1;
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0a8b }
        r7.zzjum = r8;	 Catch:{ all -> 0x0a8b }
        r8 = r6.length;	 Catch:{ all -> 0x0a8b }
        r10 = 1;
        r8 = r8 - r10;
        r6[r8] = r7;	 Catch:{ all -> 0x0a8b }
        r14.zzjui = r6;	 Catch:{ all -> 0x0a8b }
    L_0x03e4:
        if (r16 != 0) goto L_0x0422;
    L_0x03e6:
        r6 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzbba();	 Catch:{ all -> 0x0a8b }
        r7 = "Marking event as real-time";
        r8 = r60.zzayk();	 Catch:{ all -> 0x0a8b }
        r10 = r14.name;	 Catch:{ all -> 0x0a8b }
        r8 = r8.zzjp(r10);	 Catch:{ all -> 0x0a8b }
        r6.zzj(r7, r8);	 Catch:{ all -> 0x0a8b }
        r6 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        r8 = 1;
        r7 = r7 + r8;
        r6 = java.util.Arrays.copyOf(r6, r7);	 Catch:{ all -> 0x0a8b }
        r6 = (com.google.android.gms.internal.zzcoc[]) r6;	 Catch:{ all -> 0x0a8b }
        r7 = new com.google.android.gms.internal.zzcoc;	 Catch:{ all -> 0x0a8b }
        r7.<init>();	 Catch:{ all -> 0x0a8b }
        r8 = "_r";
        r7.name = r8;	 Catch:{ all -> 0x0a8b }
        r10 = 1;
        r8 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0a8b }
        r7.zzjum = r8;	 Catch:{ all -> 0x0a8b }
        r8 = r6.length;	 Catch:{ all -> 0x0a8b }
        r10 = 1;
        r8 = r8 - r10;
        r6[r8] = r7;	 Catch:{ all -> 0x0a8b }
        r14.zzjui = r6;	 Catch:{ all -> 0x0a8b }
    L_0x0422:
        r29 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r30 = r60.zzbbx();	 Catch:{ all -> 0x0a8b }
        r6 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzcm;	 Catch:{ all -> 0x0a8b }
        r33 = 0;
        r34 = 0;
        r35 = 0;
        r36 = 0;
        r37 = 1;
        r32 = r6;
        r6 = r29.zza(r30, r32, r33, r34, r35, r36, r37);	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzjhi;	 Catch:{ all -> 0x0a8b }
        r8 = r1.zzjns;	 Catch:{ all -> 0x0a8b }
        r10 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r10 = r10.zzcm;	 Catch:{ all -> 0x0a8b }
        r8 = r8.zzje(r10);	 Catch:{ all -> 0x0a8b }
        r10 = (long) r8;	 Catch:{ all -> 0x0a8b }
        r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r8 <= 0) goto L_0x0487;
    L_0x044f:
        r6 = 0;
    L_0x0450:
        r7 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        if (r6 >= r7) goto L_0x0484;
    L_0x0455:
        r7 = "_r";
        r8 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r8 = r8[r6];	 Catch:{ all -> 0x0a8b }
        r8 = r8.name;	 Catch:{ all -> 0x0a8b }
        r7 = r7.equals(r8);	 Catch:{ all -> 0x0a8b }
        if (r7 == 0) goto L_0x0481;
    L_0x0463:
        r7 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        r8 = 1;
        r7 = r7 - r8;
        r7 = new com.google.android.gms.internal.zzcoc[r7];	 Catch:{ all -> 0x0a8b }
        if (r6 <= 0) goto L_0x0472;
    L_0x046c:
        r8 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r10 = 0;
        java.lang.System.arraycopy(r8, r10, r7, r10, r6);	 Catch:{ all -> 0x0a8b }
    L_0x0472:
        r8 = r7.length;	 Catch:{ all -> 0x0a8b }
        if (r6 >= r8) goto L_0x047e;
    L_0x0475:
        r8 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r10 = r6 + 1;
        r11 = r7.length;	 Catch:{ all -> 0x0a8b }
        r11 = r11 - r6;
        java.lang.System.arraycopy(r8, r10, r7, r6, r11);	 Catch:{ all -> 0x0a8b }
    L_0x047e:
        r14.zzjui = r7;	 Catch:{ all -> 0x0a8b }
        goto L_0x0484;
    L_0x0481:
        r6 = r6 + 1;
        goto L_0x0450;
    L_0x0484:
        r8 = r27;
        goto L_0x0488;
    L_0x0487:
        r8 = 1;
    L_0x0488:
        r6 = r14.name;	 Catch:{ all -> 0x0a8b }
        r6 = com.google.android.gms.internal.zzcno.zzkh(r6);	 Catch:{ all -> 0x0a8b }
        if (r6 == 0) goto L_0x053b;
    L_0x0490:
        if (r5 == 0) goto L_0x053b;
    L_0x0492:
        r29 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r30 = r60.zzbbx();	 Catch:{ all -> 0x0a8b }
        r5 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzcm;	 Catch:{ all -> 0x0a8b }
        r33 = 0;
        r34 = 0;
        r35 = 1;
        r36 = 0;
        r37 = 0;
        r32 = r5;
        r5 = r29.zza(r30, r32, r33, r34, r35, r36, r37);	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzjhg;	 Catch:{ all -> 0x0a8b }
        r7 = r1.zzjns;	 Catch:{ all -> 0x0a8b }
        r10 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r10 = r10.zzcm;	 Catch:{ all -> 0x0a8b }
        r11 = com.google.android.gms.internal.zzciz.zzjja;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzb(r10, r11);	 Catch:{ all -> 0x0a8b }
        r10 = (long) r7;	 Catch:{ all -> 0x0a8b }
        r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x053b;
    L_0x04c1:
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbaw();	 Catch:{ all -> 0x0a8b }
        r6 = "Too many conversions. Not logging as conversion. appId";
        r7 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
        r5.zzj(r6, r7);	 Catch:{ all -> 0x0a8b }
        r5 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r6 = r5.length;	 Catch:{ all -> 0x0a8b }
        r7 = 0;
        r10 = 0;
        r11 = 0;
    L_0x04dc:
        if (r7 >= r6) goto L_0x0502;
    L_0x04de:
        r15 = r5[r7];	 Catch:{ all -> 0x0a8b }
        r38 = r5;
        r5 = "_c";
        r39 = r6;
        r6 = r15.name;	 Catch:{ all -> 0x0a8b }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x04f0;
    L_0x04ee:
        r11 = r15;
        goto L_0x04fb;
    L_0x04f0:
        r5 = "_err";
        r6 = r15.name;	 Catch:{ all -> 0x0a8b }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x04fb;
    L_0x04fa:
        r10 = 1;
    L_0x04fb:
        r7 = r7 + 1;
        r5 = r38;
        r6 = r39;
        goto L_0x04dc;
    L_0x0502:
        if (r10 == 0) goto L_0x0517;
    L_0x0504:
        if (r11 == 0) goto L_0x0517;
    L_0x0506:
        r5 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r6 = 1;
        r7 = new com.google.android.gms.internal.zzcoc[r6];	 Catch:{ all -> 0x0a8b }
        r6 = 0;
        r7[r6] = r11;	 Catch:{ all -> 0x0a8b }
        r5 = com.google.android.gms.common.util.zzb.zza(r5, r7);	 Catch:{ all -> 0x0a8b }
        r5 = (com.google.android.gms.internal.zzcoc[]) r5;	 Catch:{ all -> 0x0a8b }
        r14.zzjui = r5;	 Catch:{ all -> 0x0a8b }
        goto L_0x053b;
    L_0x0517:
        if (r11 == 0) goto L_0x0526;
    L_0x0519:
        r5 = "_err";
        r11.name = r5;	 Catch:{ all -> 0x0a8b }
        r5 = 10;
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0a8b }
        r11.zzjum = r5;	 Catch:{ all -> 0x0a8b }
        goto L_0x053b;
    L_0x0526:
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbau();	 Catch:{ all -> 0x0a8b }
        r6 = "Did not find conversion parameter. appId";
        r7 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
        r5.zzj(r6, r7);	 Catch:{ all -> 0x0a8b }
    L_0x053b:
        if (r4 == 0) goto L_0x058f;
    L_0x053d:
        r5 = "_e";
        r6 = r14.name;	 Catch:{ all -> 0x0a8b }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x058f;
    L_0x0547:
        r5 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x057c;
    L_0x054b:
        r5 = r14.zzjui;	 Catch:{ all -> 0x0a8b }
        r5 = r5.length;	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x0551;
    L_0x0550:
        goto L_0x057c;
    L_0x0551:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r5 = "_et";
        r5 = com.google.android.gms.internal.zzcno.zzb(r14, r5);	 Catch:{ all -> 0x0a8b }
        r5 = (java.lang.Long) r5;	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x0574;
    L_0x055e:
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbaw();	 Catch:{ all -> 0x0a8b }
        r6 = "Engagement event does not include duration. appId";
        r7 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
    L_0x0570:
        r5.zzj(r6, r7);	 Catch:{ all -> 0x0a8b }
        goto L_0x058f;
    L_0x0574:
        r5 = r5.longValue();	 Catch:{ all -> 0x0a8b }
        r7 = 0;
        r10 = r12 + r5;
        goto L_0x0590;
    L_0x057c:
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbaw();	 Catch:{ all -> 0x0a8b }
        r6 = "Engagement event does not contain any parameters. appId";
        r7 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
        goto L_0x0570;
    L_0x058f:
        r10 = r12;
    L_0x0590:
        r5 = r3.zzjuq;	 Catch:{ all -> 0x0a8b }
        r6 = r9 + 1;
        r5[r9] = r14;	 Catch:{ all -> 0x0a8b }
        r9 = r6;
        r12 = r10;
    L_0x0598:
        r7 = r28 + 1;
        r10 = 0;
        r11 = 1;
        goto L_0x02a9;
    L_0x059e:
        r27 = r8;
        r5 = r2.zzaoz;	 Catch:{ all -> 0x0a8b }
        r5 = r5.size();	 Catch:{ all -> 0x0a8b }
        if (r9 >= r5) goto L_0x05b2;
    L_0x05a8:
        r5 = r3.zzjuq;	 Catch:{ all -> 0x0a8b }
        r5 = java.util.Arrays.copyOf(r5, r9);	 Catch:{ all -> 0x0a8b }
        r5 = (com.google.android.gms.internal.zzcob[]) r5;	 Catch:{ all -> 0x0a8b }
        r3.zzjuq = r5;	 Catch:{ all -> 0x0a8b }
    L_0x05b2:
        if (r4 == 0) goto L_0x0674;
    L_0x05b4:
        r4 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r5 = r3.zzcm;	 Catch:{ all -> 0x0a8b }
        r6 = "_lte";
        r4 = r4.zzag(r5, r6);	 Catch:{ all -> 0x0a8b }
        if (r4 == 0) goto L_0x05ea;
    L_0x05c2:
        r5 = r4.value;	 Catch:{ all -> 0x0a8b }
        if (r5 != 0) goto L_0x05c7;
    L_0x05c6:
        goto L_0x05ea;
    L_0x05c7:
        r5 = new com.google.android.gms.internal.zzcnn;	 Catch:{ all -> 0x0a8b }
        r15 = r3.zzcm;	 Catch:{ all -> 0x0a8b }
        r16 = "auto";
        r17 = "_lte";
        r6 = r1.zzdir;	 Catch:{ all -> 0x0a8b }
        r18 = r6.currentTimeMillis();	 Catch:{ all -> 0x0a8b }
        r4 = r4.value;	 Catch:{ all -> 0x0a8b }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x0a8b }
        r6 = r4.longValue();	 Catch:{ all -> 0x0a8b }
        r4 = 0;
        r8 = r6 + r12;
        r20 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0a8b }
        r14 = r5;
        r14.<init>(r15, r16, r17, r18, r20);	 Catch:{ all -> 0x0a8b }
        r4 = r5;
        goto L_0x0603;
    L_0x05ea:
        r4 = new com.google.android.gms.internal.zzcnn;	 Catch:{ all -> 0x0a8b }
        r5 = r3.zzcm;	 Catch:{ all -> 0x0a8b }
        r30 = "auto";
        r31 = "_lte";
        r6 = r1.zzdir;	 Catch:{ all -> 0x0a8b }
        r32 = r6.currentTimeMillis();	 Catch:{ all -> 0x0a8b }
        r34 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0a8b }
        r28 = r4;
        r29 = r5;
        r28.<init>(r29, r30, r31, r32, r34);	 Catch:{ all -> 0x0a8b }
    L_0x0603:
        r5 = new com.google.android.gms.internal.zzcog;	 Catch:{ all -> 0x0a8b }
        r5.<init>();	 Catch:{ all -> 0x0a8b }
        r6 = "_lte";
        r5.name = r6;	 Catch:{ all -> 0x0a8b }
        r6 = r1.zzdir;	 Catch:{ all -> 0x0a8b }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x0a8b }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r5.zzjvr = r6;	 Catch:{ all -> 0x0a8b }
        r6 = r4.value;	 Catch:{ all -> 0x0a8b }
        r6 = (java.lang.Long) r6;	 Catch:{ all -> 0x0a8b }
        r5.zzjum = r6;	 Catch:{ all -> 0x0a8b }
        r6 = 0;
    L_0x061f:
        r7 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        if (r6 >= r7) goto L_0x063b;
    L_0x0624:
        r7 = "_lte";
        r8 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r8 = r8[r6];	 Catch:{ all -> 0x0a8b }
        r8 = r8.name;	 Catch:{ all -> 0x0a8b }
        r7 = r7.equals(r8);	 Catch:{ all -> 0x0a8b }
        if (r7 == 0) goto L_0x0638;
    L_0x0632:
        r7 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r7[r6] = r5;	 Catch:{ all -> 0x0a8b }
        r6 = 1;
        goto L_0x063c;
    L_0x0638:
        r6 = r6 + 1;
        goto L_0x061f;
    L_0x063b:
        r6 = 0;
    L_0x063c:
        if (r6 != 0) goto L_0x0658;
    L_0x063e:
        r6 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r7 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        r8 = 1;
        r7 = r7 + r8;
        r6 = java.util.Arrays.copyOf(r6, r7);	 Catch:{ all -> 0x0a8b }
        r6 = (com.google.android.gms.internal.zzcog[]) r6;	 Catch:{ all -> 0x0a8b }
        r3.zzjur = r6;	 Catch:{ all -> 0x0a8b }
        r6 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r7 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzjur;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        r8 = 1;
        r7 = r7 - r8;
        r6[r7] = r5;	 Catch:{ all -> 0x0a8b }
    L_0x0658:
        r5 = 0;
        r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0674;
    L_0x065e:
        r5 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r5.zza(r4);	 Catch:{ all -> 0x0a8b }
        r5 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzbaz();	 Catch:{ all -> 0x0a8b }
        r6 = "Updated lifetime engagement user property with value. Value";
        r4 = r4.value;	 Catch:{ all -> 0x0a8b }
        r5.zzj(r6, r4);	 Catch:{ all -> 0x0a8b }
    L_0x0674:
        r4 = r3.zzcm;	 Catch:{ all -> 0x0a8b }
        r5 = r3.zzjur;	 Catch:{ all -> 0x0a8b }
        r6 = r3.zzjuq;	 Catch:{ all -> 0x0a8b }
        r4 = r1.zza(r4, r5, r6);	 Catch:{ all -> 0x0a8b }
        r3.zzjvh = r4;	 Catch:{ all -> 0x0a8b }
        r4 = com.google.android.gms.internal.zzciz.zzjim;	 Catch:{ all -> 0x0a8b }
        r4 = r4.get();	 Catch:{ all -> 0x0a8b }
        r4 = (java.lang.Boolean) r4;	 Catch:{ all -> 0x0a8b }
        r4 = r4.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r4 == 0) goto L_0x0918;
    L_0x068e:
        r4 = r1.zzjns;	 Catch:{ all -> 0x0a8b }
        r5 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzcm;	 Catch:{ all -> 0x0a8b }
        r6 = "1";
        r4 = r4.zzaym();	 Catch:{ all -> 0x0a8b }
        r7 = "measurement.event_sampling_enabled";
        r4 = r4.zzam(r5, r7);	 Catch:{ all -> 0x0a8b }
        r4 = r6.equals(r4);	 Catch:{ all -> 0x0a8b }
        if (r4 == 0) goto L_0x0918;
    L_0x06a6:
        r4 = new java.util.HashMap;	 Catch:{ all -> 0x0a8b }
        r4.<init>();	 Catch:{ all -> 0x0a8b }
        r5 = r3.zzjuq;	 Catch:{ all -> 0x0a8b }
        r5 = r5.length;	 Catch:{ all -> 0x0a8b }
        r5 = new com.google.android.gms.internal.zzcob[r5];	 Catch:{ all -> 0x0a8b }
        r6 = r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzbcr();	 Catch:{ all -> 0x0a8b }
        r7 = r3.zzjuq;	 Catch:{ all -> 0x0a8b }
        r8 = r7.length;	 Catch:{ all -> 0x0a8b }
        r9 = 0;
        r10 = 0;
    L_0x06bd:
        if (r9 >= r8) goto L_0x08e5;
    L_0x06bf:
        r11 = r7[r9];	 Catch:{ all -> 0x0a8b }
        r12 = r11.name;	 Catch:{ all -> 0x0a8b }
        r13 = "_ep";
        r12 = r12.equals(r13);	 Catch:{ all -> 0x0a8b }
        if (r12 == 0) goto L_0x073e;
    L_0x06cb:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r12 = "_en";
        r12 = com.google.android.gms.internal.zzcno.zzb(r11, r12);	 Catch:{ all -> 0x0a8b }
        r12 = (java.lang.String) r12;	 Catch:{ all -> 0x0a8b }
        r13 = r4.get(r12);	 Catch:{ all -> 0x0a8b }
        r13 = (com.google.android.gms.internal.zzcit) r13;	 Catch:{ all -> 0x0a8b }
        if (r13 != 0) goto L_0x06ed;
    L_0x06de:
        r13 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r14 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r14 = r14.zzcm;	 Catch:{ all -> 0x0a8b }
        r13 = r13.zzae(r14, r12);	 Catch:{ all -> 0x0a8b }
        r4.put(r12, r13);	 Catch:{ all -> 0x0a8b }
    L_0x06ed:
        r12 = r13.zzjhw;	 Catch:{ all -> 0x0a8b }
        if (r12 != 0) goto L_0x0735;
    L_0x06f1:
        r12 = r13.zzjhx;	 Catch:{ all -> 0x0a8b }
        r14 = r12.longValue();	 Catch:{ all -> 0x0a8b }
        r16 = 1;
        r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r12 <= 0) goto L_0x070c;
    L_0x06fd:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r12 = r11.zzjui;	 Catch:{ all -> 0x0a8b }
        r14 = "_sr";
        r15 = r13.zzjhx;	 Catch:{ all -> 0x0a8b }
        r12 = com.google.android.gms.internal.zzcno.zza(r12, r14, r15);	 Catch:{ all -> 0x0a8b }
        r11.zzjui = r12;	 Catch:{ all -> 0x0a8b }
    L_0x070c:
        r12 = r13.zzjhy;	 Catch:{ all -> 0x0a8b }
        if (r12 == 0) goto L_0x072e;
    L_0x0710:
        r12 = r13.zzjhy;	 Catch:{ all -> 0x0a8b }
        r12 = r12.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r12 == 0) goto L_0x072e;
    L_0x0718:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r12 = r11.zzjui;	 Catch:{ all -> 0x0a8b }
        r13 = "_efs";
        r40 = r7;
        r14 = 1;
        r7 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcno.zza(r12, r13, r7);	 Catch:{ all -> 0x0a8b }
        r11.zzjui = r7;	 Catch:{ all -> 0x0a8b }
        goto L_0x0730;
    L_0x072e:
        r40 = r7;
    L_0x0730:
        r7 = r10 + 1;
        r5[r10] = r11;	 Catch:{ all -> 0x0a8b }
        goto L_0x0777;
    L_0x0735:
        r40 = r7;
        r57 = r2;
        r58 = r3;
        r55 = r6;
        goto L_0x077e;
    L_0x073e:
        r40 = r7;
        r7 = "_dbg";
        r12 = 1;
        r14 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0a8b }
        r7 = zza(r11, r7, r14);	 Catch:{ all -> 0x0a8b }
        if (r7 != 0) goto L_0x075d;
    L_0x074e:
        r7 = r60.zzaym();	 Catch:{ all -> 0x0a8b }
        r12 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r12 = r12.zzcm;	 Catch:{ all -> 0x0a8b }
        r13 = r11.name;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzap(r12, r13);	 Catch:{ all -> 0x0a8b }
        goto L_0x075e;
    L_0x075d:
        r7 = 1;
    L_0x075e:
        if (r7 > 0) goto L_0x0787;
    L_0x0760:
        r12 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r12 = r12.zzbaw();	 Catch:{ all -> 0x0a8b }
        r13 = "Sample rate must be positive. event, rate";
        r14 = r11.name;	 Catch:{ all -> 0x0a8b }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0a8b }
        r12.zze(r13, r14, r7);	 Catch:{ all -> 0x0a8b }
        r7 = r10 + 1;
        r5[r10] = r11;	 Catch:{ all -> 0x0a8b }
    L_0x0777:
        r57 = r2;
        r58 = r3;
        r55 = r6;
        r10 = r7;
    L_0x077e:
        r56 = r8;
    L_0x0780:
        r59 = r9;
        r3 = 0;
        r8 = 1;
        goto L_0x08d6;
    L_0x0787:
        r12 = r11.name;	 Catch:{ all -> 0x0a8b }
        r12 = r4.get(r12);	 Catch:{ all -> 0x0a8b }
        r12 = (com.google.android.gms.internal.zzcit) r12;	 Catch:{ all -> 0x0a8b }
        if (r12 != 0) goto L_0x07d7;
    L_0x0791:
        r12 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r13 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r13 = r13.zzcm;	 Catch:{ all -> 0x0a8b }
        r14 = r11.name;	 Catch:{ all -> 0x0a8b }
        r12 = r12.zzae(r13, r14);	 Catch:{ all -> 0x0a8b }
        if (r12 != 0) goto L_0x07d7;
    L_0x07a1:
        r12 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r12 = r12.zzbaw();	 Catch:{ all -> 0x0a8b }
        r13 = "Event being bundled has no eventAggregate. appId, eventName";
        r14 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r14 = r14.zzcm;	 Catch:{ all -> 0x0a8b }
        r15 = r11.name;	 Catch:{ all -> 0x0a8b }
        r12.zze(r13, r14, r15);	 Catch:{ all -> 0x0a8b }
        r12 = new com.google.android.gms.internal.zzcit;	 Catch:{ all -> 0x0a8b }
        r13 = r2.zzjpe;	 Catch:{ all -> 0x0a8b }
        r13 = r13.zzcm;	 Catch:{ all -> 0x0a8b }
        r14 = r11.name;	 Catch:{ all -> 0x0a8b }
        r44 = 1;
        r46 = 1;
        r15 = r11.zzjuj;	 Catch:{ all -> 0x0a8b }
        r48 = r15.longValue();	 Catch:{ all -> 0x0a8b }
        r50 = 0;
        r52 = 0;
        r53 = 0;
        r54 = 0;
        r41 = r12;
        r42 = r13;
        r43 = r14;
        r41.<init>(r42, r43, r44, r46, r48, r50, r52, r53, r54);	 Catch:{ all -> 0x0a8b }
    L_0x07d7:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r13 = "_eid";
        r13 = com.google.android.gms.internal.zzcno.zzb(r11, r13);	 Catch:{ all -> 0x0a8b }
        r13 = (java.lang.Long) r13;	 Catch:{ all -> 0x0a8b }
        if (r13 == 0) goto L_0x07e6;
    L_0x07e4:
        r14 = 1;
        goto L_0x07e7;
    L_0x07e6:
        r14 = 0;
    L_0x07e7:
        r14 = java.lang.Boolean.valueOf(r14);	 Catch:{ all -> 0x0a8b }
        r15 = 1;
        if (r7 != r15) goto L_0x0810;
    L_0x07ee:
        r7 = r10 + 1;
        r5[r10] = r11;	 Catch:{ all -> 0x0a8b }
        r10 = r14.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r10 == 0) goto L_0x0777;
    L_0x07f8:
        r10 = r12.zzjhw;	 Catch:{ all -> 0x0a8b }
        if (r10 != 0) goto L_0x0804;
    L_0x07fc:
        r10 = r12.zzjhx;	 Catch:{ all -> 0x0a8b }
        if (r10 != 0) goto L_0x0804;
    L_0x0800:
        r10 = r12.zzjhy;	 Catch:{ all -> 0x0a8b }
        if (r10 == 0) goto L_0x0777;
    L_0x0804:
        r10 = 0;
        r12 = r12.zza(r10, r10, r10);	 Catch:{ all -> 0x0a8b }
        r10 = r11.name;	 Catch:{ all -> 0x0a8b }
        r4.put(r10, r12);	 Catch:{ all -> 0x0a8b }
        goto L_0x0777;
    L_0x0810:
        r15 = r6.nextInt(r7);	 Catch:{ all -> 0x0a8b }
        if (r15 != 0) goto L_0x0855;
    L_0x0816:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r13 = r11.zzjui;	 Catch:{ all -> 0x0a8b }
        r15 = "_sr";
        r55 = r6;
        r6 = (long) r7;	 Catch:{ all -> 0x0a8b }
        r56 = r8;
        r8 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r8 = com.google.android.gms.internal.zzcno.zza(r13, r15, r8);	 Catch:{ all -> 0x0a8b }
        r11.zzjui = r8;	 Catch:{ all -> 0x0a8b }
        r8 = r10 + 1;
        r5[r10] = r11;	 Catch:{ all -> 0x0a8b }
        r10 = r14.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r10 == 0) goto L_0x083f;
    L_0x0836:
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r7 = 0;
        r12 = r12.zza(r7, r6, r7);	 Catch:{ all -> 0x0a8b }
    L_0x083f:
        r6 = r11.name;	 Catch:{ all -> 0x0a8b }
        r7 = r11.zzjuj;	 Catch:{ all -> 0x0a8b }
        r10 = r7.longValue();	 Catch:{ all -> 0x0a8b }
        r7 = r12.zzbc(r10);	 Catch:{ all -> 0x0a8b }
        r4.put(r6, r7);	 Catch:{ all -> 0x0a8b }
        r57 = r2;
        r58 = r3;
        r10 = r8;
        goto L_0x0780;
    L_0x0855:
        r57 = r2;
        r58 = r3;
        r55 = r6;
        r56 = r8;
        r2 = r12.zzjhv;	 Catch:{ all -> 0x0a8b }
        r6 = r11.zzjuj;	 Catch:{ all -> 0x0a8b }
        r15 = r6.longValue();	 Catch:{ all -> 0x0a8b }
        r6 = 0;
        r59 = r9;
        r8 = r15 - r2;
        r2 = java.lang.Math.abs(r8);	 Catch:{ all -> 0x0a8b }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r6 < 0) goto L_0x08c4;
    L_0x0875:
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r2 = r11.zzjui;	 Catch:{ all -> 0x0a8b }
        r3 = "_efs";
        r8 = 1;
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0a8b }
        r2 = com.google.android.gms.internal.zzcno.zza(r2, r3, r6);	 Catch:{ all -> 0x0a8b }
        r11.zzjui = r2;	 Catch:{ all -> 0x0a8b }
        r60.zzayl();	 Catch:{ all -> 0x0a8b }
        r2 = r11.zzjui;	 Catch:{ all -> 0x0a8b }
        r3 = "_sr";
        r6 = (long) r7;	 Catch:{ all -> 0x0a8b }
        r13 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r2 = com.google.android.gms.internal.zzcno.zza(r2, r3, r13);	 Catch:{ all -> 0x0a8b }
        r11.zzjui = r2;	 Catch:{ all -> 0x0a8b }
        r2 = r10 + 1;
        r5[r10] = r11;	 Catch:{ all -> 0x0a8b }
        r3 = r14.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r3 == 0) goto L_0x08b2;
    L_0x08a4:
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r6 = 1;
        r7 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        r6 = 0;
        r12 = r12.zza(r6, r3, r7);	 Catch:{ all -> 0x0a8b }
    L_0x08b2:
        r3 = r11.name;	 Catch:{ all -> 0x0a8b }
        r6 = r11.zzjuj;	 Catch:{ all -> 0x0a8b }
        r6 = r6.longValue();	 Catch:{ all -> 0x0a8b }
        r6 = r12.zzbc(r6);	 Catch:{ all -> 0x0a8b }
        r4.put(r3, r6);	 Catch:{ all -> 0x0a8b }
        r10 = r2;
    L_0x08c2:
        r3 = 0;
        goto L_0x08d6;
    L_0x08c4:
        r8 = 1;
        r2 = r14.booleanValue();	 Catch:{ all -> 0x0a8b }
        if (r2 == 0) goto L_0x08c2;
    L_0x08cc:
        r2 = r11.name;	 Catch:{ all -> 0x0a8b }
        r3 = 0;
        r6 = r12.zza(r13, r3, r3);	 Catch:{ all -> 0x0a8b }
        r4.put(r2, r6);	 Catch:{ all -> 0x0a8b }
    L_0x08d6:
        r2 = r59 + 1;
        r9 = r2;
        r7 = r40;
        r6 = r55;
        r8 = r56;
        r2 = r57;
        r3 = r58;
        goto L_0x06bd;
    L_0x08e5:
        r57 = r2;
        r2 = r3;
        r3 = 0;
        r6 = r2.zzjuq;	 Catch:{ all -> 0x0a8b }
        r6 = r6.length;	 Catch:{ all -> 0x0a8b }
        if (r10 >= r6) goto L_0x08f6;
    L_0x08ee:
        r5 = java.util.Arrays.copyOf(r5, r10);	 Catch:{ all -> 0x0a8b }
        r5 = (com.google.android.gms.internal.zzcob[]) r5;	 Catch:{ all -> 0x0a8b }
        r2.zzjuq = r5;	 Catch:{ all -> 0x0a8b }
    L_0x08f6:
        r4 = r4.entrySet();	 Catch:{ all -> 0x0a8b }
        r4 = r4.iterator();	 Catch:{ all -> 0x0a8b }
    L_0x08fe:
        r5 = r4.hasNext();	 Catch:{ all -> 0x0a8b }
        if (r5 == 0) goto L_0x091c;
    L_0x0904:
        r5 = r4.next();	 Catch:{ all -> 0x0a8b }
        r5 = (java.util.Map.Entry) r5;	 Catch:{ all -> 0x0a8b }
        r6 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r5 = r5.getValue();	 Catch:{ all -> 0x0a8b }
        r5 = (com.google.android.gms.internal.zzcit) r5;	 Catch:{ all -> 0x0a8b }
        r6.zza(r5);	 Catch:{ all -> 0x0a8b }
        goto L_0x08fe;
    L_0x0918:
        r57 = r2;
        r2 = r3;
        r3 = 0;
    L_0x091c:
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0a8b }
        r2.zzjut = r4;	 Catch:{ all -> 0x0a8b }
        r4 = -9223372036854775808;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0a8b }
        r2.zzjuu = r4;	 Catch:{ all -> 0x0a8b }
        r4 = 0;
    L_0x0930:
        r5 = r2.zzjuq;	 Catch:{ all -> 0x0a8b }
        r5 = r5.length;	 Catch:{ all -> 0x0a8b }
        if (r4 >= r5) goto L_0x0964;
    L_0x0935:
        r5 = r2.zzjuq;	 Catch:{ all -> 0x0a8b }
        r5 = r5[r4];	 Catch:{ all -> 0x0a8b }
        r6 = r5.zzjuj;	 Catch:{ all -> 0x0a8b }
        r6 = r6.longValue();	 Catch:{ all -> 0x0a8b }
        r8 = r2.zzjut;	 Catch:{ all -> 0x0a8b }
        r8 = r8.longValue();	 Catch:{ all -> 0x0a8b }
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r10 >= 0) goto L_0x094d;
    L_0x0949:
        r6 = r5.zzjuj;	 Catch:{ all -> 0x0a8b }
        r2.zzjut = r6;	 Catch:{ all -> 0x0a8b }
    L_0x094d:
        r6 = r5.zzjuj;	 Catch:{ all -> 0x0a8b }
        r6 = r6.longValue();	 Catch:{ all -> 0x0a8b }
        r8 = r2.zzjuu;	 Catch:{ all -> 0x0a8b }
        r8 = r8.longValue();	 Catch:{ all -> 0x0a8b }
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r10 <= 0) goto L_0x0961;
    L_0x095d:
        r5 = r5.zzjuj;	 Catch:{ all -> 0x0a8b }
        r2.zzjuu = r5;	 Catch:{ all -> 0x0a8b }
    L_0x0961:
        r4 = r4 + 1;
        goto L_0x0930;
    L_0x0964:
        r4 = r57;
        r5 = r4.zzjpe;	 Catch:{ all -> 0x0a8b }
        r5 = r5.zzcm;	 Catch:{ all -> 0x0a8b }
        r6 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzjj(r5);	 Catch:{ all -> 0x0a8b }
        if (r6 != 0) goto L_0x098a;
    L_0x0974:
        r3 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r3 = r3.zzbau();	 Catch:{ all -> 0x0a8b }
        r6 = "Bundling raw events w/o app info. appId";
        r7 = r4.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
        r3.zzj(r6, r7);	 Catch:{ all -> 0x0a8b }
        goto L_0x09e4;
    L_0x098a:
        r7 = r2.zzjuq;	 Catch:{ all -> 0x0a8b }
        r7 = r7.length;	 Catch:{ all -> 0x0a8b }
        if (r7 <= 0) goto L_0x09e4;
    L_0x098f:
        r7 = r6.zzayw();	 Catch:{ all -> 0x0a8b }
        r9 = 0;
        r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r11 == 0) goto L_0x099e;
    L_0x0999:
        r9 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x0a8b }
        goto L_0x099f;
    L_0x099e:
        r9 = r3;
    L_0x099f:
        r2.zzjuw = r9;	 Catch:{ all -> 0x0a8b }
        r9 = r6.zzayv();	 Catch:{ all -> 0x0a8b }
        r11 = 0;
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 != 0) goto L_0x09ac;
    L_0x09ab:
        goto L_0x09ad;
    L_0x09ac:
        r7 = r9;
    L_0x09ad:
        r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r9 == 0) goto L_0x09b5;
    L_0x09b1:
        r3 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x0a8b }
    L_0x09b5:
        r2.zzjuv = r3;	 Catch:{ all -> 0x0a8b }
        r6.zzazf();	 Catch:{ all -> 0x0a8b }
        r7 = r6.zzazc();	 Catch:{ all -> 0x0a8b }
        r3 = (int) r7;	 Catch:{ all -> 0x0a8b }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0a8b }
        r2.zzjvf = r3;	 Catch:{ all -> 0x0a8b }
        r3 = r2.zzjut;	 Catch:{ all -> 0x0a8b }
        r7 = r3.longValue();	 Catch:{ all -> 0x0a8b }
        r6.zzal(r7);	 Catch:{ all -> 0x0a8b }
        r3 = r2.zzjuu;	 Catch:{ all -> 0x0a8b }
        r7 = r3.longValue();	 Catch:{ all -> 0x0a8b }
        r6.zzam(r7);	 Catch:{ all -> 0x0a8b }
        r3 = r6.zzazn();	 Catch:{ all -> 0x0a8b }
        r2.zzjgi = r3;	 Catch:{ all -> 0x0a8b }
        r3 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r3.zza(r6);	 Catch:{ all -> 0x0a8b }
    L_0x09e4:
        r3 = r2.zzjuq;	 Catch:{ all -> 0x0a8b }
        r3 = r3.length;	 Catch:{ all -> 0x0a8b }
        if (r3 <= 0) goto L_0x0a30;
    L_0x09e9:
        r3 = r60.zzaym();	 Catch:{ all -> 0x0a8b }
        r6 = r4.zzjpe;	 Catch:{ all -> 0x0a8b }
        r6 = r6.zzcm;	 Catch:{ all -> 0x0a8b }
        r3 = r3.zzka(r6);	 Catch:{ all -> 0x0a8b }
        if (r3 == 0) goto L_0x0a01;
    L_0x09f7:
        r6 = r3.zzjtx;	 Catch:{ all -> 0x0a8b }
        if (r6 != 0) goto L_0x09fc;
    L_0x09fb:
        goto L_0x0a01;
    L_0x09fc:
        r3 = r3.zzjtx;	 Catch:{ all -> 0x0a8b }
    L_0x09fe:
        r2.zzjvm = r3;	 Catch:{ all -> 0x0a8b }
        goto L_0x0a27;
    L_0x0a01:
        r3 = r4.zzjpe;	 Catch:{ all -> 0x0a8b }
        r3 = r3.zzjfl;	 Catch:{ all -> 0x0a8b }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0a8b }
        if (r3 == 0) goto L_0x0a12;
    L_0x0a0b:
        r6 = -1;
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x0a8b }
        goto L_0x09fe;
    L_0x0a12:
        r3 = r60.zzayp();	 Catch:{ all -> 0x0a8b }
        r3 = r3.zzbaw();	 Catch:{ all -> 0x0a8b }
        r6 = "Did not find measurement config or missing version info. appId";
        r7 = r4.zzjpe;	 Catch:{ all -> 0x0a8b }
        r7 = r7.zzcm;	 Catch:{ all -> 0x0a8b }
        r7 = com.google.android.gms.internal.zzcjj.zzjs(r7);	 Catch:{ all -> 0x0a8b }
        r3.zzj(r6, r7);	 Catch:{ all -> 0x0a8b }
    L_0x0a27:
        r3 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r10 = r27;
        r3.zza(r2, r10);	 Catch:{ all -> 0x0a8b }
    L_0x0a30:
        r2 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r3 = r4.zzjpf;	 Catch:{ all -> 0x0a8b }
        r2.zzai(r3);	 Catch:{ all -> 0x0a8b }
        r2 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r3 = r2.getWritableDatabase();	 Catch:{ all -> 0x0a8b }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0a50 }
        r7 = 0;
        r6[r7] = r5;	 Catch:{ SQLiteException -> 0x0a50 }
        r7 = 1;
        r6[r7] = r5;	 Catch:{ SQLiteException -> 0x0a50 }
        r3.execSQL(r4, r6);	 Catch:{ SQLiteException -> 0x0a50 }
        goto L_0x0a63;
    L_0x0a50:
        r0 = move-exception;
        r3 = r0;
        r2 = r2.zzayp();	 Catch:{ all -> 0x0a8b }
        r2 = r2.zzbau();	 Catch:{ all -> 0x0a8b }
        r4 = "Failed to remove unused event metadata. appId";
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r5);	 Catch:{ all -> 0x0a8b }
        r2.zze(r4, r5, r3);	 Catch:{ all -> 0x0a8b }
    L_0x0a63:
        r2 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x0a8b }
        r2 = r60.zzayj();
        r2.endTransaction();
        r2 = 1;
        return r2;
    L_0x0a73:
        r2 = r60.zzayj();	 Catch:{ all -> 0x0a8b }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x0a8b }
        r2 = r60.zzayj();
        r2.endTransaction();
        r2 = 0;
        return r2;
    L_0x0a83:
        r0 = move-exception;
    L_0x0a84:
        r2 = r0;
    L_0x0a85:
        if (r9 == 0) goto L_0x0a8a;
    L_0x0a87:
        r9.close();	 Catch:{ all -> 0x0a8b }
    L_0x0a8a:
        throw r2;	 Catch:{ all -> 0x0a8b }
    L_0x0a8b:
        r0 = move-exception;
        r2 = r0;
        r3 = r60.zzayj();
        r3.endTransaction();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzg(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final zzcif zzke(String str) {
        zzcjl zzbaz;
        String str2;
        Object zzjs;
        String zzjs2 = str;
        zzcie zzjj = zzayj().zzjj(zzjs2);
        if (zzjj == null || TextUtils.isEmpty(zzjj.zzwo())) {
            zzbaz = zzayp().zzbaz();
            str2 = "No app data available; dropping";
        } else {
            Boolean zzc = zzc(zzjj);
            if (zzc == null || zzc.booleanValue()) {
                return new zzcif(zzjs2, zzjj.getGmpAppId(), zzjj.zzwo(), zzjj.zzayx(), zzjj.zzayy(), zzjj.zzayz(), zzjj.zzaza(), null, zzjj.zzazb(), false, zzjj.zzayu(), zzjj.zzazo(), 0, 0, zzjj.zzazp());
            }
            zzbaz = zzayp().zzbau();
            str2 = "App version does not match; dropping. appId";
            zzjs2 = zzcjj.zzjs(str);
        }
        zzbaz.zzj(str2, zzjs2);
        return null;
    }

    public final Context getContext() {
        return this.zzaiq;
    }

    @WorkerThread
    public final boolean isEnabled() {
        zzayo().zzwj();
        zzyk();
        boolean z = false;
        if (this.zzjns.zzazr()) {
            return false;
        }
        Boolean zzjf = this.zzjns.zzjf("firebase_analytics_collection_enabled");
        if (zzjf != null) {
            z = zzjf.booleanValue();
        } else if (!zzbz.zzakr()) {
            z = true;
        }
        return zzayq().zzbs(z);
    }

    @WorkerThread
    protected final void start() {
        zzayo().zzwj();
        zzayj().zzazy();
        if (zzayq().zzjln.get() == 0) {
            zzayq().zzjln.set(this.zzdir.currentTimeMillis());
        }
        if (Long.valueOf(zzayq().zzjls.get()).longValue() == 0) {
            zzayp().zzbba().zzj("Persisting first open", Long.valueOf(this.zzjgk));
            zzayq().zzjls.set(this.zzjgk);
        }
        if (zzbbn()) {
            if (!TextUtils.isEmpty(zzaye().getGmpAppId())) {
                String zzbbe = zzayq().zzbbe();
                if (zzbbe == null) {
                    zzayq().zzjw(zzaye().getGmpAppId());
                } else if (!zzbbe.equals(zzaye().getGmpAppId())) {
                    zzayp().zzbay().log("Rechecking which service to use due to a GMP App Id change");
                    zzayq().zzbbh();
                    this.zzjoi.disconnect();
                    this.zzjoi.zzzh();
                    zzayq().zzjw(zzaye().getGmpAppId());
                    zzayq().zzjls.set(this.zzjgk);
                    zzayq().zzjlt.zzjy(null);
                }
            }
            zzayd().zzjx(zzayq().zzjlt.zzbbj());
            if (!TextUtils.isEmpty(zzaye().getGmpAppId())) {
                zzclh zzayd = zzayd();
                zzayd.zzwj();
                zzayd.zzyk();
                if (zzayd.zzjev.zzbbn()) {
                    zzayd.zzayg().zzbcj();
                    String zzbbi = zzayd.zzayq().zzbbi();
                    if (!TextUtils.isEmpty(zzbbi)) {
                        zzayd.zzayf().zzyk();
                        if (!zzbbi.equals(VERSION.RELEASE)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_po", zzbbi);
                            zzayd.zzd("auto", "_ou", bundle);
                        }
                    }
                }
                zzayg().zza(new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!zzayl().zzeh("android.permission.INTERNET")) {
                zzayp().zzbau().log("App is missing INTERNET permission");
            }
            if (!zzayl().zzeh("android.permission.ACCESS_NETWORK_STATE")) {
                zzayp().zzbau().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!zzbih.zzdd(this.zzaiq).zzaoe()) {
                if (!zzcka.zzbj(this.zzaiq)) {
                    zzayp().zzbau().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzcmy.zzg(this.zzaiq, false)) {
                    zzayp().zzbau().log("AppMeasurementService not registered/enabled");
                }
            }
            zzayp().zzbau().log("Uploading is not possible. App measurement disabled");
        }
        zzbca();
    }

    @WorkerThread
    protected final void zza(int i, Throwable th, byte[] bArr) {
        zzayo().zzwj();
        zzyk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjpa = false;
                zzbce();
            }
        }
        List<Long> list = this.zzjot;
        this.zzjot = null;
        int i2 = 1;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzayq().zzjln.set(this.zzdir.currentTimeMillis());
                zzayq().zzjlo.set(0);
                zzbca();
                zzayp().zzbba().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzayj().beginTransaction();
                zzclh zzayj;
                try {
                    for (Long l : list) {
                        zzayj = zzayj();
                        long longValue = l.longValue();
                        zzayj.zzwj();
                        zzayj.zzyk();
                        if (zzayj.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    }
                    zzayj().setTransactionSuccessful();
                    zzayj().endTransaction();
                    if (zzbbs().zzaax() && zzbbz()) {
                        zzbby();
                    } else {
                        this.zzjox = -1;
                        zzbca();
                    }
                    this.zzjoy = 0;
                } catch (SQLiteException e) {
                    zzayj.zzayp().zzbau().zzj("Failed to delete a bundle in a queue table", e);
                    throw e;
                } catch (Throwable th3) {
                    zzayj().endTransaction();
                }
            } catch (SQLiteException e2) {
                zzayp().zzbau().zzj("Database error while trying to delete uploaded bundles", e2);
                this.zzjoy = this.zzdir.elapsedRealtime();
                zzayp().zzbba().zzj("Disable upload, time", Long.valueOf(this.zzjoy));
            }
        } else {
            zzayp().zzbba().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzayq().zzjlo.set(this.zzdir.currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                i2 = 0;
            }
            if (i2 != 0) {
                zzayq().zzjlp.set(this.zzdir.currentTimeMillis());
            }
            zzbca();
        }
        this.zzjpa = false;
        zzbce();
    }

    /* JADX WARNING: Missing block: B:22:0x0072, code:
            if (com.google.firebase.analytics.FirebaseAnalytics.a.ECOMMERCE_PURCHASE.equals(r1.name) != false) goto L_0x0074;
     */
    @android.support.annotation.WorkerThread
    public final byte[] zza(@android.support.annotation.NonNull com.google.android.gms.internal.zzcix r33, @android.support.annotation.Size(min = 1) java.lang.String r34) {
        /*
        r32 = this;
        r11 = r32;
        r1 = r33;
        r10 = r34;
        r32.zzyk();
        r2 = r32.zzayo();
        r2.zzwj();
        zzaxz();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r33);
        com.google.android.gms.common.internal.zzbq.zzgv(r34);
        r8 = new com.google.android.gms.internal.zzcod;
        r8.<init>();
        r2 = r32.zzayj();
        r2.beginTransaction();
        r2 = r32.zzayj();	 Catch:{ all -> 0x04bd }
        r9 = r2.zzjj(r10);	 Catch:{ all -> 0x04bd }
        r6 = 0;
        if (r9 != 0) goto L_0x004c;
    L_0x0030:
        r1 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r1 = r1.zzbaz();	 Catch:{ all -> 0x0047 }
        r2 = "Log and bundle not available. package_name";
        r1.zzj(r2, r10);	 Catch:{ all -> 0x0047 }
    L_0x003d:
        r1 = new byte[r6];	 Catch:{ all -> 0x0047 }
        r2 = r32.zzayj();
        r2.endTransaction();
        return r1;
    L_0x0047:
        r0 = move-exception;
        r1 = r0;
        r5 = r11;
        goto L_0x04c0;
    L_0x004c:
        r2 = r9.zzazb();	 Catch:{ all -> 0x04bd }
        if (r2 != 0) goto L_0x0060;
    L_0x0052:
        r1 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r1 = r1.zzbaz();	 Catch:{ all -> 0x0047 }
        r2 = "Log and bundle disabled. package_name";
        r1.zzj(r2, r10);	 Catch:{ all -> 0x0047 }
        goto L_0x003d;
    L_0x0060:
        r2 = "_iap";
        r3 = r1.name;	 Catch:{ all -> 0x04bd }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x04bd }
        if (r2 != 0) goto L_0x0074;
    L_0x006a:
        r2 = "ecommerce_purchase";
        r3 = r1.name;	 Catch:{ all -> 0x0047 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x008b;
    L_0x0074:
        r2 = r11.zza(r10, r1);	 Catch:{ all -> 0x04bd }
        if (r2 != 0) goto L_0x008b;
    L_0x007a:
        r2 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r2 = r2.zzbaw();	 Catch:{ all -> 0x0047 }
        r3 = "Failed to handle purchase event at single event bundle creation. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r34);	 Catch:{ all -> 0x0047 }
        r2.zzj(r3, r4);	 Catch:{ all -> 0x0047 }
    L_0x008b:
        r2 = r11.zzjns;	 Catch:{ all -> 0x04bd }
        r2 = r2.zzjh(r10);	 Catch:{ all -> 0x04bd }
        r4 = 0;
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x04bd }
        if (r2 == 0) goto L_0x00e4;
    L_0x0099:
        r7 = "_e";
        r12 = r1.name;	 Catch:{ all -> 0x0047 }
        r7 = r7.equals(r12);	 Catch:{ all -> 0x0047 }
        if (r7 == 0) goto L_0x00e4;
    L_0x00a3:
        r7 = r1.zzjhr;	 Catch:{ all -> 0x0047 }
        if (r7 == 0) goto L_0x00d5;
    L_0x00a7:
        r7 = r1.zzjhr;	 Catch:{ all -> 0x0047 }
        r7 = r7.size();	 Catch:{ all -> 0x0047 }
        if (r7 != 0) goto L_0x00b0;
    L_0x00af:
        goto L_0x00d5;
    L_0x00b0:
        r7 = r1.zzjhr;	 Catch:{ all -> 0x0047 }
        r12 = "_et";
        r7 = r7.getLong(r12);	 Catch:{ all -> 0x0047 }
        if (r7 != 0) goto L_0x00cc;
    L_0x00ba:
        r7 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r7 = r7.zzbaw();	 Catch:{ all -> 0x0047 }
        r12 = "The engagement event does not include duration. appId";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r34);	 Catch:{ all -> 0x0047 }
    L_0x00c8:
        r7.zzj(r12, r13);	 Catch:{ all -> 0x0047 }
        goto L_0x00e4;
    L_0x00cc:
        r3 = r1.zzjhr;	 Catch:{ all -> 0x0047 }
        r7 = "_et";
        r3 = r3.getLong(r7);	 Catch:{ all -> 0x0047 }
        goto L_0x00e4;
    L_0x00d5:
        r7 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r7 = r7.zzbaw();	 Catch:{ all -> 0x0047 }
        r12 = "The engagement event does not contain any parameters. appId";
        r13 = com.google.android.gms.internal.zzcjj.zzjs(r34);	 Catch:{ all -> 0x0047 }
        goto L_0x00c8;
    L_0x00e4:
        r7 = new com.google.android.gms.internal.zzcoe;	 Catch:{ all -> 0x04bd }
        r7.<init>();	 Catch:{ all -> 0x04bd }
        r13 = 1;
        r12 = new com.google.android.gms.internal.zzcoe[r13];	 Catch:{ all -> 0x04bd }
        r12[r6] = r7;	 Catch:{ all -> 0x04bd }
        r8.zzjun = r12;	 Catch:{ all -> 0x04bd }
        r12 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x04bd }
        r7.zzjup = r12;	 Catch:{ all -> 0x04bd }
        r12 = "android";
        r7.zzjux = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.getAppId();	 Catch:{ all -> 0x04bd }
        r7.zzcm = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.zzayy();	 Catch:{ all -> 0x04bd }
        r7.zzjfs = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.zzwo();	 Catch:{ all -> 0x04bd }
        r7.zzina = r12;	 Catch:{ all -> 0x04bd }
        r14 = r9.zzayx();	 Catch:{ all -> 0x04bd }
        r16 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        r13 = 0;
        if (r12 != 0) goto L_0x011a;
    L_0x0118:
        r12 = r13;
        goto L_0x011f;
    L_0x011a:
        r12 = (int) r14;	 Catch:{ all -> 0x04bd }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x04bd }
    L_0x011f:
        r7.zzjvi = r12;	 Catch:{ all -> 0x04bd }
        r14 = r9.zzayz();	 Catch:{ all -> 0x04bd }
        r12 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x04bd }
        r7.zzjva = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.getGmpAppId();	 Catch:{ all -> 0x04bd }
        r7.zzjfl = r12;	 Catch:{ all -> 0x04bd }
        r14 = r9.zzaza();	 Catch:{ all -> 0x04bd }
        r12 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x04bd }
        r7.zzjve = r12;	 Catch:{ all -> 0x04bd }
        r12 = r32.isEnabled();	 Catch:{ all -> 0x04bd }
        if (r12 == 0) goto L_0x0153;
    L_0x0141:
        r12 = com.google.android.gms.internal.zzcik.zzazv();	 Catch:{ all -> 0x0047 }
        if (r12 == 0) goto L_0x0153;
    L_0x0147:
        r12 = r11.zzjns;	 Catch:{ all -> 0x0047 }
        r14 = r7.zzcm;	 Catch:{ all -> 0x0047 }
        r12 = r12.zzjg(r14);	 Catch:{ all -> 0x0047 }
        if (r12 == 0) goto L_0x0153;
    L_0x0151:
        r7.zzjvn = r13;	 Catch:{ all -> 0x0047 }
    L_0x0153:
        r12 = r32.zzayq();	 Catch:{ all -> 0x04bd }
        r14 = r9.getAppId();	 Catch:{ all -> 0x04bd }
        r12 = r12.zzju(r14);	 Catch:{ all -> 0x04bd }
        r14 = r9.zzazp();	 Catch:{ all -> 0x04bd }
        if (r14 == 0) goto L_0x017d;
    L_0x0165:
        if (r12 == 0) goto L_0x017d;
    L_0x0167:
        r14 = r12.first;	 Catch:{ all -> 0x0047 }
        r14 = (java.lang.CharSequence) r14;	 Catch:{ all -> 0x0047 }
        r14 = android.text.TextUtils.isEmpty(r14);	 Catch:{ all -> 0x0047 }
        if (r14 != 0) goto L_0x017d;
    L_0x0171:
        r14 = r12.first;	 Catch:{ all -> 0x0047 }
        r14 = (java.lang.String) r14;	 Catch:{ all -> 0x0047 }
        r7.zzjvc = r14;	 Catch:{ all -> 0x0047 }
        r12 = r12.second;	 Catch:{ all -> 0x0047 }
        r12 = (java.lang.Boolean) r12;	 Catch:{ all -> 0x0047 }
        r7.zzjvd = r12;	 Catch:{ all -> 0x0047 }
    L_0x017d:
        r12 = r32.zzayf();	 Catch:{ all -> 0x04bd }
        r12.zzyk();	 Catch:{ all -> 0x04bd }
        r12 = android.os.Build.MODEL;	 Catch:{ all -> 0x04bd }
        r7.zzjuy = r12;	 Catch:{ all -> 0x04bd }
        r12 = r32.zzayf();	 Catch:{ all -> 0x04bd }
        r12.zzyk();	 Catch:{ all -> 0x04bd }
        r12 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x04bd }
        r7.zzda = r12;	 Catch:{ all -> 0x04bd }
        r12 = r32.zzayf();	 Catch:{ all -> 0x04bd }
        r14 = r12.zzbal();	 Catch:{ all -> 0x04bd }
        r12 = (int) r14;	 Catch:{ all -> 0x04bd }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x04bd }
        r7.zzjuz = r12;	 Catch:{ all -> 0x04bd }
        r12 = r32.zzayf();	 Catch:{ all -> 0x04bd }
        r12 = r12.zzbam();	 Catch:{ all -> 0x04bd }
        r7.zzjho = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.getAppInstanceId();	 Catch:{ all -> 0x04bd }
        r7.zzjfk = r12;	 Catch:{ all -> 0x04bd }
        r12 = r9.zzayu();	 Catch:{ all -> 0x04bd }
        r7.zzjfn = r12;	 Catch:{ all -> 0x04bd }
        r12 = r32.zzayj();	 Catch:{ all -> 0x04bd }
        r14 = r9.getAppId();	 Catch:{ all -> 0x04bd }
        r12 = r12.zzji(r14);	 Catch:{ all -> 0x04bd }
        r14 = r12.size();	 Catch:{ all -> 0x04bd }
        r14 = new com.google.android.gms.internal.zzcog[r14];	 Catch:{ all -> 0x04bd }
        r7.zzjur = r14;	 Catch:{ all -> 0x04bd }
        if (r2 == 0) goto L_0x022a;
    L_0x01ce:
        r14 = r32.zzayj();	 Catch:{ all -> 0x0047 }
        r15 = r7.zzcm;	 Catch:{ all -> 0x0047 }
        r6 = "_lte";
        r6 = r14.zzag(r15, r6);	 Catch:{ all -> 0x0047 }
        if (r6 == 0) goto L_0x0214;
    L_0x01dc:
        r14 = r6.value;	 Catch:{ all -> 0x0047 }
        if (r14 != 0) goto L_0x01e1;
    L_0x01e0:
        goto L_0x0214;
    L_0x01e1:
        r14 = r3.longValue();	 Catch:{ all -> 0x0047 }
        r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1));
        if (r16 <= 0) goto L_0x0212;
    L_0x01e9:
        r14 = new com.google.android.gms.internal.zzcnn;	 Catch:{ all -> 0x0047 }
        r15 = r7.zzcm;	 Catch:{ all -> 0x0047 }
        r19 = "auto";
        r20 = "_lte";
        r13 = r11.zzdir;	 Catch:{ all -> 0x0047 }
        r21 = r13.currentTimeMillis();	 Catch:{ all -> 0x0047 }
        r6 = r6.value;	 Catch:{ all -> 0x0047 }
        r6 = (java.lang.Long) r6;	 Catch:{ all -> 0x0047 }
        r16 = r6.longValue();	 Catch:{ all -> 0x0047 }
        r23 = r3.longValue();	 Catch:{ all -> 0x0047 }
        r6 = 0;
        r4 = r16 + r23;
        r23 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0047 }
        r17 = r14;
        r18 = r15;
        r17.<init>(r18, r19, r20, r21, r23);	 Catch:{ all -> 0x0047 }
        goto L_0x022b;
    L_0x0212:
        r14 = r6;
        goto L_0x022b;
    L_0x0214:
        r4 = new com.google.android.gms.internal.zzcnn;	 Catch:{ all -> 0x0047 }
        r15 = r7.zzcm;	 Catch:{ all -> 0x0047 }
        r16 = "auto";
        r17 = "_lte";
        r5 = r11.zzdir;	 Catch:{ all -> 0x0047 }
        r18 = r5.currentTimeMillis();	 Catch:{ all -> 0x0047 }
        r14 = r4;
        r20 = r3;
        r14.<init>(r15, r16, r17, r18, r20);	 Catch:{ all -> 0x0047 }
        r14 = r4;
        goto L_0x022b;
    L_0x022a:
        r14 = 0;
    L_0x022b:
        r4 = 0;
        r5 = 0;
    L_0x022d:
        r6 = r12.size();	 Catch:{ all -> 0x04bd }
        if (r4 >= r6) goto L_0x028d;
    L_0x0233:
        r6 = new com.google.android.gms.internal.zzcog;	 Catch:{ all -> 0x0047 }
        r6.<init>();	 Catch:{ all -> 0x0047 }
        r13 = r7.zzjur;	 Catch:{ all -> 0x0047 }
        r13[r4] = r6;	 Catch:{ all -> 0x0047 }
        r13 = r12.get(r4);	 Catch:{ all -> 0x0047 }
        r13 = (com.google.android.gms.internal.zzcnn) r13;	 Catch:{ all -> 0x0047 }
        r13 = r13.name;	 Catch:{ all -> 0x0047 }
        r6.name = r13;	 Catch:{ all -> 0x0047 }
        r13 = r12.get(r4);	 Catch:{ all -> 0x0047 }
        r13 = (com.google.android.gms.internal.zzcnn) r13;	 Catch:{ all -> 0x0047 }
        r27 = r8;
        r28 = r9;
        r8 = r13.zzjsi;	 Catch:{ all -> 0x0047 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0047 }
        r6.zzjvr = r8;	 Catch:{ all -> 0x0047 }
        r8 = r32.zzayl();	 Catch:{ all -> 0x0047 }
        r9 = r12.get(r4);	 Catch:{ all -> 0x0047 }
        r9 = (com.google.android.gms.internal.zzcnn) r9;	 Catch:{ all -> 0x0047 }
        r9 = r9.value;	 Catch:{ all -> 0x0047 }
        r8.zza(r6, r9);	 Catch:{ all -> 0x0047 }
        if (r2 == 0) goto L_0x0286;
    L_0x0269:
        r8 = "_lte";
        r9 = r6.name;	 Catch:{ all -> 0x0047 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x0047 }
        if (r8 == 0) goto L_0x0286;
    L_0x0273:
        r5 = r14.value;	 Catch:{ all -> 0x0047 }
        r5 = (java.lang.Long) r5;	 Catch:{ all -> 0x0047 }
        r6.zzjum = r5;	 Catch:{ all -> 0x0047 }
        r5 = r11.zzdir;	 Catch:{ all -> 0x0047 }
        r8 = r5.currentTimeMillis();	 Catch:{ all -> 0x0047 }
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0047 }
        r6.zzjvr = r5;	 Catch:{ all -> 0x0047 }
        r5 = r6;
    L_0x0286:
        r4 = r4 + 1;
        r8 = r27;
        r9 = r28;
        goto L_0x022d;
    L_0x028d:
        r27 = r8;
        r28 = r9;
        if (r2 == 0) goto L_0x02c9;
    L_0x0293:
        if (r5 != 0) goto L_0x02c9;
    L_0x0295:
        r2 = new com.google.android.gms.internal.zzcog;	 Catch:{ all -> 0x0047 }
        r2.<init>();	 Catch:{ all -> 0x0047 }
        r4 = "_lte";
        r2.name = r4;	 Catch:{ all -> 0x0047 }
        r4 = r11.zzdir;	 Catch:{ all -> 0x0047 }
        r4 = r4.currentTimeMillis();	 Catch:{ all -> 0x0047 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0047 }
        r2.zzjvr = r4;	 Catch:{ all -> 0x0047 }
        r4 = r14.value;	 Catch:{ all -> 0x0047 }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x0047 }
        r2.zzjum = r4;	 Catch:{ all -> 0x0047 }
        r4 = r7.zzjur;	 Catch:{ all -> 0x0047 }
        r5 = r7.zzjur;	 Catch:{ all -> 0x0047 }
        r5 = r5.length;	 Catch:{ all -> 0x0047 }
        r6 = 1;
        r5 = r5 + r6;
        r4 = java.util.Arrays.copyOf(r4, r5);	 Catch:{ all -> 0x0047 }
        r4 = (com.google.android.gms.internal.zzcog[]) r4;	 Catch:{ all -> 0x0047 }
        r7.zzjur = r4;	 Catch:{ all -> 0x0047 }
        r4 = r7.zzjur;	 Catch:{ all -> 0x0047 }
        r5 = r7.zzjur;	 Catch:{ all -> 0x0047 }
        r5 = r5.length;	 Catch:{ all -> 0x0047 }
        r6 = 1;
        r5 = r5 - r6;
        r4[r5] = r2;	 Catch:{ all -> 0x0047 }
        goto L_0x02ca;
    L_0x02c9:
        r6 = 1;
    L_0x02ca:
        r2 = r3.longValue();	 Catch:{ all -> 0x04bd }
        r4 = 0;
        r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r8 <= 0) goto L_0x02db;
    L_0x02d4:
        r2 = r32.zzayj();	 Catch:{ all -> 0x0047 }
        r2.zza(r14);	 Catch:{ all -> 0x0047 }
    L_0x02db:
        r2 = r1.zzjhr;	 Catch:{ all -> 0x04bd }
        r8 = r2.zzbao();	 Catch:{ all -> 0x04bd }
        r2 = "_iap";
        r3 = r1.name;	 Catch:{ all -> 0x04bd }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x04bd }
        r12 = 1;
        if (r2 == 0) goto L_0x0304;
    L_0x02ed:
        r2 = "_c";
        r8.putLong(r2, r12);	 Catch:{ all -> 0x0047 }
        r2 = r32.zzayp();	 Catch:{ all -> 0x0047 }
        r2 = r2.zzbaz();	 Catch:{ all -> 0x0047 }
        r3 = "Marking in-app purchase as real-time";
        r2.log(r3);	 Catch:{ all -> 0x0047 }
        r2 = "_r";
        r8.putLong(r2, r12);	 Catch:{ all -> 0x0047 }
    L_0x0304:
        r2 = "_o";
        r3 = r1.zzjgm;	 Catch:{ all -> 0x04bd }
        r8.putString(r2, r3);	 Catch:{ all -> 0x04bd }
        r2 = r32.zzayl();	 Catch:{ all -> 0x04bd }
        r3 = r7.zzcm;	 Catch:{ all -> 0x04bd }
        r2 = r2.zzkq(r3);	 Catch:{ all -> 0x04bd }
        if (r2 == 0) goto L_0x0331;
    L_0x0317:
        r2 = r32.zzayl();	 Catch:{ all -> 0x0047 }
        r3 = "_dbg";
        r9 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0047 }
        r2.zza(r8, r3, r9);	 Catch:{ all -> 0x0047 }
        r2 = r32.zzayl();	 Catch:{ all -> 0x0047 }
        r3 = "_r";
        r9 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0047 }
        r2.zza(r8, r3, r9);	 Catch:{ all -> 0x0047 }
    L_0x0331:
        r2 = r32.zzayj();	 Catch:{ all -> 0x04bd }
        r3 = r1.name;	 Catch:{ all -> 0x04bd }
        r2 = r2.zzae(r10, r3);	 Catch:{ all -> 0x04bd }
        if (r2 != 0) goto L_0x0362;
    L_0x033d:
        r2 = new com.google.android.gms.internal.zzcit;	 Catch:{ all -> 0x0047 }
        r14 = r1.name;	 Catch:{ all -> 0x0047 }
        r15 = 1;
        r17 = 0;
        r12 = r1.zzjib;	 Catch:{ all -> 0x0047 }
        r21 = 0;
        r23 = 0;
        r24 = 0;
        r25 = 0;
        r19 = r12;
        r12 = r2;
        r9 = 1;
        r26 = 0;
        r13 = r10;
        r12.<init>(r13, r14, r15, r17, r19, r21, r23, r24, r25);	 Catch:{ all -> 0x0047 }
        r3 = r32.zzayj();	 Catch:{ all -> 0x0047 }
        r3.zza(r2);	 Catch:{ all -> 0x0047 }
        r12 = r4;
        goto L_0x0378;
    L_0x0362:
        r9 = 1;
        r26 = 0;
        r12 = r2.zzjhu;	 Catch:{ all -> 0x04bd }
        r14 = r1.zzjib;	 Catch:{ all -> 0x04bd }
        r2 = r2.zzbb(r14);	 Catch:{ all -> 0x04bd }
        r2 = r2.zzban();	 Catch:{ all -> 0x04bd }
        r3 = r32.zzayj();	 Catch:{ all -> 0x04bd }
        r3.zza(r2);	 Catch:{ all -> 0x04bd }
    L_0x0378:
        r14 = new com.google.android.gms.internal.zzcis;	 Catch:{ all -> 0x04bd }
        r3 = r1.zzjgm;	 Catch:{ all -> 0x04bd }
        r6 = r1.name;	 Catch:{ all -> 0x04bd }
        r1 = r1.zzjib;	 Catch:{ all -> 0x04bd }
        r15 = r1;
        r1 = r14;
        r2 = r11;
        r17 = r4;
        r4 = r10;
        r5 = r6;
        r11 = r7;
        r29 = r14;
        r14 = 0;
        r6 = r15;
        r16 = r8;
        r15 = r27;
        r30 = r28;
        r14 = 1;
        r8 = r12;
        r10 = r16;
        r1.<init>(r2, r3, r4, r5, r6, r8, r10);	 Catch:{ all -> 0x04b9 }
        r1 = new com.google.android.gms.internal.zzcob;	 Catch:{ all -> 0x04b9 }
        r1.<init>();	 Catch:{ all -> 0x04b9 }
        r2 = new com.google.android.gms.internal.zzcob[r14];	 Catch:{ all -> 0x04b9 }
        r3 = 0;
        r2[r3] = r1;	 Catch:{ all -> 0x04b9 }
        r11.zzjuq = r2;	 Catch:{ all -> 0x04b9 }
        r2 = r29;
        r3 = r2.timestamp;	 Catch:{ all -> 0x04b9 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b9 }
        r1.zzjuj = r3;	 Catch:{ all -> 0x04b9 }
        r3 = r2.name;	 Catch:{ all -> 0x04b9 }
        r1.name = r3;	 Catch:{ all -> 0x04b9 }
        r3 = r2.zzjhq;	 Catch:{ all -> 0x04b9 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b9 }
        r1.zzjuk = r3;	 Catch:{ all -> 0x04b9 }
        r3 = r2.zzjhr;	 Catch:{ all -> 0x04b9 }
        r3 = r3.size();	 Catch:{ all -> 0x04b9 }
        r3 = new com.google.android.gms.internal.zzcoc[r3];	 Catch:{ all -> 0x04b9 }
        r1.zzjui = r3;	 Catch:{ all -> 0x04b9 }
        r3 = r2.zzjhr;	 Catch:{ all -> 0x04b9 }
        r3 = r3.iterator();	 Catch:{ all -> 0x04b9 }
        r4 = 0;
    L_0x03cc:
        r5 = r3.hasNext();	 Catch:{ all -> 0x04b9 }
        if (r5 == 0) goto L_0x03f8;
    L_0x03d2:
        r5 = r3.next();	 Catch:{ all -> 0x04b9 }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x04b9 }
        r6 = new com.google.android.gms.internal.zzcoc;	 Catch:{ all -> 0x04b9 }
        r6.<init>();	 Catch:{ all -> 0x04b9 }
        r7 = r1.zzjui;	 Catch:{ all -> 0x04b9 }
        r8 = r4 + 1;
        r7[r4] = r6;	 Catch:{ all -> 0x04b9 }
        r6.name = r5;	 Catch:{ all -> 0x04b9 }
        r4 = r2.zzjhr;	 Catch:{ all -> 0x04b9 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x04b9 }
        r7 = r11;
        r5 = r32;
        r9 = r32.zzayl();	 Catch:{ all -> 0x04b7 }
        r9.zza(r6, r4);	 Catch:{ all -> 0x04b7 }
        r11 = r7;
        r4 = r8;
        goto L_0x03cc;
    L_0x03f8:
        r7 = r11;
        r2 = r30;
        r5 = r32;
        r3 = r2.getAppId();	 Catch:{ all -> 0x04b7 }
        r4 = r7.zzjur;	 Catch:{ all -> 0x04b7 }
        r6 = r7.zzjuq;	 Catch:{ all -> 0x04b7 }
        r3 = r5.zza(r3, r4, r6);	 Catch:{ all -> 0x04b7 }
        r7.zzjvh = r3;	 Catch:{ all -> 0x04b7 }
        r3 = r1.zzjuj;	 Catch:{ all -> 0x04b7 }
        r7.zzjut = r3;	 Catch:{ all -> 0x04b7 }
        r1 = r1.zzjuj;	 Catch:{ all -> 0x04b7 }
        r7.zzjuu = r1;	 Catch:{ all -> 0x04b7 }
        r3 = r2.zzayw();	 Catch:{ all -> 0x04b7 }
        r1 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1));
        if (r1 == 0) goto L_0x0420;
    L_0x041b:
        r13 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b7 }
        goto L_0x0422;
    L_0x0420:
        r13 = r26;
    L_0x0422:
        r7.zzjuw = r13;	 Catch:{ all -> 0x04b7 }
        r8 = r2.zzayv();	 Catch:{ all -> 0x04b7 }
        r1 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1));
        if (r1 != 0) goto L_0x042d;
    L_0x042c:
        goto L_0x042e;
    L_0x042d:
        r3 = r8;
    L_0x042e:
        r1 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1));
        if (r1 == 0) goto L_0x0437;
    L_0x0432:
        r13 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b7 }
        goto L_0x0439;
    L_0x0437:
        r13 = r26;
    L_0x0439:
        r7.zzjuv = r13;	 Catch:{ all -> 0x04b7 }
        r2.zzazf();	 Catch:{ all -> 0x04b7 }
        r3 = r2.zzazc();	 Catch:{ all -> 0x04b7 }
        r1 = (int) r3;	 Catch:{ all -> 0x04b7 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x04b7 }
        r7.zzjvf = r1;	 Catch:{ all -> 0x04b7 }
        r3 = 12211; // 0x2fb3 float:1.7111E-41 double:6.033E-320;
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b7 }
        r7.zzjvb = r1;	 Catch:{ all -> 0x04b7 }
        r1 = r5.zzdir;	 Catch:{ all -> 0x04b7 }
        r3 = r1.currentTimeMillis();	 Catch:{ all -> 0x04b7 }
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x04b7 }
        r7.zzjus = r1;	 Catch:{ all -> 0x04b7 }
        r1 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x04b7 }
        r7.zzjvg = r1;	 Catch:{ all -> 0x04b7 }
        r1 = r7.zzjut;	 Catch:{ all -> 0x04b7 }
        r3 = r1.longValue();	 Catch:{ all -> 0x04b7 }
        r2.zzal(r3);	 Catch:{ all -> 0x04b7 }
        r1 = r7.zzjuu;	 Catch:{ all -> 0x04b7 }
        r3 = r1.longValue();	 Catch:{ all -> 0x04b7 }
        r2.zzam(r3);	 Catch:{ all -> 0x04b7 }
        r1 = r32.zzayj();	 Catch:{ all -> 0x04b7 }
        r1.zza(r2);	 Catch:{ all -> 0x04b7 }
        r1 = r32.zzayj();	 Catch:{ all -> 0x04b7 }
        r1.setTransactionSuccessful();	 Catch:{ all -> 0x04b7 }
        r1 = r32.zzayj();
        r1.endTransaction();
        r1 = r15.zzhs();	 Catch:{ IOException -> 0x04a3 }
        r1 = new byte[r1];	 Catch:{ IOException -> 0x04a3 }
        r2 = r1.length;	 Catch:{ IOException -> 0x04a3 }
        r3 = 0;
        r2 = com.google.android.gms.internal.zzflk.zzp(r1, r3, r2);	 Catch:{ IOException -> 0x04a3 }
        r15.zza(r2);	 Catch:{ IOException -> 0x04a3 }
        r2.zzcyx();	 Catch:{ IOException -> 0x04a3 }
        r2 = r32.zzayl();	 Catch:{ IOException -> 0x04a3 }
        r1 = r2.zzr(r1);	 Catch:{ IOException -> 0x04a3 }
        return r1;
    L_0x04a3:
        r0 = move-exception;
        r1 = r0;
        r2 = r32.zzayp();
        r2 = r2.zzbau();
        r3 = "Data loss. Failed to bundle and serialize. appId";
        r4 = com.google.android.gms.internal.zzcjj.zzjs(r34);
        r2.zze(r3, r4, r1);
        return r26;
    L_0x04b7:
        r0 = move-exception;
        goto L_0x04bf;
    L_0x04b9:
        r0 = move-exception;
        r5 = r32;
        goto L_0x04bf;
    L_0x04bd:
        r0 = move-exception;
        r5 = r11;
    L_0x04bf:
        r1 = r0;
    L_0x04c0:
        r2 = r32.zzayj();
        r2.endTransaction();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zza(com.google.android.gms.internal.zzcix, java.lang.String):byte[]");
    }

    public final zzcia zzayb() {
        zza(this.zzjof);
        return this.zzjof;
    }

    public final zzcih zzayc() {
        zza(this.zzjon);
        return this.zzjon;
    }

    public final zzclk zzayd() {
        zza(this.zzjoe);
        return this.zzjoe;
    }

    public final zzcje zzaye() {
        zza(this.zzjok);
        return this.zzjok;
    }

    public final zzcir zzayf() {
        zza(this.zzjoj);
        return this.zzjoj;
    }

    public final zzcme zzayg() {
        zza(this.zzjoi);
        return this.zzjoi;
    }

    public final zzcma zzayh() {
        zza(this.zzjod);
        return this.zzjod;
    }

    public final zzcjf zzayi() {
        zza(this.zzjoh);
        return this.zzjoh;
    }

    public final zzcil zzayj() {
        zza(this.zzjog);
        return this.zzjog;
    }

    public final zzcjh zzayk() {
        zza(this.zzjob);
        return this.zzjob;
    }

    public final zzcno zzayl() {
        zza(this.zzjoa);
        return this.zzjoa;
    }

    public final zzckd zzaym() {
        zza(this.zzjnx);
        return this.zzjnx;
    }

    public final zzcnd zzayn() {
        zza(this.zzjnw);
        return this.zzjnw;
    }

    public final zzcke zzayo() {
        zza(this.zzjnv);
        return this.zzjnv;
    }

    public final zzcjj zzayp() {
        zza(this.zzjnu);
        return this.zzjnu;
    }

    public final zzcju zzayq() {
        zza(this.zzjnt);
        return this.zzjnt;
    }

    public final zzcik zzayr() {
        return this.zzjns;
    }

    @WorkerThread
    final void zzb(zzcii zzcii, zzcif zzcif) {
        zzbq.checkNotNull(zzcii);
        zzbq.zzgv(zzcii.packageName);
        zzbq.checkNotNull(zzcii.zzjgm);
        zzbq.checkNotNull(zzcii.zzjgn);
        zzbq.zzgv(zzcii.zzjgn.name);
        zzayo().zzwj();
        zzyk();
        if (!TextUtils.isEmpty(zzcif.zzjfl)) {
            if (zzcif.zzjfv) {
                zzcii zzcii2 = new zzcii(zzcii);
                boolean z = false;
                zzcii2.zzjgp = false;
                zzayj().beginTransaction();
                try {
                    zzcjl zzbaz;
                    String str;
                    Object obj;
                    Object zzjr;
                    Object value;
                    zzcii zzah = zzayj().zzah(zzcii2.packageName, zzcii2.zzjgn.name);
                    if (!(zzah == null || zzah.zzjgm.equals(zzcii2.zzjgm))) {
                        zzayp().zzbaw().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzayk().zzjr(zzcii2.zzjgn.name), zzcii2.zzjgm, zzah.zzjgm);
                    }
                    if (zzah != null && zzah.zzjgp) {
                        zzcii2.zzjgm = zzah.zzjgm;
                        zzcii2.zzjgo = zzah.zzjgo;
                        zzcii2.zzjgs = zzah.zzjgs;
                        zzcii2.zzjgq = zzah.zzjgq;
                        zzcii2.zzjgt = zzah.zzjgt;
                        zzcii2.zzjgp = zzah.zzjgp;
                        zzcii2.zzjgn = new zzcnl(zzcii2.zzjgn.name, zzah.zzjgn.zzjsi, zzcii2.zzjgn.getValue(), zzah.zzjgn.zzjgm);
                    } else if (TextUtils.isEmpty(zzcii2.zzjgq)) {
                        zzcii2.zzjgn = new zzcnl(zzcii2.zzjgn.name, zzcii2.zzjgo, zzcii2.zzjgn.getValue(), zzcii2.zzjgn.zzjgm);
                        zzcii2.zzjgp = true;
                        z = true;
                    }
                    if (zzcii2.zzjgp) {
                        zzcjl zzbaz2;
                        String str2;
                        Object obj2;
                        Object zzjr2;
                        Object obj3;
                        zzcnl zzcnl = zzcii2.zzjgn;
                        zzcnn zzcnn = new zzcnn(zzcii2.packageName, zzcii2.zzjgm, zzcnl.name, zzcnl.zzjsi, zzcnl.getValue());
                        if (zzayj().zza(zzcnn)) {
                            zzbaz2 = zzayp().zzbaz();
                            str2 = "User property updated immediately";
                            obj2 = zzcii2.packageName;
                            zzjr2 = zzayk().zzjr(zzcnn.name);
                            obj3 = zzcnn.value;
                        } else {
                            zzbaz2 = zzayp().zzbau();
                            str2 = "(2)Too many active user properties, ignoring";
                            obj2 = zzcjj.zzjs(zzcii2.packageName);
                            zzjr2 = zzayk().zzjr(zzcnn.name);
                            obj3 = zzcnn.value;
                        }
                        zzbaz2.zzd(str2, obj2, zzjr2, obj3);
                        if (z && zzcii2.zzjgt != null) {
                            zzc(new zzcix(zzcii2.zzjgt, zzcii2.zzjgo), zzcif);
                        }
                    }
                    if (zzayj().zza(zzcii2)) {
                        zzbaz = zzayp().zzbaz();
                        str = "Conditional property added";
                        obj = zzcii2.packageName;
                        zzjr = zzayk().zzjr(zzcii2.zzjgn.name);
                        value = zzcii2.zzjgn.getValue();
                    } else {
                        zzbaz = zzayp().zzbau();
                        str = "Too many conditional properties, ignoring";
                        obj = zzcjj.zzjs(zzcii2.packageName);
                        zzjr = zzayk().zzjr(zzcii2.zzjgn.name);
                        value = zzcii2.zzjgn.getValue();
                    }
                    zzbaz.zzd(str, obj, zzjr, value);
                    zzayj().setTransactionSuccessful();
                } finally {
                    zzayj().endTransaction();
                }
            } else {
                zzg(zzcif);
            }
        }
    }

    @WorkerThread
    final void zzb(zzcix zzcix, zzcif zzcif) {
        zzcix zzcix2 = zzcix;
        zzcif zzcif2 = zzcif;
        zzbq.checkNotNull(zzcif);
        zzbq.zzgv(zzcif2.packageName);
        zzayo().zzwj();
        zzyk();
        String str = zzcif2.packageName;
        long j = zzcix2.zzjib;
        zzayl();
        if (!zzcno.zzd(zzcix, zzcif)) {
            return;
        }
        if (zzcif2.zzjfv) {
            zzayj().beginTransaction();
            try {
                List emptyList;
                Object obj;
                List emptyList2;
                zzclh zzayj = zzayj();
                zzbq.zzgv(str);
                zzayj.zzwj();
                zzayj.zzyk();
                if (j < 0) {
                    zzayj.zzayp().zzbaw().zze("Invalid time querying timed out conditional properties", zzcjj.zzjs(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzayj.zzd("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzcii zzcii : emptyList) {
                    if (zzcii != null) {
                        zzayp().zzbaz().zzd("User property timed out", zzcii.packageName, zzayk().zzjr(zzcii.zzjgn.name), zzcii.zzjgn.getValue());
                        if (zzcii.zzjgr != null) {
                            zzc(new zzcix(zzcii.zzjgr, j), zzcif2);
                        }
                        zzayj().zzai(str, zzcii.zzjgn.name);
                    }
                }
                zzayj = zzayj();
                zzbq.zzgv(str);
                zzayj.zzwj();
                zzayj.zzyk();
                if (j < 0) {
                    zzayj.zzayp().zzbaw().zze("Invalid time querying expired conditional properties", zzcjj.zzjs(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzayj.zzd("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r5.size());
                for (zzcii zzcii2 : r5) {
                    if (zzcii2 != null) {
                        zzayp().zzbaz().zzd("User property expired", zzcii2.packageName, zzayk().zzjr(zzcii2.zzjgn.name), zzcii2.zzjgn.getValue());
                        zzayj().zzaf(str, zzcii2.zzjgn.name);
                        if (zzcii2.zzjgv != null) {
                            arrayList.add(zzcii2.zzjgv);
                        }
                        zzayj().zzai(str, zzcii2.zzjgn.name);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    obj = arrayList2.get(i);
                    i++;
                    zzc(new zzcix((zzcix) obj, j), zzcif2);
                }
                zzayj = zzayj();
                String str2 = zzcix2.name;
                zzbq.zzgv(str);
                zzbq.zzgv(str2);
                zzayj.zzwj();
                zzayj.zzyk();
                if (j < 0) {
                    zzayj.zzayp().zzbaw().zzd("Invalid time querying triggered conditional properties", zzcjj.zzjs(str), zzayj.zzayk().zzjp(str2), Long.valueOf(j));
                    emptyList2 = Collections.emptyList();
                } else {
                    emptyList2 = zzayj.zzd("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(emptyList2.size());
                Iterator it = emptyList2.iterator();
                while (it.hasNext()) {
                    zzcii zzcii3 = (zzcii) it.next();
                    if (zzcii3 != null) {
                        zzcjl zzbaz;
                        Object zzjr;
                        Object obj2;
                        zzcnl zzcnl = zzcii3.zzjgn;
                        zzcnn zzcnn = r5;
                        Iterator it2 = it;
                        zzcii zzcii4 = zzcii3;
                        zzcnn zzcnn2 = new zzcnn(zzcii3.packageName, zzcii3.zzjgm, zzcnl.name, j, zzcnl.getValue());
                        if (zzayj().zza(zzcnn)) {
                            zzbaz = zzayp().zzbaz();
                            str2 = "User property triggered";
                            obj = zzcii4.packageName;
                            zzjr = zzayk().zzjr(zzcnn.name);
                            obj2 = zzcnn.value;
                        } else {
                            zzbaz = zzayp().zzbau();
                            str2 = "Too many active user properties, ignoring";
                            obj = zzcjj.zzjs(zzcii4.packageName);
                            zzjr = zzayk().zzjr(zzcnn.name);
                            obj2 = zzcnn.value;
                        }
                        zzbaz.zzd(str2, obj, zzjr, obj2);
                        if (zzcii4.zzjgt != null) {
                            arrayList3.add(zzcii4.zzjgt);
                        }
                        zzcii4.zzjgn = new zzcnl(zzcnn);
                        zzcii4.zzjgp = true;
                        zzayj().zza(zzcii4);
                        it = it2;
                    }
                }
                zzc(zzcix, zzcif);
                ArrayList arrayList4 = (ArrayList) arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzcix((zzcix) obj3, j), zzcif2);
                }
                zzayj().setTransactionSuccessful();
                zzayj().endTransaction();
            } catch (Throwable th) {
                Throwable th2 = th;
                zzayj().endTransaction();
            }
        } else {
            zzg(zzcif2);
        }
    }

    @WorkerThread
    final void zzb(zzcix zzcix, String str) {
        zzcix zzcix2 = zzcix;
        String str2 = str;
        zzcie zzjj = zzayj().zzjj(str2);
        if (zzjj == null || TextUtils.isEmpty(zzjj.zzwo())) {
            zzayp().zzbaz().zzj("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzjj);
        if (zzc == null) {
            if (!"_ui".equals(zzcix2.name)) {
                zzayp().zzbaw().zzj("Could not find package. appId", zzcjj.zzjs(str));
            }
        } else if (!zzc.booleanValue()) {
            zzayp().zzbau().zzj("App version does not match; dropping event. appId", zzcjj.zzjs(str));
            return;
        }
        zzcif zzcif = r2;
        zzcif zzcif2 = new zzcif(str2, zzjj.getGmpAppId(), zzjj.zzwo(), zzjj.zzayx(), zzjj.zzayy(), zzjj.zzayz(), zzjj.zzaza(), null, zzjj.zzazb(), false, zzjj.zzayu(), zzjj.zzazo(), 0, 0, zzjj.zzazp());
        zzb(zzcix2, zzcif);
    }

    final void zzb(zzcli zzcli) {
        this.zzjov++;
    }

    @WorkerThread
    final void zzb(zzcnl zzcnl, zzcif zzcif) {
        zzayo().zzwj();
        zzyk();
        if (!TextUtils.isEmpty(zzcif.zzjfl)) {
            if (zzcif.zzjfv) {
                int zzkk = zzayl().zzkk(zzcnl.name);
                if (zzkk != 0) {
                    zzayl();
                    zzayl().zza(zzcif.packageName, zzkk, "_ev", zzcno.zza(zzcnl.name, 24, true), zzcnl.name != null ? zzcnl.name.length() : 0);
                    return;
                }
                int zzl = zzayl().zzl(zzcnl.name, zzcnl.getValue());
                if (zzl != 0) {
                    zzayl();
                    String zza = zzcno.zza(zzcnl.name, 24, true);
                    Object value = zzcnl.getValue();
                    int length = (value == null || !((value instanceof String) || (value instanceof CharSequence))) ? 0 : String.valueOf(value).length();
                    zzayl().zza(zzcif.packageName, zzl, "_ev", zza, length);
                    return;
                }
                Object zzm = zzayl().zzm(zzcnl.name, zzcnl.getValue());
                if (zzm != null) {
                    zzcnn zzcnn = new zzcnn(zzcif.packageName, zzcnl.zzjgm, zzcnl.name, zzcnl.zzjsi, zzm);
                    zzayp().zzbaz().zze("Setting user property", zzayk().zzjr(zzcnn.name), zzm);
                    zzayj().beginTransaction();
                    try {
                        zzg(zzcif);
                        boolean zza2 = zzayj().zza(zzcnn);
                        zzayj().setTransactionSuccessful();
                        if (zza2) {
                            zzayp().zzbaz().zze("User property set", zzayk().zzjr(zzcnn.name), zzcnn.value);
                        } else {
                            zzayp().zzbau().zze("Too many unique user properties are set. Ignoring user property", zzayk().zzjr(zzcnn.name), zzcnn.value);
                            zzayl().zza(zzcif.packageName, 9, null, null, 0);
                        }
                        zzayj().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzayj().endTransaction();
                    }
                } else {
                    return;
                }
            }
            zzg(zzcif);
        }
    }

    @WorkerThread
    final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzcil zzayj;
        zzayo().zzwj();
        zzyk();
        zzbq.zzgv(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzjoz = false;
                zzbce();
            }
        }
        zzayp().zzbba().zzj("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzayj().beginTransaction();
        zzcie zzjj = zzayj().zzjj(str);
        Object obj = 1;
        Object obj2 = ((i == 200 || i == 204 || i == MobileEvents.EVENTTYPE_RAW_TOUCH) && th == null) ? 1 : null;
        if (zzjj == null) {
            zzayp().zzbaw().zzj("App does not exist in onConfigFetched. appId", zzcjj.zzjs(str));
            zzayj().setTransactionSuccessful();
            zzayj = zzayj();
        } else {
            if (obj2 != null || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == MobileEvents.EVENTTYPE_RAW_TOUCH) {
                    if (zzaym().zzka(str) == null && !zzaym().zzb(str, null, null)) {
                        zzayj = zzayj();
                    }
                } else if (!zzaym().zzb(str, bArr, str2)) {
                    zzayj = zzayj();
                }
                zzjj.zzar(this.zzdir.currentTimeMillis());
                zzayj().zza(zzjj);
                if (i == 404) {
                    zzayp().zzbax().zzj("Config not found. Using empty config. appId", str);
                } else {
                    zzayp().zzbba().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzbbs().zzaax() && zzbbz()) {
                    zzbby();
                    zzayj().setTransactionSuccessful();
                    zzayj = zzayj();
                }
            } else {
                zzjj.zzas(this.zzdir.currentTimeMillis());
                zzayj().zza(zzjj);
                zzayp().zzbba().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzaym().zzkc(str);
                zzayq().zzjlo.set(this.zzdir.currentTimeMillis());
                if (!(i == 503 || i == 429)) {
                    obj = null;
                }
                if (obj != null) {
                    zzayq().zzjlp.set(this.zzdir.currentTimeMillis());
                }
            }
            zzbca();
            zzayj().setTransactionSuccessful();
            zzayj = zzayj();
        }
        zzayj.endTransaction();
        this.zzjoz = false;
        zzbce();
    }

    @WorkerThread
    protected final boolean zzbbn() {
        zzyk();
        zzayo().zzwj();
        if (this.zzjop == null || this.zzjoq == 0 || !(this.zzjop == null || this.zzjop.booleanValue() || Math.abs(this.zzdir.elapsedRealtime() - this.zzjoq) <= 1000)) {
            this.zzjoq = this.zzdir.elapsedRealtime();
            boolean z = false;
            if (zzayl().zzeh("android.permission.INTERNET") && zzayl().zzeh("android.permission.ACCESS_NETWORK_STATE") && (zzbih.zzdd(this.zzaiq).zzaoe() || (zzcka.zzbj(this.zzaiq) && zzcmy.zzg(this.zzaiq, false)))) {
                z = true;
            }
            this.zzjop = Boolean.valueOf(z);
            if (this.zzjop.booleanValue()) {
                this.zzjop = Boolean.valueOf(zzayl().zzkn(zzaye().getGmpAppId()));
            }
        }
        return this.zzjop.booleanValue();
    }

    public final zzcjj zzbbo() {
        return (this.zzjnu == null || !this.zzjnu.isInitialized()) ? null : this.zzjnu;
    }

    final zzcke zzbbp() {
        return this.zzjnv;
    }

    public final AppMeasurement zzbbq() {
        return this.zzjny;
    }

    public final FirebaseAnalytics zzbbr() {
        return this.zzjnz;
    }

    public final zzcjn zzbbs() {
        zza(this.zzjoc);
        return this.zzjoc;
    }

    final long zzbbw() {
        Long valueOf = Long.valueOf(zzayq().zzjls.get());
        return valueOf.longValue() == 0 ? this.zzjgk : Math.min(this.zzjgk, valueOf.longValue());
    }

    @WorkerThread
    public final void zzbby() {
        zzayo().zzwj();
        zzyk();
        this.zzjpb = true;
        String zzazw;
        String str;
        try {
            zzcjl zzbaw;
            String str2;
            Boolean zzbck = zzayg().zzbck();
            if (zzbck == null) {
                zzbaw = zzayp().zzbaw();
                str2 = "Upload data called on the client side before use of service was decided";
            } else if (zzbck.booleanValue()) {
                zzbaw = zzayp().zzbau();
                str2 = "Upload called in the client side when service should be used";
            } else {
                if (this.zzjoy <= 0) {
                    zzayo().zzwj();
                    if ((this.zzjot != null ? 1 : null) != null) {
                        zzbaw = zzayp().zzbba();
                        str2 = "Uploading requested multiple times";
                    } else if (zzbbs().zzaax()) {
                        long currentTimeMillis = this.zzdir.currentTimeMillis();
                        Object obj = null;
                        zzg(null, currentTimeMillis - zzcik.zzazt());
                        long j = zzayq().zzjln.get();
                        if (j != 0) {
                            zzayp().zzbaz().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                        }
                        zzazw = zzayj().zzazw();
                        if (TextUtils.isEmpty(zzazw)) {
                            this.zzjox = -1;
                            Object zzba = zzayj().zzba(currentTimeMillis - zzcik.zzazt());
                            if (!TextUtils.isEmpty(zzba)) {
                                zzcie zzjj = zzayj().zzjj(zzba);
                                if (zzjj != null) {
                                    zzb(zzjj);
                                }
                            }
                        } else {
                            if (this.zzjox == -1) {
                                this.zzjox = zzayj().zzbad();
                            }
                            List<Pair> zzl = zzayj().zzl(zzazw, this.zzjns.zzb(zzazw, zzciz.zzjit), Math.max(0, this.zzjns.zzb(zzazw, zzciz.zzjiu)));
                            if (!zzl.isEmpty()) {
                                Object obj2;
                                List zzl2;
                                for (Pair pair : zzl2) {
                                    zzcoe zzcoe = (zzcoe) pair.first;
                                    if (!TextUtils.isEmpty(zzcoe.zzjvc)) {
                                        obj2 = zzcoe.zzjvc;
                                        break;
                                    }
                                }
                                obj2 = null;
                                if (obj2 != null) {
                                    for (int i = 0; i < zzl2.size(); i++) {
                                        zzcoe zzcoe2 = (zzcoe) ((Pair) zzl2.get(i)).first;
                                        if (!TextUtils.isEmpty(zzcoe2.zzjvc) && !zzcoe2.zzjvc.equals(obj2)) {
                                            zzl2 = zzl2.subList(0, i);
                                            break;
                                        }
                                    }
                                }
                                zzcod zzcod = new zzcod();
                                zzcod.zzjun = new zzcoe[zzl2.size()];
                                Collection arrayList = new ArrayList(zzl2.size());
                                Object obj3 = (zzcik.zzazv() && this.zzjns.zzjg(zzazw)) ? 1 : null;
                                for (int i2 = 0; i2 < zzcod.zzjun.length; i2++) {
                                    zzcod.zzjun[i2] = (zzcoe) ((Pair) zzl2.get(i2)).first;
                                    arrayList.add((Long) ((Pair) zzl2.get(i2)).second);
                                    zzcod.zzjun[i2].zzjvb = Long.valueOf(12211);
                                    zzcod.zzjun[i2].zzjus = Long.valueOf(currentTimeMillis);
                                    zzcod.zzjun[i2].zzjvg = Boolean.valueOf(false);
                                    if (obj3 == null) {
                                        zzcod.zzjun[i2].zzjvn = null;
                                    }
                                }
                                if (zzayp().zzae(2)) {
                                    obj = zzayk().zza(zzcod);
                                }
                                Object zzb = zzayl().zzb(zzcod);
                                str = (String) zzciz.zzjjd.get();
                                URL url = new URL(str);
                                zzbq.checkArgument(arrayList.isEmpty() ^ true);
                                if (this.zzjot != null) {
                                    zzayp().zzbau().log("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzjot = new ArrayList(arrayList);
                                }
                                zzayq().zzjlo.set(currentTimeMillis);
                                Object obj4 = "?";
                                if (zzcod.zzjun.length > 0) {
                                    obj4 = zzcod.zzjun[0].zzcm;
                                }
                                zzayp().zzbba().zzd("Uploading data. app, uncompressed size, data", obj4, Integer.valueOf(zzb.length), obj);
                                this.zzjpa = true;
                                zzclh zzbbs = zzbbs();
                                zzcjp zzckm = new zzckm(this);
                                zzbbs.zzwj();
                                zzbbs.zzyk();
                                zzbq.checkNotNull(url);
                                zzbq.checkNotNull(zzb);
                                zzbq.checkNotNull(zzckm);
                                zzbbs.zzayo().zzi(new zzcjr(zzbbs, zzazw, url, zzb, null, zzckm));
                            }
                        }
                        this.zzjpb = false;
                        zzbce();
                    } else {
                        zzayp().zzbba().log("Network not connected, ignoring upload request");
                    }
                }
                zzbca();
                this.zzjpb = false;
                zzbce();
            }
            zzbaw.log(str2);
        } catch (MalformedURLException unused) {
            zzayp().zzbau().zze("Failed to parse upload URL. Not uploading. appId", zzcjj.zzjs(zzazw), str);
        } catch (Throwable th) {
            this.zzjpb = false;
            zzbce();
        }
        this.zzjpb = false;
        zzbce();
    }

    final void zzbcb() {
        this.zzjow++;
    }

    @WorkerThread
    final void zzbcc() {
        zzayo().zzwj();
        zzyk();
        if (!this.zzjoo) {
            zzayp().zzbay().log("This instance being marked as an uploader");
            zzayo().zzwj();
            zzyk();
            if (zzbcd() && zzbbv()) {
                zzcjl zzbau;
                String str;
                int zza = zza(this.zzjos);
                int zzbar = zzaye().zzbar();
                zzayo().zzwj();
                if (zza > zzbar) {
                    zzbau = zzayp().zzbau();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza < zzbar) {
                    if (zza(zzbar, this.zzjos)) {
                        zzbau = zzayp().zzbba();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzbau = zzayp().zzbau();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzbau.zze(str, Integer.valueOf(zza), Integer.valueOf(zzbar));
            }
            this.zzjoo = true;
            zzbca();
        }
    }

    public final void zzbt(boolean z) {
        zzbca();
    }

    @WorkerThread
    final void zzc(zzcii zzcii, zzcif zzcif) {
        zzbq.checkNotNull(zzcii);
        zzbq.zzgv(zzcii.packageName);
        zzbq.checkNotNull(zzcii.zzjgn);
        zzbq.zzgv(zzcii.zzjgn.name);
        zzayo().zzwj();
        zzyk();
        if (!TextUtils.isEmpty(zzcif.zzjfl)) {
            if (zzcif.zzjfv) {
                zzayj().beginTransaction();
                try {
                    zzg(zzcif);
                    zzcii zzah = zzayj().zzah(zzcii.packageName, zzcii.zzjgn.name);
                    if (zzah != null) {
                        zzayp().zzbaz().zze("Removing conditional user property", zzcii.packageName, zzayk().zzjr(zzcii.zzjgn.name));
                        zzayj().zzai(zzcii.packageName, zzcii.zzjgn.name);
                        if (zzah.zzjgp) {
                            zzayj().zzaf(zzcii.packageName, zzcii.zzjgn.name);
                        }
                        if (zzcii.zzjgv != null) {
                            Bundle bundle = null;
                            if (zzcii.zzjgv.zzjhr != null) {
                                bundle = zzcii.zzjgv.zzjhr.zzbao();
                            }
                            Bundle bundle2 = bundle;
                            zzc(zzayl().zza(zzcii.zzjgv.name, bundle2, zzah.zzjgm, zzcii.zzjgv.zzjib, true, false), zzcif);
                        }
                    } else {
                        zzayp().zzbaw().zze("Conditional user property doesn't exist", zzcjj.zzjs(zzcii.packageName), zzayk().zzjr(zzcii.zzjgn.name));
                    }
                    zzayj().setTransactionSuccessful();
                } finally {
                    zzayj().endTransaction();
                }
            } else {
                zzg(zzcif);
            }
        }
    }

    @WorkerThread
    final void zzc(zzcnl zzcnl, zzcif zzcif) {
        zzayo().zzwj();
        zzyk();
        if (!TextUtils.isEmpty(zzcif.zzjfl)) {
            if (zzcif.zzjfv) {
                zzayp().zzbaz().zzj("Removing user property", zzayk().zzjr(zzcnl.name));
                zzayj().beginTransaction();
                try {
                    zzg(zzcif);
                    zzayj().zzaf(zzcif.packageName, zzcnl.name);
                    zzayj().setTransactionSuccessful();
                    zzayp().zzbaz().zzj("User property removed", zzayk().zzjr(zzcnl.name));
                } finally {
                    zzayj().endTransaction();
                }
            } else {
                zzg(zzcif);
            }
        }
    }

    final void zzd(zzcif zzcif) {
        zzayj().zzjj(zzcif.packageName);
        zzclh zzayj = zzayj();
        String str = zzcif.packageName;
        zzbq.zzgv(str);
        zzayj.zzwj();
        zzayj.zzyk();
        try {
            SQLiteDatabase writableDatabase = zzayj.getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = ((((((((writableDatabase.delete("apps", "app_id=?", strArr) + 0) + writableDatabase.delete("events", "app_id=?", strArr)) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("queue", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr)) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzayj.zzayp().zzbba().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzayj.zzayp().zzbau().zze("Error resetting analytics data. appId, error", zzcjj.zzjs(str), e);
        }
        zzf(zza(this.zzaiq, zzcif.packageName, zzcif.zzjfl, zzcif.zzjfv, zzcif.zzjfx));
    }

    @WorkerThread
    final void zzd(zzcii zzcii) {
        zzcif zzke = zzke(zzcii.packageName);
        if (zzke != null) {
            zzb(zzcii, zzke);
        }
    }

    final void zze(zzcif zzcif) {
        zzayo().zzwj();
        zzyk();
        zzbq.zzgv(zzcif.packageName);
        zzg(zzcif);
    }

    @WorkerThread
    final void zze(zzcii zzcii) {
        zzcif zzke = zzke(zzcii.packageName);
        if (zzke != null) {
            zzc(zzcii, zzke);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x037a A:{Catch:{ SQLiteException -> 0x0140, all -> 0x03a3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e6 A:{Catch:{ SQLiteException -> 0x0140, all -> 0x03a3 }} */
    @android.support.annotation.WorkerThread
    public final void zzf(com.google.android.gms.internal.zzcif r21) {
        /*
        r20 = this;
        r1 = r20;
        r2 = r21;
        r3 = r20.zzayo();
        r3.zzwj();
        r20.zzyk();
        com.google.android.gms.common.internal.zzbq.checkNotNull(r21);
        r3 = r2.packageName;
        com.google.android.gms.common.internal.zzbq.zzgv(r3);
        r3 = r2.zzjfl;
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x001f;
    L_0x001e:
        return;
    L_0x001f:
        r3 = r20.zzayj();
        r4 = r2.packageName;
        r3 = r3.zzjj(r4);
        r4 = 0;
        if (r3 == 0) goto L_0x0052;
    L_0x002d:
        r6 = r3.getGmpAppId();
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 == 0) goto L_0x0052;
    L_0x0037:
        r6 = r2.zzjfl;
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 != 0) goto L_0x0052;
    L_0x003f:
        r3.zzar(r4);
        r6 = r20.zzayj();
        r6.zza(r3);
        r3 = r20.zzaym();
        r6 = r2.packageName;
        r3.zzkd(r6);
    L_0x0052:
        r3 = r2.zzjfv;
        if (r3 != 0) goto L_0x005a;
    L_0x0056:
        r20.zzg(r21);
        return;
    L_0x005a:
        r6 = r2.zzjgk;
        r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r3 != 0) goto L_0x0066;
    L_0x0060:
        r3 = r1.zzdir;
        r6 = r3.currentTimeMillis();
    L_0x0066:
        r3 = r2.zzjgl;
        r14 = 0;
        r15 = 1;
        if (r3 == 0) goto L_0x0086;
    L_0x006c:
        if (r3 == r15) goto L_0x0086;
    L_0x006e:
        r8 = r20.zzayp();
        r8 = r8.zzbaw();
        r9 = "Incorrect app type, assuming installed app. appId, appType";
        r10 = r2.packageName;
        r10 = com.google.android.gms.internal.zzcjj.zzjs(r10);
        r3 = java.lang.Integer.valueOf(r3);
        r8.zze(r9, r10, r3);
        r3 = 0;
    L_0x0086:
        r8 = r20.zzayj();
        r8.beginTransaction();
        r8 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r9 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r8 = r8.zzjj(r9);	 Catch:{ all -> 0x03a3 }
        r16 = 0;
        if (r8 == 0) goto L_0x0155;
    L_0x009b:
        r9 = r8.getGmpAppId();	 Catch:{ all -> 0x03a3 }
        if (r9 == 0) goto L_0x0155;
    L_0x00a1:
        r9 = r8.getGmpAppId();	 Catch:{ all -> 0x03a3 }
        r10 = r2.zzjfl;	 Catch:{ all -> 0x03a3 }
        r9 = r9.equals(r10);	 Catch:{ all -> 0x03a3 }
        if (r9 != 0) goto L_0x0155;
    L_0x00ad:
        r9 = r20.zzayp();	 Catch:{ all -> 0x03a3 }
        r9 = r9.zzbaw();	 Catch:{ all -> 0x03a3 }
        r10 = "New GMP App Id passed in. Removing cached database data. appId";
        r11 = r8.getAppId();	 Catch:{ all -> 0x03a3 }
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ all -> 0x03a3 }
        r9.zzj(r10, r11);	 Catch:{ all -> 0x03a3 }
        r9 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r8 = r8.getAppId();	 Catch:{ all -> 0x03a3 }
        r9.zzyk();	 Catch:{ all -> 0x03a3 }
        r9.zzwj();	 Catch:{ all -> 0x03a3 }
        com.google.android.gms.common.internal.zzbq.zzgv(r8);	 Catch:{ all -> 0x03a3 }
        r10 = r9.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0140 }
        r11 = new java.lang.String[r15];	 Catch:{ SQLiteException -> 0x0140 }
        r11[r14] = r8;	 Catch:{ SQLiteException -> 0x0140 }
        r12 = "events";
        r13 = "app_id=?";
        r12 = r10.delete(r12, r13, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r14;
        r13 = "user_attributes";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "conditional_properties";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "apps";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "raw_events";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "raw_events_metadata";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "event_filters";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "property_filters";
        r14 = "app_id=?";
        r13 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r13;
        r13 = "audience_filter_values";
        r14 = "app_id=?";
        r10 = r10.delete(r13, r14, r11);	 Catch:{ SQLiteException -> 0x0140 }
        r12 = r12 + r10;
        if (r12 <= 0) goto L_0x0153;
    L_0x012e:
        r10 = r9.zzayp();	 Catch:{ SQLiteException -> 0x0140 }
        r10 = r10.zzbba();	 Catch:{ SQLiteException -> 0x0140 }
        r11 = "Deleted application data. app, records";
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ SQLiteException -> 0x0140 }
        r10.zze(r11, r8, r12);	 Catch:{ SQLiteException -> 0x0140 }
        goto L_0x0153;
    L_0x0140:
        r0 = move-exception;
        r10 = r0;
        r9 = r9.zzayp();	 Catch:{ all -> 0x03a3 }
        r9 = r9.zzbau();	 Catch:{ all -> 0x03a3 }
        r11 = "Error deleting application data. appId, error";
        r8 = com.google.android.gms.internal.zzcjj.zzjs(r8);	 Catch:{ all -> 0x03a3 }
        r9.zze(r11, r8, r10);	 Catch:{ all -> 0x03a3 }
    L_0x0153:
        r8 = r16;
    L_0x0155:
        if (r8 == 0) goto L_0x01c5;
    L_0x0157:
        r9 = r8.zzayx();	 Catch:{ all -> 0x03a3 }
        r11 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x0191;
    L_0x0162:
        r9 = r8.zzayx();	 Catch:{ all -> 0x03a3 }
        r11 = r2.zzjfr;	 Catch:{ all -> 0x03a3 }
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x01c5;
    L_0x016c:
        r9 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r9.<init>();	 Catch:{ all -> 0x03a3 }
        r10 = "_pv";
        r8 = r8.zzwo();	 Catch:{ all -> 0x03a3 }
        r9.putString(r10, r8);	 Catch:{ all -> 0x03a3 }
        r14 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r10 = "_au";
        r11 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r11.<init>(r9);	 Catch:{ all -> 0x03a3 }
        r12 = "auto";
        r8 = r14;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
    L_0x018d:
        r1.zzb(r14, r2);	 Catch:{ all -> 0x03a3 }
        goto L_0x01c5;
    L_0x0191:
        r9 = r8.zzwo();	 Catch:{ all -> 0x03a3 }
        if (r9 == 0) goto L_0x01c5;
    L_0x0197:
        r9 = r8.zzwo();	 Catch:{ all -> 0x03a3 }
        r10 = r2.zzina;	 Catch:{ all -> 0x03a3 }
        r9 = r9.equals(r10);	 Catch:{ all -> 0x03a3 }
        if (r9 != 0) goto L_0x01c5;
    L_0x01a3:
        r9 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r9.<init>();	 Catch:{ all -> 0x03a3 }
        r10 = "_pv";
        r8 = r8.zzwo();	 Catch:{ all -> 0x03a3 }
        r9.putString(r10, r8);	 Catch:{ all -> 0x03a3 }
        r14 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r10 = "_au";
        r11 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r11.<init>(r9);	 Catch:{ all -> 0x03a3 }
        r12 = "auto";
        r8 = r14;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
        goto L_0x018d;
    L_0x01c5:
        r20.zzg(r21);	 Catch:{ all -> 0x03a3 }
        if (r3 != 0) goto L_0x01d7;
    L_0x01ca:
        r8 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r9 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r10 = "_f";
    L_0x01d2:
        r8 = r8.zzae(r9, r10);	 Catch:{ all -> 0x03a3 }
        goto L_0x01e4;
    L_0x01d7:
        if (r3 != r15) goto L_0x01e2;
    L_0x01d9:
        r8 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r9 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r10 = "_v";
        goto L_0x01d2;
    L_0x01e2:
        r8 = r16;
    L_0x01e4:
        if (r8 != 0) goto L_0x037a;
    L_0x01e6:
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r10 = r6 / r8;
        r13 = 1;
        r17 = r10 + r13;
        r8 = r8 * r17;
        if (r3 != 0) goto L_0x031c;
    L_0x01f3:
        r3 = new com.google.android.gms.internal.zzcnl;	 Catch:{ all -> 0x03a3 }
        r10 = "_fot";
        r12 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x03a3 }
        r17 = "auto";
        r8 = r3;
        r9 = r10;
        r10 = r6;
        r4 = r13;
        r13 = r17;
        r8.<init>(r9, r10, r12, r13);	 Catch:{ all -> 0x03a3 }
        r1.zzb(r3, r2);	 Catch:{ all -> 0x03a3 }
        r3 = r20.zzayo();	 Catch:{ all -> 0x03a3 }
        r3.zzwj();	 Catch:{ all -> 0x03a3 }
        r20.zzyk();	 Catch:{ all -> 0x03a3 }
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r3.<init>();	 Catch:{ all -> 0x03a3 }
        r8 = "_c";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r8 = "_r";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r8 = "_uwa";
        r9 = 0;
        r3.putLong(r8, r9);	 Catch:{ all -> 0x03a3 }
        r8 = "_pfo";
        r3.putLong(r8, r9);	 Catch:{ all -> 0x03a3 }
        r8 = "_sys";
        r3.putLong(r8, r9);	 Catch:{ all -> 0x03a3 }
        r8 = "_sysu";
        r3.putLong(r8, r9);	 Catch:{ all -> 0x03a3 }
        r8 = r1.zzaiq;	 Catch:{ all -> 0x03a3 }
        r8 = r8.getPackageManager();	 Catch:{ all -> 0x03a3 }
        if (r8 != 0) goto L_0x0255;
    L_0x0240:
        r8 = r20.zzayp();	 Catch:{ all -> 0x03a3 }
        r8 = r8.zzbau();	 Catch:{ all -> 0x03a3 }
        r9 = "PackageManager is null, first open report might be inaccurate. appId";
        r10 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r10 = com.google.android.gms.internal.zzcjj.zzjs(r10);	 Catch:{ all -> 0x03a3 }
        r8.zzj(r9, r10);	 Catch:{ all -> 0x03a3 }
        goto L_0x02e8;
    L_0x0255:
        r8 = r1.zzaiq;	 Catch:{ NameNotFoundException -> 0x0263 }
        r8 = com.google.android.gms.internal.zzbih.zzdd(r8);	 Catch:{ NameNotFoundException -> 0x0263 }
        r9 = r2.packageName;	 Catch:{ NameNotFoundException -> 0x0263 }
        r10 = 0;
        r8 = r8.getPackageInfo(r9, r10);	 Catch:{ NameNotFoundException -> 0x0263 }
        goto L_0x027a;
    L_0x0263:
        r0 = move-exception;
        r8 = r0;
        r9 = r20.zzayp();	 Catch:{ all -> 0x03a3 }
        r9 = r9.zzbau();	 Catch:{ all -> 0x03a3 }
        r10 = "Package info is null, first open report might be inaccurate. appId";
        r11 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ all -> 0x03a3 }
        r9.zze(r10, r11, r8);	 Catch:{ all -> 0x03a3 }
        r8 = r16;
    L_0x027a:
        if (r8 == 0) goto L_0x02ac;
    L_0x027c:
        r9 = r8.firstInstallTime;	 Catch:{ all -> 0x03a3 }
        r11 = 0;
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x02ac;
    L_0x0284:
        r9 = r8.firstInstallTime;	 Catch:{ all -> 0x03a3 }
        r11 = r8.lastUpdateTime;	 Catch:{ all -> 0x03a3 }
        r8 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r8 == 0) goto L_0x0293;
    L_0x028c:
        r8 = "_uwa";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r8 = 0;
        goto L_0x0294;
    L_0x0293:
        r8 = 1;
    L_0x0294:
        r14 = new com.google.android.gms.internal.zzcnl;	 Catch:{ all -> 0x03a3 }
        r9 = "_fi";
        if (r8 == 0) goto L_0x029c;
    L_0x029a:
        r10 = r4;
        goto L_0x029e;
    L_0x029c:
        r10 = 0;
    L_0x029e:
        r12 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x03a3 }
        r13 = "auto";
        r8 = r14;
        r10 = r6;
        r8.<init>(r9, r10, r12, r13);	 Catch:{ all -> 0x03a3 }
        r1.zzb(r14, r2);	 Catch:{ all -> 0x03a3 }
    L_0x02ac:
        r8 = r1.zzaiq;	 Catch:{ NameNotFoundException -> 0x02ba }
        r8 = com.google.android.gms.internal.zzbih.zzdd(r8);	 Catch:{ NameNotFoundException -> 0x02ba }
        r9 = r2.packageName;	 Catch:{ NameNotFoundException -> 0x02ba }
        r10 = 0;
        r8 = r8.getApplicationInfo(r9, r10);	 Catch:{ NameNotFoundException -> 0x02ba }
        goto L_0x02d1;
    L_0x02ba:
        r0 = move-exception;
        r8 = r0;
        r9 = r20.zzayp();	 Catch:{ all -> 0x03a3 }
        r9 = r9.zzbau();	 Catch:{ all -> 0x03a3 }
        r10 = "Application info is null, first open report might be inaccurate. appId";
        r11 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        r11 = com.google.android.gms.internal.zzcjj.zzjs(r11);	 Catch:{ all -> 0x03a3 }
        r9.zze(r10, r11, r8);	 Catch:{ all -> 0x03a3 }
        r8 = r16;
    L_0x02d1:
        if (r8 == 0) goto L_0x02e8;
    L_0x02d3:
        r9 = r8.flags;	 Catch:{ all -> 0x03a3 }
        r9 = r9 & r15;
        if (r9 == 0) goto L_0x02dd;
    L_0x02d8:
        r9 = "_sys";
        r3.putLong(r9, r4);	 Catch:{ all -> 0x03a3 }
    L_0x02dd:
        r8 = r8.flags;	 Catch:{ all -> 0x03a3 }
        r8 = r8 & 128;
        if (r8 == 0) goto L_0x02e8;
    L_0x02e3:
        r8 = "_sysu";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
    L_0x02e8:
        r8 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r9 = r2.packageName;	 Catch:{ all -> 0x03a3 }
        com.google.android.gms.common.internal.zzbq.zzgv(r9);	 Catch:{ all -> 0x03a3 }
        r8.zzwj();	 Catch:{ all -> 0x03a3 }
        r8.zzyk();	 Catch:{ all -> 0x03a3 }
        r10 = "first_open_count";
        r8 = r8.zzal(r9, r10);	 Catch:{ all -> 0x03a3 }
        r10 = 0;
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r12 < 0) goto L_0x0308;
    L_0x0303:
        r10 = "_pfo";
        r3.putLong(r10, r8);	 Catch:{ all -> 0x03a3 }
    L_0x0308:
        r14 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r9 = "_f";
        r10 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r10.<init>(r3);	 Catch:{ all -> 0x03a3 }
        r11 = "auto";
        r8 = r14;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
    L_0x0318:
        r1.zzb(r14, r2);	 Catch:{ all -> 0x03a3 }
        goto L_0x035c;
    L_0x031c:
        r4 = r13;
        if (r3 != r15) goto L_0x035c;
    L_0x031f:
        r3 = new com.google.android.gms.internal.zzcnl;	 Catch:{ all -> 0x03a3 }
        r10 = "_fvt";
        r12 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x03a3 }
        r13 = "auto";
        r8 = r3;
        r9 = r10;
        r10 = r6;
        r8.<init>(r9, r10, r12, r13);	 Catch:{ all -> 0x03a3 }
        r1.zzb(r3, r2);	 Catch:{ all -> 0x03a3 }
        r3 = r20.zzayo();	 Catch:{ all -> 0x03a3 }
        r3.zzwj();	 Catch:{ all -> 0x03a3 }
        r20.zzyk();	 Catch:{ all -> 0x03a3 }
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r3.<init>();	 Catch:{ all -> 0x03a3 }
        r8 = "_c";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r8 = "_r";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r14 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r9 = "_v";
        r10 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r10.<init>(r3);	 Catch:{ all -> 0x03a3 }
        r11 = "auto";
        r8 = r14;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
        goto L_0x0318;
    L_0x035c:
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r3.<init>();	 Catch:{ all -> 0x03a3 }
        r8 = "_et";
        r3.putLong(r8, r4);	 Catch:{ all -> 0x03a3 }
        r4 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r9 = "_e";
        r10 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r10.<init>(r3);	 Catch:{ all -> 0x03a3 }
        r11 = "auto";
        r8 = r4;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
    L_0x0376:
        r1.zzb(r4, r2);	 Catch:{ all -> 0x03a3 }
        goto L_0x0394;
    L_0x037a:
        r3 = r2.zzjgj;	 Catch:{ all -> 0x03a3 }
        if (r3 == 0) goto L_0x0394;
    L_0x037e:
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x03a3 }
        r3.<init>();	 Catch:{ all -> 0x03a3 }
        r4 = new com.google.android.gms.internal.zzcix;	 Catch:{ all -> 0x03a3 }
        r9 = "_cd";
        r10 = new com.google.android.gms.internal.zzciu;	 Catch:{ all -> 0x03a3 }
        r10.<init>(r3);	 Catch:{ all -> 0x03a3 }
        r11 = "auto";
        r8 = r4;
        r12 = r6;
        r8.<init>(r9, r10, r11, r12);	 Catch:{ all -> 0x03a3 }
        goto L_0x0376;
    L_0x0394:
        r2 = r20.zzayj();	 Catch:{ all -> 0x03a3 }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x03a3 }
        r2 = r20.zzayj();
        r2.endTransaction();
        return;
    L_0x03a3:
        r0 = move-exception;
        r2 = r0;
        r3 = r20.zzayj();
        r3.endTransaction();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzf(com.google.android.gms.internal.zzcif):void");
    }

    @WorkerThread
    final void zzj(Runnable runnable) {
        zzayo().zzwj();
        if (this.zzjou == null) {
            this.zzjou = new ArrayList();
        }
        this.zzjou.add(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A:{Splitter: B:1:0x000f, ExcHandler: java.util.concurrent.TimeoutException (r0_4 'e' java.util.concurrent.TimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A:{Splitter: B:1:0x000f, ExcHandler: java.util.concurrent.TimeoutException (r0_4 'e' java.util.concurrent.TimeoutException)} */
    /* JADX WARNING: Missing block: B:4:0x0018, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0019, code:
            zzayp().zzbau().zze("Failed to get app instance id. appId", com.google.android.gms.internal.zzcjj.zzjs(r5), r0);
     */
    /* JADX WARNING: Missing block: B:6:0x002b, code:
            return null;
     */
    public final java.lang.String zzkf(java.lang.String r5) {
        /*
        r4 = this;
        r0 = r4.zzayo();
        r1 = new com.google.android.gms.internal.zzckl;
        r1.<init>(r4, r5);
        r0 = r0.zzc(r1);
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ TimeoutException -> 0x0018, TimeoutException -> 0x0018, TimeoutException -> 0x0018 }
        r0 = r0.get(r1, r3);	 Catch:{ TimeoutException -> 0x0018, TimeoutException -> 0x0018, TimeoutException -> 0x0018 }
        r0 = (java.lang.String) r0;	 Catch:{ TimeoutException -> 0x0018, TimeoutException -> 0x0018, TimeoutException -> 0x0018 }
        return r0;
    L_0x0018:
        r0 = move-exception;
        r1 = r4.zzayp();
        r1 = r1.zzbau();
        r2 = "Failed to get app instance id. appId";
        r5 = com.google.android.gms.internal.zzcjj.zzjs(r5);
        r1.zze(r2, r5, r0);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckj.zzkf(java.lang.String):java.lang.String");
    }

    public final zze zzxx() {
        return this.zzdir;
    }

    final void zzyk() {
        if (!this.initialized) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
