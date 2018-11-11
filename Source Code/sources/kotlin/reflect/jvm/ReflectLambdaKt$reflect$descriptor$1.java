package kotlin.reflect.jvm;

import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;", "R", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
/* compiled from: reflectLambda.kt */
final class ReflectLambdaKt$reflect$descriptor$1 extends FunctionReference implements m<p, Function, ah> {
    public static final ReflectLambdaKt$reflect$descriptor$1 euO = new ReflectLambdaKt$reflect$descriptor$1();

    ReflectLambdaKt$reflect$descriptor$1() {
        super(2);
    }

    public final d Py() {
        return j.F(p.class);
    }

    public final String getName() {
        return "loadFunction";
    }

    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    /* renamed from: a */
    public final ah B(p pVar, Function function) {
        h.e(pVar, "p1");
        h.e(function, "p2");
        return pVar.h(function);
    }
}
