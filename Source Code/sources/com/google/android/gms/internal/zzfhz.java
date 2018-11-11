package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzfhz {
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static ByteBuffer zzpqm;
    private static zzfhb zzpqn = zzfhb.zzbb(EMPTY_BYTE_ARRAY);

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        zzpqm = ByteBuffer.wrap(bArr);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        return zza == 0 ? 1 : zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (i = i2; i < i2 + i3; i++) {
            i4 = (i4 * 31) + bArr[i];
        }
        return i4;
    }

    static <T> T zzc(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int zzdf(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzdo(boolean z) {
        return z ? 1231 : 1237;
    }

    static boolean zzh(zzfjc zzfjc) {
        return false;
    }
}
