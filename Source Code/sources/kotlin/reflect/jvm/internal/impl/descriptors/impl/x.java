package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ac;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.r.a;
import kotlin.reflect.jvm.internal.impl.descriptors.r.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: PropertyAccessorDescriptorImpl */
public abstract class x extends k implements ac {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private av eCK;
    private final boolean eCN;
    private final Kind eCY;
    private r eCZ = null;
    private final Modality eCr;
    private final ad eDN;
    private boolean isDefault;
    private final boolean isExternal;

    public void Q(Collection<? extends CallableMemberDescriptor> collection) {
    }

    public <V> V a(b<V> bVar) {
        return null;
    }

    public boolean bbO() {
        return false;
    }

    public boolean bbP() {
        return false;
    }

    public boolean bcT() {
        return false;
    }

    public boolean bcb() {
        return false;
    }

    public boolean bdm() {
        return false;
    }

    public boolean bdn() {
        return false;
    }

    public boolean bdo() {
        return false;
    }

    public boolean bdp() {
        return false;
    }

    public boolean bdq() {
        return false;
    }

    /* renamed from: beZ */
    public abstract ac beq();

    public x(Modality modality, av avVar, ad adVar, g gVar, f fVar, boolean z, boolean z2, boolean z3, Kind kind, ai aiVar) {
        super(adVar.bbv(), gVar, fVar, aiVar);
        this.eCr = modality;
        this.eCK = avVar;
        this.eDN = adVar;
        this.isDefault = z;
        this.isExternal = z2;
        this.eCN = z3;
        this.eCY = kind;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void gK(boolean z) {
        this.isDefault = z;
    }

    public Kind bcW() {
        return this.eCY;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean bbN() {
        return this.eCN;
    }

    /* renamed from: c */
    public r f(TypeSubstitutor typeSubstitutor) {
        throw new UnsupportedOperationException();
    }

    public List<an> getTypeParameters() {
        return Collections.emptyList();
    }

    public Modality bbG() {
        return this.eCr;
    }

    public av bbJ() {
        return this.eCK;
    }

    public void d(av avVar) {
        this.eCK = avVar;
    }

    public ad bdH() {
        return this.eDN;
    }

    public ag bcO() {
        return bdH().bcO();
    }

    public ag bcP() {
        return bdH().bcP();
    }

    public a<? extends r> bdr() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* renamed from: d */
    public ac a(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    protected Collection<ac> gL(boolean z) {
        Collection<ac> arrayList = new ArrayList(0);
        for (ad adVar : bdH().bcU()) {
            Object bdI = z ? adVar.bdI() : adVar.bdJ();
            if (bdI != null) {
                arrayList.add(bdI);
            }
        }
        return arrayList;
    }

    public r bdl() {
        return this.eCZ;
    }

    public void g(r rVar) {
        this.eCZ = rVar;
    }
}
