package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: JvmPackageScope.kt */
final class JvmPackageScope$kotlinScopes$2 extends Lambda implements a<List<? extends h>> {
    final /* synthetic */ d this$0;

    JvmPackageScope$kotlinScopes$2(d dVar) {
        this.this$0 = dVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<h> invoke() {
        Collection arrayList = new ArrayList();
        for (n a : this.this$0.eHp.bgL().values()) {
            h a2 = this.this$0.eGT.bgq().bfX().a((x) this.this$0.eHp, a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return u.W((List) arrayList);
    }
}
