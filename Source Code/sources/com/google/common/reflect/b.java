package com.google.common.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/* compiled from: Invokable */
public abstract class b<T, R> extends a implements GenericDeclaration {

    /* compiled from: Invokable */
    static class a<T> extends b<T, Object> {
        final Method method;

        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }
    }

    public final Class<? super T> getDeclaringClass() {
        return super.getDeclaringClass();
    }

    public TypeToken<T> vr() {
        return TypeToken.t(getDeclaringClass());
    }
}
