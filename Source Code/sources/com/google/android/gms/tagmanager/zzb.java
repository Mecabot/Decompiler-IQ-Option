package com.google.android.gms.tagmanager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzb implements zzd {
    private /* synthetic */ zza zzkms;

    zzb(zza zza) {
        this.zzkms = zza;
    }

    public final Info zzbfg() {
        Throwable e;
        String str;
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zzkms.mContext);
        } catch (IllegalStateException e2) {
            e = e2;
            str = "IllegalStateException getting Advertising Id Info";
            zzdj.zzc(str, e);
            return null;
        } catch (GooglePlayServicesRepairableException e3) {
            e = e3;
            str = "GooglePlayServicesRepairableException getting Advertising Id Info";
            zzdj.zzc(str, e);
            return null;
        } catch (IOException e4) {
            e = e4;
            str = "IOException getting Ad Id Info";
            zzdj.zzc(str, e);
            return null;
        } catch (GooglePlayServicesNotAvailableException e5) {
            e = e5;
            this.zzkms.close();
            str = "GooglePlayServicesNotAvailableException getting Advertising Id Info";
            zzdj.zzc(str, e);
            return null;
        } catch (Exception e6) {
            e = e6;
            str = "Unknown exception. Could not get the Advertising Id Info.";
            zzdj.zzc(str, e);
            return null;
        }
    }
}
