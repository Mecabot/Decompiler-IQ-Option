package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 extends Lambda implements b<CallableMemberDescriptor, w> {
    public static final SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 eIY = new SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1();

    SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1() {
        super(1);
    }

    /* renamed from: y */
    public final w invoke(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        w bcQ = callableMemberDescriptor.bcQ();
        if (bcQ == null) {
            h.aXZ();
        }
        return bcQ;
    }
}
