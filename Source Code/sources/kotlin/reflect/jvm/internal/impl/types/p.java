package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: ErrorUtils */
public class p {
    private static final u eUC = new u() {
        public <R, D> R a(m<R, D> mVar, D d) {
            return null;
        }

        public k bbv() {
            return null;
        }

        public k bcZ() {
            return this;
        }

        public boolean d(u uVar) {
            return false;
        }

        public g bbQ() {
            return g.eBF.bel();
        }

        public Collection<kotlin.reflect.jvm.internal.impl.name.b> a(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.jvm.a.b<? super f, Boolean> bVar2) {
            return m.emptyList();
        }

        public f bdc() {
            return f.mF("<ERROR MODULE>");
        }

        public z g(kotlin.reflect.jvm.internal.impl.name.b bVar) {
            throw new IllegalStateException("Should not be called!");
        }

        public kotlin.reflect.jvm.internal.impl.builtins.g bdy() {
            return e.baC();
        }
    };
    private static final a eUD = new a(f.mF("<ERROR CLASS>"));
    public static final ad eUE = mU("<LOOP IN SUPERTYPES>");
    private static final w eUF = mU("<ERROR PROPERTY TYPE>");
    private static final ad eUG = byP();
    private static final Set<ad> eUH = Collections.singleton(eUG);

    /* compiled from: ErrorUtils */
    public static class d implements an {
        private final an eUK;
        private final an eUL;

        public an byS() {
            return this.eUK;
        }

        public List<an> getParameters() {
            return this.eUL.getParameters();
        }

        public Collection<w> beu() {
            return this.eUL.beu();
        }

        public boolean bbY() {
            return this.eUL.bbY();
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.f bbW() {
            return this.eUL.bbW();
        }

        public kotlin.reflect.jvm.internal.impl.builtins.g bdy() {
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(this.eUK);
        }
    }

    /* compiled from: ErrorUtils */
    public static class b implements h {
        private final String eRe;

        /* synthetic */ b(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private b(String str) {
            this.eRe = str;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            return p.mS(fVar.asString());
        }

        /* renamed from: h */
        public Set a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            return p.eUH;
        }

        /* renamed from: i */
        public Set b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            return Collections.singleton(p.a(this));
        }

        public Set<f> beC() {
            return Collections.emptySet();
        }

        public Set<f> beD() {
            return Collections.emptySet();
        }

        public Collection<k> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
            return Collections.emptyList();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ErrorScope{");
            stringBuilder.append(this.eRe);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: ErrorUtils */
    private static class c implements h {
        private final String eRe;

        /* synthetic */ c(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private c(String str) {
            this.eRe = str;
        }

        public kotlin.reflect.jvm.internal.impl.descriptors.f c(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.eRe);
            stringBuilder.append(", required name: ");
            stringBuilder.append(fVar);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Collection a(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.eRe);
            stringBuilder.append(", required name: ");
            stringBuilder.append(fVar);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Collection b(f fVar, kotlin.reflect.jvm.internal.impl.incremental.components.b bVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.eRe);
            stringBuilder.append(", required name: ");
            stringBuilder.append(fVar);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Collection<k> a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, kotlin.jvm.a.b<? super f, Boolean> bVar) {
            throw new IllegalStateException(this.eRe);
        }

        public Set<f> beC() {
            throw new IllegalStateException();
        }

        public Set<f> beD() {
            throw new IllegalStateException();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ThrowingScope{");
            stringBuilder.append(this.eRe);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* compiled from: ErrorUtils */
    private static class a extends kotlin.reflect.jvm.internal.impl.descriptors.impl.h {
        /* renamed from: g */
        public kotlin.reflect.jvm.internal.impl.descriptors.d f(TypeSubstitutor typeSubstitutor) {
            return this;
        }

        public a(f fVar) {
            super(p.byQ(), fVar, Modality.OPEN, ClassKind.CLASS, Collections.emptyList(), ai.eAX, false, LockBasedStorageManager.eUc);
            kotlin.reflect.jvm.internal.impl.descriptors.c a = kotlin.reflect.jvm.internal.impl.descriptors.impl.f.a(this, g.eBF.bel(), true, ai.eAX);
            a.a(Collections.emptyList(), au.eBf);
            h mT = p.mT(bdc().asString());
            a.Q(new o(p.a("<ERROR>", this), mT));
            a(mT, Collections.singleton(a), a);
        }

        public String toString() {
            return bdc().asString();
        }

        public h a(as asVar) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error scope for class ");
            stringBuilder.append(bdc());
            stringBuilder.append(" with arguments: ");
            stringBuilder.append(asVar);
            return p.mT(stringBuilder.toString());
        }
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.d mS(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ERROR CLASS: ");
        stringBuilder.append(str);
        stringBuilder.append(">");
        return new a(f.mF(stringBuilder.toString()));
    }

    public static h mT(String str) {
        return z(str, false);
    }

    public static h z(String str, boolean z) {
        if (z) {
            return new c(str, null);
        }
        return new b(str, null);
    }

    private static y byP() {
        y a = y.a(eUD, g.eBF.bel(), Modality.OPEN, au.eBg, true, f.mF("<ERROR PROPERTY>"), Kind.DECLARATION, ai.eAX, false, false, false, false, false, false);
        a.a(eUF, Collections.emptyList(), null, (w) null);
        return a;
    }

    private static ah a(b bVar) {
        ah aVar = new kotlin.reflect.jvm.internal.impl.types.a.a(eUD, bVar);
        aVar.a(null, null, Collections.emptyList(), Collections.emptyList(), mU("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, au.eBg);
        return aVar;
    }

    public static ad mU(String str) {
        return f(str, Collections.emptyList());
    }

    public static ad mV(String str) {
        return a(str, mX(str));
    }

    public static ad a(String str, an anVar) {
        return new o(anVar, mT(str));
    }

    public static ad f(String str, List<ap> list) {
        return new o(mW(str), mT(str), list, false);
    }

    public static an mW(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ERROR : ");
        stringBuilder.append(str);
        stringBuilder.append("]");
        return a(stringBuilder.toString(), eUD);
    }

    public static an mX(String str) {
        return a(str, eUD);
    }

    private static an a(final String str, final a aVar) {
        return new an() {
            public boolean bbY() {
                return false;
            }

            public List<an> getParameters() {
                return m.emptyList();
            }

            public Collection<w> beu() {
                return m.emptyList();
            }

            public kotlin.reflect.jvm.internal.impl.descriptors.f bbW() {
                return aVar;
            }

            public kotlin.reflect.jvm.internal.impl.builtins.g bdy() {
                return e.baC();
            }

            public String toString() {
                return str;
            }
        };
    }

    public static boolean W(k kVar) {
        boolean z = false;
        if (kVar == null) {
            return false;
        }
        if (X(kVar) || X(kVar.bbv()) || kVar == eUC) {
            z = true;
        }
        return z;
    }

    private static boolean X(k kVar) {
        return kVar instanceof a;
    }

    public static u byQ() {
        return eUC;
    }

    public static boolean aA(w wVar) {
        return wVar != null && (wVar.bwA() instanceof d);
    }
}
