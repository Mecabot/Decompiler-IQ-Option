package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class v {
    public static final /* synthetic */ int[] aoS = new int[Variance.values().length];

    static {
        aoS[Variance.INVARIANT.ordinal()] = 1;
        aoS[Variance.IN_VARIANCE.ordinal()] = 2;
        aoS[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}
