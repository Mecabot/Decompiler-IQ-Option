package kotlin.reflect.jvm.internal.impl.metadata.a;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level;

public final /* synthetic */ class j {
    public static final /* synthetic */ int[] aoS = new int[Level.values().length];

    static {
        aoS[Level.WARNING.ordinal()] = 1;
        aoS[Level.ERROR.ordinal()] = 2;
        aoS[Level.HIDDEN.ordinal()] = 3;
    }
}
