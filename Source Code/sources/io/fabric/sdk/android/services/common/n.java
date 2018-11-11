package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.a.b;
import io.fabric.sdk.android.services.a.d;

/* compiled from: InstallerPackageNameProvider */
public class n {
    private final d<String> enm = new d<String>() {
        /* renamed from: cT */
        public String cy(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };
    private final b<String> enn = new b();

    public String Z(Context context) {
        try {
            String str = (String) this.enn.a(context, this.enm);
            if ("".equals(str)) {
                str = null;
            }
            return str;
        } catch (Throwable e) {
            c.aUg().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
