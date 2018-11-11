package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.load.java.structure.n;

/* compiled from: JavaPropertyInitializerEvaluator.kt */
public interface f {

    /* compiled from: JavaPropertyInitializerEvaluator.kt */
    public static final class a implements f {
        public static final a eGj = new a();

        public Void b(n nVar, ad adVar) {
            h.e(nVar, "field");
            h.e(adVar, "descriptor");
            return null;
        }

        private a() {
        }

        public /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.constants.f a(n nVar, ad adVar) {
            return (kotlin.reflect.jvm.internal.impl.resolve.constants.f) b(nVar, adVar);
        }
    }

    kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> a(n nVar, ad adVar);
}
