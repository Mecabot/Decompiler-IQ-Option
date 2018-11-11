package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;

/* compiled from: TypeWithEnhancement.kt */
public final class aw {
    public static final w bc(w wVar) {
        h.e(wVar, "$receiver");
        return wVar instanceof av ? ((av) wVar).byY() : null;
    }

    public static final w bd(w wVar) {
        h.e(wVar, "$receiver");
        w bc = bc(wVar);
        return bc != null ? bc : wVar;
    }

    public static final ay a(ay ayVar, w wVar) {
        h.e(ayVar, "$receiver");
        h.e(wVar, b.ORIGIN);
        return b(ayVar, bc(wVar));
    }

    public static final ay b(ay ayVar, w wVar) {
        h.e(ayVar, "$receiver");
        if (wVar == null) {
            return ayVar;
        }
        ay afVar;
        if (ayVar instanceof ad) {
            afVar = new af((ad) ayVar, wVar);
        } else if (ayVar instanceof q) {
            afVar = new s((q) ayVar, wVar);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return afVar;
    }
}
