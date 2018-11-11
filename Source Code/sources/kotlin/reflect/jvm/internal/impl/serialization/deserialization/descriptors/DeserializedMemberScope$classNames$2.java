package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$classNames$2 extends Lambda implements a<Set<? extends f>> {
    final /* synthetic */ a $classNames;

    DeserializedMemberScope$classNames$2(a aVar) {
        this.$classNames = aVar;
        super(0);
    }

    /* renamed from: bgK */
    public final Set<f> invoke() {
        return u.Y((Iterable) this.$classNames.invoke());
    }
}
