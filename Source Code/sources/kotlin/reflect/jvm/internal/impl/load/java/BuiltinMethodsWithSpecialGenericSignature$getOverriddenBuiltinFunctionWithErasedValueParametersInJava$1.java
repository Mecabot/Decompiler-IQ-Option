package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: specialBuiltinMembers.kt */
final class BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    public static final BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1 eET = new BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1();

    BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        return BuiltinMethodsWithSpecialGenericSignature.eES.k(callableMemberDescriptor);
    }
}
