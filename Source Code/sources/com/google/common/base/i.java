package com.google.common.base;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.iqoption.dto.Currencies;

/* compiled from: Preconditions */
public final class i {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j)));
        }
    }

    public static void a(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj));
        }
    }

    public static void a(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j), obj));
        }
    }

    public static void a(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, obj2));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(format(str, objArr));
        }
    }

    public static void b(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j)));
        }
    }

    public static void b(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, obj));
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int s(int i, int i2) {
        return a(i, i2, b.INDEX);
    }

    public static int a(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(b(i, i2, str));
    }

    private static String b(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("negative size: ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static int t(int i, int i2) {
        return c(i, i2, b.INDEX);
    }

    public static int c(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(d(i, i2, str));
    }

    private static String d(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("negative size: ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void g(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(h(i, i2, i3));
        }
    }

    private static String h(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return d(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return d(i2, i3, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String format(String str, Object... objArr) {
        CharSequence valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        }
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf(Currencies.REPLACE_CURRENCY_MASK, i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf, i2, indexOf);
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            stringBuilder.append(" [");
            int i4 = i + 1;
            stringBuilder.append(objArr[i]);
            while (i4 < objArr.length) {
                stringBuilder.append(", ");
                i = i4 + 1;
                stringBuilder.append(objArr[i4]);
                i4 = i;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
