package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$loadProperty$2 extends Lambda implements a<f<?>> {
    final /* synthetic */ j $property;
    final /* synthetic */ Property $proto;
    final /* synthetic */ p this$0;

    MemberDeserializer$loadProperty$2(p pVar, Property property, j jVar) {
        this.this$0 = pVar;
        this.$proto = property;
        this.$property = jVar;
        super(0);
    }

    /* renamed from: bgX */
    public final f<?> invoke() {
        r a = this.this$0.V(this.this$0.eTh.bbv());
        if (a == null) {
            h.aXZ();
        }
        a bxx = this.this$0.eTh.biq().bxx();
        Property property = this.$proto;
        w bcQ = this.$property.bcQ();
        h.d(bcQ, "property.returnType");
        return (f) bxx.a(a, property, bcQ);
    }
}
