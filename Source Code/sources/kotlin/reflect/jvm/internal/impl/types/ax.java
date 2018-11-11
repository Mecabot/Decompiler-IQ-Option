package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;

/* compiled from: ErrorType.kt */
public final class ax extends o {
    private final String eVq;

    public final String bzj() {
        return this.eVq;
    }

    public ax(String str, an anVar, h hVar, List<? extends ap> list, boolean z) {
        kotlin.jvm.internal.h.e(str, "presentableName");
        kotlin.jvm.internal.h.e(anVar, "constructor");
        kotlin.jvm.internal.h.e(hVar, "memberScope");
        kotlin.jvm.internal.h.e(list, "arguments");
        super(anVar, hVar, list, z);
        this.eVq = str;
    }

    /* renamed from: gQ */
    public ad gP(boolean z) {
        return new ax(this.eVq, bwA(), bbk(), bdF(), z);
    }
}
