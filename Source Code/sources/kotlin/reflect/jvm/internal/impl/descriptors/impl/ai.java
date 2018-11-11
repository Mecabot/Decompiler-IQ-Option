package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.aq;
import kotlin.reflect.jvm.internal.impl.descriptors.as;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: VariableDescriptorImpl */
public abstract class ai extends k implements as {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected w eEp;

    public ag bcO() {
        return null;
    }

    public ag bcP() {
        return null;
    }

    public boolean bcT() {
        return false;
    }

    public boolean bdY() {
        return false;
    }

    public ai(k kVar, g gVar, f fVar, w wVar, kotlin.reflect.jvm.internal.impl.descriptors.ai aiVar) {
        super(kVar, gVar, fVar, aiVar);
        this.eEp = wVar;
    }

    public w bai() {
        return this.eEp;
    }

    public void W(w wVar) {
        this.eEp = wVar;
    }

    /* renamed from: bfd */
    public as beq() {
        return (as) super.bcZ();
    }

    public List<aq> bcS() {
        return Collections.emptyList();
    }

    public Collection<? extends a> bcU() {
        return Collections.emptySet();
    }

    public List<an> getTypeParameters() {
        return Collections.emptyList();
    }

    public w bcQ() {
        return bai();
    }
}
