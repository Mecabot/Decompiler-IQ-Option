package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class zzay {
    final String zzbkr;
    final byte[] zzkpc;

    zzay(String str, byte[] bArr) {
        this.zzbkr = str;
        this.zzkpc = bArr;
    }

    public final String toString() {
        String str = this.zzbkr;
        int hashCode = Arrays.hashCode(this.zzkpc);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 54);
        stringBuilder.append("KeyAndSerialized: key = ");
        stringBuilder.append(str);
        stringBuilder.append(" serialized hash = ");
        stringBuilder.append(hashCode);
        return stringBuilder.toString();
    }
}
