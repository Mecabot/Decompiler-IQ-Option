package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j.b.c;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.h;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.java.structure.g;
import kotlin.reflect.jvm.internal.impl.load.kotlin.n;
import kotlin.reflect.jvm.internal.impl.name.a;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$classes$1 extends Lambda implements b<a, d> {
    final /* synthetic */ h $c;
    final /* synthetic */ j this$0;

    LazyJavaPackageScope$classes$1(j jVar, h hVar) {
        this.this$0 = jVar;
        this.$c = hVar;
        super(1);
    }

    /* renamed from: a */
    public final d invoke(a aVar) {
        n a;
        kotlin.jvm.internal.h.e(aVar, "request");
        a aVar2 = new a(this.this$0.bgJ().bdD(), aVar.bdc());
        if (aVar.bgP() != null) {
            a = this.$c.bgq().bfW().a(aVar.bgP());
        } else {
            a = this.$c.bgq().bfW().b(aVar2);
        }
        d dVar = null;
        a classId = a != null ? a.getClassId() : null;
        if (classId != null && (classId.btJ() || classId.isLocal())) {
            return null;
        }
        b a2 = this.this$0.a(a);
        if (a2 instanceof b.a) {
            dVar = ((b.a) a2).aYX();
        } else if (!(a2 instanceof c)) {
            if (a2 instanceof b.b) {
                g bgP = aVar.bgP();
                if (bgP == null) {
                    bgP = this.$c.bgq().bfV().a(aVar2);
                }
                g gVar = bgP;
                if ((gVar != null ? gVar.bhs() : null) == LightClassOriginKind.BINARY) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Couldn't find kotlin binary class for light class created by kotlin binary file\n");
                    stringBuilder.append("JavaClass: ");
                    stringBuilder.append(gVar);
                    stringBuilder.append(10);
                    stringBuilder.append("ClassId: ");
                    stringBuilder.append(aVar2);
                    stringBuilder.append(10);
                    stringBuilder.append("findKotlinClass(JavaClass) = ");
                    stringBuilder.append(this.$c.bgq().bfW().a(gVar));
                    stringBuilder.append(10);
                    stringBuilder.append("findKotlinClass(ClassId) = ");
                    stringBuilder.append(this.$c.bgq().bfW().b(aVar2));
                    stringBuilder.append(10);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                f fVar;
                kotlin.reflect.jvm.internal.impl.name.b bdD = gVar != null ? gVar.bdD() : null;
                if (bdD == null || bdD.isRoot() || (kotlin.jvm.internal.h.E(bdD.btM(), this.this$0.bgJ().bdD()) ^ 1) != 0) {
                    fVar = null;
                } else {
                    f fVar2 = new f(this.$c, this.this$0.bgJ(), gVar, null, 8, null);
                    this.$c.bgq().bgj().a(fVar2);
                }
                dVar = fVar;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return dVar;
    }
}
