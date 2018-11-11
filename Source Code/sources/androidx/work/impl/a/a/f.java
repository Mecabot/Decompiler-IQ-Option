package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.e;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.j;

/* compiled from: NetworkNotRoamingController */
public class f extends c<b> {
    public f(Context context) {
        super(g.i(context).cq());
    }

    boolean j(@NonNull j jVar) {
        return jVar.gv.aH() == NetworkType.NOT_ROAMING;
    }

    /* renamed from: a */
    boolean i(@NonNull b bVar) {
        boolean z = true;
        if (VERSION.SDK_INT < 24) {
            e.b("NetworkNotRoamingCtrlr", "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return bVar.isConnected() ^ true;
        }
        if (bVar.isConnected() && bVar.ce()) {
            z = false;
        }
        return z;
    }
}
