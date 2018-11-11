package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, aXE = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflect-api"})
/* compiled from: moduleByClassLoader.kt */
final class ag {
    private final WeakReference<ClassLoader> aSh;
    private final int ewI;
    private ClassLoader ewJ;

    public ag(ClassLoader classLoader) {
        h.e(classLoader, "classLoader");
        this.aSh = new WeakReference(classLoader);
        this.ewI = System.identityHashCode(classLoader);
        this.ewJ = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.ewJ = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ag) && ((ClassLoader) this.aSh.get()) == ((ClassLoader) ((ag) obj).aSh.get());
    }

    public int hashCode() {
        return this.ewI;
    }

    public String toString() {
        ClassLoader classLoader = (ClassLoader) this.aSh.get();
        if (classLoader != null) {
            String classLoader2 = classLoader.toString();
            if (classLoader2 != null) {
                return classLoader2;
            }
        }
        return "<null>";
    }
}
