package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;

/* compiled from: specialBuiltinMembers.kt */
final class SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1 eFK = new SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1();

    SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        return c.eEZ.m(a.H(callableMemberDescriptor));
    }
}
