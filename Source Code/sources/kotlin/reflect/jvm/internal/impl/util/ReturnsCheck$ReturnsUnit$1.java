package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.types.ad;

/* compiled from: modifierChecks.kt */
final class ReturnsCheck$ReturnsUnit$1 extends Lambda implements b<g, ad> {
    public static final ReturnsCheck$ReturnsUnit$1 eXj = new ReturnsCheck$ReturnsUnit$1();

    ReturnsCheck$ReturnsUnit$1() {
        super(1);
    }

    /* renamed from: c */
    public final ad invoke(g gVar) {
        h.e(gVar, "$receiver");
        ad bbf = gVar.bbf();
        h.d(bbf, "unitType");
        return bbf;
    }
}
