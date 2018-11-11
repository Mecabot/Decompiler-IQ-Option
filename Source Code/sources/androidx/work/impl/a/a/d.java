package androidx.work.impl.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.impl.a.b;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.j;

/* compiled from: NetworkConnectedController */
public class d extends c<b> {
    public d(Context context) {
        super(g.i(context).cq());
    }

    boolean j(@NonNull j jVar) {
        return jVar.gv.aH() == NetworkType.CONNECTED;
    }

    /* renamed from: a */
    boolean i(@NonNull b bVar) {
        boolean z = true;
        if (VERSION.SDK_INT < 26) {
            return bVar.isConnected() ^ true;
        }
        if (bVar.isConnected() && bVar.cc()) {
            z = false;
        }
        return z;
    }
}
