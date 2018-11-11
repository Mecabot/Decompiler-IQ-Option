package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.f;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeAliasDescriptors$1 extends Lambda implements b<Integer, f> {
    final /* synthetic */ v this$0;

    TypeDeserializer$typeAliasDescriptors$1(v vVar) {
        this.this$0 = vVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return ma(((Number) obj).intValue());
    }

    public final f ma(int i) {
        return this.this$0.lY(i);
    }
}
