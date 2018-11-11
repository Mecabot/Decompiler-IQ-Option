package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$annotations$1 extends Lambda implements a<List<? extends c>> {
    final /* synthetic */ e this$0;

    DeserializedClassDescriptor$annotations$1(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<c> invoke() {
        return u.W(this.this$0.bxX().biq().bxx().b(this.this$0.bxY()));
    }
}
