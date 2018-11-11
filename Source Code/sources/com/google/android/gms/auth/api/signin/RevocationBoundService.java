package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzx;

public final class RevocationBoundService extends Service {
    public final IBinder onBind(Intent intent) {
        String str;
        String str2;
        String valueOf;
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) || "com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            if (Log.isLoggable("RevocationService", 2)) {
                str = "RevocationService";
                str2 = "RevocationBoundService handling ";
                valueOf = String.valueOf(intent.getAction());
                Log.v(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return new zzx(this);
        }
        str = "RevocationService";
        str2 = "Unknown action sent to RevocationBoundService: ";
        valueOf = String.valueOf(intent.getAction());
        Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        return null;
    }
}
