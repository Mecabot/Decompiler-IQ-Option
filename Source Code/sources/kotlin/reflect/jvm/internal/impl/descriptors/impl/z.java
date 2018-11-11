package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ae;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: PropertyGetterDescriptorImpl */
public class z extends x implements ae {
    private w eDY;
    private final ae eDZ;

    public z(ad adVar, g gVar, Modality modality, av avVar, boolean z, boolean z2, boolean z3, Kind kind, ae aeVar, ai aiVar) {
        z zVar;
        ae aeVar2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<get-");
        stringBuilder.append(adVar.bdc());
        stringBuilder.append(">");
        super(modality, avVar, adVar, gVar, f.mF(stringBuilder.toString()), z, z2, z3, kind, aiVar);
        if (aeVar != null) {
            zVar = this;
            aeVar2 = aeVar;
        } else {
            zVar = this;
            aeVar2 = zVar;
        }
        zVar.eDZ = aeVar2;
    }

    public void T(w wVar) {
        if (wVar == null) {
            wVar = bdH().bai();
        }
        this.eDY = wVar;
    }

    public Collection<? extends ae> bcU() {
        return super.gL(true);
    }

    public List<aq> bcS() {
        return Collections.emptyList();
    }

    public w bcQ() {
        return this.eDY;
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((ae) this, (Object) d);
    }

    /* renamed from: bff */
    public ae beq() {
        return this.eDZ;
    }
}
