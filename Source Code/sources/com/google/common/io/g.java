package com.google.common.io;

import com.google.common.base.i;
import com.google.common.base.o;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Closer */
public final class g implements Closeable {
    private static final c Uo = (b.isAvailable() ? b.Uu : a.Ut);
    final c Uq;
    private final Deque<Closeable> Ur = new ArrayDeque(4);
    private Throwable Us;

    /* compiled from: Closer */
    interface c {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    /* compiled from: Closer */
    static final class a implements c {
        static final a Ut = new a();

        a() {
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = f.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Suppressing exception thrown when closing ");
            stringBuilder.append(closeable);
            logger.log(level, stringBuilder.toString(), th2);
        }
    }

    /* compiled from: Closer */
    static final class b implements c {
        static final b Uu = new b();
        static final Method Uv = vm();

        b() {
        }

        static boolean isAvailable() {
            return Uv != null;
        }

        private static Method vm() {
            try {
                return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    Uv.invoke(th, new Object[]{th2});
                } catch (Throwable unused) {
                    a.Ut.a(closeable, th, th2);
                }
            }
        }
    }

    public static g vl() {
        return new g(Uo);
    }

    g(c cVar) {
        this.Uq = (c) i.checkNotNull(cVar);
    }

    public <C extends Closeable> C a(C c) {
        if (c != null) {
            this.Ur.addFirst(c);
        }
        return c;
    }

    public RuntimeException j(Throwable th) {
        i.checkNotNull(th);
        this.Us = th;
        o.c(th, IOException.class);
        throw new RuntimeException(th);
    }

    public void close() {
        Throwable th = this.Us;
        while (!this.Ur.isEmpty()) {
            Closeable closeable = (Closeable) this.Ur.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.Uq.a(closeable, th, th2);
                }
            }
        }
        if (this.Us == null && th != null) {
            o.c(th, IOException.class);
            throw new AssertionError(th);
        }
    }
}
