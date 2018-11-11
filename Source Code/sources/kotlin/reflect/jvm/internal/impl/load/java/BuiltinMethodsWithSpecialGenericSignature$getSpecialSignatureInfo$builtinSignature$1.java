package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: specialBuiltinMembers.kt */
final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    public static final BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 eEU = new BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1();

    BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        return (callableMemberDescriptor instanceof r) && BuiltinMethodsWithSpecialGenericSignature.eES.k(callableMemberDescriptor);
    }
}
