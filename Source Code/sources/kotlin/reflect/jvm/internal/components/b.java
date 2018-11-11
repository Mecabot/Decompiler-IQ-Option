package kotlin.reflect.jvm.internal.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.d;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n.e;
import kotlin.reflect.jvm.internal.impl.name.f;

@i(aXC = {1, 1, 11}, aXD = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u0019"}, aXE = {"Lkotlin/reflect/jvm/internal/components/ReflectClassStructure;", "", "()V", "loadClassAnnotations", "", "klass", "Ljava/lang/Class;", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "loadConstructorAnnotations", "memberVisitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "loadFieldAnnotations", "loadMethodAnnotations", "processAnnotation", "annotation", "", "processAnnotationArgumentValue", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationArgumentVisitor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "processAnnotationArguments", "annotationType", "visitMembers", "descriptors.runtime"})
/* compiled from: ReflectKotlinClass.kt */
final class b {
    public static final b ewL = new b();

    private b() {
    }

    public final void a(Class<?> cls, c cVar) {
        h.e(cls, "klass");
        h.e(cVar, "visitor");
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            h.d(annotation, "annotation");
            a(cVar, annotation);
        }
        cVar.visitEnd();
    }

    public final void a(Class<?> cls, d dVar) {
        h.e(cls, "klass");
        h.e(dVar, "memberVisitor");
        b(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }

    private final void b(Class<?> cls, d dVar) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method[] methodArr;
            Method method = declaredMethods[i];
            h.d(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            f mD = f.mD(method.getName());
            h.d(mD, "Name.identifier(method.name)");
            e a = dVar.a(mD, m.exa.g(method));
            if (a != null) {
                int i2;
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    c cVar = a;
                    h.d(annotation, "annotation");
                    a(cVar, annotation);
                }
                Object parameterAnnotations = method.getParameterAnnotations();
                h.d(parameterAnnotations, "method.parameterAnnotations");
                int length2 = parameterAnnotations.length;
                for (i2 = 0; i2 < length2; i2++) {
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length3 = annotationArr.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        Annotation annotation2 = annotationArr[i3];
                        Class a2 = a.a(a.a(annotation2));
                        kotlin.reflect.jvm.internal.impl.name.a S = kotlin.reflect.jvm.internal.structure.b.S(a2);
                        methodArr = declaredMethods;
                        h.d(annotation2, "annotation");
                        n.a a3 = a.a(i2, S, new a(annotation2));
                        if (a3 != null) {
                            ewL.a(a3, annotation2, a2);
                        }
                        i3++;
                        declaredMethods = methodArr;
                    }
                    methodArr = declaredMethods;
                }
                methodArr = declaredMethods;
                a.visitEnd();
            } else {
                methodArr = declaredMethods;
            }
            i++;
            declaredMethods = methodArr;
        }
    }

    private final void c(Class<?> cls, d dVar) {
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (i < length) {
            Constructor[] constructorArr;
            int i2;
            Constructor constructor = declaredConstructors[i];
            f mF = f.mF("<init>");
            h.d(mF, "Name.special(\"<init>\")");
            m mVar = m.exa;
            h.d(constructor, "constructor");
            e a = dVar.a(mF, mVar.b(constructor));
            if (a != null) {
                int i3;
                int length2;
                for (Annotation annotation : constructor.getDeclaredAnnotations()) {
                    c cVar = a;
                    h.d(annotation, "annotation");
                    a(cVar, annotation);
                }
                Object parameterAnnotations = constructor.getParameterAnnotations();
                h.d(parameterAnnotations, "parameterAnnotations");
                Object[] objArr = (Object[]) parameterAnnotations;
                if (((objArr.length == 0 ? 1 : 0) ^ 1) != 0) {
                    int length3 = constructor.getParameterTypes().length - objArr.length;
                    length2 = parameterAnnotations.length;
                    for (i3 = 0; i3 < length2; i3++) {
                        int i4;
                        Annotation[] annotationArr = parameterAnnotations[i3];
                        int length4 = annotationArr.length;
                        int i5 = 0;
                        while (i5 < length4) {
                            Annotation annotation2 = annotationArr[i5];
                            Class a2 = a.a(a.a(annotation2));
                            int i6 = i3 + length3;
                            constructorArr = declaredConstructors;
                            kotlin.reflect.jvm.internal.impl.name.a S = kotlin.reflect.jvm.internal.structure.b.S(a2);
                            i2 = length;
                            i4 = length3;
                            h.d(annotation2, "annotation");
                            n.a a3 = a.a(i6, S, new a(annotation2));
                            if (a3 != null) {
                                ewL.a(a3, annotation2, a2);
                            }
                            i5++;
                            declaredConstructors = constructorArr;
                            length = i2;
                            length3 = i4;
                        }
                        constructorArr = declaredConstructors;
                        i2 = length;
                        i4 = length3;
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                a.visitEnd();
            } else {
                constructorArr = declaredConstructors;
                i2 = length;
            }
            i++;
            declaredConstructors = constructorArr;
            length = i2;
        }
    }

    private final void d(Class<?> cls, d dVar) {
        for (Field field : cls.getDeclaredFields()) {
            h.d(field, "field");
            f mD = f.mD(field.getName());
            h.d(mD, "Name.identifier(field.name)");
            c a = dVar.a(mD, m.exa.c(field), null);
            if (a != null) {
                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    h.d(annotation, "annotation");
                    a(a, annotation);
                }
                a.visitEnd();
            }
        }
    }

    private final void a(c cVar, Annotation annotation) {
        Class a = a.a(a.a(annotation));
        n.a a2 = cVar.a(kotlin.reflect.jvm.internal.structure.b.S(a), new a(annotation));
        if (a2 != null) {
            ewL.a(a2, annotation, a);
        }
    }

    private final void a(n.a aVar, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                if (invoke == null) {
                    h.aXZ();
                }
                h.d(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
                f mD = f.mD(method.getName());
                h.d(mD, "Name.identifier(method.name)");
                a(aVar, mD, invoke);
            } catch (IllegalAccessException unused) {
                i++;
            }
        }
        aVar.visitEnd();
    }

    private final void a(n.a aVar, f fVar, Object obj) {
        Class cls = obj.getClass();
        if (h.ewP.contains(cls)) {
            aVar.a(fVar, obj);
        } else if (kotlin.reflect.jvm.internal.structure.b.P(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            h.d(cls, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
            kotlin.reflect.jvm.internal.impl.name.a S = kotlin.reflect.jvm.internal.structure.b.S(cls);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
            }
            f mD = f.mD(((Enum) obj).name());
            h.d(mD, "Name.identifier((value as Enum<*>).name)");
            aVar.a(fVar, S, mD);
        } else if (Annotation.class.isAssignableFrom(cls)) {
            Object interfaces = cls.getInterfaces();
            h.d(interfaces, "clazz.interfaces");
            cls = (Class) i.y(interfaces);
            h.d(cls, "annotationClass");
            aVar = aVar.a(fVar, kotlin.reflect.jvm.internal.structure.b.S(cls));
            if (aVar == null) {
                return;
            }
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Annotation");
            }
            a(aVar, (Annotation) obj, cls);
        } else if (cls.isArray()) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.n.b A = aVar.A(fVar);
            if (A != null) {
                Class componentType = cls.getComponentType();
                h.d(componentType, "componentType");
                int i = 0;
                Object[] objArr;
                if (componentType.isEnum()) {
                    kotlin.reflect.jvm.internal.impl.name.a S2 = kotlin.reflect.jvm.internal.structure.b.S(componentType);
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                    }
                    objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i < length) {
                        Object obj2 = objArr[i];
                        if (obj2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                        }
                        f mD2 = f.mD(((Enum) obj2).name());
                        h.d(mD2, "Name.identifier((element as Enum<*>).name)");
                        A.b(S2, mD2);
                        i++;
                    }
                } else if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                } else {
                    objArr = (Object[]) obj;
                    int length2 = objArr.length;
                    while (i < length2) {
                        A.cQ(objArr[i]);
                        i++;
                    }
                }
                A.visitEnd();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported annotation argument value (");
            stringBuilder.append(cls);
            stringBuilder.append("): ");
            stringBuilder.append(obj);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
    }
}
