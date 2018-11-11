package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$functions$1 extends Lambda implements b<f, Collection<? extends ah>> {
    final /* synthetic */ h this$0;

    DeserializedMemberScope$functions$1(h hVar) {
        this.this$0 = hVar;
        super(1);
    }

    /* renamed from: h */
    public final Collection<ah> invoke(f fVar) {
        h.e(fVar, "it");
        return this.this$0.g(fVar);
    }
}
