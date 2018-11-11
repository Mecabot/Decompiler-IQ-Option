package kotlin.reflect.jvm.internal;

import java.util.Map;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends Lambda implements a<String> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ Map $values;

    AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class cls, Map map) {
        this.$annotationClass = cls;
        this.$values = map;
        super(0);
    }

    /* renamed from: PM */
    public final String invoke() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        stringBuilder.append(this.$annotationClass.getCanonicalName());
        u.a(this.$values.entrySet(), stringBuilder, ", ", "(", ")", 0, null, AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.euY, 48, null);
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
