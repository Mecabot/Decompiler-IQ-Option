package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;

/* compiled from: TypeSubstitution.kt */
public final class u extends as {
    private final an[] eUT;
    private final ap[] eUU;
    private final boolean eUV;

    public final an[] byZ() {
        return this.eUT;
    }

    public final ap[] bza() {
        return this.eUU;
    }

    public /* synthetic */ u(an[] anVarArr, ap[] apVarArr, boolean z, int i, f fVar) {
        if ((i & 4) != 0) {
            z = false;
        }
        this(anVarArr, apVarArr, z);
    }

    public u(an[] anVarArr, ap[] apVarArr, boolean z) {
        h.e(anVarArr, "parameters");
        h.e(apVarArr, "arguments");
        this.eUT = anVarArr;
        this.eUU = apVarArr;
        this.eUV = z;
        Object obj = this.eUT.length <= this.eUU.length ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Number of arguments should not be less then number of parameters, but: parameters=");
            stringBuilder.append(this.eUT.length);
            stringBuilder.append(", args=");
            stringBuilder.append(this.eUU.length);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public u(List<? extends an> list, List<? extends ap> list2) {
        h.e(list, "parameters");
        h.e(list2, "argumentsList");
        Object[] toArray = list.toArray(new an[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        an[] anVarArr = (an[]) toArray;
        toArray = list2.toArray(new ap[0]);
        if (toArray == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this(anVarArr, (ap[]) toArray, false, 4, null);
    }

    public boolean isEmpty() {
        return this.eUU.length == 0;
    }

    public boolean bwE() {
        return this.eUV;
    }

    public ap Z(w wVar) {
        h.e(wVar, "key");
        f bbW = wVar.bwA().bbW();
        if (!(bbW instanceof an)) {
            bbW = null;
        }
        an anVar = (an) bbW;
        if (anVar == null) {
            return null;
        }
        int index = anVar.getIndex();
        if (index >= this.eUT.length || !h.E(this.eUT[index].bby(), anVar.bby())) {
            return null;
        }
        return this.eUU[index];
    }
}
