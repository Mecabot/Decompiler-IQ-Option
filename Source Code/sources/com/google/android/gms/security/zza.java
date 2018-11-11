package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zzf;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;

final class zza extends AsyncTask<Void, Void, Integer> {
    private /* synthetic */ Context val$context;
    private /* synthetic */ ProviderInstallListener zzklm;

    zza(Context context, ProviderInstallListener providerInstallListener) {
        this.val$context = context;
        this.zzklm = providerInstallListener;
    }

    private final Integer zzb(Void... voidArr) {
        int i;
        try {
            ProviderInstaller.installIfNeeded(this.val$context);
            i = 0;
        } catch (GooglePlayServicesRepairableException e) {
            i = e.getConnectionStatusCode();
        } catch (GooglePlayServicesNotAvailableException e2) {
            i = e2.errorCode;
        }
        return Integer.valueOf(i);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzklm.onProviderInstalled();
            return;
        }
        ProviderInstaller.zzklk;
        this.zzklm.onProviderInstallFailed(num.intValue(), zzf.zza(this.val$context, num.intValue(), "pi"));
    }
}
