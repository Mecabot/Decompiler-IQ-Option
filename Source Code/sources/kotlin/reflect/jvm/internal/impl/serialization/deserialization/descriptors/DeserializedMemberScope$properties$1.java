package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$properties$1 extends Lambda implements b<f, Collection<? extends ad>> {
    final /* synthetic */ h this$0;

    DeserializedMemberScope$properties$1(h hVar) {
        this.this$0 = hVar;
        super(1);
    }

    /* renamed from: h */
    public final Collection<ad> invoke(f fVar) {
        h.e(fVar, "it");
        return this.this$0.f(fVar);
    }
}
