package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation;

public final /* synthetic */ class i {
    public static final /* synthetic */ int[] aoS = new int[Operation.values().length];

    static {
        aoS[Operation.NONE.ordinal()] = 1;
        aoS[Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
        aoS[Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
    }
}
