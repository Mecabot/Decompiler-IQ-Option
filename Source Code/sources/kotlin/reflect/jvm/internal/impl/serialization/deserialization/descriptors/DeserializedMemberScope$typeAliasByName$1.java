package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$typeAliasByName$1 extends Lambda implements b<f, am> {
    final /* synthetic */ h this$0;

    DeserializedMemberScope$typeAliasByName$1(h hVar) {
        this.this$0 = hVar;
        super(1);
    }

    /* renamed from: V */
    public final am invoke(f fVar) {
        h.e(fVar, "it");
        return this.this$0.S(fVar);
    }
}
