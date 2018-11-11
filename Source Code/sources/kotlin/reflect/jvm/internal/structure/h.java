package kotlin.reflect.jvm.internal.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.reflect.jvm.internal.impl.load.java.structure.e;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.structure.d.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016R\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "values", "", "(Lorg/jetbrains/kotlin/name/Name;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getElements", "", "descriptors.runtime"})
/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class h extends d implements e {
    private final Object[] values;

    public h(f fVar, Object[] objArr) {
        kotlin.jvm.internal.h.e(objArr, "values");
        super(fVar);
        this.values = objArr;
    }

    public List<d> bhn() {
        Object[] objArr = this.values;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            a aVar = d.eYp;
            if (obj == null) {
                kotlin.jvm.internal.h.aXZ();
            }
            arrayList.add(aVar.a(obj, null));
        }
        return (List) arrayList;
    }
}
