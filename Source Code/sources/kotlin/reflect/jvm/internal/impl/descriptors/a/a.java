package kotlin.reflect.jvm.internal.impl.descriptors.a;

import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AdditionalClassPartsProvider.kt */
public interface a {

    /* compiled from: AdditionalClassPartsProvider.kt */
    public static final class a implements a {
        public static final a eBS = new a();

        private a() {
        }

        public Collection<w> l(d dVar) {
            h.e(dVar, "classDescriptor");
            return m.emptyList();
        }

        public Collection<ah> a(f fVar, d dVar) {
            h.e(fVar, "name");
            h.e(dVar, "classDescriptor");
            return m.emptyList();
        }

        public Collection<f> n(d dVar) {
            h.e(dVar, "classDescriptor");
            return m.emptyList();
        }

        public Collection<c> p(d dVar) {
            h.e(dVar, "classDescriptor");
            return m.emptyList();
        }
    }

    Collection<ah> a(f fVar, d dVar);

    Collection<w> l(d dVar);

    Collection<f> n(d dVar);

    Collection<c> p(d dVar);
}
