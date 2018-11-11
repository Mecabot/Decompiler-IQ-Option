package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.aj;
import kotlin.reflect.jvm.internal.impl.descriptors.as;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.name.h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y;

/* compiled from: DescriptorUtils */
public class c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final f eQA = f.mD("values");
    public static final f eQB = f.mD("valueOf");
    public static final b eQC = new b("kotlin.jvm.JvmName");
    private static final b eQD = new b("kotlin.jvm.Volatile");
    private static final b eQE = new b("kotlin.jvm.Synchronized");
    public static final b eQF = new b("kotlin.coroutines");
    public static final b eQG = eQF.C(f.mD("experimental"));
    public static final b eQH = eQG.C(f.mD("intrinsics"));
    public static final b eQI = eQG.C(f.mD("Continuation"));
    public static final b eQJ = eQF.C(f.mD("Continuation"));
    public static final b eQK = new b("kotlin.SuccessOrFailure");

    private c() {
    }

    public static ag t(k kVar) {
        return kVar instanceof d ? ((d) kVar).bdh() : null;
    }

    public static boolean u(k kVar) {
        while (kVar != null) {
            if (F(kVar) || v(kVar)) {
                return true;
            }
            kVar = kVar.bbv();
        }
        return false;
    }

    public static boolean v(k kVar) {
        return (kVar instanceof o) && ((o) kVar).bbJ() == au.eBh;
    }

    public static kotlin.reflect.jvm.internal.impl.name.c w(k kVar) {
        b y = y(kVar);
        return y != null ? y.btL() : z(kVar);
    }

    public static b x(k kVar) {
        b y = y(kVar);
        return y != null ? y : z(kVar).btP();
    }

    private static b y(k kVar) {
        if ((kVar instanceof u) || p.W(kVar)) {
            return b.eNc;
        }
        if (kVar instanceof z) {
            return ((z) kVar).bdD();
        }
        return kVar instanceof x ? ((x) kVar).bdD() : null;
    }

    private static kotlin.reflect.jvm.internal.impl.name.c z(k kVar) {
        return w(kVar.bbv()).F(kVar.bdc());
    }

    public static boolean A(k kVar) {
        return kVar != null && (kVar.bbv() instanceof x);
    }

    public static boolean f(k kVar, k kVar2) {
        return B(kVar).equals(B(kVar2));
    }

    public static <D extends k> D a(k kVar, Class<D> cls) {
        return a(kVar, cls, true);
    }

    public static <D extends k> D a(k kVar, Class<D> cls, boolean z) {
        if (kVar == null) {
            return null;
        }
        D kVar2;
        if (z) {
            kVar2 = kVar2.bbv();
        }
        while (kVar2 != null) {
            if (cls.isInstance(kVar2)) {
                return kVar2;
            }
            kVar2 = kVar2.bbv();
        }
        return null;
    }

    public static u an(w wVar) {
        k bbW = wVar.bwA().bbW();
        if (bbW == null) {
            return null;
        }
        return C(bbW);
    }

    public static u B(k kVar) {
        return C(kVar);
    }

    public static u C(k kVar) {
        while (kVar != null) {
            if (kVar instanceof u) {
                return (u) kVar;
            }
            if (kVar instanceof z) {
                return ((z) kVar).bar();
            }
            kVar = kVar.bbv();
        }
        return null;
    }

    public static boolean c(d dVar, d dVar2) {
        for (w a : dVar.bby().beu()) {
            if (a(a, dVar2.bdi())) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(d dVar, d dVar2) {
        return b(dVar.bdb(), dVar2.bdi());
    }

    private static boolean a(w wVar, k kVar) {
        k bbW = wVar.bwA().bbW();
        if (bbW != null) {
            bbW = bbW.bcZ();
            if ((bbW instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.f) && ((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar).bby().equals(((kotlin.reflect.jvm.internal.impl.descriptors.f) bbW).bby())) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(w wVar, k kVar) {
        if (a(wVar, kVar)) {
            return true;
        }
        for (w b : wVar.bwA().beu()) {
            if (b(b, kVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean D(k kVar) {
        return a(kVar, ClassKind.OBJECT) && ((d) kVar).bbK();
    }

    public static boolean E(k kVar) {
        return a(kVar, ClassKind.CLASS) && ((d) kVar).bbG() == Modality.SEALED;
    }

    public static boolean F(k kVar) {
        return K(kVar) && kVar.bdc().equals(h.eNo);
    }

    public static boolean G(k kVar) {
        return a(kVar, ClassKind.ENUM_ENTRY);
    }

    public static boolean H(k kVar) {
        return a(kVar, ClassKind.ENUM_CLASS);
    }

    public static boolean I(k kVar) {
        return a(kVar, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean J(k kVar) {
        return a(kVar, ClassKind.INTERFACE);
    }

    public static boolean K(k kVar) {
        return a(kVar, ClassKind.CLASS);
    }

    public static boolean L(k kVar) {
        return K(kVar) || H(kVar);
    }

    private static boolean a(k kVar, ClassKind classKind) {
        return (kVar instanceof d) && ((d) kVar).bbF() == classKind;
    }

    public static d I(d dVar) {
        for (w ao : dVar.bby().beu()) {
            d ao2 = ao(ao);
            if (ao2.bbF() != ClassKind.INTERFACE) {
                return ao2;
            }
        }
        return null;
    }

    public static d ao(w wVar) {
        return b(wVar.bwA());
    }

    public static d b(an anVar) {
        return (d) anVar.bbW();
    }

    public static av J(d dVar) {
        ClassKind bbF = dVar.bbF();
        if (bbF == ClassKind.ENUM_CLASS || bbF.isSingleton() || E(dVar)) {
            return au.eBc;
        }
        if (F(dVar)) {
            return au.eBn;
        }
        return au.eBg;
    }

    public static <D extends CallableMemberDescriptor> D A(D d) {
        while (d.bcW() == Kind.FAKE_OVERRIDE) {
            Collection bcU = d.bcU();
            if (bcU.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fake override should have at least one overridden descriptor: ");
                stringBuilder.append(d);
                throw new IllegalStateException(stringBuilder.toString());
            }
            CallableMemberDescriptor d2 = (CallableMemberDescriptor) bcU.iterator().next();
        }
        return d2;
    }

    public static <D extends o> D a(D d) {
        return d instanceof CallableMemberDescriptor ? A((CallableMemberDescriptor) d) : d;
    }

    public static boolean a(as asVar, w wVar) {
        boolean z = false;
        if (asVar.bdW() || y.aF(wVar)) {
            return false;
        }
        if (kotlin.reflect.jvm.internal.impl.types.au.aX(wVar)) {
            return true;
        }
        g Q = a.Q(asVar);
        if (g.p(wVar) || kotlin.reflect.jvm.internal.impl.types.checker.b.eVr.d(Q.bbg(), wVar) || kotlin.reflect.jvm.internal.impl.types.checker.b.eVr.d(Q.baO().bdb(), wVar) || kotlin.reflect.jvm.internal.impl.types.checker.b.eVr.d(Q.baU(), wVar) || kotlin.reflect.jvm.internal.impl.builtins.k.ezF.I(wVar)) {
            z = true;
        }
        return z;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> e(D d) {
        Set linkedHashSet = new LinkedHashSet();
        a(d.bcR(), linkedHashSet);
        return linkedHashSet;
    }

    private static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> void a(D d, Set<D> set) {
        if (!set.contains(d)) {
            for (kotlin.reflect.jvm.internal.impl.descriptors.a bcR : d.bcR().bcU()) {
                kotlin.reflect.jvm.internal.impl.descriptors.a bcR2 = bcR2.bcR();
                a(bcR2, (Set) set);
                set.add(bcR2);
            }
        }
    }

    public static aj M(k kVar) {
        if (kVar instanceof af) {
            kVar = ((af) kVar).bdH();
        }
        if (kVar instanceof n) {
            return ((n) kVar).bbR().ban();
        }
        return aj.eAY;
    }

    public static CallableMemberDescriptor B(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor instanceof ac ? ((ac) callableMemberDescriptor).bdH() : callableMemberDescriptor;
    }
}
