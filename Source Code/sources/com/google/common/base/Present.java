package com.google.common.base;

final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public boolean isPresent() {
        return true;
    }

    Present(T t) {
        this.reference = t;
    }

    public T get() {
        return this.reference;
    }

    public T w(T t) {
        i.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public T pq() {
        return this.reference;
    }

    public <V> Optional<V> a(d<? super T, V> dVar) {
        return new Present(i.checkNotNull(dVar.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Present)) {
            return false;
        }
        return this.reference.equals(((Present) obj).reference);
    }

    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Optional.of(");
        stringBuilder.append(this.reference);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
