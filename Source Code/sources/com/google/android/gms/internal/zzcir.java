package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzcir extends zzcli {
    private long zzjhn;
    private String zzjho;
    private Boolean zzjhp;

    zzcir(zzckj zzckj) {
        super(zzckj);
    }

    protected final boolean zzazq() {
        Calendar instance = Calendar.getInstance();
        this.zzjhn = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String toLowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String toLowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(toLowerCase).length() + 1) + String.valueOf(toLowerCase2).length());
        stringBuilder.append(toLowerCase);
        stringBuilder.append("-");
        stringBuilder.append(toLowerCase2);
        this.zzjho = stringBuilder.toString();
        return false;
    }

    public final long zzbal() {
        zzyk();
        return this.zzjhn;
    }

    public final String zzbam() {
        zzyk();
        return this.zzjho;
    }

    public final boolean zzec(Context context) {
        if (this.zzjhp == null) {
            this.zzjhp = Boolean.valueOf(false);
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zzjhp = Boolean.valueOf(true);
                }
            } catch (NameNotFoundException unused) {
                return this.zzjhp.booleanValue();
            }
        }
    }
}
