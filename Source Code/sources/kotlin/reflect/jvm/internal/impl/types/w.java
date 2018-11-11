package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.a;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.checker.l;

/* compiled from: KotlinType.kt */
public abstract class w implements a {
    public abstract boolean aYp();

    public abstract h bbk();

    public abstract List<ap> bdF();

    public abstract an bwA();

    public abstract ay bzc();

    private w() {
    }

    public /* synthetic */ w(f fVar) {
        this();
    }

    public final int hashCode() {
        if (y.aF(this)) {
            return super.hashCode();
        }
        return (((bwA().hashCode() * 31) + bdF().hashCode()) * 31) + aYp();
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (!(aYp() == wVar.aYp() && l.eVB.a(bzc(), wVar.bzc()))) {
            z = false;
        }
        return z;
    }
}
