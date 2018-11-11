package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.resolve.c;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001\"\b\b\u0000\u0010\u0005*\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KClassImpl;", "", "kotlin.jvm.PlatformType", "T", "invoke"})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$nestedClasses$2 extends Lambda implements a<List<? extends i<? extends Object>>> {
    final /* synthetic */ i.a this$0;

    KClassImpl$Data$nestedClasses$2(i.a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<i<? extends Object>> invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : j.a.a(this.this$0.aYX().bdg(), null, null, 3, null)) {
            if (!c.G((k) next)) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (k kVar : (List) arrayList) {
            if (kVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            Class a = ae.a((d) kVar);
            Object iVar = a != null ? new i(a) : null;
            if (iVar != null) {
                arrayList2.add(iVar);
            }
        }
        return (List) arrayList2;
    }
}
