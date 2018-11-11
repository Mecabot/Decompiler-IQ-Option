package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 extends Lambda implements b<f, n> {
    final /* synthetic */ c this$0;

    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(c cVar) {
        this.this$0 = cVar;
        super(1);
    }

    /* renamed from: R */
    public final n invoke(f fVar) {
        h.e(fVar, "name");
        EnumEntry enumEntry = (EnumEntry) this.this$0.eTL.get(fVar);
        if (enumEntry == null) {
            return null;
        }
        return n.a(e.this.bxX().baI(), e.this, fVar, this.this$0.eCy, new a(e.this.bxX().baI(), new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1(enumEntry, this, fVar)), ai.eAX);
    }
}
