package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.reflect.d;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0015\u0010\u0006\u001a\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "T", "", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$getLocalProperty$2$1$1 extends FunctionReference implements m<p, Property, ad> {
    public static final KClassImpl$getLocalProperty$2$1$1 evM = new KClassImpl$getLocalProperty$2$1$1();

    KClassImpl$getLocalProperty$2$1$1() {
        super(2);
    }

    public final d Py() {
        return j.F(p.class);
    }

    public final String getName() {
        return "loadProperty";
    }

    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    /* renamed from: a */
    public final ad B(p pVar, Property property) {
        h.e(pVar, "p1");
        h.e(property, "p2");
        return pVar.h(property);
    }
}
