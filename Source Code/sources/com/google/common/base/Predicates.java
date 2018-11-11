package com.google.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Predicates {

    private static class CompositionPredicate<A, B> implements j<A>, Serializable {
        private static final long serialVersionUID = 0;
        final d<A, ? extends B> f;
        final j<B> p;

        private CompositionPredicate(j<B> jVar, d<A, ? extends B> dVar) {
            this.p = (j) i.checkNotNull(jVar);
            this.f = (d) i.checkNotNull(dVar);
        }

        public boolean apply(A a) {
            return this.p.apply(this.f.apply(a));
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            if (this.f.equals(compositionPredicate.f) && this.p.equals(compositionPredicate.p)) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            return this.f.hashCode() ^ this.p.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.p);
            stringBuilder.append("(");
            stringBuilder.append(this.f);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class IsEqualToPredicate<T> implements j<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        private IsEqualToPredicate(T t) {
            this.target = t;
        }

        public boolean apply(T t) {
            return this.target.equals(t);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof IsEqualToPredicate)) {
                return false;
            }
            return this.target.equals(((IsEqualToPredicate) obj).target);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Predicates.equalTo(");
            stringBuilder.append(this.target);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class NotPredicate<T> implements j<T>, Serializable {
        private static final long serialVersionUID = 0;
        final j<T> predicate;

        NotPredicate(j<T> jVar) {
            this.predicate = (j) i.checkNotNull(jVar);
        }

        public boolean apply(T t) {
            return this.predicate.apply(t) ^ 1;
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return false;
            }
            return this.predicate.equals(((NotPredicate) obj).predicate);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Predicates.not(");
            stringBuilder.append(this.predicate);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    enum ObjectPredicate implements j<Object> {
        ALWAYS_TRUE {
            public boolean apply(Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> j<T> withNarrowedType() {
            return this;
        }
    }

    private static class OrPredicate<T> implements j<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends j<? super T>> components;

        private OrPredicate(List<? extends j<? super T>> list) {
            this.components = list;
        }

        public boolean apply(T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (((j) this.components.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrPredicate)) {
                return false;
            }
            return this.components.equals(((OrPredicate) obj).components);
        }

        public String toString() {
            return Predicates.a("or", this.components);
        }
    }

    public static <T> j<T> pQ() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> j<T> pR() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> j<T> pS() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> j<T> b(j<T> jVar) {
        return new NotPredicate(jVar);
    }

    @SafeVarargs
    public static <T> j<T> a(j<? super T>... jVarArr) {
        return new OrPredicate(c(jVarArr));
    }

    public static <T> j<T> a(j<? super T> jVar, j<? super T> jVar2) {
        return new OrPredicate(b((j) i.checkNotNull(jVar), (j) i.checkNotNull(jVar2)));
    }

    public static <T> j<T> G(T t) {
        return t == null ? pR() : new IsEqualToPredicate(t);
    }

    public static <A, B> j<A> a(j<B> jVar, d<A, ? extends B> dVar) {
        return new CompositionPredicate(jVar, dVar);
    }

    private static String a(String str, Iterable<?> iterable) {
        StringBuilder stringBuilder = new StringBuilder("Predicates.");
        stringBuilder.append(str);
        stringBuilder.append('(');
        Object obj = 1;
        for (Object next : iterable) {
            if (obj == null) {
                stringBuilder.append(',');
            }
            stringBuilder.append(next);
            obj = null;
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    private static <T> List<j<? super T>> b(j<? super T> jVar, j<? super T> jVar2) {
        return Arrays.asList(new j[]{jVar, jVar2});
    }

    private static <T> List<T> c(T... tArr) {
        return a(Arrays.asList(tArr));
    }

    static <T> List<T> a(Iterable<T> iterable) {
        List arrayList = new ArrayList();
        for (T checkNotNull : iterable) {
            arrayList.add(i.checkNotNull(checkNotNull));
        }
        return arrayList;
    }
}
