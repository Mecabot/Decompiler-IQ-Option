package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.j;

/* compiled from: NetworkMeteredController */
public class e extends c<b> {
    public e(Context context) {
        super(g.i(context).cq());
    }

    boolean j(@NonNull j jVar) {
        return jVar.gv.aH() == NetworkType.METERED;
    }

    /* renamed from: a */
    boolean i(@NonNull b bVar) {
        boolean z = true;
        if (VERSION.SDK_INT < 26) {
            androidx.work.e.b("NetworkMeteredCtrlr", "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return bVar.isConnected() ^ true;
        }
        if (bVar.isConnected() && bVar.cd()) {
            z = false;
        }
        return z;
    }
}
