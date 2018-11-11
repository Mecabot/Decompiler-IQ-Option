package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends Lambda implements b<u, w> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 eGg = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    /* renamed from: g */
    public final w invoke(u uVar) {
        h.e(uVar, "module");
        aq b = a.b(c.eGc.bfQ(), uVar.bdy().d(g.exC.eym));
        if (b != null) {
            w bai = b.bai();
            if (bai != null) {
                return bai;
            }
        }
        ad mU = p.mU("Error: AnnotationTarget[]");
        h.d(mU, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
        return mU;
    }
}
