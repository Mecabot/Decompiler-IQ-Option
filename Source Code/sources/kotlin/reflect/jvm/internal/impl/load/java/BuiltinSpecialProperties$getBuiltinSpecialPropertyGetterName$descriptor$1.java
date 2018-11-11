package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: specialBuiltinMembers.kt */
final class BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    public static final BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 eFa = new BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1();

    BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        return c.eEZ.m(callableMemberDescriptor);
    }
}
