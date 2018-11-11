package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.a;
import kotlin.reflect.d;
import kotlin.reflect.n;

public abstract class CallableReference implements Serializable, a {
    public static final Object euq = NoReceiver.eur;
    private transient a eup;
    protected final Object receiver;

    private static class NoReceiver implements Serializable {
        private static final NoReceiver eur = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return eur;
        }
    }

    protected abstract a aXP();

    public CallableReference() {
        this(euq);
    }

    protected CallableReference(Object obj) {
        this.receiver = obj;
    }

    public Object aXQ() {
        return this.receiver;
    }

    public a aXR() {
        a aVar = this.eup;
        if (aVar != null) {
            return aVar;
        }
        aVar = aXP();
        this.eup = aVar;
        return aVar;
    }

    protected a aXS() {
        CallableReference aXR = aXR();
        if (aXR != this) {
            return aXR;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public d Py() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    public n aXT() {
        return aXS().aXT();
    }

    public Object L(Object... objArr) {
        return aXS().L(objArr);
    }
}
