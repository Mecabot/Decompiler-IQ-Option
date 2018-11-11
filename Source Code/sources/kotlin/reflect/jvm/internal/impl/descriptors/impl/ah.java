package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.au;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.resolve.constants.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ValueParameterDescriptorImpl.kt */
public class ah extends ai implements aq {
    public static final a eEo = new a();
    private final aq eEj;
    private final boolean eEk;
    private final boolean eEl;
    private final boolean eEm;
    private final w eEn;
    private final int index;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public boolean bdW() {
        return false;
    }

    public Void bfq() {
        return null;
    }

    public /* synthetic */ f bdX() {
        return (f) bfq();
    }

    public boolean bdZ() {
        return kotlin.reflect.jvm.internal.impl.descriptors.aq.a.b(this);
    }

    public int getIndex() {
        return this.index;
    }

    public boolean bdU() {
        return this.eEl;
    }

    public boolean bdV() {
        return this.eEm;
    }

    public w bdS() {
        return this.eEn;
    }

    public ah(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, aq aqVar, int i, g gVar, kotlin.reflect.jvm.internal.impl.name.f fVar, w wVar, boolean z, boolean z2, boolean z3, w wVar2, ai aiVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = aVar;
        h.e(aVar2, "containingDeclaration");
        g gVar2 = gVar;
        h.e(gVar2, "annotations");
        kotlin.reflect.jvm.internal.impl.name.f fVar2 = fVar;
        h.e(fVar2, "name");
        w wVar3 = wVar;
        h.e(wVar3, "outType");
        ai aiVar2 = aiVar;
        h.e(aiVar2, b.SOURCE);
        super(aVar2, gVar2, fVar2, wVar3, aiVar2);
        this.index = i;
        this.eEk = z;
        this.eEl = z2;
        this.eEm = z3;
        this.eEn = wVar2;
        this.eEj = aqVar != null ? aqVar : (aq) this;
    }

    /* renamed from: bdQ */
    public kotlin.reflect.jvm.internal.impl.descriptors.a bbv() {
        k bbv = super.bbv();
        if (bbv != null) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.a) bbv;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
    }

    public boolean bdR() {
        if (this.eEk) {
            kotlin.reflect.jvm.internal.impl.descriptors.a bdQ = bbv();
            if (bdQ == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            }
            Kind bcW = ((CallableMemberDescriptor) bdQ).bcW();
            h.d(bcW, "(containingDeclaration a…bleMemberDescriptor).kind");
            if (bcW.isReal()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: bdT */
    public aq bfd() {
        return this.eEj == ((ah) this) ? this : this.eEj.bdT();
    }

    /* renamed from: j */
    public aq f(TypeSubstitutor typeSubstitutor) {
        h.e(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        h.e(mVar, "visitor");
        return mVar.a((aq) this, (Object) d);
    }

    public aq a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar, int i) {
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = aVar;
        h.e(aVar2, "newOwner");
        kotlin.reflect.jvm.internal.impl.name.f fVar2 = fVar;
        h.e(fVar2, "newName");
        g bbQ = bbQ();
        h.d(bbQ, "annotations");
        w bai = bai();
        h.d(bai, Param.TYPE);
        boolean bdR = bdR();
        boolean bdU = bdU();
        boolean bdV = bdV();
        w bdS = bdS();
        ai aiVar = ai.eAX;
        h.d(aiVar, "SourceElement.NO_SOURCE");
        return new ah(aVar2, null, i, bbQ, fVar2, bai, bdR, bdU, bdV, bdS, aiVar);
    }

    public av bbJ() {
        return au.eBh;
    }

    public Collection<aq> bcU() {
        Collection bcU = bbv().bcU();
        h.d(bcU, "containingDeclaration.overriddenDescriptors");
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.a> iterable = bcU;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.a aVar : iterable) {
            h.d(aVar, "it");
            arrayList.add((aq) aVar.bcS().get(getIndex()));
        }
        return (List) arrayList;
    }
}
