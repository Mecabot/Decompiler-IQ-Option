package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.People.LoadPeopleResult;

final class zzj extends zza {
    private final zzn<LoadPeopleResult> zziul;

    public zzj(zzn<LoadPeopleResult> zzn) {
        this.zziul = zzn;
    }

    public final void zza(DataHolder dataHolder, String str) {
        Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzahs() != null ? (PendingIntent) dataHolder.zzahs().getParcelable("pendingIntent") : null);
        if (!(status.isSuccess() || dataHolder == null)) {
            if (!dataHolder.isClosed()) {
                dataHolder.close();
            }
            dataHolder = null;
        }
        this.zziul.setResult(new zzi(status, dataHolder, str));
    }
}
