package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getConstructors$1 extends Lambda implements m<j, j, Boolean> {
    final /* synthetic */ TypeSubstitutor $substitutor;

    JvmBuiltInsSettings$getConstructors$1(TypeSubstitutor typeSubstitutor) {
        this.$substitutor = typeSubstitutor;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        return Boolean.valueOf(a((j) obj, (j) obj2));
    }

    public final boolean a(j jVar, j jVar2) {
        h.e(jVar, "$receiver");
        h.e(jVar2, "javaConstructor");
        return OverridingUtil.g((a) jVar, (a) jVar2.b(this.$substitutor)) == Result.OVERRIDABLE;
    }
}
