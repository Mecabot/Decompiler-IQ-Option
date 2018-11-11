package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.g;
import kotlin.reflect.jvm.internal.impl.resolve.constants.i;
import kotlin.reflect.jvm.internal.impl.resolve.constants.j;
import kotlin.reflect.jvm.internal.impl.resolve.constants.l;
import kotlin.reflect.jvm.internal.impl.resolve.constants.p;
import kotlin.reflect.jvm.internal.impl.resolve.constants.r;
import kotlin.reflect.jvm.internal.impl.resolve.constants.t;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class c extends a<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, f<?>, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> {
    private final b eJs = new b(this.ezG, this.ezw);
    private final u ezG;
    private final w ezw;

    /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class a implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.a {
        private final HashMap<kotlin.reflect.jvm.internal.impl.name.f, f<?>> eJt = new HashMap();
        final /* synthetic */ c eJu;
        final /* synthetic */ d eJv;
        final /* synthetic */ List eJw;
        final /* synthetic */ ai eJx;

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class a implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.a {
            final /* synthetic */ ArrayList $list;
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f $name;
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.n.a eJA;
            private final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.n.a eJy;
            final /* synthetic */ a eJz;

            public kotlin.reflect.jvm.internal.impl.load.kotlin.n.b A(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                h.e(fVar, "name");
                return this.eJy.A(fVar);
            }

            public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar) {
                h.e(fVar, "name");
                h.e(aVar, "classId");
                return this.eJy.a(fVar, aVar);
            }

            public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
                this.eJy.a(fVar, obj);
            }

            public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar2) {
                h.e(fVar, "name");
                h.e(aVar, "enumClassId");
                h.e(fVar2, "enumEntryName");
                this.eJy.a(fVar, aVar, fVar2);
            }

            a(a aVar, kotlin.reflect.jvm.internal.impl.load.kotlin.n.a aVar2, kotlin.reflect.jvm.internal.impl.name.f fVar, ArrayList arrayList) {
                this.eJz = aVar;
                this.eJA = aVar2;
                this.$name = fVar;
                this.$list = arrayList;
                this.eJy = aVar2;
            }

            public void visitEnd() {
                this.eJA.visitEnd();
                this.eJz.eJt.put(this.$name, new kotlin.reflect.jvm.internal.impl.resolve.constants.a((kotlin.reflect.jvm.internal.impl.descriptors.annotations.c) u.bY(this.$list)));
            }
        }

        /* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements kotlin.reflect.jvm.internal.impl.load.kotlin.n.b {
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f $name;
            private final ArrayList<f<?>> eJB = new ArrayList();
            final /* synthetic */ a eJz;

            b(a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar) {
                this.eJz = aVar;
                this.$name = fVar;
            }

            public void cQ(Object obj) {
                this.eJB.add(this.eJz.b(this.$name, obj));
            }

            public void b(kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar) {
                h.e(aVar, "enumClassId");
                h.e(fVar, "enumEntryName");
                this.eJB.add(new i(aVar, fVar));
            }

            public void visitEnd() {
                aq b = kotlin.reflect.jvm.internal.impl.load.java.components.a.b(this.$name, this.eJz.eJv);
                if (b != null) {
                    Map a = this.eJz.eJt;
                    kotlin.reflect.jvm.internal.impl.name.f fVar = this.$name;
                    g gVar = g.eRn;
                    List j = kotlin.reflect.jvm.internal.impl.utils.a.j(this.eJB);
                    kotlin.reflect.jvm.internal.impl.types.w bai = b.bai();
                    h.d(bai, "parameter.type");
                    a.put(fVar, gVar.a(j, bai));
                }
            }
        }

        a(c cVar, d dVar, List list, ai aiVar) {
            this.eJu = cVar;
            this.eJv = dVar;
            this.eJw = list;
            this.eJx = aiVar;
        }

        public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
            if (fVar != null) {
                this.eJt.put(fVar, b(fVar, obj));
            }
        }

        public void a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar2) {
            h.e(fVar, "name");
            h.e(aVar, "enumClassId");
            h.e(fVar2, "enumEntryName");
            this.eJt.put(fVar, new i(aVar, fVar2));
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.b A(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            h.e(fVar, "name");
            return new b(this, fVar);
        }

        public kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.f fVar, kotlin.reflect.jvm.internal.impl.name.a aVar) {
            h.e(fVar, "name");
            h.e(aVar, "classId");
            ArrayList arrayList = new ArrayList();
            c cVar = this.eJu;
            ai aiVar = ai.eAX;
            h.d(aiVar, "SourceElement.NO_SOURCE");
            kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a = cVar.a(aVar, aiVar, (List) arrayList);
            if (a == null) {
                h.aXZ();
            }
            return new a(this, a, fVar, arrayList);
        }

        public void visitEnd() {
            this.eJw.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(this.eJv.bdb(), this.eJt, this.eJx));
        }

        private final f<?> b(kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
            f<?> db = g.eRn.db(obj);
            if (db != null) {
                return db;
            }
            kotlin.reflect.jvm.internal.impl.resolve.constants.j.a aVar = j.eRq;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported annotation argument: ");
            stringBuilder.append(fVar);
            return aVar.mQ(stringBuilder.toString());
        }
    }

    public c(u uVar, w wVar, kotlin.reflect.jvm.internal.impl.storage.h hVar, m mVar) {
        h.e(uVar, "module");
        h.e(wVar, "notFoundClasses");
        h.e(hVar, "storageManager");
        h.e(mVar, "kotlinClassFinder");
        super(hVar, mVar);
        this.ezG = uVar;
        this.ezw = wVar;
    }

    /* renamed from: b */
    protected kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(Annotation annotation, kotlin.reflect.jvm.internal.impl.metadata.a.c cVar) {
        h.e(annotation, "proto");
        h.e(cVar, "nameResolver");
        return this.eJs.c(annotation, cVar);
    }

    /* renamed from: r */
    protected f<?> q(String str, Object obj) {
        h.e(str, "desc");
        h.e(obj, "initializer");
        boolean z = false;
        if (v.b((CharSequence) "ZBCS", (CharSequence) str, false, 2, null)) {
            int intValue = ((Integer) obj).intValue();
            int hashCode = str.hashCode();
            if (hashCode != 83) {
                if (hashCode != 90) {
                    switch (hashCode) {
                        case 66:
                            if (str.equals("B")) {
                                obj = Byte.valueOf((byte) intValue);
                                break;
                            }
                            break;
                        case 67:
                            if (str.equals("C")) {
                                obj = Character.valueOf((char) intValue);
                                break;
                            }
                            break;
                    }
                } else if (str.equals("Z")) {
                    if (intValue != 0) {
                        z = true;
                    }
                    obj = Boolean.valueOf(z);
                }
            } else if (str.equals("S")) {
                obj = Short.valueOf((short) intValue);
            }
            throw new AssertionError(str);
        }
        return g.eRn.db(obj);
    }

    /* renamed from: b */
    protected f<?> cP(f<?> fVar) {
        h.e(fVar, "constant");
        if (fVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.d) {
            return new t(((Number) ((kotlin.reflect.jvm.internal.impl.resolve.constants.d) fVar).getValue()).byteValue());
        }
        if (fVar instanceof r) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.w(((Number) ((r) fVar).getValue()).shortValue());
        }
        if (fVar instanceof l) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.u(((Number) ((l) fVar).getValue()).intValue());
        }
        return fVar instanceof p ? new v(((Number) ((p) fVar).getValue()).longValue()) : fVar;
    }

    protected List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> a(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list, List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list2, AnnotationUseSiteTarget annotationUseSiteTarget) {
        h.e(list, "propertyAnnotations");
        h.e(list2, "fieldAnnotations");
        h.e(annotationUseSiteTarget, "fieldUseSiteTarget");
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c fVar : iterable) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.f(fVar, null));
        }
        arrayList = (List) arrayList;
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterable2 = list2;
        Collection arrayList2 = new ArrayList(n.e(iterable2, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c fVar2 : iterable2) {
            arrayList2.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.f(fVar2, annotationUseSiteTarget));
        }
        return u.b(arrayList, (Iterable) (List) arrayList2);
    }

    protected List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.f> ci(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list) {
        h.e(list, "annotations");
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterable = list;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c fVar : iterable) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.f(fVar, null));
        }
        return (List) arrayList;
    }

    protected kotlin.reflect.jvm.internal.impl.load.kotlin.n.a a(kotlin.reflect.jvm.internal.impl.name.a aVar, ai aiVar, List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> list) {
        h.e(aVar, "annotationClassId");
        h.e(aiVar, FirebaseAnalytics.b.SOURCE);
        h.e(list, "result");
        return new a(this, h(aVar), list, aiVar);
    }

    private final d h(kotlin.reflect.jvm.internal.impl.name.a aVar) {
        return q.a(this.ezG, aVar, this.ezw);
    }
}
