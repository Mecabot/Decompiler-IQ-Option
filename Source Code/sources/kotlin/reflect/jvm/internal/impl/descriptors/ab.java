package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ap;

/* compiled from: typeParameterUtils.kt */
public final class ab {
    private final g eAU;
    private final List<ap> eAV;
    private final ab eAW;

    public ab(g gVar, List<? extends ap> list, ab abVar) {
        h.e(gVar, "classifierDescriptor");
        h.e(list, "arguments");
        this.eAU = gVar;
        this.eAV = list;
        this.eAW = abVar;
    }

    public final g bdE() {
        return this.eAU;
    }

    public final List<ap> bdF() {
        return this.eAV;
    }

    public final ab bdG() {
        return this.eAW;
    }
}
