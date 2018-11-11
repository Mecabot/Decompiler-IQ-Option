package androidx.work.impl.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import androidx.work.impl.a.b.g;
import androidx.work.impl.b.j;

/* compiled from: BatteryNotLowController */
public class b extends c<Boolean> {
    public b(Context context) {
        super(g.i(context).cp());
    }

    boolean j(@NonNull j jVar) {
        return jVar.gv.aK();
    }

    /* renamed from: b */
    boolean i(@NonNull Boolean bool) {
        return bool.booleanValue() ^ 1;
    }
}
