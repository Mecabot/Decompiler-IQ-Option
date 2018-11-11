package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.components.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ai;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.h;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.load.kotlin.o;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.c;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, aXE = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "invoke"})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$members$2 extends Lambda implements a<List<? extends g<?>>> {
    final /* synthetic */ a this$0;

    KPackageImpl$Data$members$2(a aVar) {
        this.this$0 = aVar;
        super(0);
    }

    /* renamed from: aYR */
    public final List<g<?>> invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : n.this.a(n.this.aZD(), MemberBelonginess.DECLARED)) {
            CallableMemberDescriptor aYM = ((g) next).aYM();
            if (aYM == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor");
            }
            c cVar = (c) aYM;
            k bbv = cVar.bbv();
            if (bbv == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor");
            }
            x xVar = (x) bbv;
            Object obj = null;
            if (!(xVar instanceof h)) {
                xVar = null;
            }
            h hVar = (h) xVar;
            ai bbR = hVar != null ? hVar.bbR() : null;
            if (!(bbR instanceof o)) {
                bbR = null;
            }
            o oVar = (o) bbR;
            n b = oVar != null ? oVar.b(cVar) : null;
            if (!(b instanceof e)) {
                b = null;
            }
            e eVar = (e) b;
            if (eVar != null) {
                obj = eVar.bao();
            }
            if (kotlin.jvm.internal.h.E(obj, n.this.aXV())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
