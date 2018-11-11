package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;
import kotlin.reflect.jvm.internal.impl.load.java.structure.y;
import kotlin.reflect.jvm.internal.structure.w.a;

@i(aXC = {1, 1, 11}, aXD = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, aXE = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "hasAnnotationParameterDefaultValue", "", "getHasAnnotationParameterDefaultValue", "()Z", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
/* compiled from: ReflectJavaMethod.kt */
public final class s extends r implements q {
    private final Method eYD;

    public s(Method method) {
        h.e(method, "member");
        this.eYD = method;
    }

    /* renamed from: bAb */
    public Method bzW() {
        return this.eYD;
    }

    public List<y> bcS() {
        Object genericParameterTypes = bzW().getGenericParameterTypes();
        h.d(genericParameterTypes, "member.genericParameterTypes");
        Object parameterAnnotations = bzW().getParameterAnnotations();
        h.d(parameterAnnotations, "member.parameterAnnotations");
        return a(genericParameterTypes, parameterAnnotations, bzW().isVarArgs());
    }

    /* renamed from: bAa */
    public w bhG() {
        a aVar = w.eYF;
        Type genericReturnType = bzW().getGenericReturnType();
        h.d(genericReturnType, "member.genericReturnType");
        return aVar.q(genericReturnType);
    }

    public boolean bhH() {
        return bzW().getDefaultValue() != null;
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
