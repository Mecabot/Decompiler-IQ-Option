package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.a;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"findAnnotation", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "", "", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "([Ljava/lang/annotation/Annotation;Lorg/jetbrains/kotlin/name/FqName;)Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "", "([Ljava/lang/annotation/Annotation;)Ljava/util/List;", "descriptors.runtime"})
/* compiled from: ReflectJavaAnnotationOwner.kt */
public final class g {
    public static final List<c> a(Annotation[] annotationArr) {
        h.e(annotationArr, "$receiver");
        Collection arrayList = new ArrayList(annotationArr.length);
        for (Annotation cVar : annotationArr) {
            arrayList.add(new c(cVar));
        }
        return (List) arrayList;
    }

    public static final c a(Annotation[] annotationArr, b bVar) {
        h.e(annotationArr, "$receiver");
        h.e(bVar, "fqName");
        for (Annotation annotation : annotationArr) {
            if (h.E(b.S(a.a(a.a(annotation))).btK(), bVar)) {
                break;
            }
        }
        Annotation annotation2 = null;
        return annotation2 != null ? new c(annotation2) : null;
    }
}
