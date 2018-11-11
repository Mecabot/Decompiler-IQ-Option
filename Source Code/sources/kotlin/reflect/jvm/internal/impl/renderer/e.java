package kotlin.reflect.jvm.internal.impl.renderer;

public final /* synthetic */ class e {
    public static final /* synthetic */ int[] aoS = new int[RenderingFormat.values().length];
    public static final /* synthetic */ int[] auV = new int[RenderingFormat.values().length];
    public static final /* synthetic */ int[] auW = new int[RenderingFormat.values().length];
    public static final /* synthetic */ int[] auk = new int[RenderingFormat.values().length];
    public static final /* synthetic */ int[] cCT = new int[ParameterNameRenderingPolicy.values().length];

    static {
        aoS[RenderingFormat.PLAIN.ordinal()] = 1;
        aoS[RenderingFormat.HTML.ordinal()] = 2;
        auk[RenderingFormat.PLAIN.ordinal()] = 1;
        auk[RenderingFormat.HTML.ordinal()] = 2;
        auV[RenderingFormat.PLAIN.ordinal()] = 1;
        auV[RenderingFormat.HTML.ordinal()] = 2;
        auW[RenderingFormat.PLAIN.ordinal()] = 1;
        auW[RenderingFormat.HTML.ordinal()] = 2;
        cCT[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
        cCT[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
        cCT[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
    }
}
