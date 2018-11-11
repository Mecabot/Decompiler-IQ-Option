package kotlin.reflect.jvm.internal.structure;

import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.u;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPrimitiveType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPrimitiveType;", "reflectType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getReflectType", "()Ljava/lang/Class;", "type", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getType", "()Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "descriptors.runtime"})
/* compiled from: ReflectJavaPrimitiveType.kt */
public final class v extends w implements u {
    private final Class<?> eYE;

    public v(Class<?> cls) {
        h.e(cls, "reflectType");
        this.eYE = cls;
    }

    /* renamed from: bAc */
    protected Class<?> bzR() {
        return this.eYE;
    }

    public PrimitiveType bhJ() {
        if (h.E(bzR(), Void.TYPE)) {
            return null;
        }
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(bzR().getName());
        h.d(jvmPrimitiveType, "JvmPrimitiveType.get(reflectType.name)");
        return jvmPrimitiveType.getPrimitiveType();
    }
}
