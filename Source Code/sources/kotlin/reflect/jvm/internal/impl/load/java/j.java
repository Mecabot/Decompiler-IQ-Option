package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.c;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
public final class j implements ExternalOverridabilityCondition {
    public static final a eFe = new a();

    /* compiled from: JavaIncompatibilityRulesOverridabilityCondition.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            h.e(aVar, "superDescriptor");
            h.e(aVar2, "subDescriptor");
            if (!(aVar2 instanceof JavaMethodDescriptor) || !(aVar instanceof r)) {
                return false;
            }
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) aVar2;
            r rVar = (r) aVar;
            Object obj = javaMethodDescriptor.bcS().size() == rVar.bcS().size() ? 1 : null;
            if (m.etY && obj == null) {
                throw new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
            }
            ah bfi = javaMethodDescriptor.beq();
            h.d(bfi, "subDescriptor.original");
            List bcS = bfi.bcS();
            h.d(bcS, "subDescriptor.original.valueParameters");
            Iterable iterable = bcS;
            r bdk = rVar.bdk();
            h.d(bdk, "superDescriptor.original");
            List bcS2 = bdk.bcS();
            h.d(bcS2, "superDescriptor.original.valueParameters");
            for (Pair pair : u.f(iterable, (Iterable) bcS2)) {
                aq aqVar = (aq) pair.aXG();
                aq aqVar2 = (aq) pair.aXH();
                a aVar3 = this;
                r rVar2 = (r) aVar2;
                h.d(aqVar, "subParameter");
                boolean z = aVar3.a(rVar2, aqVar) instanceof c;
                h.d(aqVar2, "superParameter");
                if (z != (aVar3.a(rVar, aqVar2) instanceof c)) {
                    return true;
                }
            }
            return false;
        }

        private final kotlin.reflect.jvm.internal.impl.load.kotlin.j a(r rVar, aq aqVar) {
            w bai;
            if (kotlin.reflect.jvm.internal.impl.load.kotlin.r.b(rVar) || i(rVar)) {
                bai = aqVar.bai();
                h.d(bai, "valueParameterDescriptor.type");
                return kotlin.reflect.jvm.internal.impl.load.kotlin.r.ag(kotlin.reflect.jvm.internal.impl.types.b.a.aT(bai));
            }
            bai = aqVar.bai();
            h.d(bai, "valueParameterDescriptor.type");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.r.ag(bai);
        }

        private final boolean i(r rVar) {
            boolean z = true;
            if (rVar.bcS().size() != 1) {
                return false;
            }
            k bbv = rVar.bbv();
            if (!(bbv instanceof d)) {
                bbv = null;
            }
            d dVar = (d) bbv;
            if (dVar == null) {
                return false;
            }
            List bcS = rVar.bcS();
            h.d(bcS, "f.valueParameters");
            Object bY = u.bY(bcS);
            h.d(bY, "f.valueParameters.single()");
            f bbW = ((aq) bY).bai().bwA().bbW();
            if (!(bbW instanceof d)) {
                bbW = null;
            }
            d dVar2 = (d) bbW;
            if (dVar2 == null) {
                return false;
            }
            if (!(g.d(dVar) && h.E(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(dVar), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.x(dVar2)))) {
                z = false;
            }
            return z;
        }
    }

    public Result a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, d dVar) {
        h.e(aVar, "superDescriptor");
        h.e(aVar2, "subDescriptor");
        if (b(aVar, aVar2, dVar)) {
            return Result.INCOMPATIBLE;
        }
        if (eFe.a(aVar, aVar2)) {
            return Result.INCOMPATIBLE;
        }
        return Result.UNKNOWN;
    }

    /* JADX WARNING: Missing block: B:43:0x00a8, code:
            return false;
     */
    private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.a r8, kotlin.reflect.jvm.internal.impl.descriptors.a r9, kotlin.reflect.jvm.internal.impl.descriptors.d r10) {
        /*
        r7 = this;
        r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
        r1 = 0;
        if (r0 == 0) goto L_0x00a9;
    L_0x0005:
        r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r;
        if (r0 == 0) goto L_0x00a9;
    L_0x0009:
        r0 = r9;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r0;
        r0 = kotlin.reflect.jvm.internal.impl.builtins.g.b(r0);
        if (r0 == 0) goto L_0x0014;
    L_0x0012:
        goto L_0x00a9;
    L_0x0014:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.eES;
        r9 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r9;
        r2 = r9.bdc();
        r3 = "subDescriptor.name";
        kotlin.jvm.internal.h.d(r2, r3);
        r0 = r0.m(r2);
        if (r0 != 0) goto L_0x0039;
    L_0x0027:
        r0 = kotlin.reflect.jvm.internal.impl.load.java.b.eEK;
        r2 = r9.bdc();
        r3 = "subDescriptor.name";
        kotlin.jvm.internal.h.d(r2, r3);
        r0 = r0.k(r2);
        if (r0 != 0) goto L_0x0039;
    L_0x0038:
        return r1;
    L_0x0039:
        r0 = r8;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0;
        r0 = kotlin.reflect.jvm.internal.impl.load.java.q.s(r0);
        r2 = r9.bdm();
        r3 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r;
        r4 = 0;
        if (r3 != 0) goto L_0x004b;
    L_0x0049:
        r5 = r4;
        goto L_0x004c;
    L_0x004b:
        r5 = r8;
    L_0x004c:
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r5;
        r6 = 1;
        if (r5 == 0) goto L_0x005a;
    L_0x0051:
        r5 = r5.bdm();
        if (r2 == r5) goto L_0x0058;
    L_0x0057:
        goto L_0x005a;
    L_0x0058:
        r2 = 0;
        goto L_0x005b;
    L_0x005a:
        r2 = 1;
    L_0x005b:
        if (r2 == 0) goto L_0x0066;
    L_0x005d:
        if (r0 == 0) goto L_0x0065;
    L_0x005f:
        r2 = r9.bdm();
        if (r2 != 0) goto L_0x0066;
    L_0x0065:
        return r6;
    L_0x0066:
        r2 = r10 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.d;
        if (r2 == 0) goto L_0x00a8;
    L_0x006a:
        r2 = r9.bdl();
        if (r2 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x00a8;
    L_0x0071:
        if (r0 == 0) goto L_0x00a7;
    L_0x0073:
        r2 = r0;
        r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) r2;
        r10 = kotlin.reflect.jvm.internal.impl.load.java.q.a(r10, r2);
        if (r10 == 0) goto L_0x007d;
    L_0x007c:
        goto L_0x00a7;
    L_0x007d:
        r10 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r;
        if (r10 == 0) goto L_0x00a6;
    L_0x0081:
        if (r3 == 0) goto L_0x00a6;
    L_0x0083:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r0;
        r10 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.h(r0);
        if (r10 == 0) goto L_0x00a6;
    L_0x008b:
        r10 = 2;
        r9 = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(r9, r1, r1, r10, r4);
        r8 = (kotlin.reflect.jvm.internal.impl.descriptors.r) r8;
        r8 = r8.bdk();
        r0 = "superDescriptor.original";
        kotlin.jvm.internal.h.d(r8, r0);
        r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.r.a(r8, r1, r1, r10, r4);
        r8 = kotlin.jvm.internal.h.E(r9, r8);
        if (r8 == 0) goto L_0x00a6;
    L_0x00a5:
        return r1;
    L_0x00a6:
        return r6;
    L_0x00a7:
        return r1;
    L_0x00a8:
        return r1;
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.j.b(kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.d):boolean");
    }

    public Contract bfC() {
        return Contract.CONFLICTS_ONLY;
    }
}
