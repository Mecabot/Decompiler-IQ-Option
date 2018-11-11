package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ah;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.a;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: SimpleFunctionDescriptorImpl */
public class ac extends o implements ah {
    protected ac(k kVar, ah ahVar, g gVar, f fVar, Kind kind, ai aiVar) {
        super(kVar, ahVar, gVar, fVar, kind, aiVar);
    }

    public static ac a(k kVar, g gVar, f fVar, Kind kind, ai aiVar) {
        return new ac(kVar, null, gVar, fVar, kind, aiVar);
    }

    /* renamed from: b */
    public ac a(w wVar, ag agVar, List<? extends an> list, List<aq> list2, w wVar2, Modality modality, av avVar) {
        return a(wVar, agVar, list, list2, wVar2, modality, avVar, null);
    }

    public ac a(w wVar, ag agVar, List<? extends an> list, List<aq> list2, w wVar2, Modality modality, av avVar, Map<? extends b<?>, ?> map) {
        super.a(wVar, agVar, list, list2, wVar2, modality, avVar);
        if (!(map == null || map.isEmpty())) {
            this.eDa = new LinkedHashMap(map);
        }
        return this;
    }

    /* renamed from: bfi */
    public ah beq() {
        return (ah) super.beq();
    }

    protected o a(k kVar, r rVar, Kind kind, f fVar, g gVar, ai aiVar) {
        ah ahVar = (ah) rVar;
        if (fVar == null) {
            fVar = bdc();
        }
        return new ac(kVar, ahVar, gVar, fVar, kind, aiVar);
    }

    /* renamed from: f */
    public ah c(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        return (ah) super.a(kVar, modality, avVar, kind, z);
    }

    public a<? extends ah> bdr() {
        return super.bdr();
    }
}
