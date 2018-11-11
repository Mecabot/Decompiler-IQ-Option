package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

/* compiled from: AbstractTypeConstructor.kt */
final class AbstractTypeConstructor$supertypes$3 extends Lambda implements b<a, l> {
    final /* synthetic */ c this$0;

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$2 */
    static final class AnonymousClass2 extends Lambda implements b<an, Collection<? extends w>> {
        final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

        AnonymousClass2(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
            this.this$0 = abstractTypeConstructor$supertypes$3;
            super(1);
        }

        /* renamed from: c */
        public final Collection<w> invoke(an anVar) {
            h.e(anVar, "it");
            return this.this$0.this$0.a(anVar, true);
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$3 */
    static final class AnonymousClass3 extends Lambda implements b<w, l> {
        final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

        AnonymousClass3(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
            this.this$0 = abstractTypeConstructor$supertypes$3;
            super(1);
        }

        public /* synthetic */ Object invoke(Object obj) {
            ay((w) obj);
            return l.etX;
        }

        public final void ay(w wVar) {
            h.e(wVar, "it");
            this.this$0.this$0.ax(wVar);
        }
    }

    AbstractTypeConstructor$supertypes$3(c cVar) {
        this.this$0 = cVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((a) obj);
        return l.etX;
    }

    public final void a(a aVar) {
        h.e(aVar, "supertypes");
        Collection a = this.this$0.bbZ().a(this.this$0, aVar.byL(), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(this), new AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(this));
        Collection collection = null;
        if (a.isEmpty()) {
            w bex = this.this$0.bex();
            List cr = bex != null ? l.cr(bex) : null;
            if (cr == null) {
                cr = m.emptyList();
            }
            a = cr;
        }
        this.this$0.bbZ().a(this.this$0, a, new AnonymousClass2(this), new AnonymousClass3(this));
        if (a instanceof List) {
            collection = a;
        }
        List list = (List) collection;
        if (list == null) {
            list = u.W(a);
        }
        aVar.cm(list);
    }
}
