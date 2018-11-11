package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* compiled from: TypeVisitor */
abstract class f {
    private final Set<Type> Vz = Sets.uI();

    void a(TypeVariable<?> typeVariable) {
    }

    void b(GenericArrayType genericArrayType) {
    }

    void b(ParameterizedType parameterizedType) {
    }

    void b(WildcardType wildcardType) {
    }

    void s(Class<?> cls) {
    }

    f() {
    }

    public final void d(Type... typeArr) {
        for (Object obj : typeArr) {
            if (obj != null && this.Vz.add(obj)) {
                try {
                    if (obj instanceof TypeVariable) {
                        a((TypeVariable) obj);
                    } else if (obj instanceof WildcardType) {
                        b((WildcardType) obj);
                    } else if (obj instanceof ParameterizedType) {
                        b((ParameterizedType) obj);
                    } else if (obj instanceof Class) {
                        s((Class) obj);
                    } else if (obj instanceof GenericArrayType) {
                        b((GenericArrayType) obj);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown type: ");
                        stringBuilder.append(obj);
                        throw new AssertionError(stringBuilder.toString());
                    }
                } catch (Throwable th) {
                    this.Vz.remove(obj);
                }
            }
        }
    }
}
