package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements a<List<? extends c>> {
    final /* synthetic */ m this$0;

    DeserializedTypeParameterDescriptor$annotations$1(m mVar) {
        this.this$0 = mVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<c> invoke() {
        return u.W(this.this$0.eTh.biq().bxx().a(this.this$0.eUb, this.this$0.eTh.aYI()));
    }
}
