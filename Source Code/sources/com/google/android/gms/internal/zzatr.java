package com.google.android.gms.internal;

final class zzatr extends zzarh implements zzask<zzats> {
    private final zzats zzeer = new zzats();

    public zzatr(zzark zzark) {
        super(zzark);
    }

    public final void zzc(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zzeer.zzeeu = z;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zzeer.zzeev = z;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.zzeer.zzeew = z;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    public final void zzd(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zzeer.zzeet = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }

    public final void zzi(String str, String str2) {
        this.zzeer.zzeex.put(str, str2);
    }

    public final void zzj(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zzeer.zzdub = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zzeer.zzees = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
            }
        } else {
            zzd("string configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzasi zzzt() {
        return this.zzeer;
    }
}
