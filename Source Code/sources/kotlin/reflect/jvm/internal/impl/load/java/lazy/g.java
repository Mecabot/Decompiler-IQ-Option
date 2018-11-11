package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.a;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
public final class g implements y {
    private final h eGT;
    private final a<b, h> eGV = this.eGT.baI().byD();

    public g(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "components");
        this.eGT = new h(bVar, m.a.eHh, h.cp(null));
    }

    private final h p(b bVar) {
        t a = this.eGT.bgq().bfV().a(bVar);
        return a != null ? (h) this.eGV.b(bVar, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, a)) : null;
    }

    public List<h> i(b bVar) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        return m.cs(p(bVar));
    }

    /* renamed from: b */
    public List<b> a(b bVar, kotlin.jvm.a.b<? super f, Boolean> bVar2) {
        kotlin.jvm.internal.h.e(bVar, "fqName");
        kotlin.jvm.internal.h.e(bVar2, "nameFilter");
        h p = p(bVar);
        List<b> bgM = p != null ? p.bgM() : null;
        return bgM != null ? bgM : m.emptyList();
    }
}
