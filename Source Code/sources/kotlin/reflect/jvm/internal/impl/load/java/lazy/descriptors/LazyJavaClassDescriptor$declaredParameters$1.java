package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.load.java.structure.w;

/* compiled from: LazyJavaClassDescriptor.kt */
final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements a<List<? extends an>> {
    final /* synthetic */ f this$0;

    LazyJavaClassDescriptor$declaredParameters$1(f fVar) {
        this.this$0 = fVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<an> invoke() {
        Iterable<w> typeParameters = this.this$0.eHk.getTypeParameters();
        Collection arrayList = new ArrayList(n.e(typeParameters, 10));
        for (w wVar : typeParameters) {
            an a = this.this$0.eGT.bgr().a(wVar);
            if (a != null) {
                arrayList.add(a);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Parameter ");
                stringBuilder.append(wVar);
                stringBuilder.append(" surely belongs to class ");
                stringBuilder.append(this.this$0.eHk);
                stringBuilder.append(", so it must be resolved");
                throw new AssertionError(stringBuilder.toString());
            }
        }
        return (List) arrayList;
    }
}
