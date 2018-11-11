package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzac implements OnCompleteListener<Map<zzh<?>, String>> {
    private /* synthetic */ zzaa zzfwu;

    private zzac(zzaa zzaa) {
        this.zzfwu = zzaa;
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        this.zzfwu.zzfwa.lock();
        try {
            if (this.zzfwu.zzfwp) {
                if (task.isSuccessful()) {
                    this.zzfwu.zzfwq = new ArrayMap(this.zzfwu.zzfwg.size());
                    for (zzz zzahv : this.zzfwu.zzfwg.values()) {
                        this.zzfwu.zzfwq.put(zzahv.zzahv(), ConnectionResult.zzfqt);
                    }
                } else {
                    zzaa zzaa;
                    ConnectionResult zzf;
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        if (this.zzfwu.zzfwn) {
                            this.zzfwu.zzfwq = new ArrayMap(this.zzfwu.zzfwg.size());
                            for (zzz zzz : this.zzfwu.zzfwg.values()) {
                                Map zzd;
                                zzh zzahv2 = zzz.zzahv();
                                Object connectionResult = availabilityException.getConnectionResult(zzz);
                                if (this.zzfwu.zza(zzz, (ConnectionResult) connectionResult)) {
                                    zzd = this.zzfwu.zzfwq;
                                    connectionResult = new ConnectionResult(16);
                                } else {
                                    zzd = this.zzfwu.zzfwq;
                                }
                                zzd.put(zzahv2, connectionResult);
                            }
                        } else {
                            this.zzfwu.zzfwq = availabilityException.zzahr();
                        }
                        zzaa = this.zzfwu;
                        zzf = this.zzfwu.zzajb();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        this.zzfwu.zzfwq = Collections.emptyMap();
                        zzaa = this.zzfwu;
                        zzf = new ConnectionResult(8);
                    }
                    zzaa.zzfwt = zzf;
                }
                if (this.zzfwu.zzfwr != null) {
                    this.zzfwu.zzfwq.putAll(this.zzfwu.zzfwr);
                    this.zzfwu.zzfwt = this.zzfwu.zzajb();
                }
                if (this.zzfwu.zzfwt == null) {
                    this.zzfwu.zzaiz();
                    this.zzfwu.zzaja();
                } else {
                    this.zzfwu.zzfwp = false;
                    this.zzfwu.zzfwj.zzc(this.zzfwu.zzfwt);
                }
                this.zzfwu.zzfwl.signalAll();
            }
            this.zzfwu.zzfwa.unlock();
        } catch (Throwable th) {
            this.zzfwu.zzfwa.unlock();
        }
    }
}
