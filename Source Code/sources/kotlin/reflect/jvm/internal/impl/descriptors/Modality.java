package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: Modality.kt */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final a Companion = null;

    /* compiled from: Modality.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final Modality n(boolean z, boolean z2) {
            if (z) {
                return Modality.ABSTRACT;
            }
            if (z2) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }

    static {
        Companion = new a();
    }
}
