package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.storage.f;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: VariableDescriptorWithInitializerImpl */
public abstract class aj extends ai {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean eEq;
    protected f<kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> eEr;

    public aj(k kVar, g gVar, kotlin.reflect.jvm.internal.impl.name.f fVar, w wVar, boolean z, ai aiVar) {
        super(kVar, gVar, fVar, wVar, aiVar);
        this.eEq = z;
    }

    public boolean bdW() {
        return this.eEq;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.constants.f<?> bdX() {
        return this.eEr != null ? (kotlin.reflect.jvm.internal.impl.resolve.constants.f) this.eEr.invoke() : null;
    }

    public void a(f<kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> fVar) {
        this.eEr = fVar;
    }
}
