package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DescriptorRenderer.kt */
public abstract class b {
    public static final b eOY = ePh.n(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.ePk);
    public static final b eOZ = ePh.n(DescriptorRenderer$Companion$COMPACT$1.ePi);
    public static final b ePa = ePh.n(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.ePj);
    public static final b ePb = ePh.n(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.ePl);
    public static final b ePc = ePh.n(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.ePp);
    public static final b ePd = ePh.n(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.ePn);
    public static final b ePe = ePh.n(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.ePq);
    public static final b ePf = ePh.n(DescriptorRenderer$Companion$DEBUG_TEXT$1.ePm);
    public static final b ePg = ePh.n(DescriptorRenderer$Companion$HTML$1.ePo);
    public static final a ePh = new a();

    /* compiled from: DescriptorRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final b n(kotlin.jvm.a.b<? super f, l> bVar) {
            h.e(bVar, "changeOptions");
            g gVar = new g();
            bVar.invoke(gVar);
            gVar.lock();
            return new d(gVar);
        }

        public final String b(g gVar) {
            h.e(gVar, "classifier");
            if (gVar instanceof am) {
                return "typealias";
            }
            if (gVar instanceof d) {
                d dVar = (d) gVar;
                if (dVar.bbK()) {
                    return "companion object";
                }
                switch (c.aoS[dVar.bbF().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected classifier: ");
            stringBuilder.append(gVar);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    public interface b {

        /* compiled from: DescriptorRenderer.kt */
        public static final class a implements b {
            public static final a ePr = new a();

            public void a(aq aqVar, int i, int i2, StringBuilder stringBuilder) {
                h.e(aqVar, "parameter");
                h.e(stringBuilder, "builder");
            }

            private a() {
            }

            public void b(int i, StringBuilder stringBuilder) {
                h.e(stringBuilder, "builder");
                stringBuilder.append("(");
            }

            public void c(int i, StringBuilder stringBuilder) {
                h.e(stringBuilder, "builder");
                stringBuilder.append(")");
            }

            public void b(aq aqVar, int i, int i2, StringBuilder stringBuilder) {
                h.e(aqVar, "parameter");
                h.e(stringBuilder, "builder");
                if (i != i2 - 1) {
                    stringBuilder.append(", ");
                }
            }
        }

        void a(aq aqVar, int i, int i2, StringBuilder stringBuilder);

        void b(int i, StringBuilder stringBuilder);

        void b(aq aqVar, int i, int i2, StringBuilder stringBuilder);

        void c(int i, StringBuilder stringBuilder);
    }

    public abstract String a(String str, String str2, kotlin.reflect.jvm.internal.impl.builtins.g gVar);

    public abstract String a(c cVar, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String a(ap apVar);

    public abstract String b(f fVar, boolean z);

    public abstract String b(w wVar);

    public abstract String f(kotlin.reflect.jvm.internal.impl.name.c cVar);

    public abstract String s(k kVar);

    public final b n(kotlin.jvm.a.b<? super f, l> bVar) {
        h.e(bVar, "changeOptions");
        if (this == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        }
        g bwt = ((d) this).bvD().bwt();
        bVar.invoke(bwt);
        bwt.lock();
        return new d(bwt);
    }

    public static /* synthetic */ String a(b bVar, c cVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i & 2) != 0) {
            annotationUseSiteTarget = (AnnotationUseSiteTarget) null;
        }
        return bVar.a(cVar, annotationUseSiteTarget);
    }
}
