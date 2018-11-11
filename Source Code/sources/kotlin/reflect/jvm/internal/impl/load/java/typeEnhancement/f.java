package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.h;

/* compiled from: signatureEnhancement.kt */
public final class f {
    private final NullabilityQualifier eIF;
    private final boolean eIG;

    public static /* bridge */ /* synthetic */ f a(f fVar, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = fVar.eIF;
        }
        if ((i & 2) != 0) {
            z = fVar.eIG;
        }
        return fVar.a(nullabilityQualifier, z);
    }

    public final f a(NullabilityQualifier nullabilityQualifier, boolean z) {
        h.e(nullabilityQualifier, "qualifier");
        return new f(nullabilityQualifier, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (h.E(this.eIF, fVar.eIF)) {
                if ((this.eIG == fVar.eIG ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        NullabilityQualifier nullabilityQualifier = this.eIF;
        int hashCode = (nullabilityQualifier != null ? nullabilityQualifier.hashCode() : 0) * 31;
        int i = this.eIG;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NullabilityQualifierWithMigrationStatus(qualifier=");
        stringBuilder.append(this.eIF);
        stringBuilder.append(", isForWarningOnly=");
        stringBuilder.append(this.eIG);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(NullabilityQualifier nullabilityQualifier, boolean z) {
        h.e(nullabilityQualifier, "qualifier");
        this.eIF = nullabilityQualifier;
        this.eIG = z;
    }

    public final NullabilityQualifier bhX() {
        return this.eIF;
    }

    public /* synthetic */ f(NullabilityQualifier nullabilityQualifier, boolean z, int i, f fVar) {
        if ((i & 2) != 0) {
            z = false;
        }
        this(nullabilityQualifier, z);
    }

    public final boolean bhY() {
        return this.eIG;
    }
}
