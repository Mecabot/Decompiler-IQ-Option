package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements g {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder(this.prefix);
        stringBuilder.append('-');
        stringBuilder.append(incrementAndGet());
        String stringBuilder2 = stringBuilder.toString();
        Thread aVar = this.nonBlocking ? new a(runnable, stringBuilder2) : new Thread(runnable, stringBuilder2);
        aVar.setPriority(this.priority);
        aVar.setDaemon(true);
        return aVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        stringBuilder.append(this.prefix);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
