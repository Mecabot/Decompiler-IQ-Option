package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.n;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* compiled from: DeserializedMemberScope.kt */
public final class DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3 extends Lambda implements a<M> {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ p $parser$inlined;
    final /* synthetic */ h this$0;

    public DeserializedMemberScope$computeDescriptors$$inlined$let$lambda$3(ByteArrayInputStream byteArrayInputStream, h hVar, p pVar) {
        this.$inputStream = byteArrayInputStream;
        this.this$0 = hVar;
        this.$parser$inlined = pVar;
        super(0);
    }

    /* renamed from: byw */
    public final M invoke() {
        return (n) this.$parser$inlined.j(this.$inputStream, this.this$0.bxX().biq().bxD());
    }
}
