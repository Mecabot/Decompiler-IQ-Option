package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.a;
import kotlin.reflect.jvm.internal.impl.load.java.structure.c;
import kotlin.reflect.jvm.internal.impl.name.f;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationAsAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationAsAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "annotation", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/annotation/Annotation;)V", "getAnnotation", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "descriptors.runtime"})
/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class e extends d implements c {
    private final Annotation ewK;

    public e(f fVar, Annotation annotation) {
        h.e(annotation, "annotation");
        super(fVar);
        this.ewK = annotation;
    }

    public a bhl() {
        return new c(this.ewK);
    }
}
