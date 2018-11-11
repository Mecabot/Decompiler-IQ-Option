package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.jvm.internal.h;

/* compiled from: util.kt */
public final class g extends a {
    private final String value;

    public g(String str) {
        h.e(str, b.VALUE);
        super();
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
