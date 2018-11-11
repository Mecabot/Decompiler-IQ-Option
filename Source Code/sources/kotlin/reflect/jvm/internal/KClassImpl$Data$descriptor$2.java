package kotlin.reflect.jvm.internal;

import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.components.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.q;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "T", "", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$descriptor$2 extends Lambda implements a<d> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$descriptor$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aZi */
    public final d invoke() {
        d l;
        kotlin.reflect.jvm.internal.impl.name.a a = i.this.getClassId();
        j aZo = ((i.a) i.this.aYW().invoke()).aZo();
        if (a.isLocal()) {
            l = aZo.bas().l(a);
        } else {
            l = q.a(aZo.bar(), a);
        }
        if (l != null) {
            return l;
        }
        i.this.aZa();
        throw null;
    }
}
