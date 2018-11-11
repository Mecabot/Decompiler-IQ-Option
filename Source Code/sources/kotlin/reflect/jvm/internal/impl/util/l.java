package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r;

/* compiled from: modifierChecks.kt */
public abstract class l implements b {
    private final String description;

    /* compiled from: modifierChecks.kt */
    public static final class a extends l {
        private final int n;

        public a(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have at least ");
            stringBuilder.append(i);
            stringBuilder.append(" value parameter");
            stringBuilder.append(i > 1 ? "s" : "");
            super(stringBuilder.toString(), null);
            this.n = i;
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return rVar.bcS().size() >= this.n;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends l {
        private final int n;

        public b(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("must have exactly ");
            stringBuilder.append(i);
            stringBuilder.append(" value parameters");
            super(stringBuilder.toString(), null);
            this.n = i;
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return rVar.bcS().size() == this.n;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends l {
        public static final c eXk = new c();

        private c() {
            super("must have no value parameters", null);
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return rVar.bcS().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class d extends l {
        public static final d eXl = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        public boolean n(r rVar) {
            h.e(rVar, "functionDescriptor");
            return rVar.bcS().size() == 1;
        }
    }

    private l(String str) {
        this.description = str;
    }

    public /* synthetic */ l(String str, f fVar) {
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
