package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.checker.b.a;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: KotlinTypeCheckerImpl */
public class c implements b {
    private final TypeCheckingProcedure eVs;

    public static b b(final a aVar) {
        return new c(new TypeCheckingProcedure(new n() {
            public boolean c(an anVar, an anVar2) {
                return anVar.equals(anVar2) || aVar.a(anVar, anVar2);
            }
        }));
    }

    protected c(TypeCheckingProcedure typeCheckingProcedure) {
        this.eVs = typeCheckingProcedure;
    }

    public boolean c(w wVar, w wVar2) {
        return this.eVs.c(wVar, wVar2);
    }

    public boolean d(w wVar, w wVar2) {
        return this.eVs.d(wVar, wVar2);
    }
}
