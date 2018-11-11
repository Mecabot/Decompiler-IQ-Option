package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$classDescriptors$1 extends Lambda implements b<Integer, d> {
    final /* synthetic */ v this$0;

    TypeDeserializer$classDescriptors$1(v vVar) {
        this.this$0 = vVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return lZ(((Number) obj).intValue());
    }

    public final d lZ(int i) {
        return this.this$0.lW(i);
    }
}
