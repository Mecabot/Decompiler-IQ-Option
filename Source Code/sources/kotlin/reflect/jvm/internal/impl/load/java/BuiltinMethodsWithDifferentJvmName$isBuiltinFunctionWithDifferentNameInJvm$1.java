package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;

/* compiled from: specialBuiltinMembers.kt */
final class BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ ah $functionDescriptor;

    BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(ah ahVar) {
        this.$functionDescriptor = ahVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "it");
        Map a = b.eEH;
        String c = r.c(this.$functionDescriptor);
        if (a != null) {
            return a.containsKey(c);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
}
