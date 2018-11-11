package kotlin.reflect.jvm.internal.impl.resolve.scopes.a;

import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: TransientReceiver */
public class h extends a {
    public h(w wVar) {
        this(wVar, null);
    }

    private h(w wVar, e eVar) {
        super(wVar, eVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Transient} : ");
        stringBuilder.append(bai());
        return stringBuilder.toString();
    }
}
