package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

@Hide
final class zzh extends Handler {
    private /* synthetic */ zzd zzgfk;

    public zzh(zzd zzd, Looper looper) {
        this.zzgfk = zzd;
        super(looper);
    }

    private static void zza(Message message) {
        zzi zzi = (zzi) message.obj;
        zzi.zzamb();
        zzi.unregister();
    }

    /* JADX WARNING: Missing block: B:9:0x0012, code:
            return true;
     */
    private static boolean zzb(android.os.Message r3) {
        /*
        r0 = r3.what;
        r1 = 1;
        r2 = 2;
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        r0 = r3.what;
        if (r0 == r1) goto L_0x0012;
    L_0x000a:
        r3 = r3.what;
        r0 = 7;
        if (r3 != r0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r3 = 0;
        return r3;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzh.zzb(android.os.Message):boolean");
    }

    public final void handleMessage(Message message) {
        if (this.zzgfk.zzgfh.get() != message.arg1) {
            if (zzb(message)) {
                zza(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.zzgfk.isConnecting()) {
            zza(message);
        } else {
            PendingIntent pendingIntent = null;
            ConnectionResult zzd;
            if (message.what == 4) {
                this.zzgfk.zzgff = new ConnectionResult(message.arg2);
                if (!this.zzgfk.zzalz() || this.zzgfk.zzgfg) {
                    zzd = this.zzgfk.zzgff != null ? this.zzgfk.zzgff : new ConnectionResult(8);
                    this.zzgfk.zzgew.zzf(zzd);
                    this.zzgfk.onConnectionFailed(zzd);
                    return;
                }
                this.zzgfk.zza(3, null);
            } else if (message.what == 5) {
                zzd = this.zzgfk.zzgff != null ? this.zzgfk.zzgff : new ConnectionResult(8);
                this.zzgfk.zzgew.zzf(zzd);
                this.zzgfk.onConnectionFailed(zzd);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.zzgfk.zzgew.zzf(connectionResult);
                this.zzgfk.onConnectionFailed(connectionResult);
            } else if (message.what == 6) {
                this.zzgfk.zza(5, null);
                if (this.zzgfk.zzgfb != null) {
                    this.zzgfk.zzgfb.onConnectionSuspended(message.arg2);
                }
                this.zzgfk.onConnectionSuspended(message.arg2);
                this.zzgfk.zza(5, 1, null);
            } else if (message.what == 2 && !this.zzgfk.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((zzi) message.obj).zzamc();
            } else {
                int i = message.what;
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Don't know how to handle message: ");
                stringBuilder.append(i);
                Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
            }
        }
    }
}
