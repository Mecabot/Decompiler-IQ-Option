package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzatu extends zzari {
    private boolean zzdum;
    private String zzdwo;
    private String zzdwp;
    private int zzebd;
    protected int zzedg;
    protected boolean zzeez;
    private boolean zzefa;

    public zzatu(zzark zzark) {
        super(zzark);
    }

    public final boolean zzabm() {
        zzyk();
        return false;
    }

    public final boolean zzabn() {
        zzyk();
        return this.zzefa;
    }

    public final boolean zzabo() {
        zzyk();
        return this.zzdum;
    }

    protected final void zzwk() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzed("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzasx zzasx = (zzasx) new zzasv(zzxw()).zzav(i);
                if (zzasx != null) {
                    String str;
                    int i2;
                    zzea("Loading global XML config values");
                    boolean z = false;
                    if ((zzasx.zzdwo != null ? 1 : null) != null) {
                        str = zzasx.zzdwo;
                        this.zzdwo = str;
                        zzb("XML config - app name", str);
                    }
                    if ((zzasx.zzdwp != null ? 1 : null) != null) {
                        str = zzasx.zzdwp;
                        this.zzdwp = str;
                        zzb("XML config - app version", str);
                    }
                    if ((zzasx.zzedf != null ? 1 : null) != null) {
                        str = zzasx.zzedf.toLowerCase();
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.zzebd = i2;
                            zza("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if ((zzasx.zzedg >= 0 ? 1 : null) != null) {
                        i2 = zzasx.zzedg;
                        this.zzedg = i2;
                        this.zzeez = true;
                        zzb("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (zzasx.zzedh != -1) {
                        if (zzasx.zzedh == 1) {
                            z = true;
                        }
                        this.zzdum = z;
                        this.zzefa = true;
                        zzb("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }

    public final String zzwn() {
        zzyk();
        return this.zzdwo;
    }

    public final String zzwo() {
        zzyk();
        return this.zzdwp;
    }
}
