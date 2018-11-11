package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.e;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.h;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$notConsideredDeprecation$2 extends Lambda implements a<h> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    JvmBuiltInsSettings$notConsideredDeprecation$2(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.this$0 = jvmBuiltInsSettings;
        super(0);
    }

    /* renamed from: bcN */
    public final h invoke() {
        return new h(l.cr(e.a(this.this$0.eAh.bdy(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
    }
}
