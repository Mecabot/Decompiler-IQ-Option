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

final class zzad implements OnCompleteListener<Map<zzh<?>, String>> {
    private /* synthetic */ zzaa zzfwu;
    private zzcu zzfwv;

    zzad(zzaa zzaa, zzcu zzcu) {
        this.zzfwu = zzaa;
        this.zzfwv = zzcu;
    }

    final void cancel() {
        this.zzfwv.zzacm();
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        this.zzfwu.zzfwa.lock();
        try {
            zzcu zzcu;
            if (this.zzfwu.zzfwp) {
                if (task.isSuccessful()) {
                    this.zzfwu.zzfwr = new ArrayMap(this.zzfwu.zzfwh.size());
                    for (zzz zzahv : this.zzfwu.zzfwh.values()) {
                        this.zzfwu.zzfwr.put(zzahv.zzahv(), ConnectionResult.zzfqt);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zzfwu.zzfwn) {
                        this.zzfwu.zzfwr = new ArrayMap(this.zzfwu.zzfwh.size());
                        for (zzz zzz : this.zzfwu.zzfwh.values()) {
                            Map zzg;
                            zzh zzahv2 = zzz.zzahv();
                            Object connectionResult = availabilityException.getConnectionResult(zzz);
                            if (this.zzfwu.zza(zzz, (ConnectionResult) connectionResult)) {
                                zzg = this.zzfwu.zzfwr;
                                connectionResult = new ConnectionResult(16);
                            } else {
                                zzg = this.zzfwu.zzfwr;
                            }
                            zzg.put(zzahv2, connectionResult);
                        }
                    } else {
                        this.zzfwu.zzfwr = availabilityException.zzahr();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    this.zzfwu.zzfwr = Collections.emptyMap();
                }
                if (this.zzfwu.isConnected()) {
                    this.zzfwu.zzfwq.putAll(this.zzfwu.zzfwr);
                    if (this.zzfwu.zzajb() == null) {
                        this.zzfwu.zzaiz();
                        this.zzfwu.zzaja();
                        this.zzfwu.zzfwl.signalAll();
                    }
                }
                zzcu = this.zzfwv;
            } else {
                zzcu = this.zzfwv;
            }
            zzcu.zzacm();
        } finally {
            this.zzfwu.zzfwa.unlock();
        }
    }
}
