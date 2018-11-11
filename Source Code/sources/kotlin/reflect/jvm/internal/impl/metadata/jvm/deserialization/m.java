package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.n;

/* compiled from: ModuleMapping.kt */
public final class m {
    private final LinkedHashMap<String, String> eMX = new LinkedHashMap();
    private final Set<String> eMY = new LinkedHashSet();
    private final String eMZ;

    public m(String str) {
        h.e(str, "packageFqName");
        this.eMZ = str;
    }

    public final Set<String> btF() {
        Set<String> keySet = this.eMX.keySet();
        h.d(keySet, "packageParts.keys");
        return keySet;
    }

    public final void bh(String str, String str2) {
        h.e(str, "partInternalName");
        this.eMX.put(str, str2);
    }

    public final void mz(String str) {
        h.e(str, "shortName");
        Set set = this.eMY;
        if (set == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
        }
        n.cz(set).add(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (h.E(mVar.eMZ, this.eMZ) && h.E(mVar.eMX, this.eMX) && h.E(mVar.eMY, this.eMY)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.eMZ.hashCode() * 31) + this.eMX.hashCode()) * 31) + this.eMY.hashCode();
    }

    public String toString() {
        return ak.a(btF(), this.eMY).toString();
    }
}
