package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.au;

/* compiled from: VisibilityUtil.kt */
public final class j {
    public static final CallableMemberDescriptor V(Collection<? extends CallableMemberDescriptor> collection) {
        h.e(collection, "descriptors");
        int isEmpty = collection.isEmpty() ^ 1;
        if (m.etY && isEmpty == 0) {
            throw new AssertionError("Assertion failed");
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor != null) {
                Integer c = au.c(callableMemberDescriptor.bbJ(), callableMemberDescriptor2.bbJ());
                if (c != null) {
                    if (h.compare(c.intValue(), 0) >= 0) {
                    }
                }
            }
            callableMemberDescriptor = callableMemberDescriptor2;
        }
        if (callableMemberDescriptor == null) {
            h.aXZ();
        }
        return callableMemberDescriptor;
    }
}
