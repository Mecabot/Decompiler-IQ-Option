package com.iqoption.util;

import android.os.Build.VERSION;

/* compiled from: PackageNameUtil */
public class ax {
    public static final boolean dwr = (VERSION.SDK_INT == 21);
    public static final boolean dws = (VERSION.SDK_INT >= 21);
    public static final boolean dwt = (VERSION.SDK_INT >= 19);
    public static final boolean dwu;

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 26) {
            z = true;
        }
        dwu = z;
    }
}
