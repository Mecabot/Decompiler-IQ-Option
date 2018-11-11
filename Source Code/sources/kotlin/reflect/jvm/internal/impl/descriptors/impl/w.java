package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.name.b;

/* compiled from: PackageFragmentDescriptorImpl.kt */
public abstract class w extends k implements x {
    private final b eBM;

    public final b bdD() {
        return this.eBM;
    }

    public w(u uVar, b bVar) {
        h.e(uVar, "module");
        h.e(bVar, "fqName");
        super(uVar, g.eBF.bel(), bVar.btO(), ai.eAX);
        this.eBM = bVar;
    }

    public <R, D> R a(m<R, D> mVar, D d) {
        h.e(mVar, "visitor");
        return mVar.a((x) this, (Object) d);
    }

    /* renamed from: bdC */
    public u bbv() {
        k bbv = super.bbv();
        if (bbv != null) {
            return (u) bbv;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }

    public ai bbR() {
        ai aiVar = ai.eAX;
        h.d(aiVar, "SourceElement.NO_SOURCE");
        return aiVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package ");
        stringBuilder.append(this.eBM);
        return stringBuilder.toString();
    }
}
