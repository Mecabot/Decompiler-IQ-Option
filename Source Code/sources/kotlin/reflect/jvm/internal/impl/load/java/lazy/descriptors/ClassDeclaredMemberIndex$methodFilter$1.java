package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.load.java.components.a;
import kotlin.reflect.jvm.internal.impl.load.java.structure.p;
import kotlin.reflect.jvm.internal.impl.load.java.structure.q;

/* compiled from: DeclaredMemberIndex.kt */
final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements b<q, Boolean> {
    final /* synthetic */ a this$0;

    ClassDeclaredMemberIndex$methodFilter$1(a aVar) {
        this.this$0 = aVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(b((q) obj));
    }

    public final boolean b(q qVar) {
        h.e(qVar, "m");
        return ((Boolean) this.this$0.eHl.invoke(qVar)).booleanValue() && !a.a((p) qVar);
    }
}
