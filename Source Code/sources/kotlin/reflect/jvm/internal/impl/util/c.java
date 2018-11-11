package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.h;

/* compiled from: modifierChecks.kt */
public abstract class c {
    private final boolean ajK;

    /* compiled from: modifierChecks.kt */
    public static final class a extends c {
        public static final a eVX = new a();

        private a() {
            super(false, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends c {
        private final String error;

        public b(String str) {
            h.e(str, "error");
            super(false, null);
            this.error = str;
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends c {
        public static final c eVY = new c();

        private c() {
            super(true, null);
        }
    }

    private c(boolean z) {
        this.ajK = z;
    }

    public /* synthetic */ c(boolean z, f fVar) {
        this(z);
    }

    public final boolean isSuccess() {
        return this.ajK;
    }
}
