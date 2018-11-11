package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: ConstantValueFactory.kt */
final class ConstantValueFactory$createArrayValue$3 extends Lambda implements b<u, ad> {
    final /* synthetic */ PrimitiveType $componentType;

    ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        this.$componentType = primitiveType;
        super(1);
    }

    /* renamed from: f */
    public final ad invoke(u uVar) {
        h.e(uVar, "module");
        ad c = uVar.bdy().c(this.$componentType);
        h.d(c, "module.builtIns.getPrimi…KotlinType(componentType)");
        return c;
    }
}
