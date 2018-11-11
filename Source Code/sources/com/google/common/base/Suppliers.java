package com.google.common.base;

import java.io.Serializable;

public final class Suppliers {

    static class MemoizingSupplier<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<T> delegate;
        volatile transient boolean initialized;
        transient T value;

        MemoizingSupplier(n<T> nVar) {
            this.delegate = (n) i.checkNotNull(nVar);
        }

        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Suppliers.memoize(");
            stringBuilder.append(this.delegate);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class SupplierOfInstance<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T t) {
            this.instance = t;
        }

        public T get() {
            return this.instance;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierOfInstance)) {
                return false;
            }
            return f.equal(this.instance, ((SupplierOfInstance) obj).instance);
        }

        public int hashCode() {
            return f.hashCode(this.instance);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Suppliers.ofInstance(");
            stringBuilder.append(this.instance);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static class a<T> implements n<T> {
        volatile n<T> delegate;
        volatile boolean initialized;
        T value;

        a(n<T> nVar) {
            this.delegate = (n) i.checkNotNull(nVar);
        }

        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        this.delegate = null;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Suppliers.memoize(");
            stringBuilder.append(this.delegate);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static <T> n<T> a(n<T> nVar) {
        if ((nVar instanceof a) || (nVar instanceof MemoizingSupplier)) {
            return nVar;
        }
        return nVar instanceof Serializable ? new MemoizingSupplier(nVar) : new a(nVar);
    }

    public static <T> n<T> H(T t) {
        return new SupplierOfInstance(t);
    }
}
