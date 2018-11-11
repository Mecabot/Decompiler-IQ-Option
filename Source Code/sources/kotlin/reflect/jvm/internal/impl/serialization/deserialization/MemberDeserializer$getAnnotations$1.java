package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getAnnotations$1 extends Lambda implements a<List<? extends f>> {
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ n $proto;
    final /* synthetic */ p this$0;

    MemberDeserializer$getAnnotations$1(p pVar, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        this.this$0 = pVar;
        this.$proto = nVar;
        this.$kind = annotatedCallableKind;
        super(0);
    }

    /* renamed from: aYR */
    public final List<f> invoke() {
        r a = this.this$0.V(this.this$0.eTh.bbv());
        List<f> W = a != null ? u.W(this.this$0.eTh.biq().bxx().a(a, this.$proto, this.$kind)) : null;
        return W != null ? W : m.emptyList();
    }
}
