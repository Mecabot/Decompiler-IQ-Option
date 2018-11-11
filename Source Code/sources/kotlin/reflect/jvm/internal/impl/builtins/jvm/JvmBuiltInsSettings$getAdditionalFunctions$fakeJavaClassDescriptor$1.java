package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.components.g;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1 extends Lambda implements a<f> {
    final /* synthetic */ f $javaAnalogueDescriptor;
    final /* synthetic */ d $kotlinMutableClassIfContainer;

    JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1(f fVar, d dVar) {
        this.$javaAnalogueDescriptor = fVar;
        this.$kotlinMutableClassIfContainer = dVar;
        super(0);
    }

    /* renamed from: bcK */
    public final f invoke() {
        f fVar = this.$javaAnalogueDescriptor;
        g gVar = g.eGk;
        h.d(gVar, "JavaResolverCache.EMPTY");
        return fVar.a(gVar, this.$kotlinMutableClassIfContainer);
    }
}
