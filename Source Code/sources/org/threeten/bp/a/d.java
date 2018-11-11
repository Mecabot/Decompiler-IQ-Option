package org.threeten.bp.a;

/* compiled from: Jdk8Methods */
public final class d {
    public static int C(long j, long j2) {
        return j < j2 ? -1 : j > j2 ? 1 : 0;
    }

    public static int bu(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" must not be null");
        throw new NullPointerException(stringBuilder.toString());
    }

    public static boolean equals(Object obj, Object obj2) {
        boolean z = false;
        if (obj != null) {
            return obj2 == null ? false : obj.equals(obj2);
        } else {
            if (obj2 == null) {
                z = true;
            }
            return z;
        }
    }

    public static int bv(int i, int i2) {
        int i3 = i + i2;
        if ((i ^ i3) >= 0 || (i ^ i2) < 0) {
            return i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Addition overflows an int: ");
        stringBuilder.append(i);
        stringBuilder.append(" + ");
        stringBuilder.append(i2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long D(long j, long j2) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Addition overflows a long: ");
        stringBuilder.append(j);
        stringBuilder.append(" + ");
        stringBuilder.append(j2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static int bw(int i, int i2) {
        int i3 = i - i2;
        if ((i ^ i3) >= 0 || (i ^ i2) >= 0) {
            return i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Subtraction overflows an int: ");
        stringBuilder.append(i);
        stringBuilder.append(" - ");
        stringBuilder.append(i2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long E(long j, long j2) {
        long j3 = j - j2;
        if ((j ^ j3) >= 0 || (j ^ j2) >= 0) {
            return j3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Subtraction overflows a long: ");
        stringBuilder.append(j);
        stringBuilder.append(" - ");
        stringBuilder.append(j2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long j(long j, int i) {
        StringBuilder stringBuilder;
        switch (i) {
            case -1:
                if (j != Long.MIN_VALUE) {
                    return -j;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Multiplication overflows a long: ");
                stringBuilder.append(j);
                stringBuilder.append(" * ");
                stringBuilder.append(i);
                throw new ArithmeticException(stringBuilder.toString());
            case 0:
                return 0;
            case 1:
                return j;
            default:
                long j2 = (long) i;
                long j3 = j * j2;
                if (j3 / j2 == j) {
                    return j3;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Multiplication overflows a long: ");
                stringBuilder.append(j);
                stringBuilder.append(" * ");
                stringBuilder.append(i);
                throw new ArithmeticException(stringBuilder.toString());
        }
    }

    public static long F(long j, long j2) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Multiplication overflows a long: ");
        stringBuilder.append(j);
        stringBuilder.append(" * ");
        stringBuilder.append(j2);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static int ek(long j) {
        if (j <= 2147483647L && j >= -2147483648L) {
            return (int) j;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calculation overflows an int: ");
        stringBuilder.append(j);
        throw new ArithmeticException(stringBuilder.toString());
    }

    public static long floorDiv(long j, long j2) {
        return j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
    }

    public static long floorMod(long j, long j2) {
        return ((j % j2) + j2) % j2;
    }

    public static int k(long j, int i) {
        long j2 = (long) i;
        return (int) (((j % j2) + j2) % j2);
    }
}
