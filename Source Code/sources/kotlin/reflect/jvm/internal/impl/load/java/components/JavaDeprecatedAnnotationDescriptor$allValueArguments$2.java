package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.j;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.constants.s;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaDeprecatedAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends s>> {
    public static final JavaDeprecatedAnnotationDescriptor$allValueArguments$2 eGi = new JavaDeprecatedAnnotationDescriptor$allValueArguments$2();

    JavaDeprecatedAnnotationDescriptor$allValueArguments$2() {
        super(0);
    }

    /* renamed from: adu */
    public final Map<f, s> invoke() {
        return ac.h(j.D(c.eGc.bfP(), new s("Deprecated in Java")));
    }
}
