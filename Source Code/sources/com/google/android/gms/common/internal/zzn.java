package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

@Hide
public final class zzn extends zze {
    private /* synthetic */ zzd zzgfk;
    private IBinder zzgfo;

    @BinderThread
    public zzn(zzd zzd, int i, IBinder iBinder, Bundle bundle) {
        this.zzgfk = zzd;
        super(zzd, i, bundle);
        this.zzgfo = iBinder;
    }

    protected final boolean zzama() {
        boolean z = false;
        try {
            String interfaceDescriptor = this.zzgfo.getInterfaceDescriptor();
            if (this.zzgfk.zzhn().equals(interfaceDescriptor)) {
                IInterface zzd = this.zzgfk.zzd(this.zzgfo);
                if (zzd != null && (this.zzgfk.zza(2, 4, zzd) || this.zzgfk.zza(3, 4, zzd))) {
                    this.zzgfk.zzgff = null;
                    Bundle zzagp = this.zzgfk.zzagp();
                    if (this.zzgfk.zzgfb != null) {
                        this.zzgfk.zzgfb.onConnected(zzagp);
                    }
                    z = true;
                }
                return z;
            }
            String zzhn = this.zzgfk.zzhn();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(zzhn).length() + 34) + String.valueOf(interfaceDescriptor).length());
            stringBuilder.append("service descriptor mismatch: ");
            stringBuilder.append(zzhn);
            stringBuilder.append(" vs. ");
            stringBuilder.append(interfaceDescriptor);
            Log.e("GmsClient", stringBuilder.toString());
            return false;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    protected final void zzj(ConnectionResult connectionResult) {
        if (this.zzgfk.zzgfc != null) {
            this.zzgfk.zzgfc.onConnectionFailed(connectionResult);
        }
        this.zzgfk.onConnectionFailed(connectionResult);
    }
}
