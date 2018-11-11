package com.google.android.gms.auth;

import android.os.IBinder;
import com.google.android.gms.internal.zzez;
import java.util.List;

final class zzg implements zzj<List<AccountChangeEvent>> {
    private /* synthetic */ String zzehv;
    private /* synthetic */ int zzehw;

    zzg(String str, int i) {
        this.zzehv = str;
        this.zzehw = i;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) {
        return ((AccountChangeEventsResponse) zzd.zzp(zzez.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(this.zzehv).setEventIndex(this.zzehw)))).getEvents();
    }
}
