package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.name.a;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeConstructor$1$classNestingLevel$1 extends FunctionReference implements b<a, a> {
    public static final TypeDeserializer$typeConstructor$1$classNestingLevel$1 eTv = new TypeDeserializer$typeConstructor$1$classNestingLevel$1();

    TypeDeserializer$typeConstructor$1$classNestingLevel$1() {
        super(1);
    }

    public final d Py() {
        return j.F(a.class);
    }

    public final String getName() {
        return "getOuterClassId";
    }

    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    /* renamed from: f */
    public final a invoke(a aVar) {
        h.e(aVar, "p1");
        return aVar.btI();
    }
}
