package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.storage.e;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
public final class d implements b {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private static final kotlin.reflect.jvm.internal.impl.name.b eAj = g.exp;
    private static final f eAk = g.exC.exK.btN();
    private static final kotlin.reflect.jvm.internal.impl.name.a eAl = kotlin.reflect.jvm.internal.impl.name.a.t(g.exC.exK.btP());
    public static final a eAm = new a();
    private final e eAg;
    private final u eAh;
    private final kotlin.jvm.a.b<u, k> eAi;

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final kotlin.reflect.jvm.internal.impl.name.a bcq() {
            return d.eAl;
        }
    }

    private final h bcm() {
        return (h) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eAg, (Object) this, apP[0]);
    }

    public d(kotlin.reflect.jvm.internal.impl.storage.h hVar, u uVar, kotlin.jvm.a.b<? super u, ? extends k> bVar) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        kotlin.jvm.internal.h.e(uVar, "moduleDescriptor");
        kotlin.jvm.internal.h.e(bVar, "computeContainingDeclaration");
        this.eAh = uVar;
        this.eAi = bVar;
        this.eAg = hVar.i(new JvmBuiltInClassDescriptorFactory$cloneable$2(this, hVar));
    }

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.storage.h hVar, u uVar, kotlin.jvm.a.b bVar, int i, f fVar) {
        if ((i & 4) != 0) {
            bVar = JvmBuiltInClassDescriptorFactory$1.eAn;
        }
        this(hVar, uVar, bVar);
    }

    public boolean a(kotlin.reflect.jvm.internal.impl.name.b bVar, f fVar) {
        kotlin.jvm.internal.h.e(bVar, "packageFqName");
        kotlin.jvm.internal.h.e(fVar, "name");
        return kotlin.jvm.internal.h.E(fVar, eAk) && kotlin.jvm.internal.h.E(bVar, eAj);
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.d e(kotlin.reflect.jvm.internal.impl.name.a aVar) {
        kotlin.jvm.internal.h.e(aVar, "classId");
        return kotlin.jvm.internal.h.E(aVar, eAl) ? bcm() : null;
    }

    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> e(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        kotlin.jvm.internal.h.e(bVar, "packageFqName");
        if (kotlin.jvm.internal.h.E(bVar, eAj)) {
            return ai.cu(bcm());
        }
        return aj.emptySet();
    }
}
