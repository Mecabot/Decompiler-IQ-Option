package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AnnotationAndConstantLoader.kt */
public interface a<A, C, T> {
    C a(r rVar, Property property, w wVar);

    List<A> a(Type type, c cVar);

    List<A> a(TypeParameter typeParameter, c cVar);

    List<A> a(r rVar, EnumEntry enumEntry);

    List<T> a(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind);

    List<A> a(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind, int i, ValueParameter valueParameter);

    List<A> b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.r.a aVar);

    List<A> b(r rVar, n nVar, AnnotatedCallableKind annotatedCallableKind);
}
