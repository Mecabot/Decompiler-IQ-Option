package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.android.gms.measurement.AppMeasurement.Param;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.a;
import kotlin.reflect.jvm.internal.impl.load.kotlin.j.c;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.b;

/* compiled from: methodSignatureMapping.kt */
final class l implements k<j> {
    public static final l eJU = new l();

    private l() {
    }

    /* renamed from: a */
    public j cT(j jVar) {
        h.e(jVar, "possiblyPrimitiveType");
        if (!(jVar instanceof c)) {
            return jVar;
        }
        c cVar = (c) jVar;
        if (cVar.biz() == null) {
            return jVar;
        }
        b u = b.u(cVar.biz().getWrapperFqName());
        h.d(u, "JvmClassName.byFqNameWit…mitiveType.wrapperFqName)");
        String internalName = u.getInternalName();
        h.d(internalName, "JvmClassName.byFqNameWit…apperFqName).internalName");
        return mr(internalName);
    }

    /* renamed from: ms */
    public j mq(String str) {
        h.e(str, "representation");
        boolean z = false;
        Object obj = str.length() > 0 ? 1 : null;
        if (m.etY && obj == null) {
            throw new AssertionError("empty string as JvmType");
        }
        char charAt = str.charAt(0);
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            if ((jvmPrimitiveType.getDesc().charAt(0) == charAt ? 1 : null) != null) {
                break;
            }
        }
        JvmPrimitiveType jvmPrimitiveType2 = null;
        if (jvmPrimitiveType2 != null) {
            return new c(jvmPrimitiveType2);
        }
        j cVar;
        if (charAt == 'V') {
            cVar = new c(null);
        } else if (charAt != '[') {
            if (charAt == 'L' && v.b((CharSequence) str, ';', false, 2, null)) {
                z = true;
            }
            if (!m.etY || z) {
                str = str.substring(1, str.length() - 1);
                h.d(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                cVar = new j.b(str);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Type that is not primitive nor array should be Object, but '");
                stringBuilder.append(str);
                stringBuilder.append("' was found");
                throw new AssertionError(stringBuilder.toString());
            }
        } else {
            str = str.substring(1);
            h.d(str, "(this as java.lang.String).substring(startIndex)");
            cVar = new a(mq(str));
        }
        return cVar;
    }

    /* renamed from: mt */
    public j.b mr(String str) {
        h.e(str, "internalName");
        return new j.b(str);
    }

    /* renamed from: b */
    public String toString(j jVar) {
        h.e(jVar, Param.TYPE);
        StringBuilder stringBuilder;
        if (jVar instanceof a) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(toString(((a) jVar).biy()));
            return stringBuilder.toString();
        } else if (jVar instanceof c) {
            JvmPrimitiveType biz = ((c) jVar).biz();
            if (biz != null) {
                String desc = biz.getDesc();
                if (desc != null) {
                    return desc;
                }
            }
            return "V";
        } else if (jVar instanceof j.b) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("L");
            stringBuilder.append(((j.b) jVar).getInternalName());
            stringBuilder.append(";");
            return stringBuilder.toString();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: biB */
    public j biA() {
        return mr("java/lang/Class");
    }
}
