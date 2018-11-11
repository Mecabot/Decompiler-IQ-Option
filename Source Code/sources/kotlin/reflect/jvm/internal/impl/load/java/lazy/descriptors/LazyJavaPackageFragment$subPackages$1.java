package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.t;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements a<List<? extends b>> {
    final /* synthetic */ h this$0;

    LazyJavaPackageFragment$subPackages$1(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<b> invoke() {
        Iterable<t> bhI = this.this$0.eHM.bhI();
        Collection arrayList = new ArrayList(n.e(bhI, 10));
        for (t bdD : bhI) {
            arrayList.add(bdD.bdD());
        }
        return (List) arrayList;
    }
}
