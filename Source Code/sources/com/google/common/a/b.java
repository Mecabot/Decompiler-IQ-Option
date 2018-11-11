package com.google.common.a;

/* compiled from: Platform */
final class b {
    private static final ThreadLocal<char[]> Tz = new ThreadLocal<char[]>() {
        /* renamed from: uU */
        protected char[] initialValue() {
            return new char[1024];
        }
    };

    static char[] uT() {
        return (char[]) Tz.get();
    }
}
