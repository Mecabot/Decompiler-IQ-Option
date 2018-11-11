package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
public abstract class h {
    public abstract void b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void h(CallableMemberDescriptor callableMemberDescriptor);

    public void a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
        kotlin.jvm.internal.h.e(callableMemberDescriptor, "member");
        kotlin.jvm.internal.h.e(collection, "overridden");
        callableMemberDescriptor.Q(collection);
    }
}
