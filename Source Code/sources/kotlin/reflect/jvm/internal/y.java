package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;

/* compiled from: ReflectProperties */
public class y {

    /* compiled from: ReflectProperties */
    public static abstract class c<T> {
        private static final Object ewz = new Object() {
        };

        public abstract T invoke();

        public final T G(Object obj, Object obj2) {
            return invoke();
        }

        protected Object cF(T t) {
            return t == null ? ewz : t;
        }

        protected T cG(Object obj) {
            return obj == ewz ? null : obj;
        }
    }

    /* compiled from: ReflectProperties */
    public static class a<T> extends c<T> {
        private SoftReference<Object> ewy = null;
        private final kotlin.jvm.a.a<T> initializer;

        public a(T t, kotlin.jvm.a.a<T> aVar) {
            this.initializer = aVar;
            if (t != null) {
                this.ewy = new SoftReference(cF(t));
            }
        }

        public T invoke() {
            SoftReference softReference = this.ewy;
            if (softReference != null) {
                Object obj = softReference.get();
                if (obj != null) {
                    return cG(obj);
                }
            }
            T invoke = this.initializer.invoke();
            this.ewy = new SoftReference(cF(invoke));
            return invoke;
        }
    }

    /* compiled from: ReflectProperties */
    public static class b<T> extends c<T> {
        private final kotlin.jvm.a.a<T> initializer;
        private Object value = null;

        public b(kotlin.jvm.a.a<T> aVar) {
            this.initializer = aVar;
        }

        public T invoke() {
            Object obj = this.value;
            if (obj != null) {
                return cG(obj);
            }
            T invoke = this.initializer.invoke();
            this.value = cF(invoke);
            return invoke;
        }
    }

    public static <T> b<T> g(kotlin.jvm.a.a<T> aVar) {
        return new b(aVar);
    }

    public static <T> a<T> a(T t, kotlin.jvm.a.a<T> aVar) {
        return new a(t, aVar);
    }

    public static <T> a<T> h(kotlin.jvm.a.a<T> aVar) {
        return a(null, aVar);
    }
}
