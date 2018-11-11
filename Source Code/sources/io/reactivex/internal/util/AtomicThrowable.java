package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean Y(Throwable th) {
        return ExceptionHelper.a(this, th);
    }

    public Throwable aXi() {
        return ExceptionHelper.a(this);
    }
}
