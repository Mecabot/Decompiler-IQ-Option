package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcit {
    final String name;
    final String zzcm;
    final long zzjhs;
    final long zzjht;
    final long zzjhu;
    final long zzjhv;
    final Long zzjhw;
    final Long zzjhx;
    final Boolean zzjhy;

    zzcit(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        zzbq.zzgv(str);
        zzbq.zzgv(str2);
        boolean z = false;
        zzbq.checkArgument(j5 >= 0);
        zzbq.checkArgument(j6 >= 0);
        if (j7 >= 0) {
            z = true;
        }
        zzbq.checkArgument(z);
        this.zzcm = str;
        this.name = str2;
        this.zzjhs = j5;
        this.zzjht = j6;
        this.zzjhu = j3;
        this.zzjhv = j7;
        this.zzjhw = l;
        this.zzjhx = l2;
        this.zzjhy = bool;
    }

    final zzcit zza(Long l, Long l2, Boolean bool) {
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        return new zzcit(this.zzcm, this.name, this.zzjhs, this.zzjht, this.zzjhu, this.zzjhv, l, l2, bool2);
    }

    final zzcit zzban() {
        String str = this.zzcm;
        String str2 = this.name;
        long j = this.zzjhs + 1;
        long j2 = this.zzjht + 1;
        long j3 = this.zzjhu;
        long j4 = this.zzjhv;
        return new zzcit(str, str2, j, j2, j3, j4, this.zzjhw, this.zzjhx, this.zzjhy);
    }

    final zzcit zzbb(long j) {
        return new zzcit(this.zzcm, this.name, this.zzjhs, this.zzjht, j, this.zzjhv, this.zzjhw, this.zzjhx, this.zzjhy);
    }

    final zzcit zzbc(long j) {
        return new zzcit(this.zzcm, this.name, this.zzjhs, this.zzjht, this.zzjhu, j, this.zzjhw, this.zzjhx, this.zzjhy);
    }
}
