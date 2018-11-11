package com.noveogroup.android.log;

/* compiled from: Utils */
public final class g {
    private static final String PACKAGE_NAME = Logger.class.getPackage().getName();
    private static final a ecg = new a();

    /* compiled from: Utils */
    private static final class a extends SecurityManager {
        private a() {
        }
    }

    private static StackTraceElement aRG() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        Object obj = null;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (obj == null) {
                if (stackTraceElement.getClassName().startsWith(PACKAGE_NAME)) {
                    obj = 1;
                }
            } else if (!stackTraceElement.getClassName().startsWith(PACKAGE_NAME)) {
                return stackTraceElement;
            }
        }
        return stackTrace[stackTrace.length - 1];
    }

    public static StackTraceElement aRH() {
        return aRG();
    }

    public static String d(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (Math.abs(i2) < str.length()) {
            str = i2 < 0 ? str.substring(str.length() + i2, str.length()) : i2 > 0 ? str.substring(0, i2) : str;
        }
        if (Math.abs(i) <= str.length()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%");
        stringBuilder.append(i);
        stringBuilder.append("s");
        return String.format(stringBuilder.toString(), new Object[]{str});
    }

    public static String e(String str, int i, int i2) {
        str = U(str, i);
        if (str == null) {
            return null;
        }
        if (i2 == 0 || i2 > str.length()) {
            return str;
        }
        int i3 = 0;
        StringBuilder stringBuilder;
        int length;
        if (i2 < 0) {
            i2 = -i2;
            stringBuilder = new StringBuilder();
            length = str.length() - 1;
            while (length > 0) {
                int lastIndexOf = str.lastIndexOf(46, length);
                if (lastIndexOf != -1) {
                    if (stringBuilder.length() > 0 && (stringBuilder.length() + ((length + 1) - lastIndexOf)) + 1 > i2) {
                        stringBuilder.insert(0, '*');
                        break;
                    }
                    stringBuilder.insert(0, str.substring(lastIndexOf, length + 1));
                } else if (stringBuilder.length() > 0 && (stringBuilder.length() + length) + 1 > i2) {
                    stringBuilder.insert(0, '*');
                    break;
                } else {
                    stringBuilder.insert(0, str.substring(0, length + 1));
                }
                length = lastIndexOf - 1;
            }
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        while (i3 < str.length()) {
            length = str.indexOf(46, i3);
            if (length != -1) {
                if (stringBuilder.length() > 0 && length + 1 > i2) {
                    stringBuilder.insert(stringBuilder.length(), '*');
                    break;
                }
                length++;
                stringBuilder.insert(stringBuilder.length(), str.substring(i3, length));
                i3 = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(stringBuilder.length(), '*');
            } else {
                stringBuilder.insert(stringBuilder.length(), str.substring(i3, str.length()));
            }
        }
        return stringBuilder.toString();
    }

    private static String U(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 1;
        if (i > 0) {
            int i3 = 0;
            while (i3 < str.length()) {
                int indexOf = str.indexOf(46, i3);
                if (indexOf == -1) {
                    stringBuilder.insert(stringBuilder.length(), str.substring(i3, str.length()));
                    break;
                } else if (i2 == i) {
                    stringBuilder.insert(stringBuilder.length(), str.substring(i3, indexOf));
                    break;
                } else {
                    indexOf++;
                    stringBuilder.insert(stringBuilder.length(), str.substring(i3, indexOf));
                    i2++;
                    i3 = indexOf;
                }
            }
        } else if (i < 0) {
            String U = U(str, -i);
            if (str.equals(U)) {
                stringBuilder.insert(stringBuilder.length(), str.substring(str.lastIndexOf(46) + 1, str.length()));
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(U);
                stringBuilder.append('.');
                return str.replaceFirst(stringBuilder.toString(), "");
            }
        }
        return stringBuilder.toString();
    }
}
