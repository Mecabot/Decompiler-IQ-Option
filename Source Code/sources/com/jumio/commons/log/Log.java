package com.jumio.commons.log;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.File;

public class Log {
    public static final String TAG = "JumioMobileSDK";
    private static FileAppender fileAppender;
    private static LogLevel logLevel = LogLevel.OFF;

    public enum LogLevel {
        OFF,
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public static void allowFileLogging(Context context, boolean z) {
        if (z) {
            fileAppender = new FileAppender(context);
        } else if (fileAppender != null) {
            fileAppender.destroy();
            fileAppender = null;
        }
    }

    public static boolean isFileLoggingActivated() {
        return fileAppender != null;
    }

    public static void setLogLevel(LogLevel logLevel) {
        logLevel = logLevel;
    }

    public static LogLevel getLogLevel() {
        return logLevel;
    }

    public static boolean isLogEnabledForLevel(LogLevel logLevel) {
        return !logLevel.equals(LogLevel.OFF) && logLevel.ordinal() <= logLevel.ordinal();
    }

    public static void i(String str) {
        i("JumioMobileSDK", str);
    }

    public static void i(String str, Throwable th) {
        i("JumioMobileSDK", str, th);
    }

    public static void i(String str, String str2) {
        if (isLogEnabledForLevel(LogLevel.INFO)) {
            android.util.Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (isLogEnabledForLevel(LogLevel.INFO)) {
            android.util.Log.i(str, str2, th);
        }
    }

    public static void i(String str, File file, String str2) {
        i("JumioMobileSDK", str);
        if (fileAppender != null && isLogEnabledForLevel(LogLevel.INFO)) {
            fileAppender.logString(str, file, str2);
        }
    }

    public static void e(String str) {
        e("JumioMobileSDK", str);
    }

    public static void e(String str, Throwable th) {
        e("JumioMobileSDK", str, th);
    }

    public static void e(String str, String str2) {
        if (isLogEnabledForLevel(LogLevel.ERROR)) {
            android.util.Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isLogEnabledForLevel(LogLevel.ERROR)) {
            android.util.Log.e(str, str2, th);
        }
    }

    public static void e(String str, File file, String str2) {
        e("JumioMobileSDK", str);
        if (fileAppender != null && isLogEnabledForLevel(LogLevel.ERROR)) {
            fileAppender.dumpStringToFile(str, file, str2);
        }
    }

    public static void d(String str) {
        d("JumioMobileSDK", str);
    }

    public static void d(String str, Throwable th) {
        d("JumioMobileSDK", str, th);
    }

    public static void d(String str, String str2) {
        if (isLogEnabledForLevel(LogLevel.DEBUG)) {
            android.util.Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isLogEnabledForLevel(LogLevel.DEBUG)) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void d(String str, File file, String str2) {
        d("JumioMobileSDK", str);
        if (fileAppender != null && isLogEnabledForLevel(LogLevel.DEBUG)) {
            fileAppender.dumpStringToFile(str, file, str2);
        }
    }

    public static void v(String str) {
        v("JumioMobileSDK", str);
    }

    public static void v(String str, Throwable th) {
        v("JumioMobileSDK", str, th);
    }

    public static void v(String str, String str2) {
        if (isLogEnabledForLevel(LogLevel.VERBOSE)) {
            android.util.Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (isLogEnabledForLevel(LogLevel.VERBOSE)) {
            android.util.Log.v(str, str2, th);
        }
    }

    public static void v(String str, File file, String str2) {
        v("JumioMobileSDK", str);
        if (fileAppender != null && isLogEnabledForLevel(LogLevel.VERBOSE)) {
            fileAppender.dumpStringToFile(str, file, str2);
        }
    }

    public static void w(String str) {
        w("JumioMobileSDK", str);
    }

    public static void w(String str, Throwable th) {
        w("JumioMobileSDK", str, th);
    }

    public static void w(String str, String str2) {
        if (isLogEnabledForLevel(LogLevel.WARN)) {
            android.util.Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isLogEnabledForLevel(LogLevel.WARN)) {
            android.util.Log.w(str, str2, th);
        }
    }

    public static void w(String str, File file, String str2) {
        w("JumioMobileSDK", str);
        if (fileAppender != null && isLogEnabledForLevel(LogLevel.WARN)) {
            fileAppender.dumpStringToFile(str, file, str2);
        }
    }

    public static void printStackTrace(Throwable th) {
        if (!logLevel.equals(LogLevel.OFF)) {
            th.printStackTrace();
        }
    }

    public static void image(Bitmap bitmap, File file, String str) {
        image(bitmap, file, str, CompressFormat.JPEG, 80);
    }

    public static void image(Bitmap bitmap, File file, String str, CompressFormat compressFormat, int i) {
        if (logLevel.ordinal() <= LogLevel.DEBUG.ordinal() && fileAppender != null) {
            fileAppender.dumpBitmap(bitmap, file, str, compressFormat, i);
        }
    }

    public static void data(byte[] bArr, File file, String str) {
        if (logLevel.ordinal() <= LogLevel.DEBUG.ordinal() && fileAppender != null) {
            fileAppender.dumpRawBuffer(bArr, file, str, false);
        }
    }
}
