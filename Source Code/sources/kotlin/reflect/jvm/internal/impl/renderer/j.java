package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.c;
import kotlin.reflect.jvm.internal.impl.name.f;

/* compiled from: RenderingUtils.kt */
public final class j {
    public static final String K(f fVar) {
        h.e(fVar, "$receiver");
        String asString;
        if (L(fVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            asString = fVar.asString();
            h.d(asString, "asString()");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(String.valueOf('`'));
            stringBuilder2.append(asString);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append('`');
            return stringBuilder.toString();
        }
        asString = fVar.asString();
        h.d(asString, "asString()");
        return asString;
    }

    /* JADX WARNING: Missing block: B:18:0x003c, code:
            if (r5 != null) goto L_0x003e;
     */
    private static final boolean L(kotlin.reflect.jvm.internal.impl.name.f r5) {
        /*
        r0 = r5.btR();
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r5 = r5.asString();
        r0 = kotlin.reflect.jvm.internal.impl.renderer.i.eQu;
        r0 = r0.contains(r5);
        r2 = 1;
        if (r0 != 0) goto L_0x003e;
    L_0x0015:
        r0 = "string";
        kotlin.jvm.internal.h.d(r5, r0);
        r5 = (java.lang.CharSequence) r5;
        r0 = 0;
    L_0x001d:
        r3 = r5.length();
        if (r0 >= r3) goto L_0x003b;
    L_0x0023:
        r3 = r5.charAt(r0);
        r4 = java.lang.Character.isLetterOrDigit(r3);
        if (r4 != 0) goto L_0x0033;
    L_0x002d:
        r4 = 95;
        if (r3 == r4) goto L_0x0033;
    L_0x0031:
        r3 = 1;
        goto L_0x0034;
    L_0x0033:
        r3 = 0;
    L_0x0034:
        if (r3 == 0) goto L_0x0038;
    L_0x0036:
        r5 = 1;
        goto L_0x003c;
    L_0x0038:
        r0 = r0 + 1;
        goto L_0x001d;
    L_0x003b:
        r5 = 0;
    L_0x003c:
        if (r5 == 0) goto L_0x003f;
    L_0x003e:
        r1 = 1;
    L_0x003f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.j.L(kotlin.reflect.jvm.internal.impl.name.f):boolean");
    }

    public static final String g(c cVar) {
        h.e(cVar, "$receiver");
        List pathSegments = cVar.pathSegments();
        h.d(pathSegments, "pathSegments()");
        return cj(pathSegments);
    }

    public static final String cj(List<f> list) {
        h.e(list, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(K(fVar));
        }
        String stringBuilder2 = stringBuilder.toString();
        h.d(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }
}
