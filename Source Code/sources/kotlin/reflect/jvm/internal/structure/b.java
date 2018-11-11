package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.c;
import kotlin.i;
import kotlin.jvm.a;
import kotlin.jvm.a.d;
import kotlin.jvm.a.e;
import kotlin.jvm.a.f;
import kotlin.jvm.a.g;
import kotlin.jvm.a.k;
import kotlin.jvm.a.l;
import kotlin.jvm.a.m;
import kotlin.jvm.a.n;
import kotlin.jvm.a.o;
import kotlin.jvm.a.p;
import kotlin.jvm.a.q;
import kotlin.jvm.a.r;
import kotlin.jvm.a.s;
import kotlin.jvm.a.t;
import kotlin.jvm.a.u;
import kotlin.jvm.a.v;
import kotlin.jvm.a.w;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000J\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0002*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010$\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u0002\"&\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\",\u0010\t\u001a \u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\",\u0010\n\u001a \u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0002\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0019\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001c¨\u0006&"}, aXE = {"FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "PRIMITIVE_CLASSES", "", "Lkotlin/reflect/KClass;", "", "PRIMITIVE_TO_WRAPPER", "WRAPPER_TO_PRIMITIVE", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/name/ClassId;", "desc", "", "getDesc", "(Ljava/lang/Class;)Ljava/lang/String;", "functionClassArity", "getFunctionClassArity", "(Ljava/lang/Class;)Ljava/lang/Integer;", "parameterizedTypeArguments", "Ljava/lang/reflect/Type;", "getParameterizedTypeArguments", "(Ljava/lang/reflect/Type;)Ljava/util/List;", "primitiveByWrapper", "getPrimitiveByWrapper", "(Ljava/lang/Class;)Ljava/lang/Class;", "safeClassLoader", "Ljava/lang/ClassLoader;", "getSafeClassLoader", "(Ljava/lang/Class;)Ljava/lang/ClassLoader;", "wrapperByPrimitive", "getWrapperByPrimitive", "createArrayType", "isEnumClassOrSpecializedEnumEntryClass", "", "descriptors.runtime"})
/* compiled from: reflectClassUtil.kt */
public final class b {
    private static final List<kotlin.reflect.b<? extends Object>> eYj;
    private static final Map<Class<? extends Object>, Class<? extends Object>> eYk;
    private static final Map<Class<? extends Object>, Class<? extends Object>> eYl;
    private static final Map<Class<? extends c<?>>, Integer> eYm;

    public static final ClassLoader O(Class<?> cls) {
        h.e(cls, "$receiver");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        classLoader = ClassLoader.getSystemClassLoader();
        h.d(classLoader, "ClassLoader.getSystemClassLoader()");
        return classLoader;
    }

    public static final boolean P(Class<?> cls) {
        h.e(cls, "$receiver");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        r1 = new kotlin.reflect.b[8];
        int i = 0;
        r1[0] = j.F(Boolean.TYPE);
        r1[1] = j.F(Byte.TYPE);
        r1[2] = j.F(Character.TYPE);
        r1[3] = j.F(Double.TYPE);
        r1[4] = j.F(Float.TYPE);
        r1[5] = j.F(Integer.TYPE);
        r1[6] = j.F(Long.TYPE);
        r1[7] = j.F(Short.TYPE);
        eYj = m.listOf(r1);
        Iterable<kotlin.reflect.b> iterable = eYj;
        Collection arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.b bVar : iterable) {
            arrayList.add(kotlin.j.D(a.c(bVar), a.b(bVar)));
        }
        eYk = ad.ae((List) arrayList);
        iterable = eYj;
        arrayList = new ArrayList(n.e(iterable, 10));
        for (kotlin.reflect.b bVar2 : iterable) {
            arrayList.add(kotlin.j.D(a.b(bVar2), a.c(bVar2)));
        }
        eYl = ad.ae((List) arrayList);
        Iterable<Class> listOf = m.listOf(kotlin.jvm.a.a.class, kotlin.jvm.a.b.class, m.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.jvm.a.c.class, d.class, e.class, f.class, g.class, kotlin.jvm.a.h.class, kotlin.jvm.a.i.class, kotlin.jvm.a.j.class, k.class, l.class, n.class, o.class, p.class);
        Collection arrayList2 = new ArrayList(n.e(listOf, 10));
        for (Class D : listOf) {
            int i2 = i + 1;
            arrayList2.add(kotlin.j.D(D, Integer.valueOf(i)));
            i = i2;
        }
        eYm = ad.ae((List) arrayList2);
    }

    public static final Class<?> Q(Class<?> cls) {
        h.e(cls, "$receiver");
        return (Class) eYk.get(cls);
    }

    public static final Class<?> R(Class<?> cls) {
        h.e(cls, "$receiver");
        return (Class) eYl.get(cls);
    }

    public static final kotlin.reflect.jvm.internal.impl.name.a S(Class<?> cls) {
        h.e(cls, "$receiver");
        StringBuilder stringBuilder;
        if (cls.isPrimitive()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Can't compute ClassId for primitive type: ");
            stringBuilder.append(cls);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (cls.isArray()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Can't compute ClassId for array type: ");
            stringBuilder.append(cls);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                h.d(simpleName, "simpleName");
                if ((((CharSequence) simpleName).length() == 0 ? 1 : null) == null) {
                    kotlin.reflect.jvm.internal.impl.name.a S;
                    Class declaringClass = cls.getDeclaringClass();
                    if (declaringClass != null) {
                        S = S(declaringClass);
                        if (S != null) {
                            S = S.B(kotlin.reflect.jvm.internal.impl.name.f.mD(cls.getSimpleName()));
                            if (S != null) {
                                return S;
                            }
                        }
                    }
                    S = kotlin.reflect.jvm.internal.impl.name.a.t(new kotlin.reflect.jvm.internal.impl.name.b(cls.getName()));
                    h.d(S, "ClassId.topLevel(FqName(name))");
                    return S;
                }
            }
            kotlin.reflect.jvm.internal.impl.name.b bVar = new kotlin.reflect.jvm.internal.impl.name.b(cls.getName());
            return new kotlin.reflect.jvm.internal.impl.name.a(bVar.btM(), kotlin.reflect.jvm.internal.impl.name.b.E(bVar.btN()), true);
        }
    }

    public static final String T(Class<?> cls) {
        h.e(cls, "$receiver");
        if (h.E(cls, Void.TYPE)) {
            return "V";
        }
        String name = U(cls).getName();
        h.d(name, "createArrayType().name");
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = name.substring(1);
        h.d(substring, "(this as java.lang.String).substring(startIndex)");
        return u.a(substring, '.', '/', false, 4, null);
    }

    public static final Class<?> U(Class<?> cls) {
        h.e(cls, "$receiver");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final List<Type> p(Type type) {
        h.e(type, "$receiver");
        if (!(type instanceof ParameterizedType)) {
            return m.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return m.f(m.e(k.a((Object) type, (kotlin.jvm.a.b) ReflectClassUtilKt$parameterizedTypeArguments$1.eYn), ReflectClassUtilKt$parameterizedTypeArguments$2.eYo));
        }
        Object actualTypeArguments = parameterizedType.getActualTypeArguments();
        h.d(actualTypeArguments, "actualTypeArguments");
        return i.A(actualTypeArguments);
    }
}
