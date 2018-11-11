package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzccj extends zzcce<String> {
    public zzccj(int i, String str, String str2) {
        super(0, str, str2, null);
    }

    private final String zze(zzccm zzccm) {
        try {
            return zzccm.getStringFlagValue(getKey(), (String) zzje(), getSource());
        } catch (RemoteException unused) {
            return (String) zzje();
        }
    }
}
