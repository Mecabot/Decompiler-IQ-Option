package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.util.f.b;
import kotlin.reflect.jvm.internal.impl.util.l.a;
import kotlin.reflect.jvm.internal.impl.util.l.c;
import kotlin.reflect.jvm.internal.impl.util.l.d;

/* compiled from: modifierChecks.kt */
public final class i extends a {
    private static final List<d> eWl;
    public static final i eWm = new i();

    static {
        r0 = new d[18];
        f fVar = j.eWz;
        h.d(fVar, "GET");
        r0[0] = new d(fVar, new b[]{b.eWi, new a(1)}, null, 4, null);
        fVar = j.eWA;
        h.d(fVar, "SET");
        r0[1] = new d(fVar, new b[]{b.eWi, new a(2)}, (kotlin.jvm.a.b) OperatorChecks$checks$1.eWn);
        f fVar2 = j.eWr;
        h.d(fVar2, "GET_VALUE");
        r0[2] = new d(fVar2, new b[]{b.eWi, h.eWk, new a(2), e.eWg}, null, 4, null);
        f fVar3 = j.eWs;
        h.d(fVar3, "SET_VALUE");
        r0[3] = new d(fVar3, new b[]{b.eWi, h.eWk, new a(3), e.eWg}, null, 4, null);
        fVar2 = j.eWt;
        h.d(fVar2, "PROVIDE_DELEGATE");
        r0[4] = new d(fVar2, new b[]{b.eWi, h.eWk, new l.b(2), e.eWg}, null, 4, null);
        fVar3 = j.eWx;
        h.d(fVar3, "INVOKE");
        r0[5] = new d(fVar3, new b[]{b.eWi}, null, 4, null);
        fVar2 = j.eWw;
        h.d(fVar2, "CONTAINS");
        r0[6] = new d(fVar2, new b[]{b.eWi, d.eXl, h.eWk, k.a.eXe}, null, 4, null);
        fVar2 = j.eWy;
        h.d(fVar2, "ITERATOR");
        r0[7] = new d(fVar2, new b[]{b.eWi, c.eXk}, null, 4, null);
        fVar2 = j.eWB;
        h.d(fVar2, "NEXT");
        r0[8] = new d(fVar2, new b[]{b.eWi, c.eXk}, null, 4, null);
        fVar2 = j.eWC;
        h.d(fVar2, "HAS_NEXT");
        r0[9] = new d(fVar2, new b[]{b.eWi, c.eXk, k.a.eXe}, null, 4, null);
        fVar2 = j.eWR;
        h.d(fVar2, "RANGE_TO");
        r0[10] = new d(fVar2, new b[]{b.eWi, d.eXl, h.eWk}, null, 4, null);
        fVar3 = j.eWu;
        h.d(fVar3, "EQUALS");
        r0[11] = new d(fVar3, new b[]{f.a.eWh}, (kotlin.jvm.a.b) OperatorChecks$checks$2.eWo);
        fVar2 = j.eWv;
        h.d(fVar2, "COMPARE_TO");
        r0[12] = new d(fVar2, new b[]{b.eWi, k.b.eXg, d.eXl, h.eWk}, null, 4, null);
        r0[13] = new d((Collection) j.eXa, new b[]{b.eWi, d.eXl, h.eWk}, null, 4, null);
        r0[14] = new d((Collection) j.eWZ, new b[]{b.eWi, c.eXk}, null, 4, null);
        r0[15] = new d((Collection) m.listOf(j.eWG, j.eWH), new b[]{b.eWi}, (kotlin.jvm.a.b) OperatorChecks$checks$3.eWq);
        r0[16] = new d((Collection) j.eXb, new b[]{b.eWi, k.c.eXi, d.eXl, h.eWk}, null, 4, null);
        r0[17] = new d(j.eWD, new b[]{b.eWi, c.eXk}, null, 4, null);
        eWl = m.listOf(r0);
    }

    private i() {
    }

    public List<d> bzw() {
        return eWl;
    }
}
