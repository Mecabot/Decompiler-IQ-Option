package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbia;
import com.google.android.gms.internal.zzcwn;

public interface zzb extends IInterface {
    void zza(int i, Bundle bundle, Bundle bundle2);

    @Hide
    void zza(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor);

    @Hide
    void zza(int i, Bundle bundle, zzbia zzbia);

    @Hide
    void zza(int i, zzcwn zzcwn);

    @Hide
    void zza(DataHolder dataHolder, String str);

    @Hide
    void zza(DataHolder dataHolder, String str, String str2);

    @Hide
    void zzaq(Status status);

    @Hide
    void zzk(int i, Bundle bundle);

    @Hide
    void zzlb(String str);

    @Hide
    void zzlc(String str);
}
