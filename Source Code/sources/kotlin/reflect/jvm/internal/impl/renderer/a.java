package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* compiled from: ClassifierNamePolicy.kt */
public interface a {

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class a implements a {
        public static final a eOV = new a();

        private a() {
        }

        public String a(f fVar, b bVar) {
            h.e(fVar, "classifier");
            h.e(bVar, "renderer");
            if (fVar instanceof an) {
                kotlin.reflect.jvm.internal.impl.name.f bdc = ((an) fVar).bdc();
                h.d(bdc, "classifier.name");
                return bVar.b(bdc, false);
            }
            kotlin.reflect.jvm.internal.impl.name.c w = kotlin.reflect.jvm.internal.impl.resolve.c.w(fVar);
            h.d(w, "DescriptorUtils.getFqName(classifier)");
            return bVar.f(w);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class b implements a {
        public static final b eOW = new b();

        private b() {
        }

        public String a(f fVar, b bVar) {
            h.e(fVar, "classifier");
            h.e(bVar, "renderer");
            if (fVar instanceof an) {
                kotlin.reflect.jvm.internal.impl.name.f bdc = ((an) fVar).bdc();
                h.d(bdc, "classifier.name");
                return bVar.b(bdc, false);
            }
            ArrayList arrayList = new ArrayList();
            k kVar = fVar;
            do {
                arrayList.add(kVar.bdc());
                kVar = kVar.bbv();
            } while (kVar instanceof d);
            return j.cj(s.bT(arrayList));
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class c implements a {
        public static final c eOX = new c();

        private c() {
        }

        public String a(f fVar, b bVar) {
            h.e(fVar, "classifier");
            h.e(bVar, "renderer");
            return a(fVar);
        }

        private final String a(f fVar) {
            kotlin.reflect.jvm.internal.impl.name.f bdc = fVar.bdc();
            h.d(bdc, "descriptor.name");
            String K = j.K(bdc);
            if (fVar instanceof an) {
                return K;
            }
            k bbv = fVar.bbv();
            h.d(bbv, "descriptor.containingDeclaration");
            String r = r(bbv);
            if (!(r == null || (h.E(r, "") ^ 1) == 0)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(r);
                stringBuilder.append(".");
                stringBuilder.append(K);
                K = stringBuilder.toString();
            }
            return K;
        }

        private final String r(k kVar) {
            if (kVar instanceof d) {
                return a((f) kVar);
            }
            if (!(kVar instanceof x)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.name.c btL = ((x) kVar).bdD().btL();
            h.d(btL, "descriptor.fqName.toUnsafe()");
            return j.g(btL);
        }
    }

    String a(f fVar, b bVar);
}
