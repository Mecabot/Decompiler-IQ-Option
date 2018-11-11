package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: PropertySetterDescriptorImpl */
public class aa extends x implements af {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private aq eEa;
    private final af eEb;

    public aa(ad adVar, g gVar, Modality modality, av avVar, boolean z, boolean z2, boolean z3, Kind kind, af afVar, ai aiVar) {
        aa aaVar;
        af afVar2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<set-");
        stringBuilder.append(adVar.bdc());
        stringBuilder.append(">");
        super(modality, avVar, adVar, gVar, f.mF(stringBuilder.toString()), z, z2, z3, kind, aiVar);
        if (afVar != null) {
            aaVar = this;
            afVar2 = afVar;
        } else {
            aaVar = this;
            afVar2 = aaVar;
        }
        aaVar.eEb = afVar2;
    }

    public void c(aq aqVar) {
        this.eEa = aqVar;
    }

    public void bfg() {
        this.eEa = a((af) this, bdH().bcQ());
    }

    public static ah a(af afVar, w wVar) {
        return new ah(afVar, null, 0, g.eBF.bel(), f.mF("<set-?>"), wVar, false, false, false, null, ai.eAX);
    }

    public Collection<? extends af> bcU() {
        return super.gL(false);
    }

    public List<aq> bcS() {
        if (this.eEa != null) {
            return Collections.singletonList(this.eEa);
        }
        throw new IllegalStateException();
    }

    public w bcQ() {
        return a.Q(this).bbf();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((af) this, (Object) d);
    }

    /* renamed from: bfh */
    public af beq() {
        return this.eEb;
    }
}
