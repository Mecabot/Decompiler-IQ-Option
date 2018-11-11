package com.google.firebase.iid;

import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;

public class FirebaseInstanceIdService extends f {
    @WorkerThread
    public void fM() {
    }

    @Hide
    protected final Intent m(Intent intent) {
        return (Intent) ac.wP().YZ.poll();
    }

    @Hide
    public final void n(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            fM();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(stringExtra).length() + 21) + String.valueOf(valueOf).length());
                stringBuilder.append("Received command: ");
                stringBuilder.append(stringExtra);
                stringBuilder.append(" - ");
                stringBuilder.append(valueOf);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.wj().wr();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId.wj().ws();
            }
        }
    }
}
