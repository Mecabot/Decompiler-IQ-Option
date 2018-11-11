package org.apache.commons.lang3;

/* compiled from: ArrayUtils */
public class a {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final double[] aPh = new double[0];
    public static final long[] aPi = new long[0];
    public static final int[] aPj = new int[0];
    public static final Object[] eZF = new Object[0];
    public static final Class<?>[] eZG = new Class[0];
    public static final Long[] eZH = new Long[0];
    public static final Integer[] eZI = new Integer[0];
    public static final short[] eZJ = new short[0];
    public static final Short[] eZK = new Short[0];
    public static final Byte[] eZL = new Byte[0];
    public static final Double[] eZM = new Double[0];
    public static final float[] eZN = new float[0];
    public static final Float[] eZO = new Float[0];
    public static final boolean[] eZP = new boolean[0];
    public static final Boolean[] eZQ = new Boolean[0];
    public static final char[] eZR = new char[0];
    public static final Character[] eZS = new Character[0];

    public static byte[] aj(byte[] bArr) {
        return bArr == null ? null : (byte[]) bArr.clone();
    }

    public static byte[] r(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        i2 -= i;
        if (i2 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return a(objArr, obj, 0);
    }

    public static int a(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (obj == null) {
            while (i < objArr.length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i < objArr.length) {
                if (obj.equals(objArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static boolean b(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static byte[] b(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return aj(bArr2);
        }
        if (bArr2 == null) {
            return aj(bArr);
        }
        Object obj = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
        return obj;
    }
}
