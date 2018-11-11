package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.f;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.m;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
public final class g implements m {
    public static final g eJI = new g();

    private g() {
    }

    public w a(Type type, String str, ad adVar, ad adVar2) {
        h.e(type, "proto");
        h.e(str, "flexibleId");
        h.e(adVar, "lowerBound");
        h.e(adVar2, "upperBound");
        if ((h.E(str, "kotlin.jvm.PlatformType") ^ 1) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error java flexible type with id: ");
            stringBuilder.append(str);
            stringBuilder.append(". (");
            stringBuilder.append(adVar);
            stringBuilder.append("..");
            stringBuilder.append(adVar2);
            stringBuilder.append(')');
            ad mU = p.mU(stringBuilder.toString());
            h.d(mU, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            return mU;
        } else if (type.c(JvmProtoBuf.eMo)) {
            return new f(adVar, adVar2);
        } else {
            return x.a(adVar, adVar2);
        }
    }
}
