package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 extends Lambda implements a<Collection<? extends k>> {
    final /* synthetic */ a this$0;

    DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aZh */
    public final Collection<k> invoke() {
        return this.this$0.b(d.eRR, h.eSi.bxi(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
    }
}
