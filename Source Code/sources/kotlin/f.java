package kotlin;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] aoS = new int[LazyThreadSafetyMode.values().length];

    static {
        aoS[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
        aoS[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
        aoS[LazyThreadSafetyMode.NONE.ordinal()] = 3;
    }
}
