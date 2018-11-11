package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.renderer.f;

/* compiled from: TypeWithEnhancement.kt */
public final class s extends q implements av {
    private final q eUR;
    private final w eUS;

    /* renamed from: byW */
    public q byX() {
        return this.eUR;
    }

    public w byY() {
        return this.eUS;
    }

    public s(q qVar, w wVar) {
        h.e(qVar, b.ORIGIN);
        h.e(wVar, "enhancement");
        super(qVar.byT(), qVar.byU());
        this.eUR = qVar;
        this.eUS = wVar;
    }

    public ay f(g gVar) {
        h.e(gVar, "newAnnotations");
        return aw.b(byX().f(gVar), byY());
    }

    public ay gP(boolean z) {
        return aw.b(byX().gP(z), byY().bzc().gP(z));
    }

    public String a(kotlin.reflect.jvm.internal.impl.renderer.b bVar, f fVar) {
        h.e(bVar, "renderer");
        h.e(fVar, "options");
        if (fVar.bvM()) {
            return bVar.b(byY());
        }
        return byX().a(bVar, fVar);
    }

    public ad bhi() {
        return byX().bhi();
    }
}
