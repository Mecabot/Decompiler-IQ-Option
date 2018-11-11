package com.google.common.util.concurrent;

/* compiled from: Platform */
final class w {
    static boolean d(Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }
}
