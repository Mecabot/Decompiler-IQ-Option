package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;

public final /* synthetic */ class d {
    public static final /* synthetic */ int[] aoS = new int[Kind.values().length];

    static {
        aoS[Kind.Function.ordinal()] = 1;
        aoS[Kind.SuspendFunction.ordinal()] = 2;
    }
}
