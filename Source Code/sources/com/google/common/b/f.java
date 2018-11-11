package com.google.common.b;

import com.google.common.base.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* compiled from: Subscriber */
class f {
    private d Ua;
    private final Executor executor;
    private final Method method;
    final Object target;

    /* compiled from: Subscriber */
    static final class a extends f {
        /* synthetic */ a(d dVar, Object obj, Method method, AnonymousClass1 anonymousClass1) {
            this(dVar, obj, method);
        }

        private a(d dVar, Object obj, Method method) {
            super(dVar, obj, method, null);
        }

        void aG(Object obj) {
            synchronized (this) {
                super.aG(obj);
            }
        }
    }

    /* synthetic */ f(d dVar, Object obj, Method method, AnonymousClass1 anonymousClass1) {
        this(dVar, obj, method);
    }

    static f a(d dVar, Object obj, Method method) {
        return a(method) ? new f(dVar, obj, method) : new a(dVar, obj, method, null);
    }

    private f(d dVar, Object obj, Method method) {
        this.Ua = dVar;
        this.target = i.checkNotNull(obj);
        this.method = method;
        method.setAccessible(true);
        this.executor = dVar.uZ();
    }

    final void aF(final Object obj) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    f.this.aG(obj);
                } catch (InvocationTargetException e) {
                    f.this.Ua.a(e.getCause(), f.this.aH(obj));
                }
            }
        });
    }

    void aG(Object obj) {
        StringBuilder stringBuilder;
        try {
            this.method.invoke(this.target, new Object[]{i.checkNotNull(obj)});
        } catch (Throwable e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Method rejected target/argument: ");
            stringBuilder.append(obj);
            throw new Error(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Method became inaccessible: ");
            stringBuilder.append(obj);
            throw new Error(stringBuilder.toString(), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    private g aH(Object obj) {
        return new g(this.Ua, obj, this.target, this.method);
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public final boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.target == fVar.target && this.method.equals(fVar.method)) {
            z = true;
        }
        return z;
    }

    private static boolean a(Method method) {
        return method.getAnnotation(a.class) != null;
    }
}
