package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Hide
public final class zzb {
    public static <T> ArrayList<T> zza(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r0);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static void zza(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    public static void zza(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void zza(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    public static void zza(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"");
            stringBuilder.append(strArr[i]);
            stringBuilder.append("\"");
        }
    }

    public static void zza(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }

    public static byte[] zza(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        Object copyOf = Arrays.copyOf(bArr[0], i);
        i = bArr[0].length;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            Object obj = bArr[i2];
            System.arraycopy(obj, 0, copyOf, i, obj.length);
            i += obj.length;
        }
        return copyOf;
    }

    public static <T> T[] zza(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (tArr2.length == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        int i;
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        if (tArr2.length == 1) {
            i = 0;
            for (Object obj : tArr) {
                if (!zzbg.equal(tArr2[0], obj)) {
                    int i2 = i + 1;
                    tArr3[i] = obj;
                    i = i2;
                }
            }
        } else {
            int i3 = 0;
            for (Object obj2 : tArr) {
                int length = tArr2.length;
                int i4 = 0;
                while (i4 < length) {
                    if (zzbg.equal(tArr2[i4], obj2)) {
                        break;
                    }
                    i4++;
                }
                i4 = -1;
                if ((i4 >= 0 ? 1 : null) == null) {
                    length = i3 + 1;
                    tArr3[i3] = obj2;
                    i3 = length;
                }
            }
            i = i3;
        }
        if (tArr3 == null) {
            return null;
        }
        if (i != tArr3.length) {
            tArr3 = Arrays.copyOf(tArr3, i);
        }
        return tArr3;
    }

    public static Integer[] zzb(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
