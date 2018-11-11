package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzarv extends zzari {
    private final zzaql zzdvo = new zzaql();

    zzarv(zzark zzark) {
        super(zzark);
    }

    protected final void zzwk() {
        zzya().zzwh().zzb(this.zzdvo);
        zzatu zzye = zzye();
        String zzwn = zzye.zzwn();
        if (zzwn != null) {
            this.zzdvo.setAppName(zzwn);
        }
        String zzwo = zzye.zzwo();
        if (zzwo != null) {
            this.zzdvo.setAppVersion(zzwo);
        }
    }

    public final zzaql zzzd() {
        zzyk();
        return this.zzdvo;
    }
}
