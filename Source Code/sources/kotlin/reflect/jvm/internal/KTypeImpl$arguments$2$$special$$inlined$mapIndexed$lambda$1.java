package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, aXE = {"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements a<Type> {
    final /* synthetic */ int $i;
    final /* synthetic */ d $parameterizedTypeArguments$inlined;
    final /* synthetic */ j $parameterizedTypeArguments$metadata$inlined;
    final /* synthetic */ KTypeImpl$arguments$2 this$0;

    KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int i, KTypeImpl$arguments$2 kTypeImpl$arguments$2, d dVar, j jVar) {
        this.$i = i;
        this.this$0 = kTypeImpl$arguments$2;
        this.$parameterizedTypeArguments$inlined = dVar;
        this.$parameterizedTypeArguments$metadata$inlined = jVar;
        super(0);
    }

    /* renamed from: aYV */
    public final Type invoke() {
        Type bah = this.this$0.this$0.bah();
        Object componentType;
        StringBuilder stringBuilder;
        if (bah instanceof Class) {
            Class cls = (Class) bah;
            componentType = cls.isArray() ? cls.getComponentType() : Object.class;
            h.d(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
            return (Type) componentType;
        } else if (bah instanceof GenericArrayType) {
            if (this.$i != 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Array type has been queried for a non-0th argument: ");
                stringBuilder.append(this.this$0.this$0);
                throw new KotlinReflectionInternalError(stringBuilder.toString());
            }
            bah = ((GenericArrayType) bah).getGenericComponentType();
            h.d(bah, "javaType.genericComponentType");
            return bah;
        } else if (bah instanceof ParameterizedType) {
            d dVar = this.$parameterizedTypeArguments$inlined;
            j jVar = this.$parameterizedTypeArguments$metadata$inlined;
            bah = (Type) ((List) dVar.getValue()).get(this.$i);
            if (bah instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) bah;
                Object lowerBounds = wildcardType.getLowerBounds();
                h.d(lowerBounds, "argument.lowerBounds");
                Type type = (Type) i.w((Object[]) lowerBounds);
                if (type != null) {
                    bah = type;
                } else {
                    componentType = wildcardType.getUpperBounds();
                    h.d(componentType, "argument.upperBounds");
                    bah = (Type) i.v((Object[]) componentType);
                }
            }
            h.d(bah, "if (argument !is Wildcar…ument.upperBounds.first()");
            return bah;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Non-generic type has been queried for arguments: ");
            stringBuilder.append(this.this$0.this$0);
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
    }
}
