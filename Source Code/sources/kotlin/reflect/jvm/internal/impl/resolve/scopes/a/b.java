package kotlin.reflect.jvm.internal.impl.resolve.scopes.a;

import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ExtensionReceiver */
public class b extends a implements d {
    private final a eSx;

    public b(a aVar, w wVar, e eVar) {
        super(wVar, eVar);
        this.eSx = aVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bai());
        stringBuilder.append(": Ext {");
        stringBuilder.append(this.eSx);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
