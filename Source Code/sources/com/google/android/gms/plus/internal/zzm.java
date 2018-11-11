package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;
import com.google.android.gms.plus.PlusOneDummyView;

public final class zzm extends zzp<zzd> {
    private static final zzm zzkhz = new zzm();

    private zzm() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View zza(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) zzn.zzy(((zzd) zzkhz.zzdg(context)).zza(zzn.zzz(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception unused) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected final /* synthetic */ Object zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
        return queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new zze(iBinder);
    }
}
