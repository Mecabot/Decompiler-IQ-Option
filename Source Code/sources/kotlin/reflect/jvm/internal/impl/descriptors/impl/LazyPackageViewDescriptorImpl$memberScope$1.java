package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h.c;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements a<h> {
    final /* synthetic */ q this$0;

    LazyPackageViewDescriptorImpl$memberScope$1(q qVar) {
        this.this$0 = qVar;
        super(0);
    }

    /* renamed from: bbn */
    public final h invoke() {
        if (this.this$0.getFragments().isEmpty()) {
            return c.eSm;
        }
        Iterable<x> fragments = this.this$0.getFragments();
        Collection arrayList = new ArrayList(n.e(fragments, 10));
        for (x bbk : fragments) {
            arrayList.add(bbk.bbk());
        }
        List i = u.i((Collection) (List) arrayList, (Object) new ad(this.this$0.bar(), this.this$0.bdD()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package view scope for ");
        stringBuilder.append(this.this$0.bdD());
        stringBuilder.append(" in ");
        stringBuilder.append(this.this$0.bar().bdc());
        return new b(stringBuilder.toString(), i);
    }
}
