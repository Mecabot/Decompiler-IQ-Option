package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Map;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

/* compiled from: ClassMapperLite.kt */
final class ClassMapperLite$map$1$1 extends Lambda implements m<String, String, l> {
    final /* synthetic */ Map receiver$0;

    ClassMapperLite$map$1$1(Map map) {
        this.receiver$0 = map;
        super(2);
    }

    public /* synthetic */ Object B(Object obj, Object obj2) {
        Z((String) obj, (String) obj2);
        return l.etX;
    }

    public final void Z(String str, String str2) {
        h.e(str, "kotlinSimpleName");
        h.e(str2, "javaInternalName");
        Map map = this.receiver$0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("kotlin/");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append('L');
        stringBuilder.append(str2);
        stringBuilder.append(';');
        map.put(str, stringBuilder.toString());
    }
}
