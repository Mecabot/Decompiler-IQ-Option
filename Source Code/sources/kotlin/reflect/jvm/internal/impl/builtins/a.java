package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.h;

/* compiled from: BuiltInsInitializer.kt */
public final class a<T extends g> {
    private volatile T exb;
    private volatile boolean exc;
    private Throwable exd;
    private final kotlin.jvm.a.a<T> exe;

    public a(kotlin.jvm.a.a<? extends T> aVar) {
        h.e(aVar, "constructor");
        this.exe = aVar;
    }

    private final synchronized void initialize() {
        if (this.exb == null) {
            Throwable th;
            if (this.exd != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Built-in library initialization failed previously: ");
                th = this.exd;
                if (th == null) {
                    h.aXZ();
                }
                stringBuilder.append(th);
                throw new IllegalStateException(stringBuilder.toString(), this.exd);
            } else if (this.exc) {
                throw new IllegalStateException("Built-in library initialization loop");
            } else {
                this.exc = true;
                try {
                    this.exb = (g) this.exe.invoke();
                    this.exc = false;
                } catch (Throwable th2) {
                    this.exc = false;
                }
            }
        }
    }

    public final T bax() {
        T t;
        if (this.exc) {
            synchronized (this) {
                t = this.exb;
                if (t != null) {
                } else {
                    throw new AssertionError("Built-ins are not initialized (note: We are under the same lock as initializing and instance)");
                }
            }
            return t;
        }
        if (this.exb == null) {
            initialize();
        }
        t = this.exb;
        if (t == null) {
            h.aXZ();
        }
        return t;
    }
}
