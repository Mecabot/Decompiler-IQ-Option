package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;

/* compiled from: Annotations.kt */
public interface g extends Iterable<c>, kotlin.jvm.internal.a.a {
    public static final a eBF = a.eBH;

    /* compiled from: Annotations.kt */
    public static final class a {
        private static final g eBG = new a();
        static final /* synthetic */ a eBH = new a();

        /* compiled from: Annotations.kt */
        public static final class a implements g {
            public boolean isEmpty() {
                return true;
            }

            public Void l(kotlin.reflect.jvm.internal.impl.name.b bVar) {
                h.e(bVar, "fqName");
                return null;
            }

            public String toString() {
                return "EMPTY";
            }

            a() {
            }

            public /* synthetic */ c j(kotlin.reflect.jvm.internal.impl.name.b bVar) {
                return (c) l(bVar);
            }

            public boolean k(kotlin.reflect.jvm.internal.impl.name.b bVar) {
                h.e(bVar, "fqName");
                return b.b(this, bVar);
            }

            public List<f> bej() {
                return m.emptyList();
            }

            public List<f> bek() {
                return m.emptyList();
            }

            public Iterator<c> iterator() {
                return m.emptyList().iterator();
            }
        }

        private a() {
        }

        public final g bel() {
            return eBG;
        }

        public final c a(g gVar, AnnotationUseSiteTarget annotationUseSiteTarget, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            h.e(gVar, "annotations");
            h.e(annotationUseSiteTarget, "target");
            h.e(bVar, "fqName");
            for (Object next : a(gVar, annotationUseSiteTarget)) {
                if (h.E(((c) next).bdD(), bVar)) {
                    break;
                }
            }
            Object next2 = null;
            return (c) next2;
        }

        private final List<c> a(g gVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
            Collection arrayList = new ArrayList();
            for (f fVar : gVar.bej()) {
                Object beh = fVar.beh();
                if ((annotationUseSiteTarget == fVar.bei() ? 1 : null) == null) {
                    beh = null;
                }
                if (beh != null) {
                    arrayList.add(beh);
                }
            }
            return (List) arrayList;
        }
    }

    /* compiled from: Annotations.kt */
    public static final class b {
        public static c a(g gVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            h.e(bVar, "fqName");
            for (Object next : gVar) {
                if (h.E(((c) next).bdD(), bVar)) {
                    break;
                }
            }
            Object next2 = null;
            return (c) next2;
        }

        public static boolean b(g gVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
            h.e(bVar, "fqName");
            return gVar.j(bVar) != null;
        }
    }

    List<f> bej();

    List<f> bek();

    boolean isEmpty();

    c j(kotlin.reflect.jvm.internal.impl.name.b bVar);

    boolean k(kotlin.reflect.jvm.internal.impl.name.b bVar);
}
