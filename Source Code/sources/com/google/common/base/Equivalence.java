package com.google.common.base;

import java.io.Serializable;

public abstract class Equivalence<T> {

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals MJ = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        protected boolean g(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        protected int x(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return MJ;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity Na = new Identity();
        private static final long serialVersionUID = 1;

        protected boolean g(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        protected int x(Object obj) {
            return System.identityHashCode(obj);
        }

        private Object readResolve() {
            return Na;
        }
    }

    protected abstract boolean g(T t, T t2);

    protected abstract int x(T t);

    protected Equivalence() {
    }

    public final boolean f(T t, T t2) {
        if (t == t2) {
            return true;
        }
        return (t == null || t2 == null) ? false : g(t, t2);
    }

    public final int hash(T t) {
        return t == null ? 0 : x(t);
    }

    public static Equivalence<Object> pK() {
        return Equals.MJ;
    }

    public static Equivalence<Object> pL() {
        return Identity.Na;
    }
}
