package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.f;
import com.google.common.base.i;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TypeResolver */
public final class e {
    private final b Vh;

    /* compiled from: TypeResolver */
    private static class b {
        private final ImmutableMap<c, Type> map;

        b() {
            this.map = ImmutableMap.sT();
        }

        private b(ImmutableMap<c, Type> immutableMap) {
            this.map = immutableMap;
        }

        final b s(Map<c, ? extends Type> map) {
            com.google.common.collect.ImmutableMap.a sU = ImmutableMap.sU();
            sU.o(this.map);
            for (Entry entry : map.entrySet()) {
                Object obj = (c) entry.getKey();
                Type type = (Type) entry.getValue();
                i.a(obj.e(type) ^ 1, "Type variable %s bound to itself", obj);
                sU.r(obj, type);
            }
            return new b(sU.tc());
        }

        final Type b(final TypeVariable<?> typeVariable) {
            return a(typeVariable, new b() {
                public Type a(TypeVariable<?> typeVariable, b bVar) {
                    if (typeVariable.getGenericDeclaration().equals(typeVariable.getGenericDeclaration())) {
                        return typeVariable;
                    }
                    return this.a(typeVariable, bVar);
                }
            });
        }

        Type a(TypeVariable<?> typeVariable, b bVar) {
            Type type = (Type) this.map.get(new c(typeVariable));
            if (type != null) {
                return new e(bVar, null).b(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] a = new e(bVar, null).a(bounds);
            if (a.VH && Arrays.equals(bounds, a)) {
                return typeVariable;
            }
            return Types.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), a);
        }
    }

    /* compiled from: TypeResolver */
    static final class c {
        private final TypeVariable<?> Vp;

        c(TypeVariable<?> typeVariable) {
            this.Vp = (TypeVariable) i.checkNotNull(typeVariable);
        }

        public int hashCode() {
            return f.hashCode(this.Vp.getGenericDeclaration(), this.Vp.getName());
        }

        public boolean equals(Object obj) {
            return obj instanceof c ? c(((c) obj).Vp) : false;
        }

        public String toString() {
            return this.Vp.toString();
        }

        static c d(Type type) {
            return type instanceof TypeVariable ? new c((TypeVariable) type) : null;
        }

        boolean e(Type type) {
            return type instanceof TypeVariable ? c((TypeVariable) type) : false;
        }

        private boolean c(TypeVariable<?> typeVariable) {
            return this.Vp.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.Vp.getName().equals(typeVariable.getName());
        }
    }

    /* compiled from: TypeResolver */
    private static class d {
        private final AtomicInteger id;

        /* synthetic */ d(AtomicInteger atomicInteger, AnonymousClass1 anonymousClass1) {
            this(atomicInteger);
        }

        d() {
            this(new AtomicInteger());
        }

        private d(AtomicInteger atomicInteger) {
            this.id = atomicInteger;
        }

        final Type f(Type type) {
            i.checkNotNull(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.newArrayType(vt().f(((GenericArrayType) type).getGenericComponentType()));
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = d(typeParameters[i]).f(actualTypeArguments[i]);
                }
                return Types.a(vt().g(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> b(Type[] typeArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("capture#");
            stringBuilder.append(this.id.incrementAndGet());
            stringBuilder.append("-of ? extends ");
            stringBuilder.append(Joiner.e('&').join((Object[]) typeArr));
            return Types.a((GenericDeclaration) d.class, stringBuilder.toString(), typeArr);
        }

        private d d(final TypeVariable<?> typeVariable) {
            return new d(this.id) {
                TypeVariable<?> b(Type[] typeArr) {
                    Set linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private d vt() {
            return new d(this.id);
        }

        private Type g(Type type) {
            return type == null ? null : f(type);
        }
    }

    /* compiled from: TypeResolver */
    private static final class a extends f {
        private static final d Vk = new d();
        private final Map<c, Type> Vl = Maps.us();

        private a() {
        }

        static ImmutableMap<c, Type> c(Type type) {
            a aVar = new a();
            aVar.d(Vk.f(type));
            return ImmutableMap.n(aVar.Vl);
        }

        void s(Class<?> cls) {
            d(cls.getGenericSuperclass());
            d(cls.getGenericInterfaces());
        }

        void b(ParameterizedType parameterizedType) {
            TypeVariable[] typeParameters = ((Class) parameterizedType.getRawType()).getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            i.checkState(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                a(new c(typeParameters[i]), actualTypeArguments[i]);
            }
            d(r0);
            d(parameterizedType.getOwnerType());
        }

        void a(TypeVariable<?> typeVariable) {
            d(typeVariable.getBounds());
        }

        void b(WildcardType wildcardType) {
            d(wildcardType.getUpperBounds());
        }

        private void a(c cVar, Type type) {
            if (!this.Vl.containsKey(cVar)) {
                Type type2 = type;
                while (type2 != null) {
                    if (cVar.e(type2)) {
                        while (type != null) {
                            type = (Type) this.Vl.remove(c.d(type));
                        }
                        return;
                    }
                    type2 = (Type) this.Vl.get(c.d(type2));
                }
                this.Vl.put(cVar, type);
            }
        }
    }

    /* synthetic */ e(b bVar, AnonymousClass1 anonymousClass1) {
        this(bVar);
    }

    public e() {
        this.Vh = new b();
    }

    private e(b bVar) {
        this.Vh = bVar;
    }

    static e a(Type type) {
        return new e().r(a.c(type));
    }

    e r(Map<c, ? extends Type> map) {
        return new e(this.Vh.s(map));
    }

    private static void a(final Map<c, Type> map, Type type, final Type type2) {
        if (!type.equals(type2)) {
            new f() {
                void a(TypeVariable<?> typeVariable) {
                    map.put(new c(typeVariable), type2);
                }

                void b(WildcardType wildcardType) {
                    if (type2 instanceof WildcardType) {
                        WildcardType wildcardType2 = (WildcardType) type2;
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        Type[] upperBounds2 = wildcardType2.getUpperBounds();
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                        boolean z = upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length;
                        i.a(z, "Incompatible type: %s vs. %s", (Object) wildcardType, type2);
                        for (int i = 0; i < upperBounds.length; i++) {
                            e.a(map, upperBounds[i], upperBounds2[i]);
                        }
                        for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                            e.a(map, lowerBounds[i2], lowerBounds2[i2]);
                        }
                    }
                }

                void b(ParameterizedType parameterizedType) {
                    if (!(type2 instanceof WildcardType)) {
                        Object obj = (ParameterizedType) e.a(ParameterizedType.class, (Object) type2);
                        if (!(parameterizedType.getOwnerType() == null || obj.getOwnerType() == null)) {
                            e.a(map, parameterizedType.getOwnerType(), obj.getOwnerType());
                        }
                        i.a(parameterizedType.getRawType().equals(obj.getRawType()), "Inconsistent raw type: %s vs. %s", (Object) parameterizedType, type2);
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Type[] actualTypeArguments2 = obj.getActualTypeArguments();
                        i.a(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", (Object) parameterizedType, obj);
                        for (int i = 0; i < actualTypeArguments.length; i++) {
                            e.a(map, actualTypeArguments[i], actualTypeArguments2[i]);
                        }
                    }
                }

                void b(GenericArrayType genericArrayType) {
                    if (!(type2 instanceof WildcardType)) {
                        Type componentType = Types.getComponentType(type2);
                        i.a(componentType != null, "%s is not an array type.", type2);
                        e.a(map, genericArrayType.getGenericComponentType(), componentType);
                    }
                }

                void s(Class<?> cls) {
                    if (!(type2 instanceof WildcardType)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("No type mapping from ");
                        stringBuilder.append(cls);
                        stringBuilder.append(" to ");
                        stringBuilder.append(type2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }.d(type);
        }
    }

    public Type b(Type type) {
        i.checkNotNull(type);
        if (type instanceof TypeVariable) {
            return this.Vh.b((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        return type instanceof WildcardType ? a((WildcardType) type) : type;
    }

    private Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType a(WildcardType wildcardType) {
        return new WildcardTypeImpl(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
    }

    private Type a(GenericArrayType genericArrayType) {
        return Types.newArrayType(b(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType == null) {
            ownerType = null;
        } else {
            ownerType = b(ownerType);
        }
        return Types.a(ownerType, (Class) b(parameterizedType.getRawType()), a(parameterizedType.getActualTypeArguments()));
    }

    private static <T> T a(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" is not a ");
            stringBuilder.append(cls.getSimpleName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
