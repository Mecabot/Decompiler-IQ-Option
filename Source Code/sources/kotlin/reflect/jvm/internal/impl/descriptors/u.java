package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: ModuleDescriptor.kt */
public interface u extends k {

    /* compiled from: ModuleDescriptor.kt */
    public static final class a<T> {
        private final String name;

        public a(String str) {
            h.e(str, "name");
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: ModuleDescriptor.kt */
    public static final class b {
        public static k e(u uVar) {
            return null;
        }

        public static <R, D> R a(u uVar, m<R, D> mVar, D d) {
            h.e(mVar, "visitor");
            return mVar.a(uVar, (Object) d);
        }
    }

    Collection<kotlin.reflect.jvm.internal.impl.name.b> a(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.jvm.a.b<? super f, Boolean> bVar2);

    g bdy();

    boolean d(u uVar);

    z g(kotlin.reflect.jvm.internal.impl.name.b bVar);
}
