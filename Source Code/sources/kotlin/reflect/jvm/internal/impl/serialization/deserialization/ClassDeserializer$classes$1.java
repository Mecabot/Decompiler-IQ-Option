package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: ClassDeserializer.kt */
final class ClassDeserializer$classes$1 extends Lambda implements b<a, d> {
    final /* synthetic */ f this$0;

    ClassDeserializer$classes$1(f fVar) {
        this.this$0 = fVar;
        super(1);
    }

    /* renamed from: b */
    public final d invoke(a aVar) {
        h.e(aVar, "key");
        return this.this$0.a(aVar);
    }
}
