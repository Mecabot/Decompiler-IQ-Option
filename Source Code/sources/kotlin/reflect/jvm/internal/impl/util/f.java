package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: modifierChecks.kt */
public abstract class f implements b {
    private final String description;

    /* compiled from: modifierChecks.kt */
    public static final class a extends f {
        public static final a eWh = new a();

        private a() {
            super("must be a member function", null);
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return rVar.bcP() != null;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends f {
        public static final b eWi = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return (rVar.bcP() == null && rVar.bcO() == null) ? false : true;
        }
    }

    private f(String str) {
        this.description = str;
    }

    public /* synthetic */ f(String str, f fVar) {
        this(str);
    }

    public String a(r rVar) {
        h.e(rVar, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.util.b.a.a(this, rVar);
    }

    public String getDescription() {
        return this.description;
    }
}
