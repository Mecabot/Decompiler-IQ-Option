package com.google.common.reflect;

import com.google.common.base.i;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: Reflection */
public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        i.checkNotNull(invocationHandler);
        i.a(cls.isInterface(), "%s is not an interface", (Object) cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
