package com.google.android.gms.tagmanager;

import android.text.TextUtils;

final class zzbx {
    private final long zzedk;
    private final long zzkpu;
    private final long zzkpv;
    private String zzkpw;

    zzbx(long j, long j2, long j3) {
        this.zzkpu = j;
        this.zzedk = j2;
        this.zzkpv = j3;
    }

    final long zzbgr() {
        return this.zzkpu;
    }

    final long zzbgs() {
        return this.zzkpv;
    }

    final String zzbgt() {
        return this.zzkpw;
    }

    final void zzlv(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzkpw = str;
        }
    }
}
