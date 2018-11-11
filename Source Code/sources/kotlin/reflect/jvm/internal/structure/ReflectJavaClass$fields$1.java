package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Field;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "field", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "invoke"})
/* compiled from: ReflectJavaClass.kt */
final class ReflectJavaClass$fields$1 extends Lambda implements b<Field, Boolean> {
    public static final ReflectJavaClass$fields$1 eYu = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(d((Field) obj));
    }

    public final boolean d(Field field) {
        h.d(field, "field");
        return field.isSynthetic() ^ 1;
    }
}
