package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.name.a;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeConstructor$1 extends Lambda implements b<Integer, d> {
    final /* synthetic */ Type $proto;
    final /* synthetic */ v this$0;

    TypeDeserializer$typeConstructor$1(v vVar, Type type) {
        this.this$0 = vVar;
        this.$proto = type;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return lZ(((Number) obj).intValue());
    }

    public final d lZ(int i) {
        a a = q.a(this.this$0.eTh.aYI(), i);
        List g = m.g(m.f(k.a((Object) this.$proto, (b) new TypeDeserializer$typeConstructor$1$typeParametersCount$1(this)), TypeDeserializer$typeConstructor$1$typeParametersCount$2.eTw));
        int i2 = m.i(k.a((Object) a, (b) TypeDeserializer$typeConstructor$1$classNestingLevel$1.eTv));
        while (g.size() < i2) {
            g.add(Integer.valueOf(0));
        }
        return this.this$0.eTh.biq().bxB().a(a, g);
    }
}
