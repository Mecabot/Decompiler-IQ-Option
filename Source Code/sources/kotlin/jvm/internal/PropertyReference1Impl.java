package kotlin.jvm.internal;

import kotlin.reflect.d;

public class PropertyReference1Impl extends PropertyReference1 {
    private final String name;
    private final d owner;
    private final String signature;

    public PropertyReference1Impl(d dVar, String str, String str2) {
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
