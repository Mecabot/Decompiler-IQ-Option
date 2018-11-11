package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;

public final /* synthetic */ class b {
    public static final /* synthetic */ int[] aoS = new int[Kind.values().length];
    public static final /* synthetic */ int[] auk = new int[Kind.values().length];

    static {
        aoS[Kind.SuspendFunction.ordinal()] = 1;
        aoS[Kind.KSuspendFunction.ordinal()] = 2;
        auk[Kind.KFunction.ordinal()] = 1;
        auk[Kind.KSuspendFunction.ordinal()] = 2;
    }
}
