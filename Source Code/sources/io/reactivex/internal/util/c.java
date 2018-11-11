package io.reactivex.internal.util;

import io.reactivex.d.a;
import io.reactivex.internal.schedulers.g;

/* compiled from: BlockingHelper */
public final class c {
    public static void aXj() {
        if (!a.aXk()) {
            return;
        }
        if ((Thread.currentThread() instanceof g) || a.aXl()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempt to block on a Scheduler ");
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
