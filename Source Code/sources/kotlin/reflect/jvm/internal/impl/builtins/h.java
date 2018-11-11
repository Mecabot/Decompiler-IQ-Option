package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.d;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.ah;
import kotlin.reflect.jvm.internal.impl.types.an;
import kotlin.reflect.jvm.internal.impl.types.x;

/* compiled from: ReflectionTypes.kt */
public final class h {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(h.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    public static final b ezx = new b();
    private final d ezo;
    private final a ezp = new a(1);
    private final a ezq = new a(1);
    private final a ezr = new a(2);
    private final a ezs = new a(3);
    private final a ezt = new a(1);
    private final a ezu = new a(2);
    private final a ezv = new a(3);
    private final w ezw;

    /* compiled from: ReflectionTypes.kt */
    private static final class a {
        private final int ezy;

        public a(int i) {
            this.ezy = i;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.d a(h hVar, j<?> jVar) {
            kotlin.jvm.internal.h.e(hVar, "types");
            kotlin.jvm.internal.h.e(jVar, "property");
            return hVar.W(u.capitalize(jVar.getName()), this.ezy);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final kotlin.reflect.jvm.internal.impl.types.w b(u uVar) {
            kotlin.jvm.internal.h.e(uVar, "module");
            kotlin.reflect.jvm.internal.impl.name.a aVar = g.exC.eyS;
            kotlin.jvm.internal.h.d(aVar, "KotlinBuiltIns.FQ_NAMES.kProperty");
            kotlin.reflect.jvm.internal.impl.descriptors.d a = q.a(uVar, aVar);
            if (a == null) {
                return null;
            }
            g bel = g.eBF.bel();
            an bby = a.bby();
            kotlin.jvm.internal.h.d(bby, "kPropertyClass.typeConstructor");
            List parameters = bby.getParameters();
            kotlin.jvm.internal.h.d(parameters, "kPropertyClass.typeConstructor.parameters");
            Object bY = u.bY(parameters);
            kotlin.jvm.internal.h.d(bY, "kPropertyClass.typeConstructor.parameters.single()");
            return x.a(bel, a, l.cr(new ah((kotlin.reflect.jvm.internal.impl.descriptors.an) bY)));
        }
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbl() {
        d dVar = this.ezo;
        j jVar = apP[0];
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) dVar.getValue();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.d bbm() {
        return this.ezp.a(this, apP[1]);
    }

    public h(u uVar, w wVar) {
        kotlin.jvm.internal.h.e(uVar, "module");
        kotlin.jvm.internal.h.e(wVar, "notFoundClasses");
        this.ezw = wVar;
        this.ezo = g.a(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(uVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d W(String str, int i) {
        f mD = f.mD(str);
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h bbl = bbl();
        kotlin.jvm.internal.h.d(mD, "name");
        kotlin.reflect.jvm.internal.impl.descriptors.f c = bbl.c(mD, NoLookupLocation.FROM_REFLECTION);
        if (!(c instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            c = null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) c;
        return dVar != null ? dVar : this.ezw.a(new kotlin.reflect.jvm.internal.impl.name.a(i.bbo(), mD), l.cr(Integer.valueOf(i)));
    }
}
