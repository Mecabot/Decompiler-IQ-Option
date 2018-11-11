package com.appsflyer;

import android.support.annotation.NonNull;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AFLogger {
    private static long pm = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int ॱ;

        private LogLevel(int i) {
            this.ॱ = i;
        }

        public final int getLevel() {
            return this.ॱ;
        }
    }

    public static void a(String str, boolean z) {
        if ((LogLevel.INFO.getLevel() <= i.fF().getInt("logLevel", LogLevel.NONE.getLevel()) ? 1 : null) != null) {
            Log.i("AppsFlyer_4.8.15", b(str, false));
        }
        if (z) {
            ah.ge().h("I", b(str, true));
        }
    }

    public static void fy() {
        pm = System.currentTimeMillis();
    }

    @NonNull
    private static String b(String str, boolean z) {
        if (!z && LogLevel.VERBOSE.getLevel() > i.fF().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(g(System.currentTimeMillis() - pm));
        stringBuilder.append(") [");
        stringBuilder.append(Thread.currentThread().getName());
        stringBuilder.append("] ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static void a(String str, Throwable th, boolean z) {
        if ((LogLevel.ERROR.getLevel() <= i.fF().getInt("logLevel", LogLevel.NONE.getLevel()) ? 1 : null) != null && z) {
            Log.e("AppsFlyer_4.8.15", b(str, false), th);
        }
        ah.ge().b(th);
    }

    static void aj(String str) {
        if ((LogLevel.WARNING.getLevel() <= i.fF().getInt("logLevel", LogLevel.NONE.getLevel()) ? 1 : null) != null) {
            Log.w("AppsFlyer_4.8.15", b(str, false));
        }
        ah.ge().h("W", b(str, true));
    }

    public static void ak(String str) {
        if ((LogLevel.VERBOSE.getLevel() <= i.fF().getInt("logLevel", LogLevel.NONE.getLevel()) ? 1 : null) != null) {
            Log.v("AppsFlyer_4.8.15", b(str, false));
        }
        ah.ge().h("V", b(str, true));
    }

    public static void an(String str) {
        a(str, true);
    }

    public static void a(String str, Throwable th) {
        a(str, th, false);
    }

    public static void ao(String str) {
        aj(str);
    }

    private static String g(long j) {
        long toMillis = j - TimeUnit.HOURS.toMillis(TimeUnit.MILLISECONDS.toHours(j));
        long toMillis2 = toMillis - TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(toMillis));
        toMillis = TimeUnit.MILLISECONDS.toMillis(toMillis2 - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(toMillis2)));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(r0), Long.valueOf(j), Long.valueOf(r2), Long.valueOf(toMillis)});
    }

    static void al(String str) {
        if (!i.fF().fJ()) {
            Log.d("AppsFlyer_4.8.15", b(str, false));
        }
        ah.ge().h("F", str);
    }

    public static void am(String str) {
        if ((LogLevel.DEBUG.getLevel() <= i.fF().getInt("logLevel", LogLevel.NONE.getLevel()) ? 1 : null) != null) {
            Log.d("AppsFlyer_4.8.15", b(str, false));
        }
        ah.ge().h("D", b(str, true));
    }
}
