package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1 extends Lambda implements b<ah, Boolean> {
    final /* synthetic */ a this$0;

    DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1(a aVar) {
        this.this$0 = aVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(j((ah) obj));
    }

    public final boolean j(ah ahVar) {
        h.e(ahVar, "it");
        return this.this$0.bxX().biq().baG().a(e.this, ahVar);
    }
}
