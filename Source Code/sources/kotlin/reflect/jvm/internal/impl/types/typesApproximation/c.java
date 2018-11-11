package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.reflect.jvm.internal.impl.types.Variance;

public final /* synthetic */ class c {
    public static final /* synthetic */ int[] aoS = new int[Variance.values().length];
    public static final /* synthetic */ int[] auk = new int[Variance.values().length];

    static {
        aoS[Variance.INVARIANT.ordinal()] = 1;
        aoS[Variance.IN_VARIANCE.ordinal()] = 2;
        aoS[Variance.OUT_VARIANCE.ordinal()] = 3;
        auk[Variance.IN_VARIANCE.ordinal()] = 1;
        auk[Variance.OUT_VARIANCE.ordinal()] = 2;
    }
}
