package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.f;
import kotlin.reflect.jvm.internal.structure.w.a;

@kotlin.i(aXC = {1, 1, 11}, aXD = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "componentType", "getComponentType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReflectType", "()Ljava/lang/reflect/Type;", "descriptors.runtime"})
/* compiled from: ReflectJavaArrayType.kt */
public final class i extends w implements f {
    private final w eYq;
    private final Type eYr;

    public i(Type type) {
        w q;
        h.e(type, "reflectType");
        this.eYr = type;
        type = bzR();
        a aVar;
        if (type instanceof GenericArrayType) {
            aVar = w.eYF;
            type = ((GenericArrayType) type).getGenericComponentType();
            h.d(type, "genericComponentType");
            q = aVar.q(type);
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    aVar = w.eYF;
                    cls = cls.getComponentType();
                    h.d(cls, "getComponentType()");
                    q = aVar.q(cls);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not an array type (");
            stringBuilder.append(bzR().getClass());
            stringBuilder.append("): ");
            stringBuilder.append(bzR());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.eYq = q;
    }

    protected Type bzR() {
        return this.eYr;
    }

    /* renamed from: bzQ */
    public w bho() {
        return this.eYq;
    }
}
