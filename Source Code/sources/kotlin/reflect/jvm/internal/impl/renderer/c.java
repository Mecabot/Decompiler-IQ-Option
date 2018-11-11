package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

public final /* synthetic */ class c {
    public static final /* synthetic */ int[] aoS = new int[ClassKind.values().length];

    static {
        aoS[ClassKind.CLASS.ordinal()] = 1;
        aoS[ClassKind.INTERFACE.ordinal()] = 2;
        aoS[ClassKind.ENUM_CLASS.ordinal()] = 3;
        aoS[ClassKind.OBJECT.ordinal()] = 4;
        aoS[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
        aoS[ClassKind.ENUM_ENTRY.ordinal()] = 6;
    }
}
