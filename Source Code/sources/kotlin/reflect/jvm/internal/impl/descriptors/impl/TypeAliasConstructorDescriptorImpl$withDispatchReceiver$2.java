package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ag;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.am;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.storage.h;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: TypeAliasConstructorDescriptor.kt */
final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements a<af> {
    final /* synthetic */ c $underlyingConstructorDescriptor;
    final /* synthetic */ af this$0;

    TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(af afVar, c cVar) {
        this.this$0 = afVar;
        this.$underlyingConstructorDescriptor = cVar;
        super(0);
    }

    /* renamed from: bfn */
    public final af invoke() {
        h baI = this.this$0.baI();
        am bfm = this.this$0.bfm();
        c cVar = this.$underlyingConstructorDescriptor;
        ae aeVar = this.this$0;
        g bbQ = this.$underlyingConstructorDescriptor.bbQ();
        Kind bcW = this.$underlyingConstructorDescriptor.bcW();
        kotlin.jvm.internal.h.d(bcW, "underlyingConstructorDescriptor.kind");
        ai bbR = this.this$0.bfm().bbR();
        kotlin.jvm.internal.h.d(bbR, "typeAliasDescriptor.source");
        af afVar = new af(baI, bfm, cVar, aeVar, bbQ, bcW, bbR, null);
        TypeSubstitutor a = af.eEg.a(this.this$0.bfm());
        if (a == null) {
            return null;
        }
        ag bcP = this.$underlyingConstructorDescriptor.bcP();
        afVar.a(null, bcP != null ? bcP.e(a) : null, this.this$0.bfm().bbS(), this.this$0.bcS(), this.this$0.bcQ(), Modality.FINAL, this.this$0.bfm().bbJ());
        return afVar;
    }
}
