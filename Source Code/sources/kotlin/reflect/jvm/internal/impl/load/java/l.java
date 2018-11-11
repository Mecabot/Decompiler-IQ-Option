package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ad;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.b;
import kotlin.reflect.jvm.internal.impl.resolve.c;

/* compiled from: JvmAbi */
public final class l {
    public static final b eFi = new b("kotlin.jvm.JvmField");
    public static final a eFj = a.t(new b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));

    public static boolean mk(String str) {
        return str.startsWith("get") || str.startsWith("is");
    }

    public static boolean ml(String str) {
        return str.startsWith("set");
    }

    public static String mm(String str) {
        if (mo(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get");
        stringBuilder.append(kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.a.mZ(str));
        return stringBuilder.toString();
    }

    public static String mn(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        stringBuilder.append(mo(str) ? str.substring("is".length()) : kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.a.mZ(str));
        return stringBuilder.toString();
    }

    public static boolean mo(String str) {
        boolean z = false;
        if (!str.startsWith("is") || str.length() == "is".length()) {
            return false;
        }
        char charAt = str.charAt("is".length());
        if ('a' > charAt || charAt > 'z') {
            z = true;
        }
        return z;
    }

    public static boolean e(ad adVar) {
        if (adVar.bcW() == Kind.FAKE_OVERRIDE) {
            return false;
        }
        boolean z = true;
        if (p(adVar.bbv())) {
            return true;
        }
        if (!(c.D(adVar.bbv()) && p((CallableMemberDescriptor) adVar))) {
            z = false;
        }
        return z;
    }

    public static boolean p(k kVar) {
        return c.D(kVar) && c.L(kVar.bbv()) && !b((d) kVar);
    }

    public static boolean b(d dVar) {
        return kotlin.reflect.jvm.internal.impl.builtins.d.exk.b(dVar);
    }

    public static boolean p(CallableMemberDescriptor callableMemberDescriptor) {
        for (f fVar : callableMemberDescriptor.bbQ().bej()) {
            if (AnnotationUseSiteTarget.FIELD.equals(fVar.beg()) && eFi.equals(fVar.bef().bdD())) {
                return true;
            }
        }
        return callableMemberDescriptor.bbQ().k(eFi);
    }
}
