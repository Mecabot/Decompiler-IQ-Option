package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzbfl extends zzm<Status, zzbfn> {
    private final zze zzfqh;

    zzbfl(zze zze, GoogleApiClient googleApiClient) {
        super(ClearcutLogger.API, googleApiClient);
        this.zzfqh = zze;
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        zzbfn zzbfn = (zzbfn) zzb;
        zzbfp zzbfm = new zzbfm(this);
        try {
            zze zze = this.zzfqh;
            if (zze.zzfpm != null && zze.zzfpt.zzpzb.length == 0) {
                zze.zzfpt.zzpzb = zze.zzfpm.zzahc();
            }
            if (zze.zzfqg != null && zze.zzfpt.zzpzi.length == 0) {
                zze.zzfpt.zzpzi = zze.zzfqg.zzahc();
            }
            zze.zzfqa = zzfls.zzc(zze.zzfpt);
            ((zzbfr) zzbfn.zzalw()).zza(zzbfm, this.zzfqh);
        } catch (Throwable e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            zzu(new Status(10, "MessageProducer"));
        }
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
