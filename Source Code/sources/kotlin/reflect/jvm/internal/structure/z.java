package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.structure.w.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaWildcardType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaWildcardType;", "reflectType", "Ljava/lang/reflect/WildcardType;", "(Ljava/lang/reflect/WildcardType;)V", "bound", "getBound", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "isExtends", "", "()Z", "getReflectType", "()Ljava/lang/reflect/WildcardType;", "descriptors.runtime"})
/* compiled from: ReflectJavaWildcardType.kt */
public final class z extends w implements kotlin.reflect.jvm.internal.impl.load.java.structure.z {
    private final WildcardType eYL;

    public z(WildcardType wildcardType) {
        h.e(wildcardType, "reflectType");
        this.eYL = wildcardType;
    }

    /* renamed from: bAe */
    protected WildcardType bzR() {
        return this.eYL;
    }

    /* renamed from: bAd */
    public w bhM() {
        Object upperBounds = bzR().getUpperBounds();
        Object lowerBounds = bzR().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Wildcard types with many bounds are not yet supported: ");
            stringBuilder.append(bzR());
            throw new UnsupportedOperationException(stringBuilder.toString());
        } else if (lowerBounds.length == 1) {
            a aVar = w.eYF;
            h.d(lowerBounds, "lowerBounds");
            lowerBounds = i.y(lowerBounds);
            h.d(lowerBounds, "lowerBounds.single()");
            return aVar.q((Type) lowerBounds);
        } else if (upperBounds.length != 1) {
            return null;
        } else {
            h.d(upperBounds, "upperBounds");
            Type type = (Type) i.y(upperBounds);
            if ((h.E(type, Object.class) ^ 1) == 0) {
                return null;
            }
            a aVar2 = w.eYF;
            h.d(type, "ub");
            return aVar2.q(type);
        }
    }

    public boolean bhN() {
        Object upperBounds = bzR().getUpperBounds();
        h.d(upperBounds, "reflectType.upperBounds");
        return h.E((Type) i.w((Object[]) upperBounds), Object.class) ^ 1;
    }
}
