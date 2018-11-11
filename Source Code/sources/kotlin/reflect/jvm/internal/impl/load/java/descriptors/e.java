package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.af;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.aa;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.y;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.z;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.p;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: JavaPropertyDescriptor */
public class e extends y implements b {
    private final boolean eGu;

    public boolean bcT() {
        return false;
    }

    private e(k kVar, g gVar, Modality modality, av avVar, boolean z, f fVar, ai aiVar, ad adVar, Kind kind, boolean z2) {
        super(kVar, adVar, gVar, modality, avVar, z, fVar, kind, aiVar, false, false, false, false, false, false);
        this.eGu = z2;
    }

    public static e a(k kVar, g gVar, Modality modality, av avVar, boolean z, f fVar, ai aiVar, boolean z2) {
        return new e(kVar, gVar, modality, avVar, z, fVar, aiVar, null, Kind.DECLARATION, z2);
    }

    protected y a(k kVar, Modality modality, av avVar, ad adVar, Kind kind, f fVar) {
        return new e(kVar, bbQ(), modality, avVar, bdW(), fVar, ai.eAX, adVar, kind, this.eGu);
    }

    public b a(w wVar, List<i> list, w wVar2) {
        z zVar;
        af afVar;
        w wVar3 = wVar2;
        b eVar = new e(bbv(), bbQ(), bbG(), bbJ(), bdW(), bdc(), bbR(), bfd(), bcW(), this.eGu);
        z bfa = bdI();
        if (bfa != null) {
            zVar = r2;
            z zVar2 = new z(eVar, bfa.bbQ(), bfa.bbG(), bfa.bbJ(), bfa.isDefault(), bfa.isExternal(), bfa.bbN(), bcW(), bfa, bfa.bbR());
            zVar.g(bfa.bdl());
            zVar.T(wVar3);
        } else {
            zVar = null;
        }
        af bdJ = bdJ();
        if (bdJ != null) {
            afVar = r2;
            aa aaVar = new aa(eVar, bdJ.bbQ(), bdJ.bbG(), bdJ.bbJ(), bdJ.isDefault(), bdJ.isExternal(), bdJ.bbN(), bcW(), bdJ, bdJ.bbR());
            afVar.g(afVar.bdl());
            afVar.c((aq) bdJ.bcS().get(0));
        } else {
            afVar = null;
        }
        eVar.a(zVar, afVar);
        eVar.gM(bfb());
        if (this.eEr != null) {
            eVar.a(this.eEr);
        }
        eVar.Q(bcU());
        eVar.a(wVar2, getTypeParameters(), bcP(), wVar);
        return eVar;
    }

    public boolean bdY() {
        w bai = bai();
        return this.eGu && h.L(bai) && (!p.af(bai) || kotlin.reflect.jvm.internal.impl.builtins.g.H(bai));
    }
}
