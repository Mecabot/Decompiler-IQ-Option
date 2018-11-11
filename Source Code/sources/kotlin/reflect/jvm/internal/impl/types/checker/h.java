package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.LowerCapturedTypePolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SeveralSupertypesWithSameConstructorPolicy;

public final /* synthetic */ class h {
    public static final /* synthetic */ int[] aoS = new int[LowerCapturedTypePolicy.values().length];
    public static final /* synthetic */ int[] auV = new int[Variance.values().length];
    public static final /* synthetic */ int[] auk = new int[SeveralSupertypesWithSameConstructorPolicy.values().length];

    static {
        aoS[LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
        aoS[LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
        aoS[LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
        auk[SeveralSupertypesWithSameConstructorPolicy.FORCE_NOT_SUBTYPE.ordinal()] = 1;
        auk[SeveralSupertypesWithSameConstructorPolicy.TAKE_FIRST_FOR_SUBTYPING.ordinal()] = 2;
        auk[SeveralSupertypesWithSameConstructorPolicy.CHECK_ANY_OF_THEM.ordinal()] = 3;
        auk[SeveralSupertypesWithSameConstructorPolicy.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN.ordinal()] = 4;
        auV[Variance.INVARIANT.ordinal()] = 1;
        auV[Variance.OUT_VARIANCE.ordinal()] = 2;
        auV[Variance.IN_VARIANCE.ordinal()] = 3;
    }
}
