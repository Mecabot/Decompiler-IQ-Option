package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: ConstantValueFactory.kt */
public final class g {
    public static final g eRn = new g();

    private g() {
    }

    public final b a(List<? extends f<?>> list, w wVar) {
        h.e(list, b.VALUE);
        h.e(wVar, Param.TYPE);
        return new b(list, new ConstantValueFactory$createArrayValue$1(wVar));
    }

    public final f<?> db(Object obj) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new r(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new l(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new p(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new k(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new h(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new s((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(i.ab((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return a(i.a((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return a(i.v((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return a(i.h((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return a(i.b((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return a(i.g((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(i.b((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(i.b((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        return obj == null ? new q() : null;
    }

    private final b a(List<?> list, PrimitiveType primitiveType) {
        Collection arrayList = new ArrayList();
        for (Object db : u.W(list)) {
            f db2 = db(db);
            if (db2 != null) {
                arrayList.add(db2);
            }
        }
        return new b((List) arrayList, new ConstantValueFactory$createArrayValue$3(primitiveType));
    }
}
