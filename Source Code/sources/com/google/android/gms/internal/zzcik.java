package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzu;
import java.lang.reflect.InvocationTargetException;

@Hide
public final class zzcik extends zzclh {
    private Boolean zzeba;

    zzcik(zzckj zzckj) {
        super(zzckj);
    }

    public static long zzazs() {
        return ((Long) zzciz.zzjjq.get()).longValue();
    }

    public static long zzazt() {
        return ((Long) zzciz.zzjiq.get()).longValue();
    }

    public static boolean zzazv() {
        return ((Boolean) zzciz.zzjil.get()).booleanValue();
    }

    public final long zza(String str, zzcja<Long> zzcja) {
        if (str != null) {
            Object zzam = zzaym().zzam(str, zzcja.getKey());
            if (!TextUtils.isEmpty(zzam)) {
                try {
                    return ((Long) zzcja.get(Long.valueOf(Long.valueOf(zzam).longValue()))).longValue();
                } catch (NumberFormatException unused) {
                    return ((Long) zzcja.get()).longValue();
                }
            }
        }
    }

    public final boolean zzazr() {
        Boolean zzjf = zzjf("firebase_analytics_collection_deactivated");
        return zzjf != null && zzjf.booleanValue();
    }

    public final String zzazu() {
        Object e;
        zzcjl zzbau;
        String str;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e2) {
            e = e2;
            zzbau = zzayp().zzbau();
            str = "Could not find SystemProperties class";
            zzbau.zzj(str, e);
            return "";
        } catch (NoSuchMethodException e3) {
            e = e3;
            zzbau = zzayp().zzbau();
            str = "Could not find SystemProperties.get() method";
            zzbau.zzj(str, e);
            return "";
        } catch (IllegalAccessException e4) {
            e = e4;
            zzbau = zzayp().zzbau();
            str = "Could not access SystemProperties.get()";
            zzbau.zzj(str, e);
            return "";
        } catch (InvocationTargetException e5) {
            e = e5;
            zzbau = zzayp().zzbau();
            str = "SystemProperties.get() threw an exception";
            zzbau.zzj(str, e);
            return "";
        }
    }

    public final int zzb(String str, zzcja<Integer> zzcja) {
        if (str != null) {
            Object zzam = zzaym().zzam(str, zzcja.getKey());
            if (!TextUtils.isEmpty(zzam)) {
                try {
                    return ((Integer) zzcja.get(Integer.valueOf(Integer.valueOf(zzam).intValue()))).intValue();
                } catch (NumberFormatException unused) {
                    return ((Integer) zzcja.get()).intValue();
                }
            }
        }
    }

    public final boolean zzc(String str, zzcja<Boolean> zzcja) {
        Object zzam;
        if (str != null) {
            zzam = zzaym().zzam(str, zzcja.getKey());
            if (!TextUtils.isEmpty(zzam)) {
                zzam = zzcja.get(Boolean.valueOf(Boolean.parseBoolean(zzam)));
                return ((Boolean) zzam).booleanValue();
            }
        }
        zzam = zzcja.get();
        return ((Boolean) zzam).booleanValue();
    }

    public final int zzje(@Size(min = 1) String str) {
        return zzb(str, zzciz.zzjjb);
    }

    @Nullable
    final Boolean zzjf(@Size(min = 1) String str) {
        zzbq.zzgv(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzayp().zzbau().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = zzbih.zzdd(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzayp().zzbau().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData != null) {
                return !applicationInfo.metaData.containsKey(str) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                zzayp().zzbau().log("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        } catch (NameNotFoundException e) {
            zzayp().zzbau().zzj("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzjg(String str) {
        return "1".equals(zzaym().zzam(str, "gaia_collection_enabled"));
    }

    final boolean zzjh(String str) {
        return zzc(str, zzciz.zzjju);
    }

    public final boolean zzzu() {
        if (this.zzeba == null) {
            synchronized (this) {
                if (this.zzeba == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzany = zzu.zzany();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzany);
                        this.zzeba = Boolean.valueOf(z);
                    }
                    if (this.zzeba == null) {
                        this.zzeba = Boolean.TRUE;
                        zzayp().zzbau().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzeba.booleanValue();
    }
}
