package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.support.annotation.NonNull;

/* compiled from: PackageManagerHelper */
public class e {
    public static void a(@NonNull Context context, @NonNull Class cls, boolean z) {
        String str;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            String str2 = "PackageManagerHelper";
            str = "%s %s";
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? "enabled" : "disabled";
            androidx.work.e.b(str2, String.format(str, objArr), new Throwable[0]);
        } catch (Exception e) {
            str = "PackageManagerHelper";
            String str3 = "%s could not be %s";
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            objArr2[1] = z ? "enabled" : "disabled";
            androidx.work.e.b(str, String.format(str3, objArr2), e);
        }
    }
}
