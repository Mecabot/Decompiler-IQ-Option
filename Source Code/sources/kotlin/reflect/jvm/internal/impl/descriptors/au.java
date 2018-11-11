package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ae;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.e;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.g;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.utils.a;

/* compiled from: Visibilities */
public class au {
    public static final av eBc = new av("private", false) {
        private boolean k(k kVar) {
            return c.M(kVar) != aj.eAY;
        }

        public boolean b(e eVar, o oVar, k kVar) {
            if (c.A((k) oVar) && k(kVar)) {
                return au.a((k) oVar, kVar);
            }
            k bbv;
            if (oVar instanceof j) {
                k bdj = ((j) oVar).bdj();
                if (c.E(bdj) && c.A(bdj) && (kVar instanceof j) && c.A(kVar.bbv()) && au.a((k) oVar, kVar)) {
                    return true;
                }
            }
            while (bbv != null) {
                bbv = bbv.bbv();
                if (!(bbv instanceof d) || c.D(bbv)) {
                    if (bbv instanceof x) {
                        break;
                    }
                }
                break;
            }
            boolean z = false;
            if (bbv == null) {
                return false;
            }
            while (kVar != null) {
                if (bbv == kVar) {
                    return true;
                }
                if (kVar instanceof x) {
                    if ((bbv instanceof x) && ((x) bbv).bdD().equals(((x) kVar).bdD()) && c.f(kVar, bbv)) {
                        z = true;
                    }
                    return z;
                }
                kVar = kVar.bbv();
            }
            return false;
        }
    };
    public static final av eBd = new av("private_to_this", false) {
        public String getDisplayName() {
            return "private/*private to this*/";
        }

        public boolean b(e eVar, o oVar, k kVar) {
            if (au.eBc.b(eVar, oVar, kVar)) {
                if (eVar == au.eBp) {
                    return true;
                }
                if (eVar == au.eBo) {
                    return false;
                }
                k a = c.a((k) oVar, d.class);
                if (a != null && (eVar instanceof g)) {
                    return ((g) eVar).bdP().bdi().equals(a.bcZ());
                }
            }
            return false;
        }
    };
    public static final av eBe = new av("protected", true) {
        public boolean b(e eVar, o oVar, k kVar) {
            k kVar2 = (d) c.a((k) oVar, d.class);
            d dVar = (d) c.a(kVar, d.class, false);
            if (dVar == null) {
                return false;
            }
            if (kVar2 != null && c.D(kVar2)) {
                d dVar2 = (d) c.a(kVar2, d.class);
                if (dVar2 != null && c.d(dVar, dVar2)) {
                    return true;
                }
            }
            kVar2 = c.a(oVar);
            d dVar3 = (d) c.a(kVar2, d.class);
            if (dVar3 == null) {
                return false;
            }
            if (c.d(dVar, dVar3) && a(eVar, kVar2, dVar)) {
                return true;
            }
            return b(eVar, oVar, dVar.bbv());
        }

        private boolean a(e eVar, o oVar, d dVar) {
            boolean z = false;
            if (eVar == au.eBq) {
                return false;
            }
            if (!(oVar instanceof CallableMemberDescriptor) || (oVar instanceof j) || eVar == au.eBp) {
                return true;
            }
            if (eVar == au.eBo || eVar == null) {
                return false;
            }
            w bxm = eVar instanceof f ? ((f) eVar).bxm() : eVar.bai();
            if (c.b(bxm, dVar) || n.az(bxm)) {
                z = true;
            }
            return z;
        }
    };
    public static final av eBf = new av("internal", false) {
        public boolean b(e eVar, o oVar, k kVar) {
            if (c.B(kVar).d(c.B((k) oVar))) {
                return au.eBr.j(oVar, kVar);
            }
            return false;
        }
    };
    public static final av eBg = new av("public", true) {
        public boolean b(e eVar, o oVar, k kVar) {
            return true;
        }
    };
    public static final av eBh = new av("local", false) {
        public boolean b(e eVar, o oVar, k kVar) {
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    };
    public static final av eBi = new av("inherited", false) {
        public boolean b(e eVar, o oVar, k kVar) {
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    public static final av eBj = new av("invisible_fake", false) {
        public boolean b(e eVar, o oVar, k kVar) {
            return false;
        }
    };
    public static final av eBk = new av("unknown", false) {
        public boolean b(e eVar, o oVar, k kVar) {
            return false;
        }
    };
    public static final Set<av> eBl = Collections.unmodifiableSet(aj.I(eBc, eBd, eBf, eBh));
    private static final Map<av, Integer> eBm;
    public static final av eBn = eBg;
    private static final e eBo = new e() {
        public w bai() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final e eBp = new e() {
        public w bai() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    @Deprecated
    public static final e eBq = new e() {
        public w bai() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    private static final kotlin.reflect.jvm.internal.impl.util.g eBr;

    static {
        Map bf = a.bf(4);
        bf.put(eBd, Integer.valueOf(0));
        bf.put(eBc, Integer.valueOf(0));
        bf.put(eBf, Integer.valueOf(1));
        bf.put(eBe, Integer.valueOf(1));
        bf.put(eBg, Integer.valueOf(2));
        eBm = Collections.unmodifiableMap(bf);
        Iterator it = ServiceLoader.load(kotlin.reflect.jvm.internal.impl.util.g.class, kotlin.reflect.jvm.internal.impl.util.g.class.getClassLoader()).iterator();
        eBr = it.hasNext() ? (kotlin.reflect.jvm.internal.impl.util.g) it.next() : kotlin.reflect.jvm.internal.impl.util.g.a.eWj;
    }

    public static boolean a(o oVar, k kVar) {
        return a(eBp, oVar, kVar) == null;
    }

    public static boolean a(k kVar, k kVar2) {
        aj M = c.M(kVar2);
        return M != aj.eAY ? M.equals(c.M(kVar)) : false;
    }

    public static o a(e eVar, o oVar, k kVar) {
        k kVar2 = (o) oVar.bcZ();
        while (kVar2 != null && kVar2.bbJ() != eBh) {
            if (!kVar2.bbJ().b(eVar, kVar2, kVar)) {
                return kVar2;
            }
            o kVar22 = (o) c.a(kVar22, o.class);
        }
        if (oVar instanceof ae) {
            o a = a(eVar, ((ae) oVar).bfj(), kVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    static Integer b(av avVar, av avVar2) {
        if (avVar == avVar2) {
            return Integer.valueOf(0);
        }
        Integer num = (Integer) eBm.get(avVar);
        Integer num2 = (Integer) eBm.get(avVar2);
        return (num == null || num2 == null || num.equals(num2)) ? null : Integer.valueOf(num.intValue() - num2.intValue());
    }

    public static Integer c(av avVar, av avVar2) {
        Integer c = avVar.c(avVar2);
        if (c != null) {
            return c;
        }
        Integer c2 = avVar2.c(avVar);
        return c2 != null ? Integer.valueOf(-c2.intValue()) : null;
    }

    public static boolean b(av avVar) {
        return avVar == eBc || avVar == eBd;
    }
}
