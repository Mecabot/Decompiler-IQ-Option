package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1 extends Lambda implements a<ad> {
    final /* synthetic */ JvmBuiltInsSettings this$0;

    JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.this$0 = jvmBuiltInsSettings;
        super(0);
    }

    /* renamed from: bcI */
    public final ad invoke() {
        ad baU = this.this$0.eAh.bdy().baU();
        h.d(baU, "moduleDescriptor.builtIns.anyType");
        return baU;
    }
}
