package kotlin.reflect.jvm.internal.structure;

import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$innerClassNames$1 extends Lambda implements b<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClassNames$1 eYw = new ReflectJavaClass$innerClassNames$1();

    ReflectJavaClass$innerClassNames$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(V((Class) obj));
    }

    public final boolean V(Class<?> cls) {
        h.d(cls, "it");
        String simpleName = cls.getSimpleName();
        h.d(simpleName, "it.simpleName");
        return ((CharSequence) simpleName).length() == 0;
    }
}
