package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a.e;

/* compiled from: Visibility.kt */
public abstract class av {
    private final boolean eBs;
    private final String name;

    public abstract boolean b(e eVar, o oVar, k kVar);

    public av bec() {
        return this;
    }

    protected av(String str, boolean z) {
        h.e(str, "name");
        this.name = str;
        this.eBs = z;
    }

    public final boolean bed() {
        return this.eBs;
    }

    protected Integer c(av avVar) {
        h.e(avVar, "visibility");
        return au.b(this, avVar);
    }

    public String getDisplayName() {
        return this.name;
    }

    public final String toString() {
        return getDisplayName();
    }
}
