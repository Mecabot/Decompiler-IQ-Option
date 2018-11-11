package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: AnnotationDescriptor.kt */
public interface c {

    /* compiled from: AnnotationDescriptor.kt */
    public static final class a {
        public static b a(c cVar) {
            d l = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(cVar);
            if (l == null) {
                return null;
            }
            if (p.W(l)) {
                l = null;
            }
            if (l == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.name.c z = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.z(l);
            if (z == null) {
                return null;
            }
            if (!z.isSafe()) {
                z = null;
            }
            return z != null ? z.btP() : null;
        }
    }

    w bai();

    ai bbR();

    b bdD();

    Map<f, kotlin.reflect.jvm.internal.impl.resolve.constants.f<?>> bee();
}
