package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$simpleType$annotations$1 extends Lambda implements a<List<? extends f>> {
    final /* synthetic */ g $additionalAnnotations;
    final /* synthetic */ Type $proto;
    final /* synthetic */ v this$0;

    TypeDeserializer$simpleType$annotations$1(v vVar, Type type, g gVar) {
        this.this$0 = vVar;
        this.$proto = type;
        this.$additionalAnnotations = gVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<f> invoke() {
        Iterable<c> a = this.this$0.eTh.biq().bxx().a(this.$proto, this.this$0.eTh.aYI());
        Collection arrayList = new ArrayList(n.e(a, 10));
        for (c fVar : a) {
            arrayList.add(new f(fVar, null));
        }
        return u.W(u.b((Collection) (List) arrayList, (Iterable) this.$additionalAnnotations.bek()));
    }
}
