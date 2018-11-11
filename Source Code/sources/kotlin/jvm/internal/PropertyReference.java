package kotlin.jvm.internal;

import kotlin.reflect.j;

public abstract class PropertyReference extends CallableReference implements j {
    /* renamed from: aYe */
    protected j aXS() {
        return (j) super.aXS();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (!(Py().equals(propertyReference.Py()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && h.E(aXQ(), propertyReference.aXQ()))) {
                z = false;
            }
            return z;
        } else if (obj instanceof j) {
            return obj.equals(aXR());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((Py().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        PropertyReference aXR = aXR();
        if (aXR != this) {
            return aXR.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("property ");
        stringBuilder.append(getName());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}
