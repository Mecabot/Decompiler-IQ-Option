package kotlin.reflect.jvm.internal.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.k;
import kotlin.reflect.jvm.internal.impl.load.java.structure.y;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaConstructor;", "member", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getMember", "()Ljava/lang/reflect/Constructor;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
/* compiled from: ReflectJavaConstructor.kt */
public final class m extends r implements k {
    private final Constructor<?> eYA;

    public m(Constructor<?> constructor) {
        h.e(constructor, "member");
        this.eYA = constructor;
    }

    /* renamed from: bzV */
    public Constructor<?> bzW() {
        return this.eYA;
    }

    public List<y> bcS() {
        Object genericParameterTypes = bzW().getGenericParameterTypes();
        h.d(genericParameterTypes, "types");
        if ((genericParameterTypes.length == 0 ? 1 : null) != null) {
            return m.emptyList();
        }
        Class declaringClass = bzW().getDeclaringClass();
        h.d(declaringClass, "klass");
        if (!(declaringClass.getDeclaringClass() == null || Modifier.isStatic(declaringClass.getModifiers()))) {
            genericParameterTypes = Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
            h.d(genericParameterTypes, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            genericParameterTypes = (Type[]) genericParameterTypes;
        }
        Object parameterAnnotations = bzW().getParameterAnnotations();
        Object[] objArr = (Object[]) parameterAnnotations;
        if (objArr.length < genericParameterTypes.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal generic signature: ");
            stringBuilder.append(bzW());
            throw new IllegalStateException(stringBuilder.toString());
        }
        if (objArr.length > genericParameterTypes.length) {
            h.d(parameterAnnotations, "annotations");
            parameterAnnotations = Arrays.copyOfRange(objArr, objArr.length - genericParameterTypes.length, objArr.length);
            h.d(parameterAnnotations, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            parameterAnnotations = (Annotation[][]) parameterAnnotations;
        }
        h.d(genericParameterTypes, "realTypes");
        h.d(parameterAnnotations, "realAnnotations");
        return a(genericParameterTypes, parameterAnnotations, bzW().isVarArgs());
    }

    public List<x> getTypeParameters() {
        Object typeParameters = bzW().getTypeParameters();
        h.d(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable xVar : typeParameters) {
            arrayList.add(new x(xVar));
        }
        return (List) arrayList;
    }
}
