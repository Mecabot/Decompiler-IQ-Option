package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.al.a;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.b;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.metadata.a.g;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.j;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.s;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
public final class m extends b {
    private final j eTh;
    private final a eUa = new a(this.eTh.baI(), new DeserializedTypeParameterDescriptor$annotations$1(this));
    private final TypeParameter eUb;

    public m(j jVar, TypeParameter typeParameter, int i) {
        h.e(jVar, "c");
        h.e(typeParameter, "proto");
        kotlin.reflect.jvm.internal.impl.storage.h baI = jVar.baI();
        k bbv = jVar.bbv();
        f b = q.b(jVar.aYI(), typeParameter.blW());
        s sVar = s.eTk;
        Variance bpG = typeParameter.bpG();
        h.d(bpG, "proto.variance");
        super(baI, bbv, b, sVar.b(bpG), typeParameter.bpE(), i, ai.eAX, a.eAZ);
        this.eTh = jVar;
        this.eUb = typeParameter;
    }

    /* renamed from: byz */
    public a bbQ() {
        return this.eUa;
    }

    protected List<w> bev() {
        List a = g.a(this.eUb, this.eTh.aYJ());
        if (a.isEmpty()) {
            return l.cr(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(this).baW());
        }
        Iterable<Type> iterable = a;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (Type a2 : iterable) {
            arrayList.add(this.eTh.bxI().a(a2, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.eBF.bel()));
        }
        return (List) arrayList;
    }

    /* renamed from: aw */
    protected Void P(w wVar) {
        h.e(wVar, Param.TYPE);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There should be no cycles for deserialized type parameters, but found for: ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }
}
