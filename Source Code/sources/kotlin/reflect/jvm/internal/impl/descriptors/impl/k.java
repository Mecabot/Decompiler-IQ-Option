package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeclarationDescriptorNonRootImpl */
public abstract class k extends j implements l {
    private final ai eBw;
    private final kotlin.reflect.jvm.internal.impl.descriptors.k eCq;

    protected k(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, g gVar, f fVar, ai aiVar) {
        super(gVar, fVar);
        this.eCq = kVar;
        this.eBw = aiVar;
    }

    /* renamed from: beq */
    public n bcZ() {
        return (n) super.bcZ();
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.k bbv() {
        return this.eCq;
    }

    public ai bbR() {
        return this.eBw;
    }
}
