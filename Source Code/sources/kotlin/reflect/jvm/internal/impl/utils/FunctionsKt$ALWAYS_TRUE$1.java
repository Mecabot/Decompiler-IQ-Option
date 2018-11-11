package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

/* compiled from: functions.kt */
final class FunctionsKt$ALWAYS_TRUE$1 extends Lambda implements b<Object, Boolean> {
    public static final FunctionsKt$ALWAYS_TRUE$1 eXv = new FunctionsKt$ALWAYS_TRUE$1();

    FunctionsKt$ALWAYS_TRUE$1() {
        super(1);
    }

    public final boolean cD(Object obj) {
        return true;
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(cD(obj));
    }
}
