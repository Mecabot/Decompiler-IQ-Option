package com.google.common.cache;

import com.google.common.base.n;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {
    private static final n<f> Pf;

    private static final class PureJavaLongAddable extends AtomicLong implements f {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void increment() {
            getAndIncrement();
        }

        public void add(long j) {
            getAndAdd(j);
        }
    }

    static {
        n anonymousClass1;
        try {
            LongAdder longAdder = new LongAdder();
            anonymousClass1 = new n<f>() {
                /* renamed from: rs */
                public f get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            anonymousClass1 = new n<f>() {
                /* renamed from: rs */
                public f get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        Pf = anonymousClass1;
    }

    public static f rr() {
        return (f) Pf.get();
    }
}
