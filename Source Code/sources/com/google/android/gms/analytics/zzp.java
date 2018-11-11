package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzaql;
import com.google.android.gms.internal.zzaqy;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.internal.zzarn;
import com.google.android.gms.internal.zzasy;
import com.google.android.gms.internal.zzatt;
import java.util.HashMap;
import java.util.Map;

final class zzp implements Runnable {
    private /* synthetic */ Map zzdwb;
    private /* synthetic */ boolean zzdwc;
    private /* synthetic */ String zzdwd;
    private /* synthetic */ long zzdwe;
    private /* synthetic */ boolean zzdwf;
    private /* synthetic */ boolean zzdwg;
    private /* synthetic */ String zzdwh;
    private /* synthetic */ Tracker zzdwi;

    zzp(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.zzdwi = tracker;
        this.zzdwb = map;
        this.zzdwc = z;
        this.zzdwd = str;
        this.zzdwe = j;
        this.zzdwf = z2;
        this.zzdwg = z3;
        this.zzdwh = str2;
    }

    public final void run() {
        if (this.zzdwi.zzdvy.zzwl()) {
            this.zzdwb.put("sc", "start");
        }
        zza zzyb = this.zzdwi.zzyb();
        zzbq.zzgw("getClientId can not be called from the main thread");
        zzatt.zzc(this.zzdwb, "cid", zzyb.zzvr().zzyq().zzzp());
        String str = (String) this.zzdwb.get("sf");
        if (str != null) {
            double zza = zzatt.zza(str, 100.0d);
            if (zzatt.zza(zza, (String) this.zzdwb.get("cid"))) {
                this.zzdwi.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                return;
            }
        }
        zzaqy zzb = this.zzdwi.zzb();
        if (this.zzdwc) {
            zzatt.zzb(this.zzdwb, "ate", zzb.zzxg());
            zzatt.zzb(this.zzdwb, "adid", zzb.zzxn());
        } else {
            this.zzdwb.remove("ate");
            this.zzdwb.remove("adid");
        }
        zzaql zzzd = this.zzdwi.zzc().zzzd();
        zzatt.zzb(this.zzdwb, "an", zzzd.zzwn());
        zzatt.zzb(this.zzdwb, "av", zzzd.zzwo());
        zzatt.zzb(this.zzdwb, "aid", zzzd.getAppId());
        zzatt.zzb(this.zzdwb, "aiid", zzzd.zzwp());
        this.zzdwb.put("v", "1");
        this.zzdwb.put("_v", zzarj.zzdyr);
        zzatt.zzb(this.zzdwb, "ul", this.zzdwi.zze().zzaah().getLanguage());
        zzatt.zzb(this.zzdwb, "sr", this.zzdwi.zze().zzaai());
        Object obj = (this.zzdwd.equals("transaction") || this.zzdwd.equals("item")) ? 1 : null;
        if (obj != null || this.zzdwi.zzdvx.zzaas()) {
            long zzeo = zzatt.zzeo((String) this.zzdwb.get("ht"));
            if (zzeo == 0) {
                zzeo = this.zzdwe;
            }
            long j = zzeo;
            if (this.zzdwf) {
                this.zzdwi.zzh().zzc("Dry run enabled. Would have sent hit", new zzasy(this.zzdwi, this.zzdwb, j, this.zzdwg));
                return;
            }
            String str2 = (String) this.zzdwb.get("cid");
            Map hashMap = new HashMap();
            zzatt.zza(hashMap, "uid", this.zzdwb);
            zzatt.zza(hashMap, "an", this.zzdwb);
            zzatt.zza(hashMap, "aid", this.zzdwb);
            zzatt.zza(hashMap, "av", this.zzdwb);
            zzatt.zza(hashMap, "aiid", this.zzdwb);
            this.zzdwb.put("_s", String.valueOf(this.zzdwi.zzj().zza(new zzarn(0, str2, this.zzdwh, TextUtils.isEmpty((CharSequence) this.zzdwb.get("adid")) ^ 1, 0, hashMap))));
            this.zzdwi.zzj().zza(new zzasy(this.zzdwi, this.zzdwb, j, this.zzdwg));
            return;
        }
        this.zzdwi.zzh().zzf(this.zzdwb, "Too many hits sent too quickly, rate limiting invoked");
    }
}
