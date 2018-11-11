package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: methodSignatureMapping.kt */
public abstract class j {

    /* compiled from: methodSignatureMapping.kt */
    public static final class a extends j {
        private final j eJR;

        public a(j jVar) {
            h.e(jVar, "elementType");
            super();
            this.eJR = jVar;
        }

        public final j biy() {
            return this.eJR;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class b extends j {
        private final String eJS;

        public b(String str) {
            h.e(str, "internalName");
            super();
            this.eJS = str;
        }

        public final String getInternalName() {
            return this.eJS;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class c extends j {
        private final JvmPrimitiveType eJT;

        public c(JvmPrimitiveType jvmPrimitiveType) {
            super();
            this.eJT = jvmPrimitiveType;
        }

        public final JvmPrimitiveType biz() {
            return this.eJT;
        }
    }

    private j() {
    }

    public /* synthetic */ j(f fVar) {
        this();
    }

    public String toString() {
        return l.eJU.toString(this);
    }
}
