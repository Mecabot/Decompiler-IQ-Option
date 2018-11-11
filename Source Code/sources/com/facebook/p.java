package com.facebook;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.internal.w;
import com.facebook.internal.x;

/* compiled from: ProfileManager */
public final class p {
    private static volatile p yE;
    private final LocalBroadcastManager wz;
    private final o yF;
    private n yG;

    p(LocalBroadcastManager localBroadcastManager, o oVar) {
        x.a((Object) localBroadcastManager, "localBroadcastManager");
        x.a((Object) oVar, "profileCache");
        this.wz = localBroadcastManager;
        this.yF = oVar;
    }

    static p jP() {
        if (yE == null) {
            synchronized (p.class) {
                if (yE == null) {
                    yE = new p(LocalBroadcastManager.getInstance(h.getApplicationContext()), new o());
                }
            }
        }
        return yE;
    }

    n jM() {
        return this.yG;
    }

    boolean jQ() {
        n jO = this.yF.jO();
        if (jO == null) {
            return false;
        }
        a(jO, false);
        return true;
    }

    void a(@Nullable n nVar) {
        a(nVar, true);
    }

    private void a(@Nullable n nVar, boolean z) {
        n nVar2 = this.yG;
        this.yG = nVar;
        if (z) {
            if (nVar != null) {
                this.yF.b(nVar);
            } else {
                this.yF.clear();
            }
        }
        if (!w.d((Object) nVar2, (Object) nVar)) {
            a(nVar2, nVar);
        }
    }

    private void a(n nVar, n nVar2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", nVar);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", nVar2);
        this.wz.sendBroadcast(intent);
    }
}
