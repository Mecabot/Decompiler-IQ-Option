package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: constantValues.kt */
public final class e extends m<Character> {
    public e(char c) {
        super(Character.valueOf(c));
    }

    /* renamed from: i */
    public ad h(u uVar) {
        h.e(uVar, "module");
        return uVar.bdy().bbd();
    }

    public String toString() {
        Object[] objArr = new Object[]{Integer.valueOf(((Character) getValue()).charValue()), D(((Character) getValue()).charValue())};
        String format = String.format("\\u%04X ('%s')", Arrays.copyOf(objArr, objArr.length));
        h.d(format, "java.lang.String.format(this, *args)");
        return format;
    }

    private final String D(char c) {
        switch (c) {
            case 8:
                return "\\b";
            case 9:
                return "\\t";
            case 10:
                return "\\n";
            case 12:
                return "\\f";
            case 13:
                return "\\r";
            default:
                String ch = E(c) ? Character.toString(c) : "?";
                h.d(ch, "if (isPrintableUnicode(c…cter.toString(c) else \"?\"");
                return ch;
        }
    }

    private final boolean E(char c) {
        byte type = (byte) Character.getType(c);
        return (type == (byte) 0 || type == (byte) 13 || type == (byte) 14 || type == (byte) 15 || type == (byte) 16 || type == (byte) 18 || type == (byte) 19) ? false : true;
    }
}
