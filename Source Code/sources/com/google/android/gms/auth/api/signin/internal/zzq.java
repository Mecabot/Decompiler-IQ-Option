package com.google.android.gms.auth.api.signin.internal;

public final class zzq {
    private static int zzenz = 31;
    private int zzeoa = 1;

    public final int zzacr() {
        return this.zzeoa;
    }

    public final zzq zzav(boolean z) {
        this.zzeoa = (zzenz * this.zzeoa) + z;
        return this;
    }

    public final zzq zzs(Object obj) {
        this.zzeoa = (zzenz * this.zzeoa) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}
