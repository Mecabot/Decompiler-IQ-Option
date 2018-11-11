package kotlin.reflect.jvm.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, aXE = {"<anonymous>", "", "invoke"})
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2 extends Lambda implements a<Integer> {
    final /* synthetic */ Map $values;

    AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(Map map) {
        this.$values = map;
        super(0);
    }

    public /* synthetic */ Object invoke() {
        return Integer.valueOf(aqI());
    }

    public final int aqI() {
        int i = 0;
        for (Entry entry : this.$values.entrySet()) {
            int hashCode;
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof boolean[]) {
                hashCode = Arrays.hashCode((boolean[]) value);
            } else if (value instanceof char[]) {
                hashCode = Arrays.hashCode((char[]) value);
            } else if (value instanceof byte[]) {
                hashCode = Arrays.hashCode((byte[]) value);
            } else if (value instanceof short[]) {
                hashCode = Arrays.hashCode((short[]) value);
            } else if (value instanceof int[]) {
                hashCode = Arrays.hashCode((int[]) value);
            } else if (value instanceof float[]) {
                hashCode = Arrays.hashCode((float[]) value);
            } else if (value instanceof long[]) {
                hashCode = Arrays.hashCode((long[]) value);
            } else if (value instanceof double[]) {
                hashCode = Arrays.hashCode((double[]) value);
            } else if (value instanceof Object[]) {
                hashCode = Arrays.hashCode((Object[]) value);
            } else {
                hashCode = value.hashCode();
            }
            i += hashCode ^ (str.hashCode() * 127);
        }
        return i;
    }
}
