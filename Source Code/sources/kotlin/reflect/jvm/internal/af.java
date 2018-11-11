package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;

@i(aXC = {1, 1, 11})
public final /* synthetic */ class af {
    public static final /* synthetic */ int[] aoS = new int[Kind.values().length];

    static {
        aoS[Kind.FILE_FACADE.ordinal()] = 1;
        aoS[Kind.MULTIFILE_CLASS_PART.ordinal()] = 2;
        aoS[Kind.MULTIFILE_CLASS.ordinal()] = 3;
    }
}
