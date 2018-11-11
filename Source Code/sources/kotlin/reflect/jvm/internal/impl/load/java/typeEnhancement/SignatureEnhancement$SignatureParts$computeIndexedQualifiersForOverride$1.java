package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 extends Lambda implements b<Integer, d> {
    final /* synthetic */ d[] $computedResult;

    SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(d[] dVarArr) {
        this.$computedResult = dVarArr;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return jt(((Number) obj).intValue());
    }

    public final d jt(int i) {
        d[] dVarArr = this.$computedResult;
        return (i < 0 || i > i.z(dVarArr)) ? d.eID.bhV() : dVarArr[i];
    }
}
