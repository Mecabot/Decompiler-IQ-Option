package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.TypeCastException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$isMutabilityViolation$2 extends Lambda implements b<CallableMemberDescriptor, Boolean> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    JvmBuiltInsSettings$isMutabilityViolation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.this$0 = jvmBuiltInsSettings;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(e((CallableMemberDescriptor) obj));
    }

    public final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        h.d(callableMemberDescriptor, "overridden");
        if (callableMemberDescriptor.bcW() == Kind.DECLARATION) {
            c b = this.this$0.eAr;
            k bbv = callableMemberDescriptor.bbv();
            if (bbv == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            } else if (b.h((d) bbv)) {
                return true;
            }
        }
        return false;
    }
}
