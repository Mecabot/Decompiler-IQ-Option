package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzbb implements zzby {
    private static final Object zzkmq = new Object();
    private static zzbb zzkpe;
    private zzek zzkns;
    private zzbz zzkpf;

    private zzbb(Context context) {
        this(zzca.zzen(context), new zzfm());
    }

    private zzbb(zzbz zzbz, zzek zzek) {
        this.zzkpf = zzbz;
        this.zzkns = zzek;
    }

    public static zzby zzeh(Context context) {
        zzby zzby;
        synchronized (zzkmq) {
            if (zzkpe == null) {
                zzkpe = new zzbb(context);
            }
            zzby = zzkpe;
        }
        return zzby;
    }

    public final boolean zzlr(String str) {
        if (this.zzkns.zzaas()) {
            this.zzkpf.zzlw(str);
            return true;
        }
        zzdj.zzcz("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
