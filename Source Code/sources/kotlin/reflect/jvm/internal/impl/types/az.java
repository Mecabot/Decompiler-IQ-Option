package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: KotlinType.kt */
public abstract class az extends w {
    public boolean byE() {
        return true;
    }

    protected abstract w bzd();

    public az() {
        super();
    }

    public g bbQ() {
        return bzd().bbQ();
    }

    public an bwA() {
        return bzd().bwA();
    }

    public List<ap> bdF() {
        return bzd().bdF();
    }

    public boolean aYp() {
        return bzd().aYp();
    }

    public h bbk() {
        return bzd().bbk();
    }

    public final ay bzc() {
        w bzd = bzd();
        while (bzd instanceof az) {
            bzd = ((az) bzd).bzd();
        }
        if (bzd != null) {
            return (ay) bzd;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        return byE() ? bzd().toString() : "<Not computed yet>";
    }
}
