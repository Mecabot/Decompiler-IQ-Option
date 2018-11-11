package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.h;

/* compiled from: numbers.kt */
public final class f {
    private final int eXJ;
    private final String number;

    public final int bbt() {
        return this.eXJ;
    }

    public final String component1() {
        return this.number;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (h.E(this.number, fVar.number)) {
                if ((this.eXJ == fVar.eXJ ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.number;
        return ((str != null ? str.hashCode() : 0) * 31) + this.eXJ;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NumberWithRadix(number=");
        stringBuilder.append(this.number);
        stringBuilder.append(", radix=");
        stringBuilder.append(this.eXJ);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public f(String str, int i) {
        h.e(str, "number");
        this.number = str;
        this.eXJ = i;
    }
}
