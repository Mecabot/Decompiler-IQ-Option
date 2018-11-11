package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class a extends f<c> {
    public a(c cVar) {
        h.e(cVar, b.VALUE);
        super(cVar);
    }

    public w h(u uVar) {
        h.e(uVar, "module");
        return ((c) getValue()).bai();
    }
}
