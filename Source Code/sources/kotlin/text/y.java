package kotlin.text;

import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"})
/* compiled from: StringBuilderJVM.kt */
final class y {
    public static final String eZD;
    public static final y eZE = new y();

    static {
        String property = System.getProperty("line.separator");
        if (property == null) {
            h.aXZ();
        }
        eZD = property;
    }

    private y() {
    }
}
