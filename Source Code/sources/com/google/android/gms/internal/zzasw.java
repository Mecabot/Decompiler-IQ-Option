package com.google.android.gms.internal;

final class zzasw implements zzask<zzasx> {
    private final zzark zzdyp;
    private final zzasx zzede = new zzasx();

    public zzasw(zzark zzark) {
        this.zzdyp = zzark;
    }

    public final void zzc(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.zzede.zzedh = z;
        } else {
            this.zzdyp.zzxy().zzd("Bool xml configuration name not recognized", str);
        }
    }

    public final void zzd(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.zzede.zzedg = i;
        } else {
            this.zzdyp.zzxy().zzd("Int xml configuration name not recognized", str);
        }
    }

    public final void zzi(String str, String str2) {
    }

    public final void zzj(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.zzede.zzdwo = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.zzede.zzdwp = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.zzede.zzedf = str2;
        } else {
            this.zzdyp.zzxy().zzd("String xml configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzasi zzzt() {
        return this.zzede;
    }
}
