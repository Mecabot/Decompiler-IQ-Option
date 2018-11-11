package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 extends Lambda implements b<CallableMemberDescriptor, w> {
    public static final SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 eIX = new SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1();

    SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1() {
        super(1);
    }

    /* renamed from: y */
    public final w invoke(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        ag bcO = callableMemberDescriptor.bcO();
        if (bcO == null) {
            h.aXZ();
        }
        h.d(bcO, "it.extensionReceiverParameter!!");
        w bai = bcO.bai();
        h.d(bai, "it.extensionReceiverParameter!!.type");
        return bai;
    }
}
