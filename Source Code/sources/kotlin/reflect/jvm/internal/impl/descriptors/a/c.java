package kotlin.reflect.jvm.internal.impl.descriptors.a;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.d;

/* compiled from: PlatformDependentDeclarationFilter.kt */
public interface c {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class a implements c {
        public static final a eBT = new a();

        public boolean a(d dVar, ah ahVar) {
            h.e(dVar, "classDescriptor");
            h.e(ahVar, "functionDescriptor");
            return true;
        }

        private a() {
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class b implements c {
        public static final b eBU = new b();

        private b() {
        }

        public boolean a(d dVar, ah ahVar) {
            h.e(dVar, "classDescriptor");
            h.e(ahVar, "functionDescriptor");
            return ahVar.bbQ().k(d.bem()) ^ 1;
        }
    }

    boolean a(d dVar, ah ahVar);
}
