package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.an;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.ar;
import kotlin.reflect.jvm.internal.impl.types.as;
import kotlin.reflect.jvm.internal.impl.types.h;
import kotlin.reflect.jvm.internal.impl.types.u;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.z;

/* compiled from: CapturedTypeConstructor.kt */
public final class c {

    /* compiled from: CapturedTypeConstructor.kt */
    public static final class a extends h {
        final /* synthetic */ as eRk;
        final /* synthetic */ boolean eRl;

        a(as asVar, boolean z, as asVar2) {
            this.eRk = asVar;
            this.eRl = z;
            super(asVar2);
        }

        public boolean bwE() {
            return this.eRl;
        }

        public ap Z(w wVar) {
            kotlin.jvm.internal.h.e(wVar, "key");
            ap Z = super.Z(wVar);
            if (Z == null) {
                return null;
            }
            f bbW = wVar.bwA().bbW();
            if (!(bbW instanceof an)) {
                bbW = null;
            }
            return c.a(Z, (an) bbW);
        }
    }

    public static final w c(ap apVar) {
        kotlin.jvm.internal.h.e(apVar, "typeProjection");
        return new a(apVar, null, false, null, 14, null);
    }

    public static final boolean au(w wVar) {
        kotlin.jvm.internal.h.e(wVar, "$receiver");
        return wVar.bwA() instanceof b;
    }

    public static /* bridge */ /* synthetic */ as a(as asVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return a(asVar, z);
    }

    public static final as a(as asVar, boolean z) {
        kotlin.jvm.internal.h.e(asVar, "$receiver");
        if (!(asVar instanceof u)) {
            return new a(asVar, z, asVar);
        }
        u uVar = (u) asVar;
        an[] byZ = uVar.byZ();
        Iterable<Pair> c = i.c((Object[]) uVar.bza(), (Object[]) uVar.byZ());
        Collection arrayList = new ArrayList(n.e(c, 10));
        for (Pair pair : c) {
            arrayList.add(a((ap) pair.getFirst(), (an) pair.aXF()));
        }
        Object[] toArray = ((List) arrayList).toArray(new ap[0]);
        if (toArray != null) {
            return new u(byZ, (ap[]) toArray, z);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private static final ap a(ap apVar, an anVar) {
        if (anVar == null || apVar.bzf() == Variance.INVARIANT) {
            return apVar;
        }
        if (anVar.bdd() != apVar.bzf()) {
            return new ar(c(apVar));
        }
        ap arVar;
        if (apVar.bze()) {
            kotlin.reflect.jvm.internal.impl.storage.h hVar = LockBasedStorageManager.eUc;
            kotlin.jvm.internal.h.d(hVar, "LockBasedStorageManager.NO_LOCKS");
            arVar = new ar(new z(hVar, new CapturedTypeConstructorKt$createCapturedIfNeeded$1(apVar)));
        } else {
            arVar = new ar(apVar.bai());
        }
        return arVar;
    }
}
