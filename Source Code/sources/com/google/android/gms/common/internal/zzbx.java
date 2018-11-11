package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;
import com.google.android.gms.dynamic.zzq;

public final class zzbx extends zzp<zzbd> {
    private static final zzbx zzgic = new zzbx();

    private zzbx() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzc(Context context, int i, int i2) {
        return zzgic.zzd(context, i, i2);
    }

    private final View zzd(Context context, int i, int i2) {
        try {
            zzbv zzbv = new zzbv(i, i2, null);
            return (View) zzn.zzy(((zzbd) zzdg(context)).zza(zzn.zzz(context), zzbv));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("Could not get button with size ");
            stringBuilder.append(i);
            stringBuilder.append(" and color ");
            stringBuilder.append(i2);
            throw new zzq(stringBuilder.toString(), e);
        }
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof zzbd ? (zzbd) queryLocalInterface : new zzbe(iBinder);
    }
}
