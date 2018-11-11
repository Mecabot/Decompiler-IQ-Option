package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.c;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: functionTypes.kt */
public final class f {
    public static final boolean c(w wVar) {
        h.e(wVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        return (bbW != null ? a((k) bbW) : null) == Kind.Function;
    }

    public static final boolean d(w wVar) {
        h.e(wVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        return (bbW != null ? a((k) bbW) : null) == Kind.SuspendFunction;
    }

    public static final boolean e(w wVar) {
        h.e(wVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        Kind a = bbW != null ? a((k) bbW) : null;
        return a == Kind.Function || a == Kind.SuspendFunction;
    }

    public static final boolean f(w wVar) {
        h.e(wVar, "$receiver");
        return e(wVar) && g(wVar);
    }

    private static final boolean g(w wVar) {
        g bbQ = wVar.bbQ();
        b bVar = g.exC.eyj;
        h.d(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        return bbQ.j(bVar) != null;
    }

    public static final Kind a(k kVar) {
        h.e(kVar, "$receiver");
        if ((kVar instanceof d) && g.c(kVar)) {
            return a(a.z(kVar));
        }
        return null;
    }

    private static final Kind a(c cVar) {
        if (!cVar.isSafe() || cVar.isRoot()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.functions.a.a aVar = kotlin.reflect.jvm.internal.impl.builtins.functions.a.ezH;
        String asString = cVar.btN().asString();
        h.d(asString, "shortName().asString()");
        b btM = cVar.btP().btM();
        h.d(btM, "toSafe().parent()");
        return aVar.b(asString, btM);
    }

    public static final w h(w wVar) {
        h.e(wVar, "$receiver");
        boolean e = e(wVar);
        if (!m.etY || e) {
            return g(wVar) ? ((ap) u.bU(wVar.bdF())).bai() : null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Not a function type: ");
            stringBuilder.append(wVar);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    public static final w i(w wVar) {
        h.e(wVar, "$receiver");
        boolean e = e(wVar);
        if (!m.etY || e) {
            wVar = ((ap) u.bW(wVar.bdF())).bai();
            h.d(wVar, "arguments.last().type");
            return wVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a function type: ");
        stringBuilder.append(wVar);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final List<ap> j(w wVar) {
        h.e(wVar, "$receiver");
        boolean e = e(wVar);
        StringBuilder stringBuilder;
        if (!m.etY || e) {
            List bdF = wVar.bdF();
            boolean f = f(wVar);
            int i = 1;
            boolean size = bdF.size() - 1;
            if (f > size) {
                i = 0;
            }
            if (!m.etY || i != 0) {
                return bdF.subList(f, size);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Not an exact function type: ");
            stringBuilder.append(wVar);
            throw new AssertionError(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Not a function type: ");
        stringBuilder.append(wVar);
        throw new AssertionError(stringBuilder.toString());
    }

    public static final kotlin.reflect.jvm.internal.impl.name.f k(w wVar) {
        h.e(wVar, "$receiver");
        g bbQ = wVar.bbQ();
        b bVar = g.exC.eyk;
        h.d(bVar, "KotlinBuiltIns.FQ_NAMES.parameterName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j = bbQ.j(bVar);
        if (j == null) {
            return null;
        }
        Object R = u.R(j.bee().values());
        if (!(R instanceof s)) {
            R = null;
        }
        s sVar = (s) R;
        if (sVar != null) {
            String str = (String) sVar.getValue();
            if (str != null) {
                if (!kotlin.reflect.jvm.internal.impl.name.f.mE(str)) {
                    str = null;
                }
                if (str != null) {
                    return kotlin.reflect.jvm.internal.impl.name.f.mD(str);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:16:0x0052, code:
            if (r2.btR() == false) goto L_0x0056;
     */
    public static final java.util.List<kotlin.reflect.jvm.internal.impl.types.ap> a(kotlin.reflect.jvm.internal.impl.types.w r10, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.w> r11, java.util.List<kotlin.reflect.jvm.internal.impl.name.f> r12, kotlin.reflect.jvm.internal.impl.types.w r13, kotlin.reflect.jvm.internal.impl.builtins.g r14) {
        /*
        r0 = "parameterTypes";
        kotlin.jvm.internal.h.e(r11, r0);
        r0 = "returnType";
        kotlin.jvm.internal.h.e(r13, r0);
        r0 = "builtIns";
        kotlin.jvm.internal.h.e(r14, r0);
        r0 = new java.util.ArrayList;
        r1 = r11.size();
        r2 = 0;
        r3 = 1;
        if (r10 == 0) goto L_0x001b;
    L_0x0019:
        r4 = 1;
        goto L_0x001c;
    L_0x001b:
        r4 = 0;
    L_0x001c:
        r1 = r1 + r4;
        r1 = r1 + r3;
        r0.<init>(r1);
        r1 = r0;
        r1 = (java.util.Collection) r1;
        r3 = 0;
        if (r10 == 0) goto L_0x002c;
    L_0x0027:
        r10 = kotlin.reflect.jvm.internal.impl.types.b.a.bk(r10);
        goto L_0x002d;
    L_0x002c:
        r10 = r3;
    L_0x002d:
        kotlin.reflect.jvm.internal.impl.utils.a.j(r1, r10);
        r11 = (java.lang.Iterable) r11;
        r10 = r11.iterator();
    L_0x0036:
        r11 = r10.hasNext();
        if (r11 == 0) goto L_0x00a0;
    L_0x003c:
        r11 = r10.next();
        r4 = r2 + 1;
        r11 = (kotlin.reflect.jvm.internal.impl.types.w) r11;
        if (r12 == 0) goto L_0x0055;
    L_0x0046:
        r2 = r12.get(r2);
        r2 = (kotlin.reflect.jvm.internal.impl.name.f) r2;
        if (r2 == 0) goto L_0x0055;
    L_0x004e:
        r5 = r2.btR();
        if (r5 != 0) goto L_0x0055;
    L_0x0054:
        goto L_0x0056;
    L_0x0055:
        r2 = r3;
    L_0x0056:
        if (r2 == 0) goto L_0x0097;
    L_0x0058:
        r5 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.j;
        r6 = kotlin.reflect.jvm.internal.impl.builtins.g.exC;
        r6 = r6.eyk;
        r7 = "KotlinBuiltIns.FQ_NAMES.parameterName";
        kotlin.jvm.internal.h.d(r6, r7);
        r7 = "name";
        r7 = kotlin.reflect.jvm.internal.impl.name.f.mD(r7);
        r8 = new kotlin.reflect.jvm.internal.impl.resolve.constants.s;
        r2 = r2.asString();
        r9 = "name.asString()";
        kotlin.jvm.internal.h.d(r2, r9);
        r8.<init>(r2);
        r2 = kotlin.j.D(r7, r8);
        r2 = kotlin.collections.ac.h(r2);
        r5.<init>(r14, r6, r2);
        r2 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.h;
        r6 = r11.bbQ();
        r6 = (java.lang.Iterable) r6;
        r5 = kotlin.collections.u.e(r6, r5);
        r2.<init>(r5);
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.g) r2;
        r11 = kotlin.reflect.jvm.internal.impl.types.b.a.a(r11, r2);
    L_0x0097:
        r11 = kotlin.reflect.jvm.internal.impl.types.b.a.bk(r11);
        r1.add(r11);
        r2 = r4;
        goto L_0x0036;
    L_0x00a0:
        r10 = kotlin.reflect.jvm.internal.impl.types.b.a.bk(r13);
        r0.add(r10);
        r0 = (java.util.List) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.f.a(kotlin.reflect.jvm.internal.impl.types.w, java.util.List, java.util.List, kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.builtins.g):java.util.List<kotlin.reflect.jvm.internal.impl.types.ap>");
    }

    public static /* bridge */ /* synthetic */ ad a(g gVar, g gVar2, w wVar, List list, List list2, w wVar2, boolean z, int i, Object obj) {
        return a(gVar, gVar2, wVar, list, list2, wVar2, (i & 64) != 0 ? false : z);
    }

    public static final ad a(g gVar, g gVar2, w wVar, List<? extends w> list, List<kotlin.reflect.jvm.internal.impl.name.f> list2, w wVar2, boolean z) {
        h.e(gVar, "builtIns");
        h.e(gVar2, "annotations");
        h.e(list, "parameterTypes");
        h.e(wVar2, "returnType");
        List a = a(wVar, list, list2, wVar2, gVar);
        int size = list.size();
        if (wVar != null) {
            size++;
        }
        d js = z ? gVar.js(size) : gVar.jr(size);
        if (wVar != null) {
            b bVar = g.exC.eyj;
            h.d(bVar, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
            if (gVar2.j(bVar) == null) {
                Iterable iterable = gVar2;
                b bVar2 = g.exC.eyj;
                h.d(bVar2, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
                gVar2 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.h(u.e(iterable, (Object) new j(gVar, bVar2, ad.emptyMap())));
            }
        }
        h.d(js, "classDescriptor");
        return x.a(gVar2, js, a);
    }
}
