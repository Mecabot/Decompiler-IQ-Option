package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzari;
import com.google.android.gms.internal.zzark;
import com.google.android.gms.internal.zzatb;
import com.google.android.gms.internal.zzats;
import com.google.android.gms.internal.zzatt;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Tracker extends zzari {
    private final Map<String, String> zzbwu = new HashMap();
    private boolean zzdvv;
    private final Map<String, String> zzdvw = new HashMap();
    private final zzatb zzdvx;
    private final zza zzdvy;
    private ExceptionReporter zzdvz;
    private zzats zzdwa;

    class zza extends zzari implements zza {
        private boolean zzdwj;
        private int zzdwk;
        private long zzdwl = -1;
        private boolean zzdwm;
        private long zzdwn;

        protected zza(zzark zzark) {
            super(zzark);
        }

        private final void zzwm() {
            if (this.zzdwl >= 0 || this.zzdwj) {
                zzyb().zza(Tracker.this.zzdvy);
            } else {
                zzyb().zzb(Tracker.this.zzdvy);
            }
        }

        public final void enableAutoActivityTracking(boolean z) {
            this.zzdwj = z;
            zzwm();
        }

        public final void setSessionTimeout(long j) {
            this.zzdwl = j;
            zzwm();
        }

        public final void zzm(Activity activity) {
            if (this.zzdwk == 0) {
                if ((zzxx().elapsedRealtime() >= this.zzdwn + Math.max(1000, this.zzdwl) ? 1 : null) != null) {
                    this.zzdwm = true;
                }
            }
            this.zzdwk++;
            if (this.zzdwj) {
                String canonicalName;
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker tracker = Tracker.this;
                String str = "&cd";
                if (Tracker.this.zzdwa != null) {
                    zzats zzk = Tracker.this.zzdwa;
                    canonicalName = activity.getClass().getCanonicalName();
                    String str2 = (String) zzk.zzeex.get(canonicalName);
                    if (str2 != null) {
                        canonicalName = str2;
                    }
                } else {
                    canonicalName = activity.getClass().getCanonicalName();
                }
                tracker.set(str, canonicalName);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    zzbq.checkNotNull(activity);
                    Intent intent2 = activity.getIntent();
                    CharSequence charSequence = null;
                    if (intent2 != null) {
                        CharSequence stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            charSequence = stringExtra;
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        hashMap.put("&dr", charSequence);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        public final void zzn(Activity activity) {
            this.zzdwk--;
            this.zzdwk = Math.max(0, this.zzdwk);
            if (this.zzdwk == 0) {
                this.zzdwn = zzxx().elapsedRealtime();
            }
        }

        protected final void zzwk() {
        }

        public final synchronized boolean zzwl() {
            boolean z;
            z = this.zzdwm;
            this.zzdwm = false;
            return z;
        }
    }

    Tracker(zzark zzark, String str, zzatb zzatb) {
        super(zzark);
        if (str != null) {
            this.zzbwu.put("&tid", str);
        }
        this.zzbwu.put("useSecure", "1");
        this.zzbwu.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        this.zzdvx = new zzatb("tracking", zzxx());
        this.zzdvy = new zza(zzark);
    }

    private static String zza(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        Object obj = (!str.startsWith("&") || str.length() < 2) ? null : 1;
        return obj == null ? null : ((String) entry.getKey()).substring(1);
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzbq.checkNotNull(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zza = zza(entry);
                if (zza != null) {
                    map2.put(zza, (String) entry.getValue());
                }
            }
        }
    }

    private static void zzc(Map<String, String> map, Map<String, String> map2) {
        zzbq.checkNotNull(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zza = zza(entry);
                if (!(zza == null || map2.containsKey(zza))) {
                    map2.put(zza, (String) entry.getValue());
                }
            }
        }
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzdvv = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zzdvy.enableAutoActivityTracking(z);
    }

    public void enableExceptionReporting(boolean z) {
        synchronized (this) {
            if ((this.zzdvz != null) == z) {
                return;
            }
            String str;
            if (z) {
                this.zzdvz = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                Thread.setDefaultUncaughtExceptionHandler(this.zzdvz);
                str = "Uncaught exceptions will be reported to Google Analytics";
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.zzdvz.zzvv());
                str = "Uncaught exceptions will not be reported to Google Analytics";
            }
            zzea(str);
        }
    }

    public String get(String str) {
        zzyk();
        return TextUtils.isEmpty(str) ? null : this.zzbwu.containsKey(str) ? (String) this.zzbwu.get(str) : str.equals("&ul") ? zzatt.zza(Locale.getDefault()) : str.equals("&cid") ? zzyg().zzzp() : str.equals("&sr") ? zze().zzaai() : str.equals("&aid") ? zzc().zzzd().getAppId() : str.equals("&an") ? zzc().zzzd().zzwn() : str.equals("&av") ? zzc().zzzd().zzwo() : str.equals("&aiid") ? zzc().zzzd().zzwp() : null;
    }

    public void send(Map<String, String> map) {
        long currentTimeMillis = zzxx().currentTimeMillis();
        if (zzyb().getAppOptOut()) {
            zzeb("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzyb().isDryRunEnabled();
        Map hashMap = new HashMap();
        zzb(this.zzbwu, hashMap);
        zzb(map, hashMap);
        boolean zzd = zzatt.zzd((String) this.zzbwu.get("useSecure"), true);
        zzc(this.zzdvw, hashMap);
        this.zzdvw.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzh().zzf(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzh().zzf(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.zzdvv;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.zzbwu.get("&a")) + 1;
                if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                    parseInt = 1;
                }
                this.zzbwu.put("&a", Integer.toString(parseInt));
            }
        }
        zzya().zzd(new zzp(this, hashMap, z, str, currentTimeMillis, isDryRunEnabled, zzd, str2));
    }

    public void set(String str, String str2) {
        zzbq.checkNotNull(str, "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.zzbwu.put(str, str2);
        }
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzatt.zzao(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                uri = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = uri.getQueryParameter("utm_id");
                if (str != null) {
                    this.zzdvw.put("&ci", str);
                }
                str = uri.getQueryParameter("anid");
                if (str != null) {
                    this.zzdvw.put("&anid", str);
                }
                str = uri.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.zzdvw.put("&cn", str);
                }
                str = uri.getQueryParameter("utm_content");
                if (str != null) {
                    this.zzdvw.put("&cc", str);
                }
                str = uri.getQueryParameter("utm_medium");
                if (str != null) {
                    this.zzdvw.put("&cm", str);
                }
                str = uri.getQueryParameter("utm_source");
                if (str != null) {
                    this.zzdvw.put("&cs", str);
                }
                str = uri.getQueryParameter("utm_term");
                if (str != null) {
                    this.zzdvw.put("&ck", str);
                }
                str = uri.getQueryParameter("dclid");
                if (str != null) {
                    this.zzdvw.put("&dclid", str);
                }
                str = uri.getQueryParameter("gclid");
                if (str != null) {
                    this.zzdvw.put("&gclid", str);
                }
                valueOf = uri.getQueryParameter(b.ACLID);
                if (valueOf != null) {
                    this.zzdvw.put("&aclid", valueOf);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            set("&sr", stringBuilder.toString());
            return;
        }
        zzed("Invalid width or height. The values should be non-negative.");
    }

    public void setSessionTimeout(long j) {
        this.zzdvy.setSessionTimeout(j * 1000);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzatt.zzao(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    final void zza(zzats zzats) {
        String str;
        boolean z;
        zzea("Loading Tracker config values");
        this.zzdwa = zzats;
        boolean z2 = false;
        if ((this.zzdwa.zzdub != null ? 1 : null) != null) {
            str = this.zzdwa.zzdub;
            set("&tid", str);
            zza("trackingId loaded", str);
        }
        if ((this.zzdwa.zzees >= 0.0d ? 1 : null) != null) {
            str = Double.toString(this.zzdwa.zzees);
            set("&sf", str);
            zza("Sample frequency loaded", str);
        }
        if ((this.zzdwa.zzeet >= 0 ? 1 : null) != null) {
            int i = this.zzdwa.zzeet;
            setSessionTimeout((long) i);
            zza("Session timeout loaded", Integer.valueOf(i));
        }
        if (this.zzdwa.zzeeu != -1) {
            z = this.zzdwa.zzeeu == 1;
            enableAutoActivityTracking(z);
            zza("Auto activity tracking loaded", Boolean.valueOf(z));
        }
        if (this.zzdwa.zzeev != -1) {
            z = this.zzdwa.zzeev == 1;
            if (z) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(z));
        }
        if (this.zzdwa.zzeew == 1) {
            z2 = true;
        }
        enableExceptionReporting(z2);
    }

    @Hide
    protected final void zzwk() {
        this.zzdvy.initialize();
        String zzwn = zzye().zzwn();
        if (zzwn != null) {
            set("&an", zzwn);
        }
        zzwn = zzye().zzwo();
        if (zzwn != null) {
            set("&av", zzwn);
        }
    }
}
