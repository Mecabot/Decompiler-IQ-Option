package kotlin.reflect.jvm.internal;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a6\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0002\u001a$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¨\u0006\u0012²\u0006\r\u0010\u0013\u001a\u00020\rX\u0002¢\u0006\u0000²\u0006\r\u0010\u0014\u001a\u00020\tX\u0002¢\u0006\u0000"}, aXE = {"createAnnotationInstance", "", "annotationClass", "Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "values", "", "", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflect-api", "hashCode", "toString"})
/* compiled from: AnnotationConstructorCaller.kt */
public final class a {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference0Impl(kotlin.jvm.internal.j.e(a.class, "kotlin-reflect-api"), "hashCode", "<v#0>")), kotlin.jvm.internal.j.a(new PropertyReference0Impl(kotlin.jvm.internal.j.e(a.class, "kotlin-reflect-api"), "toString", "<v#1>"))};

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052,\u0010\u0006\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00010\u0001 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
    /* compiled from: AnnotationConstructorCaller.kt */
    static final class a implements InvocationHandler {
        final /* synthetic */ Class $annotationClass;
        final /* synthetic */ Map $values;
        final /* synthetic */ d euT;
        final /* synthetic */ j euU;
        final /* synthetic */ d euV;
        final /* synthetic */ j euW;
        final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$1 euX;

        a(Class cls, d dVar, j jVar, d dVar2, j jVar2, AnnotationConstructorCallerKt$createAnnotationInstance$1 annotationConstructorCallerKt$createAnnotationInstance$1, Map map) {
            this.$annotationClass = cls;
            this.euT = dVar;
            this.euU = jVar;
            this.euV = dVar2;
            this.euW = jVar2;
            this.euX = annotationConstructorCallerKt$createAnnotationInstance$1;
            this.$values = map;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            h.d(method, b.METHOD);
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                d dVar;
                j jVar;
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.$annotationClass;
                        }
                    } else if (name.equals("hashCode")) {
                        dVar = this.euV;
                        jVar = this.euW;
                        return dVar.getValue();
                    }
                } else if (name.equals("toString")) {
                    dVar = this.euT;
                    jVar = this.euU;
                    return dVar.getValue();
                }
            }
            if (h.E(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.euX.cD(i.y(objArr)));
            }
            if (this.$values.containsKey(name)) {
                return this.$values.get(name);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method is not supported: ");
            stringBuilder.append(method);
            stringBuilder.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            stringBuilder.append(i.A(objArr));
            stringBuilder.append(')');
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        }
    }

    private static final Object a(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof kotlin.reflect.b) {
            obj = kotlin.jvm.a.a((kotlin.reflect.b) obj);
        } else if (obj instanceof Object[]) {
            Object obj2 = (Object[]) obj;
            if (obj2 instanceof Class[]) {
                return null;
            }
            if (!(obj2 instanceof kotlin.reflect.b[])) {
                obj = obj2;
            } else if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
            } else {
                kotlin.reflect.b[] bVarArr = (kotlin.reflect.b[]) obj;
                Collection arrayList = new ArrayList(bVarArr.length);
                for (kotlin.reflect.b a : bVarArr) {
                    arrayList.add(kotlin.jvm.a.a(a));
                }
                obj = ((List) arrayList).toArray(new Class[0]);
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
        }
        if (!cls.isInstance(obj)) {
            obj = null;
        }
        return obj;
    }

    private static final Void a(int i, String str, Class<?> cls) {
        kotlin.reflect.b F;
        String stringBuilder;
        if (h.E(cls, Class.class)) {
            F = kotlin.jvm.internal.j.F(kotlin.reflect.b.class);
        } else if (cls.isArray() && h.E(cls.getComponentType(), Class.class)) {
            F = kotlin.jvm.internal.j.F(kotlin.reflect.b[].class);
        } else {
            F = kotlin.jvm.a.E(cls);
        }
        if (h.E(F.getQualifiedName(), kotlin.jvm.internal.j.F(Object[].class).getQualifiedName())) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(F.getQualifiedName());
            stringBuilder2.append('<');
            Class componentType = kotlin.jvm.a.a(F).getComponentType();
            h.d(componentType, "kotlinClass.java.componentType");
            stringBuilder2.append(kotlin.jvm.a.E(componentType).getQualifiedName());
            stringBuilder2.append('>');
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = F.getQualifiedName();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Argument #");
        stringBuilder3.append(i);
        stringBuilder3.append(' ');
        stringBuilder3.append(str);
        stringBuilder3.append(" is not of the required type ");
        stringBuilder3.append(stringBuilder);
        throw new IllegalArgumentException(stringBuilder3.toString());
    }

    private static final Object a(Class<?> cls, List<Method> list, Map<String, ? extends Object> map) {
        AnnotationConstructorCallerKt$createAnnotationInstance$1 annotationConstructorCallerKt$createAnnotationInstance$1 = new AnnotationConstructorCallerKt$createAnnotationInstance$1(cls, list, map);
        d f = g.f(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(map));
        j jVar = apP[0];
        d f2 = g.f(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(cls, map));
        j jVar2 = apP[1];
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls, f2, jVar2, f, jVar, annotationConstructorCallerKt$createAnnotationInstance$1, map));
        h.d(newProxyInstance, "Proxy.newProxyInstance(a…        }\n        }\n    }");
        return newProxyInstance;
    }
}
