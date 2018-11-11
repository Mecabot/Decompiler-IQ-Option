package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.a;
import kotlin.reflect.jvm.internal.impl.resolve.constants.i;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;

/* compiled from: annotationUtil.kt */
public final class e {
    private static final f eBA = f.mD("expression");
    private static final f eBB = f.mD("imports");
    private static final b eBC = new b("kotlin.internal.InlineOnly");
    private static final f eBx = f.mD("message");
    private static final f eBy = f.mD("replaceWith");
    private static final f eBz = f.mD(FirebaseAnalytics.b.LEVEL);

    public static /* bridge */ /* synthetic */ c a(g gVar, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return a(gVar, str, str2, str3);
    }

    public static final c a(g gVar, String str, String str2, String str3) {
        h.e(gVar, "$receiver");
        h.e(str, "message");
        h.e(str2, "replaceWith");
        h.e(str3, FirebaseAnalytics.b.LEVEL);
        b bVar = g.exC.eyi;
        h.d(bVar, "KotlinBuiltIns.FQ_NAMES.replaceWith");
        j jVar = new j(gVar, bVar, ad.a(j.D(eBA, new s(str2)), j.D(eBB, new kotlin.reflect.jvm.internal.impl.resolve.constants.b(m.emptyList(), new AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1(gVar)))));
        bVar = g.exC.eyg;
        h.d(bVar, "KotlinBuiltIns.FQ_NAMES.deprecated");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = j.D(eBx, new s(str));
        pairArr[1] = j.D(eBy, new a(jVar));
        f fVar = eBz;
        kotlin.reflect.jvm.internal.impl.name.a t = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.eyh);
        h.d(t, "ClassId.topLevel(KotlinB…Q_NAMES.deprecationLevel)");
        f mD = f.mD(str3);
        h.d(mD, "Name.identifier(level)");
        pairArr[2] = j.D(fVar, new i(t, mD));
        return new j(gVar, bVar, ad.a(pairArr));
    }

    /* JADX WARNING: Missing block: B:7:0x0025, code:
            if (c(r2) == false) goto L_0x0029;
     */
    public static final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.s r2) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
        if (r0 == 0) goto L_0x0029;
    L_0x0009:
        r0 = r2;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        r1 = f(r0);
        if (r1 != 0) goto L_0x0027;
    L_0x0012:
        r0 = kotlin.reflect.jvm.internal.impl.resolve.c.B(r0);
        r1 = "DescriptorUtils.getDirectMember(this)";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = f(r0);
        if (r0 != 0) goto L_0x0027;
    L_0x0021:
        r2 = c(r2);
        if (r2 == 0) goto L_0x0029;
    L_0x0027:
        r2 = 1;
        goto L_0x002a;
    L_0x0029:
        r2 = 0;
    L_0x002a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.a(kotlin.reflect.jvm.internal.impl.descriptors.s):boolean");
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        h.e(sVar, "$receiver");
        if (a(sVar)) {
            return true;
        }
        if (sVar instanceof r) {
            r rVar = (r) sVar;
            if (rVar.bdq() && rVar.bbN()) {
                Object obj;
                List bcS = rVar.bcS();
                h.d(bcS, "valueParameters");
                Iterable<aq> iterable = bcS;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (aq bdU : iterable) {
                        if (bdU.bdU()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null || h.E(rVar.bbJ(), au.eBc)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:5:0x001f, code:
            if (g(r0) == false) goto L_0x004a;
     */
    public static final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.s r2) {
        /*
        r0 = "$receiver";
        kotlin.jvm.internal.h.e(r2, r0);
        r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r;
        if (r0 == 0) goto L_0x004a;
    L_0x0009:
        r0 = r2;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        r1 = g(r0);
        if (r1 != 0) goto L_0x0022;
    L_0x0012:
        r0 = kotlin.reflect.jvm.internal.impl.resolve.c.B(r0);
        r1 = "DescriptorUtils.getDirectMember(this)";
        kotlin.jvm.internal.h.d(r0, r1);
        r0 = g(r0);
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        goto L_0x004a;
    L_0x0022:
        r0 = r2;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r0;
        r0 = r0.bbN();
        r1 = kotlin.m.etY;
        if (r1 == 0) goto L_0x0048;
    L_0x002d:
        if (r0 != 0) goto L_0x0048;
    L_0x002f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Function is not inline: ";
        r0.append(r1);
        r0.append(r2);
        r2 = r0.toString();
        r0 = new java.lang.AssertionError;
        r0.<init>(r2);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0048:
        r2 = 1;
        return r2;
    L_0x004a:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.e.c(kotlin.reflect.jvm.internal.impl.descriptors.s):boolean");
    }

    private static final boolean f(CallableMemberDescriptor callableMemberDescriptor) {
        List typeParameters = callableMemberDescriptor.getTypeParameters();
        h.d(typeParameters, "typeParameters");
        Iterable<an> iterable = typeParameters;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (an anVar : iterable) {
            h.d(anVar, "it");
            if (anVar.bde()) {
                return true;
            }
        }
        return false;
    }

    private static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.bbQ().k(eBC);
    }
}
