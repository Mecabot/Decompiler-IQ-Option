package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.t;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;

/* compiled from: LazyJavaPackageFragment.kt */
final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements a<Map<String, ? extends n>> {
    final /* synthetic */ h this$0;

    LazyJavaPackageFragment$binaryClasses$2(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    /* renamed from: adu */
    public final Map<String, n> invoke() {
        t bge = this.this$0.eGT.bgq().bge();
        String asString = this.this$0.bdD().asString();
        h.d(asString, "fqName.asString()");
        Iterable<String> lZ = bge.lZ(asString);
        Collection arrayList = new ArrayList();
        for (String str : lZ) {
            b mR = b.mR(str);
            h.d(mR, "JvmClassName.byInternalName(partName)");
            kotlin.reflect.jvm.internal.impl.name.a t = kotlin.reflect.jvm.internal.impl.name.a.t(mR.bwK());
            m bfW = this.this$0.eGT.bgq().bfW();
            h.d(t, "classId");
            n b = bfW.b(t);
            Object D = b != null ? j.D(str, b) : null;
            if (D != null) {
                arrayList.add(D);
            }
        }
        return ad.ae((List) arrayList);
    }
}
