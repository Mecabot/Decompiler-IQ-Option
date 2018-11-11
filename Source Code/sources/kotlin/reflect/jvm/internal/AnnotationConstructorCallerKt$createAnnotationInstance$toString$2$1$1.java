package kotlin.reflect.jvm.internal;

import java.util.Arrays;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010&\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "entry", "", "", "invoke"})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 extends Lambda implements b<Entry<? extends String, ? extends Object>, String> {
    public static final AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 euY = new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1();

    AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1() {
        super(1);
    }

    /* renamed from: h */
    public final String invoke(Entry<String, ? extends Object> entry) {
        String arrays;
        h.e(entry, "entry");
        String str = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            arrays = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            arrays = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            arrays = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            arrays = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            arrays = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            arrays = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            arrays = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            arrays = Arrays.toString((double[]) value);
        } else if (value instanceof Object[]) {
            arrays = Arrays.toString((Object[]) value);
        } else {
            arrays = value.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('=');
        stringBuilder.append(arrays);
        return stringBuilder.toString();
    }
}
