package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.z;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1 extends Lambda implements b<v, Boolean> {
    public static final JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1 eIn = new JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1();

    JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(b((v) obj));
    }

    public final boolean b(v vVar) {
        if (!(vVar instanceof z)) {
            vVar = null;
        }
        z zVar = (z) vVar;
        return (zVar == null || zVar.bhM() == null || zVar.bhN()) ? false : true;
    }
}
