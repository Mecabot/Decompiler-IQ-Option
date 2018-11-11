package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: utils.kt */
final class UtilsKt$debugInfo$1$1 extends Lambda implements b<String, StringBuilder> {
    final /* synthetic */ StringBuilder receiver$0;

    UtilsKt$debugInfo$1$1(StringBuilder stringBuilder) {
        this.receiver$0 = stringBuilder;
        super(1);
    }

    /* renamed from: mY */
    public final StringBuilder invoke(String str) {
        h.e(str, "$receiver");
        StringBuilder stringBuilder = this.receiver$0;
        stringBuilder.append(str);
        h.d(stringBuilder, "append(value)");
        return q.t(stringBuilder);
    }
}
