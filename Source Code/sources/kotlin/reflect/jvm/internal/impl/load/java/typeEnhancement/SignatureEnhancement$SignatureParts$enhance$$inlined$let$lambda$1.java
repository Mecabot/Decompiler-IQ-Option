package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1 extends Lambda implements b<Integer, d> {
    final /* synthetic */ o $predefined$inlined;
    final /* synthetic */ b $qualifiers$inlined;

    SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1(o oVar, b bVar) {
        this.$predefined$inlined = oVar;
        this.$qualifiers$inlined = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return jt(((Number) obj).intValue());
    }

    public final d jt(int i) {
        d dVar = (d) this.$predefined$inlined.aSg().get(Integer.valueOf(i));
        return dVar != null ? dVar : (d) this.$qualifiers$inlined.invoke(Integer.valueOf(i));
    }
}
