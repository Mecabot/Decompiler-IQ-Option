package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.k;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.j;

/* compiled from: LazyJavaClassMemberScope.kt */
final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements a<List<? extends c>> {
    final /* synthetic */ h $c;
    final /* synthetic */ g this$0;

    LazyJavaClassMemberScope$constructors$1(g gVar, h hVar) {
        this.this$0 = gVar;
        this.$c = hVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<c> invoke() {
        Collection<k> bbE = this.this$0.eHk.bbE();
        ArrayList arrayList = new ArrayList(bbE.size());
        for (k a : bbE) {
            arrayList.add(this.this$0.a(a));
        }
        j bgi = this.$c.bgq().bgi();
        h hVar = this.$c;
        Collection collection = arrayList;
        if (collection.isEmpty()) {
            collection = m.cs(this.this$0.bgH());
        }
        return u.W(bgi.a(hVar, collection));
    }
}
