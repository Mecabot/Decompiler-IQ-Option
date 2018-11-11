package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.internal.a.d;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.n;

/* compiled from: SmartSet.kt */
public final class i<T> extends AbstractSet<T> {
    private static final int eXQ = 5;
    public static final b eXR = new b();
    private Object data;
    private int size;

    /* compiled from: SmartSet.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final <T> i<T> bzH() {
            return new i();
        }

        public final <T> i<T> Y(Collection<? extends T> collection) {
            h.e(collection, "set");
            i<T> iVar = new i();
            iVar.addAll(collection);
            return iVar;
        }
    }

    /* compiled from: SmartSet.kt */
    private static final class a<T> implements Iterator<T>, d {
        private final Iterator<T> eXS;

        public a(T[] tArr) {
            h.e(tArr, "array");
            this.eXS = kotlin.jvm.internal.b.K(tArr);
        }

        public boolean hasNext() {
            return this.eXS.hasNext();
        }

        public T next() {
            return this.eXS.next();
        }

        /* renamed from: bzI */
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: SmartSet.kt */
    private static final class c<T> implements Iterator<T>, d {
        private final T element;
        private boolean euH = true;

        public c(T t) {
            this.element = t;
        }

        public T next() {
            if (this.euH) {
                this.euH = false;
                return this.element;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.euH;
        }

        /* renamed from: bzI */
        public Void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final <T> i<T> bzH() {
        return eXR.bzH();
    }

    private i() {
    }

    public /* synthetic */ i(f fVar) {
        this();
    }

    public final int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.data);
        }
        if (size() < eXQ) {
            Object obj = this.data;
            if (obj != null) {
                return new a((Object[]) obj);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object obj2 = this.data;
        if (obj2 != null) {
            return n.cz(obj2).iterator();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
    }

    public boolean add(T t) {
        Object obj;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (h.E(this.data, t)) {
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < eXQ) {
            obj = this.data;
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] objArr = (Object[]) obj;
            if (i.b(objArr, (Object) t)) {
                return false;
            }
            if (size() == eXQ - 1) {
                obj = aj.J(Arrays.copyOf(objArr, objArr.length));
                obj.add(t);
            } else {
                obj = Arrays.copyOf(objArr, size() + 1);
                obj[obj.length - 1] = t;
            }
            this.data = obj;
        } else {
            obj = this.data;
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
            } else if (!n.cz(obj).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    public void clear() {
        this.data = null;
        setSize(0);
    }

    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return h.E(this.data, obj);
        }
        Object obj2;
        if (size() < eXQ) {
            obj2 = this.data;
            if (obj2 != null) {
                return i.b((Object[]) obj2, obj);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        obj2 = this.data;
        if (obj2 != null) {
            return ((Set) obj2).contains(obj);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Set<T>");
    }
}
