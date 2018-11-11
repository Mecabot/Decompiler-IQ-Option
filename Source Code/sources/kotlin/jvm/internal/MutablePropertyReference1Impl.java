package kotlin.jvm.internal;

import kotlin.reflect.d;

public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    private final String name;
    private final d owner;
    private final String signature;

    public MutablePropertyReference1Impl(d dVar, String str, String str2) {
        this.owner = dVar;
        this.name = str;
        this.signature = str2;
    }

    public d Py() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public Object get(Object obj) {
        return aYd().L(obj);
    }
}
