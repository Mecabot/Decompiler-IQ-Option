package com.microblink.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
/* compiled from: line */
public class Log {
    private static int dYS = LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal();
    private static a dYT;

    /* compiled from: line */
    public enum LogLevel {
        LOG_WARNINGS_AND_ERRORS,
        LOG_INFORMATION,
        LOG_DEBUG,
        LOG_VERBOSE
    }

    /* compiled from: line */
    public interface a {
        void a(String str, String str2, String str3, Throwable th);
    }

    public static LogLevel aQb() {
        return LogLevel.values()[dYS];
    }

    private static String format(String str, Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = str.split("(?<!\\\\)\\{\\}", -1);
        int i = 0;
        int i2 = 0;
        while (i < split.length) {
            int i3 = i + 1;
            stringBuilder.append(split[i]);
            if (i3 < split.length) {
                if (i2 >= objArr.length) {
                    stringBuilder = new StringBuilder("missing parameter for log message '");
                    stringBuilder.append(str);
                    stringBuilder.append("'");
                    throw new RuntimeException(stringBuilder.toString());
                }
                i = i2 + 1;
                stringBuilder.append(objArr[i2]);
                i2 = i;
            }
            i = i3;
        }
        return stringBuilder.toString();
    }

    public static int getLineNumber() {
        return Thread.currentThread().getStackTrace().length > 5 ? Thread.currentThread().getStackTrace()[5].getLineNumber() : -1;
    }

    public static String getThreadName() {
        StringBuilder stringBuilder = new StringBuilder("@");
        stringBuilder.append(Thread.currentThread().getName());
        return stringBuilder.toString();
    }

    private static String bQ(Object obj) {
        String str;
        StringBuilder stringBuilder;
        if (obj == null) {
            str = "";
        } else if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Class) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Class) obj).getSimpleName());
            stringBuilder.append(".java");
            str = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj.getClass().getSimpleName());
            stringBuilder.append(".java");
            str = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(getLineNumber());
        stringBuilder.append(getThreadName());
        return stringBuilder.toString();
    }

    private static void b(String str, String str2, String str3, Throwable th) {
        if (dYT != null) {
            dYT.a(str, str2, str3, th);
        }
    }

    public static void a(Object obj, String str, Object... objArr) {
        if (dYS >= LogLevel.LOG_DEBUG.ordinal()) {
            String bQ = bQ(obj);
            str = format(str, objArr);
            android.util.Log.d(bQ, str);
            b("[D]", bQ, str, null);
        }
    }

    public static void b(Object obj, String str, Object... objArr) {
        String bQ = bQ(obj);
        str = format(str, objArr);
        android.util.Log.e(bQ, str);
        b("[E]", bQ, str, null);
    }

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        String bQ = bQ(obj);
        str = format(str, objArr);
        android.util.Log.e(bQ, str, th);
        b("[E]", bQ, str, th);
    }

    public static void c(Object obj, String str, Object... objArr) {
        String bQ = bQ(obj);
        str = format(str, objArr);
        android.util.Log.w(bQ, str);
        b("[W]", bQ, str, null);
    }

    public static void b(Object obj, Throwable th, String str, Object... objArr) {
        String bQ = bQ(obj);
        str = format(str, objArr);
        android.util.Log.w(bQ, str, th);
        b("[W]", bQ, str, th);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static void d(Object obj, String str, Object... objArr) {
        String bQ = bQ(obj);
        str = format(str, objArr);
        if (VERSION.SDK_INT >= 8) {
            android.util.Log.wtf(bQ, str);
        } else {
            android.util.Log.e(bQ, str);
        }
        b("[WTF]", bQ, str, null);
    }

    public static void e(Object obj, String str, Object... objArr) {
        if (dYS >= LogLevel.LOG_VERBOSE.ordinal()) {
            String bQ = bQ(obj);
            str = format(str, objArr);
            android.util.Log.v(bQ, str);
            b("[V]", bQ, str, null);
        }
    }

    public static void f(Object obj, String str, Object... objArr) {
        if (dYS >= LogLevel.LOG_INFORMATION.ordinal()) {
            String bQ = bQ(obj);
            str = format(str, objArr);
            android.util.Log.i(bQ, str);
            b("[I]", bQ, str, null);
        }
    }
}
