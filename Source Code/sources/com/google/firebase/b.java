package com.google.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzca;
import com.google.android.gms.common.util.zzw;
import java.util.Arrays;

public final class b {
    private final String XD;
    private final String XE;
    private final String XF;
    private final String XG;
    private final String XH;
    private final String XI;
    private final String XJ;

    private b(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        zzbq.zza(zzw.zzhb(str) ^ 1, (Object) "ApplicationId must be set.");
        this.XE = str;
        this.XD = str2;
        this.XF = str3;
        this.XG = str4;
        this.XH = str5;
        this.XI = str6;
        this.XJ = str7;
    }

    public static b aA(Context context) {
        zzca zzca = new zzca(context);
        Object string = zzca.getString("google_app_id");
        return TextUtils.isEmpty(string) ? null : new b(string, zzca.getString("google_api_key"), zzca.getString("firebase_database_url"), zzca.getString("ga_trackingId"), zzca.getString("gcm_defaultSenderId"), zzca.getString("google_storage_bucket"), zzca.getString("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return zzbg.equal(this.XE, bVar.XE) && zzbg.equal(this.XD, bVar.XD) && zzbg.equal(this.XF, bVar.XF) && zzbg.equal(this.XG, bVar.XG) && zzbg.equal(this.XH, bVar.XH) && zzbg.equal(this.XI, bVar.XI) && zzbg.equal(this.XJ, bVar.XJ);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.XE, this.XD, this.XF, this.XG, this.XH, this.XI, this.XJ});
    }

    public final String it() {
        return this.XE;
    }

    public final String toString() {
        return zzbg.zzx(this).zzg("applicationId", this.XE).zzg("apiKey", this.XD).zzg("databaseUrl", this.XF).zzg("gcmSenderId", this.XH).zzg("storageBucket", this.XI).zzg("projectId", this.XJ).toString();
    }

    public final String wi() {
        return this.XH;
    }
}
