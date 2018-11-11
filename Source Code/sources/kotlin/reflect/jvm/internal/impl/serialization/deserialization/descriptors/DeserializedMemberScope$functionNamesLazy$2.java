package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$functionNamesLazy$2 extends Lambda implements a<Set<? extends f>> {
    final /* synthetic */ h this$0;

    DeserializedMemberScope$functionNamesLazy$2(h hVar) {
        this.this$0 = hVar;
        super(0);
    }

    /* renamed from: bgK */
    public final Set<f> invoke() {
        return ak.a(this.this$0.eTN.keySet(), this.this$0.byn());
    }
}
