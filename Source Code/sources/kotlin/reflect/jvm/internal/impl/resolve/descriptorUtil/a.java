package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DescriptorUtils.kt */
public final class a {
    private static final f eRs = f.mD(com.google.firebase.analytics.FirebaseAnalytics.b.VALUE);

    /* compiled from: DescriptorUtils.kt */
    static final class a<N> implements kotlin.reflect.jvm.internal.impl.utils.b.b<N> {
        public static final a eRt = new a();

        a() {
        }

        /* renamed from: f */
        public final List<aq> cK(aq aqVar) {
            h.d(aqVar, "current");
            Iterable<aq> bcU = aqVar.bcU();
            Collection arrayList = new ArrayList(n.e(bcU, 10));
            for (aq bdT : bcU) {
                arrayList.add(bdT.bdT());
            }
            return (List) arrayList;
        }
    }

    /* compiled from: DescriptorUtils.kt */
    static final class b<N> implements kotlin.reflect.jvm.internal.impl.utils.b.b<N> {
        final /* synthetic */ boolean eRv;

        b(boolean z) {
            this.eRv = z;
        }

        /* JADX WARNING: Missing block: B:7:0x0012, code:
            if (r2 != null) goto L_0x0019;
     */
        /* renamed from: I */
        public final java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> cK(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2) {
            /*
            r1 = this;
            r0 = r1.eRv;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            if (r2 == 0) goto L_0x000b;
        L_0x0006:
            r2 = r2.bcV();
            goto L_0x000c;
        L_0x000b:
            r2 = 0;
        L_0x000c:
            if (r2 == 0) goto L_0x0015;
        L_0x000e:
            r2 = r2.bcU();
            if (r2 == 0) goto L_0x0015;
        L_0x0014:
            goto L_0x0019;
        L_0x0015:
            r2 = kotlin.collections.m.emptyList();
        L_0x0019:
            r2 = (java.lang.Iterable) r2;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b.I(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor):java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor>");
        }
    }

    /* compiled from: DescriptorUtils.kt */
    public static final class c extends kotlin.reflect.jvm.internal.impl.utils.b.a<CallableMemberDescriptor, CallableMemberDescriptor> {
        final /* synthetic */ ObjectRef eAG;
        final /* synthetic */ kotlin.jvm.a.b eRw;

        c(ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.eAG = objectRef;
            this.eRw = bVar;
        }

        /* renamed from: J */
        public boolean cL(CallableMemberDescriptor callableMemberDescriptor) {
            h.e(callableMemberDescriptor, "current");
            return ((CallableMemberDescriptor) this.eAG.element) == null;
        }

        /* renamed from: K */
        public void dc(CallableMemberDescriptor callableMemberDescriptor) {
            h.e(callableMemberDescriptor, "current");
            if (((CallableMemberDescriptor) this.eAG.element) == null && ((Boolean) this.eRw.invoke(callableMemberDescriptor)).booleanValue()) {
                this.eAG.element = callableMemberDescriptor;
            }
        }

        /* renamed from: bwI */
        public CallableMemberDescriptor bcM() {
            return (CallableMemberDescriptor) this.eAG.element;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.name.c z(k kVar) {
        h.e(kVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.name.c w = kotlin.reflect.jvm.internal.impl.resolve.c.w(kVar);
        h.d(w, "DescriptorUtils.getFqName(this)");
        return w;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.b x(k kVar) {
        h.e(kVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.name.b x = kotlin.reflect.jvm.internal.impl.resolve.c.x(kVar);
        h.d(x, "DescriptorUtils.getFqNameSafe(this)");
        return x;
    }

    public static final u P(k kVar) {
        h.e(kVar, "$receiver");
        u B = kotlin.reflect.jvm.internal.impl.resolve.c.B(kVar);
        h.d(B, "DescriptorUtils.getContainingModule(this)");
        return B;
    }

    public static final d b(u uVar, kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar2) {
        h.e(uVar, "$receiver");
        h.e(bVar, "topLevelClassFqName");
        h.e(bVar2, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
        int isRoot = bVar.isRoot() ^ 1;
        if (m.etY && isRoot == 0) {
            throw new AssertionError("Assertion failed");
        }
        kotlin.reflect.jvm.internal.impl.name.b btM = bVar.btM();
        h.d(btM, "topLevelClassFqName.parent()");
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbk = uVar.g(btM).bbk();
        f btN = bVar.btN();
        h.d(btN, "topLevelClassFqName.shortName()");
        kotlin.reflect.jvm.internal.impl.descriptors.f c = bbk.c(btN, bVar2);
        if (!(c instanceof d)) {
            c = null;
        }
        return (d) c;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.a c(g gVar) {
        h.e(gVar, "$receiver");
        k bbv = gVar.bbv();
        if (bbv instanceof x) {
            return new kotlin.reflect.jvm.internal.impl.name.a(((x) bbv).bdD(), gVar.bdc());
        }
        if (!(bbv instanceof g)) {
            return null;
        }
        h.d(bbv, "owner");
        kotlin.reflect.jvm.internal.impl.name.a c = c((g) bbv);
        if (c != null) {
            return c.B(gVar.bdc());
        }
        return null;
    }

    public static final d L(d dVar) {
        h.e(dVar, "$receiver");
        for (w wVar : dVar.bdb().bwA().beu()) {
            if (!kotlin.reflect.jvm.internal.impl.builtins.g.D(wVar)) {
                kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
                if (kotlin.reflect.jvm.internal.impl.resolve.c.L(bbW)) {
                    if (bbW != null) {
                        return (d) bbW;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.builtins.g Q(k kVar) {
        h.e(kVar, "$receiver");
        return P(kVar).bdy();
    }

    public static final boolean e(aq aqVar) {
        h.e(aqVar, "$receiver");
        Boolean a = kotlin.reflect.jvm.internal.impl.utils.b.a((Collection) l.cr(aqVar), (kotlin.reflect.jvm.internal.impl.utils.b.b) a.eRt, (kotlin.jvm.a.b) DescriptorUtilsKt$declaresOrInheritsDefaultValue$2.eRu);
        h.d(a, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
        return a.booleanValue();
    }

    public static final kotlin.sequences.h<k> R(k kVar) {
        h.e(kVar, "$receiver");
        return k.a((Object) kVar, (kotlin.jvm.a.b) DescriptorUtilsKt$parentsWithSelf$1.eRx);
    }

    public static final kotlin.sequences.h<k> S(k kVar) {
        h.e(kVar, "$receiver");
        return m.a(R(kVar), 1);
    }

    public static final CallableMemberDescriptor H(CallableMemberDescriptor callableMemberDescriptor) {
        h.e(callableMemberDescriptor, "$receiver");
        if (!(callableMemberDescriptor instanceof ac)) {
            return callableMemberDescriptor;
        }
        ad bdH = ((ac) callableMemberDescriptor).bdH();
        h.d(bdH, "correspondingProperty");
        return bdH;
    }

    public static final kotlin.reflect.jvm.internal.impl.name.b h(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        h.e(aVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.name.c z = z(aVar);
        if (!z.isSafe()) {
            z = null;
        }
        return z != null ? z.btP() : null;
    }

    public static /* bridge */ /* synthetic */ CallableMemberDescriptor a(CallableMemberDescriptor callableMemberDescriptor, boolean z, kotlin.jvm.a.b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(callableMemberDescriptor, z, bVar);
    }

    public static final CallableMemberDescriptor a(CallableMemberDescriptor callableMemberDescriptor, boolean z, kotlin.jvm.a.b<? super CallableMemberDescriptor, Boolean> bVar) {
        h.e(callableMemberDescriptor, "$receiver");
        h.e(bVar, "predicate");
        ObjectRef objectRef = new ObjectRef();
        objectRef.element = (CallableMemberDescriptor) null;
        return (CallableMemberDescriptor) kotlin.reflect.jvm.internal.impl.utils.b.a((Collection) l.cr(callableMemberDescriptor), (kotlin.reflect.jvm.internal.impl.utils.b.b) new b(z), (kotlin.reflect.jvm.internal.impl.utils.b.c) new c(objectRef, bVar));
    }

    public static final Collection<d> M(d dVar) {
        h.e(dVar, "sealedClass");
        if (dVar.bbG() != Modality.SEALED) {
            return m.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DescriptorUtilsKt$computeSealedSubclasses$1 descriptorUtilsKt$computeSealedSubclasses$1 = new DescriptorUtilsKt$computeSealedSubclasses$1(dVar, linkedHashSet);
        k bbv = dVar.bbv();
        if (bbv instanceof x) {
            descriptorUtilsKt$computeSealedSubclasses$1.a(((x) bbv).bbk(), false);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bdg = dVar.bdg();
        h.d(bdg, "sealedClass.unsubstitutedInnerClassesScope");
        descriptorUtilsKt$computeSealedSubclasses$1.a(bdg, true);
        return linkedHashSet;
    }

    public static final d l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "$receiver");
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = cVar.bai().bwA().bbW();
        if (!(bbW instanceof d)) {
            bbW = null;
        }
        return (d) bbW;
    }

    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> m(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        h.e(cVar, "$receiver");
        return (kotlin.reflect.jvm.internal.impl.resolve.constants.f) u.N((Iterable) cVar.bee().values());
    }
}
