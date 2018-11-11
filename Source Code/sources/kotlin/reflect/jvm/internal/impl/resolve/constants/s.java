package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class s extends f<String> {
    public s(String str) {
        h.e(str, b.VALUE);
        super(str);
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().bbg();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\"');
        stringBuilder.append((String) getValue());
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }
}
