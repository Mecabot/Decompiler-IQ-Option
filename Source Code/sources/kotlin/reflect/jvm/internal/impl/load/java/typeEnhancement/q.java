package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

public final /* synthetic */ class q {
    public static final /* synthetic */ int[] aoS = new int[MutabilityQualifier.values().length];
    public static final /* synthetic */ int[] auk = new int[NullabilityQualifier.values().length];

    static {
        aoS[MutabilityQualifier.READ_ONLY.ordinal()] = 1;
        aoS[MutabilityQualifier.MUTABLE.ordinal()] = 2;
        auk[NullabilityQualifier.NULLABLE.ordinal()] = 1;
        auk[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
    }
}
