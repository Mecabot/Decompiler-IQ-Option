package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.types.an;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class a {
    public static final a eQv = new a();

    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    static final class a implements kotlin.reflect.jvm.internal.impl.types.checker.b.a {
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a eQx;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a eQy;

        a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            this.eQx = aVar;
            this.eQy = aVar2;
        }

        /* renamed from: b */
        public final boolean a(an anVar, an anVar2) {
            h.e(anVar, "c1");
            h.e(anVar2, "c2");
            if (h.E(anVar, anVar2)) {
                return true;
            }
            f bbW = anVar.bbW();
            f bbW2 = anVar2.bbW();
            return ((bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.an) && (bbW2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.an)) ? a.eQv.a((kotlin.reflect.jvm.internal.impl.descriptors.an) bbW, (kotlin.reflect.jvm.internal.impl.descriptors.an) bbW2, (m) new DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1(this)) : false;
        }
    }

    private a() {
    }

    public final boolean d(k kVar, k kVar2) {
        if ((kVar instanceof d) && (kVar2 instanceof d)) {
            return b((d) kVar, (d) kVar2);
        }
        if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.an) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.an)) {
            return a(this, (kotlin.reflect.jvm.internal.impl.descriptors.an) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.an) kVar2, null, 4, null);
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return a(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar, (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2, false, 4, null);
        } else if ((kVar instanceof x) && (kVar2 instanceof x)) {
            return h.E(((x) kVar).bdD(), ((x) kVar2).bdD());
        } else {
            return h.E(kVar, kVar2);
        }
    }

    private final boolean b(d dVar, d dVar2) {
        return h.E(dVar.bby(), dVar2.bby());
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.an anVar, kotlin.reflect.jvm.internal.impl.descriptors.an anVar2, m<? super k, ? super k, Boolean> mVar) {
        boolean z = true;
        if (h.E(anVar, anVar2)) {
            return true;
        }
        if (h.E(anVar.bbv(), anVar2.bbv()) || !a((k) anVar, (k) anVar2, (m) mVar)) {
            return false;
        }
        if (anVar.getIndex() != anVar2.getIndex()) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:19:0x007f, code:
            if (r7.bww() == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) goto L_0x0083;
     */
    public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a r7, kotlin.reflect.jvm.internal.impl.descriptors.a r8, boolean r9) {
        /*
        r6 = this;
        r0 = "a";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = "b";
        kotlin.jvm.internal.h.e(r8, r0);
        r0 = kotlin.jvm.internal.h.E(r7, r8);
        r1 = 1;
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r7.bdc();
        r2 = r8.bdc();
        r0 = kotlin.jvm.internal.h.E(r0, r2);
        r0 = r0 ^ r1;
        r2 = 0;
        if (r0 == 0) goto L_0x0023;
    L_0x0022:
        return r2;
    L_0x0023:
        r0 = r7.bbv();
        r3 = r8.bbv();
        r0 = kotlin.jvm.internal.h.E(r0, r3);
        if (r0 == 0) goto L_0x0032;
    L_0x0031:
        return r2;
    L_0x0032:
        r0 = r7;
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r0;
        r3 = kotlin.reflect.jvm.internal.impl.resolve.c.u(r0);
        if (r3 != 0) goto L_0x0084;
    L_0x003b:
        r3 = r8;
        r3 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r3;
        r4 = kotlin.reflect.jvm.internal.impl.resolve.c.u(r3);
        if (r4 == 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0084;
    L_0x0045:
        r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.eQw;
        r4 = (kotlin.jvm.a.m) r4;
        r0 = r6.a(r0, r3, r4);
        if (r0 != 0) goto L_0x0050;
    L_0x004f:
        return r2;
    L_0x0050:
        r0 = new kotlin.reflect.jvm.internal.impl.resolve.a$a;
        r0.<init>(r7, r8);
        r0 = (kotlin.reflect.jvm.internal.impl.types.checker.b.a) r0;
        r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(r0);
        r3 = r9 ^ 1;
        r4 = 0;
        r3 = r0.a(r7, r8, r4, r3);
        r5 = "overridingUtil.isOverrid… null, !ignoreReturnType)";
        kotlin.jvm.internal.h.d(r3, r5);
        r3 = r3.bww();
        r5 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r3 != r5) goto L_0x0082;
    L_0x006f:
        r9 = r9 ^ r1;
        r7 = r0.a(r8, r7, r4, r9);
        r8 = "overridingUtil.isOverrid… null, !ignoreReturnType)";
        kotlin.jvm.internal.h.d(r7, r8);
        r7 = r7.bww();
        r8 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (r7 != r8) goto L_0x0082;
    L_0x0081:
        goto L_0x0083;
    L_0x0082:
        r1 = 0;
    L_0x0083:
        return r1;
    L_0x0084:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.a.a(kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a, boolean):boolean");
    }

    private final boolean a(k kVar, k kVar2, m<? super k, ? super k, Boolean> mVar) {
        kVar = kVar.bbv();
        kVar2 = kVar2.bbv();
        if ((kVar instanceof CallableMemberDescriptor) || (kVar2 instanceof CallableMemberDescriptor)) {
            return ((Boolean) mVar.B(kVar, kVar2)).booleanValue();
        }
        return d(kVar, kVar2);
    }
}
