package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.a.g;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeConstructor$1$typeParametersCount$1 extends Lambda implements b<Type, Type> {
    final /* synthetic */ TypeDeserializer$typeConstructor$1 this$0;

    TypeDeserializer$typeConstructor$1$typeParametersCount$1(TypeDeserializer$typeConstructor$1 typeDeserializer$typeConstructor$1) {
        this.this$0 = typeDeserializer$typeConstructor$1;
        super(1);
    }

    /* renamed from: t */
    public final Type invoke(Type type) {
        h.e(type, "it");
        return g.b(type, this.this$0.this$0.eTh.aYJ());
    }
}
