package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zze;

@Hide
public class zzarh {
    private final zzark zzdyp;

    protected zzarh(zzark zzark) {
        zzbq.checkNotNull(zzark);
        this.zzdyp = zzark;
    }

    private final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzatd zzym = this.zzdyp != null ? this.zzdyp.zzym() : null;
        String str2;
        if (zzym != null) {
            str2 = (String) zzast.zzebn.get();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, zzc(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                zzym.zzb(i, str, obj, obj2, obj3);
            }
            return;
        }
        str2 = (String) zzast.zzebn.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
    }

    @Hide
    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        obj = zzm(obj);
        obj2 = zzm(obj2);
        obj3 = zzm(obj3);
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
        if (!TextUtils.isEmpty(obj3)) {
            stringBuilder.append(str3);
            stringBuilder.append(obj3);
        }
        return stringBuilder.toString();
    }

    private static String zzm(Object obj) {
        return obj == null ? "" : obj instanceof String ? (String) obj : obj instanceof Boolean ? obj == Boolean.TRUE ? "true" : "false" : obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
    }

    @Hide
    public static boolean zzqk() {
        return Log.isLoggable((String) zzast.zzebn.get(), 2);
    }

    @Hide
    protected final Context getContext() {
        return this.zzdyp.getContext();
    }

    @Hide
    public final void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    @Hide
    public final void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    @Hide
    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    @Hide
    public final void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    @Hide
    public final void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    @Hide
    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    @Hide
    public final void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    @Hide
    public final void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    @Hide
    public final void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    @Hide
    public final void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    @Hide
    public final void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    @Hide
    public final void zzea(String str) {
        zza(2, str, null, null, null);
    }

    @Hide
    public final void zzeb(String str) {
        zza(3, str, null, null, null);
    }

    @Hide
    public final void zzec(String str) {
        zza(4, str, null, null, null);
    }

    @Hide
    public final void zzed(String str) {
        zza(5, str, null, null, null);
    }

    @Hide
    public final void zzee(String str) {
        zza(6, str, null, null, null);
    }

    @Hide
    public final zzark zzxw() {
        return this.zzdyp;
    }

    @Hide
    protected final zze zzxx() {
        return this.zzdyp.zzxx();
    }

    @Hide
    /* renamed from: zzxy */
    protected final zzatd zzh() {
        return this.zzdyp.zzxy();
    }

    @Hide
    protected final zzasl zzxz() {
        return this.zzdyp.zzxz();
    }

    @Hide
    protected final zzk zzya() {
        return this.zzdyp.zzya();
    }

    @Hide
    public final GoogleAnalytics zzyb() {
        return this.zzdyp.zzyn();
    }

    @Hide
    /* renamed from: zzyc */
    protected final zzaqz zzj() {
        return this.zzdyp.zzyc();
    }

    @Hide
    protected final zzasq zzyd() {
        return this.zzdyp.zzyd();
    }

    @Hide
    protected final zzatu zzye() {
        return this.zzdyp.zzye();
    }

    @Hide
    protected final zzath zzyf() {
        return this.zzdyp.zzyf();
    }

    @Hide
    protected final zzasc zzyg() {
        return this.zzdyp.zzyq();
    }

    @Hide
    /* renamed from: zzyh */
    protected final zzaqy zzb() {
        return this.zzdyp.zzyp();
    }

    @Hide
    /* renamed from: zzyi */
    protected final zzarv zzc() {
        return this.zzdyp.zzyi();
    }

    @Hide
    /* renamed from: zzyj */
    protected final zzasp zze() {
        return this.zzdyp.zzyj();
    }
}
