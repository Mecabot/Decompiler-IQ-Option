package kotlin.reflect.jvm.internal.impl.types;

/* compiled from: TypeProjectionBase */
public abstract class aq implements ap {
    public String toString() {
        if (bze()) {
            return "*";
        }
        if (bzf() == Variance.INVARIANT) {
            return bai().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bzf());
        stringBuilder.append(" ");
        stringBuilder.append(bai());
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ap)) {
            return false;
        }
        ap apVar = (ap) obj;
        return bze() == apVar.bze() && bzf() == apVar.bzf() && bai().equals(apVar.bai());
    }

    public int hashCode() {
        return (bzf().hashCode() * 31) + (bze() ? 17 : bai().hashCode());
    }
}
