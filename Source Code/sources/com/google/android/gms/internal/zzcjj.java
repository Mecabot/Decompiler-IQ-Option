package com.google.android.gms.internal;

import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzcjj extends zzcli {
    private long zzjft = -1;
    private char zzjkg = 0;
    @GuardedBy("this")
    private String zzjkh;
    private final zzcjl zzjki = new zzcjl(this, 6, false, false);
    private final zzcjl zzjkj = new zzcjl(this, 6, true, false);
    private final zzcjl zzjkk = new zzcjl(this, 6, false, true);
    private final zzcjl zzjkl = new zzcjl(this, 5, false, false);
    private final zzcjl zzjkm = new zzcjl(this, 5, true, false);
    private final zzcjl zzjkn = new zzcjl(this, 5, false, true);
    private final zzcjl zzjko = new zzcjl(this, 4, false, false);
    private final zzcjl zzjkp = new zzcjl(this, 3, false, false);
    private final zzcjl zzjkq = new zzcjl(this, 2, false, false);

    zzcjj(zzckj zzckj) {
        super(zzckj);
    }

    @Hide
    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        obj = zzb(z, obj);
        obj2 = zzb(z, obj2);
        Object zzb = zzb(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "";
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
            str3 = ": ";
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(str3);
            stringBuilder.append(obj);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder.append(str3);
            stringBuilder.append(obj2);
            str3 = ", ";
        }
        if (!TextUtils.isEmpty(zzb)) {
            stringBuilder.append(str3);
            stringBuilder.append(zzb);
        }
        return stringBuilder.toString();
    }

    @Hide
    private static String zzb(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        String valueOf;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(round);
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(round2);
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof zzcjm ? ((zzcjm) obj).zzgim : z ? "-" : String.valueOf(obj);
            } else {
                Throwable th = (Throwable) obj;
                StringBuilder stringBuilder2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                valueOf = zzjt(AppMeasurement.class.getCanonicalName());
                String zzjt = zzjt(zzckj.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = zzjt(className);
                            if (className.equals(valueOf) || className.equals(zzjt)) {
                                stringBuilder2.append(": ");
                                stringBuilder2.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                return stringBuilder2.toString();
            }
        }
    }

    private final String zzbbb() {
        String str;
        synchronized (this) {
            if (this.zzjkh == null) {
                this.zzjkh = (String) zzciz.zzjin.get();
            }
            str = this.zzjkh;
        }
        return str;
    }

    protected static Object zzjs(String str) {
        return str == null ? null : new zzcjm(str);
    }

    private static String zzjt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzae(i)) {
            zzm(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            String str2;
            zzbq.checkNotNull(str);
            zzcli zzbbp = this.zzjev.zzbbp();
            if (zzbbp == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (zzbbp.isInitialized()) {
                if (i < 0) {
                    i = 0;
                }
                zzbbp.zzh(new zzcjk(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            } else {
                str2 = "Scheduler not initialized. Not logging error/warn";
            }
            zzm(6, str2);
        }
    }

    protected final boolean zzae(int i) {
        return Log.isLoggable(zzbbb(), i);
    }

    protected final boolean zzazq() {
        return false;
    }

    public final zzcjl zzbau() {
        return this.zzjki;
    }

    public final zzcjl zzbav() {
        return this.zzjkj;
    }

    public final zzcjl zzbaw() {
        return this.zzjkl;
    }

    public final zzcjl zzbax() {
        return this.zzjkn;
    }

    public final zzcjl zzbay() {
        return this.zzjko;
    }

    public final zzcjl zzbaz() {
        return this.zzjkp;
    }

    public final zzcjl zzbba() {
        return this.zzjkq;
    }

    public final String zzbbc() {
        Pair zzabh = zzayq().zzjlm.zzabh();
        if (zzabh == null || zzabh == zzcju.zzjlk) {
            return null;
        }
        String valueOf = String.valueOf(zzabh.second);
        String str = (String) zzabh.first;
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length());
        stringBuilder.append(valueOf);
        stringBuilder.append(":");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    @Hide
    protected final void zzm(int i, String str) {
        Log.println(i, zzbbb(), str);
    }
}
