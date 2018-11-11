package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.q;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.b;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.c;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: methodSignatureMapping.kt */
public final class r {
    public static final String a(kotlin.reflect.jvm.internal.impl.descriptors.r rVar, boolean z, boolean z2) {
        h.e(rVar, "$receiver");
        StringBuilder stringBuilder = new StringBuilder();
        if (z2) {
            String str;
            if (rVar instanceof j) {
                str = "<init>";
            } else {
                str = rVar.bdc().asString();
                h.d(str, "name.asString()");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append("(");
        for (aq aqVar : rVar.bcS()) {
            h.d(aqVar, "parameter");
            w bai = aqVar.bai();
            h.d(bai, "parameter.type");
            a(stringBuilder, bai);
        }
        stringBuilder.append(")");
        if (z) {
            if (z.d(rVar)) {
                stringBuilder.append("V");
            } else {
                w bcQ = rVar.bcQ();
                if (bcQ == null) {
                    h.aXZ();
                }
                h.d(bcQ, "returnType!!");
                a(stringBuilder, bcQ);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public static /* bridge */ /* synthetic */ String a(kotlin.reflect.jvm.internal.impl.descriptors.r rVar, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return a(rVar, z, z2);
    }

    public static final boolean b(a aVar) {
        h.e(aVar, "f");
        boolean z = false;
        if (!(aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.r)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.r rVar = (kotlin.reflect.jvm.internal.impl.descriptors.r) aVar;
        if (rVar.bcS().size() != 1 || q.w((CallableMemberDescriptor) aVar) || (h.E(rVar.bdc().asString(), ProductAction.ACTION_REMOVE) ^ 1) != 0) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.r bdk = rVar.bdk();
        h.d(bdk, "f.original");
        List bcS = bdk.bcS();
        h.d(bcS, "f.original.valueParameters");
        Object bY = u.bY(bcS);
        h.d(bY, "f.original.valueParameters.single()");
        w bai = ((aq) bY).bai();
        h.d(bai, "f.original.valueParameters.single().type");
        j ag = ag(bai);
        JvmPrimitiveType jvmPrimitiveType = null;
        if (!(ag instanceof c)) {
            ag = null;
        }
        c cVar = (c) ag;
        if (cVar != null) {
            jvmPrimitiveType = cVar.biz();
        }
        if (jvmPrimitiveType != JvmPrimitiveType.INT) {
            return false;
        }
        bdk = BuiltinMethodsWithSpecialGenericSignature.h(rVar);
        if (bdk == null) {
            return false;
        }
        rVar = bdk.bdk();
        h.d(rVar, "overridden.original");
        List bcS2 = rVar.bcS();
        h.d(bcS2, "overridden.original.valueParameters");
        Object bY2 = u.bY(bcS2);
        h.d(bY2, "overridden.original.valueParameters.single()");
        w bai2 = ((aq) bY2).bai();
        h.d(bai2, "overridden.original.valueParameters.single().type");
        j ag2 = ag(bai2);
        k bbv = bdk.bbv();
        h.d(bbv, "overridden.containingDeclaration");
        if (h.E(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(bbv), g.exC.eyE.btL()) && (ag2 instanceof b) && h.E(((b) ag2).getInternalName(), "java/lang/Object")) {
            z = true;
        }
        return z;
    }

    public static final String C(d dVar) {
        h.e(dVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.eAc;
        kotlin.reflect.jvm.internal.impl.name.c btL = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(dVar).btL();
        h.d(btL, "fqNameSafe.toUnsafe()");
        kotlin.reflect.jvm.internal.impl.name.a c = cVar.c(btL);
        if (c == null) {
            return z.a(dVar, null, false, 2, null);
        }
        kotlin.reflect.jvm.internal.impl.resolve.jvm.b j = kotlin.reflect.jvm.internal.impl.resolve.jvm.b.j(c);
        h.d(j, "JvmClassName.byClassId(it)");
        String internalName = j.getInternalName();
        h.d(internalName, "JvmClassName.byClassId(it).internalName");
        return internalName;
    }

    private static final void a(StringBuilder stringBuilder, w wVar) {
        stringBuilder.append(ag(wVar));
    }

    public static final j ag(w wVar) {
        h.e(wVar, "$receiver");
        return (j) z.a(wVar, l.eJU, x.eKk, w.eJZ, null, null, false, 32, null);
    }

    public static final String c(a aVar) {
        h.e(aVar, "$receiver");
        u uVar = u.eJX;
        if (kotlin.reflect.jvm.internal.impl.resolve.c.u(aVar)) {
            return null;
        }
        k bbv = aVar.bbv();
        if (!(bbv instanceof d)) {
            bbv = null;
        }
        d dVar = (d) bbv;
        if (dVar == null) {
            return null;
        }
        f bdc = dVar.bdc();
        h.d(bdc, "classDescriptor.name");
        if (bdc.btR()) {
            return null;
        }
        aVar = aVar.bcR();
        if (!(aVar instanceof ah)) {
            aVar = null;
        }
        ah ahVar = (ah) aVar;
        if (ahVar != null) {
            return uVar.a(dVar, a(ahVar, false, false, 3, null));
        }
        return null;
    }
}
