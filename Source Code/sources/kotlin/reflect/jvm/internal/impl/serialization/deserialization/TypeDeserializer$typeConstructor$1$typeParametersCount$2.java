package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeConstructor$1$typeParametersCount$2 extends Lambda implements b<Type, Integer> {
    public static final TypeDeserializer$typeConstructor$1$typeParametersCount$2 eTw = new TypeDeserializer$typeConstructor$1$typeParametersCount$2();

    TypeDeserializer$typeConstructor$1$typeParametersCount$2() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Integer.valueOf(u((Type) obj));
    }

    public final int u(Type type) {
        h.e(type, "it");
        return type.biZ();
    }
}
