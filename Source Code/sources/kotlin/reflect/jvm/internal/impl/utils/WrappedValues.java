package kotlin.reflect.jvm.internal.impl.utils;

public class WrappedValues {
    public static volatile boolean eXT = false;
    private static final Object ewz = new Object() {
        public String toString() {
            return "NULL_VALUE";
        }
    };

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    private static final class a {
        private final Throwable baX;

        /* synthetic */ a(Throwable th, AnonymousClass1 anonymousClass1) {
            this(th);
        }

        private a(Throwable th) {
            this.baX = th;
        }

        public Throwable getThrowable() {
            return this.baX;
        }

        public String toString() {
            return this.baX.toString();
        }
    }

    public static <V> V dj(Object obj) {
        return obj == ewz ? null : obj;
    }

    public static <V> Object dk(V v) {
        return v == null ? ewz : v;
    }

    public static Object ah(Throwable th) {
        return new a(th, null);
    }

    public static <V> V dl(Object obj) {
        return dj(dm(obj));
    }

    public static <V> V dm(Object obj) {
        if (!(obj instanceof a)) {
            return obj;
        }
        Throwable throwable = ((a) obj).getThrowable();
        if (eXT && c.ag(throwable)) {
            throw new WrappedProcessCanceledException(throwable);
        }
        throw c.j(throwable);
    }
}
