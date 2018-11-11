package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.m;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.a.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a.b;
import kotlin.reflect.jvm.internal.impl.descriptors.a.c;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.storage.h;

/* compiled from: JvmBuiltIns.kt */
public final class e extends g {
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(e.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    private u eAo;
    private boolean eAp;
    private final kotlin.reflect.jvm.internal.impl.storage.e eAq;

    public final JvmBuiltInsSettings bcs() {
        return (JvmBuiltInsSettings) kotlin.reflect.jvm.internal.impl.storage.g.a(this.eAq, (Object) this, apP[0]);
    }

    public /* synthetic */ e(h hVar, boolean z, int i, f fVar) {
        if ((i & 2) != 0) {
            z = true;
        }
        this(hVar, z);
    }

    public e(h hVar, boolean z) {
        kotlin.jvm.internal.h.e(hVar, "storageManager");
        super(hVar);
        this.eAp = true;
        this.eAq = hVar.i(new JvmBuiltIns$settings$2(this, hVar));
        if (z) {
            baE();
        }
    }

    public final void a(u uVar, boolean z) {
        kotlin.jvm.internal.h.e(uVar, "moduleDescriptor");
        Object obj = this.eAo == null ? 1 : null;
        if (m.etY && obj == null) {
            throw new AssertionError("JvmBuiltins repeated initialization");
        }
        this.eAo = uVar;
        this.eAp = z;
    }

    protected c baG() {
        return bcs();
    }

    protected a baF() {
        return bcs();
    }

    /* renamed from: bct */
    protected List<b> baH() {
        Iterable baH = super.baH();
        kotlin.jvm.internal.h.d(baH, "super.getClassDescriptorFactories()");
        h baI = baI();
        kotlin.jvm.internal.h.d(baI, "storageManager");
        kotlin.reflect.jvm.internal.impl.descriptors.impl.u baJ = baJ();
        kotlin.jvm.internal.h.d(baJ, "builtInsModule");
        return u.e(baH, (Object) new d(baI, baJ, null, 4, null));
    }
}
