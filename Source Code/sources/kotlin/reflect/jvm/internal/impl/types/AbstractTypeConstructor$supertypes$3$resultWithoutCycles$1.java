package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements b<an, Collection<? extends w>> {
    final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
        this.this$0 = abstractTypeConstructor$supertypes$3;
        super(1);
    }

    /* renamed from: c */
    public final Collection<w> invoke(an anVar) {
        h.e(anVar, "it");
        return this.this$0.this$0.a(anVar, false);
    }
}
