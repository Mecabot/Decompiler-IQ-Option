package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.r;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1 extends Lambda implements a<List<? extends c>> {
    final /* synthetic */ f $name$inlined;
    final /* synthetic */ EnumEntry $proto;
    final /* synthetic */ DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 this$0;

    DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$$special$$inlined$let$lambda$1(EnumEntry enumEntry, DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1 deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1, f fVar) {
        this.$proto = enumEntry;
        this.this$0 = deserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1;
        this.$name$inlined = fVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<c> invoke() {
        return u.W(e.this.bxX().biq().bxx().a((r) e.this.bxY(), this.$proto));
    }
}
