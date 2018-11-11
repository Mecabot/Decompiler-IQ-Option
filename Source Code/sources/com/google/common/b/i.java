package com.google.common.b;

import com.google.common.base.f;
import com.google.common.base.o;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.e;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.v;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: SubscriberRegistry */
final class i {
    private static final e<Class<?>, ImmutableList<Method>> Uh = CacheBuilder.qh().qo().a(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        /* renamed from: q */
        public ImmutableList<Method> K(Class<?> cls) {
            return i.n(cls);
        }
    });
    private static final e<Class<?>, ImmutableSet<Class<?>>> Ui = CacheBuilder.qh().qo().a(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() {
        /* renamed from: r */
        public ImmutableSet<Class<?>> K(Class<?> cls) {
            return ImmutableSet.n(TypeToken.t(cls).vw().vy());
        }
    });
    private final d Ua;
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<f>> Ug = Maps.ut();

    /* compiled from: SubscriberRegistry */
    private static final class a {
        private final List<Class<?>> Uj;
        private final String name;

        a(Method method) {
            this.name = method.getName();
            this.Uj = Arrays.asList(method.getParameterTypes());
        }

        public int hashCode() {
            return f.hashCode(this.name, this.Uj);
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.name.equals(aVar.name) && this.Uj.equals(aVar.Uj)) {
                z = true;
            }
            return z;
        }
    }

    i(d dVar) {
        this.Ua = (d) com.google.common.base.i.checkNotNull(dVar);
    }

    void aD(Object obj) {
        for (Entry entry : aJ(obj).asMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.Ug.get(cls);
            if (copyOnWriteArraySet == null) {
                copyOnWriteArraySet = new CopyOnWriteArraySet();
                copyOnWriteArraySet = (CopyOnWriteArraySet) com.google.common.base.e.h(this.Ug.putIfAbsent(cls, copyOnWriteArraySet), copyOnWriteArraySet);
            }
            copyOnWriteArraySet.addAll(collection);
        }
    }

    void unregister(Object obj) {
        for (Entry entry : aJ(obj).asMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            Collection collection = (Collection) entry.getValue();
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.Ug.get(cls);
            if (copyOnWriteArraySet != null) {
                if (!copyOnWriteArraySet.removeAll(collection)) {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("missing event subscriber for an annotated method. Is ");
            stringBuilder.append(obj);
            stringBuilder.append(" registered?");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    Iterator<f> aI(Object obj) {
        ImmutableSet o = o(obj.getClass());
        List aY = Lists.aY(o.size());
        Iterator sI = o.iterator();
        while (sI.hasNext()) {
            CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.Ug.get((Class) sI.next());
            if (copyOnWriteArraySet != null) {
                aY.add(copyOnWriteArraySet.iterator());
            }
        }
        return Iterators.m(aY.iterator());
    }

    private v<Class<?>, f> aJ(Object obj) {
        v<Class<?>, f> sG = HashMultimap.sG();
        Iterator sI = m(obj.getClass()).iterator();
        while (sI.hasNext()) {
            Method method = (Method) sI.next();
            sG.j(method.getParameterTypes()[0], f.a(this.Ua, obj, method));
        }
        return sG;
    }

    private static ImmutableList<Method> m(Class<?> cls) {
        return (ImmutableList) Uh.L(cls);
    }

    private static ImmutableList<Method> n(Class<?> cls) {
        Set<Class> vy = TypeToken.t(cls).vw().vy();
        Map us = Maps.us();
        for (Class declaredMethods : vy) {
            for (Object obj : declaredMethods.getDeclaredMethods()) {
                if (obj.isAnnotationPresent(e.class) && !obj.isSynthetic()) {
                    Class[] parameterTypes = obj.getParameterTypes();
                    boolean z = true;
                    if (parameterTypes.length != 1) {
                        z = false;
                    }
                    com.google.common.base.i.a(z, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", obj, parameterTypes.length);
                    a aVar = new a(obj);
                    if (!us.containsKey(aVar)) {
                        us.put(aVar, obj);
                    }
                }
            }
        }
        return ImmutableList.m(us.values());
    }

    static ImmutableSet<Class<?>> o(Class<?> cls) {
        try {
            return (ImmutableSet) Ui.L(cls);
        } catch (UncheckedExecutionException e) {
            throw o.g(e.getCause());
        }
    }
}
