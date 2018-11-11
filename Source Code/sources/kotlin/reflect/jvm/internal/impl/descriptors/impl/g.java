package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: ClassDescriptorBase */
public abstract class g extends a {
    private final ai eBw;
    private final k eCq;
    private final boolean isExternal;

    protected g(h hVar, k kVar, f fVar, ai aiVar, boolean z) {
        super(hVar, fVar);
        this.eCq = kVar;
        this.eBw = aiVar;
        this.isExternal = z;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public k bbv() {
        return this.eCq;
    }

    public ai bbR() {
        return this.eBw;
    }
}
