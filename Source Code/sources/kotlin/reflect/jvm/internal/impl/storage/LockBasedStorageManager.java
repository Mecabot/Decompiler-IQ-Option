package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.l;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;

public class LockBasedStorageManager implements h {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String PACKAGE_NAME = v.o(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public static final h eUc = new LockBasedStorageManager("NO_LOCKS", c.eUj, d.eUq) {
        protected <T> i<T> byC() {
            return i.byG();
        }
    };
    protected final Lock aQf;
    private final c eUd;
    private final String eUe;

    private enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    public interface c {
        public static final c eUj = new c() {
            public RuntimeException af(Throwable th) {
                throw kotlin.reflect.jvm.internal.impl.utils.c.j(th);
            }
        };

        RuntimeException af(Throwable th);
    }

    private static class d<K, V> {
        private final kotlin.jvm.a.a<? extends V> eUk;
        private final K key;

        public d(K k, kotlin.jvm.a.a<? extends V> aVar) {
            this.key = k;
            this.eUk = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.key.equals(((d) obj).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    private static class i<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean eUp;
        private final T value;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public static <T> i<T> df(T t) {
            return new i(t, false);
        }

        public static <T> i<T> byG() {
            return new i(null, true);
        }

        private i(T t, boolean z) {
            this.value = t;
            this.eUp = z;
        }

        public T getValue() {
            return this.value;
        }

        public boolean byH() {
            return this.eUp;
        }

        public String toString() {
            return byH() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    private static class e<T> implements f<T> {
        private final LockBasedStorageManager eUl;
        private final kotlin.jvm.a.a<? extends T> eUm;
        private volatile Object value = NotValue.NOT_COMPUTED;

        protected void dd(T t) {
        }

        public e(LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.a.a<? extends T> aVar) {
            this.eUl = lockBasedStorageManager;
            this.eUm = aVar;
        }

        public boolean byE() {
            return (this.value == NotValue.NOT_COMPUTED || this.value == NotValue.COMPUTING) ? false : true;
        }

        public T invoke() {
            Object obj = this.value;
            if (!(obj instanceof NotValue)) {
                return WrappedValues.dm(obj);
            }
            this.eUl.aQf.lock();
            try {
                T value;
                NotValue notValue = this.value;
                if (notValue instanceof NotValue) {
                    if (notValue == NotValue.COMPUTING) {
                        this.value = NotValue.RECURSION_WAS_DETECTED;
                        i he = he(true);
                        if (!he.byH()) {
                            value = he.getValue();
                        }
                    }
                    if (notValue == NotValue.RECURSION_WAS_DETECTED) {
                        i he2 = he(false);
                        if (!he2.byH()) {
                            value = he2.getValue();
                        }
                    }
                    this.value = NotValue.COMPUTING;
                    value = this.eUm.invoke();
                    this.value = value;
                    dd(value);
                } else {
                    value = WrappedValues.dm(notValue);
                }
                this.eUl.aQf.unlock();
                return value;
            } catch (Throwable th) {
                this.eUl.aQf.unlock();
            }
        }

        protected i<T> he(boolean z) {
            return this.eUl.byC();
        }
    }

    private static class g<K, V> implements c<K, V> {
        private final LockBasedStorageManager eUl;
        private final ConcurrentMap<K, Object> eUn;
        private final kotlin.jvm.a.b<? super K, ? extends V> eUo;

        public g(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, kotlin.jvm.a.b<? super K, ? extends V> bVar) {
            this.eUl = lockBasedStorageManager;
            this.eUn = concurrentMap;
            this.eUo = bVar;
        }

        public V invoke(K k) {
            NotValue notValue = this.eUn.get(k);
            if (notValue != null && notValue != NotValue.COMPUTING) {
                return WrappedValues.dl(notValue);
            }
            this.eUl.aQf.lock();
            try {
                notValue = this.eUn.get(k);
                if (notValue == NotValue.COMPUTING) {
                    throw de(k);
                } else if (notValue != null) {
                    V dl = WrappedValues.dl(notValue);
                    return dl;
                } else {
                    Throwable th = null;
                    Throwable H;
                    try {
                        this.eUn.put(k, NotValue.COMPUTING);
                        V invoke = this.eUo.invoke(k);
                        NotValue put = this.eUn.put(k, WrappedValues.dk(invoke));
                        if (put != NotValue.COMPUTING) {
                            H = H(k, put);
                            try {
                                throw H;
                            } catch (Throwable th2) {
                                Throwable th3 = H;
                                H = th2;
                                th2 = th3;
                            }
                        } else {
                            this.eUl.aQf.unlock();
                            return invoke;
                        }
                    } catch (Throwable th4) {
                        H = th4;
                        if (kotlin.reflect.jvm.internal.impl.utils.c.ag(H)) {
                            this.eUn.remove(k);
                            throw ((RuntimeException) H);
                        } else if (H == th2) {
                            throw this.eUl.eUd.af(H);
                        } else {
                            notValue = this.eUn.put(k, WrappedValues.ah(H));
                            if (notValue != NotValue.COMPUTING) {
                                throw H(k, notValue);
                            }
                            throw this.eUl.eUd.af(H);
                        }
                    }
                }
            } finally {
                this.eUl.aQf.unlock();
            }
        }

        private AssertionError de(K k) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Recursion detected on input: ");
            stringBuilder.append(k);
            stringBuilder.append(" under ");
            stringBuilder.append(this.eUl);
            return (AssertionError) LockBasedStorageManager.ad(new AssertionError(stringBuilder.toString()));
        }

        private AssertionError H(K k, Object obj) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Race condition detected on input ");
            stringBuilder.append(k);
            stringBuilder.append(". Old value is ");
            stringBuilder.append(obj);
            stringBuilder.append(" under ");
            stringBuilder.append(this.eUl);
            return (AssertionError) LockBasedStorageManager.ad(new AssertionError(stringBuilder.toString()));
        }

        protected LockBasedStorageManager byF() {
            return this.eUl;
        }
    }

    private static class b<K, V> extends g<d<K, V>, V> {
        /* synthetic */ b(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, AnonymousClass1 anonymousClass1) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private b(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new kotlin.jvm.a.b<d<K, V>, V>() {
                /* renamed from: a */
                public V invoke(d<K, V> dVar) {
                    return dVar.eUk.invoke();
                }
            });
        }

        public V b(K k, kotlin.jvm.a.a<? extends V> aVar) {
            return invoke(new d(k, aVar));
        }
    }

    private static class f<T> extends e<T> implements e<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public f(LockBasedStorageManager lockBasedStorageManager, kotlin.jvm.a.a<? extends T> aVar) {
            super(lockBasedStorageManager, aVar);
        }

        public T invoke() {
            return super.invoke();
        }
    }

    private static class h<K, V> extends g<K, V> implements b<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        public h(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, kotlin.jvm.a.b<? super K, ? extends V> bVar) {
            super(lockBasedStorageManager, concurrentMap, bVar);
        }

        public V invoke(K k) {
            return super.invoke(k);
        }
    }

    private static class a<K, V> extends b<K, V> implements a<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
            Class cls = LockBasedStorageManager.class;
        }

        /* synthetic */ a(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, AnonymousClass1 anonymousClass1) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private a(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<d<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, null);
        }

        public V b(K k, kotlin.jvm.a.a<? extends V> aVar) {
            return super.b(k, aVar);
        }
    }

    private static String byA() {
        return "<unknown creating class>";
    }

    /* synthetic */ LockBasedStorageManager(String str, c cVar, Lock lock, AnonymousClass1 anonymousClass1) {
        this(str, cVar, lock);
    }

    private LockBasedStorageManager(String str, c cVar, Lock lock) {
        this.aQf = lock;
        this.eUd = cVar;
        this.eUe = str;
    }

    public LockBasedStorageManager() {
        this(byA(), c.eUj, new ReentrantLock());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(" (");
        stringBuilder.append(this.eUe);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public <K, V> b<K, V> o(kotlin.jvm.a.b<? super K, ? extends V> bVar) {
        return a((kotlin.jvm.a.b) bVar, byB());
    }

    public <K, V> b<K, V> a(kotlin.jvm.a.b<? super K, ? extends V> bVar, ConcurrentMap<K, Object> concurrentMap) {
        return new h(this, concurrentMap, bVar);
    }

    public <K, V> c<K, V> p(kotlin.jvm.a.b<? super K, ? extends V> bVar) {
        return b(bVar, byB());
    }

    public <K, V> c<K, V> b(kotlin.jvm.a.b<? super K, ? extends V> bVar, ConcurrentMap<K, Object> concurrentMap) {
        return new g(this, concurrentMap, bVar);
    }

    public <T> e<T> i(kotlin.jvm.a.a<? extends T> aVar) {
        return new f(this, aVar);
    }

    public <T> e<T> a(kotlin.jvm.a.a<? extends T> aVar, final T t) {
        return new f<T>(this, aVar) {
            protected i<T> he(boolean z) {
                return i.df(t);
            }
        };
    }

    public <T> e<T> a(kotlin.jvm.a.a<? extends T> aVar, kotlin.jvm.a.b<? super Boolean, ? extends T> bVar, kotlin.jvm.a.b<? super T, l> bVar2) {
        final kotlin.jvm.a.b<? super Boolean, ? extends T> bVar3 = bVar;
        final kotlin.jvm.a.b<? super T, l> bVar4 = bVar2;
        return new f<T>(this, aVar) {
            protected i<T> he(boolean z) {
                if (bVar3 == null) {
                    return super.he(z);
                }
                return i.df(bVar3.invoke(Boolean.valueOf(z)));
            }

            protected void dd(T t) {
                bVar4.invoke(t);
            }
        };
    }

    public <T> f<T> j(kotlin.jvm.a.a<? extends T> aVar) {
        return new e(this, aVar);
    }

    private static <K> ConcurrentMap<K, Object> byB() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    protected <T> i<T> byC() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Recursive call in a lazy value under ");
        stringBuilder.append(this);
        throw ((IllegalStateException) ad(new IllegalStateException(stringBuilder.toString())));
    }

    private static <T extends Throwable> T ad(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            if (!stackTrace[i].getClassName().startsWith(PACKAGE_NAME)) {
                break;
            }
            i++;
        }
        i = -1;
        List subList = Arrays.asList(stackTrace).subList(i, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }

    public <K, V> a<K, V> byD() {
        return new a(this, byB(), null);
    }
}
