package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.builtins.g;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.types.w;

/* compiled from: modifierChecks.kt */
public abstract class k implements b {
    private final String description;
    private final kotlin.jvm.a.b<g, w> eXd;
    private final String name;

    /* compiled from: modifierChecks.kt */
    public static final class a extends k {
        public static final a eXe = new a();

        private a() {
            super("Boolean", ReturnsCheck$ReturnsBoolean$1.eXf, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends k {
        public static final b eXg = new b();

        private b() {
            super("Int", ReturnsCheck$ReturnsInt$1.eXh, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends k {
        public static final c eXi = new c();

        private c() {
            super("Unit", ReturnsCheck$ReturnsUnit$1.eXj, null);
        }
    }

    private k(String str, kotlin.jvm.a.b<? super g, ? extends w> bVar) {
        this.name = str;
        this.eXd = bVar;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("must return ");
        stringBuilder.append(this.name);
        this.description = stringBuilder.toString();
    }

    public /* synthetic */ k(String str, kotlin.jvm.a.b bVar, f fVar) {
        this(str, bVar);
    }

    public String a(r rVar) {
        h.e(rVar, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.util.b.a.a(this, rVar);
    }

    public String getDescription() {
        return this.description;
    }

    public boolean n(r rVar) {
        h.e(rVar, "functionDescriptor");
        return h.E(rVar.bcQ(), (w) this.eXd.invoke(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.Q(rVar)));
    }
}
