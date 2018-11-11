package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: ReflectionTypes.kt */
final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements a<h> {
    final /* synthetic */ u $module;

    ReflectionTypes$kotlinReflectScope$2(u uVar) {
        this.$module = uVar;
        super(0);
    }

    /* renamed from: bbn */
    public final h invoke() {
        return this.$module.g(i.bbo()).bbk();
    }
}
