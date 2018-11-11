package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getReceiverParameterAnnotations$1 extends Lambda implements a<List<? extends f>> {
    final /* synthetic */ n $proto;
    final /* synthetic */ AnnotatedCallableKind $receiverTargetedKind;
    final /* synthetic */ p this$0;

    MemberDeserializer$getReceiverParameterAnnotations$1(p pVar, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        this.this$0 = pVar;
        this.$proto = nVar;
        this.$receiverTargetedKind = annotatedCallableKind;
        super(0);
    }

    /* renamed from: aYR */
    public final List<f> invoke() {
        List<f> W;
        r a = this.this$0.V(this.this$0.eTh.bbv());
        if (a != null) {
            Iterable<c> b = this.this$0.eTh.biq().bxx().b(a, this.$proto, this.$receiverTargetedKind);
            Collection arrayList = new ArrayList(n.e(b, 10));
            for (c fVar : b) {
                arrayList.add(new f(fVar, AnnotationUseSiteTarget.RECEIVER));
            }
            W = u.W((List) arrayList);
        } else {
            W = null;
        }
        return W != null ? W : m.emptyList();
    }
}
