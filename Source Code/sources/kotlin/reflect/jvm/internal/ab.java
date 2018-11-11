package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class ab {
    public static final /* synthetic */ int[] aoS = new int[Kind.values().length];
    public static final /* synthetic */ int[] auk = new int[Variance.values().length];

    static {
        aoS[Kind.EXTENSION_RECEIVER.ordinal()] = 1;
        aoS[Kind.INSTANCE.ordinal()] = 2;
        aoS[Kind.VALUE.ordinal()] = 3;
        auk[Variance.INVARIANT.ordinal()] = 1;
        auk[Variance.IN_VARIANCE.ordinal()] = 2;
        auk[Variance.OUT_VARIANCE.ordinal()] = 3;
    }
}
