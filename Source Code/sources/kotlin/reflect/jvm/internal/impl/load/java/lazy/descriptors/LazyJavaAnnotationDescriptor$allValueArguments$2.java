package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.b;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>>> {
    final /* synthetic */ e this$0;

    LazyJavaAnnotationDescriptor$allValueArguments$2(e eVar) {
        this.this$0 = eVar;
        super(0);
    }

    /* renamed from: adu */
    public final Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> invoke() {
        Collection arrayList = new ArrayList();
        for (b bVar : this.this$0.eHs.bhj()) {
            Object bdc = bVar.bdc();
            if (bdc == null) {
                bdc = m.eFm;
            }
            kotlin.reflect.jvm.internal.impl.resolve.constants.f a = this.this$0.b(bVar);
            Object D = a != null ? j.D(bdc, a) : null;
            if (D != null) {
                arrayList.add(D);
            }
        }
        return ad.ae((List) arrayList);
    }
}
