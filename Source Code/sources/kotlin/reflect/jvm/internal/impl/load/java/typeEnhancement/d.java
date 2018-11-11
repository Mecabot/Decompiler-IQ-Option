package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* compiled from: typeQualifiers.kt */
public final class d {
    private static final d eIC = new d(null, null, false, false, 8, null);
    public static final a eID = new a();
    private final boolean eIA;
    private final boolean eIB;
    private final NullabilityQualifier eIy;
    private final MutabilityQualifier eIz;

    /* compiled from: typeQualifiers.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final d bhV() {
            return d.eIC;
        }
    }

    public d(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.eIy = nullabilityQualifier;
        this.eIz = mutabilityQualifier;
        this.eIA = z;
        this.eIB = z2;
    }

    public final NullabilityQualifier bhQ() {
        return this.eIy;
    }

    public final MutabilityQualifier bhR() {
        return this.eIz;
    }

    public final boolean bhS() {
        return this.eIA;
    }

    public /* synthetic */ d(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, f fVar) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        this(nullabilityQualifier, mutabilityQualifier, z, z2);
    }

    public final boolean bhT() {
        return this.eIB;
    }
}
