package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;

public final class zzp {
    private static zzp zzenv;
    private zzaa zzenw;
    private GoogleSignInAccount zzenx = this.zzenw.zzacx();
    private GoogleSignInOptions zzeny = this.zzenw.zzacy();

    private zzp(Context context) {
        this.zzenw = zzaa.zzbs(context);
    }

    public static synchronized zzp zzbq(@NonNull Context context) {
        zzp zzbr;
        synchronized (zzp.class) {
            zzbr = zzbr(context.getApplicationContext());
        }
        return zzbr;
    }

    private static synchronized zzp zzbr(Context context) {
        zzp zzp;
        synchronized (zzp.class) {
            if (zzenv == null) {
                zzenv = new zzp(context);
            }
            zzp = zzenv;
        }
        return zzp;
    }

    public final synchronized void clear() {
        this.zzenw.clear();
        this.zzenx = null;
        this.zzeny = null;
    }

    public final synchronized void zza(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        zzaa zzaa = this.zzenw;
        zzbq.checkNotNull(googleSignInAccount);
        zzbq.checkNotNull(googleSignInOptions);
        zzaa.zzo("defaultGoogleSignInAccount", googleSignInAccount.zzace());
        zzaa.zza(googleSignInAccount, googleSignInOptions);
        this.zzenx = googleSignInAccount;
        this.zzeny = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzacp() {
        return this.zzenx;
    }

    public final synchronized GoogleSignInOptions zzacq() {
        return this.zzeny;
    }
}
