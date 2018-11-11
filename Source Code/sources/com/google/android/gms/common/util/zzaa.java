package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.internal.zzbih;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzaa {
    private static final Method zzgli = zzanz();
    private static final Method zzglj = zzaoa();
    private static final Method zzglk = zzaob();
    private static final Method zzgll = zzaoc();
    private static final Method zzglm = zzaod();

    private static int zza(WorkSource workSource) {
        if (zzglk != null) {
            try {
                return ((Integer) zzglk.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    @Nullable
    private static String zza(WorkSource workSource, int i) {
        if (zzglm != null) {
            try {
                return (String) zzglm.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    private static Method zzanz() {
        try {
            return WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzaoa() {
        if (zzs.zzanu()) {
            try {
                return WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE, String.class});
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private static Method zzaob() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzaoc() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method zzaod() {
        if (zzs.zzanu()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static List<String> zzb(@Nullable WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.emptyList();
        }
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzw.zzhb(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static boolean zzda(Context context) {
        return (context == null || context.getPackageManager() == null || zzbih.zzdd(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        if (zzglj != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzglj.invoke(workSource, new Object[]{Integer.valueOf(i), str});
                return workSource;
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                return workSource;
            }
        }
        if (zzgli != null) {
            zzgli.invoke(workSource, new Object[]{Integer.valueOf(i)});
        }
        return workSource;
    }

    @Nullable
    public static WorkSource zzw(Context context, @Nullable String str) {
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        String str2;
        String str3;
        try {
            ApplicationInfo applicationInfo = zzbih.zzdd(context).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zze(applicationInfo.uid, str);
            }
            str2 = "WorkSourceUtil";
            str3 = "Could not get applicationInfo from package: ";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
            return null;
        } catch (NameNotFoundException unused) {
            str2 = "WorkSourceUtil";
            str3 = "Could not find package: ";
            str = String.valueOf(str);
            Log.e(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
            return null;
        }
    }
}
