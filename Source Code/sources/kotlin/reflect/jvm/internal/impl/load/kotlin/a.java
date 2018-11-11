package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.k;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.load.java.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.a.g;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.j;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public abstract class a<A, C, T> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.a<A, C, T> {
    private static final Set<kotlin.reflect.jvm.internal.impl.name.a> eJj;
    @Deprecated
    public static final a eJk = new a();
    private final m eGy;
    private final kotlin.reflect.jvm.internal.impl.storage.b<n, b<A, C>> eJi;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    private static final class b<A, C> {
        private final Map<q, List<A>> eJl;
        private final Map<q, C> eJm;

        public b(Map<q, ? extends List<? extends A>> map, Map<q, ? extends C> map2) {
            h.e(map, "memberAnnotations");
            h.e(map2, "propertyConstants");
            this.eJl = map;
            this.eJm = map2;
        }

        public final Map<q, List<A>> bin() {
            return this.eJl;
        }

        public final Map<q, C> bio() {
            return this.eJm;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class c implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.d {
        final /* synthetic */ HashMap eJn;
        final /* synthetic */ HashMap eJo;
        final /* synthetic */ a this$0;

        /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        public class b implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.c {
            final /* synthetic */ c eJp;
            private final ArrayList<A> eJq = new ArrayList();
            private final q eJr;

            public b(c cVar, q qVar) {
                h.e(qVar, "signature");
                this.eJp = cVar;
                this.eJr = qVar;
            }

            protected final q bip() {
                return this.eJr;
            }

            public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar) {
                h.e(aVar, "classId");
                h.e(aiVar, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
                return this.eJp.this$0.b(aVar, aiVar, (List) this.eJq);
            }

            public void visitEnd() {
                if ((this.eJq.isEmpty() ^ 1) != 0) {
                    this.eJp.eJn.put(this.eJr, this.eJq);
                }
            }
        }

        /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        public final class a extends b implements e {
            final /* synthetic */ c eJp;

            public a(c cVar, q qVar) {
                h.e(qVar, "signature");
                this.eJp = cVar;
                super(cVar, qVar);
            }

            public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(int i, kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar) {
                h.e(aVar, "classId");
                h.e(aiVar, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
                q a = q.eJW.a(bip(), i);
                List list = (List) this.eJp.eJn.get(a);
                if (list == null) {
                    list = new ArrayList();
                    this.eJp.eJn.put(a, list);
                }
                return this.eJp.this$0.b(aVar, aiVar, list);
            }
        }

        c(a aVar, HashMap hashMap, HashMap hashMap2) {
            this.this$0 = aVar;
            this.eJn = hashMap;
            this.eJo = hashMap2;
        }

        public e a(f fVar, String str) {
            h.e(fVar, "name");
            h.e(str, "desc");
            kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar = q.eJW;
            String asString = fVar.asString();
            h.d(asString, "name.asString()");
            return new a(this, aVar.bc(asString, str));
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.c a(f fVar, String str, Object obj) {
            h.e(fVar, "name");
            h.e(str, "desc");
            kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar = q.eJW;
            String asString = fVar.asString();
            h.d(asString, "name.asString()");
            q bd = aVar.bd(asString, str);
            if (obj != null) {
                Object q = this.this$0.q(str, obj);
                if (q != null) {
                    this.eJo.put(bd, q);
                }
            }
            return new b(this, bd);
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class d implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.c {
        final /* synthetic */ ArrayList $result;
        final /* synthetic */ a this$0;

        public void visitEnd() {
        }

        d(a aVar, ArrayList arrayList) {
            this.this$0 = aVar;
            this.$result = arrayList;
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar) {
            h.e(aVar, "classId");
            h.e(aiVar, com.google.firebase.analytics.FirebaseAnalytics.b.SOURCE);
            return this.this$0.b(aVar, aiVar, (List) this.$result);
        }
    }

    protected abstract A a(Annotation annotation, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar);

    protected abstract List<T> a(List<? extends A> list, List<? extends A> list2, AnnotationUseSiteTarget annotationUseSiteTarget);

    protected abstract kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar, List<A> list);

    protected byte[] b(n nVar) {
        h.e(nVar, "kotlinClass");
        return null;
    }

    protected abstract C cP(C c);

    protected abstract List<T> ci(List<? extends A> list);

    protected abstract C q(String str, Object obj);

    public a(kotlin.reflect.jvm.internal.impl.storage.h hVar, m mVar) {
        h.e(hVar, "storageManager");
        h.e(mVar, "kotlinClassFinder");
        this.eGy = mVar;
        this.eJi = hVar.o(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    private final kotlin.reflect.jvm.internal.impl.load.kotlin.n.a b(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar, List<A> list) {
        if (eJj.contains(aVar)) {
            return null;
        }
        return a(aVar, aiVar, (List) list);
    }

    private final n a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar) {
        ai bbR = aVar.bbR();
        if (!(bbR instanceof p)) {
            bbR = null;
        }
        p pVar = (p) bbR;
        return pVar != null ? pVar.biC() : null;
    }

    public List<A> b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar) {
        h.e(aVar, "container");
        n a = a(aVar);
        if (a != null) {
            ArrayList arrayList = new ArrayList(1);
            a.a((kotlin.reflect.jvm.internal.impl.load.kotlin.n.c) new d(this, arrayList), b(a));
            return arrayList;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class for loading annotations is not found: ");
        stringBuilder.append(aVar.bxN());
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    public List<T> a(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        n nVar2 = nVar;
        AnnotatedCallableKind annotatedCallableKind2 = annotatedCallableKind;
        r rVar2 = rVar;
        h.e(rVar2, "container");
        h.e(nVar2, "proto");
        h.e(annotatedCallableKind2, "kind");
        if (annotatedCallableKind2 == AnnotatedCallableKind.PROPERTY) {
            AnnotationUseSiteTarget annotationUseSiteTarget;
            Property property = (Property) nVar2;
            Property property2 = property;
            q a = a(this, property2, rVar.aYI(), rVar.aYJ(), false, true, 8, null);
            q a2 = a(this, property2, rVar.aYI(), rVar.aYJ(), true, false, 16, null);
            Boolean lc = kotlin.reflect.jvm.internal.impl.metadata.a.b.eLC.get(property.getFlags());
            boolean g = j.g(property);
            List a3 = a != null ? a(this, rVar2, a, true, false, lc, g, 8, null) : null;
            if (a3 == null) {
                a3 = m.emptyList();
            }
            List list = a3;
            a3 = a2 != null ? a(rVar2, a2, true, true, lc, g) : null;
            if (a3 == null) {
                a3 = m.emptyList();
            }
            boolean z = false;
            if (a2 != null) {
                String biD = a2.biD();
                if (biD != null) {
                    z = v.b((CharSequence) biD, (CharSequence) "$delegate", false, 2, null);
                }
            }
            if (z) {
                annotationUseSiteTarget = AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD;
            } else {
                annotationUseSiteTarget = AnnotationUseSiteTarget.FIELD;
            }
            return a(list, a3, annotationUseSiteTarget);
        }
        q a4 = a(nVar2, rVar.aYI(), rVar.aYJ(), annotatedCallableKind2);
        if (a4 != null) {
            return ci(a(this, rVar2, a4, false, false, null, false, 60, null));
        }
        return m.emptyList();
    }

    public List<A> a(r rVar, EnumEntry enumEntry) {
        h.e(rVar, "container");
        h.e(enumEntry, "proto");
        kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar = q.eJW;
        String string = rVar.aYI().getString(enumEntry.blW());
        String asString = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) rVar).getClassId().asString();
        h.d(asString, "(container as ProtoConta…Class).classId.asString()");
        return a(this, rVar, aVar.bd(string, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.c.my(asString)), false, false, null, false, 60, null);
    }

    static /* synthetic */ List a(a aVar, r rVar, q qVar, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        return aVar.a(rVar, qVar, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? (Boolean) null : bool, (i & 32) != 0 ? false : z3);
    }

    private final List<A> a(r rVar, q qVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        n a = a(rVar, a(rVar, z, z2, bool, z3));
        if (a == null) {
            return m.emptyList();
        }
        List<A> list = (List) ((b) this.eJi.invoke(a)).bin().get(qVar);
        if (list == null) {
            list = m.emptyList();
        }
        return list;
    }

    public List<A> a(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind, int i, ValueParameter valueParameter) {
        h.e(rVar, "container");
        h.e(nVar, "callableProto");
        h.e(annotatedCallableKind, "kind");
        h.e(valueParameter, "proto");
        q a = a(nVar, rVar.aYI(), rVar.aYJ(), annotatedCallableKind);
        if (a == null) {
            return m.emptyList();
        }
        return a(this, rVar, q.eJW.a(a, i + a(rVar, nVar)), false, false, null, false, 60, null);
    }

    private final int a(r rVar, n nVar) {
        if (nVar instanceof Function) {
            if (!g.g((Function) nVar)) {
                return 0;
            }
        } else if (nVar instanceof Property) {
            if (!g.f((Property) nVar)) {
                return 0;
            }
        } else if (!(nVar instanceof Constructor)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported message: ");
            stringBuilder.append(nVar.getClass());
            throw new UnsupportedOperationException(stringBuilder.toString());
        } else if (rVar == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        } else {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) rVar;
            if (aVar.bxO() == Kind.ENUM_CLASS) {
                return 2;
            }
            if (!aVar.bbL()) {
                return 0;
            }
        }
        return 1;
    }

    public List<A> b(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        h.e(rVar, "container");
        h.e(nVar, "proto");
        h.e(annotatedCallableKind, "kind");
        q a = a(nVar, rVar.aYI(), rVar.aYJ(), annotatedCallableKind);
        if (a == null) {
            return m.emptyList();
        }
        return a(this, rVar, q.eJW.a(a, 0), false, false, null, false, 60, null);
    }

    public List<A> a(Type type, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        h.e(type, "proto");
        h.e(cVar, "nameResolver");
        Object e = type.e(JvmProtoBuf.eMn);
        h.d(e, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<Annotation> iterable = (Iterable) e;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Annotation annotation : iterable) {
            h.d(annotation, "it");
            arrayList.add(a(annotation, cVar));
        }
        return (List) arrayList;
    }

    public List<A> a(TypeParameter typeParameter, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        h.e(typeParameter, "proto");
        h.e(cVar, "nameResolver");
        Object e = typeParameter.e(JvmProtoBuf.eMp);
        h.d(e, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<Annotation> iterable = (Iterable) e;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Annotation annotation : iterable) {
            h.d(annotation, "it");
            arrayList.add(a(annotation, cVar));
        }
        return (List) arrayList;
    }

    public C a(r rVar, Property property, w wVar) {
        h.e(rVar, "container");
        h.e(property, "proto");
        h.e(wVar, "expectedType");
        q a = a((n) property, rVar.aYI(), rVar.aYJ(), AnnotatedCallableKind.PROPERTY);
        if (a == null) {
            return null;
        }
        n a2 = a(rVar, a(rVar, true, true, kotlin.reflect.jvm.internal.impl.metadata.a.b.eLC.get(property.getFlags()), j.g(property)));
        if (a2 == null) {
            return null;
        }
        C c = ((b) this.eJi.invoke(a2)).bio().get(a);
        if (c == null) {
            return null;
        }
        if (k.ezF.I(wVar)) {
            c = cP(c);
        }
        return c;
    }

    private final n a(r rVar, n nVar) {
        if (nVar != null) {
            return nVar;
        }
        return rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a ? a((kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) rVar) : null;
    }

    private final n a(r rVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar;
        if (z) {
            if (bool == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isConst should not be null for property (container=");
                stringBuilder.append(rVar);
                stringBuilder.append(')');
                throw new IllegalStateException(stringBuilder.toString().toString());
            }
            m mVar;
            kotlin.reflect.jvm.internal.impl.name.a B;
            if (rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) {
                aVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) rVar;
                if (aVar.bxO() == Kind.INTERFACE) {
                    mVar = this.eGy;
                    B = aVar.getClassId().B(f.mD("DefaultImpls"));
                    h.d(B, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                    return mVar.b(B);
                }
            }
            if (bool.booleanValue() && (rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.b)) {
                ai bbR = rVar.bbR();
                if (!(bbR instanceof i)) {
                    bbR = null;
                }
                i iVar = (i) bbR;
                kotlin.reflect.jvm.internal.impl.resolve.jvm.b biw = iVar != null ? iVar.biw() : null;
                if (biw != null) {
                    mVar = this.eGy;
                    String internalName = biw.getInternalName();
                    h.d(internalName, "facadeClassName.internalName");
                    B = kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b(u.a(internalName, '/', '.', false, 4, null)));
                    h.d(B, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
                    return mVar.b(B);
                }
            }
        }
        if (z2 && (rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a)) {
            aVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a) rVar;
            if (aVar.bxO() == Kind.COMPANION_OBJECT) {
                aVar = aVar.bxP();
                if (aVar != null && (aVar.bxO() == Kind.CLASS || aVar.bxO() == Kind.ENUM_CLASS || (z3 && (aVar.bxO() == Kind.INTERFACE || aVar.bxO() == Kind.ANNOTATION_CLASS)))) {
                    return a(aVar);
                }
            }
        }
        if (!(rVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.b) || !(rVar.bbR() instanceof i)) {
            return null;
        }
        ai bbR2 = rVar.bbR();
        if (bbR2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        i iVar2 = (i) bbR2;
        n bix = iVar2.bix();
        if (bix == null) {
            bix = this.eGy.b(iVar2.getClassId());
        }
        return bix;
    }

    private final b<A, C> c(n nVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        nVar.a((kotlin.reflect.jvm.internal.impl.load.kotlin.n.d) new c(this, hashMap, hashMap2), b(nVar));
        return new b(hashMap, hashMap2);
    }

    static /* synthetic */ q a(a aVar, Property property, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
        }
        return aVar.a(property, cVar, hVar, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    private final q a(Property property, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar, boolean z, boolean z2) {
        ExtendableMessage extendableMessage = property;
        GeneratedMessageLite.e eVar = JvmProtoBuf.eMl;
        h.d(eVar, "propertySignature");
        JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z) {
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.a a = j.eMR.a(property, cVar, hVar);
            if (a != null) {
                return q.eJW.a(a);
            }
            return null;
        } else if (!z2 || !jvmPropertySignature.bsC()) {
            return null;
        } else {
            kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar = q.eJW;
            JvmMethodSignature bsD = jvmPropertySignature.bsD();
            h.d(bsD, "signature.syntheticMethod");
            return aVar.a(cVar, bsD);
        }
    }

    private final q a(n nVar, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar, kotlin.reflect.jvm.internal.impl.metadata.a.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        q qVar = null;
        kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f.b a;
        if (nVar instanceof Constructor) {
            aVar = q.eJW;
            a = j.eMR.a((Constructor) nVar, cVar, hVar);
            if (a == null) {
                return null;
            }
            qVar = aVar.a(a);
        } else if (nVar instanceof Function) {
            aVar = q.eJW;
            a = j.eMR.a((Function) nVar, cVar, hVar);
            if (a == null) {
                return null;
            }
            qVar = aVar.a(a);
        } else if (nVar instanceof Property) {
            ExtendableMessage extendableMessage = (ExtendableMessage) nVar;
            GeneratedMessageLite.e eVar = JvmProtoBuf.eMl;
            h.d(eVar, "propertySignature");
            JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.a.f.a(extendableMessage, eVar);
            if (jvmPropertySignature != null) {
                kotlin.reflect.jvm.internal.impl.load.kotlin.q.a aVar2;
                JvmMethodSignature bsF;
                switch (annotatedCallableKind) {
                    case PROPERTY_GETTER:
                        if (jvmPropertySignature.bsE()) {
                            aVar2 = q.eJW;
                            bsF = jvmPropertySignature.bsF();
                            h.d(bsF, "signature.getter");
                            qVar = aVar2.a(cVar, bsF);
                            break;
                        }
                        break;
                    case PROPERTY_SETTER:
                        if (jvmPropertySignature.bsG()) {
                            aVar2 = q.eJW;
                            bsF = jvmPropertySignature.bsH();
                            h.d(bsF, "signature.setter");
                            qVar = aVar2.a(cVar, bsF);
                            break;
                        }
                        break;
                    case PROPERTY:
                        qVar = a((Property) nVar, cVar, hVar, true, true);
                        break;
                }
            }
            return null;
        }
        return qVar;
    }

    static {
        Iterable<kotlin.reflect.jvm.internal.impl.name.b> listOf = m.listOf(m.eFk, m.eFn, m.eFo, new kotlin.reflect.jvm.internal.impl.name.b("java.lang.annotation.Target"), new kotlin.reflect.jvm.internal.impl.name.b("java.lang.annotation.Retention"), new kotlin.reflect.jvm.internal.impl.name.b("java.lang.annotation.Documented"));
        Collection arrayList = new ArrayList(n.e(listOf, 10));
        for (kotlin.reflect.jvm.internal.impl.name.b t : listOf) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.name.a.t(t));
        }
        eJj = u.Y((List) arrayList);
    }
}
