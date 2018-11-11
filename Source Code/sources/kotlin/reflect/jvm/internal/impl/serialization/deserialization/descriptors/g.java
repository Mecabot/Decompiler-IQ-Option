package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.metadata.a.c;
import kotlin.reflect.jvm.internal.impl.metadata.a.h;
import kotlin.reflect.jvm.internal.impl.metadata.a.i;
import kotlin.reflect.jvm.internal.impl.metadata.a.k;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* compiled from: DeserializedMemberDescriptor.kt */
public interface g extends s {

    /* compiled from: DeserializedMemberDescriptor.kt */
    public static final class a {
        public static List<i> d(g gVar) {
            return i.eMa.a(gVar.bxV(), gVar.aYI(), gVar.bxK());
        }
    }

    c aYI();

    h aYJ();

    k bxK();

    f bxL();

    n bxV();

    List<i> bxW();
}
