package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ConstructorDescriptor */
public interface j extends r {
    j b(TypeSubstitutor typeSubstitutor);

    w bcQ();

    g bdj();

    List<an> getTypeParameters();
}
