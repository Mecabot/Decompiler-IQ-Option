package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: BuiltInsLoader.kt */
final class BuiltInsLoader$Companion$Instance$2 extends Lambda implements a<b> {
    public static final BuiltInsLoader$Companion$Instance$2 exi = new BuiltInsLoader$Companion$Instance$2();

    BuiltInsLoader$Companion$Instance$2() {
        super(0);
    }

    /* renamed from: baz */
    public final b invoke() {
        ServiceLoader load = ServiceLoader.load(b.class, b.class.getClassLoader());
        h.d(load, "implementations");
        b bVar = (b) u.N((Iterable) load);
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}
