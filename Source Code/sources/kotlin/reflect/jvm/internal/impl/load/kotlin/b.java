package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;

public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[AnnotatedCallableKind.values().length];

    static {
        aoS[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
        aoS[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
        aoS[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
    }
}
