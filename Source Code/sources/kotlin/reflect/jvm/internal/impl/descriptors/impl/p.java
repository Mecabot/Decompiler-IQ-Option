package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.e;

/* compiled from: LazyClassReceiverParameterDescriptor */
public class p extends c {
    private final d eDs;
    private final c eDt;

    public p(d dVar) {
        this.eDs = dVar;
        this.eDt = new c(dVar, null);
    }

    public e bdM() {
        return this.eDt;
    }

    public k bbv() {
        return this.eDs;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class ");
        stringBuilder.append(this.eDs.bdc());
        stringBuilder.append("::this");
        return stringBuilder.toString();
    }
}
