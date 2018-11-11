package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class b extends f<List<? extends f<?>>> {
    private final kotlin.jvm.a.b<u, w> eRm;

    public b(List<? extends f<?>> list, kotlin.jvm.a.b<? super u, ? extends w> bVar) {
        h.e(list, com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);
        h.e(bVar, "computeType");
        super(list);
        this.eRm = bVar;
    }

    public w h(u uVar) {
        h.e(uVar, "module");
        w wVar = (w) this.eRm.invoke(uVar);
        Object obj = (g.n(wVar) || g.o(wVar)) ? 1 : null;
        if (!m.etY || obj != null) {
            return wVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type should be an array, but was ");
        stringBuilder.append(wVar);
        stringBuilder.append(": ");
        stringBuilder.append((List) getValue());
        throw new AssertionError(stringBuilder.toString());
    }
}
