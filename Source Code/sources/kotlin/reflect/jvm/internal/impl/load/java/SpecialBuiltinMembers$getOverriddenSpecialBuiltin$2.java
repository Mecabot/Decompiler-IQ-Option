package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: specialBuiltinMembers.kt */
final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 eFM = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        return g.b((k) callableMemberDescriptor) && BuiltinMethodsWithSpecialGenericSignature.l(callableMemberDescriptor) != null;
    }
}
