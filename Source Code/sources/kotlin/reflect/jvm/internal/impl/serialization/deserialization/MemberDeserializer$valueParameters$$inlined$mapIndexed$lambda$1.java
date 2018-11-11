package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1 extends Lambda implements a<List<? extends c>> {
    final /* synthetic */ n $callable$inlined;
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a $callableDescriptor$inlined;
    final /* synthetic */ r $containerOfCallable$inlined;
    final /* synthetic */ int $i;
    final /* synthetic */ AnnotatedCallableKind $kind$inlined;
    final /* synthetic */ ValueParameter $proto;
    final /* synthetic */ p this$0;

    MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(int i, ValueParameter valueParameter, p pVar, r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        this.$i = i;
        this.$proto = valueParameter;
        this.this$0 = pVar;
        this.$containerOfCallable$inlined = rVar;
        this.$callable$inlined = nVar;
        this.$kind$inlined = annotatedCallableKind;
        this.$callableDescriptor$inlined = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<c> invoke() {
        return u.W(this.this$0.eTh.biq().bxx().a(this.$containerOfCallable$inlined, this.$callable$inlined, this.$kind$inlined, this.$i, this.$proto));
    }
}
