package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzu;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzasl {
    private final zzark zzdtw;
    private volatile Boolean zzeba;
    private String zzebb;
    private Set<Integer> zzebc;

    protected zzasl(zzark zzark) {
        zzbq.checkNotNull(zzark);
        this.zzdtw = zzark;
    }

    public static int zzaaa() {
        return ((Integer) zzast.zzeca.get()).intValue();
    }

    public static String zzaab() {
        return (String) zzast.zzecc.get();
    }

    public static String zzaac() {
        return (String) zzast.zzecb.get();
    }

    public static String zzaad() {
        return (String) zzast.zzecd.get();
    }

    public static long zzaaf() {
        return ((Long) zzast.zzecr.get()).longValue();
    }

    public static boolean zzzv() {
        return ((Boolean) zzast.zzebm.get()).booleanValue();
    }

    public static int zzzw() {
        return ((Integer) zzast.zzecj.get()).intValue();
    }

    public static long zzzx() {
        return ((Long) zzast.zzebu.get()).longValue();
    }

    public static long zzzy() {
        return ((Long) zzast.zzebx.get()).longValue();
    }

    public static int zzzz() {
        return ((Integer) zzast.zzebz.get()).intValue();
    }

    public final Set<Integer> zzaae() {
        String str = (String) zzast.zzecm.get();
        if (this.zzebc == null || this.zzebb == null || !this.zzebb.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            int length = split.length;
            int i = 0;
            while (i < length) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(split[i])));
                } catch (NumberFormatException unused) {
                    i++;
                }
            }
            this.zzebb = str;
            this.zzebc = hashSet;
        }
        return this.zzebc;
    }

    public final boolean zzzu() {
        if (this.zzeba == null) {
            synchronized (this) {
                if (this.zzeba == null) {
                    ApplicationInfo applicationInfo = this.zzdtw.getContext().getApplicationInfo();
                    String zzany = zzu.zzany();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzany);
                        this.zzeba = Boolean.valueOf(z);
                    }
                    if ((this.zzeba == null || !this.zzeba.booleanValue()) && "com.google.android.gms.analytics".equals(zzany)) {
                        this.zzeba = Boolean.TRUE;
                    }
                    if (this.zzeba == null) {
                        this.zzeba = Boolean.TRUE;
                        this.zzdtw.zzxy().zzee("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzeba.booleanValue();
    }
}
