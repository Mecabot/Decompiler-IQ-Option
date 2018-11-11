package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.av;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ClassConstructorDescriptorImpl */
public class f extends o implements c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final kotlin.reflect.jvm.internal.impl.name.f eCp = kotlin.reflect.jvm.internal.impl.name.f.mF("<init>");
    protected final boolean eCo;

    public void Q(Collection<? extends CallableMemberDescriptor> collection) {
    }

    protected f(d dVar, j jVar, g gVar, boolean z, Kind kind, ai aiVar) {
        super(dVar, jVar, gVar, eCp, kind, aiVar);
        this.eCo = z;
    }

    public static f a(d dVar, g gVar, boolean z, ai aiVar) {
        return new f(dVar, null, gVar, z, Kind.DECLARATION, aiVar);
    }

    public f a(List<aq> list, av avVar, List<an> list2) {
        super.a(null, bey(), list2, list, null, Modality.FINAL, avVar);
        return this;
    }

    public f a(List<aq> list, av avVar) {
        a(list, avVar, bdj().bbS());
        return this;
    }

    public ag bey() {
        d bez = bdj();
        if (bez.bbL()) {
            k bbv = bez.bbv();
            if (bbv instanceof d) {
                return ((d) bbv).bdh();
            }
        }
        return null;
    }

    /* renamed from: bez */
    public d bdj() {
        return (d) super.bbv();
    }

    /* renamed from: bdf */
    public c beq() {
        return (c) super.beq();
    }

    /* renamed from: a */
    public c f(TypeSubstitutor typeSubstitutor) {
        return (c) super.f(typeSubstitutor);
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        return mVar.a((j) this, (Object) d);
    }

    public Collection<? extends r> bcU() {
        return Collections.emptySet();
    }

    /* renamed from: b */
    protected f a(k kVar, r rVar, Kind kind, kotlin.reflect.jvm.internal.impl.name.f fVar, g gVar, ai aiVar) {
        if (kind == Kind.DECLARATION || kind == Kind.SYNTHESIZED) {
            return new f((d) kVar, this, gVar, this.eCo, Kind.DECLARATION, aiVar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempt at creating a constructor that is not a declaration: \ncopy from: ");
        stringBuilder.append(this);
        stringBuilder.append("\n");
        stringBuilder.append("newOwner: ");
        stringBuilder.append(kVar);
        stringBuilder.append("\n");
        stringBuilder.append("kind: ");
        stringBuilder.append(kind);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* renamed from: b */
    public c c(k kVar, Modality modality, av avVar, Kind kind, boolean z) {
        return (c) super.a(kVar, modality, avVar, kind, z);
    }
}
