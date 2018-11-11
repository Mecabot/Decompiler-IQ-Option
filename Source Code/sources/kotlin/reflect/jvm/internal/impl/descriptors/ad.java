package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: PropertyDescriptor */
public interface ad extends CallableMemberDescriptor, at {
    Collection<? extends ad> bcU();

    ae bdI();

    af bdJ();

    List<ac> bdK();

    ad bdL();

    ad d(TypeSubstitutor typeSubstitutor);
}
