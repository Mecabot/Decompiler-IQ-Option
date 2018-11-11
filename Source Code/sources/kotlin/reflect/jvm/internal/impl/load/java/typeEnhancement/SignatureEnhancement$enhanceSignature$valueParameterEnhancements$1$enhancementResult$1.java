package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1 extends Lambda implements b<CallableMemberDescriptor, w> {
    final /* synthetic */ aq $p;

    SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1(aq aqVar) {
        this.$p = aqVar;
        super(1);
    }

    /* renamed from: y */
    public final w invoke(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        Object obj = callableMemberDescriptor.bcS().get(this.$p.getIndex());
        h.d(obj, "it.valueParameters[p.index]");
        w bai = ((aq) obj).bai();
        h.d(bai, "it.valueParameters[p.index].type");
        return bai;
    }
}
