package com.google.common.reflect;

import com.google.common.base.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.i;
import com.google.common.collect.p;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public abstract class TypeToken<T> extends d<T> implements Serializable {
    private transient e Vs;
    private final Type runtimeType;

    private static abstract class a<K> {
        static final a<TypeToken<?>> Vu = new a<TypeToken<?>>() {
            /* renamed from: c */
            Class<?> aL(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* renamed from: d */
            Iterable<? extends TypeToken<?>> aM(TypeToken<?> typeToken) {
                return typeToken.vv();
            }

            /* renamed from: e */
            TypeToken<?> aN(TypeToken<?> typeToken) {
                return typeToken.vu();
            }
        };
        static final a<Class<?>> Vv = new a<Class<?>>() {
            /* renamed from: u */
            Class<?> aL(Class<?> cls) {
                return cls;
            }

            /* renamed from: v */
            Iterable<? extends Class<?>> aM(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* renamed from: w */
            Class<?> aN(Class<?> cls) {
                return cls.getSuperclass();
            }
        };

        abstract Class<?> aL(K k);

        abstract Iterable<? extends K> aM(K k);

        abstract K aN(K k);

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        final ImmutableList<K> aK(K k) {
            return B(ImmutableList.af(k));
        }

        ImmutableList<K> B(Iterable<? extends K> iterable) {
            Map us = Maps.us();
            for (Object a : iterable) {
                a(a, us);
            }
            return a(us, Ordering.natural().reverse());
        }

        private int a(K k, Map<? super K, Integer> map) {
            Integer num = (Integer) map.get(k);
            if (num != null) {
                return num.intValue();
            }
            int isInterface = aL(k).isInterface();
            for (Object a : aM(k)) {
                isInterface = Math.max(isInterface, a(a, (Map) map));
            }
            Object aN = aN(k);
            if (aN != null) {
                isInterface = Math.max(isInterface, a(aN, (Map) map));
            }
            isInterface++;
            map.put(k, Integer.valueOf(isInterface));
            return isInterface;
        }

        private static <K, V> ImmutableList<K> a(final Map<K, V> map, final Comparator<? super V> comparator) {
            return new Ordering<K>() {
                public int compare(K k, K k2) {
                    return comparator.compare(map.get(k), map.get(k2));
                }
            }.immutableSortedCopy(map.keySet());
        }
    }

    private enum TypeFilter implements j<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> typeToken) {
                return ((typeToken.runtimeType instanceof TypeVariable) || (typeToken.runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$1 */
    class AnonymousClass1 extends a<T> {
        final /* synthetic */ TypeToken this$0;

        public TypeToken<T> vr() {
            return this.this$0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vr());
            stringBuilder.append(".");
            stringBuilder.append(super.toString());
            return stringBuilder.toString();
        }
    }

    public class TypeSet extends p<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> Vy;

        TypeSet() {
        }

        /* renamed from: st */
        protected Set<TypeToken<? super T>> su() {
            Set set = this.Vy;
            if (set != null) {
                return set;
            }
            set = i.c(a.Vu.aK(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).sB();
            this.Vy = set;
            return set;
        }

        public Set<Class<? super T>> vy() {
            return ImmutableSet.n(a.Vv.B(TypeToken.this.vx()));
        }
    }

    /* synthetic */ TypeToken(Type type, AnonymousClass1 anonymousClass1) {
        this(type);
    }

    protected TypeToken() {
        this.runtimeType = vs();
        com.google.common.base.i.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) com.google.common.base.i.checkNotNull(type);
    }

    public static <T> TypeToken<T> t(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> h(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return (Class) vx().iterator().next();
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<?> i(Type type) {
        com.google.common.base.i.checkNotNull(type);
        e eVar = this.Vs;
        if (eVar == null) {
            eVar = e.a(this.runtimeType);
            this.Vs = eVar;
        }
        return h(eVar.b(type));
    }

    private TypeToken<?> j(Type type) {
        TypeToken<?> i = i(type);
        i.Vs = this.Vs;
        return i;
    }

    final TypeToken<? super T> vu() {
        if (this.runtimeType instanceof TypeVariable) {
            return k(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return k(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return j(genericSuperclass);
    }

    private TypeToken<? super T> k(Type type) {
        TypeToken<? super T> h = h(type);
        return h.getRawType().isInterface() ? null : h;
    }

    final ImmutableList<TypeToken<? super T>> vv() {
        if (this.runtimeType instanceof TypeVariable) {
            return c(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return c(((WildcardType) this.runtimeType).getUpperBounds());
        }
        com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
        for (Type j : getRawType().getGenericInterfaces()) {
            sO.ae(j(j));
        }
        return sO.sP();
    }

    private ImmutableList<TypeToken<? super T>> c(Type[] typeArr) {
        com.google.common.collect.ImmutableList.a sO = ImmutableList.sO();
        for (Type h : typeArr) {
            TypeToken h2 = h(h);
            if (h2.getRawType().isInterface()) {
                sO.ae(h2);
            }
        }
        return sO.sP();
    }

    public final TypeSet vw() {
        return new TypeSet();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeToken)) {
            return false;
        }
        return this.runtimeType.equals(((TypeToken) obj).runtimeType);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.l(this.runtimeType);
    }

    protected Object writeReplace() {
        return h(new e().b(this.runtimeType));
    }

    private ImmutableSet<Class<? super T>> vx() {
        final com.google.common.collect.ImmutableSet.a ts = ImmutableSet.ts();
        new f() {
            void a(TypeVariable<?> typeVariable) {
                d(typeVariable.getBounds());
            }

            void b(WildcardType wildcardType) {
                d(wildcardType.getUpperBounds());
            }

            void b(ParameterizedType parameterizedType) {
                ts.ae((Class) parameterizedType.getRawType());
            }

            void s(Class<?> cls) {
                ts.ae(cls);
            }

            void b(GenericArrayType genericArrayType) {
                ts.ae(Types.x(TypeToken.h(genericArrayType.getGenericComponentType()).getRawType()));
            }
        }.d(this.runtimeType);
        return ts.tt();
    }
}
