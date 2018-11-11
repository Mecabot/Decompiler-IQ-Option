package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
public abstract class g extends h {
    protected abstract void a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        h.e(callableMemberDescriptor, "fromSuper");
        h.e(callableMemberDescriptor2, "fromCurrent");
        a(callableMemberDescriptor, callableMemberDescriptor2);
    }

    public void c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        h.e(callableMemberDescriptor, "first");
        h.e(callableMemberDescriptor2, "second");
        a(callableMemberDescriptor, callableMemberDescriptor2);
    }
}
