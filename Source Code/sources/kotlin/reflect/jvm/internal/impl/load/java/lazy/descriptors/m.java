package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: LazyJavaStaticScope.kt */
public abstract class m extends k {
    protected void b(f fVar, Collection<ad> collection) {
        h.e(fVar, "name");
        h.e(collection, "result");
    }

    protected Void bha() {
        return null;
    }

    public m(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar) {
        h.e(hVar, "c");
        super(hVar);
    }

    public /* synthetic */ ag bcP() {
        return (ag) bha();
    }

    protected a a(q qVar, List<? extends an> list, w wVar, List<? extends aq> list2) {
        h.e(qVar, b.METHOD);
        h.e(list, "methodTypeParameters");
        h.e(wVar, "returnType");
        h.e(list2, "valueParameters");
        return new a(wVar, null, list2, list, false, m.emptyList());
    }
}
