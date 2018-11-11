package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcci extends zzcce<Long> {
    public zzcci(int i, String str, Long l) {
        super(0, str, l, null);
    }

    private final Long zzd(zzccm zzccm) {
        try {
            return Long.valueOf(zzccm.getLongFlagValue(getKey(), ((Long) zzje()).longValue(), getSource()));
        } catch (RemoteException unused) {
            return (Long) zzje();
        }
    }
}
