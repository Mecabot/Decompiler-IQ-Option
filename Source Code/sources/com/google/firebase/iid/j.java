package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class j extends Binder {
    private final f Ym;

    j(f fVar) {
        this.Ym = fVar;
    }

    public final void a(h hVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (this.Ym.p(hVar.intent)) {
            hVar.finish();
            return;
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.Ym.zzimc.execute(new k(this, hVar));
    }
}
