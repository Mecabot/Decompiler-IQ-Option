package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.h;
import kotlin.reflect.k;
import kotlin.reflect.l;

/* compiled from: Reflection */
public class j {
    private static final k euw;
    private static final b[] eux = new b[0];

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A:{PHI: r0 , Splitter: B:1:0x0001, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A:{PHI: r0 , Splitter: B:1:0x0001, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A:{PHI: r0 , Splitter: B:1:0x0001, ExcHandler: java.lang.ClassCastException (unused java.lang.ClassCastException)} */
    /* JADX WARNING: Missing block: B:4:0x000e, code:
            if (r0 == null) goto L_0x0011;
     */
    /* JADX WARNING: Missing block: B:5:0x0011, code:
            r0 = new kotlin.jvm.internal.k();
     */
    /* JADX WARNING: Missing block: B:6:0x0016, code:
            euw = r0;
            eux = new kotlin.reflect.b[0];
     */
    /* JADX WARNING: Missing block: B:7:0x001d, code:
            return;
     */
    static {
        /*
        r0 = 0;
        r1 = "kotlin.reflect.jvm.internal.z";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r1 = r1.newInstance();	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r1 = (kotlin.jvm.internal.k) r1;	 Catch:{ ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e, ClassCastException -> 0x000e }
        r0 = r1;
    L_0x000e:
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0016;
    L_0x0011:
        r0 = new kotlin.jvm.internal.k;
        r0.<init>();
    L_0x0016:
        euw = r0;
        r0 = 0;
        r0 = new kotlin.reflect.b[r0];
        eux = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.j.<clinit>():void");
    }

    public static d e(Class cls, String str) {
        return euw.e(cls, str);
    }

    public static b F(Class cls) {
        return euw.F(cls);
    }

    public static String a(Lambda lambda) {
        return euw.a(lambda);
    }

    public static e a(FunctionReference functionReference) {
        return euw.a(functionReference);
    }

    public static k a(PropertyReference0 propertyReference0) {
        return euw.a(propertyReference0);
    }

    public static l a(PropertyReference1 propertyReference1) {
        return euw.a(propertyReference1);
    }

    public static h a(MutablePropertyReference1 mutablePropertyReference1) {
        return euw.a(mutablePropertyReference1);
    }
}
