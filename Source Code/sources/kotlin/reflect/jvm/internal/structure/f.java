package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.d;
import kotlin.reflect.jvm.internal.impl.name.b;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationOwner;", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "isDeprecatedInJavaDoc", "", "()Z", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
/* compiled from: ReflectJavaAnnotationOwner.kt */
public interface f extends d {

    @i(aXC = {1, 1, 11})
    /* compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class a {
        public static boolean b(f fVar) {
            return false;
        }

        public static List<c> a(f fVar) {
            AnnotatedElement bzP = fVar.bzP();
            if (bzP != null) {
                Annotation[] declaredAnnotations = bzP.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    List<c> a = g.a(declaredAnnotations);
                    if (a != null) {
                        return a;
                    }
                }
            }
            return m.emptyList();
        }

        public static c a(f fVar, b bVar) {
            h.e(bVar, "fqName");
            AnnotatedElement bzP = fVar.bzP();
            if (bzP != null) {
                Annotation[] declaredAnnotations = bzP.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    return g.a(declaredAnnotations, bVar);
                }
            }
            return null;
        }
    }

    AnnotatedElement bzP();
}
