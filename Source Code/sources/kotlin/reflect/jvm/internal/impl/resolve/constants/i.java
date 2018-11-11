package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.a;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.types.ad;
import kotlin.reflect.jvm.internal.impl.types.p;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: constantValues.kt */
public final class i extends f<Pair<? extends a, ? extends f>> {
    private final a eRo;
    private final f eRp;

    public i(a aVar, f fVar) {
        h.e(aVar, "enumClassId");
        h.e(fVar, "enumEntryName");
        super(j.D(aVar, fVar));
        this.eRo = aVar;
        this.eRp = fVar;
    }

    public final f bwF() {
        return this.eRp;
    }

    public w h(u uVar) {
        ad bdb;
        h.e(uVar, "module");
        d a = q.a(uVar, this.eRo);
        if (a != null) {
            if (!c.H(a)) {
                a = null;
            }
            if (a != null) {
                bdb = a.bdb();
                if (bdb != null) {
                    return bdb;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Containing class for error-class based enum entry ");
        stringBuilder.append(this.eRo);
        stringBuilder.append('.');
        stringBuilder.append(this.eRp);
        bdb = p.mU(stringBuilder.toString());
        h.d(bdb, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
        return bdb;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.eRo.btH());
        stringBuilder.append('.');
        stringBuilder.append(this.eRp);
        return stringBuilder.toString();
    }
}
