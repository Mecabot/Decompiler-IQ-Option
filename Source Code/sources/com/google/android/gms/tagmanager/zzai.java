package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.Random;

@Hide
public final class zzai {
    private final Context mContext;
    private final Random zzbje;
    private final String zzknc;

    public zzai(Context context, String str) {
        this(context, str, new Random());
    }

    @VisibleForTesting
    private zzai(Context context, String str, Random random) {
        this.mContext = (Context) zzbq.checkNotNull(context);
        this.zzknc = (String) zzbq.checkNotNull(str);
        this.zzbje = random;
    }

    private final SharedPreferences zzbga() {
        Context context = this.mContext;
        String valueOf = String.valueOf("_gtmContainerRefreshPolicy_");
        String valueOf2 = String.valueOf(this.zzknc);
        return context.getSharedPreferences(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), 0);
    }

    private final long zzg(long j, long j2) {
        SharedPreferences zzbga = zzbga();
        long max = Math.max(0, zzbga.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.zzbje.nextFloat() * ((float) (j + ((long) ((((float) max) / ((float) ((max + Math.max(0, zzbga.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j2 - j)))))));
    }

    public final long zzbfw() {
        return zzg(7200000, 259200000) + 43200000;
    }

    public final long zzbfx() {
        return zzg(600000, 86400000) + 3600000;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzbfy() {
        SharedPreferences zzbga = zzbga();
        long j = zzbga.getLong("FORBIDDEN_COUNT", 0);
        long j2 = zzbga.getLong("SUCCESSFUL_COUNT", 0);
        Editor edit = zzbga.edit();
        j = j == 0 ? 3 : Math.min(10, j + 1);
        long max = Math.max(0, Math.min(j2, 10 - j));
        edit.putLong("FORBIDDEN_COUNT", j);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzbfz() {
        SharedPreferences zzbga = zzbga();
        long j = zzbga.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = zzbga.getLong("FORBIDDEN_COUNT", 0);
        long min = Math.min(10, j + 1);
        long max = Math.max(0, Math.min(j2, 10 - min));
        Editor edit = zzbga.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }
}
