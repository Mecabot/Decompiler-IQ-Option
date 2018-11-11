package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzaf {
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static String TAG = "Volley";

    static class zza {
        public static final boolean zzbk = zzaf.DEBUG;
        private final List<zzag> zzbl = new ArrayList();
        private boolean zzbm = false;

        zza() {
        }

        protected final void finalize() {
            if (!this.zzbm) {
                zzc("Request on the loose");
                zzaf.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public final synchronized void zza(String str, long j) {
            if (this.zzbm) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzbl.add(new zzag(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void zzc(String str) {
            long j;
            this.zzbm = true;
            if (this.zzbl.size() == 0) {
                j = 0;
            } else {
                j = ((zzag) this.zzbl.get(this.zzbl.size() - 1)).time - ((zzag) this.zzbl.get(0)).time;
            }
            if (j > 0) {
                long j2 = ((zzag) this.zzbl.get(0)).time;
                zzaf.zzb("(%-4d ms) %s", Long.valueOf(j), str);
                for (zzag zzag : this.zzbl) {
                    zzaf.zzb("(+%-4d) [%2d] %s", Long.valueOf(zzag.time - j2), Long.valueOf(zzag.zzbn), zzag.name);
                    j2 = zzag.time;
                }
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(zzaf.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(methodName).length());
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(methodName);
                str2 = stringBuilder.toString();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
