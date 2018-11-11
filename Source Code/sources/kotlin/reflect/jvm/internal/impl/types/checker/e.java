package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ay;
import kotlin.reflect.jvm.internal.impl.types.b.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: NewCapturedType.kt */
public final class e implements an {
    private final ap eVx;
    private List<? extends ay> eVy;

    public f bbW() {
        return null;
    }

    public boolean bbY() {
        return false;
    }

    public e(ap apVar, List<? extends ay> list) {
        h.e(apVar, "projection");
        this.eVx = apVar;
        this.eVy = list;
    }

    public /* synthetic */ e(ap apVar, List list, int i, f fVar) {
        if ((i & 2) != 0) {
            list = (List) null;
        }
        this(apVar, list);
    }

    public final void cp(List<? extends ay> list) {
        h.e(list, "supertypes");
        Object obj = this.eVy == null ? 1 : null;
        if (m.etY && obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Already initialized! oldValue = ");
            stringBuilder.append(this.eVy);
            stringBuilder.append(", newValue = ");
            stringBuilder.append(list);
            throw new AssertionError(stringBuilder.toString());
        }
        this.eVy = list;
    }

    /* renamed from: byJ */
    public List<ay> beu() {
        List<ay> list = this.eVy;
        return list != null ? list : m.emptyList();
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.an> getParameters() {
        return m.emptyList();
    }

    public g bdy() {
        w bai = this.eVx.bai();
        h.d(bai, "projection.type");
        return a.bj(bai);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CapturedType(");
        stringBuilder.append(this.eVx);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
