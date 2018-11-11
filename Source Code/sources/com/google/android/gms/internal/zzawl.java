package com.google.android.gms.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.api.Status;

public interface zzawl extends IInterface {
    void onFailure(Status status);

    void zza(DeviceMetaData deviceMetaData);

    void zza(Status status, zzl zzl);

    void zza(Status status, zzt zzt);

    void zzaby();

    void zze(Status status);

    void zzh(byte[] bArr);
}
