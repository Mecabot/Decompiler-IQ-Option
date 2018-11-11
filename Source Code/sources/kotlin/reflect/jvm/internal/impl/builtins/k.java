package kotlin.reflect.jvm.internal.impl.builtins;

import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.au;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: UnsignedType.kt */
public final class k {
    private static final Set<f> ezE;
    public static final k ezF = new k();

    static {
        UnsignedType[] values = UnsignedType.values();
        Collection arrayList = new ArrayList(values.length);
        for (UnsignedType typeName : values) {
            arrayList.add(typeName.getTypeName());
        }
        ezE = u.Y((List) arrayList);
    }

    private k() {
    }

    public final boolean I(w wVar) {
        h.e(wVar, Param.TYPE);
        if (au.aR(wVar)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f bbW = wVar.bwA().bbW();
        if (bbW == null) {
            return false;
        }
        h.d(bbW, "descriptor");
        return g(bbW);
    }

    public final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        h.e(kVar, "descriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.k bbv = kVar.bbv();
        return (bbv instanceof x) && h.E(((x) bbv).bdD(), g.exp) && ezE.contains(kVar.bdc());
    }
}
