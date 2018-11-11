package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.a.g;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$simpleType$1 extends Lambda implements b<Type, List<? extends Argument>> {
    final /* synthetic */ v this$0;

    TypeDeserializer$simpleType$1(v vVar) {
        this.this$0 = vVar;
        super(1);
    }

    /* renamed from: s */
    public final List<Argument> invoke(Type type) {
        h.e(type, "$receiver");
        List biY = type.biY();
        h.d(biY, "argumentList");
        Collection collection = biY;
        type = g.b(type, this.this$0.eTh.aYJ());
        List s = type != null ? invoke(type) : null;
        if (s == null) {
            s = m.emptyList();
        }
        return u.b(collection, (Iterable) s);
    }
}
