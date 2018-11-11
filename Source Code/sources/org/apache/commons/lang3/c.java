package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: StringUtils */
public class c {
    private static final Pattern faa = Pattern.compile("\\s+");
    private static boolean fab = false;
    private static Method fac = null;
    private static final Pattern fad = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    private static boolean fae = false;
    private static Method faf;
    private static Object fag;
    private static final Pattern fah = fad;

    static {
        try {
            fag = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer$Form").getField("NFD").get(null);
            faf = Thread.currentThread().getContextClassLoader().loadClass("java.text.Normalizer").getMethod("normalize", new Class[]{CharSequence.class, r3});
            fae = true;
        } catch (ClassNotFoundException unused) {
            fae = false;
        } catch (NoSuchFieldException unused2) {
            fae = false;
        } catch (IllegalAccessException unused3) {
            fae = false;
        } catch (NoSuchMethodException unused4) {
            fae = false;
        }
        try {
            fac = Thread.currentThread().getContextClassLoader().loadClass("sun.text.Normalizer").getMethod("decompose", new Class[]{String.class, Boolean.TYPE, Integer.TYPE});
            fab = true;
        } catch (ClassNotFoundException unused5) {
            fab = false;
        } catch (NoSuchMethodException unused6) {
            fab = false;
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean M(CharSequence charSequence) {
        if (charSequence != null) {
            int length = charSequence.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(charSequence.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static boolean T(CharSequence charSequence) {
        return M(charSequence) ^ 1;
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String nh(String str) {
        str = trim(str);
        return isEmpty(str) ? null : str;
    }

    public static String[] split(String str, String str2) {
        return a(str, str2, -1, false);
    }

    private static String[] a(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return a.EMPTY_STRING_ARRAY;
        }
        int i2;
        int i3;
        Object obj;
        List arrayList = new ArrayList();
        int i4;
        Object obj2;
        int i5;
        if (str2 == null) {
            int i6 = 0;
            Object obj3 = null;
            i2 = 1;
            i4 = 0;
            loop0:
            while (true) {
                obj2 = null;
                while (i6 < length) {
                    if (Character.isWhitespace(str.charAt(i6))) {
                        if (obj3 != null || z) {
                            Object obj4;
                            i3 = i2 + 1;
                            if (i2 == i) {
                                i6 = length;
                                obj4 = null;
                            } else {
                                obj4 = 1;
                            }
                            arrayList.add(str.substring(i4, i6));
                            obj2 = obj4;
                            i2 = i3;
                            obj3 = null;
                        }
                        i4 = i6 + 1;
                        i6 = i4;
                    } else {
                        i6++;
                        obj3 = 1;
                    }
                }
                break loop0;
            }
            i2 = i4;
            obj = obj3;
            i3 = i6;
        } else if (str2.length() == 1) {
            char charAt = str2.charAt(0);
            i3 = 0;
            i2 = 0;
            obj = null;
            obj2 = null;
            i5 = 1;
            while (i3 < length) {
                if (str.charAt(i3) == charAt) {
                    if (obj != null || z) {
                        i4 = i5 + 1;
                        if (i5 == i) {
                            i3 = length;
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        arrayList.add(str.substring(i2, i3));
                        i5 = i4;
                        obj = null;
                    }
                    i2 = i3 + 1;
                    i3 = i2;
                } else {
                    i3++;
                    obj = 1;
                    obj2 = null;
                }
            }
        } else {
            i3 = 0;
            i2 = 0;
            obj = null;
            obj2 = null;
            i5 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (obj != null || z) {
                        i4 = i5 + 1;
                        if (i5 == i) {
                            i3 = length;
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        arrayList.add(str.substring(i2, i3));
                        i5 = i4;
                        obj = null;
                    }
                    i2 = i3 + 1;
                    i3 = i2;
                } else {
                    i3++;
                    obj = 1;
                    obj2 = null;
                }
            }
        }
        if (obj != null || (z && r7 != null)) {
            arrayList.add(str.substring(i2, i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String ni(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                int i3 = i + 1;
                cArr[i] = str.charAt(i2);
                i = i3;
            }
        }
        if (i == length) {
            return str;
        }
        return new String(cArr, 0, i);
    }

    public static String d(char c, int i) {
        char[] cArr = new char[i];
        for (i--; i >= 0; i--) {
            cArr[i] = c;
        }
        return new String(cArr);
    }

    public static String a(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return f(str, i, String.valueOf(c));
        }
        return str.concat(d(c, length));
    }

    public static String f(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        int i2 = 0;
        if (length == 1 && length2 <= 8192) {
            return a(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] toCharArray = str2.toCharArray();
        while (i2 < length2) {
            cArr[i2] = toCharArray[i2 % length];
            i2++;
        }
        return str.concat(new String(cArr));
    }

    public static String b(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return g(str, i, String.valueOf(c));
        }
        return d(c, length).concat(str);
    }

    public static String g(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        int i2 = 0;
        if (length == 1 && length2 <= 8192) {
            return b(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] toCharArray = str2.toCharArray();
        while (i2 < length2) {
            cArr[i2] = toCharArray[i2 % length];
            i2++;
        }
        return new String(cArr).concat(str);
    }
}
