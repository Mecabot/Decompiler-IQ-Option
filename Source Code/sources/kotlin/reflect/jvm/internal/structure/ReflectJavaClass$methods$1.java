package kotlin.reflect.jvm.internal.structure;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "method", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$methods$1 extends Lambda implements b<Method, Boolean> {
    final /* synthetic */ j this$0;

    ReflectJavaClass$methods$1(j jVar) {
        this.this$0 = jVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(i((Method) obj));
    }

    public final boolean i(Method method) {
        h.d(method, FirebaseAnalytics.b.METHOD);
        return (method.isSynthetic() || (this.this$0.isEnum() && this.this$0.h(method))) ? false : true;
    }
}
