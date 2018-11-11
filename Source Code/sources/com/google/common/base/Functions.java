package com.google.common.base;

import java.io.Serializable;

public final class Functions {

    private static class ConstantFunction<E> implements d<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        private final E value;

        public ConstantFunction(E e) {
            this.value = e;
        }

        public E apply(Object obj) {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ConstantFunction)) {
                return false;
            }
            return f.equal(this.value, ((ConstantFunction) obj).value);
        }

        public int hashCode() {
            return this.value == null ? 0 : this.value.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Functions.constant(");
            stringBuilder.append(this.value);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class PredicateFunction<T> implements d<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final j<T> predicate;

        private PredicateFunction(j<T> jVar) {
            this.predicate = (j) i.checkNotNull(jVar);
        }

        /* renamed from: z */
        public Boolean apply(T t) {
            return Boolean.valueOf(this.predicate.apply(t));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PredicateFunction)) {
                return false;
            }
            return this.predicate.equals(((PredicateFunction) obj).predicate);
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Functions.forPredicate(");
            stringBuilder.append(this.predicate);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static <T> d<T, Boolean> a(j<T> jVar) {
        return new PredicateFunction(jVar);
    }

    public static <E> d<Object, E> y(E e) {
        return new ConstantFunction(e);
    }
}
