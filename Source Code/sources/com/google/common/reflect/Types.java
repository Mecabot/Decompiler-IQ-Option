package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.base.i;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.s;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

final class Types {
    private static final d<Type, String> VB = new d<Type, String>() {
        /* renamed from: m */
        public String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    };
    private static final Joiner VD = Joiner.on(", ").cF("null");

    private enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS {
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER {
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership JVM_BEHAVIOR = null;

        class a<T> {
            a() {
            }
        }

        abstract Class<?> getOwnerType(Class<?> cls);

        static {
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        private static ClassOwnership detectJvmBehavior() {
            ParameterizedType parameterizedType = (ParameterizedType) new a<String>() {
            }.getClass().getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Types.l(this.componentType));
            stringBuilder.append("[]");
            return stringBuilder.toString();
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return false;
            }
            return f.equal(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
    }

    enum JavaVersion {
        JAVA6 {
            GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }

            Type usedInGenericType(Type type) {
                i.checkNotNull(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isArray()) {
                        return new GenericArrayTypeImpl(cls.getComponentType());
                    }
                }
                return type;
            }
        },
        JAVA7 {
            Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.x((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            Type usedInGenericType(Type type) {
                return (Type) i.checkNotNull(type);
            }
        },
        JAVA8 {
            Type newArrayType(Type type) {
                return JAVA7.newArrayType(type);
            }

            Type usedInGenericType(Type type) {
                return JAVA7.usedInGenericType(type);
            }

            /* JADX WARNING: Removed duplicated region for block: B:3:0x0014 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.reflect.InvocationTargetException (r5_3 'e' java.lang.Throwable)} */
            /* JADX WARNING: Missing block: B:3:0x0014, code:
            r5 = move-exception;
     */
            /* JADX WARNING: Missing block: B:5:0x001a, code:
            throw new java.lang.RuntimeException(r5);
     */
            java.lang.String typeName(java.lang.reflect.Type r5) {
                /*
                r4 = this;
                r0 = java.lang.reflect.Type.class;
                r1 = "getTypeName";
                r2 = 0;
                r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
                r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
                r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
                r5 = r0.invoke(r5, r1);	 Catch:{ NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
                r5 = (java.lang.String) r5;	 Catch:{ NoSuchMethodException -> 0x001b, InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
                return r5;
            L_0x0014:
                r5 = move-exception;
                r0 = new java.lang.RuntimeException;
                r0.<init>(r5);
                throw r0;
            L_0x001b:
                r5 = new java.lang.AssertionError;
                r0 = "Type.getTypeName should be available in Java 8";
                r5.<init>(r0);
                throw r5;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.Types.JavaVersion.3.typeName(java.lang.reflect.Type):java.lang.String");
            }
        },
        JAVA9 {
            boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            Type newArrayType(Type type) {
                return JAVA8.newArrayType(type);
            }

            Type usedInGenericType(Type type) {
                return JAVA8.usedInGenericType(type);
            }

            String typeName(Type type) {
                return JAVA8.typeName(type);
            }
        };
        
        static final JavaVersion CURRENT = null;

        boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        abstract Type newArrayType(Type type);

        abstract Type usedInGenericType(Type type);

        String typeName(Type type) {
            return Types.l(type);
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
            for (Type usedInGenericType : typeArr) {
                sO.ae(usedInGenericType(usedInGenericType));
            }
            return sO.sP();
        }
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            i.checkNotNull(cls);
            i.checkArgument(typeArr.length == cls.getTypeParameters().length);
            Types.a(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public Type[] getActualTypeArguments() {
            return Types.t(this.argumentsList);
        }

        public Type getRawType() {
            return this.rawType;
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                stringBuilder.append(JavaVersion.CURRENT.typeName(this.ownerType));
                stringBuilder.append('.');
            }
            stringBuilder.append(this.rawType.getName());
            stringBuilder.append('<');
            stringBuilder.append(Types.VD.join(s.a(this.argumentsList, Types.VB)));
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        public int hashCode() {
            return ((this.ownerType == null ? 0 : this.ownerType.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (getRawType().equals(parameterizedType.getRawType()) && f.equal(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                z = true;
            }
            return z;
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.a(typeArr, "lower bound for wildcard");
            Types.a(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public Type[] getLowerBounds() {
            return Types.t(this.lowerBounds);
        }

        public Type[] getUpperBounds() {
            return Types.t(this.upperBounds);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            Type type;
            StringBuilder stringBuilder = new StringBuilder("?");
            Iterator sI = this.lowerBounds.iterator();
            while (sI.hasNext()) {
                type = (Type) sI.next();
                stringBuilder.append(" super ");
                stringBuilder.append(JavaVersion.CURRENT.typeName(type));
            }
            for (Type type2 : Types.C(this.upperBounds)) {
                stringBuilder.append(" extends ");
                stringBuilder.append(JavaVersion.CURRENT.typeName(type2));
            }
            return stringBuilder.toString();
        }
    }

    static final class a<X> {
        static final boolean VH = (a.class.getTypeParameters()[0].equals(Types.a((GenericDeclaration) a.class, "X", new Type[0])) ^ 1);

        a() {
        }
    }

    private static final class b<D extends GenericDeclaration> {
        private final D VJ;
        private final ImmutableList<Type> VK;
        private final String name;

        b(D d, String str, Type[] typeArr) {
            Types.a(typeArr, "bound for type variable");
            this.VJ = (GenericDeclaration) i.checkNotNull(d);
            this.name = (String) i.checkNotNull(str);
            this.VK = ImmutableList.f(typeArr);
        }

        public D getGenericDeclaration() {
            return this.VJ;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }

        public int hashCode() {
            return this.VJ.hashCode() ^ this.name.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (a.VH) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof c)) {
                    return false;
                }
                b a = ((c) Proxy.getInvocationHandler(obj)).VM;
                if (!(this.name.equals(a.getName()) && this.VJ.equals(a.getGenericDeclaration()) && this.VK.equals(a.VK))) {
                    z = false;
                }
                return z;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (!(this.name.equals(typeVariable.getName()) && this.VJ.equals(typeVariable.getGenericDeclaration()))) {
                    z = false;
                }
                return z;
            }
        }
    }

    private static final class c implements InvocationHandler {
        private static final ImmutableMap<String, Method> VL;
        private final b<?> VM;

        static {
            com.google.common.collect.ImmutableMap.a sU = ImmutableMap.sU();
            Method[] methods = b.class.getMethods();
            int length = methods.length;
            int i = 0;
            while (i < length) {
                Method method = methods[i];
                if (method.getDeclaringClass().equals(b.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                        sU.r(method.getName(), method);
                    }
                } else {
                    i++;
                }
            }
            VL = sU.tc();
        }

        c(b<?> bVar) {
            this.VM = bVar;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            method = (Method) VL.get(name);
            if (method == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method.invoke(this.VM, objArr);
            } catch (InvocationTargetException e) {
                throw e.getCause();
            }
        }
    }

    static Type newArrayType(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z = true;
        i.checkArgument(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return supertypeOf(newArrayType(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        i.checkArgument(z, "Wildcard should have only one upper bound.");
        return subtypeOf(newArrayType(upperBounds[0]));
    }

    static ParameterizedType a(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a((Class) cls, typeArr);
        }
        i.checkNotNull(typeArr);
        i.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", (Object) cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    static <D extends GenericDeclaration> TypeVariable<D> a(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return b(d, str, typeArr);
    }

    static WildcardType subtypeOf(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    static WildcardType supertypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    static String l(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getComponentType(Type type) {
        i.checkNotNull(type);
        final AtomicReference atomicReference = new AtomicReference();
        new f() {
            void a(TypeVariable<?> typeVariable) {
                atomicReference.set(Types.e(typeVariable.getBounds()));
            }

            void b(WildcardType wildcardType) {
                atomicReference.set(Types.e(wildcardType.getUpperBounds()));
            }

            void b(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            void s(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }
        }.d(type);
        return (Type) atomicReference.get();
    }

    private static Type e(Type[] typeArr) {
        for (Type componentType : typeArr) {
            Type componentType2 = getComponentType(componentType2);
            if (componentType2 != null) {
                if (componentType2 instanceof Class) {
                    Class cls = (Class) componentType2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return subtypeOf(componentType2);
            }
        }
        return null;
    }

    private static <D extends GenericDeclaration> TypeVariable<D> b(D d, String str, Type[] typeArr) {
        return (TypeVariable) c.a(TypeVariable.class, new c(new b(d, str, typeArr)));
    }

    private static Type[] t(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    private static Iterable<Type> C(Iterable<Type> iterable) {
        return s.a((Iterable) iterable, Predicates.b(Predicates.G(Object.class)));
    }

    private static void a(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Object obj = (Class) type;
                i.a(obj.isPrimitive() ^ 1, "Primitive type '%s' used as %s", obj, (Object) str);
            }
        }
    }

    static Class<?> x(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }
}
