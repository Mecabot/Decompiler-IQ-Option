package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements a<ad> {
    final /* synthetic */ e this$0;

    LazyJavaAnnotationDescriptor$type$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        b bdD = this.this$0.bdD();
        if (bdD != null) {
            c cVar = c.eAc;
            h.d(bdD, "fqName");
            d a = c.a(cVar, bdD, this.this$0.eGT.bar().bdy(), null, 4, null);
            if (a == null) {
                g bhk = this.this$0.eHs.bhk();
                a = bhk != null ? this.this$0.eGT.bgq().bgd().b(bhk) : null;
            }
            if (a == null) {
                a = this.this$0.q(bdD);
            }
            return a.bdb();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No fqName: ");
        stringBuilder.append(this.this$0.eHs);
        return p.mU(stringBuilder.toString());
    }
}
