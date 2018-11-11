package androidx.work.impl.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.impl.a.b;
import androidx.work.impl.b.j;

/* compiled from: NetworkUnmeteredController */
public class g extends c<b> {
    public g(Context context) {
        super(androidx.work.impl.a.b.g.i(context).cq());
    }

    boolean j(@NonNull j jVar) {
        return jVar.gv.aH() == NetworkType.UNMETERED;
    }

    /* renamed from: a */
    boolean i(@NonNull b bVar) {
        return !bVar.isConnected() || bVar.cd();
    }
}
