package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.ap;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: TypeCheckerProcedureCallbacksImpl */
class n implements o {
    public boolean a(w wVar, ap apVar) {
        return false;
    }

    public boolean e(w wVar, w wVar2) {
        return false;
    }

    n() {
    }

    public boolean a(w wVar, w wVar2, TypeCheckingProcedure typeCheckingProcedure) {
        return typeCheckingProcedure.d(wVar, wVar2);
    }

    public boolean c(an anVar, an anVar2) {
        return anVar.equals(anVar2);
    }

    public boolean b(w wVar, w wVar2, TypeCheckingProcedure typeCheckingProcedure) {
        return typeCheckingProcedure.c(wVar, wVar2);
    }
}
