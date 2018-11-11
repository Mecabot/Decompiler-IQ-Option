package com.google.android.gms.plus.internal;

import android.os.IInterface;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzaq;
import java.util.List;

@Hide
public interface zzf extends IInterface {
    String getAccountName();

    zzaq zza(zzb zzb, int i, int i2, int i3, String str);

    void zza(zzb zzb);

    void zza(zzb zzb, List<String> list);

    void zzbem();
}
