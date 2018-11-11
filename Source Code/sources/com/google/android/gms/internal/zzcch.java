package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcch extends zzcce<Integer> {
    public zzcch(int i, String str, Integer num) {
        super(0, str, num, null);
    }

    private final Integer zzc(zzccm zzccm) {
        try {
            return Integer.valueOf(zzccm.getIntFlagValue(getKey(), ((Integer) zzje()).intValue(), getSource()));
        } catch (RemoteException unused) {
            return (Integer) zzje();
        }
    }
}
