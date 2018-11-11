package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;

/* compiled from: predefinedEnhancementInfo.kt */
public final class h {
    private final o eIL;
    private final List<o> eIM;

    public h() {
        this(null, null, 3, null);
    }

    public h(o oVar, List<o> list) {
        kotlin.jvm.internal.h.e(list, "parametersInfo");
        this.eIL = oVar;
        this.eIM = list;
    }

    public /* synthetic */ h(o oVar, List list, int i, f fVar) {
        if ((i & 1) != 0) {
            oVar = (o) null;
        }
        if ((i & 2) != 0) {
            list = m.emptyList();
        }
        this(oVar, list);
    }

    public final o bid() {
        return this.eIL;
    }

    public final List<o> bie() {
        return this.eIM;
    }
}
