package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.c;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ao;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.b;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: utils.kt */
public final class p {
    public static final w a(w wVar, w wVar2, o oVar) {
        h.e(wVar, "subtype");
        h.e(wVar2, "supertype");
        h.e(oVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new m(wVar, null));
        an bwA = wVar2.bwA();
        while (!arrayDeque.isEmpty()) {
            m mVar = (m) arrayDeque.poll();
            w bai = mVar.bai();
            an bwA2 = bai.bwA();
            w bai2;
            if (oVar.c(bwA2, bwA)) {
                boolean aYp = bai.aYp();
                for (mVar = mVar.bzm(); mVar != null; mVar = mVar.bzm()) {
                    Object obj;
                    bai2 = mVar.bai();
                    Iterable<ap> bdF = bai2.bdF();
                    if (!((bdF instanceof Collection) && ((Collection) bdF).isEmpty())) {
                        for (ap bzf : bdF) {
                            Object obj2;
                            if (bzf.bzf() != Variance.INVARIANT) {
                                obj2 = 1;
                                continue;
                            } else {
                                obj2 = null;
                                continue;
                            }
                            if (obj2 != null) {
                                obj = 1;
                                break;
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        bai = c.a(ao.eVe.aN(bai2), false, 1, null).bzh().b(bai, Variance.INVARIANT);
                        h.d(bai, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        bai = bi(bai);
                    } else {
                        bai = ao.eVe.aN(bai2).bzh().b(bai, Variance.INVARIANT);
                        h.d(bai, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                    }
                    aYp = aYp || bai2.aYp();
                }
                an bwA3 = bai.bwA();
                if (oVar.c(bwA3, bwA)) {
                    return au.b(bai, aYp);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Type constructors should be equals!\n");
                stringBuilder.append("substitutedSuperType: ");
                stringBuilder.append(e(bwA3));
                stringBuilder.append(", \n\n");
                stringBuilder.append("supertype: ");
                stringBuilder.append(e(bwA));
                stringBuilder.append(" \n");
                stringBuilder.append(oVar.c(bwA3, bwA));
                throw new AssertionError(stringBuilder.toString());
            }
            for (w bai22 : bwA2.beu()) {
                h.d(bai22, "immediateSupertype");
                arrayDeque.add(new m(bai22, mVar));
            }
        }
        return null;
    }

    private static final w bi(w wVar) {
        return (w) b.bm(wVar).bzr();
    }

    private static final String e(an anVar) {
        StringBuilder stringBuilder = new StringBuilder();
        UtilsKt$debugInfo$1$1 utilsKt$debugInfo$1$1 = new UtilsKt$debugInfo$1$1(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("type: ");
        stringBuilder2.append(anVar);
        utilsKt$debugInfo$1$1.invoke(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("hashCode: ");
        stringBuilder2.append(anVar.hashCode());
        utilsKt$debugInfo$1$1.invoke(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("javaClass: ");
        stringBuilder2.append(anVar.getClass().getCanonicalName());
        utilsKt$debugInfo$1$1.invoke(stringBuilder2.toString());
        for (k bbW = anVar.bbW(); bbW != null; bbW = bbW.bbv()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("fqName: ");
            stringBuilder2.append(kotlin.reflect.jvm.internal.impl.renderer.b.ePd.s(bbW));
            utilsKt$debugInfo$1$1.invoke(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("javaClass: ");
            stringBuilder2.append(bbW.getClass().getCanonicalName());
            utilsKt$debugInfo$1$1.invoke(stringBuilder2.toString());
        }
        String stringBuilder3 = stringBuilder.toString();
        h.d(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }
}
